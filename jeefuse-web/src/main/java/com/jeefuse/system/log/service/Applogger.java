package com.jeefuse.system.log.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.LogType;
import com.jeefuse.system.security.service.spring.SecurityHolder;

/**
 * 系统应用日志记录.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class Applogger {

	/**
	 * 日志级别设置.
	 */
	static final int loglevel = LogType.getIndex(LogType.TRACE);

	/**
	 * 保存登录日志.
	 */
	static private void login(GsysLoginlog gsysLoginlog) {
		LogServiceFactory.getGsysLoginlogService().saveByUserLogin(gsysLoginlog);
	}

	/**
	 * 保存登录日志.
	 */
	static public void login(HttpServletRequest request, String msg) {
		GsysLoginlog gsysLoginlog = new GsysLoginlog();
		gsysLoginlog.setCreatedate(new Date());
		gsysLoginlog.setLoginIp(request.getRemoteAddr());
		gsysLoginlog.setUserId(SecurityHolder.getLoginUserId());
		gsysLoginlog.setMessage(msg);
		login(gsysLoginlog);
	}

	/**
	 * 保存操作日志.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param logType
	 *            日志类型
	 * @param remoteIp
	 *            远程IP
	 */
	static public void operateLog(String msg, String detail, LogType logType, HttpServletRequest request) {
		if (LogType.getIndex(logType) < loglevel)
			return;
		GsysOperatelog model = new GsysOperatelog();
		model.setCreatedate(new Date());
		model.setLoginIp(request.getRemoteAddr());
		model.setUserId(SecurityHolder.getLoginUserId());
		model.setMessage(msg);
		model.setDetail(detail);
		model.setKind(logType.getKey());
		LogServiceFactory.getGsysOperatelogService().save(model);
	}

	/**
	 * 保存操作日志.类型为INFO.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void info(String msg, String detail, HttpServletRequest request) {
		operateLog(msg, detail, LogType.INFO, request);
	}

	/**
	 * 保存操作日志.类型为TRACE.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void trace(String msg, String detail, HttpServletRequest request) {
		operateLog(msg, detail, LogType.TRACE, request);
	}

	/**
	 * 保存操作日志.类型为WARN.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void warn(String msg, String detail, HttpServletRequest request) {
		operateLog(msg, detail, LogType.WARN, request);
	}

	/**
	 * 保存应用异常操作日志.类型为APP_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void appError(String msg, HttpServletRequest request) {
		operateLog(msg, null, LogType.APP_ERROR, request);
	}

	/**
	 * 保存应用异常操作日志.类型为APP_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void appError(String msg, String detail, HttpServletRequest request) {
		operateLog(msg, detail, LogType.APP_ERROR, request);
	}

	/**
	 * 保存系统异常操作日志.类型为SYS_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param Throwable
	 *            异常
	 * @param remoteIp
	 *            远程IP
	 */
	static public void appError(String msg, Throwable e, HttpServletRequest request) {
		operateLog(msg, e.getMessage(), LogType.APP_ERROR, request);
	}

	/**
	 * 保存系统异常操作日志.类型为SYS_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param remoteIp
	 *            远程IP
	 */
	static public void sysError(String msg, HttpServletRequest request) {
		operateLog(msg, null, LogType.SYS_ERROR, request);
	}

	/**
	 * 保存系统异常操作日志.类型为SYS_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param detail
	 *            详细
	 * @param remoteIp
	 *            远程IP
	 */
	static public void sysError(String msg, String detail, HttpServletRequest request) {
		operateLog(msg, detail, LogType.SYS_ERROR, request);
	}

	/**
	 * 保存系统异常操作日志.类型为SYS_ERROR.
	 * 
	 * @param msg
	 *            信息说明
	 * @param remoteIp
	 *            远程IP
	 * @param Throwable
	 *            异常
	 */
	static public void sysError(String msg, HttpServletRequest request, Throwable e) {
		operateLog(msg, e.getMessage(), LogType.SYS_ERROR, request);
	}

}
