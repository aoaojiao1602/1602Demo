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
  `lr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学习记录id 自增主键',
  `learn_course_id` varchar(20) NOT NULL COMMENT '课程编号',
  `learn_course_record` varchar(100) NOT NULL COMMENT '章节记录',
  `learn_course_time` int(10) unsigned NOT NULL COMMENT '视频进度记忆点',
  `learn_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `learn_stu_id` varchar(20) NOT NULL COMMENT '学生id',
  PRIMARY KEY (`lr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `learnrecordtb` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
