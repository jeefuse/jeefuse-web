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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import com.jeefuse.base.model.IdEntity;

/**
 * GsysRole Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_role")
public class GsysRole implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysRole() {
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
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "NAME", length = 40, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 40)
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
	 * displayName
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "DISPLAY_NAME", length = 40, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 40)
	public String getDisplayName() {
		return displayName;
	}

	/** @generated */
	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	/** @generated */
	private String displayName = null;

	/**
	 * ------------------------------------------------------------------------
	 * descript
	 * ------------------------------------------------------------------------
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
	 * gsysRelRoleFunctions
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysRole", cascade = CascadeType.REMOVE)
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

	/**
	 * ------------------------------------------------------------------------
	 * gsysRelRoleResources
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysRole", cascade = CascadeType.REMOVE)
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


	/**
	 * ------------------------------------------------------------------------
	 * gsysRelUserRoles
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysRole", cascade = CascadeType.REMOVE)
	public List<GsysRelUserRole> getGsysRelUserRoles() {
		if (this.gsysRelUserRoles == null) {
			this.gsysRelUserRoles = new ArrayList<GsysRelUserRole>();
		}
		return gsysRelUserRoles;
	}

	/** @generated */
	public void setGsysRelUserRoles(final List<GsysRelUserRole> gsysRelUserRoles) {
		this.gsysRelUserRoles = gsysRelUserRoles;
	}

	/** @generated */
	private List<GsysRelUserRole> gsysRelUserRoles = null;



	/*------------------------------------------------------------------------
	 * Utils
	 *************************************************************************/

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("displayName",displayName).append("descript",descript)
		// .append("gsysRelRoleFunctions",gsysRelRoleFunctions).append("gsysRelRoleResources",gsysRelRoleResources).append("gsysRelUserRoles",gsysRelUserRoles)
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
		if (!(obj instanceof GsysRole))
			return false;
		final GsysRole other = (GsysRole) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}	
}
