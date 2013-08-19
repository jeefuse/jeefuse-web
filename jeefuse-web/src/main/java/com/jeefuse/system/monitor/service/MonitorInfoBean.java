package com.jeefuse.system.monitor.service;

import com.jeefuse.base.utils.common.FormatUtil;

/**
 * 获得CPU使用率,系统内存,虚拟机内存等情况.
 * 
 * @author yonclv
 */
public class MonitorInfoBean {
	/** 可使用内存. */
	private long totalMemory;

	/** 剩余内存. */
	private long freeMemory;

	/** 最大可使用内存. */
	private long maxMemory;

	/** 总的物理内存. */
	private long totalPhysicalMemorySize;

	/** 剩余的物理内存. */
	private long freePhysicalMemorySize;

	/** 已使用的物理内存. */
	private long usedPhysicalMemorySize;

	/** 线程总数. */
	private int totalThread;

	/** cpu使用率. */
	private double cpuRatio;

	private long freeSwapSpaceSize;

	private long CommittedVirtualMemorySize;

	private Double systemLoadAverage;

	private long processCpuTime;

	public long getTotalMemory() {
		return totalMemory;
	}

	public String getTotalMemoryFormat() {
		return FormatUtil.formatSize(totalMemory);
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public long getFreeMemory() {
		return freeMemory;
	}

	public String getFreeMemoryFormat() {
		return FormatUtil.formatSize(freeMemory);
	}

	public void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

	public long getMaxMemory() {
		return maxMemory;
	}

	public String getMaxMemoryFormat() {
		return FormatUtil.formatSize(maxMemory);
	}

	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}

	public long getTotalPhysicalMemorySize() {
		return totalPhysicalMemorySize;
	}

	public String getTotalPhysicalMemorySizeFormat() {
		return FormatUtil.formatSize(totalPhysicalMemorySize);
	}

	public void setTotalPhysicalMemorySize(long totalPhysicalMemorySize) {
		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
	}

	public long getFreePhysicalMemorySize() {
		return freePhysicalMemorySize;
	}

	public String getFreePhysicalMemorySizeFormat() {
		return FormatUtil.formatSize(freePhysicalMemorySize);
	}

	public void setFreePhysicalMemorySize(long freePhysicalMemorySize) {
		this.freePhysicalMemorySize = freePhysicalMemorySize;
	}

	public int getTotalThread() {
		return totalThread;
	}

	public void setTotalThread(int totalThread) {
		this.totalThread = totalThread;
	}

	public double getCpuRatio() {
		return cpuRatio;
	}

	public void setCpuRatio(double cpuRatio) {
		this.cpuRatio = cpuRatio;
	}

	public long getUsedPhysicalMemorySize() {
		return usedPhysicalMemorySize;
	}

	public String getUsedPhysicalMemorySizeFormat() {
		return FormatUtil.formatSize(usedPhysicalMemorySize);
	}

	public void setUsedPhysicalMemorySize(long usedPhysicalMemorySize) {
		this.usedPhysicalMemorySize = usedPhysicalMemorySize;
	}

	public long getFreeSwapSpaceSize() {
		return freeSwapSpaceSize;
	}

	public String getFreeSwapSpaceSizeFormat() {
		return FormatUtil.formatSize(freeSwapSpaceSize);
	}

	public void setFreeSwapSpaceSize(long freeSwapSpaceSize) {
		this.freeSwapSpaceSize = freeSwapSpaceSize;
	}

	public long getCommittedVirtualMemorySize() {
		return CommittedVirtualMemorySize;
	}

	public String getCommittedVirtualMemorySizeFormat() {
		return FormatUtil.formatSize(CommittedVirtualMemorySize);
	}

	public void setCommittedVirtualMemorySize(long committedVirtualMemorySize) {
		CommittedVirtualMemorySize = committedVirtualMemorySize;
	}

	public Double getSystemLoadAverage() {
		return systemLoadAverage;
	}

	public void setSystemLoadAverage(Double systemLoadAverage) {
		this.systemLoadAverage = systemLoadAverage;
	}

	public long getProcessCpuTime() {
		return processCpuTime;
	}

	public void setProcessCpuTime(long processCpuTime) {
		this.processCpuTime = processCpuTime;
	}

}
