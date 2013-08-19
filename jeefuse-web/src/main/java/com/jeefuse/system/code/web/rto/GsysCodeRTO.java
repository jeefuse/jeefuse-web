/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.rto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;

/**
 * GsysCode Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeRTO implements GenericRTO<GsysCode>, Serializable{
	/** @generated */
	private static final long serialVersionUID = 1L;

	/**
	 * ------------------------------------------------------------------------
	 * cid
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getCid() {
		return cid;
	}

	/** @generated */
	public void setCid(final String cid) {
		this.cid = cid;
	}

	/** @generated */
	private String cid = null;

	/** @generated */
	public String getId() {
		return cid;
	}
	
	/** @generated */
	public void setId(final String id) {
		this.cid = id;
	}
	
	/**
	 * ------------------------------------------------------------------------
	 * 更新前的cid
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getOldId() {
		return oldId;
	}

	/** @generated */
	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	/** @generated */
	private String oldId = null;

	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/** @generated */
	public void setName(final String name) {
		this.name = name;
	}
	
	/** @generated */
	private String name = null;	

	/**
	 * ------------------------------------------------------------------------
	 * ˵
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getDescript() {
		return descript;
	}

	/** @generated */
	public void setDescript(final String descript) {
		this.descript = descript;
	}
	
	/** @generated */
	private String descript = null;

	/**
	 * ------------------------------------------------------------------------
	 * kind
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/** @generated */
	public void setKind(final String kind) {
		this.kind = kind;
	}
	
	/** @generated */
	private String kind = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysCodevalues
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public List<GsysCodevalue> getGsysCodevalues() {
		if (this.gsysCodevalues == null) {
			this.gsysCodevalues = new ArrayList<GsysCodevalue>();
		}
		return gsysCodevalues;
	}

	/** @generated */
	public void setGsysCodevalues(final List<GsysCodevalue> gsysCodevalues) {
		this.gsysCodevalues = gsysCodevalues;
	}
	
	/** @generated */
	private List<GsysCodevalue> gsysCodevalues = null;


	/***************************************************************************
	 * RTO <==> model convert
	 **************************************************************************/

	/**
	 * 从请求中构造要更新的实体[GsysCode]对象.
	 * 
	 * @param oldModel
	 *            要更新的实体对象.
	 */
	public GsysCode getModifiedModel(GsysCode oldModel) {
		oldModel.setCid(this.getId());//id
		oldModel.setName(this.getName());//1 name
		oldModel.setDescript(this.getDescript());//2 ˵
		oldModel.setKind(this.getKind());//3 kind
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体[GsysCode]对象.
	 * 
	 * @generated
	 */
	public GsysCode getNewModel() {
		GsysCode newGsysCode=new GsysCode();
		newGsysCode.setCid(this.getId());//id
		newGsysCode.setName(this.getName());//1 name
		newGsysCode.setDescript(this.getDescript());//2 ˵
		newGsysCode.setKind(this.getKind());//3 kind
		newGsysCode.setGsysCodevalues(this.getGsysCodevalues());//4 gsysCodevalues
		return newGsysCode;
	}

	/**
	 * 用实体[GsysCode]对象填充当前RTO数据.
	 * 
	 * @generated
	 */
	public void setModel(GsysCode model) {
		this.setId(model.getCid());//id
		this.setName(model.getName());//1 name
		this.setDescript(model.getDescript());//2 ˵
		this.setKind(model.getKind());//3 kind
		this.setGsysCodevalues(model.getGsysCodevalues());//4 gsysCodevalues
	}
	
	/**************************************************************************
	 * Utils
	 **************************************************************************/

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("name",name).append("descript",descript).append("kind",kind)
				//.append("gsysCodevalues",gsysCodevalues)
				.toString();
	}


}
