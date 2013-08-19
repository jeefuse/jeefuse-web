/*
Navicat MySQL Data Transfer

Source Server         : goolov
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : jeefuse-web

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2013-08-19 17:07:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `gsys_code`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_code`;
CREATE TABLE `gsys_code` (
  `CID` varchar(32) NOT NULL DEFAULT '' COMMENT '编码编号',
  `NAME` varchar(100) DEFAULT NULL COMMENT '编码名称',
  `DESCRIPT` varchar(200) DEFAULT NULL COMMENT '说明',
  `KIND` char(1) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编码表';

-- ----------------------------
-- Records of gsys_code
-- ----------------------------
INSERT INTO `gsys_code` VALUES ('0001', '会员类型', '会员类型', '1');

-- ----------------------------
-- Table structure for `gsys_codevalue`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_codevalue`;
CREATE TABLE `gsys_codevalue` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `CODE_CID` varchar(32) DEFAULT NULL COMMENT '编码编号',
  `NAME` varchar(20) DEFAULT NULL COMMENT '编码值名',
  `VALUE` varchar(50) DEFAULT NULL COMMENT '编码值',
  `DESCRIPT` varchar(128) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`ID`),
  KEY `FK_GSYS_CODEVALUE_REF_GSYS_CODE` (`CODE_CID`),
  CONSTRAINT `FK_GSYS_CODEVALUE_REF_GSYS_CODE` FOREIGN KEY (`CODE_CID`) REFERENCES `gsys_code` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编码值';

-- ----------------------------
-- Records of gsys_codevalue
-- ----------------------------

-- ----------------------------
-- Table structure for `gsys_function`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_function`;
CREATE TABLE `gsys_function` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `VALUE` varchar(100) NOT NULL COMMENT '权限标志',
  `NAME` varchar(120) NOT NULL COMMENT '权限名称',
  `DESCRIPT` varchar(255) DEFAULT NULL COMMENT '描述',
  `TYPE` varchar(20) NOT NULL COMMENT '权限类型',
  `URL` varchar(255) DEFAULT NULL COMMENT 'url',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '上级ID',
  `VALID_STATUS` char(1) DEFAULT NULL COMMENT '是否有效',
  `SORT_NUM` int(11) NOT NULL COMMENT '排序',
  `LAYER_CODE` varchar(20) DEFAULT NULL COMMENT '层次编码',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `index_gsys_function_id` (`ID`),
  UNIQUE KEY `index_gsys_function_layerCode` (`LAYER_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_function
-- ----------------------------
INSERT INTO `gsys_function` VALUES ('40282ba02acd6d63012acd791d8a0001', 'F_sys', '系统管理', '系统管理包括用户管理、权限管理、编码管理、登录管理、在线用户管理等系统功能', 'url', '/system/main.vhtml', null, 'Y', '101', '019');
INSERT INTO `gsys_function` VALUES ('40282ba02acd6d63012acd7e4cbf0002', 'F_sys_authorize', '权限管理', '权限管理包括权限维护、角色维护', 'url', '', '40282ba02acd6d63012acd791d8a0001', 'Y', '102001', '019001');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acd9347f70001', 'F_sys_authrize_function', '功能设置', '系统功能维护', 'url', '/system/security/gsysFunction/manage.vhtml', '40282ba02acd6d63012acd7e4cbf0002', 'Y', '102001002', '019001003');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acd945f810002', 'F_sys_authrize_role', '角色设置', '设置角色信息及相关权限', 'url', '/system/security/gsysRole/manage.vhtml', '40282ba02acd6d63012acd7e4cbf0002', 'Y', '102001002', '019001002');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acd9e80f30003', 'F_sys_user', '用户管理', '用户管理操作', 'url', '', '40282ba02acd6d63012acd791d8a0001', 'Y', '0', '019002');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acda120c30004', 'F_sys_user_setup', '用户设置', '用户信息维护', 'url', '/system/security/gsysUser/manage.vhtml', '40282ba02acd836d012acd9e80f30003', 'Y', '2002', '019002001');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acdbd3e070006', 'F_sys_code', '编码管理', '编码类别设置、编码属性设置', 'url', null, '40282ba02acd6d63012acd791d8a0001', 'Y', '0', '019003');
INSERT INTO `gsys_function` VALUES ('40282ba02acd836d012acdbe72510007', 'F_sys_code_kind', '编码类别设置', '编码类别设置', 'url', '/system/code/gsysCode/manage.vhtml', '40282ba02acd836d012acdbd3e070006', 'Y', '0', '019003001');
INSERT INTO `gsys_function` VALUES ('40282ba02acdd416012acdd74f300001', 'F_sys_code_property', '编码属性设置', '编码属性设置', 'url', '/system/code/gsysCodevalue/manage.vhtml', '40282ba02acd836d012acdbd3e070006', 'Y', '0', '019003002');
INSERT INTO `gsys_function` VALUES ('4028e48f2acfec53012ad069b1350001', 'F_sys_log', '日志管理', '日志管理包括登录日志、操作日志。用于跟踪用户的操作信息。', 'url', null, '40282ba02acd6d63012acd791d8a0001', 'Y', '0', '019004');
INSERT INTO `gsys_function` VALUES ('4028e48f2acfec53012ad0840c950002', 'F_sys_log_operate', '操作日志维护', '操作日志维护', 'url', '/system/log/gsysOperatelog/manage.vhtml', '4028e48f2acfec53012ad069b1350001', 'Y', '0', '019004001');
INSERT INTO `gsys_function` VALUES ('4028e48f2acfec53012ad0850ccf0003', 'F_sys_log_operate', '登入日志维护', '登入日志维护', 'url', '/system/log/gsysLoginlog/manage.vhtml', '4028e48f2acfec53012ad069b1350001', 'Y', '0', '019004002');
INSERT INTO `gsys_function` VALUES ('4028e48f2acfec53012ad0873b470004', 'F_sys_param', '参数管理', '系统参数设置管理。', 'url', null, '40282ba02acd6d63012acd791d8a0001', 'Y', '0', '019005');
INSERT INTO `gsys_function` VALUES ('4028e48f2acfec53012ad087a8790005', 'F_sys_param_setup', '系统参数设置', '系统参数设置。', 'url', '/system/param/gsysParameter/manage.vhtml', '4028e48f2acfec53012ad0873b470004', 'Y', '0', '019005001');
INSERT INTO `gsys_function` VALUES ('4028e48f2ad0c898012ad0d26d670001', 'F_sys_monitor', '系统监控', '系统运行性能分析、在线用户会话管理、网页分析.', 'url', null, '40282ba02acd6d63012acd791d8a0001', 'Y', '0', '019006');
INSERT INTO `gsys_function` VALUES ('4028e48f2ad0c898012ad0d34d280002', 'F_sys_monitor_session', '用户会话维护', '在线用户会话维护', 'url', '/system/systemInfo/onlineSessionList.vhtml', '4028e48f2ad0c898012ad0d26d670001', 'Y', '0', '019006001');
INSERT INTO `gsys_function` VALUES ('4028e48f2ad0c898012ad0d4e3780003', 'F_sys_monitor_performance', '性能监控', '系统运行性能监控', 'url', '/system/systemInfo/index.vhtml', '4028e48f2ad0c898012ad0d26d670001', 'Y', '0', '019006002');
INSERT INTO `gsys_function` VALUES ('4028e48f2ad25dac012ad265ceb90001', 'F_sys_authrize_resource', '资源设置', '系统资源维护', 'url', '/system/security/gsysResource/manage.vhtml', '40282ba02acd6d63012acd7e4cbf0002', 'Y', '102001002', '019001004');

-- ----------------------------
-- Table structure for `gsys_loginlog`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_loginlog`;
CREATE TABLE `gsys_loginlog` (
  `ID` varchar(32) NOT NULL COMMENT 'id',
  `LOGIN_IP` varchar(32) DEFAULT NULL COMMENT '登录IP',
  `CREATEDATE` datetime NOT NULL COMMENT '登录时间',
  `MESSAGE` longtext NOT NULL COMMENT '信息',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '登入用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登入日志';

-- ----------------------------
-- Records of gsys_loginlog
-- ----------------------------
INSERT INTO `gsys_loginlog` VALUES ('402881e84095d177014095d41c9b0001', '127.0.0.1', '2013-08-19 17:07:20', '登录成功!将转向http://localhost:8080/jeefuse-web/system/main.vhtml', '2c93faeb2c8b54ca012c8b6a70000007');

-- ----------------------------
-- Table structure for `gsys_operatelog`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_operatelog`;
CREATE TABLE `gsys_operatelog` (
  `ID` varchar(32) NOT NULL COMMENT 'id',
  `LOGIN_IP` varchar(32) DEFAULT NULL COMMENT '登录IP',
  `CREATEDATE` datetime NOT NULL COMMENT '创建时间',
  `MESSAGE` varchar(255) NOT NULL COMMENT '信息',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '操作用户',
  `KIND` varchar(10) NOT NULL COMMENT '类型',
  `DETAIL` longtext COMMENT '详细说明',
  PRIMARY KEY (`ID`),
  KEY `FK_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `gsys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of gsys_operatelog
-- ----------------------------

-- ----------------------------
-- Table structure for `gsys_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_parameter`;
CREATE TABLE `gsys_parameter` (
  `NAME` varchar(32) NOT NULL COMMENT '参数名',
  `VALUE` varchar(50) DEFAULT NULL COMMENT '参数值',
  `DESCRIPT` varchar(150) DEFAULT NULL COMMENT '用途说明',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数';

-- ----------------------------
-- Records of gsys_parameter
-- ----------------------------
INSERT INTO `gsys_parameter` VALUES ('appLogLevel', 'debug', '系统日志级别');
INSERT INTO `gsys_parameter` VALUES ('defaultSystemStyle', 'default', '默认系统风格');
INSERT INTO `gsys_parameter` VALUES ('onlineUserLimit', '50000', '在线用户限制');

-- ----------------------------
-- Table structure for `gsys_rel_role_function`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_rel_role_function`;
CREATE TABLE `gsys_rel_role_function` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `FUNCTION_ID` varchar(32) NOT NULL COMMENT '功能ID',
  PRIMARY KEY (`ID`),
  KEY `INDEX_ROLEFUNCTION_REL_ROLE` (`ROLE_ID`),
  KEY `INDEX_ROLEFUNCTION_REL_FUNCTION` (`FUNCTION_ID`),
  CONSTRAINT `FK_ROLEFUNCTION_REL_FUNCTION` FOREIGN KEY (`FUNCTION_ID`) REFERENCES `gsys_function` (`ID`),
  CONSTRAINT `FK_ROLEFUNCTION_REL_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `gsys_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_rel_role_function
-- ----------------------------
INSERT INTO `gsys_rel_role_function` VALUES ('000001', '40282ba02adb6370012adb7258a80001', '40282ba02acd6d63012acd791d8a0001');
INSERT INTO `gsys_rel_role_function` VALUES ('000002', '40282ba02adb6370012adb7258a80001', '40282ba02acd6d63012acd7e4cbf0002');
INSERT INTO `gsys_rel_role_function` VALUES ('000003', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acd9347f70001');
INSERT INTO `gsys_rel_role_function` VALUES ('000004', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acd945f810002');
INSERT INTO `gsys_rel_role_function` VALUES ('000005', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acd9e80f30003');
INSERT INTO `gsys_rel_role_function` VALUES ('000006', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acda120c30004');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a256000c', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd6d63012acd791d8a0001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a256000d', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd6d63012acd7e4cbf0002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a256000e', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acd945f810002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a256000f', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acd9347f70001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560010', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2ad25dac012ad265ceb90001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560011', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acd9e80f30003');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560012', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acda120c30004');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560013', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acdbd3e070006');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560014', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acd836d012acdbe72510007');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560015', '40282ba02adcad6a012adcedbf4e002a', '40282ba02acdd416012acdd74f300001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560016', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2acfec53012ad069b1350001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560017', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2acfec53012ad0840c950002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2560018', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2acfec53012ad0850ccf0003');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a2660019', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2acfec53012ad0873b470004');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a266001a', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2acfec53012ad087a8790005');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a266001b', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2ad0c898012ad0d26d670001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a266001c', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2ad0c898012ad0d34d280002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faea32715ca801327174a266001d', '40282ba02adcad6a012adcedbf4e002a', '4028e48f2ad0c898012ad0d4e3780003');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1520001', '40282ba02adb6370012adb7258a80001', '4028e48f2ad25dac012ad265ceb90001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710002', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acdbd3e070006');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710003', '40282ba02adb6370012adb7258a80001', '40282ba02acd836d012acdbe72510007');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710004', '40282ba02adb6370012adb7258a80001', '40282ba02acdd416012acdd74f300001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710005', '40282ba02adb6370012adb7258a80001', '4028e48f2acfec53012ad069b1350001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710006', '40282ba02adb6370012adb7258a80001', '4028e48f2acfec53012ad0840c950002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710007', '40282ba02adb6370012adb7258a80001', '4028e48f2acfec53012ad0850ccf0003');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710008', '40282ba02adb6370012adb7258a80001', '4028e48f2acfec53012ad0873b470004');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b1710009', '40282ba02adb6370012adb7258a80001', '4028e48f2acfec53012ad087a8790005');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b171000a', '40282ba02adb6370012adb7258a80001', '4028e48f2ad0c898012ad0d26d670001');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b171000b', '40282ba02adb6370012adb7258a80001', '4028e48f2ad0c898012ad0d34d280002');
INSERT INTO `gsys_rel_role_function` VALUES ('2c93faee2f9c9793012f9c98b171000c', '40282ba02adb6370012adb7258a80001', '4028e48f2ad0c898012ad0d4e3780003');

-- ----------------------------
-- Table structure for `gsys_rel_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_rel_role_resource`;
CREATE TABLE `gsys_rel_role_resource` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` varchar(32) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`ID`),
  KEY `ROLE_RESOURCE_REF_RESOURCE` (`RESOURCE_ID`),
  KEY `ROLE_RESOURCE_REF_ROLE` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_rel_role_resource
-- ----------------------------
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f40129129821ee0003', '40282b982891baaf012891bde077000f', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a20015', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d012910b92b590008');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a20016', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d0129108505010004');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a20017', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a20018', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d012910b850c70007');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a20019', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298b5a2001a', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291298ecb0001b', '40282b982891baaf012891bdf4f90013', '4028e48f29100c8d012910b938d60009');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291299891f001f', '40282b98291289f401291299890f001c', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291299891f0020', '40282b98291289f401291299890f001c', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291299891f0021', '40282b98291289f401291299890f001c', '4028e48f29100c8d012910b938d60009');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b98291289f401291299891f0022', '40282b98291289f401291299890f001c', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b982912a32c012912ad5a9c000c', '40282b98291283190129128476780001', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b982912a32c012912ad5a9c000d', '40282b98291283190129128476780001', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b982912a32c012912ad5a9c000e', '40282b98291283190129128476780001', '4028e48f29100c8d012910b850c70007');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b982912a32c012912ad5a9c000f', '40282b98291283190129128476780001', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce8328c0006', '40282b9829bcbddc0129bce8328c0005', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce8328c0007', '40282b9829bcbddc0129bce8328c0005', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce8328c0008', '40282b9829bcbddc0129bce8328c0005', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce8328c0009', '40282b9829bcbddc0129bce8328c0005', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce8328c000a', '40282b9829bcbddc0129bce8328c0005', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce83de6000c', '40282b9829bcbddc0129bce83dc7000b', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce83de6000d', '40282b9829bcbddc0129bce83dc7000b', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce83de6000e', '40282b9829bcbddc0129bce83dc7000b', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce83df6000f', '40282b9829bcbddc0129bce83dc7000b', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce83df60010', '40282b9829bcbddc0129bce83dc7000b', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce848180012', '40282b9829bcbddc0129bce848080011', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce848180013', '40282b9829bcbddc0129bce848080011', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce848180014', '40282b9829bcbddc0129bce848080011', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce848180015', '40282b9829bcbddc0129bce848080011', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bce848180016', '40282b9829bcbddc0129bce848080011', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceba5e90295', '40282b9829bcbddc0129bceba58b0242', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceba5f80296', '40282b9829bcbddc0129bceba58b0242', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceba5f80297', '40282b9829bcbddc0129bceba58b0242', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceba5f80298', '40282b9829bcbddc0129bceba58b0242', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceba5f80299', '40282b9829bcbddc0129bceba58b0242', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcec892502ed', '40282b9829bcbddc0129bcec88d6029a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcec892502ee', '40282b9829bcbddc0129bcec88d6029a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcec892502ef', '40282b9829bcbddc0129bcec88d6029a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcec892502f0', '40282b9829bcbddc0129bcec88d6029a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcec892502f1', '40282b9829bcbddc0129bcec88d6029a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca0e30345', '40282b9829bcbddc0129bcec8e8402f2', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca0f20346', '40282b9829bcbddc0129bcec8e8402f2', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca0f20347', '40282b9829bcbddc0129bcec8e8402f2', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca0f20348', '40282b9829bcbddc0129bcec8e8402f2', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca0f20349', '40282b9829bcbddc0129bcec8e8402f2', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca7c8039d', '40282b9829bcbddc0129bceca78a034a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca7d8039e', '40282b9829bcbddc0129bceca78a034a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca7d8039f', '40282b9829bcbddc0129bceca78a034a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca7d803a0', '40282b9829bcbddc0129bceca78a034a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceca7d803a1', '40282b9829bcbddc0129bceca78a034a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecad4703f5', '40282b9829bcbddc0129bcecacca03a2', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecad4703f6', '40282b9829bcbddc0129bcecacca03a2', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecad4703f7', '40282b9829bcbddc0129bcecacca03a2', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecad4703f8', '40282b9829bcbddc0129bcecacca03a2', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecad4703f9', '40282b9829bcbddc0129bcecacca03a2', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb2a6044d', '40282b9829bcbddc0129bcecb23803fa', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb2a6044e', '40282b9829bcbddc0129bcecb23803fa', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb2a6044f', '40282b9829bcbddc0129bcecb23803fa', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb2a60450', '40282b9829bcbddc0129bcecb23803fa', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb2a60451', '40282b9829bcbddc0129bcecb23803fa', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb78804a5', '40282b9829bcbddc0129bcecb7390452', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb78804a6', '40282b9829bcbddc0129bcecb7390452', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb78804a7', '40282b9829bcbddc0129bcecb7390452', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb78804a8', '40282b9829bcbddc0129bcecb7390452', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecb78804a9', '40282b9829bcbddc0129bcecb7390452', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecbc6a04fd', '40282b9829bcbddc0129bcecbbfc04aa', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecbc6a04fe', '40282b9829bcbddc0129bcecbbfc04aa', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecbc6a04ff', '40282b9829bcbddc0129bcecbbfc04aa', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecbc6a0500', '40282b9829bcbddc0129bcecbbfc04aa', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecbc6a0501', '40282b9829bcbddc0129bcecbbfc04aa', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc10d0555', '40282b9829bcbddc0129bcecc0bf0502', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc10d0556', '40282b9829bcbddc0129bcecc0bf0502', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc10d0557', '40282b9829bcbddc0129bcecc0bf0502', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc10d0558', '40282b9829bcbddc0129bcecc0bf0502', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc10d0559', '40282b9829bcbddc0129bcecc0bf0502', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc62e05ad', '40282b9829bcbddc0129bcecc5d0055a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc62e05ae', '40282b9829bcbddc0129bcecc5d0055a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc63d05af', '40282b9829bcbddc0129bcecc5d0055a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc63d05b0', '40282b9829bcbddc0129bcecc5d0055a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecc63d05b1', '40282b9829bcbddc0129bcecc5d0055a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccad10605', '40282b9829bcbddc0129bcecca9305b2', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccad10606', '40282b9829bcbddc0129bcecca9305b2', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccad10607', '40282b9829bcbddc0129bcecca9305b2', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccad10608', '40282b9829bcbddc0129bcecca9305b2', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccad10609', '40282b9829bcbddc0129bcecca9305b2', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccf36065d', '40282b9829bcbddc0129bcecced8060a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccf36065e', '40282b9829bcbddc0129bcecced8060a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccf36065f', '40282b9829bcbddc0129bcecced8060a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccf360660', '40282b9829bcbddc0129bcecced8060a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceccf360661', '40282b9829bcbddc0129bcecced8060a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecd37c06b5', '40282b9829bcbddc0129bcecd31e0662', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecd37c06b6', '40282b9829bcbddc0129bcecd31e0662', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecd37c06b7', '40282b9829bcbddc0129bcecd31e0662', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecd37c06b8', '40282b9829bcbddc0129bcecd31e0662', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecd37c06b9', '40282b9829bcbddc0129bcecd31e0662', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecdca4070d', '40282b9829bcbddc0129bcecdc3606ba', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecdca4070e', '40282b9829bcbddc0129bcecdc3606ba', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecdca4070f', '40282b9829bcbddc0129bcecdc3606ba', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecdca40710', '40282b9829bcbddc0129bcecdc3606ba', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecdca40711', '40282b9829bcbddc0129bcecdc3606ba', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece1b40765', '40282b9829bcbddc0129bcece1570712', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece1b40766', '40282b9829bcbddc0129bcece1570712', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece1b40767', '40282b9829bcbddc0129bcece1570712', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece1b40768', '40282b9829bcbddc0129bcece1570712', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece1b40769', '40282b9829bcbddc0129bcece1570712', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece67707bd', '40282b9829bcbddc0129bcece629076a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece67707be', '40282b9829bcbddc0129bcece629076a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece67707bf', '40282b9829bcbddc0129bcece629076a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece67707c0', '40282b9829bcbddc0129bcece629076a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcece67707c1', '40282b9829bcbddc0129bcece629076a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceceafb0815', '40282b9829bcbddc0129bcecea9e07c2', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceceafb0816', '40282b9829bcbddc0129bcecea9e07c2', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceceafb0817', '40282b9829bcbddc0129bcecea9e07c2', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceceafb0818', '40282b9829bcbddc0129bcecea9e07c2', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bceceafb0819', '40282b9829bcbddc0129bcecea9e07c2', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecf0a9086d', '40282b9829bcbddc0129bcecf06a081a', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecf0a9086e', '40282b9829bcbddc0129bcecf06a081a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecf0a9086f', '40282b9829bcbddc0129bcecf06a081a', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecf0a90870', '40282b9829bcbddc0129bcecf06a081a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('40282b9829bcbddc0129bcecf0a90871', '40282b9829bcbddc0129bcecf06a081a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f2910c59d012910d9e304000f', '40282b982891baaf012891bdd309000d', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f2910c59d012910d9e3040010', '40282b982891baaf012891bdd309000d', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f291124d501291146097b0002', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29114e0501291151b1100006', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29114e0501291151b12f0007', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d0129108505010004');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29114e0501291151b12f0008', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d012910b938d60009');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29114e05012911530a180009', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29114e05012911530a27000a', '40282b982891baaf012891bdc87a000a', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129115f2fb60003', '40282b982891baaf012891bdc1170008', '4028e48f29100c8d012910847d430002');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129115f2fd60004', '40282b982891baaf012891bdc1170008', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116d040e0005', '40282b982891baaf012891bdef7a0012', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116d040e0006', '40282b982891baaf012891bdef7a0012', '4028e48f29100c8d012910b8111f0005');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116d040e0007', '40282b982891baaf012891bdef7a0012', '4028e48f29100c8d012910b850c70007');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116d040e0008', '40282b982891baaf012891bdef7a0012', '4028e48f29100c8d01291084e2950003');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116d040e0009', '40282b982891baaf012891bdef7a0012', '4028e48f29100c8d012910b8427f0006');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116db4c10010', '4028e48f29115e2a0129116d85e1000a', '4028e48f29100c8d012910bde53f000a');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116db4c10011', '4028e48f29115e2a0129116d85e1000a', '4028e48f29100c8d012910b938d60009');
INSERT INTO `gsys_rel_role_resource` VALUES ('4028e48f29115e2a0129116db4c10012', '4028e48f29115e2a0129116d85e1000a', '4028e48f29100c8d0129108467e60001');
INSERT INTO `gsys_rel_role_resource` VALUES ('ff8080812c173dff012c174024280002', '40282ba02adb6370012adb7258a80001', '40282ba02ae24760012ae24ed4050002');
INSERT INTO `gsys_rel_role_resource` VALUES ('ff8080812c173dff012c174024280003', '40282ba02adb6370012adb7258a80001', '40282ba02ae24760012ae24c4f000001');
INSERT INTO `gsys_rel_role_resource` VALUES ('ff8080812c173dff012c174024280004', '40282ba02adb6370012adb7258a80001', '40282ba02ae24760012ae252501c0003');

-- ----------------------------
-- Table structure for `gsys_rel_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_rel_user_role`;
CREATE TABLE `gsys_rel_user_role` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`),
  KEY `USER_ROLE_REF_ROLE` (`ROLE_ID`),
  KEY `USER_ROLE_REF_USER` (`USER_ID`),
  CONSTRAINT `FK_USER_ROLE_REF_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `gsys_role` (`ID`) ON DELETE NO ACTION,
  CONSTRAINT `FK_USER_ROLE_REF_USER` FOREIGN KEY (`USER_ID`) REFERENCES `gsys_user` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_rel_user_role
-- ----------------------------
INSERT INTO `gsys_rel_user_role` VALUES ('2c93fae6316f1da501316f23afb80004', '40282ba02add09dc012add0d8c4c0002', '2c93fae6316f1da501316f23af790003');
INSERT INTO `gsys_rel_user_role` VALUES ('2c93faeb2c8b54ca012c8b6a704e0008', '40282ba02adb6370012adb7258a80001', '2c93faeb2c8b54ca012c8b6a70000007');
INSERT INTO `gsys_rel_user_role` VALUES ('402881e840948ecf0140949303300005', '40282ba02add09dc012add0d8c4c0002', '402881e840948ecf0140949303210004');
INSERT INTO `gsys_rel_user_role` VALUES ('ff8080812ae6fe5b012ae6feea010002', '40282ba02adb6370012adb7258a80001', 'ff8080812ae6fe5b012ae6fee9260001');
INSERT INTO `gsys_rel_user_role` VALUES ('ff8080812ae6fe5b012ae70048780004', '40282ba02adcad6a012adcedbf4e002a', 'ff8080812ae6fe5b012ae70048680003');

-- ----------------------------
-- Table structure for `gsys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_resource`;
CREATE TABLE `gsys_resource` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `descript` varchar(255) DEFAULT NULL COMMENT '描述',
  `value` varchar(200) NOT NULL COMMENT '资源匹配值',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_resource
-- ----------------------------
INSERT INTO `gsys_resource` VALUES ('40282ba02ae24760012ae24c4f000001', '网站URL', '网站WEB ACTION请求URL匹配', '/site/*', '1');
INSERT INTO `gsys_resource` VALUES ('40282ba02ae24760012ae24ed4050002', '后台系统管理', '后台系统管理WEB ACTION请求URL匹配', '/system/*', '1');
INSERT INTO `gsys_resource` VALUES ('40282ba02ae24760012ae252501c0003', 'WebService服务', 'WebService服务请求URL匹配', '/service/*', '3');

-- ----------------------------
-- Table structure for `gsys_role`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_role`;
CREATE TABLE `gsys_role` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `NAME` varchar(40) NOT NULL COMMENT '名称',
  `DISPLAY_NAME` varchar(40) DEFAULT NULL COMMENT '显示名称',
  `DESCRIPT` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gsys_role
-- ----------------------------
INSERT INTO `gsys_role` VALUES ('2c93faea324d572501324d68c96b0004', 'r_platform_manager', '平台管理员', '平台管理员负债维护平台的正常运营、审核用户注册、发布的信息等.');
INSERT INTO `gsys_role` VALUES ('40282ba02adb6370012adb7258a80001', 'r_super_manager', '超级管理员', '超级管理员拥有所有权限');
INSERT INTO `gsys_role` VALUES ('40282ba02adcad6a012adcedbf4e002a', 'r_sys_manager', '系统管理员', '系统管理员负责系统的日常维护，监控系统的运行情况，分配系统权限。');
INSERT INTO `gsys_role` VALUES ('40282ba02add09dc012add0d8c4c0002', 'r_user', '普通用户', '普通用户');

-- ----------------------------
-- Table structure for `gsys_user`
-- ----------------------------
DROP TABLE IF EXISTS `gsys_user`;
CREATE TABLE `gsys_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `email` varchar(50) DEFAULT NULL COMMENT 'Email',
  `level` varchar(1) DEFAULT NULL COMMENT '级别',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话',
  `telephone` varchar(60) DEFAULT NULL,
  `enabled` tinyint(4) NOT NULL COMMENT '有效性',
  `activated` tinyint(4) NOT NULL COMMENT '是否激活',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `portrait_photo` varchar(120) DEFAULT NULL COMMENT '头像',
  `portrait_photo_save_path` varchar(120) DEFAULT NULL COMMENT '头像保存实际地址',
  PRIMARY KEY (`id`),
  KEY `pk_gsys_suer_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of gsys_user
-- ----------------------------
INSERT INTO `gsys_user` VALUES ('2c93fae6316f1da501316f23af790003', 'test1107281', '2011-07-28 13:07:14', 'goolovdining2@163.com', '1', '2010-12-07 21:36:42', 'test1107281', '33ea640c4ad99756441a0ccfa2e77be8', null, '1', null, null, '1', '1', '2011-08-22 00:00:00', null, null);
INSERT INTO `gsys_user` VALUES ('2c93faeb2c8b54ca012c8b6a70000007', '超级管理员', '2010-11-27 11:39:57', 'goolovdining2@163.com', '1', '2011-08-10 11:54:30', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'find you life bright!', '0', '13111111111', '1123112', '1', '0', '2013-08-19 17:07:20', 'userFiles/2c93faeb2c8b54ca012c8b6a70000007/certification/13129484703283uhy.jpg', 'F:\\workspace\\dev\\cater-web\\webapp\\userFiles\\2c93faeb2c8b54ca012c8b6a70000007\\certification\\13129484703283uhy.jpg');
INSERT INTO `gsys_user` VALUES ('402881e840948ecf0140949303210004', 'test', '2013-08-19 11:16:37', 'test1@gmail.com', null, '2013-08-19 11:16:37', 'test1', '098f6bcd4621d373cade4e832627b4f6', 'test1', '0', null, '', '1', '1', null, null, null);
INSERT INTO `gsys_user` VALUES ('ff8080812ae6fe5b012ae6fee9260001', '超级管理员', '2010-09-06 20:21:59', 'congenlv@gmail.com', '1', '2010-11-27 11:39:00', 'admin12', '21232f297a57a5a743894a0e4a801fc3', 'stay hungry stay foolish!', '0', '', null, '1', '0', '2011-08-08 15:51:45', null, null);
INSERT INTO `gsys_user` VALUES ('ff8080812ae6fe5b012ae70048680003', '开发人员', '2010-09-06 20:23:29', 'dev@gmail.com', '1', '2010-09-07 08:45:59', 'dev01', 'dev00001', '开发人员', '1', '', null, '1', '0', '2011-08-08 15:51:45', null, null);
