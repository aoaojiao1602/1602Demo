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
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '备注:课程编号',
  `course_category` int(11) DEFAULT NULL COMMENT '备注:课程类别',
  `course_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备注:创建时间',
  `course_creator` int(11) DEFAULT NULL COMMENT '备注:课程创建者',
  `course_editor_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备注:编辑时间',
  `course_name` varchar(50) DEFAULT NULL COMMENT '备注:课程名称',
  `course_remark` varchar(100) DEFAULT NULL COMMENT '备注:课程说明',
  `course_state` varchar(10) DEFAULT NULL COMMENT '备注:是否发布',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

insert  into `courses`(`course_id`,`course_category`,`course_create_time`,`course_creator`,`course_editor_time`,`course_name`,`course_remark`,`course_state`) values (5,1,'2018-12-31 23:08:32',NULL,'2018-12-31 23:08:32','计算机基础','颠三倒四多','未发布'),(6,1,'2018-12-31 23:08:55',NULL,'2018-12-31 23:08:55','线性几何','地方','已发布'),(7,1,'2018-12-31 23:10:59',NULL,'2018-12-31 23:10:59','财务会计','说的方法水电费水电费','未发布'),(8,1,'2018-12-31 23:11:21',NULL,'2018-12-31 23:11:21','结构力学','大大方方','未发布'),(9,2,'2018-12-31 23:11:41',NULL,'2018-12-31 23:11:41','中国刑法学','第三方对方答复','未发布'),(10,1,'2018-12-31 23:13:53',NULL,'2018-12-31 23:13:53','植物组织培养','奋斗的奋斗','已发布'),(11,1,'2018-12-31 23:14:34',NULL,'2018-12-31 23:14:34','园林植物遗传育种学','发生的发生','未发布'),(12,1,'2018-12-31 23:15:02',NULL,'2018-12-31 23:15:02','西方园林历史与艺术','到付广告费','未发布'),(13,2,'2018-12-31 23:15:27',NULL,'2018-12-31 23:15:27','水文与水资源学','反反复复付付付','未发布'),(14,2,'2018-12-31 23:15:39',NULL,'2018-12-31 23:15:39','树木学','反反复复付付','未发布'),(15,2,'2018-12-31 23:16:07',NULL,'2018-12-31 23:16:07','森林培育学','发发发风色多付所付','未发布'),(16,2,'2018-12-31 23:16:24',NULL,'2018-12-31 23:16:24','区域经济学','几个人更多梵蒂冈','未发布'),(17,2,'2018-12-31 23:16:43',NULL,'2018-12-31 23:16:43','空间解析几何','韩国护肤共和国','已发布'),(18,2,'2018-12-31 23:16:59',NULL,'2018-12-31 23:16:59','环境化学','非官方发个非官方','未发布');

/*Table structure for table `courseware` */

DROP TABLE IF EXISTS `courseware`;

CREATE TABLE `courseware` (
  `cw_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '备注:课件编号',
  `cw_category` varchar(50) DEFAULT NULL COMMENT '备注:课件类型 ',
  `cw_hour` int(11) DEFAULT NULL COMMENT '备注:课件所属课时 ',
  `cw_name` varchar(50) DEFAULT NULL COMMENT '备注:课件名称 ',
  `cw_url` varchar(50) DEFAULT NULL COMMENT '备注:课件资源URL',
  PRIMARY KEY (`cw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courseware` */

/*Table structure for table `hours` */

DROP TABLE IF EXISTS `hours`;

CREATE TABLE `hours` (
  `hour_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '备注:课时编号',
  `hour_course` int(11) DEFAULT NULL COMMENT '备注:课时所属课程 ',
  `hour_name` varchar(50) DEFAULT NULL COMMENT '课时名称 ',
  `hour_parent_id` int(11) DEFAULT NULL COMMENT '备注:课时父id ',
  `hour_sort` int(11) DEFAULT NULL COMMENT '备注:章节排列顺序 ',
  PRIMARY KEY (`hour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `hours` */

insert  into `hours`(`hour_id`,`hour_course`,`hour_name`,`hour_parent_id`,`hour_sort`) values (4,18,'保护环境',0,2),(5,18,'美化环境',0,3),(6,18,'整治环境',0,4),(7,18,'爱护环境',0,1),(8,17,'1+1为什么等于2',0,1),(9,18,'送佛送到西',7,1),(10,18,'让他一人',7,2);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '备注:公告编号',
  `notice_content` varchar(100) DEFAULT NULL COMMENT '备注:公告内容 ',
  `notice_course` int(11) DEFAULT NULL COMMENT '备注:公告所属课程 ',
  `notice_name` varchar(50) DEFAULT NULL COMMENT '备注:公告名称 ',
  `notice_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:发布时间 ',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

/*Table structure for table `pic` */

DROP TABLE IF EXISTS `pic`;

CREATE TABLE `pic` (
  `pic_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:图片编号',
  `pic_course` varchar(50) DEFAULT NULL COMMENT '备注:所属课程 ',
  `pic_url` varchar(80) DEFAULT NULL COMMENT '备注:图片资源URL',
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pic` */

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '备注:评分标准编号',
  `score_content` varchar(100) DEFAULT NULL COMMENT '备注:内容 ',
  `score_course` int(11) DEFAULT NULL COMMENT '备注:所属课程 ',
  `courses_score` int(11) NOT NULL COMMENT '备注:课程编号',
  PRIMARY KEY (`score_id`),
  UNIQUE KEY `UK_2yv5mqvapxvo2ctw08rrfr7nk` (`courses_score`),
  CONSTRAINT `FKicayy96xbatmsb46axv12utit` FOREIGN KEY (`courses_score`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `score` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
