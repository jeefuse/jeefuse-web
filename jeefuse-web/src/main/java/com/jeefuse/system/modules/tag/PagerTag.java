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
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.utils.page.Page;

/**
 * 分页标签.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class PagerTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	final static String PAGE_JUMP_INVOKE_METHOD = "pageJumpInvoke";
	private int curPage;//当前页
	private int pageSize;//每页大小
	private int pageNum = 10;//显示页面数量.
	private long totalCount;//记录数
	private boolean jumpable = false;//是否显示页在跳转下拉框
	private String invokeMethod = PAGE_JUMP_INVOKE_METHOD;
	private String baseUrl;

	public PagerTag() {
	}

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
		StringBuffer bar = new StringBuffer();
		Page page = new Page();
		page.setPageNo(curPage);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		int curpage = page.getPageNo();//当前页  
		long totalPages = page.getTotalPages();//总页数  
		if (totalPages <= 1) {//只有一页
			bar.append("<span class='current'>1</span>");
			bar.append("<span class='totalPages'>共1页</span>");
			bar.append("<span class='viewCount'>显示");
			bar.append(page.getFirst() + 1);
			bar.append("-");
			long end = page.getEnd();
			bar.append(end > totalCount ? totalCount : end);
			bar.append("条</span>");
		} else {//多于一页
			if (curpage != 1) {
				bar.append("<a href='").append(getHref(curpage - 1)).append("'><<上一页</a>");
			}
			//如果总页数小于显示页数 
			if (totalPages <= pageNum) {
				for (int i = 1; i <= totalPages; i++) {
					if (curpage == i) {
						bar.append("<span class='current'>" + i + "</span>");
					} else {
						bar.append("<a href='").append(getHref(i)).append("'>" + i + "</a>");
					}
				}
			} else {//总页数大于显示页数 
				int splitPageNum = pageNum / 2;
				if (curpage <= splitPageNum) {
					for (int i = 1; i <= pageNum; i++) {
						if (curpage == i) {
							bar.append("<span class='current'>" + i + "</span>");
						} else {
							bar.append("<a href='").append(getHref(i)).append("'>" + i + "</a>");
						}
					}
				} else if (curpage >= splitPageNum) {
					int startPage = curpage - splitPageNum + 1;
					int endPage = curpage + splitPageNum;
					if (endPage > totalPages) {
						endPage = (int) totalPages;
					}
					bar.append("<a href='").append(getHref(1)).append("'>" + 1 + "</a>");
					bar.append("<span>....</span>");
					for (long i = startPage; i <= endPage; i++) {
						if (curpage == i) {
							bar.append("<span class='current'>" + i + "</span>");
						} else {
							bar.append("<a href='").append(getHref(i)).append("'>" + i + "</a>");
						}
					}
				}
			}
			//如果是最后一页  
			if (curpage != totalPages) {
				bar.append("<a href='").append(getHref(curpage + 1)).append("'>下一页>></a>");
			}
			bar.append("<span class='totalCount'>共");
			bar.append(totalCount);
			bar.append("条</span>");
			bar.append("<span class='viewCount'>显示");
			bar.append(page.getFirst() + 1);
			bar.append("-");
			long end = page.getEnd();
			bar.append(end > totalCount ? totalCount : end);
			bar.append("条</span>");
			//			bar.append("<span class='totalPages'>");
			//			bar.append(page.getTotalPages());
			//			bar.append("页</span>");
			if (jumpable) {
				bar.append("<select style='height:26px;text-align: center;padding: 0.3em 0.5em;' onchange='");
				bar.append(invokeMethod + "(\"this.value\"");
				bar.append(")'\">");
				for (int i = 1; i <= totalPages; i++) {
					if (curpage == i) {
						bar.append("<option value='" + i + "' selected='selected'>").append("第" + i + "页").append(
								"</option>");
					} else {
						bar.append("<option value='" + i + "'>").append("第" + i + "页").append("</option>");
					}
				}
				bar.append("</select>");
			}
		}
		return bar.toString();
	}

	private String getHref(long pageNo) {
		if (StringUtils.isNotBlank(baseUrl))
			return getURL(pageNo);
		else
			return "javascript:" + invokeMethod + "(" + pageNo + ")";
	}

	@SuppressWarnings("unchecked")
	private String getURL(long pageNo) {
		StringBuilder urlsb = new StringBuilder(100);
		urlsb.append(baseUrl);
		ServletRequest request = pageContext.getRequest();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.putAll(request.getParameterMap());
		paramMap.put("page.pageNo", pageNo);
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
				if (key.equals("page.pageNo")) {
					urlsb.append(key).append("=").append(pageNo);
				} else {
					urlsb.append(key).append("=").append(StringUtils.join(request.getParameterValues(key), ","));
				}
			}
		}
		return urlsb.toString();
	}

	public boolean isJumpable() {
		return jumpable;
	}

	public void setJumpable(boolean jumpable) {
		this.jumpable = jumpable;
	}

	@Override
	public int doEndTag() throws JspTagException {
		return EVAL_PAGE;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getInvokeMethod() {
		return invokeMethod;
	}

	public void setInvokeMethod(String invokeMethod) {
		this.invokeMethod = invokeMethod;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
