/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.9-log : Database - hwg
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hwg` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hwg`;

/*Table structure for table `coursecommenttb` */

DROP TABLE IF EXISTS `coursecommenttb`;

CREATE TABLE `coursecommenttb` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id 自增主键',
  `comment_content` varchar(500) NOT NULL COMMENT '评价内容',
  `comment_course_id` varchar(20) NOT NULL COMMENT '课程编号',
  `comment_like` int(10) unsigned DEFAULT NULL COMMENT '赞数',
  `comment_star` int(10) unsigned DEFAULT NULL COMMENT '评价星级',
  `comment_stu_id` varchar(20) NOT NULL COMMENT '学生编号',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评价时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coursecommenttb` */

/*Table structure for table `learnrecordtb` */

DROP TABLE IF EXISTS `learnrecordtb`;

CREATE TABLE `learnrecordtb` (
  `lr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:学习记录表主键',
  `learn_course_id` varchar(20) NOT NULL COMMENT '备注:课程编号',
  `learn_course_record` varchar(200) NOT NULL COMMENT '备注:学习进度',
  `learn_course_time` int(10) unsigned NOT NULL COMMENT '备注:视频进度记忆点',
  `learn_remark` varchar(200) DEFAULT NULL COMMENT '备注:学习记录备注',
  `learn_stu_id` varchar(20) NOT NULL COMMENT '备注:学生编号',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备注:最近修改时间',
  PRIMARY KEY (`lr_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `learnrecordtb` */

insert  into `learnrecordtb`(`lr_id`,`learn_course_id`,`learn_course_record`,`learn_course_time`,`learn_remark`,`learn_stu_id`,`update_time`) values (1,'1','1',1,'1','1','2018-12-21 10:15:14'),(2,'2','1',1,'1','1','2018-12-22 10:15:18'),(3,'3','1',1,'1','1','2018-12-23 10:15:26'),(4,'4','1',1,'1','1','2018-12-24 10:15:28'),(5,'5','1',1,'1','1','2018-12-25 10:15:31'),(6,'6','1',1,'1','1','2018-12-26 10:15:35'),(7,'7','1',1,'1','1','2018-12-27 10:15:42'),(8,'8','1',1,'1','1','2018-12-28 10:15:53'),(9,'5','2',1,'1','1','2018-12-25 10:15:31'),(10,'9','1',1,'1','1','2018-12-26 10:15:35');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
