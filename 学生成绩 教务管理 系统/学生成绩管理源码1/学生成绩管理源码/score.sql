-- MySQL dump 10.13  Distrib 5.5.25, for Win32 (x86)
--
-- Host: localhost    Database: score
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_b_score`
--

DROP TABLE IF EXISTS `t_b_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_b_score` (
  `id` varchar(36) NOT NULL,
  `coursename` varchar(15) DEFAULT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `term` varchar(36) DEFAULT NULL,
  `classname` varchar(20) DEFAULT NULL,
  `teacherid` varchar(36) NOT NULL,
  `studentid` varchar(36) NOT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_b_course_t_b_teacher1` (`teacherid`),
  KEY `fk_t_b_course_t_b_student1` (`studentid`),
  CONSTRAINT `fk_t_b_course_t_b_student1` FOREIGN KEY (`studentid`) REFERENCES `t_b_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_b_course_t_b_teacher1` FOREIGN KEY (`teacherid`) REFERENCES `t_b_teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_b_score`
--

LOCK TABLES `t_b_score` WRITE;
/*!40000 ALTER TABLE `t_b_score` DISABLE KEYS */;
INSERT INTO `t_b_score` VALUES ('402880e752e7bf5d0152e7c340a90000','Java语言',98,'第一学期','一班','402881e9529aa90b01529aadbf170001','402880e6528bcdc101528bcfd5df0000','2016-02-16'),('402880e752ed92930152ed9437090001','PHP',98,'第二学期','三班','402881e9529aa90b01529aba5b440002','402880e6528bcdc101528bcfd5df0000','2016-02-17'),('402880e752edb3ef0152edb6562f0000','c',88,'第一学期','三班','402881e9529aa90b01529aba5b440002','402880e6528bcdc101528bcfd5df0000','2016-02-17'),('402881e9529b970b01529b98ede20000','Java语言',95,'第一学期','一班','402881e9529aa90b01529aadbf170001','402881e9529aa90b01529aac34640000','2016-02-01');
/*!40000 ALTER TABLE `t_b_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_b_student`
--

DROP TABLE IF EXISTS `t_b_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_b_student` (
  `id` varchar(36) NOT NULL,
  `studentnum` varchar(15) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `mobile` varchar(13) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_b_student`
--

LOCK TABLES `t_b_student` WRITE;
/*!40000 ALTER TABLE `t_b_student` DISABLE KEYS */;
INSERT INTO `t_b_student` VALUES ('402880e6528bcdc101528bcfd5df0000','1001','刘德华','1','2016-01-07','','','2016-01-29'),('402880e6528c7fd901528c823a030000','1002','范冰冰','2','2016-01-14','','','2016-01-29'),('402881e9529aa90b01529aac34640000','1003','周润发','1','2015-02-02','123456','15188888888','2016-02-01');
/*!40000 ALTER TABLE `t_b_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_b_teacher`
--

DROP TABLE IF EXISTS `t_b_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_b_teacher` (
  `id` varchar(36) NOT NULL,
  `teachername` varchar(10) DEFAULT NULL,
  `tittle` varchar(10) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `teachernum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_b_teacher`
--

LOCK TABLES `t_b_teacher` WRITE;
/*!40000 ALTER TABLE `t_b_teacher` DISABLE KEYS */;
INSERT INTO `t_b_teacher` VALUES ('402881e9529aa90b01529aadbf170001','王勇','教授','2009-11-18 00:00:00','2016-02-01 10:33:43','13588888888','101'),('402881e9529aa90b01529aba5b440002','成龙','教授','2014-01-16 00:00:00','2016-02-01 10:47:30','15166666666','102');
/*!40000 ALTER TABLE `t_b_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_depart`
--

DROP TABLE IF EXISTS `t_s_depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_depart` (
  `id` varchar(36) NOT NULL,
  `departname` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `parentid` varchar(36) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_s_depart_t_s_depart1` (`parentid`),
  CONSTRAINT `fk_t_s_depart_t_s_depart1` FOREIGN KEY (`parentid`) REFERENCES `t_s_depart` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_depart`
--

LOCK TABLES `t_s_depart` WRITE;
/*!40000 ALTER TABLE `t_s_depart` DISABLE KEYS */;
INSERT INTO `t_s_depart` VALUES ('1','test','test','1',NULL);
/*!40000 ALTER TABLE `t_s_depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_resource`
--

DROP TABLE IF EXISTS `t_s_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_resource` (
  `id` varchar(36) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `href` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `resourceType` int(11) DEFAULT NULL,
  `parentid` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_s_resource_t_s_resource1` (`parentid`),
  CONSTRAINT `fk_t_s_resource_t_s_resource1` FOREIGN KEY (`parentid`) REFERENCES `t_s_resource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_resource`
--

LOCK TABLES `t_s_resource` WRITE;
/*!40000 ALTER TABLE `t_s_resource` DISABLE KEYS */;
INSERT INTO `t_s_resource` VALUES ('1','2014-08-27 16:05:40','系统','/','系统',1,1,NULL),('2',NULL,NULL,'userController.do?goUser','用户管理',1,1,'5'),('3',NULL,NULL,'roleController.do?goRole','角色管理',2,1,'5'),('4',NULL,NULL,'resourceController.do?goResource','菜单管理',3,1,'5'),('402881e44cb6a685014cb6a840aa0000','2015-04-14 17:07:19','基本信息管理','/','信息管理',2,1,'1'),('402881e44cb71ec1014cb723b7f40000','2015-04-15 13:55:55','学生基本信息管理','studentController.do?goStudent','学生管理',1,1,'402881e44cb6a685014cb6a840aa0000'),('402881e44cbbe87e014cbbea99a80000','2015-04-15 15:10:56','成绩信息管理','scoreController.do?goScore','成绩管理',2,1,'402881e44cb6a685014cb6a840aa0000'),('402881e54ce5b4be014ce5b838fa0000','2015-04-23 17:59:57','管理教师','teacherController.do?goTeacher','教师管理',3,1,'402881e44cb6a685014cb6a840aa0000'),('5',NULL,NULL,'/','系统管理',9,1,'1');
/*!40000 ALTER TABLE `t_s_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_role`
--

DROP TABLE IF EXISTS `t_s_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_role` (
  `id` varchar(36) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_role`
--

LOCK TABLES `t_s_role` WRITE;
/*!40000 ALTER TABLE `t_s_role` DISABLE KEYS */;
INSERT INTO `t_s_role` VALUES ('1','2015-04-29 15:14:30','admin','admin'),('402881e54c7e34f6014c7e367bfb0000','2015-04-07 20:08:41','','咨询客服');
/*!40000 ALTER TABLE `t_s_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_role_resource`
--

DROP TABLE IF EXISTS `t_s_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_role_resource` (
  `role_id` varchar(36) NOT NULL,
  `resource_id` varchar(36) NOT NULL,
  KEY `FK17BAC656127E527` (`role_id`),
  KEY `FK17BAC653B9CBFA7` (`resource_id`),
  CONSTRAINT `FK17BAC653B9CBFA7` FOREIGN KEY (`resource_id`) REFERENCES `t_s_resource` (`id`),
  CONSTRAINT `FK17BAC656127E527` FOREIGN KEY (`role_id`) REFERENCES `t_s_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_role_resource`
--

LOCK TABLES `t_s_role_resource` WRITE;
/*!40000 ALTER TABLE `t_s_role_resource` DISABLE KEYS */;
INSERT INTO `t_s_role_resource` VALUES ('402881e54c7e34f6014c7e367bfb0000','2'),('402881e54c7e34f6014c7e367bfb0000','3'),('402881e54c7e34f6014c7e367bfb0000','1'),('402881e54c7e34f6014c7e367bfb0000','5'),('1','402881e44cb71ec1014cb723b7f40000'),('1','402881e44cbbe87e014cbbea99a80000'),('1','402881e54ce5b4be014ce5b838fa0000'),('1','5'),('1','2'),('1','3'),('1','4'),('1','1'),('1','402881e44cb6a685014cb6a840aa0000');
/*!40000 ALTER TABLE `t_s_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_user`
--

DROP TABLE IF EXISTS `t_s_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_user` (
  `id` varchar(36) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `position_desc` varchar(100) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_user`
--

LOCK TABLES `t_s_user` WRITE;
/*!40000 ALTER TABLE `t_s_user` DISABLE KEYS */;
INSERT INTO `t_s_user` VALUES ('1','2015-04-03 14:32:12','ser@bjpowernode.com','21232f297a57a5a743894a0e4a801fc3','','','','动力节点',1,'admin'),('402881e54c7e3e72014c7e3f6dbc0000','2015-04-03 15:47:08','','dc483e80a7a0bd9ef71d8cf973673924','','','','132',1,'test');
/*!40000 ALTER TABLE `t_s_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_s_user_role`
--

DROP TABLE IF EXISTS `t_s_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_s_user_role` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  KEY `FKD0596186127E527` (`role_id`),
  KEY `FKD059618652A907` (`user_id`),
  CONSTRAINT `FKD0596186127E527` FOREIGN KEY (`role_id`) REFERENCES `t_s_role` (`id`),
  CONSTRAINT `FKD059618652A907` FOREIGN KEY (`user_id`) REFERENCES `t_s_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_s_user_role`
--

LOCK TABLES `t_s_user_role` WRITE;
/*!40000 ALTER TABLE `t_s_user_role` DISABLE KEYS */;
INSERT INTO `t_s_user_role` VALUES ('1','1'),('402881e54c7e3e72014c7e3f6dbc0000','402881e54c7e34f6014c7e367bfb0000');
/*!40000 ALTER TABLE `t_s_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-18 10:03:45
