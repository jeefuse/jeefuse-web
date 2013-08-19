package com.jeefuse.system.code.model;

/**
 * 编码定义.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum CodeDefineType {
	/**
	 * 口味
	 */
	taste("taste", "口味")
	/**
	 * 工艺
	 */
	,craft("craft", "工艺")
	/**
	 * 功效
	 */
	,efficacy("efficacy", "功效")
	/**
	 * 菜系
	 */
	,cuisine("cuisine", "菜系")
	/**
	 * 员工状态
	 */
	, employeeState("employeeState", "员工状态")
	/**
	 * 餐饮店类目
	 */
	, shopType("shopType", "餐饮店类目")
	/**
	 * 订单自动刷新间隔
	 */
	, orderRefreshInterval("orderRefreshIntervalType", "订单自动刷新间隔")
	;

	private CodeDefineType(String name, String descript) {
		this.name = name;
		this.descript = descript;
	}

	/** @generated */
	private String name = null;

	/** @generated */
	private String descript = null;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
