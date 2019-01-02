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
  `f_ufid` int(11) DEFAULT NULL COMMENT '备注:我的id',
  `f_uid` int(11) DEFAULT NULL COMMENT '备注:粉絲id',
  PRIMARY KEY (`f_fid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `fanstb` */

insert  into `fanstb`(`f_fid`,`f_ufid`,`f_uid`) values (1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,1,6),(6,2,1),(7,3,1),(8,4,1),(19,2,3);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1),(1);

/*Table structure for table `userinfotb` */

DROP TABLE IF EXISTS `userinfotb`;

CREATE TABLE `userinfotb` (
  `u_uid` int(10) unsigned NOT NULL COMMENT '备注:用户自动增长主键',
  `ui_birthday` datetime NOT NULL COMMENT '备注:出生年用',
  `ui_email` varchar(50) DEFAULT NULL COMMENT '备注:邮箱',
  `ui_headportrait` varchar(50) NOT NULL COMMENT '备注:用户头像url',
  `ui_headportraitid` int(11) DEFAULT NULL COMMENT '备注:用户头像id',
  `ui_headportraitname` varchar(20) DEFAULT NULL COMMENT '备注:用户头像名',
  `ui_identitycard` varchar(18) DEFAULT NULL COMMENT '备注:用户身份证',
  `ui_nickname` varchar(20) NOT NULL COMMENT '备注:用户昵称',
  `ui_phone` varchar(11) DEFAULT NULL COMMENT '备注:手机号',
  `ui_sex` varchar(5) DEFAULT NULL COMMENT '备注:性别',
  `ui_truename` varchar(8) DEFAULT NULL COMMENT '备注:用户真实姓名',
  `identity` varchar(50) DEFAULT NULL COMMENT '备注:用户身份类型',
  `education` varchar(50) DEFAULT NULL COMMENT '备注:用户最高学历',
  `industry` varchar(50) DEFAULT NULL COMMENT '备注:用户行业',
  `jianjie` varchar(300) DEFAULT NULL COMMENT '备注:用户个人简介',
  `yuanx` varchar(20) DEFAULT NULL COMMENT '备注:用户行业',
  PRIMARY KEY (`u_uid`),
  UNIQUE KEY `ui_nickname` (`ui_nickname`),
  UNIQUE KEY `ui_phone` (`ui_phone`),
  UNIQUE KEY `ui_identitycard` (`ui_identitycard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfotb` */

insert  into `userinfotb`(`u_uid`,`ui_birthday`,`ui_email`,`ui_headportrait`,`ui_headportraitid`,`ui_headportraitname`,`ui_identitycard`,`ui_nickname`,`ui_phone`,`ui_sex`,`ui_truename`,`identity`,`education`,`industry`,`jianjie`,`yuanx`) values (1,'1997-01-10 00:00:00','15836860043@163.com','img',1,'sss.png','610322199701106465','无敌真寂寞','15836860043','男','张三1','学生','博士','河南工業','九十六啊啊啊啊啊啊啊啊水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水啊啊啊啊啊啊啊','粮油食品学院'),(2,'1998-09-15 00:00:00','13137504390@163.com','img',2,'xinxi.jpg','610322199809151424','小老弟','13137504390','女','王晶','学生',NULL,'河南工業',NULL,'其他'),(3,'1966-03-15 00:00:00','13137404581@163.con','cdm',3,'998','610322196603154653','抓不死我','13137404581','男','王炸',NULL,NULL,NULL,NULL,NULL),(4,'1998-09-15 00:00:00','13137504350@163.com','cdm',4,'998','610322199809156465','武大郎','13137504350','男','闰土',NULL,NULL,NULL,NULL,NULL),(5,'1997-09-15 00:00:00','13137404350@163.com','cdm',5,'998','610322199709156465','智慧书','13137404350','男','李四',NULL,NULL,NULL,NULL,NULL),(6,'1996-09-15 00:00:00','13138404350@163.com','cdm',6,'998','610322199609156465','小王子','13138404350','男','王大力',NULL,NULL,NULL,NULL,NULL),(7,'1988-09-15 00:00:00','13138404355@163.com','cdm',6,'998','610322198809156465','小垃圾','13138404355','男','胡子昂',NULL,NULL,NULL,NULL,NULL),(8,'1989-09-15 00:00:00','13138404555@163.com','cdm',6,'998','610322198909156465','等哈说','13138404555','男','李建忠',NULL,NULL,NULL,NULL,NULL),(9,'1892-09-15 00:00:00','15836955044@163.com','img',6,'sss.png','610322189209154653','嘉年华','15836955044','女','李元',NULL,NULL,NULL,NULL,NULL),(10,'1779-05-06 00:00:00','15633463287@163.com','cdm',6,'998','610322177905064653','大苏打','15633463287','男','李元霸',NULL,NULL,NULL,NULL,NULL),(11,'1966-12-01 00:00:00','15215@qq.com','cdm',6,'998','610322196612014653','邪剑侠','15633563287','男','武田',NULL,NULL,NULL,NULL,NULL),(12,'1989-02-28 00:00:00','2658954@qq.com','cdm',6,'998','610322198902284653','狱血魔神','15639963287','男','张宇',NULL,NULL,NULL,NULL,NULL),(16,'1985-08-05 00:00:00','13284216525@163.com','cdm',6,'998','610322198508054653','阿修罗','13284216525','男','李迪',NULL,NULL,NULL,NULL,NULL),(17,'1996-05-04 00:00:00','17097764025@qq.com','cdm',6,'998','610322199605044653','鬼泣','17097764025','男','李迪',NULL,NULL,NULL,NULL,NULL),(18,'1980-11-04 00:00:00','15832394468@qq.com','cdm',6,'998','610322198011044653','剑魂','15832394468','男','白桦',NULL,NULL,NULL,NULL,NULL),(19,'1998-05-12 00:00:00','16584597652@163.com','cdm',6,'998','610322199805124653','苦瓜大王','16584597652','男','李博时',NULL,NULL,NULL,NULL,NULL),(20,'1980-11-05 00:00:00','16564564684@163.com','cdm',6,'998','610322198011054653','甜瓜','16564564684','女','李子田',NULL,NULL,NULL,NULL,NULL),(21,'1980-11-06 00:00:00','16564564685@163.com','cdm',6,'998','610322198011064653','西瓜','16564564685','男','胖虎',NULL,NULL,NULL,NULL,NULL),(22,'1980-11-07 00:00:00','16564564686@163.com','cdm',6,'998','610322198011074653','乌鸡','16564564686','男','张无忌',NULL,NULL,NULL,NULL,NULL),(23,'1980-11-08 00:00:00','16564564687@163.com','cdm',6,'998','610322198011084653','念皇','16564564687','男','笑无痕',NULL,NULL,NULL,NULL,NULL),(24,'1980-11-09 00:00:00','16564564688@163.com','cdm',6,'998','610322198011094653','套你猴子','16564564688','男','任一旭',NULL,NULL,NULL,NULL,NULL),(25,'1980-11-10 00:00:00','16564564689@163.com','cdm',6,'998','610322198011104653','大马猴','16564564689','男','任一旭',NULL,NULL,NULL,NULL,NULL),(26,'1980-11-11 00:00:00','16564564671@163.com','cdm',6,'998','610322198011114653','大暗黑天','16564564671','男','帝释天',NULL,NULL,NULL,NULL,NULL),(27,'1980-11-12 00:00:00','16564564672@163.com','cdm',6,'998','610322198011124653','天地独尊','16564564672','男','叶良晨',NULL,NULL,NULL,NULL,NULL),(28,'1980-11-13 00:00:00','16564564673@163.com','cdm',6,'998','610322198011134653','撼天动地','16564564673','男','赵日天',NULL,NULL,NULL,NULL,NULL),(29,'1988-11-14 00:00:00','16578064674@163.com','cdm',6,'998','610322198811144653','糊涂大王','16578064674','男','胡图图',NULL,NULL,NULL,NULL,NULL),(30,'1988-11-15 00:00:00','16578064675@163.com','cdm',6,'998','610322198811154653','魔法至尊','16578064675','男','李洛克',NULL,NULL,NULL,NULL,NULL),(31,'1988-11-16 00:00:00','16578064676@163.com','cdm',6,'998','610322198811164653','斗者','16578064676','男','张三丰',NULL,NULL,NULL,NULL,NULL),(32,'1988-09-06 00:00:00','16578064686@163.com','cdm',6,'998','61032219880964653','斗师','16578064686','男','西门吹雪',NULL,NULL,NULL,NULL,NULL),(35,'1988-09-07 00:00:00','16578064688@163.com','cdm',6,'998','61032219880974653','大斗师','16578064688','男','李华',NULL,NULL,NULL,NULL,NULL),(36,'1988-09-08 00:00:00','16578064689@163.com','cdm',6,'998','610322198809084653','斗灵','16578064689','男','李时珍',NULL,NULL,NULL,NULL,NULL),(37,'1988-09-10 00:00:00','16578154689@163.com','cdm',6,'998','610322198809104653','斗王','16578154689','男','华安',NULL,NULL,NULL,NULL,NULL),(38,'1984-02-13 00:00:00','16578154564@163.com','cdm',6,'998','610322198402134653','东站三号门','16578154564','男','巫溪',NULL,NULL,NULL,NULL,NULL),(39,'1984-02-15 00:00:00','16578154565@163.com','cdm',6,'998','610322198402154653','义气','16578154565','男','兰达',NULL,NULL,NULL,NULL,NULL),(40,'1984-02-16 00:00:00','16578154566@163.com','cdm',6,'998','610322198402164653','无法无土','16578154566','男','兰达',NULL,NULL,NULL,NULL,NULL),(41,'1984-02-17 00:00:00','16578154567@163.com','cdm',6,'998','610322198402174653','海盗船长','16578154567','男','杰克',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
