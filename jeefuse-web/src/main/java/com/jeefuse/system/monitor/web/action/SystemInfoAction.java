package com.jeefuse.system.monitor.web.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.jeefuse.base.utils.common.CollectionUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.monitor.service.MonitorInfoBean;
import com.jeefuse.system.monitor.service.MonitorService;
import com.jeefuse.system.monitor.service.MonitorServiceImpl;
import com.jeefuse.system.monitor.service.SystemInfoService;
import com.jeefuse.system.monitor.web.listener.OnlineSessionListener;
import com.jeefuse.system.monitor.web.listener.OnlineSessionVo;

/**
 * 系统信息.
 * 
 * @author yonclv
 * @email yonclv@sohu.com
 */
public class SystemInfoAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private MonitorInfoBean monitorInfo;
	private Set<Entry<Object, Object>> systemPropsSet;
	private Page<OnlineSessionVo> page = Page.createPage();

	public String index() {
		try {
			try {
				MonitorService service = new MonitorServiceImpl();
				monitorInfo = service.getMonitorInfo();
			} catch (Throwable e) {
				logger.error(e.getMessage(), e);
			}
			systemPropsSet = SystemInfoService.getPropertiesSet();
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 在线会话查看
	 */
	public String onlineSessionList() {
		return SUCCESS;
	}

	public void onlineSessionListOutJson() {
		try {
			Collection<OnlineSessionVo> onlineSessionSet = OnlineSessionListener.getOnlineSessionMap().values();
			List<OnlineSessionVo> onlineSessionList = new ArrayList<OnlineSessionVo>(onlineSessionSet);
			List<OnlineSessionVo> onlineSessionResult = CollectionUtil.subList(onlineSessionList, page.getFirst(), page.getEnd());
			page.setResult(onlineSessionResult);
			RenderUtil.renderJsonFlexGrid(page);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderHtmlResultMsgError();
		}
	}

	/*****************************************************************
	 * 页面属性访问 /
	 *****************************************************************/

	public MonitorInfoBean getMonitorInfo() {
		return monitorInfo;
	}

	public Set<Entry<Object, Object>> getSystemPropsSet() {
		return systemPropsSet;
	}

	public Page<OnlineSessionVo> getPage() {
		return page;
	}

}
