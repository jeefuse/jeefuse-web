package com.jeefuse.system.sequence.model;

public enum SequenceType {

	/**
	 * 店铺表序列
	 */
	dining_site_seq("dining_site_seq")
	;
	private final String name;

	private SequenceType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


}
