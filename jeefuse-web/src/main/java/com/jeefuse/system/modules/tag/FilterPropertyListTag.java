package com.jeefuse.system.modules.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * 构造搜索属性例表 .
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class FilterPropertyListTag<T extends KeyLabel> extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String baseUrl;
	private String propertyName;
	private String checkKey;
	private List<T> keyLabels;
	private boolean showAllItem = false;

	@Override
	public int doStartTag() throws JspException {
		try {
			String content = getContent();
			pageContext.getOut().write(content);
			return SKIP_BODY;
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private String getContent() {
		if (null == keyLabels || keyLabels.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(100);
		ServletRequest request = pageContext.getRequest();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.putAll(request.getParameterMap());
		if (showAllItem) {
			sb.append(" <a href='").append(getHref(null, paramMap)).append("'");
			if (null == checkKey || "".equals(checkKey)) {
				sb.append(" class='current'");
			}
			sb.append("'>").append("全部").append("</a>");
		}
		for (KeyLabel item : keyLabels) {
			sb.append(" <a href='").append(getHref(item, paramMap)).append("'");
			if (null != checkKey && item.getKey().equals(checkKey)) {
				sb.append(" class='current'");
			}
			sb.append("	title='查找");
			sb.append(item.getLabel());
			sb.append("'>").append(item.getLabel()).append("</a>");
		}
		return sb.toString();
	}

	private String getHref(KeyLabel item, Map<String, Object> paramMap) {
		StringBuilder urlsb = new StringBuilder(100);
		urlsb.append(baseUrl);
		if (null != item) {
			paramMap.put(propertyName, item.getKey());
		}
		List<String> keys = new ArrayList<String>(paramMap.keySet());
		Collections.sort(keys);//排序
		ServletRequest request = pageContext.getRequest();
		if (null != paramMap && !paramMap.isEmpty()) {
			boolean hasUrlAppendParam = false;
			if (-1 == urlsb.indexOf("?")) {
				urlsb.append("?");
			} else {
				hasUrlAppendParam = true;
			}
			Iterator<?> keyIt = keys.iterator();
			while (keyIt.hasNext()) {
				String key = keyIt.next().toString();
				if (hasUrlAppendParam) {
					urlsb.append("&");
				} else {
					hasUrlAppendParam = true;
				}
				if (key.equals(propertyName)) {
					urlsb.append(key).append("=").append(null == item ? "" : item.getKey());
				} else {
					urlsb.append(key).append("=").append(StringUtils.join(request.getParameterValues(key), ","));
				}
			}
		}
		return urlsb.toString();
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCheckKey() {
		return checkKey;
	}

	public void setCheckKey(String checkKey) {
		this.checkKey = checkKey;
	}

	public List<T> getKeyLabels() {
		return keyLabels;
	}

	public void setKeyLabels(List<T> keyLabels) {
		this.keyLabels = keyLabels;
	}

	public void setKeyLabels(T[] keyLabels) {
		if (null != keyLabels) {
			this.keyLabels = Arrays.asList(keyLabels);
		}
	}

	public boolean isShowAllItem() {
		return showAllItem;
	}

	public void setShowAllItem(boolean showAllItem) {
		this.showAllItem = showAllItem;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
