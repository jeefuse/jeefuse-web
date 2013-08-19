package com.jeefuse.system.monitor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.utils.common.FormatUtil;
import com.sun.management.OperatingSystemMXBean;

public class MonitorServiceImpl implements MonitorService {
	static protected Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);
	private static final int CPUTIME = 30;

	private static final int PERCENT = 100;

	private static final int FAULTLENGTH = 10;

	private static String linuxVersion = null;

	/**
	 * 获得当前的监控对象.
	 * 
	 * @return 返回构造好的监控对象
	 * @throws Exception
	 * @author GuoHuang
	 */
	public MonitorInfoBean getMonitorInfo() throws Exception {

		// 最大可使用内存
		long maxMemory = Runtime.getRuntime().maxMemory();
		// 可使用内存
		long totalMemory = Runtime.getRuntime().totalMemory();
		// 剩余内存
		long freeMemory = Runtime.getRuntime().freeMemory();

		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

		// 总的物理内存
		long totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
		// 剩余的物理内存
		long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
		// 已使用的物理内存
		long usedPhysicalMemorySize = (totalPhysicalMemorySize - freePhysicalMemorySize);
		// 交换空间
		long freeSwapSpaceSize = osmxb.getFreeSwapSpaceSize();
		long committedVirtualMemorySize = osmxb.getCommittedVirtualMemorySize();
		Double systemLoadAverage = osmxb.getSystemLoadAverage();
		long processCpuTime = osmxb.getProcessCpuTime();

		// 获得线程总数
		ThreadGroup parentThread;
		for (parentThread = Thread.currentThread().getThreadGroup(); parentThread.getParent() != null; parentThread = parentThread
				.getParent()) {
			;
		}
		int totalThread = parentThread.activeCount();

		// cpu 速率
		// double cpuRatio = 0;
		// if (osName.toLowerCase().startsWith("windows")) {
		// cpuRatio = this.getCpuRatioForWindows();
		// } else {
		// cpuRatio = this.getCpuRateForLinux();
		// }

		// 构造返回对象
		MonitorInfoBean infoBean = new MonitorInfoBean();
		// jvm内存
		infoBean.setMaxMemory(maxMemory);
		infoBean.setTotalMemory(totalMemory);
		infoBean.setFreeMemory(freeMemory);
		// 物理内存
		infoBean.setTotalPhysicalMemorySize(totalPhysicalMemorySize);
		infoBean.setFreePhysicalMemorySize(freePhysicalMemorySize);
		infoBean.setUsedPhysicalMemorySize(usedPhysicalMemorySize);
		infoBean.setFreeSwapSpaceSize(freeSwapSpaceSize);
		infoBean.setCommittedVirtualMemorySize(committedVirtualMemorySize);
		infoBean.setProcessCpuTime(processCpuTime);
		infoBean.setSystemLoadAverage(systemLoadAverage);
		infoBean.setTotalThread(totalThread);
		// infoBean.setCpuRatio(cpuRatio);
		return infoBean;
	}

	private double getCpuRateForLinux() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader brStat = null;
		StringTokenizer tokenStat = null;
		try {
			System.out.println("Get usage rate of CUP , linux version: " + linuxVersion);

			Process process = Runtime.getRuntime().exec("top -b -n 1");
			is = process.getInputStream();
			isr = new InputStreamReader(is);
			brStat = new BufferedReader(isr);

			if (linuxVersion.equals("2.4")) {
				brStat.readLine();
				brStat.readLine();
				brStat.readLine();
				brStat.readLine();

				tokenStat = new StringTokenizer(brStat.readLine());
				tokenStat.nextToken();
				tokenStat.nextToken();
				String user = tokenStat.nextToken();
				tokenStat.nextToken();
				String system = tokenStat.nextToken();
				tokenStat.nextToken();
				String nice = tokenStat.nextToken();
				user = user.substring(0, user.indexOf("%"));
				system = system.substring(0, system.indexOf("%"));
				nice = nice.substring(0, nice.indexOf("%"));

				float userUsage = new Float(user).floatValue();
				float systemUsage = new Float(system).floatValue();
				float niceUsage = new Float(nice).floatValue();

				return (userUsage + systemUsage + niceUsage) / 100;
			} else {
				brStat.readLine();
				brStat.readLine();

				tokenStat = new StringTokenizer(brStat.readLine());
				tokenStat.nextToken();
				tokenStat.nextToken();
				tokenStat.nextToken();
				tokenStat.nextToken();
				tokenStat.nextToken();
				tokenStat.nextToken();
				tokenStat.nextToken();
				String cpuUsage = tokenStat.nextToken();

				Float usage = new Float(cpuUsage.substring(0, cpuUsage.indexOf("%")));

				return (1 - usage.floatValue() / 100);
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			freeResource(is, isr, brStat);
			return 1;
		} finally {
			freeResource(is, isr, brStat);
		}

	}

	private void freeResource(InputStream is, InputStreamReader isr, BufferedReader br) {
		try {
			if (is != null) {
				is.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		} catch (IOException ioe) {
			logger.error(ioe.getMessage(), ioe);
		}
	}

	/**
	 * 获得CPU使用率.
	 * 
	 * @return 返回cpu使用率
	 * @author GuoHuang
	 */
	private double getCpuRatioForWindows() {
		try {
			String procCmd = System.getenv("windir")
					+ "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
			// 取进程信息
			long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));
			Thread.sleep(CPUTIME);
			long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
			if (c0 != null && c1 != null) {
				long idletime = c1[0] - c0[0];
				long busytime = c1[1] - c0[1];
				return Double.valueOf(PERCENT * (busytime) / (busytime + idletime)).doubleValue();
			} else
				return 0.0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}

	/**
	 * 
	 * 读取CPU信息.
	 * 
	 * @param proc
	 * @return
	 * @author GuoHuang
	 */
	private long[] readCpu(final Process proc) {
		long[] retn = new long[2];
		try {
			proc.getOutputStream().close();
			InputStreamReader ir = new InputStreamReader(proc.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line = input.readLine();
			if (line == null || line.length() < FAULTLENGTH)
				return null;
			int capidx = line.indexOf("Caption");
			int cmdidx = line.indexOf("CommandLine");
			int rocidx = line.indexOf("ReadOperationCount");
			int umtidx = line.indexOf("UserModeTime");
			int kmtidx = line.indexOf("KernelModeTime");
			int wocidx = line.indexOf("WriteOperationCount");
			long idletime = 0;
			long kneltime = 0;
			long usertime = 0;
			while ((line = input.readLine()) != null) {
				if (line.length() < wocidx) {
					continue;
				}
				// 字段出现顺序：Caption,CommandLine,KernelModeTime,ReadOperationCount,
				// ThreadCount,UserModeTime,WriteOperation
				String caption = Bytes.substring(line, capidx, cmdidx - 1).trim();
				String cmd = Bytes.substring(line, cmdidx, kmtidx - 1).trim();
				if (cmd.indexOf("wmic.exe") >= 0) {
					continue;
				}
				if (caption.equals("System Idle Process") || caption.equals("System")) {
					idletime += getValue(Bytes.substring(line, kmtidx, rocidx - 1).trim());
					idletime += getValue(Bytes.substring(line, umtidx, wocidx - 1).trim());
					continue;
				}

				kneltime += getValue(Bytes.substring(line, kmtidx, rocidx - 1).trim());
				usertime += getValue(Bytes.substring(line, umtidx, wocidx - 1).trim());
			}
			retn[0] = idletime;
			retn[1] = kneltime + usertime;
			return retn;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				proc.getInputStream().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private long getValue(String count) {
		if (StringUtils.isBlank(count))
			return 0;
		return Long.valueOf(count);
	}

	/**
	 * 测试方法.
	 * 
	 * @param args
	 * @throws Exception
	 * @author GuoHuang
	 */
	public static void main(String[] args) throws Exception {
		MonitorService service = new MonitorServiceImpl();
		MonitorInfoBean monitorInfo = service.getMonitorInfo();
		System.out.println("JVM最大可使用内存:" + monitorInfo.getMaxMemoryFormat());
		System.out.println("JVM所占用内存:" + monitorInfo.getTotalMemoryFormat());
		System.out.println("JVM剩余内存:" + monitorInfo.getFreeMemoryFormat());
		System.out.println("系统物理内存总计:" + monitorInfo.getTotalPhysicalMemorySizeFormat());
		System.out.println("系统已使用物理内存总计:" + monitorInfo.getUsedPhysicalMemorySizeFormat());
		System.out.println("系统可用物理内存总计:" + monitorInfo.getFreePhysicalMemorySizeFormat());
		System.out.println("系统物理交换空间总计:" + monitorInfo.getFreeSwapSpaceSizeFormat());
		System.out.println("提交的虚拟内存大小:" + monitorInfo.getCommittedVirtualMemorySizeFormat());
		System.out.println("CPU处理时间:" + FormatUtil.formatTime(monitorInfo.getProcessCpuTime()));
		System.out.println("系统平均负载:" + monitorInfo.getSystemLoadAverage());
		System.out.println("线程总数:" + monitorInfo.getTotalThread());
		System.out.println("cpu占有率:" + monitorInfo.getCpuRatio());

	}

}
