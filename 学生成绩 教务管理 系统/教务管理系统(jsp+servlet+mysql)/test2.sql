# MySQL-Front 3.2  (Build 13.0)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;

/*!40101 SET NAMES gbk */;
/*!40103 SET TIME_ZONE='SYSTEM' */;

# Host: localhost    Database: test2
# ------------------------------------------------------
# Server version 5.0.22-community-nt

DROP DATABASE IF EXISTS `test2`;
CREATE DATABASE `test2` /*!40100 DEFAULT CHARACTER SET gb2312 */;
USE `test2`;

/*!40101 SET NAMES gb2312 */;

#
# Table structure for table t_file
#

CREATE TABLE `t_file` (
  `file_name` char(16) NOT NULL default '',
  `file_path` char(20) NOT NULL default '',
  `file_date` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Dumping data for table t_file
#


#
# Table structure for table t_user
#

CREATE TABLE `t_user` (
  `user_id` char(16) NOT NULL default '',
  `user_name` char(16) default NULL,
  `password` char(16) default NULL,
  `contact_tel` char(20) default NULL,
  `email` char(20) default NULL,
  `create_date` datetime default NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Dumping data for table t_user
#

INSERT INTO `t_user` VALUES ('admin','admin','123456','','',NULL);
INSERT INTO `t_user` VALUES ('cashhn','cash','123456','','','2009-04-20 19:58:10');

/*!40101 SET NAMES gbk */;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
