/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2017-05-11 19:13:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `diagnosis`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `type` varchar(2000) DEFAULT '',
  `info` varchar(2000) DEFAULT '',
  `doctorId` int(11) DEFAULT '0',
  `patientId` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor`
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffNo` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `postid` int(11) DEFAULT '0',
  `post` varchar(2000) DEFAULT '',
  `sex` varchar(2000) DEFAULT '',
  `birthday` datetime DEFAULT NULL,
  `info` varchar(2000) DEFAULT '',
  `mcId` int(11) DEFAULT '0',
  `mcName` varchar(2000) DEFAULT '',
  `loginName` varchar(2000) DEFAULT '',
  `loginPassword` varchar(2000) DEFAULT '',
  `isActive` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '1', '≤‚ ‘', '0', '', 'ƒ–', '2017-05-11 18:25:16', '', '0', '', '≤‚ ‘', '111111', '0');

-- ----------------------------
-- Table structure for `medicalcourses`
-- ----------------------------
DROP TABLE IF EXISTS `medicalcourses`;
CREATE TABLE `medicalcourses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(2000) DEFAULT '',
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicalcourses
-- ----------------------------

-- ----------------------------
-- Table structure for `nurse`
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffNo` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `sex` varchar(2000) DEFAULT '',
  `postid` int(11) DEFAULT '0',
  `post` varchar(2000) DEFAULT '',
  `loginName` varchar(2000) DEFAULT '',
  `loginPassword` varchar(2000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nurse
-- ----------------------------
INSERT INTO `nurse` VALUES ('1', '', '≤‚ ‘', '≈Æ', '0', '', '≤‚ ‘', '111111');

-- ----------------------------
-- Table structure for `operatingroom`
-- ----------------------------
DROP TABLE IF EXISTS `operatingroom`;
CREATE TABLE `operatingroom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orNo` varchar(2000) DEFAULT '',
  `type` varchar(2000) DEFAULT '',
  `address` varchar(2000) DEFAULT '',
  `info` varchar(2000) DEFAULT '',
  `nurseList` varchar(2000) DEFAULT '',
  `isUseable` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operatingroom
-- ----------------------------

-- ----------------------------
-- Table structure for `operation`
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(2000) DEFAULT '',
  `date` datetime DEFAULT NULL,
  `operatingRoomId` int(11) DEFAULT '0',
  `patenitId` int(11) DEFAULT '0',
  `pkDoctorId` int(11) DEFAULT '0',
  `extDoctorId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation
-- ----------------------------

-- ----------------------------
-- Table structure for `operationschedule`
-- ----------------------------
DROP TABLE IF EXISTS `operationschedule`;
CREATE TABLE `operationschedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operationRoomId` int(11) DEFAULT '0',
  `operationId` int(11) DEFAULT '0',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operationschedule
-- ----------------------------

-- ----------------------------
-- Table structure for `pagefairy`
-- ----------------------------
DROP TABLE IF EXISTS `pagefairy`;
CREATE TABLE `pagefairy` (
  `nextpage` int(11) DEFAULT '0',
  `priorPage` int(11) DEFAULT '0',
  `rowsCount` int(11) DEFAULT '0',
  `pageCount` int(11) DEFAULT '0',
  `page` int(11) DEFAULT '0',
  `numberpage` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pagefairy
-- ----------------------------

-- ----------------------------
-- Table structure for `pagepagination`
-- ----------------------------
DROP TABLE IF EXISTS `pagepagination`;
CREATE TABLE `pagepagination` (
  `pageCount` int(11) DEFAULT '0',
  `pageSize` int(11) DEFAULT '0',
  `priorPage` int(11) DEFAULT '0',
  `nextPage` int(11) DEFAULT '0',
  `lastPage` int(11) DEFAULT '0',
  `pageNum` int(11) DEFAULT '0',
  `currentType` varchar(2000) DEFAULT '',
  `isActive` varchar(2000) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pagepagination
-- ----------------------------

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `oid` int(11) DEFAULT '0',
  `patientNo` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `sex` varchar(2000) DEFAULT '',
  `address` varchar(2000) DEFAULT '',
  `age` int(11) DEFAULT '0',
  `isfinished` int(11) DEFAULT '0',
  `mcId` int(11) DEFAULT '0',
  `mcName` varchar(2000) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(2000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', 'sdfsdf');

-- ----------------------------
-- Table structure for `receipt`
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `items` varchar(2000) DEFAULT '',
  `payee` varchar(2000) DEFAULT '',
  `payeeId` int(11) DEFAULT '0',
  `pdate` datetime DEFAULT NULL,
  `isFinished` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receipt
-- ----------------------------

-- ----------------------------
-- Table structure for `sickbed`
-- ----------------------------
DROP TABLE IF EXISTS `sickbed`;
CREATE TABLE `sickbed` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bedNo` varchar(2000) DEFAULT '',
  `type` varchar(2000) DEFAULT '',
  `isUseable` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sickbed
-- ----------------------------

-- ----------------------------
-- Table structure for `sickbedid`
-- ----------------------------
DROP TABLE IF EXISTS `sickbedid`;
CREATE TABLE `sickbedid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bedNo` varchar(2000) DEFAULT '',
  `type` int(11) DEFAULT '0',
  `nurseIds` varchar(2000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sickbedid
-- ----------------------------

-- ----------------------------
-- Table structure for `sinkbedschedule`
-- ----------------------------
DROP TABLE IF EXISTS `sinkbedschedule`;
CREATE TABLE `sinkbedschedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sinkbedId` int(11) DEFAULT '0',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `operationId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sinkbedschedule
-- ----------------------------

-- ----------------------------
-- Table structure for `stat`
-- ----------------------------
DROP TABLE IF EXISTS `stat`;
CREATE TABLE `stat` (
  `items` varchar(2000) DEFAULT '',
  `payee` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `pdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stat
-- ----------------------------

-- ----------------------------
-- Table structure for `stayinhp`
-- ----------------------------
DROP TABLE IF EXISTS `stayinhp`;
CREATE TABLE `stayinhp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) DEFAULT '0',
  `bedId` int(11) DEFAULT '0',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `days` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stayinhp
-- ----------------------------

-- ----------------------------
-- Table structure for `stayinhpdto`
-- ----------------------------
DROP TABLE IF EXISTS `stayinhpdto`;
CREATE TABLE `stayinhpdto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) DEFAULT '0',
  `bedId` int(11) DEFAULT '0',
  `days` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stayinhpdto
-- ----------------------------

-- ----------------------------
-- Table structure for `viewdoctorpostmedicalcoursesdto`
-- ----------------------------
DROP TABLE IF EXISTS `viewdoctorpostmedicalcoursesdto`;
CREATE TABLE `viewdoctorpostmedicalcoursesdto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `workNum` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `postName` varchar(2000) DEFAULT '',
  `sex` varchar(2000) DEFAULT '',
  `birthday` datetime DEFAULT NULL,
  `info` varchar(2000) DEFAULT '',
  `mcName` varchar(2000) DEFAULT '',
  `loginName` varchar(2000) DEFAULT '',
  `loginPassword` varchar(2000) DEFAULT '',
  `isActive` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of viewdoctorpostmedicalcoursesdto
-- ----------------------------

-- ----------------------------
-- Table structure for `viewnursepostdto`
-- ----------------------------
DROP TABLE IF EXISTS `viewnursepostdto`;
CREATE TABLE `viewnursepostdto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `workNum` varchar(2000) DEFAULT '',
  `name` varchar(2000) DEFAULT '',
  `sex` varchar(2000) DEFAULT '',
  `postName` varchar(2000) DEFAULT '',
  `loginName` varchar(2000) DEFAULT '',
  `loginPassword` varchar(2000) DEFAULT '',
  `pName` varchar(2000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of viewnursepostdto
-- ----------------------------