/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.9-log : Database - course
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`course` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `course`;

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `course_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:课程编号',
  `course_category` varchar(50) DEFAULT NULL COMMENT '备注:课程类别',
  `course_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:创建时间',
  `course_creator` varchar(50) DEFAULT NULL COMMENT '备注:课程创建者',
  `course_editor_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '备注:编辑时间',
  `course_name` varchar(50) DEFAULT NULL COMMENT '备注:课程名称',
  `course_remark` varchar(100) DEFAULT NULL COMMENT '备注:课程说明',
  `course_state` varchar(10) DEFAULT NULL COMMENT '备注:是否发布',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

/*Table structure for table `courseware` */

DROP TABLE IF EXISTS `courseware`;

CREATE TABLE `courseware` (
  `cw_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:课件编号',
  `cw_url` varchar(50) DEFAULT NULL COMMENT '备注:课件资源URL',
  `cw_category` varchar(50) DEFAULT NULL COMMENT '备注:课件类型 ',
  `cw_hour` varchar(50) DEFAULT NULL COMMENT '备注:课件所属课时 ',
  `cw_name` varchar(50) DEFAULT NULL COMMENT '备注:课件名称 ',
  PRIMARY KEY (`cw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courseware` */

/*Table structure for table `hours` */

DROP TABLE IF EXISTS `hours`;

CREATE TABLE `hours` (
  `hour_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:课时编号',
  `hour_course` varchar(50) DEFAULT NULL COMMENT '备注:课时所属课程 ',
  `hour_name` varchar(50) DEFAULT NULL COMMENT '课时名称 ',
  `hour_parent_id` int(11) DEFAULT NULL COMMENT '备注:课时父id ',
  PRIMARY KEY (`hour_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hours` */

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:公告编号',
  `notice_content` varchar(100) DEFAULT NULL COMMENT '备注:公告内容 ',
  `notice_course` varchar(50) DEFAULT NULL COMMENT '备注:公告所属课程 ',
  `notice_name` varchar(50) DEFAULT NULL COMMENT '备注:公告名称 ',
  `notice_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:发布时间 ',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

/*Table structure for table `pic` */

DROP TABLE IF EXISTS `pic`;

CREATE TABLE `pic` (
  `pic_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:图片编号',
  `pic_url` varchar(80) DEFAULT NULL COMMENT '备注:图片资源URL',
  `pic_course` varchar(50) DEFAULT NULL COMMENT '备注:所属课程 ',
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pic` */

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `score_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:评分标准编号',
  `score_content` varchar(100) DEFAULT NULL COMMENT '备注:内容 ',
  `score_course` varchar(50) DEFAULT NULL COMMENT '备注:所属课程 ',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `score` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
