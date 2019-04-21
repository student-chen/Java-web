/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : ssm2

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2018-03-01 14:42:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'dfsdfsadf',
  `name` varchar(50) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', 'java1班', '0', '0');
INSERT INTO `classes` VALUES ('2', 'Java2班', '1', '0');
INSERT INTO `classes` VALUES ('3', 'UI一班', '1', '0');
INSERT INTO `classes` VALUES ('4', 'UI二班', '1', '0');
INSERT INTO `classes` VALUES ('5', 'Java高级班', '0', '0');
INSERT INTO `classes` VALUES ('6', '6', '1', '0');
INSERT INTO `classes` VALUES ('12', 'llll', '0', null);

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '模拟电路', '1');
INSERT INTO `course` VALUES ('5', '线性代数', '0');
INSERT INTO `course` VALUES ('7', 'Java', '1');
INSERT INTO `course` VALUES ('8', 'c#', '1');
INSERT INTO `course` VALUES ('9', 'java基础', '0');
INSERT INTO `course` VALUES ('10', '毛泽东思想', '1');

-- ----------------------------
-- Table structure for `ctc`
-- ----------------------------
DROP TABLE IF EXISTS `ctc`;
CREATE TABLE `ctc` (
  `couid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `claid` int(11) NOT NULL,
  PRIMARY KEY (`couid`,`tid`,`claid`),
  KEY `tid` (`tid`),
  KEY `claid` (`claid`),
  KEY `couid` (`couid`),
  CONSTRAINT `claid` FOREIGN KEY (`claid`) REFERENCES `classes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `couid` FOREIGN KEY (`couid`) REFERENCES `course` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ctc
-- ----------------------------
INSERT INTO `ctc` VALUES ('1', '1', '2');
INSERT INTO `ctc` VALUES ('1', '1', '3');
INSERT INTO `ctc` VALUES ('1', '1', '4');
INSERT INTO `ctc` VALUES ('1', '1', '5');
INSERT INTO `ctc` VALUES ('5', '1', '1');
INSERT INTO `ctc` VALUES ('5', '1', '2');
INSERT INTO `ctc` VALUES ('5', '1', '4');
INSERT INTO `ctc` VALUES ('5', '1', '5');
INSERT INTO `ctc` VALUES ('7', '1', '2');
INSERT INTO `ctc` VALUES ('7', '1', '3');
INSERT INTO `ctc` VALUES ('7', '1', '4');
INSERT INTO `ctc` VALUES ('7', '1', '5');
INSERT INTO `ctc` VALUES ('8', '1', '4');
INSERT INTO `ctc` VALUES ('8', '1', '5');
INSERT INTO `ctc` VALUES ('9', '1', '4');
INSERT INTO `ctc` VALUES ('9', '1', '5');
INSERT INTO `ctc` VALUES ('9', '1', '6');
INSERT INTO `ctc` VALUES ('10', '1', '2');
INSERT INTO `ctc` VALUES ('10', '1', '3');
INSERT INTO `ctc` VALUES ('10', '1', '5');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT '0',
  `cid` int(11) DEFAULT '0',
  `tid` int(11) DEFAULT NULL,
  `pgrade` double DEFAULT NULL,
  `kgrade` double DEFAULT NULL,
  `zgrade` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid2` (`cid`),
  KEY `tid2` (`tid`),
  KEY `sid2` (`sid`),
  CONSTRAINT `cid2` FOREIGN KEY (`cid`) REFERENCES `course` (`id`),
  CONSTRAINT `sid2` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tid2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('7', '1', '1', '1', '23', '45', '68');
INSERT INTO `grade` VALUES ('8', '1', '7', '1', '34', '54', '88');
INSERT INTO `grade` VALUES ('9', '1', '10', '1', '33', '55', '88');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`cid`),
  KEY `cId1` (`cid`),
  KEY `tId1` (`tid`),
  CONSTRAINT `cId1` FOREIGN KEY (`cid`) REFERENCES `course` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sId1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tId1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('1', '1', '1');
INSERT INTO `sc` VALUES ('1', '1', '7');
INSERT INTO `sc` VALUES ('1', '1', '10');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `classid` int(30) DEFAULT NULL,
  `usertype` int(11) DEFAULT '2',
  `password` varchar(30) DEFAULT NULL,
  `loginname` varchar(30) DEFAULT NULL,
  `files` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `s_c` (`classid`),
  CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `classes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'ahui', '1', '山西', '15635354675', '5', '2', 'aaa', 'ahui', null);
INSERT INTO `student` VALUES ('8', '赵璇', '1', '辅导费但V发tyrytttttttttttttttttt', '123432133', '1', '2', 'aaa', 'zx', null);
INSERT INTO `student` VALUES ('9', '张宇航111', '1', '事实上', '11111', '2', '2', 'aaa', 'zyh', null);
INSERT INTO `student` VALUES ('21', '22', '0', '2222', '222', '1', '2', '22222', '22', null);
INSERT INTO `student` VALUES ('27', '22', '0', '22', '22', '1', '2', '22', '22', null);
INSERT INTO `student` VALUES ('28', '22', '0', 'sss', '111', '1', '2', 'eee', '22', null);
INSERT INTO `student` VALUES ('29', 'ee', '0', 'ffffff', '15635385193', '1', '2', 'hjjjj', 'yyy', null);
INSERT INTO `student` VALUES ('38', 'wwww', '0', 'www', '15635385193', '1', '2', 'aaa', 'admin', 'myfile');
INSERT INTO `student` VALUES ('41', '张小兰', '2', '了解对方', '15525365434', '2', '2', 'aaa', 'zhangxl', null);
INSERT INTO `student` VALUES ('42', '阿水1', '1', 'ssssss', '444', '4', '2', '123', 'ashui', null);
INSERT INTO `student` VALUES ('43', 'ddd', '1', 'ddd', 'dd', '2', '2', 'ddd', 'dd', null);
INSERT INTO `student` VALUES ('44', 'qq', '1', 'qqqqqqqq', '2222222222', '4', '2', 'qqq', 'qqq', null);
INSERT INTO `student` VALUES ('45', 'ww', '1', 'dfsdf', '1121', '2', '2', 'www', 'ww', null);
INSERT INTO `student` VALUES ('46', '22', '0', '2222', '222', '1', '2', '22222', '22', null);

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `usertype` int(11) DEFAULT '3',
  `loginname` varchar(255) DEFAULT NULL,
  `password` varchar(30) DEFAULT 'aaaaaa',
  `workId` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '王老师', '3', 'wangxd', 'aaaaaa', '12');
INSERT INTO `teacher` VALUES ('2', '王老师师', '3', null, 'aaaaaa', '123');
INSERT INTO `teacher` VALUES ('4', 'zhaojing', '3', 'zhaojing', 'aaaaaa', null);
INSERT INTO `teacher` VALUES ('5', '利润率', '3', null, null, null);
INSERT INTO `teacher` VALUES ('6', 'wwww', '3', null, null, null);
INSERT INTO `teacher` VALUES ('10', '张小姐', '3', null, 'aaaaaa', null);
INSERT INTO `teacher` VALUES ('11', '李晓玉111', '3', 'lixiaoyu', '1111', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usertype` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'aaa', '1');
INSERT INTO `user` VALUES ('2', 'zhaojing', 'aaa', '1');
