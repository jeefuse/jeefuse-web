/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysUser 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysUserValueGet implements PropertyValueGet<GsysUser>{

	/**
	 * GsysUser 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysUser model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysUserField gsysUserField = GsysUserField.valueOfFieldName(propertyName);
		if (null == gsysUserField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysUserField) {
		case id://1 ID
			return model.getId();
		case username://2 用户名
			return model.getUsername();
		case createTime://3 创建时间
			return model.getCreateTime();
		case email://4 Email
			return model.getEmail();
		case level://5 级别
			return model.getLevel();
		case updateTime://6 更新时间
			return model.getUpdateTime();
		case loginName://7 登录名
			return model.getLoginName();
		case password://9 密码
			return model.getPassword();
		case remark://10 备注
			return model.getRemark();
		case sex://11 性别
			return model.getSex();
		case mobile://12 电话
			return model.getMobile();
		case telephone://13 telephone
			return model.getTelephone();
		case enabled://14 有效性
			return model.getEnabled();
		case activated://15 是否激活
			return model.getActivated();
		case lastLoginTime://16 最后登录时间
			return model.getLastLoginTime();
		case portraitPhoto://17 头像
			return model.getPortraitPhoto();
		case portraitPhotoSavePath://18 头像保存实际地址
			return model.getPortraitPhotoSavePath();
		}
		return null;
	}
	
}
