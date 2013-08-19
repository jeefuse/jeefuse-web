/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import com.jeefuse.base.model.IdEntity;

/**
 * GsysRelRoleResource Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
	@Table(name = "gsys_rel_role_resource")
public class GsysRelRoleResource implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysRelRoleResource() {
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
	@Column(name = "ID", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
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
	 * gsysRole
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@JoinColumn(name = "ROLE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	public GsysRole getGsysRole() {
		return gsysRole;
	}

	/** @generated */
	public void setGsysRole(final GsysRole gsysRole) {
		this.gsysRole = gsysRole;
	}

	/** @generated */
	private GsysRole gsysRole = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysResource
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@JoinColumn(name = "RESOURCE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	public GsysResource getGsysResource() {
		return gsysResource;
	}

	/** @generated */
	public void setGsysResource(final GsysResource gsysResource) {
		this.gsysResource = gsysResource;
	}

	/** @generated */
	private GsysResource gsysResource = null;

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		// .append("id",id).append("gsysRole",gsysRole).append("gsysResource",gsysResource)
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
		if (!(obj instanceof GsysRelRoleResource))
			return false;
		final GsysRelRoleResource other = (GsysRelRoleResource) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}	
}
