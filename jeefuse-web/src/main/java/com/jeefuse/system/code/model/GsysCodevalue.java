/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * GsysCodevalue Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_codevalue")
public class GsysCodevalue implements IdEntity<String>, Serializable, KeyLabel {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysCodevalue() {
	}

	/**
	 * 构造KeyLabel.
	 * 
	 * @param name
	 * @param value
	 */
	public GsysCodevalue(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * ------------------------------------------------------------------------
	 * ID
	 * ------------------------------------------------------------------------
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
	
	/** @generated */
	private String id = null;

	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "NAME", length = 20, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 20)
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
	 * value
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "VALUE", length = 50, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 50)
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
	 * ˵
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "DESCRIPT", length = 100, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 100)
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
	 * gsysCode
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@JoinColumn(name = "CODE_CID", unique = false, nullable = false, insertable = true, updatable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	public GsysCode getGsysCode() {
		return gsysCode;
	}

	/** @generated */
	public void setGsysCode(final GsysCode gsysCode) {
		this.gsysCode = gsysCode;
	}

	/** @generated */
	private GsysCode gsysCode = null;

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("value",value).append("descript",descript)
				//.append("gsysCode",gsysCode)
				.toString();
	}
	
	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (id == null? super.hashCode() : id.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysCodevalue))
			return false;
		final GsysCodevalue other = (GsysCodevalue) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	@Transient
	public String getKey() {
		return value;
	}

	@Transient
	public String getLabel() {
		return name;
	}	
}
