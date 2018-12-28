/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20-log : Database - springcloudfile
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springcloudfile` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springcloudfile`;

/*Table structure for table `filetb` */

DROP TABLE IF EXISTS `filetb`;

CREATE TABLE `filetb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:文件管理自动增长主键',
  `file_name` varchar(50) DEFAULT NULL COMMENT '备注:文件现名称',
  `file_old_name` varchar(50) DEFAULT NULL COMMENT '备注:文件原名称',
  `file_size` varchar(20) DEFAULT NULL COMMENT '备注:文件大小',
  `file_time` varchar(50) DEFAULT NULL COMMENT '备注:文件时长如MP4',
  `file_type` varchar(10) DEFAULT NULL COMMENT '备注:文件类型 ',
  `file_url` varchar(40) DEFAULT NULL COMMENT '备注:文件地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `filetb` */

insert  into `filetb`(`id`,`file_name`,`file_old_name`,`file_size`,`file_time`,`file_type`,`file_url`) values (1,'E8395C7450B546A0AEE2C9C1E98CAC51.txt','upload.txt','36',NULL,'text/plain','C:\\Users\\Program Files\\'),(2,'E859B7748C1E44FF8DD73C1181A68E1C.txt','upload.txt','36',NULL,'text/plain','C:\\'),(3,'AC60D40DDFFA4FA49E3F1511BDFB8D86.txt','upload.txt','36',NULL,'text/plain','D:\\'),(4,'B0C378D6FFA6470C8996ECF2753973E1.txt','upload.txt','36KB',NULL,'.TXT','D:\\'),(5,'BEC89D7622734A57B625B4F3E79B111A.txt','upload.txt','36KB',NULL,'.TXT','D:\\');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
