/*
Navicat MySQL Data Transfer

Source Server         : JQ
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : iris

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-07 09:52:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datasource
-- ----------------------------
DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource` (
  `id` varchar(32) NOT NULL,
  `data_Source` varchar(255) DEFAULT NULL COMMENT '数据源',
  `drive` varchar(255) DEFAULT 'com.mysql.jdbc.Driver' COMMENT '驱动',
  `url` varchar(255) DEFAULT 'jdbc:mysql://localhost:3306/test?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8' COMMENT '链接',
  `username` varchar(255) DEFAULT 'root' COMMENT '用户名',
  `password` varchar(255) DEFAULT 'root' COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datasource
-- ----------------------------
INSERT INTO `datasource` VALUES ('1', 'ds1', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test1?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8', 'root', 'root');
INSERT INTO `datasource` VALUES ('2', 'ds2', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test2?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8', 'root', 'root');
INSERT INTO `datasource` VALUES ('3', 'ds3', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test3?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8', 'root', 'root');
INSERT INTO `datasource` VALUES ('4', 'ds4', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test4?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8', 'root', 'root');
INSERT INTO `datasource` VALUES ('5', 'ds5', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test5?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8', 'root', 'root');

-- ----------------------------
-- Table structure for jq_sms_text
-- ----------------------------
DROP TABLE IF EXISTS `jq_sms_text`;
CREATE TABLE `jq_sms_text` (
  `id` varchar(64) DEFAULT NULL COMMENT '001;PK',
  `in_date` datetime DEFAULT NULL COMMENT '002;登录日期',
  `in_rmk` varchar(32) DEFAULT '' COMMENT '003;登录者',
  `re_date` datetime DEFAULT NULL COMMENT '004;修改日期',
  `re_rmk` varchar(32) DEFAULT '' COMMENT '005;修改者',
  `status` bit(1) DEFAULT b'1' COMMENT '006;状态',
  `version` int(11) DEFAULT '0' COMMENT '007;版本号',
  `sys_code` varchar(20) DEFAULT '' COMMENT '008;系统代码',
  `locale` varchar(20) DEFAULT '' COMMENT '009;语言代码',
  `mobile` varchar(45) DEFAULT '' COMMENT '010;手机号',
  `code` varchar(45) DEFAULT '' COMMENT '010;代码',
  `contact` varchar(500) DEFAULT NULL COMMENT '内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短消息表';

-- ----------------------------
-- Records of jq_sms_text
-- ----------------------------
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');
INSERT INTO `jq_sms_text` VALUES ('S17112300000001', '2017-11-23 17:45:37', '3bb14fc27abe11e795fac85b76c18af8', null, '', '', '0', 'SYS_001', 'zh_CN', '18221452610', 'S17112300000001', '屏幕刮花');

-- ----------------------------
-- Table structure for submission
-- ----------------------------
DROP TABLE IF EXISTS `submission`;
CREATE TABLE `submission` (
  `id` varchar(32) NOT NULL,
  `content` longtext COMMENT 'SQL内容',
  `status` int(11) DEFAULT '0' COMMENT '1/审核通过 0/审核不通过',
  `owner_id` varchar(32) DEFAULT NULL COMMENT '提交人ID',
  `auditor_id` varchar(32) DEFAULT NULL COMMENT '审核人ID',
  `modify` datetime DEFAULT NULL COMMENT '最后修改时间',
  `execution` varchar(255) DEFAULT NULL COMMENT '执行操作',
  `query` longtext COMMENT '查询语句',
  `execution_time` datetime DEFAULT NULL COMMENT '执行时间',
  `results` varchar(255) DEFAULT NULL COMMENT '执行结果',
  `query_results` varchar(255) DEFAULT NULL COMMENT '查询结果',
  `overdue_results` varchar(255) DEFAULT NULL COMMENT '预期结果',
  `data_Source` varchar(255) DEFAULT NULL COMMENT '数据源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submission
-- ----------------------------
INSERT INTO `submission` VALUES ('19c5fbef4801415e99eb5573ac38d693', 'INSERT INTO `test`.`fox_pending_parts` (\r\n	`id`,\r\n	`create_time`,\r\n	`last_update_time`,\r\n	`activeFl`,\r\n	`capacity`,\r\n	`capacity_code`,\r\n	`color`,\r\n	`color_cn`,\r\n	`color_code`,\r\n	`color_en`,\r\n	`description`,\r\n	`model`,\r\n	`model_number`,\r\n	`part_number`,\r\n	`product_name`,\r\n	`production_area`,\r\n	`production_area_cn`,\r\n	`production_area_code`,\r\n	`sku`,\r\n	`unified_model`,\r\n	`sku_update_time`,\r\n	`acc_dc`,\r\n	`material_status`,\r\n	`material_source`,\r\n	`sns`\r\n)\r\nVALUES\r\n	(\r\n		\'5\',\r\n		\'2017-07-25 00:55:44\',\r\n		\'2017-07-25 00:55:48\',\r\n		\'0\',\r\n		\'16GB\',\r\n		\'4\',\r\n		\'ROSE GOLD\',\r\n		\'黑色\',\r\n		\'B\',\r\n		\'BlACK\',\r\n		\'221\',\r\n		\'iPad\',\r\n		\'1\',\r\n		\'1\',\r\n		\'1\',\r\n		\'NON_GC\',\r\n		\'1\',\r\n		\'1\',\r\n		\'11\',\r\n		\'1\',\r\n		\'2017-07-25 00:57:32\',\r\n		\'2\',\r\n		\'11\',\r\n		\'DRAFT \',\r\n		\'F1,F2\'\r\n	)\r\n\r\n', '1', '12', '2', '2018-05-06 20:35:00', 'insert', 'select count(1) from jq_sms_text ', '2018-05-06 20:35:05', null, '7', '1', 'ds2');
INSERT INTO `submission` VALUES ('30754192e5664c64b583a80d5a743724', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '2', '2018-05-04 10:39:51', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('35372907ad344840b142164f9c2c9bb9', 'UPDATE area\r\n								SET id = \'402881a63aea2ddb013aea52f23e30c7\',\r\n								 name = \'安徽省\',\r\n								 level = \'0\',\r\n								 parent_id = NULL\r\n								WHERE\r\n									(\r\n										id = \'402881a63aea2ddb013aea52f23e30c7\'\r\n									)', '1', '12', null, '2018-05-03 15:17:28', 'update', 'select count(1) from area WHERE\r\n							(\r\n								id = \'402881a63aea2ddb013aea52f23e30c7\'\r\n							)', null, null, null, null, 'ds2');
INSERT INTO `submission` VALUES ('35b0ad8772c944c9adab9557671d489a', 'INSERT INTO `iris`.`jq_sms_text` (\r\n	`id`,\r\n	`in_date`,\r\n	`in_rmk`,\r\n	`re_date`,\r\n	`re_rmk`,\r\n	`status`,\r\n	`version`,\r\n	`sys_code`,\r\n	`locale`,\r\n	`mobile`,\r\n	`code`,\r\n	`contact`\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)\r\n\r\n', '1', '12', '2', '2018-05-04 10:36:11', 'insert', 'select count(1) from area WHERE\r\n							(\r\n								id = \'402881a63aea2ddb013aea52f23e30c7\'\r\n							)', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('6e9d16b922e147fc8d8fad52b0b2fd19', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '2', '2018-05-04 10:38:44', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('7bd8674795ea4b258e8fd20e249eee8e', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '11', '2018-05-04 10:40:28', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('809162e1821e4b288e65827be3c53348', 'INSERT INTO `jq_sys_user` (`id`, `in_date`, `in_rmk`, `re_date`, `re_rmk`, `status`, `org_id`, `password`, `username`, `display_name`, `login_date`, `login_ip`, `login_failure_count`, `is_account_locked`, `locked_date`, `phone`, `email`, `address`, `version`, `sys_code`, `locale`, `is_enable`, `is_system`, `theme`) VALUES (\'2\', \'2017-07-07 18:22:50\', \'1\', \'2017-07-17 00:51:46\', \'1\', \'\', NULL, \'3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d\', \'gjk001\', \'高健康\', NULL, NULL, NULL, \'\\0\', NULL, \'18221452610\', \'111@11.com\', \'\', \'1\', \'SYS_001\', NULL, \'\', \'\\0\', \'\');\r\n', '1', '12', '2', '2018-05-06 20:22:37', 'insert', 'select count(*) from jq_sys_user', '2018-05-06 20:24:41', null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('877f2acebf0e4126a0532782f74627b1', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '2', '2018-05-04 10:44:03', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('d5f103ebfd574523b7dee0fc0a54bd92', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '1', '2018-05-04 10:40:05', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');
INSERT INTO `submission` VALUES ('eaa25e2df8434cf0aecc6f5f73766efb', 'INSERT INTO jq_sms_text (\r\n	id,\r\n	in_date,\r\n	in_rmk,\r\n	re_date,\r\n	re_rmk,\r\n	status,\r\n	version,\r\n	sys_code,\r\n	locale,\r\n	mobile,\r\n	code,\r\n	contact\r\n)\r\nVALUES\r\n	(\r\n		\'S17112300000001\',\r\n		\'2017-11-23 17:45:37\',\r\n		\'3bb14fc27abe11e795fac85b76c18af8\',\r\n		NULL,\r\n		\'\',\r\n		\'\',\r\n		\'0\',\r\n		\'SYS_001\',\r\n		\'zh_CN\',\r\n		\'18221452610\',\r\n		\'S17112300000001\',\r\n		\'屏幕刮花\'\r\n	)', '1', '12', '3', '2018-05-04 10:39:58', 'insert', 'select count(1) from jq_sms_text', null, null, null, '1', 'ds2');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `p_id` bigint(11) DEFAULT NULL COMMENT '父部门id',
  `p_ids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `name` varchar(45) DEFAULT NULL COMMENT '简称',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `temp` varchar(255) DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '1', '0', '[0]', 'Iris集团总公司', 'Iris集团总公司', 'aaa', null);
INSERT INTO `sys_dept` VALUES ('15', '1', '1', '[0],[1]', '广东分公司', '广东分公司', '广东', null);
INSERT INTO `sys_dept` VALUES ('17', '3', '1', '[0],[1]', '湖北分公司', '湖北分公司', '湖北', null);
INSERT INTO `sys_dept` VALUES ('19', '1', '15', '[0],[1],[15]', '广东党委组织部', '广东党委组织部', '广东党委组织部', null);
INSERT INTO `sys_dept` VALUES ('20', '2', '1', '[0],[1]', '广西分公司', '广西分公司', '广西分公司', null);
INSERT INTO `sys_dept` VALUES ('21', '4', '1', '[0],[1]', '湖南分公司', '湖南分公司', '湖南分公司', null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '编号',
  `p_id` bigint(20) DEFAULT NULL COMMENT '菜单父编号',
  `p_ids` varchar(255) DEFAULT NULL COMMENT '所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `levels` int(5) DEFAULT NULL COMMENT '菜单层级',
  `is_menu` int(2) DEFAULT NULL COMMENT '菜单/按钮:1-菜单,0-按钮',
  `others` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT NULL COMMENT '菜单状态:1-启用,0-不启用',
  `is_open` int(2) DEFAULT NULL COMMENT '默认打开:1-是,0-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'sys', '0', '[0]', '系统管理', 'fa fa-cogs', null, '1', '1', '备注11', '1', '1');
INSERT INTO `sys_menu` VALUES ('2', 'usermgr', '1', '[0],[1]', '用户管理', 'fa fa-user', '/user/index', '2', '1', '用户', '1', '1');
INSERT INTO `sys_menu` VALUES ('3', 'menumgr', '1', '[0],[1]', '菜单管理', 'fa fa-sort-amount-desc', '/menu/index', '2', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('4', 'deptmgr', '1', '[0],[1]', '机构管理', 'fa fa-university', '/dept/index', '2', '1', '机构', '1', '1');
INSERT INTO `sys_menu` VALUES ('10', 'test1', '1', '[0],[1]', '测试1', 'fa fa-exchange', 'test1', '2', '1', 'test1', '1', '0');
INSERT INTO `sys_menu` VALUES ('11', 'test1-1', '10', '[0],[1],[10]', '测试1-1', 'bank', 'test1-1', '3', '1', 'test1-1', '1', '0');
INSERT INTO `sys_menu` VALUES ('12', 'rolemgr', '1', '[0],[1]', '角色管理', 'fa fa-user-secret', '/role/index', '2', '1', '角色', '1', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `remarks` varchar(255) DEFAULT NULL COMMENT '提示',
  `temp1` varchar(255) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '1', '备注111', null);
INSERT INTO `sys_role` VALUES ('2', '提交角色1', '21', '提交角色', null);
INSERT INTO `sys_role` VALUES ('3', '审核角色1', '1', '审核角色', null);
INSERT INTO `sys_role` VALUES ('4', '测试1', '21', '党1', null);
INSERT INTO `sys_role` VALUES ('6', '啦啦啦', '20', '啊啊啊', null);

-- ----------------------------
-- Table structure for sys_role2menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role2menu`;
CREATE TABLE `sys_role2menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role2menu
-- ----------------------------
INSERT INTO `sys_role2menu` VALUES ('18', '1', '1');
INSERT INTO `sys_role2menu` VALUES ('19', '2', '1');
INSERT INTO `sys_role2menu` VALUES ('20', '3', '1');
INSERT INTO `sys_role2menu` VALUES ('21', '4', '1');
INSERT INTO `sys_role2menu` VALUES ('22', '5', '1');
INSERT INTO `sys_role2menu` VALUES ('23', '12', '1');
INSERT INTO `sys_role2menu` VALUES ('24', '1', '3');
INSERT INTO `sys_role2menu` VALUES ('25', '2', '3');
INSERT INTO `sys_role2menu` VALUES ('26', '3', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_acc` varchar(255) DEFAULT NULL COMMENT '账号',
  `user_psw` varchar(255) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `role_id` varchar(255) DEFAULT NULL,
  `dept_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '叛逆的逆', null, '2017-12-08 15:04:18', '描述~~~~', null, '1', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'wnl', '123456', '王大锤', null, '2017-12-21 15:04:18', '111', null, '1', '1', '1');
INSERT INTO `sys_user` VALUES ('8', 'test2', '111', '测试人员2', null, '2018-01-30 16:08:49', '123', null, '1', '1', '1');
INSERT INTO `sys_user` VALUES ('11', 'haha', '123', '哈哈哈1', null, '2018-03-19 10:28:29', '啊', null, '1', '1', '17');
INSERT INTO `sys_user` VALUES ('12', 'yxh', '123456', 'yxh', null, '2018-05-02 21:59:50', 'yxh', null, '1', '1', '20');
