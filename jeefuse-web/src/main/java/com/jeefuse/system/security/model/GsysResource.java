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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * GsysResource Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_resource")
public class GsysResource implements IdEntity<String>, Serializable, KeyLabel {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysResource() {
	}

	/**
	 * 用于构造KeyLabel对象.
	 */
	public GsysResource(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * ------------------------------------------------------------------------
	 * id
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(strategy = "uuid", name = "hibernate-uuid")
	@Column(name = "id", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	public String getId() {
		return id;
	}
	
	/** @generated */
	public void setId(final String id) {
		this.id = id;
	}
	
	private String id = null;

	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "name", length = 32, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 32)
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
	 * descript
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "descript", length = 255, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
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
	 * value
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "value", length = 200, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 200)
	public String getValue() {
		return value;
	}

	/** @generated */
	public void setValue(final String value) {
		this.value = value;
	}

	/** @generated */
	private String value = null;

	/**
	 * ------------------------------------------------------------------------
	 * type
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "type", length = 32, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 32)
	public String getType() {
		return type;
	}

	/** @generated */
	public void setType(final String type) {
		this.type = type;
	}

	/** @generated */
	@Transient
	public boolean isUrl() {
		return ResourceType.URL.equals(ResourceType.valueOfKey(type));
	}

	/** @generated */
	@Transient
	public boolean isMenu() {
		return ResourceType.MENU.equals(ResourceType.valueOfKey(type));
	}

	/** @generated */
	@Transient
	public boolean isWebservice() {
		return ResourceType.WEBSERVICE.equals(ResourceType.valueOfKey(type));
	}

	/** @generated */
	private String type = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysRelRoleResources
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysResource", cascade = CascadeType.REMOVE)
	public List<GsysRelRoleResource> getGsysRelRoleResources() {
		if (this.gsysRelRoleResources == null) {
			this.gsysRelRoleResources = new ArrayList<GsysRelRoleResource>();
		}
		return gsysRelRoleResources;
	}

	/** @generated */
	public void setGsysRelRoleResources(final List<GsysRelRoleResource> gsysRelRoleResources) {
		this.gsysRelRoleResources = gsysRelRoleResources;
	}

	/** @generated */
	private List<GsysRelRoleResource> gsysRelRoleResources = null;

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("descript",descript).append("value",value)
				.append("type",type).append("gsysRelRoleResources",gsysRelRoleResources)
				.toString();
	}
	
	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? super.hashCode() : id.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysResource))
			return false;
		final GsysResource other = (GsysResource) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	@Transient
	public String getKey() {
		return id;
	}

	@Transient
	public String getLabel() {
		return name;
	}	
}
