/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - zhulonghaodb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhulonghaodb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zhulonghaodb`;

/*Table structure for table `fanstb` */

DROP TABLE IF EXISTS `fanstb`;

CREATE TABLE `fanstb` (
  `f_fid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:粉丝自动增长主键',
  `f_ufid` int(11) DEFAULT NULL COMMENT '备注:粉丝id',
  `f_uid` int(11) DEFAULT NULL COMMENT '备注:用户id',
  PRIMARY KEY (`f_fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fanstb` */

/*Table structure for table `userinfotb` */

DROP TABLE IF EXISTS `userinfotb`;

CREATE TABLE `userinfotb` (
  `u_uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:用户自动增长主键',
  `ui_birthday` datetime NOT NULL COMMENT '备注:出生年用',
  `ui_email` varchar(50) DEFAULT NULL COMMENT '备注:邮箱',
  `ui_headportrait` varchar(50) NOT NULL COMMENT '备注:用户头像url',
  `ui_headportraitid` int(11) DEFAULT NULL COMMENT '备注:用户头像id',
  `ui_headportraitname` varchar(20) DEFAULT NULL COMMENT '备注:用户头像名',
  `ui_identitycard` varchar(18) DEFAULT NULL COMMENT '备注:用户身份证',
  `ui_nickname` varchar(20) NOT NULL COMMENT '备注:用户昵称',
  `ui_phone` varchar(11) NOT NULL COMMENT '备注:手机号',
  `ui_sex` varchar(5) DEFAULT NULL COMMENT '备注:性别',
  `ui_truename` varchar(8) DEFAULT NULL COMMENT '备注:用户真实姓名',
  PRIMARY KEY (`u_uid`),
  UNIQUE KEY `ui_nickname` (`ui_nickname`),
  UNIQUE KEY `ui_phone` (`ui_phone`),
  UNIQUE KEY `ui_identitycard` (`ui_identitycard`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `userinfotb` */

insert  into `userinfotb`(`u_uid`,`ui_birthday`,`ui_email`,`ui_headportrait`,`ui_headportraitid`,`ui_headportraitname`,`ui_identitycard`,`ui_nickname`,`ui_phone`,`ui_sex`,`ui_truename`) values (1,'1997-01-10 00:00:00','123456@163.com','cdm',1,'998','610322199701106465','无敌真寂寞','15836860043','男','张三'),(2,'1998-09-15 00:00:00','123123@163.com','cdm',2,'998','610322197101064653','小老弟','13137504390','女','王晶'),(3,'1966-03-15 00:00:00','1564554@163.con','cdm',3,'998','610322196603154653','抓不死我','13137404581','男','王炸'),(4,'1998-09-15 00:00:00','1231231@163.com','cdm',4,'998','610322199809156465','武大郎','13137504350','男','闰土'),(5,'1997-09-15 00:00:00','1236561@163.com','cdm',5,'998','610322199709156465','智慧书','13137404350','男','李四'),(6,'1996-09-15 00:00:00','1236461@163.com','cdm',6,'998','610322199609156465','小王子','13138404350','男','王大力'),(7,'1988-09-15 00:00:00','1235461@163.com','cdm',6,'998','610322198809156465','小垃圾','13138404355','男','胡子昂'),(8,'1989-09-15 00:00:00','15452211@163.com','cdm',6,'998','610322198909156465','等哈说','13138404555','男','李建忠');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
