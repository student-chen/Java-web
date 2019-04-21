/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : studentdb

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-06-06 20:12:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` varchar(11) DEFAULT NULL,
  `classname` varchar(255) DEFAULT NULL,
  `classexplain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '10001', '普通班', '中等');
INSERT INTO `class` VALUES ('2', '10002', '重点班', '良');
INSERT INTO `class` VALUES ('3', '10003', '励志班', '优秀');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `Xueji` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `yuwen` varchar(255) DEFAULT NULL,
  `math` varchar(255) DEFAULT NULL,
  `English` varchar(255) DEFAULT NULL,
  `histroy` varchar(255) DEFAULT NULL,
  `huaxue` varchar(255) DEFAULT NULL,
  `wuli` varchar(255) DEFAULT NULL,
  `Tiyu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '10001', 'Xiaoming', '男', '18', '15955644918', '9', '1', '在读', '2131243232', '70', '75', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('2', '10002', 'Zhansan', '男', '18', '15955644918', '90', '1', '毕业', '12312312312323', '23', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('3', '10002', 'Zhansan', '男', '18', '15955644918', '90', '1', '毕业', '12312312312323', '23', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('4', '10012', '王五', '男', '13', '15955644918', '1000', '3', '本科', '131231236628312', '12', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('6', '10002', 'Zhansan', '男', '18', '15955644918', '90', '1', '毕业', '12312312312323', '23', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('8', '10002', 'Zhansan', '男', '18', '15955644918', '90', '1', '毕业', '12312312312323', '23', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('9', '10008', '李四', '男', '12', '22312312432', '1000', '2', '研究生', '131231232628312', '23', '', '', '', '', '', '');
INSERT INTO `student` VALUES ('10', '10008', '李四', '男', '12', '22312312432', '1000', '2', '研究生', '131231232628312', '23', '45', '45', '45', '45', '45', '45');
INSERT INTO `student` VALUES ('33', '10007', '胡锦涛', '男', '23', '15893432423', '1000', '3', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `iname` varchar(255) DEFAULT NULL,
  `itext` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1', 'java', '软件开发工程师');
INSERT INTO `studentinfo` VALUES ('2', 'html', '前端设计');
INSERT INTO `studentinfo` VALUES ('3', 'UI', '网页设计');

-- ----------------------------
-- Table structure for studentrinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentrinfo`;
CREATE TABLE `studentrinfo` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rstatus` varchar(255) DEFAULT NULL,
  `rtext` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentrinfo
-- ----------------------------
INSERT INTO `studentrinfo` VALUES ('1', '安徽农大大学', '本科');
INSERT INTO `studentrinfo` VALUES ('2', '安徽工业经济职业技术学员', '专科');
INSERT INTO `studentrinfo` VALUES ('3', '重庆大学', '研究生');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `tcard` varchar(255) DEFAULT NULL,
  `tsex` varchar(255) DEFAULT NULL,
  `tadd` varchar(255) DEFAULT NULL,
  `tcalssid` varchar(255) DEFAULT NULL,
  `tlesson` varchar(255) DEFAULT NULL,
  `ttext` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '胡艳东', '342425199905168116', '男', '舒城县', '2', '计算机科学', 'html');
INSERT INTO `teacher` VALUES ('2', '李强', '432343242134', '男', '安徽', null, '计算机应用', '2');
INSERT INTO `teacher` VALUES ('3', '李强', '432343242134', '男', '安徽', null, '计算机应用', '2');
INSERT INTO `teacher` VALUES ('4', 'lisi', '2132332423', '男', '杭州', null, '计算机应用', 'UI');
INSERT INTO `teacher` VALUES ('5', '李强', '432343242134', '男', '安徽', null, '计算机应用', 'java');
INSERT INTO `teacher` VALUES ('6', 'lisi', '3232423424', '女', '杭州', null, '计算机应用', 'html5');
INSERT INTO `teacher` VALUES ('7', 'lisi', '3232423424', '女', '杭州', '', '计算机应用', 'html5');
INSERT INTO `teacher` VALUES ('8', 'lisi', '3232423424', '女', '杭州', '', '计算机应用', 'html5');

-- ----------------------------
-- Table structure for userlog
-- ----------------------------
DROP TABLE IF EXISTS `userlog`;
CREATE TABLE `userlog` (
  `RemoteAddr` varchar(255) DEFAULT NULL,
  `UserAgent` varchar(255) DEFAULT NULL,
  `CreateBy` varchar(255) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlog
-- ----------------------------
INSERT INTO `userlog` VALUES ('eqw', '2sdad', '3asdsa', '2018-05-07 10:55:07', '5asd');

-- ----------------------------
-- Table structure for useroa
-- ----------------------------
DROP TABLE IF EXISTS `useroa`;
CREATE TABLE `useroa` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useroa
-- ----------------------------
INSERT INTO `useroa` VALUES ('1', 'admin', '系统管理员', '12345', '13865431650', '2269938321@qq.com');
INSERT INTO `useroa` VALUES ('2', 'Huyandong', '胡艳东', '123123', '15955644917', '2269938321@qq.com');
INSERT INTO `useroa` VALUES ('3', 'Xiaoming', '小明', 'hyd123', '1527327345326', '2269938321@qq.com');
