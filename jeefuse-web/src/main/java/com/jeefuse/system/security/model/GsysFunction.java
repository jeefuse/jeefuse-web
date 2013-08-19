/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;

/**
 * GsysFunction Entity define.
 * 
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_function")
public class GsysFunction implements IdEntity<String>, TreeViewItem, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysFunction() {
	}

	/**
	 * using for treeView.
	 * 
	 * @generated
	 */
	public GsysFunction(String id, String name, String parentId, String url) {
		this.id = id;
		this.name = name;
		GsysFunction curParent = new GsysFunction();
		curParent.setId(parentId);
		this.parent = curParent;
		this.url = url;
	}

	/**
	 * using for treeView.
	 * 
	 * @generated
	 */
	public GsysFunction(String id, String name, String parentId) {
		this.id = id;
		this.name = name;
		GsysFunction curParent = new GsysFunction();
		curParent.setId(parentId);
		this.parent = curParent;
	}

	/**
	 * using for url map.
	 * 
	 * @generated
	 */
	public GsysFunction(String id, String url) {
		this.id = id;
		this.url = url;
	}

	/**
	 * ------------------------------------------------------------------------
	 * ID ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(strategy = "uuid", name = "hibernate-uuid")
	@Column(name = "ID", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	public String getId() {
		return id;
	}

	/** @generated */
	public void setId(final String id) {
		this.id = id;
	}

	private String id = null;

	/** @generated */
	@Column(name = "VALUE", length = 100, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 100)
	public String getValue() {
		return this.value;
	}

	/**
	 * ------------------------------------------------------------------------
	 * 权限标志
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public void setValue(final String value) {
		this.value = value;
	}

	/** @generated */
	private String value = null;

	/**
	 * ------------------------------------------------------------------------
	 * 权限名称
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@Column(name = "NAME", length = 120, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 120)
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
	 * 描述 ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	@Column(name = "DESCRIPT", length = 255, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 255)
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
	 * 权限类型
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@Column(name = "TYPE", length = 20, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 20)
	public String getType() {
		return type;
	}

	/** @generated */
	public void setType(final String type) {
		this.type = type;
	}

	/** @generated */
	private String type = null;

	/**
	 * ------------------------------------------------------------------------
	 * url
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@Column(name = "URL", length = 255, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 255)
	public String getUrl() {
		return url;
	}

	/** @generated */
	public void setUrl(final String url) {
		this.url = url;
	}

	/** @generated */
	private String url = null;

	/**
	 * ------------------------------------------------------------------------
	 * 上级 ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public GsysFunction getParent() {
		return parent;
	}

	/** @generated */
	public void setParent(final GsysFunction parent) {
		this.parent = parent;
	}

	/** @generated */
	private GsysFunction parent = null;

	@Transient
	public void setParentId(String parendId) {
		if (StringUtils.isBlank(parendId)) {
			this.parent = null;
		}
		if (null == parent) {
			parent = new GsysFunction();
		}
		parent.setId(parendId);
	}

	/**
	 * ------------------------------------------------------------------------
	 * 是否有效
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@Column(name = "VALID_STATUS", length = 1, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 1)
	public String getValidStatus() {
		return validStatus;
	}

	/** @generated */
	public void setValidStatus(final String validStatus) {
		this.validStatus = validStatus;
	}

	/** @generated */
	private String validStatus = null;

	/**
	 * ------------------------------------------------------------------------
	 * 排序 ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	@Column(name = "SORT_NUM", length = 10, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	public long getSortNum() {
		return sortNum;
	}

	/** @generated */
	public void setSortNum(final long sortNum) {
		this.sortNum = sortNum;
	}

	/** @generated */
	private long sortNum = 0;

	/**
	 * ------------------------------------------------------------------------
	 * layerCode
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@Column(name = "LAYER_CODE", length = 20, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 20)
	public String getLayerCode() {
		return layerCode;
	}

	/** @generated */
	public void setLayerCode(final String layerCode) {
		this.layerCode = layerCode;
	}

	/** @generated */
	private String layerCode = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysRelRoleFunctions
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysFunction", cascade = CascadeType.REMOVE)
	public List<GsysRelRoleFunction> getGsysRelRoleFunctions() {
		if (this.gsysRelRoleFunctions == null) {
			this.gsysRelRoleFunctions = new ArrayList<GsysRelRoleFunction>();
		}
		return gsysRelRoleFunctions;
	}

	/** @generated */
	public void setGsysRelRoleFunctions(final List<GsysRelRoleFunction> gsysRelRoleFunctions) {
		this.gsysRelRoleFunctions = gsysRelRoleFunctions;
	}

	/** @generated */
	private List<GsysRelRoleFunction> gsysRelRoleFunctions = null;

	/******************************************************************
	 * Utils
	 ******************************************************************/

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("value", value)
				.append("name", name).append("descript", descript).append("type", type).append("url", url).append(
						"validStatus", validStatus).append("sortNum", sortNum).append("layerCode", layerCode)
				.toString();
	}

	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (id == null ? super.hashCode() : id.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysFunction))
			return false;
		final GsysFunction other = (GsysFunction) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	/******************************************************************
	 * transient method
	 ******************************************************************/

	@Transient
	public boolean getComplete() {
		return true;
	}

	@Transient
	public boolean getIsexpand() {
		return true;
	}

	@Transient
	public String getText() {
		return this.getName();
	}

	@Transient
	public String getParentId() {
		if (null != parent)
			return parent.getId();
		return null;
	}

	@Transient
	public String getParentName() {
		if (null != parent)
			return parent.getName();
		return null;
	}

	@Transient
	public String getKey() {
		return this.getId();
	}

	@Transient
	public String getLabel() {
		return this.getName();
	}
}
