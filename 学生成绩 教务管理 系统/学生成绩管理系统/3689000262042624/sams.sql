/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : sams

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-05-18 18:07:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `course_name` varchar(20) NOT NULL COMMENT '课程名',
  `course_credit` int(11) NOT NULL COMMENT '学分',
  `course_hours` int(11) NOT NULL COMMENT '学时',
  `course_teacher` varchar(30) NOT NULL COMMENT '任课教师',
  `coursedate` date NOT NULL COMMENT '开课时间',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO course VALUES ('1', 'java入门基础', '3', '30', '关羽', '2017-06-09');
INSERT INTO course VALUES ('3', 'C++程序设计教程', '3', '60', '貂蝉', '2017-03-02');
INSERT INTO course VALUES ('4', 'ASP.NET就业实例教程', '3', '60', '关羽', '2017-02-09');
INSERT INTO course VALUES ('5', '大学物理', '3', '60', '刘备', '2017-02-09');
INSERT INTO course VALUES ('6', '大学语文', '6', '60', '司马懿', '2017-02-09');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `role_info` varchar(50) NOT NULL COMMENT '角色信息',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('0', '学生', '学生查看成绩');
INSERT INTO role VALUES ('1', '教师', '教师操作');
INSERT INTO role VALUES ('2', '管理员', '管理员操作');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩编号',
  `stu_num` varchar(20) NOT NULL COMMENT '学号',
  `stu_name` varchar(30) NOT NULL COMMENT '姓名',
  `stu_class` varchar(20) NOT NULL COMMENT '班级',
  `course_name` varchar(20) NOT NULL COMMENT '科目',
  `score_grade` double(11,2) NOT NULL COMMENT '成绩',
  `major` varchar(20) NOT NULL COMMENT '专业',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO score VALUES ('1', '170340', '张三', '计科1701', 'java入门基础', '96.50', '计算机');
INSERT INTO score VALUES ('2', '170340', '张三', '计科1701', 'C++程序设计教程', '85.00', '计算机');
INSERT INTO score VALUES ('3', '170341', '王五', '软件1701', 'java入门基础', '62.60', '计算机');
INSERT INTO score VALUES ('4', '170341', '王五', '软件1701', 'C++程序设计教程', '85.00', '计算机');
INSERT INTO score VALUES ('5', '170340', '张三', '计科1701', 'ASP.NET就业实例教程', '69.00', '计算机');
INSERT INTO score VALUES ('6', '170340', '张三', '计科1701', '大学物理', '95.00', '计算机');
INSERT INTO score VALUES ('7', '170340', '张三', '计科1701', '大学语文', '89.00', '计算机');
INSERT INTO score VALUES ('8', '170341', '王五', '软件1701', 'ASP.NET就业实例教程', '95.00', '计算机');
INSERT INTO score VALUES ('9', '170341', '王五', '软件1701', '大学物理', '92.00', '计算机');
INSERT INTO score VALUES ('10', '170341', '王五', '软件1701', '大学语文', '83.00', '计算机');
INSERT INTO score VALUES ('11', '170339', '李四', '软件1701', 'java入门基础', '78.20', '计算机');
INSERT INTO score VALUES ('12', '170339', '李四', '软件1701', '大学语文', '98.00', '计算机');
INSERT INTO score VALUES ('13', '170339', '李四', '软件1701', 'ASP.NET就业实例教程', '76.00', '计算机');
INSERT INTO score VALUES ('14', '170339', '李四', '软件1701', '大学物理', '69.80', '计算机');
INSERT INTO score VALUES ('15', '170339', '李四', '软件1701', 'C++程序设计教程', '89.00', '计算机');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stu_num` varchar(20) NOT NULL COMMENT '账号',
  `stu_name` varchar(30) NOT NULL COMMENT '姓名',
  `stu_sex` varchar(10) NOT NULL COMMENT '性别',
  `stu_age` int(11) NOT NULL COMMENT '年龄',
  `stu_class` varchar(20) NOT NULL COMMENT '班级',
  `major` varchar(20) NOT NULL COMMENT '专业',
  `department` varchar(20) NOT NULL COMMENT '院系',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES ('1', '170341', '王五', '男', '22', '软件1701', '计算机', '计算机学院');
INSERT INTO student VALUES ('2', '170340', '张三', '男', '23', '计科1701', '计算机', '计算机学院');
INSERT INTO student VALUES ('3', '170339', '李四', '男', '23', '软件1701', '计算机', '计算机学院');
INSERT INTO student VALUES ('6', '4785', '位', '男', '12', '12', '1121', '是个');
INSERT INTO student VALUES ('8', '170343', '陈留', '男', '23', '软件1701', '计算机', '计算机学院');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tea_num` varchar(20) NOT NULL COMMENT '工号',
  `tea_name` varchar(30) NOT NULL COMMENT '姓名',
  `tea_sex` varchar(10) NOT NULL COMMENT '性别',
  `tea_age` int(11) NOT NULL COMMENT '年龄',
  `tea_course` varchar(20) NOT NULL COMMENT '所任课程',
  `major` varchar(20) NOT NULL COMMENT '专业',
  `department` varchar(20) NOT NULL COMMENT '院系',
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO teacher VALUES ('1', '1123', '关羽', '男', '30', 'java入门基础', '计算机', '计算机学院');
INSERT INTO teacher VALUES ('2', '1124', '貂蝉', '女', '25', 'C++程序设计教程', '计算机', '计算机学院');
INSERT INTO teacher VALUES ('3', '1125', '刘备', '男', '32', '大学物理', '计算机', '计算机学院');
INSERT INTO teacher VALUES ('4', '1126', '司马懿', '男', '34', '大学语文', '计算机', '计算机学院');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_num` varchar(20) NOT NULL COMMENT '用户账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '用户电话',
  `role_id` int(11) NOT NULL COMMENT '角色编号（外键）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', '170342', '王文军', '11', '12435', '2');
INSERT INTO user VALUES ('7', '170341', '王五', '11', '14829726746', '0');
INSERT INTO user VALUES ('8', '170340', '张三', '22', '15869483651', '0');
INSERT INTO user VALUES ('9', '170339', '李四', '33', '13589462584', '0');
INSERT INTO user VALUES ('10', '170338', '王五', '112', '11', '0');
INSERT INTO user VALUES ('11', '4785', '郑成功', '33', '789544', '0');
INSERT INTO user VALUES ('12', '1123', '关羽', '11', '17418953551', '1');
INSERT INTO user VALUES ('13', '1124', '貂蝉', '22', '15897683584', '1');
INSERT INTO user VALUES ('14', '170343', '陈留', '123456', '12457891862', '0');
INSERT INTO user VALUES ('15', '1125', '刘备', '1125', '12378945862', '1');
INSERT INTO user VALUES ('16', '1126', '司马懿', '1126', '13589462584', '1');
DELIMITER ;;
CREATE TRIGGER `stuLogin` AFTER DELETE ON `student` FOR EACH ROW begin 
delete from user where user_num=old.stu_num;
end
;;
DELIMITER ;
DELIMITER ;;
CREATE TRIGGER `teaLogin` AFTER DELETE ON `teacher` FOR EACH ROW begin
delete from user where user_num=old.tea_num;
end
;;
DELIMITER ;
