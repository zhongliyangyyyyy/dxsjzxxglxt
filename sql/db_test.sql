/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : db_test

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-31 12:34:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_adinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_adinfo`;
CREATE TABLE `t_adinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_zplj` varchar(300) DEFAULT NULL,
  `c_wzsm` varchar(300) DEFAULT NULL,
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
  `c_yhid` varchar(32) DEFAULT NULL,
  `dt_lhsj` timestamp NULL DEFAULT NULL,
  `c_reportid` varchar(32) DEFAULT NULL,
  `n_lhyy` int(11) DEFAULT NULL,
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
-- Table structure for t_commentinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_commentinfo`;
CREATE TABLE `t_commentinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_pjrid` varchar(32) NOT NULL,
  `c_bpjrid` varchar(32) NOT NULL,
  `c_bq` varchar(300) DEFAULT NULL,
  `c_pjnr` varchar(300) DEFAULT NULL,
  `dt_pjsj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `c_jobid` varchar(32) NOT NULL,
  `c_grade` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commentinfo
-- ----------------------------
INSERT INTO `t_commentinfo` VALUES ('0f47637fe69146aeb94b6ac2407c8f24', 'e0beb4b0c3f64e199fd4d213a5eca57d', '3593d5bfe80c412194b47f0e3dfe00e3', '有责任心,守时,专业知识丰富,兴趣爱好广泛,技能全面,技术大牛,', '不错不错不错', '2018-05-15 23:29:36', '6d68d58f89af4f089bc2f1a6a8f3661c', '4.6');
INSERT INTO `t_commentinfo` VALUES ('21dc9eade7234adba25c907d09ad89d3', '3593d5bfe80c412194b47f0e3dfe00e3', 'e0beb4b0c3f64e199fd4d213a5eca57d', '通宵津贴,', '', '2018-05-13 20:18:36', 'd55332911f444547b699a79efac0936f', '4.7');
INSERT INTO `t_commentinfo` VALUES ('45e54b7187f64402904b66c82a5de3db', 'e0beb4b0c3f64e199fd4d213a5eca57d', '3593d5bfe80c412194b47f0e3dfe00e3', '学习能力好,总结能力好,守时,兴趣爱好广泛,专业知识丰富,', '该学生不错，但是不太适合我们的职位。', '2018-05-15 23:29:14', 'e7bce060bad24341a62ebdd27d4b441c', '4.7');
INSERT INTO `t_commentinfo` VALUES ('9aacb10045194a5fb7ca2e2db3b5df45', 'e0beb4b0c3f64e199fd4d213a5eca57d', '3593d5bfe80c412194b47f0e3dfe00e3', '学习能力好,总结能力好,有礼貌,穿着得体,社交能力好,有责任心,专业知识丰富,兴趣爱好广泛,', '该学生学习能力强。', '2018-05-15 23:29:26', '9aa0970e319e4629869cdbd301a00343', '4.9');
INSERT INTO `t_commentinfo` VALUES ('ed8f4be0c16f4b1592cc364f7ad6e479', 'e0beb4b0c3f64e199fd4d213a5eca57d', '3593d5bfe80c412194b47f0e3dfe00e3', '学习能力好,总结能力好,有责任心,专业知识丰富,兴趣爱好广泛,', '不错', '2018-05-15 23:29:32', 'd55332911f444547b699a79efac0936f', '5.0');

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
  `c_zymc` varchar(300) DEFAULT NULL,
  `dt_kssj` timestamp NULL DEFAULT NULL,
  `dt_jssj` timestamp NULL DEFAULT NULL,
  `c_zwms` varchar(300) DEFAULT NULL,
  `c_jlmc` varchar(300) DEFAULT NULL,
  `c_zp` varchar(300) DEFAULT NULL,
  `c_syzid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jianliinfo
-- ----------------------------
INSERT INTO `t_jianliinfo` VALUES ('8ccc9203076545c98bd671ab192d1d16', '钟黎阳', '5', '1', '1', '15996248646', '755093231@qq.com', '南京农业大学附近', '1', '发单', '3000', '北京华宇信息技术有限公司', 'Java开发工程师', '南京农业大学', '计算机科学与技术', '2014-01-01 00:00:00', '2018-01-01 00:00:00', '我热爱运动，喜欢旅游，性格开朗乐观，热情友好，能吃苦耐劳，学习能力强。三年的校园学习生活经历使我积累了较强的组织、协调沟通能力和团队合作精神，具有较强的责任心。面对校外的实习机会我会努力认真的工作，积累更多的相关工作经验，能够在实习期间在处理问题时能够取得重大的提升，使自己更成熟。对事物有敏锐的洞察力，多次的社会实践经历及在学生会工作期间锻炼了我与人沟通合作的能力以及独立能力，做事认真负责。', '钟黎阳的简历', 'http%3A%5C%5Clocalhost%3A8080%5Cfile%5C49456a7957fa4809b1a3f6879e15dd8f.jpg', '3593d5bfe80c412194b47f0e3dfe00e3');

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
INSERT INTO `t_jobinfo` VALUES ('19da0af5ab974f2b8f5dbe6b162f0d9d', '10', '美食节活动', '1', '3000', '1', '1', '找这周周四周五周六周日连坐四天兼职，30名女生，5名男生。美食节活动很轻松。需要热情一点。\n早上10.00-晚上10.00可能提前下课。110块钱一天。不包饭。\n地点在学则路苏果旁边。做的事就是有人来卖吃的。没人来就偷偷休息，最多帮忙打下手。很轻松。\n【必须连坐四天】', '学则路', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:25', '1');
INSERT INTO `t_jobinfo` VALUES ('6d68d58f89af4f089bc2f1a6a8f3661c', '11', '收书', '1', '2500', '1', '3', '现招收书兼职人员，性别不限，只要你有能力，有激情，就加入我们吧！\n工作内容：扫楼收购二手书活动\n底薪+提成，1 折收旧课本，每人最多卖 5 本。收书费用公司会进行支付，无须兼职人员垫付。2 小时 20 元+推广 3--5 元/个提成。\n', '各个宿舍楼扫楼', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:28', '1');
INSERT INTO `t_jobinfo` VALUES ('9aa0970e319e4629869cdbd301a00343', '4', '一年级', '1', '500', '1', '3', '工作内容：去老师住的小区打电话通知业主参加会议，没有硬性要求，但是不要划水。\n工资：20元/h,可以给盖社会实践的章\n周一，早九点到晚五点（全天没有时间的话可以只工作上午或者下午）', '天泓山庄（51路车直达）', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:03', '1');
INSERT INTO `t_jobinfo` VALUES ('b9a2847a86894c3da8e50d3ff75761df', '6', '办公室打扫', '1', '1500', '1', '1', '每天定时打扫办公室卫生，要求有责任心，有时间观念。', '教学楼4楼', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-20 22:28:09', '1');
INSERT INTO `t_jobinfo` VALUES ('bc8fd7958e8746eebb80c6fbc6adbdfa', '13', '送餐', '1', '500', '1', '1', '（纤果屋水果捞）想找两个女生（最好是11舍或13舍）帮忙送水果捞。主要工作内容是送到南苑女生寝室。时间是每天下午5.50。每次大概10分钟左右。要求有责任心，能做满这个学期的。工资的话不太固定，每周每人50左右。购买水果捞有优惠！也会经常请你们吃的！', '南京农业大学11舍13舍', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:36', '1');
INSERT INTO `t_jobinfo` VALUES ('c2332f45faa24f8f9f46fcfbd416a1f9', '9', '发单类', '1', '2000', '2', '1', '周末美容连锁机构发单，需要3-5名男生，工资每小时30+提成（当天结算）\n地点在苜蓿园附近，有意愿请联系 13951756318 江经理 ', '苜蓿园附近', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:33', '1');
INSERT INTO `t_jobinfo` VALUES ('d55332911f444547b699a79efac0936f', '7', '发传单', '1', '1500', '1', '1', '下周周一到周四\n中午1点到1.30\n下午6点到6.30\n半小时左右，15块', '校内教室', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:31', '1');
INSERT INTO `t_jobinfo` VALUES ('e7bce060bad24341a62ebdd27d4b441c', '9', '发单类举牌', '1', '1500', '1', '1', '时间:5.12/5.13,11:00-3:30\n薪酬:60+团队每拉到一个人每人加2r，除此之外还有表现工资\n内容:举牌发单\n要求:中途可轻微休息，可是不能玩手机，然后总体还是比较轻松的，要求两天连着做', '夫子庙附近地铁口', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:20', '1');
INSERT INTO `t_jobinfo` VALUES ('f933f95bf57e4687b356c906a79645cd', '12', '宴会服务员', '1', '4000', '2', '3', '今天下午14:00-22:00婚礼宴会需要多名兼职服务员，15一小时，负责自助餐准备供给及餐后收拾，活不累，男女不限，提供工作餐，要求负责任，拒绝鸽子', '白马公园', '755093231@qq.com', 'e0beb4b0c3f64e199fd4d213a5eca57d', null, '2', '2018-05-09 11:03:23', '1');

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
INSERT INTO `t_jobtype` VALUES ('1267537615885', '其他', '小时工', '收书', '11');
INSERT INTO `t_jobtype` VALUES ('12863516786', '其他', '做活动', '美食节活动', '10');
INSERT INTO `t_jobtype` VALUES ('17826378162', '其他', '发单', '发单类', '9');
INSERT INTO `t_jobtype` VALUES ('18267351567', '其他', '外卖配送员', '送餐', '13');
INSERT INTO `t_jobtype` VALUES ('198726398176', '其他', '小时工', '宴会服务员', '12');
INSERT INTO `t_jobtype` VALUES ('sdkhaskjlhd', '其他', '小时工', 'ofo搬运', '8');

-- ----------------------------
-- Table structure for t_receivejianliinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_receivejianliinfo`;
CREATE TABLE `t_receivejianliinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_jlid` varchar(32) DEFAULT NULL,
  `c_jobid` varchar(32) DEFAULT NULL,
  `n_zt` int(11) DEFAULT NULL,
  `dt_tdsj` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dt_cksj` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_receivejianliinfo
-- ----------------------------
INSERT INTO `t_receivejianliinfo` VALUES ('0de4b1d61dc6464e9862414a62fe41d4', '8ccc9203076545c98bd671ab192d1d16', '9aa0970e319e4629869cdbd301a00343', '1', '2018-05-14 15:41:37', '2018-05-14 15:41:37');
INSERT INTO `t_receivejianliinfo` VALUES ('32a8b68a3a734328813970c48fe33d2b', '8ccc9203076545c98bd671ab192d1d16', 'e7bce060bad24341a62ebdd27d4b441c', '1', '2018-05-14 15:41:37', '2018-05-14 15:41:37');
INSERT INTO `t_receivejianliinfo` VALUES ('56d6d2229c2b4ce788f2f12273f27b9a', '8ccc9203076545c98bd671ab192d1d16', 'd55332911f444547b699a79efac0936f', '1', '2018-05-14 15:41:37', '2018-05-14 15:41:37');
INSERT INTO `t_receivejianliinfo` VALUES ('bfa8a7c0779b49a2a7ffcaa31cfc1c7d', '8ccc9203076545c98bd671ab192d1d16', '6d68d58f89af4f089bc2f1a6a8f3661c', '1', '2018-05-14 15:41:37', '2018-05-14 15:41:37');

-- ----------------------------
-- Table structure for t_reportinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_reportinfo`;
CREATE TABLE `t_reportinfo` (
  `c_id` varchar(32) NOT NULL,
  `n_jblx` int(11) DEFAULT NULL,
  `c_jbrid` varchar(32) DEFAULT NULL,
  `c_bjbrid` varchar(32) DEFAULT NULL,
  `c_jbrxm` varchar(300) DEFAULT NULL,
  `c_bjbrxm` varchar(300) DEFAULT NULL,
  `dt_jbsj` timestamp NULL DEFAULT NULL,
  `dt_clsj` timestamp NULL DEFAULT NULL,
  `n_cljg` int(11) DEFAULT NULL,
  `c_jbnr` varchar(300) DEFAULT NULL,
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
  `c_id` varchar(32) NOT NULL,
  `n_shlx` int(11) DEFAULT NULL,
  `dt_fqsj` timestamp NULL DEFAULT NULL,
  `dt_shsj` timestamp NULL DEFAULT NULL,
  `n_zt` int(11) DEFAULT NULL,
  `c_jlid` varchar(32) DEFAULT NULL,
  `c_zh` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shenhelist
-- ----------------------------
INSERT INTO `t_shenhelist` VALUES ('160699168b814ca9b05c009a5c2c0fd3', '2', '2018-05-09 10:37:00', '2018-05-09 11:03:03', '2', '9aa0970e319e4629869cdbd301a00343', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('161e7ad5d9dd4b3aa20e102dae5ab590', '2', '2018-05-09 10:24:48', '2018-05-09 11:03:20', '2', 'e7bce060bad24341a62ebdd27d4b441c', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('2e14af2112664bb182a9b8b345689c50', '2', '2018-05-09 10:31:49', '2018-05-09 11:03:23', '2', 'f933f95bf57e4687b356c906a79645cd', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('2e81b9defc774c138bee086f08438ca2', '2', '2018-05-09 10:22:04', '2018-05-09 11:03:25', '2', '19da0af5ab974f2b8f5dbe6b162f0d9d', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('47dd8352fd7842f0b920298797231bed', '2', '2018-05-09 10:30:03', '2018-05-09 11:03:28', '2', '6d68d58f89af4f089bc2f1a6a8f3661c', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('73d2286dab8b4df78d78e4d0f353089d', '2', '2018-05-09 10:38:19', '2018-05-09 11:03:31', '2', 'd55332911f444547b699a79efac0936f', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('95a53eb9f1544ca58c7c2ca1c4ae73ba', '2', '2018-05-20 22:26:49', '2018-05-20 22:28:09', '2', 'b9a2847a86894c3da8e50d3ff75761df', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('c0caaedcb7c543acaae112ce51b5e9a0', '2', '2018-05-09 10:26:53', '2018-05-09 11:03:33', '2', 'c2332f45faa24f8f9f46fcfbd416a1f9', '汤迎辉');
INSERT INTO `t_shenhelist` VALUES ('faf4ca78129e4e0f9c3184c8497d7ecf', '2', '2018-05-09 10:34:11', '2018-05-09 11:03:36', '2', 'bc8fd7958e8746eebb80c6fbc6adbdfa', '汤迎辉');

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
INSERT INTO `t_user` VALUES ('2082242662@qq.com', '123123', '1', '3593d5bfe80c412194b47f0e3dfe00e3');
INSERT INTO `t_user` VALUES ('admin@admin.com', 'admin', '3', '7a26c8347f1b4d1b9e59a245eb92430f');
INSERT INTO `t_user` VALUES ('755093231@qq.com', '123123', '2', 'e0beb4b0c3f64e199fd4d213a5eca57d');

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `c_id` varchar(32) NOT NULL,
  `c_bh` varchar(300) DEFAULT NULL,
  `c_xm` varchar(300) DEFAULT NULL,
  `c_sjhm` varchar(300) DEFAULT NULL,
  `c_txzp` varchar(300) DEFAULT NULL,
  `n_type` int(11) DEFAULT NULL,
  `c_xxmc` varchar(300) DEFAULT NULL,
  `c_zymc` varchar(300) DEFAULT NULL,
  `c_sfzhm` varchar(300) DEFAULT NULL,
  `c_tplj` varchar(300) DEFAULT NULL,
  `n_zt` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('66021f63240743e3974d668d34e39a0c', 'e0beb4b0c3f64e199fd4d213a5eca57d', '汤迎辉', '17366356362', 'http%3A%5C%5Clocalhost%3A8080%5Cfile%5C24f19eeee53a490a99b3b21b06f0cf35.jpg', '2', '', '', '330724199606062019', 'http%3A%5C%5Clocalhost%3A8080%5Cfile%5C86abd79fe838417aa5a993f5c19d6e0a.JPG', null);
INSERT INTO `t_userinfo` VALUES ('e6fba9658c1b442799ddb2c036f00ff1', '3593d5bfe80c412194b47f0e3dfe00e3', '钟黎阳', '15996248646', 'http%3A%5C%5Clocalhost%3A8080%5Cfile%5C49456a7957fa4809b1a3f6879e15dd8f.jpg', '1', '南京农业大学', '计算机科学与技术', '330724199606062019', 'http%3A%5C%5Clocalhost%3A8080%5Cfile%5Ce7afa77539c74fe684192b565e342eb5.JPG', null);

-- ----------------------------
-- Table structure for t_wscjob
-- ----------------------------
DROP TABLE IF EXISTS `t_wscjob`;
CREATE TABLE `t_wscjob` (
  `c_id` varchar(32) NOT NULL,
  `c_userid` varchar(32) DEFAULT NULL,
  `c_jobid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wscjob
-- ----------------------------
INSERT INTO `t_wscjob` VALUES ('3811f85ba35941758d780a43e02694b3', '3593d5bfe80c412194b47f0e3dfe00e3', 'c2332f45faa24f8f9f46fcfbd416a1f9');
INSERT INTO `t_wscjob` VALUES ('3eda1d55af4e461193067ef79038980c', '3593d5bfe80c412194b47f0e3dfe00e3', 'bc8fd7958e8746eebb80c6fbc6adbdfa');
INSERT INTO `t_wscjob` VALUES ('5fa6982b7ebf4fd09c9e520c42a2b267', '3593d5bfe80c412194b47f0e3dfe00e3', '19da0af5ab974f2b8f5dbe6b162f0d9d');
INSERT INTO `t_wscjob` VALUES ('8a6e4ae243ee4aec872fea0c6b122308', '3593d5bfe80c412194b47f0e3dfe00e3', '6d68d58f89af4f089bc2f1a6a8f3661c');
INSERT INTO `t_wscjob` VALUES ('9e43e548c4cb4b38949d5e9093a5bb98', '3593d5bfe80c412194b47f0e3dfe00e3', 'f933f95bf57e4687b356c906a79645cd');
INSERT INTO `t_wscjob` VALUES ('f93b09c574484ce981ed91a5832de585', '3593d5bfe80c412194b47f0e3dfe00e3', '9aa0970e319e4629869cdbd301a00343');
