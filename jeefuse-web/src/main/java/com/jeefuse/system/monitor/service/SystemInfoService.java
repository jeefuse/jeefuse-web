package com.jeefuse.system.monitor.service;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SystemInfoService {

	public static Properties getSystemProps() {
		Properties props = System.getProperties();
		return props;
	}
	
	public static Set<Entry<Object, Object>> getPropertiesSet() {
		Properties props = getSystemProps();
		return props.entrySet();
	}

	public static SystemInfo getSystemInfo() {
		SystemInfo systemInfo = new SystemInfo();
		Properties props = getSystemProps();
		String osName = props.getProperty("os.name"); // 操作系统名称
		systemInfo.setOsName(osName);
		String osArch = props.getProperty("os.arch"); // 操作系统构架
		systemInfo.setOsArch(osArch);
		String osVersion = props.getProperty("os.version"); // 操作系统版本
		systemInfo.setOsVersion(osVersion);
		String javaVersion = props.getProperty("java.version");// Java 运行时环境版本
		systemInfo.setJavaVersion(javaVersion);
		String javaVendor = props.getProperty("java.vendor");//Java 运行时环境供应商
		systemInfo.setJavaVendor(javaVendor);
		String javaVendorUrl = props.getProperty("java.vendor.url");// 	Java 供应商的 URL
		systemInfo.setJavaVendorUrl(javaVendorUrl);
		String javaHome = props.getProperty("java.home");// 	Java 安装目录
		systemInfo.setJavaHome(javaHome);
		String javaVmSpecificationVersion = props.getProperty("java.vm.specification.version");// 	Java 虚拟机规范版本
		systemInfo.setJavaVmSpecificationVersion(javaVmSpecificationVersion);
		String javaVmSpecificationVendor = props.getProperty("java.vm.specification.vendor");// 	Java 虚拟机规范供应商
		systemInfo.setJavaVmSpecificationVendor(javaVmSpecificationVendor);
		String javaVmSpecificatioName = props.getProperty("java.vm.specification.name");// 	Java 虚拟机规范名称
		systemInfo.setJavaVmSpecificatioName(javaVmSpecificatioName);
		String javaVmVersion = props.getProperty("java.vm.version");// 	Java 虚拟机实现版本
		systemInfo.setJavaVmVersion(javaVmVersion);
		String javaVmVendor = props.getProperty("java.vm.vendor");// 	Java 虚拟机实现供应商
		systemInfo.setJavaVmVendor(javaVmVendor);
		String javaVmName = props.getProperty("java.vm.name");// 	Java 虚拟机实现名称
		systemInfo.setJavaVmName(javaVmName);
		String javaSpecificationVersion = props.getProperty("java.specification.version");// 	Java 运行时环境规范版本
		systemInfo.setJavaSpecificationVersion(javaSpecificationVersion);
		String javaSpecificationVendor = props.getProperty("java.specification.vendor");// 	Java 运行时环境规范供应商
		systemInfo.setJavaSpecificationVendor(javaSpecificationVendor);
		String javaSpecificationName = props.getProperty("java.specification.name");// 	Java 运行时环境规范名称
		systemInfo.setJavaSpecificationName(javaSpecificationName);
		String javaClassVersion = props.getProperty("java.class.version");// 	Java 类格式版本号
		systemInfo.setJavaClassVersion(javaClassVersion);
		String javaClassPath = props.getProperty("java.class.path");// 	Java 类路径
		systemInfo.setJavaClassPath(javaClassPath);
		String javaLibraryPath = props.getProperty("java.library.path");// 	加载库时搜索的路径列表
		systemInfo.setJavaLibraryPath(javaLibraryPath);
		String javaIoTmpdir = props.getProperty("java.io.tmpdir");// 	默认的临时文件路径
		systemInfo.setJavaIoTmpdir(javaIoTmpdir);
		String javaCompiler = props.getProperty("java.compiler");// 	要使用的 JIT 编译器的名称
		systemInfo.setJavaCompiler(javaCompiler);
		String javaExtDirs = props.getProperty("java.ext.dirs");// 	一个或多个扩展目录的路径
		systemInfo.setJavaExtDirs(javaExtDirs);
		String fileSeparator = props.getProperty("file.separator");// 	文件分隔符（在 UNIX 系统中是“/”）
		systemInfo.setFileSeparator(fileSeparator);
		String pathSeparator = props.getProperty("path.separator");// 	路径分隔符（在 UNIX 系统中是“:”）
		systemInfo.setPathSeparator(pathSeparator);
		String lineSeparator = props.getProperty("line.separator");// 	行分隔符（在 UNIX 系统中是“/n”）
		systemInfo.setLineSeparator(lineSeparator);
		String userName = props.getProperty("user.name");// 	用户的账户名称
		systemInfo.setUserName(userName);
		String userHome = props.getProperty("user.home");// 	用户的主目录
		systemInfo.setUserHome(userHome);
		String userDir = props.getProperty("user.dir");// 	用户的当前工作目录
		systemInfo.setUserDir(userDir);
		return systemInfo;
	}
}
