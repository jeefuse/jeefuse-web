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
 * 排序标签.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class OrderTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private static final String sort_field_property = "sortField";
	private static final String sort_order_property = "sortOrder";
	private String property;
	private String label;
	private String ascLabel;
	private String descLabel;
	private String baseUrl;

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
		StringBuilder sb = new StringBuilder();
		ServletRequest request = pageContext.getRequest();
		String[] sortFields = request.getParameterValues(sort_field_property);
		String[] sortOrders = request.getParameterValues(sort_order_property);
		String sortField = null != sortFields ? sortFields[0] : null;
		String sortOrder = null != sortOrders ? sortOrders[0] : null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.putAll(request.getParameterMap());
		if (null != sortField && property.equals(sortField)) {
			if ("asc".equals(sortOrder)) {
				sb.append("<a class='low-sort-sel' href='").append(getHref("desc", paramMap)).append("' title='");
				if (StringUtils.isNotBlank(descLabel)) {
					sb.append(descLabel);
				} else {
					sb.append("点击按").append(label).append("高到底排序");
				}
				sb.append("'><span><b>");
				sb.append(label);
				sb.append("</b></span></a>");
			} else {
				sb.append("<a class='high-sort-sel' href='").append(getHref("asc", paramMap)).append("' title='");
				if (StringUtils.isNotBlank(ascLabel)) {
					sb.append(ascLabel);
				} else {
					sb.append("点击按").append(label).append("底到高排序");
				}
				sb.append("'><span><b>");
				sb.append(label);
				sb.append("</b></span></a>");
			}
		} else {
			sb.append("<a class='high-sort' href='").append(getHref("asc", paramMap)).append("' title='");
			if (StringUtils.isNotBlank(ascLabel)) {
				sb.append(ascLabel);
			} else {
				sb.append("点击按").append(label).append("底到高排序");
			}
			sb.append("'><span><b>");
			sb.append(label);
			sb.append("</b></span></a>");
		}
		return sb.toString();
	}

	private String getHref(String order, Map<String, Object> paramMap) {
		StringBuilder urlsb = new StringBuilder(100);
		urlsb.append(baseUrl);
		if (null != order) {
			paramMap.put(sort_field_property, property);
			paramMap.put(sort_order_property, order);
		} else {
			paramMap.remove(sort_field_property);
			paramMap.remove(sort_order_property);
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
				if (key.equals(sort_field_property)) {
					urlsb.append(sort_field_property).append("=").append(property);
				} else if (key.equals(sort_order_property)) {
					urlsb.append(sort_order_property).append("=").append(order);
				} else {
					urlsb.append(key).append("=").append(StringUtils.join(request.getParameterValues(key), ","));
				}
			}
		}
		return urlsb.toString();
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAscLabel() {
		return ascLabel;
	}

	public void setAscLabel(String ascLabel) {
		this.ascLabel = ascLabel;
	}

	public String getDescLabel() {
		return descLabel;
	}

	public void setDescLabel(String descLabel) {
		this.descLabel = descLabel;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
