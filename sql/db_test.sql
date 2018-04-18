/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : db_test

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-04-18 23:42:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_adinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_adinfo`;
CREATE TABLE `t_adinfo` (
  `c_id` varchar(32) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_adinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `t_blacklist`;
CREATE TABLE `t_blacklist` (
  `c_id` varchar(32) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for t_chatinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_chatinfo`;
CREATE TABLE `t_chatinfo` (
  `c_id` varchar(32) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chatinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_jianliinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_jianliinfo`;
CREATE TABLE `t_jianliinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_name` varchar(300) DEFAULT NULL,
  `n_xl` int(11) DEFAULT NULL,
  `n_xb` int(11) DEFAULT NULL,
  `n_gzjy` int(11) DEFAULT NULL,
  `c_sjhm` varchar(300) DEFAULT NULL,
  `c_yx` varchar(300) DEFAULT NULL,
  `c_qwgzdz` varchar(300) DEFAULT NULL,
  `n_gzxz` int(11) DEFAULT NULL,
  `c_qwzw` varchar(300) DEFAULT NULL,
  `n_qwyx` int(11) DEFAULT NULL,
  `c_gsmc` varchar(300) DEFAULT NULL,
  `c_zwmc` varchar(300) DEFAULT NULL,
  `c_xxmc` varchar(300) DEFAULT NULL,
  `n_xxxl` int(11) DEFAULT NULL,
  `c_zymc` varchar(300) DEFAULT NULL,
  `dt_kssj` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dt_jssj` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `c_zwms` varchar(300) DEFAULT NULL,
  `c_jlmc` varchar(300) DEFAULT NULL,
  `c_zp` varchar(300) DEFAULT NULL,
  `c_syzid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jianliinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_jobinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_jobinfo`;
CREATE TABLE `t_jobinfo` (
  `c_id` varchar(32) NOT NULL,
  `n_code` int(11) DEFAULT NULL,
  `c_zwmc` varchar(300) DEFAULT NULL,
  `n_gzxz` int(11) DEFAULT NULL,
  `n_yx` int(11) DEFAULT NULL,
  `n_gzjy` int(11) DEFAULT NULL,
  `n_xlyq` int(11) DEFAULT NULL,
  `c_zwms` varchar(300) DEFAULT NULL,
  `c_gzdz` varchar(300) DEFAULT NULL,
  `c_jsjlyx` varchar(300) DEFAULT NULL,
  `c_fbzid` varchar(32) DEFAULT NULL,
  `n_llcs` int(11) DEFAULT NULL,
  `n_zt` int(11) DEFAULT NULL,
  `dt_fbsj` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `n_yxzt` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jobinfo
-- ----------------------------
INSERT INTO `t_jobinfo` VALUES ('0a26ce1948b147cfa8ce70b48460422a', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', null, '1', '1', '2018-04-18 17:53:44', '1');
INSERT INTO `t_jobinfo` VALUES ('123123123', '1', '家教上门辅导数学', '1', '3000', '1', '1', '辅导小朋友数学', '南京农业大学', '2082242662@qq.com', '23642e5f2cd247428f94c79798853fc7', '5', '1', '2018-04-18 17:53:44', '1');
INSERT INTO `t_jobinfo` VALUES ('3f70fe4c4a7442e8b29b193426379afb', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', null, '3', '1', '2018-04-18 17:53:44', '1');
INSERT INTO `t_jobinfo` VALUES ('45747fd711a94cbfa0d74cb42d0b75f6', '1', '家教上门辅导数学', '1', '1000', '1', '1', '', ' 南京 南京农业大学 ', '755093231@qq.com', null, '2', '1', '2018-04-18 17:53:45', '1');
INSERT INTO `t_jobinfo` VALUES ('467bf3fbaf5f4453af954b9c433b55d2', '1', '家教上门辅导数学', '1', '1000', '1', '1', '', ' 南京 南京农业大学 ', '755093231@qq.com', null, '4', '1', '2018-04-18 17:53:46', '1');
INSERT INTO `t_jobinfo` VALUES ('b2387bfd10814cd29deef5a9b9ac25e7', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', null, '6', '1', '2018-04-18 17:55:50', '1');
INSERT INTO `t_jobinfo` VALUES ('b475b99d4165447296d7e0306d6e0a63', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', null, '5', '1', '2018-04-18 17:55:50', '1');
INSERT INTO `t_jobinfo` VALUES ('b4f87dfb9c1842959fdea1d7dec54858', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', null, '7', '1', '2018-04-18 17:55:51', '1');
INSERT INTO `t_jobinfo` VALUES ('bda61785438c44f5b6717e7629a25778', '1', '家教上门辅导数学', '1', '1000', '1', '1', '', ' 南京 南京农业大学 ', '755093231@qq.com', null, '9', '1', '2018-04-18 17:55:52', '1');
INSERT INTO `t_jobinfo` VALUES ('c3ab7f76151d483b93dfdfe84f1f3a67', '1', '家教上门辅导数学', '1', '1000', '1', '1', '辅导小朋友数学', ' 南京 南京农业大学 ', '755093231@qq.com', '1231231231312313123', '10', '1', '2018-04-18 17:55:53', '1');

-- ----------------------------
-- Table structure for t_jobtype
-- ----------------------------
DROP TABLE IF EXISTS `t_jobtype`;
CREATE TABLE `t_jobtype` (
  `c_id` varchar(32) NOT NULL,
  `c_jobtype1` varchar(300) DEFAULT NULL,
  `c_jobtype2` varchar(300) DEFAULT NULL,
  `c_jobtype3` varchar(300) DEFAULT NULL,
  `n_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jobtype
-- ----------------------------
INSERT INTO `t_jobtype` VALUES ('112131243', '家教', '托管班', '二年级', '5');
INSERT INTO `t_jobtype` VALUES ('1121312431', '校园兼职', '打扫类', '办公室打扫', '6');
INSERT INTO `t_jobtype` VALUES ('12312', '家教', '上门辅导', '数学', '1');
INSERT INTO `t_jobtype` VALUES ('123123123123', '商家兼职', '发单类', '发传单', '7');
INSERT INTO `t_jobtype` VALUES ('123qseaqwe', '家教', '上门辅导', '英语', '2');
INSERT INTO `t_jobtype` VALUES ('123qseaqwea', '家教', '托管班', '一年级', '4');
INSERT INTO `t_jobtype` VALUES ('123qseaqweasd', '家教', '上门辅导', '语文', '3');

-- ----------------------------
-- Table structure for t_receivejianliinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_receivejianliinfo`;
CREATE TABLE `t_receivejianliinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_jlid` varchar(32) DEFAULT NULL,
  `c_jobid` varchar(32) DEFAULT NULL,
  `n_zt` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_receivejianliinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_reportinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_reportinfo`;
CREATE TABLE `t_reportinfo` (
  `c_id` varchar(32) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reportinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_shenhelist
-- ----------------------------
DROP TABLE IF EXISTS `t_shenhelist`;
CREATE TABLE `t_shenhelist` (
  `c_id` varchar(255) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shenhelist
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `c_email` varchar(300) NOT NULL,
  `c_password` varchar(300) NOT NULL,
  `n_type` int(255) DEFAULT NULL,
  `c_id` varchar(32) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('3125341726@qq.com', '123123123', null, '0259b63d136e458fa9c200bdd54de03c');
INSERT INTO `t_user` VALUES ('755093231@qq.com', '123', '1', '1231231231312313123');
INSERT INTO `t_user` VALUES ('7550931@qq.com', '123123', '2', '23642e5f2cd247428f94c79798853fc7');

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_bh` varchar(300) DEFAULT NULL,
  `c_xm` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('', null, null);
