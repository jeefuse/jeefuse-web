/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model;

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
 * GsysCode Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_code")
public class GsysCode implements IdEntity<String>, Serializable, KeyLabel {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysCode() {
	}

	/**
	 * 用于构造KeyLabel对象.
	 */
	public GsysCode(String cid, String name) {
		this.cid = cid;
		this.name = name;
	}

	/** @generated */
	@Id
	@GeneratedValue(generator = "assignGenerator")
	@GenericGenerator(name = "assignGenerator", strategy = "assigned")
	@Column(name = "CID", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 32)
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
	@Transient
	public String getId() {
		return cid;
	}
	
	/** @generated */
	@Transient
	public void setId(final String id) {
		this.cid = id;
	}

	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "NAME", length = 100, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 100)
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
	@Column(name = "DESCRIPT", length = 200, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 200)
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
	@Column(name = "KIND", length = 1, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 1)
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysCode", cascade = CascadeType.REMOVE)
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

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",cid).append("name",name).append("descript",descript).append("kind",kind)
				//.append("gsysCodevalues",gsysCodevalues)
				.toString();
	}
	
	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (cid == null? super.hashCode() : cid.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysCode))
			return false;
		final GsysCode other = (GsysCode) obj;
		if (cid == null) {
			if (other.getId() != null)
				return false;
		} else if (!cid.equals(other.getId()))
			return false;
		return true;
	}

	@Transient
	public String getKey() {

		return cid;
	}

	@Transient
	public String getLabel() {

		return name;
	}	
}
