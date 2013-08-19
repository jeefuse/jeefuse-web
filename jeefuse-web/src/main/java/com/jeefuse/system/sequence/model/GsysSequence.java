/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.model;
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
import org.hibernate.validator.NotNull;

import com.jeefuse.base.model.IdEntity;

/**
 * 序例 Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_sequence")
public class GsysSequence implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysSequence() {
	}						

	/**
	 * ------------------------------------------------------------------------
	 * 序列名
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Id
	@GeneratedValue(generator = "gsysSequenceGenerator")     
	@GenericGenerator(name = "gsysSequenceGenerator", strategy = "assigned")
	@Column(name = "name", length = 20, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
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
	 * 序号
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "next_id", length = 19, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	public Long getNextId() {
		return nextId;
	}

	/** @generated */
	public void setNextId(final Long nextId) {
		this.nextId = nextId;
	}

	/** @generated */
	private Long nextId = null;	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("nextId",nextId)
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
		if (!(obj instanceof GsysSequence))
			return false;
		final GsysSequence other = (GsysSequence) obj;
		if (name == null) {
			if (other.getId() != null)
				return false;
		} else if (!name.equals(other.getId()))
			return false;
		return true;
	}	
}
