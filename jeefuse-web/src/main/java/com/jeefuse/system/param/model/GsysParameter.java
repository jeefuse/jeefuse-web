/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.jeefuse.base.model.IdEntity;

/**
 * GsysParameter Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_parameter")
public class GsysParameter implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysParameter() {
	}

	/** @generated */
	@Column(name = "NAME", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@Id
	@GeneratedValue(generator = "gsysParameterGenerator")
	@GenericGenerator(name = "gsysParameterGenerator", strategy = "assigned")
	public String getName() {
		return name;
	}

	/** @generated */
	public void setName(final String name) {
		this.name = name;
	}
	
	/** @generated */
	private String name = null;

	/** @generated */
	@Transient
	public String getId() {
		return name;
	}
	
	/** @generated */
	@Transient
	public void setId(final String id) {
		this.name = id;
	}

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
	 * descript
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "DESCRIPT", length = 150, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 150)
	public String getDescript() {
		return descript;
	}

	/** @generated */
	public void setDescript(final String descript) {
		this.descript = descript;
	}

	/** @generated */
	private String descript = null;

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("value",value).append("descript",descript)
				.toString();
	}
	
	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (name == null? super.hashCode() : name.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysParameter))
			return false;
		final GsysParameter other = (GsysParameter) obj;
		if (name == null) {
			if (other.getId() != null)
				return false;
		} else if (!name.equals(other.getId()))
			return false;
		return true;
	}	
}
