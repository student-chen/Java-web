/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : final

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-02-14 04:41:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(10) DEFAULT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `admin_ps` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '77jubao', 'admin');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `c_hour` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据库设计', '72');
INSERT INTO `course` VALUES ('2', 'javaEE', '64');
INSERT INTO `course` VALUES ('4', '数据结构', '64');
INSERT INTO `course` VALUES ('5', 'C++', '48');
INSERT INTO `course` VALUES ('6', 'C#', '32');
INSERT INTO `course` VALUES ('7', 'javaWeb', '48');
INSERT INTO `course` VALUES ('9', '软件工程', '64');
INSERT INTO `course` VALUES ('10', '计算机网络', '48');
INSERT INTO `course` VALUES ('11', '大学英语', '32');

-- ----------------------------
-- Table structure for `course_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher` (
  `c_t_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_t_id`),
  KEY `course_course_teacher` (`c_id`),
  KEY `teacher_course_teacher` (`t_id`),
  CONSTRAINT `course_course_teacher` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_course_teacher` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_teacher
-- ----------------------------
INSERT INTO `course_teacher` VALUES ('22', '5', '1');
INSERT INTO `course_teacher` VALUES ('25', '2', '5');
INSERT INTO `course_teacher` VALUES ('26', '5', '5');
INSERT INTO `course_teacher` VALUES ('28', '9', '5');
INSERT INTO `course_teacher` VALUES ('29', '4', '5');
INSERT INTO `course_teacher` VALUES ('30', '6', '7');
INSERT INTO `course_teacher` VALUES ('32', '10', '8');
INSERT INTO `course_teacher` VALUES ('33', '1', '8');
INSERT INTO `course_teacher` VALUES ('34', '5', '9');
INSERT INTO `course_teacher` VALUES ('35', '4', '9');
INSERT INTO `course_teacher` VALUES ('36', '9', '9');
INSERT INTO `course_teacher` VALUES ('37', '6', '1');
INSERT INTO `course_teacher` VALUES ('38', '7', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) DEFAULT NULL,
  `stu_sex` varchar(2) DEFAULT NULL,
  `stu_address` varchar(100) DEFAULT NULL,
  `stu_phone` varchar(20) DEFAULT NULL,
  `stu_sp` varchar(20) DEFAULT NULL,
  `stu_class` varchar(10) DEFAULT NULL,
  `stu_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '陈', '男', '浙江湖州', '18767122138', '软件工程', '1005', '847333548@qq.com');
INSERT INTO `student` VALUES ('8', '王超', '男', '浙江台州', '18767122156', '软件工程', '1006', '65468777@qq.com');

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `stu_id` int(11) NOT NULL,
  `c_t_id` int(11) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`,`c_t_id`),
  KEY `student_student_course` (`stu_id`),
  KEY `course_teacher_student_course` (`c_t_id`),
  CONSTRAINT `course_teacher_Student_course` FOREIGN KEY (`c_t_id`) REFERENCES `course_teacher` (`c_t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_student_course` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('2', '22', '-1');
INSERT INTO `student_course` VALUES ('2', '28', '-1');
INSERT INTO `student_course` VALUES ('2', '32', '-1');
INSERT INTO `student_course` VALUES ('2', '35', '-1');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  `t_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '梁荣华', '187323123');
INSERT INTO `teacher` VALUES ('5', '潘健', '18254562488');
INSERT INTO `teacher` VALUES ('7', '郑宇军', '156236521365');
INSERT INTO `teacher` VALUES ('8', '毛科技', '1658963256');
INSERT INTO `teacher` VALUES ('9', '钱能', '1659256326');
INSERT INTO `teacher` VALUES ('10', '张三', '18767122123');
