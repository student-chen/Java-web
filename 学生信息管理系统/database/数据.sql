/*
SQLyog Trial v10.2 
MySQL - 5.7.16-enterprise-commercial-advanced-log : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`database` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `database`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teacher` char(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `course` */

insert  into `course`(`course`,`teacher`) values ('aaa','c'),('ccc','c'),('zxc','c'),('vvv','x');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(20) DEFAULT NULL,
  `username` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aaa` int(5) DEFAULT NULL,
  `ccc` int(5) DEFAULT NULL,
  `zxc` int(5) DEFAULT NULL,
  `vvv` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`username`,`aaa`,`ccc`,`zxc`,`vvv`) values (48,'s',1,34,78,33),(49,'d',34,64,65,33);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` char(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`type`) values (1,'a','a','3'),(4,'c','c','2'),(48,'s','s','1'),(49,'d','d','1'),(56,'x','x','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
