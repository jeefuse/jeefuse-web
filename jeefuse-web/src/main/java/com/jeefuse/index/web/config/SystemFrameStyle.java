package com.jeefuse.index.web.config;

/**
 * 系统界面结构风格.
 * 
 * @author yonclv
 */
public enum SystemFrameStyle {

	leftMenu, topMenu, topLeftMenu;

	@Override
	public String toString() {
		switch (this) {
		case leftMenu:
			return "leftMenu";
		case topMenu:
			return "topMenu";
		default:
			return "leftMenu";
		}
	}

	/**
	 * 根据param获取SystemFrameStyle对象.若无此对象将返回空.
	 */
	public static SystemFrameStyle valueOfString(String param) {
		SystemFrameStyle[] systemFrameStyles = SystemFrameStyle.values();
		for (SystemFrameStyle item : systemFrameStyles) {
			if (item.toString().equalsIgnoreCase(param))
				return item;
		}
		return null;
	}
}
