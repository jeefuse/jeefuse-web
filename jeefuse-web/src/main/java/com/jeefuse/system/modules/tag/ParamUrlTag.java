package com.jeefuse.system.modules.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * 在Url在添加动态参数.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ParamUrlTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String baseUrl;
	private String propertyName;
	private String value;

	public ParamUrlTag() {
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			String content = getHref();
			pageContext.getOut().write(content);
			return SKIP_BODY;
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private String getHref() {
		StringBuilder urlsb = new StringBuilder(100);
		urlsb.append(baseUrl);
		ServletRequest request = pageContext.getRequest();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.putAll(request.getParameterMap());
		if (StringUtils.isNotBlank(value)) {
			paramMap.put(propertyName, value);
		} else {
			if (paramMap.containsKey(propertyName)) {
				paramMap.remove(propertyName);
			}
		}
		if (null != paramMap && !paramMap.isEmpty()) {
			List<String> keys = new ArrayList<String>(paramMap.keySet());
			Collections.sort(keys);//排序
			urlsb.append("?");
			Iterator keyIt = keys.iterator();
			boolean first = true;
			while (keyIt.hasNext()) {
				String key = keyIt.next().toString();
				if (!first) {
					urlsb.append("&");
				} else {
					first = false;
				}
				if (key.equals(propertyName)) {
					urlsb.append(key).append("=").append(value);
				} else {
					urlsb.append(key).append("=").append(StringUtils.join(request.getParameterValues(key), ","));
				}
			}
		}
		return urlsb.toString();
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
