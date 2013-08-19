/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.render;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.code.model.CodeDefineType;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.service.CodeServiceFacade;

/**
 * GsysCodevalue render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodevalueRenderUtil {
	private static final Logger logger = LoggerFactory.getLogger(GsysCodevalueRenderUtil.class);

	/**
	 * 输出 GsysCodevalue ResultMsg json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysCodevalue model, String message) {
		ResultJsonWriter<GsysCodevalue> jsonWriter = new GsysCodevalueResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysCodevalue FlexiGrid json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysCodevalue> items) {
		FlexidGridJsonWriter<GsysCodevalue> jsonWriter = new GsysCodevalueFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysCodevalue FlexiGrid json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysCodevalue> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}

	/**
	 * 输出GsysCode关联的GsysCodevalue.只获取name、value字段.
	 * <p/>
	 * 输出格式： { success:true|false, message:"",
	 * data:[{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}] }
	 */
	static public void jsonResultMsgForKeyLabel(CodeDefineType codeDefineType) {
		List<GsysCodevalue> list = CodeServiceFacade.findByGsysCodeForKeyLabel(codeDefineType);
		String jsonString;
		try {
			jsonString = KeyLabelRenderUtil.contructResultMsgJson(list);
			RenderUtil.renderJson(jsonString);
		} catch (IOException e) {
			RenderUtil.renderJsonResultMsgError();
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 构造JSON格式.
	 * <p/>
	 * 输出格式： [{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * 
	 * 
	 * @param codeDefineType
	 * @return
	 */
	static public String contructJsonForKeyLabel(CodeDefineType codeDefineType) {
		List<GsysCodevalue> list = CodeServiceFacade.findByGsysCodeForKeyLabel(codeDefineType);
		return KeyLabelRenderUtil.contructJson(list);
	}

	/**
	 * 输出JSON格式.
	 * <p/>
	 * 输出格式： [{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * 
	 * 
	 * @param codeDefineType
	 * @return
	 */
	static public void renderJsonForKeyLabel(CodeDefineType codeDefineType) {
		RenderUtil.renderJson(contructJsonForKeyLabel(codeDefineType));
	}

	/**
	 * 构造为Map对象.
	 * 
	 * @param codeDefineType
	 * @return
	 */
	static public Map<String, String> contructMap(CodeDefineType codeDefineType) {
		List<GsysCodevalue> list = CodeServiceFacade.findByGsysCodeForKeyLabel(codeDefineType);
		if (null == list)
			return null;
		Map<String, String> map = new HashMap<String, String>();
		for (KeyLabel item : list) {
			map.put(item.getKey(), item.getLabel());
		}
		return map;
	}

	/**
	 * 构造JSON格式.
	 * <p/>
	 * 输出格式：{"internship":"实习","official":"正试","trial":"试用","dismiss":"辞退"}
	 * 
	 * @param codeDefineType
	 * @return
	 */
	static public String contructJsonMap(CodeDefineType codeDefineType) {
		List<GsysCodevalue> list = CodeServiceFacade.findByGsysCodeForKeyLabel(codeDefineType);
		if (null == list)
			return null;
		Map<String, String> map = new HashMap<String, String>();
		for (KeyLabel item : list) {
			map.put(item.getKey(), item.getLabel());
		}
		try {
			return JsonUtil.mapper.writeValueAsString(map);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 输出JSON格式.
	 * <p/>
	 * 输出格式：{"internship":"实习","official":"正试","trial":"试用","dismiss":"辞退"}
	 * 
	 * 
	 * @param codeDefineType
	 * @return
	 */
	static public void renderJsonMap(CodeDefineType codeDefineType) {
		RenderUtil.renderJson(contructJsonMap(codeDefineType));
	}

	/**
	 * 渲染为HTML select的option.
	 */
	static public String renderHtmlSelect(CodeDefineType codeDefineType, String checkKey) {
		List<GsysCodevalue> keyLabelList = CodeServiceFacade.findByGsysCodeForKeyLabel(codeDefineType);
		return KeyLabelRenderUtil.renderHtmlSelect(keyLabelList, checkKey);
	}
}