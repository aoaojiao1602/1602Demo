/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.9-log : Database - gezhenzhen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gezhenzhen` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gezhenzhen`;

/*Table structure for table `commentgratetb` */

DROP TABLE IF EXISTS `commentgratetb`;

CREATE TABLE `commentgratetb` (
  `comment_grate_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：评论点赞表自动增长主键',
  `comment_grate_comment_id` int(10) unsigned NOT NULL COMMENT '备注：评论表id外键',
  `comment_grate_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  PRIMARY KEY (`comment_grate_id`),
  KEY `FKftl90jjveaqvtea1ltww8hcl7` (`comment_grate_comment_id`),
  CONSTRAINT `FKftl90jjveaqvtea1ltww8hcl7` FOREIGN KEY (`comment_grate_comment_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `commentgratetb` */

insert  into `commentgratetb`(`comment_grate_id`,`comment_grate_comment_id`,`comment_grate_uid`) values (1,1,1),(2,2,1),(3,3,1);

/*Table structure for table `commentnotgratetb` */

DROP TABLE IF EXISTS `commentnotgratetb`;

CREATE TABLE `commentnotgratetb` (
  `comment_not_grate_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：评论点踩表自动增长主键',
  `comment_not_grate_comment_id` int(10) unsigned NOT NULL COMMENT '备注：评论表id外键',
  `comment_not_grate_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  PRIMARY KEY (`comment_not_grate_id`),
  KEY `FKmp9glke3n533imibnrmwj0gg6` (`comment_not_grate_comment_id`),
  CONSTRAINT `FKmp9glke3n533imibnrmwj0gg6` FOREIGN KEY (`comment_not_grate_comment_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `commentnotgratetb` */

insert  into `commentnotgratetb`(`comment_not_grate_id`,`comment_not_grate_comment_id`,`comment_not_grate_uid`) values (1,1,2),(2,2,2),(3,3,2);

/*Table structure for table `commentreporttb` */

DROP TABLE IF EXISTS `commentreporttb`;

CREATE TABLE `commentreporttb` (
  `comment_report_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：评论举报表自动增长主键',
  `comment_report_comment_id` int(10) unsigned NOT NULL COMMENT '备注：评论表id外键',
  `comment_report_content` varchar(100) DEFAULT NULL,
  `comment_report_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comment_report_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  PRIMARY KEY (`comment_report_id`),
  KEY `FKecynnyvcca1mxbh4vw6extb5s` (`comment_report_comment_id`),
  CONSTRAINT `FKecynnyvcca1mxbh4vw6extb5s` FOREIGN KEY (`comment_report_comment_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `commentreporttb` */

/*Table structure for table `commenttb` */

DROP TABLE IF EXISTS `commenttb`;

CREATE TABLE `commenttb` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：评论表自动增长主键',
  `comment_content` varchar(200) DEFAULT NULL,
  `comment_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comment_reply_id` int(10) unsigned NOT NULL COMMENT '备注：回复表id外键',
  `comment_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id',
  `parent_id` int(10) unsigned NOT NULL COMMENT '备注：评论父id',
  PRIMARY KEY (`comment_id`),
  KEY `FKdf0lfjmgb5q3q80xi3lb5exto` (`comment_reply_id`),
  CONSTRAINT `FKdf0lfjmgb5q3q80xi3lb5exto` FOREIGN KEY (`comment_reply_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `commenttb` */

insert  into `commenttb`(`comment_id`,`comment_content`,`comment_createtime`,`comment_reply_id`,`comment_uid`,`parent_id`) values (1,'赞同','2018-12-13 11:27:43',1,1,0),(2,'赞同','2018-12-13 11:28:12',2,1,0),(3,'说的有道理','2018-12-13 11:28:31',3,1,0),(4,'有不会的也可以自己去百度查一下','2018-12-13 11:30:41',3,2,1),(5,'说的对','2018-12-15 15:59:53',1,2,1),(6,'说的好','2018-12-15 15:59:55',1,3,1);

/*Table structure for table `moduletb` */

DROP TABLE IF EXISTS `moduletb`;

CREATE TABLE `moduletb` (
  `module_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：模块自动增长主键',
  `module_name` varchar(20) DEFAULT NULL,
  `module_title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `moduletb` */

insert  into `moduletb`(`module_id`,`module_name`,`module_title`) values (1,'老师答疑区','发表关于作业、测试、课件内容希望能够得到老师回答的疑问'),(2,'课堂交流区','这里呈现的是在课件中作为教学内容的讨论'),(3,'综合堂论区','发表任何想与大家分享的经验及想法！关于本课程、学习、工作、生活等一般性话题');

/*Table structure for table `projectcounttb` */

DROP TABLE IF EXISTS `projectcounttb`;

CREATE TABLE `projectcounttb` (
  `project_count_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：课程点赞自动增长主键',
  `project_count_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_count_project_id` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`project_count_id`),
  KEY `FKpixtd18vrfui7ew22f9e0qb6y` (`project_count_project_id`),
  CONSTRAINT `FKpixtd18vrfui7ew22f9e0qb6y` FOREIGN KEY (`project_count_project_id`) REFERENCES `projecttb` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `projectcounttb` */

insert  into `projectcounttb`(`project_count_id`,`project_count_uid`,`project_count_project_id`) values (3,1,3),(4,1,4),(5,2,1),(6,2,2),(7,2,3),(9,3,2),(12,3,3);

/*Table structure for table `projectnotcounttb` */

DROP TABLE IF EXISTS `projectnotcounttb`;

CREATE TABLE `projectnotcounttb` (
  `project_not_count_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：贴吧点踩自动增长主键',
  `project_not_count_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_not_count_project_id` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`project_not_count_id`),
  KEY `FKbgsr79yrel7r24pqtceckak3a` (`project_not_count_project_id`),
  CONSTRAINT `FKbgsr79yrel7r24pqtceckak3a` FOREIGN KEY (`project_not_count_project_id`) REFERENCES `projecttb` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `projectnotcounttb` */

insert  into `projectnotcounttb`(`project_not_count_id`,`project_not_count_uid`,`project_not_count_project_id`) values (2,1,5),(3,1,6),(4,2,4),(5,2,5),(6,2,6),(7,3,4),(8,3,5),(9,3,6),(10,1,4);

/*Table structure for table `projectreplygoodtb` */

DROP TABLE IF EXISTS `projectreplygoodtb`;

CREATE TABLE `projectreplygoodtb` (
  `project_reply_good_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：回复点赞自动增长主键',
  `project_reply_good_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_reply_good_project_reply_id` int(10) unsigned NOT NULL COMMENT '备注：贴吧回复自动增长主键',
  PRIMARY KEY (`project_reply_good_id`),
  KEY `FKi4ufuba5ey1k2w361scl1upmv` (`project_reply_good_project_reply_id`),
  CONSTRAINT `FKi4ufuba5ey1k2w361scl1upmv` FOREIGN KEY (`project_reply_good_project_reply_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `projectreplygoodtb` */

insert  into `projectreplygoodtb`(`project_reply_good_id`,`project_reply_good_uid`,`project_reply_good_project_reply_id`) values (2,1,2),(3,1,3),(4,2,1),(5,2,2),(6,2,3),(7,3,1),(8,3,2),(9,3,3),(10,1,1);

/*Table structure for table `projectreplynotgoodtb` */

DROP TABLE IF EXISTS `projectreplynotgoodtb`;

CREATE TABLE `projectreplynotgoodtb` (
  `project_reply_not_good_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：回复点踩自动增长主键',
  `project_reply_not_good_project_reply_id` int(10) unsigned NOT NULL COMMENT '备注：回复表的id外键',
  `project_reply_not_good_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  PRIMARY KEY (`project_reply_not_good_id`),
  KEY `FKjr0yhx0wiprwxain82vjl9hk9` (`project_reply_not_good_project_reply_id`),
  CONSTRAINT `FKjr0yhx0wiprwxain82vjl9hk9` FOREIGN KEY (`project_reply_not_good_project_reply_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `projectreplynotgoodtb` */

insert  into `projectreplynotgoodtb`(`project_reply_not_good_id`,`project_reply_not_good_project_reply_id`,`project_reply_not_good_uid`) values (1,1,4),(2,2,4),(3,3,4);

/*Table structure for table `projectreplytb` */

DROP TABLE IF EXISTS `projectreplytb`;

CREATE TABLE `projectreplytb` (
  `project_reply_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：贴吧回复自动增长主键',
  `project_reply_content` varchar(200) DEFAULT NULL,
  `project_reply_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_reply_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_reply_project_id` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`project_reply_id`),
  KEY `FKck2stns8yyfv0ma3tyjq88ae3` (`project_reply_project_id`),
  CONSTRAINT `FKck2stns8yyfv0ma3tyjq88ae3` FOREIGN KEY (`project_reply_project_id`) REFERENCES `projecttb` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `projectreplytb` */

insert  into `projectreplytb`(`project_reply_id`,`project_reply_content`,`project_reply_create_time`,`project_reply_uid`,`project_reply_project_id`) values (1,'多听多写多读','2018-12-13 11:19:09',3,1),(2,'遇到不会的多跟老师交流','2018-12-13 11:19:48',4,1),(3,'自己在有时间的情况下多多看看英语书或是英语电影','2018-12-13 11:20:51',1,1),(4,'对于传视频我也不怎么会','2018-12-13 11:22:06',1,2),(5,'多做数学题','2018-12-13 11:22:45',2,3),(6,'用英语跟同学之间进行简单的英语交流','2018-12-13 11:23:59',2,4),(7,'百度或是有道上区查一下','2018-12-13 11:24:51',4,7),(8,'多多的练习','2018-12-15 09:22:39',1,1);

/*Table structure for table `projectreporttb` */

DROP TABLE IF EXISTS `projectreporttb`;

CREATE TABLE `projectreporttb` (
  `project_report_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：贴吧举报自动增长主键',
  `project_report_content` varchar(100) DEFAULT NULL,
  `project_report_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_report_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_report_project_id` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`project_report_id`),
  KEY `FK8ap01nf1ga9aie1s8vggdpdat` (`project_report_project_id`),
  CONSTRAINT `FK8ap01nf1ga9aie1s8vggdpdat` FOREIGN KEY (`project_report_project_id`) REFERENCES `projecttb` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `projectreporttb` */

insert  into `projectreporttb`(`project_report_id`,`project_report_content`,`project_report_time`,`project_report_uid`,`project_report_project_id`) values (1,'方法不是很好','2018-12-15 11:01:01',1,1);

/*Table structure for table `projecttb` */

DROP TABLE IF EXISTS `projecttb`;

CREATE TABLE `projecttb` (
  `project_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：课程贴吧自动增长主键',
  `clazz_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课件的id外键',
  `project_content` varchar(200) DEFAULT NULL,
  `project_createtime` date DEFAULT NULL,
  `project_last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_state` int(11) DEFAULT '0' COMMENT '备注：是否关注',
  `project_title` varchar(50) DEFAULT NULL,
  `u_id` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `project_moduleid` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`project_id`),
  KEY `FK56kax1tq1t4aefw3uvaqffhul` (`project_moduleid`),
  CONSTRAINT `FK3syqatbbnw5ndqjmhydq697np` FOREIGN KEY (`project_moduleid`) REFERENCES `projecttb` (`project_id`),
  CONSTRAINT `FK56kax1tq1t4aefw3uvaqffhul` FOREIGN KEY (`project_moduleid`) REFERENCES `moduletb` (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `projecttb` */

insert  into `projecttb`(`project_id`,`clazz_id`,`project_content`,`project_createtime`,`project_last_time`,`project_state`,`project_title`,`u_id`,`project_moduleid`) values (1,1,'如何的学习','2018-10-10','2018-12-14 23:02:33',0,'学习',1,1),(2,NULL,'问问老师，具体的我也不太清楚','2018-02-23','2018-12-13 10:36:48',0,'如何传视频',2,2),(3,NULL,'多多看看书，多写写数学题','2017-01-12','2018-12-15 12:32:08',0,'如何学习数学',3,3),(4,3,'多于别人进行口语上的交流','2017-10-11','2018-12-13 10:37:08',0,'如何提高英语的口语交际能力',3,2),(5,4,'多读多写多锻炼','2017-11-11','2018-12-13 10:37:16',0,'如何提高自己的读写能力',3,1),(6,4,'感谢老师上次百忙之中的回复，但我的成绩还是零分','2010-10-10','2018-12-15 11:37:19',0,'关于成绩是零的疑惑',3,1),(7,NULL,'可以百度查一下或是有道翻译一下','2010-12-12','2018-12-13 10:45:50',0,'不认识单词',3,3),(8,NULL,'上课的时候不要瞎想','2018-11-12','2018-12-14 15:08:15',0,'如何做听课效率会好些',1,2),(9,1,'好好的敲代码','2018-01-11','2018-12-14 22:23:48',0,'如何学习IT',3,1),(11,2,'上课的好好的听讲，课下多多练习','2016-01-12','2018-12-15 08:30:18',0,'如何学习2222',2,1);

/*Table structure for table `replyreporttb` */

DROP TABLE IF EXISTS `replyreporttb`;

CREATE TABLE `replyreporttb` (
  `reply_report_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：回复举报自动增长主键',
  `reply_report_content` varchar(100) DEFAULT NULL,
  `reply_report_reply_id` int(10) unsigned NOT NULL COMMENT '备注：回复表的id外键',
  `reply_report_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reply_report_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  PRIMARY KEY (`reply_report_id`),
  KEY `FKqfxsg7muihuer0nifwo10se6f` (`reply_report_reply_id`),
  CONSTRAINT `FKqfxsg7muihuer0nifwo10se6f` FOREIGN KEY (`reply_report_reply_id`) REFERENCES `projectreplytb` (`project_reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `replyreporttb` */

/*Table structure for table `throughtb` */

DROP TABLE IF EXISTS `throughtb`;

CREATE TABLE `throughtb` (
  `through_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：浏览表自动增长主键',
  `through_uid` int(10) unsigned NOT NULL COMMENT '备注：用户的id外键',
  `through_project_id` int(10) unsigned NOT NULL COMMENT '备注：课程贴吧自动增长主键',
  PRIMARY KEY (`through_id`),
  KEY `FKaod8oo5ov9nyrh0qesmjp69vn` (`through_project_id`),
  CONSTRAINT `FKaod8oo5ov9nyrh0qesmjp69vn` FOREIGN KEY (`through_project_id`) REFERENCES `projecttb` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `throughtb` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
