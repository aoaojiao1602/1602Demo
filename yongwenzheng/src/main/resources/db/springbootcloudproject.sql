/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20-log : Database - springbootcloudproject
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootcloudproject` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootcloudproject`;

/*Table structure for table `clazztb` */

DROP TABLE IF EXISTS `clazztb`;

CREATE TABLE `clazztb` (
  `class_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:班级id',
  `class_name` varchar(20) DEFAULT NULL COMMENT '备注:班级名称',
  `professional_id` int(10) unsigned DEFAULT NULL COMMENT '备注:专业id',
  PRIMARY KEY (`class_id`),
  KEY `FKhausash8pl5n0k985rv3jyujh` (`professional_id`),
  CONSTRAINT `FKhausash8pl5n0k985rv3jyujh` FOREIGN KEY (`professional_id`) REFERENCES `professionaltb` (`professional_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `clazztb` */

insert  into `clazztb`(`class_id`,`class_name`,`professional_id`) values (1,'1601',1),(2,'1602',2),(3,'1603',3),(4,'1604',4);

/*Table structure for table `coursetb` */

DROP TABLE IF EXISTS `coursetb`;

CREATE TABLE `coursetb` (
  `course_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:课程推荐id',
  `course_status` int(10) unsigned DEFAULT '0' COMMENT '备注:课程推荐',
  `course_weigh` int(10) unsigned DEFAULT '0' COMMENT '备注:权重',
  `kech_id` int(11) DEFAULT NULL COMMENT '备注:课程id',
  `nav_remark` varchar(100) DEFAULT NULL COMMENT '备注:备注',
  `navigation_id` int(11) DEFAULT NULL COMMENT '备注:导航id',
  `positions_id` int(11) DEFAULT '0' COMMENT '备注:位置id',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `coursetb` */

insert  into `coursetb`(`course_id`,`course_status`,`course_weigh`,`kech_id`,`nav_remark`,`navigation_id`,`positions_id`) values (1,1,1,1,NULL,1,1),(2,0,0,2,NULL,2,0),(3,0,0,3,NULL,3,0),(4,0,0,4,NULL,4,0),(5,0,0,5,NULL,5,0);

/*Table structure for table `departmenttb` */

DROP TABLE IF EXISTS `departmenttb`;

CREATE TABLE `departmenttb` (
  `department_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:院系id',
  `department_name` varchar(20) DEFAULT NULL COMMENT '备注:院系名称',
  `school_id` int(10) unsigned DEFAULT NULL COMMENT '备注:学校id',
  PRIMARY KEY (`department_id`),
  KEY `FKbk37m8jfw3fsuphlvn1y9x06i` (`school_id`),
  CONSTRAINT `FKbk37m8jfw3fsuphlvn1y9x06i` FOREIGN KEY (`school_id`) REFERENCES `schooltb` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `departmenttb` */

insert  into `departmenttb`(`department_id`,`department_name`,`school_id`) values (1,'经济学',1),(2,'法学',1),(3,'文学',1),(4,'理学',1),(5,'工学',1),(6,'农学',1),(7,'管理学',1),(8,'艺术学',1),(9,'材料与能源',1),(10,'土建',NULL);

/*Table structure for table `discusscoursetb` */

DROP TABLE IF EXISTS `discusscoursetb`;

CREATE TABLE `discusscoursetb` (
  `discusscourse_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:课程推荐id',
  `discuss_remark` varchar(100) DEFAULT NULL COMMENT '备注:备注',
  `discuss_status` int(10) unsigned DEFAULT '0' COMMENT '备注:主题推荐状态',
  `discuss_weigh` int(10) unsigned DEFAULT '0' COMMENT '备注:权重',
  `kech_id` int(11) DEFAULT NULL COMMENT '备注:课程id',
  `positions_id` int(11) DEFAULT '0' COMMENT '备注:位置id',
  `teacher_id` int(11) DEFAULT NULL COMMENT '备注:老师id',
  PRIMARY KEY (`discusscourse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `discusscoursetb` */

insert  into `discusscoursetb`(`discusscourse_id`,`discuss_remark`,`discuss_status`,`discuss_weigh`,`kech_id`,`positions_id`,`teacher_id`) values (1,NULL,1,0,1,0,1),(2,NULL,0,0,2,0,2),(3,NULL,0,0,3,0,3);

/*Table structure for table `module_roles` */

DROP TABLE IF EXISTS `module_roles`;

CREATE TABLE `module_roles` (
  `module_roles_id` int(10) unsigned NOT NULL COMMENT '备注:模块ID自动增长主键',
  `roles_module_id` int(10) unsigned NOT NULL COMMENT '备注:角色自动增长主键',
  PRIMARY KEY (`roles_module_id`,`module_roles_id`),
  KEY `FKmfhna7q31xel3qb5y26nqsrxj` (`module_roles_id`),
  CONSTRAINT `FK90xi84iksldito8637cqxn9gf` FOREIGN KEY (`roles_module_id`) REFERENCES `roletb` (`roles_id`),
  CONSTRAINT `FKmfhna7q31xel3qb5y26nqsrxj` FOREIGN KEY (`module_roles_id`) REFERENCES `moduletb` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `module_roles` */

insert  into `module_roles`(`module_roles_id`,`roles_module_id`) values (1,1),(2,1),(3,1),(3,2),(3,3),(4,1),(5,1),(6,1);

/*Table structure for table `moduletb` */

DROP TABLE IF EXISTS `moduletb`;

CREATE TABLE `moduletb` (
  `module_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:模块ID自动增长主键',
  `module_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `module_last_update_time` datetime DEFAULT NULL COMMENT '备注:模块修改时间',
  `module_name` varchar(20) NOT NULL COMMENT '备注:模块姓名',
  `module_url` varchar(50) DEFAULT NULL COMMENT '备注:模块路径',
  `module_weight` int(10) unsigned NOT NULL COMMENT '备注:模块权重',
  `parent_id` int(10) unsigned NOT NULL COMMENT '备注:父id',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `moduletb` */

insert  into `moduletb`(`module_id`,`module_create_time`,`module_last_update_time`,`module_name`,`module_url`,`module_weight`,`parent_id`) values (1,'2018-12-31 13:06:18',NULL,'系统设置','1',1,0),(2,'2018-12-31 13:08:57',NULL,'个人中心管理','2',2,0),(3,'2018-12-31 13:09:13',NULL,'推荐管理','3',3,0),(4,'2018-12-31 13:09:38',NULL,'用户管理','4',4,1),(5,'2018-12-31 13:09:51',NULL,'角色管理','5',5,1),(6,'2018-12-31 13:10:04',NULL,'模块管理','6',6,1),(7,'2018-12-31 13:10:22',NULL,'权限管理','7',7,1),(8,'2018-12-31 13:10:39',NULL,'个人中心','8',8,2),(9,'2018-12-31 13:10:57',NULL,'课程推荐管理','9',9,3),(10,'2018-12-31 13:11:15',NULL,'精彩推荐管理','10',10,3);

/*Table structure for table `navigation` */

DROP TABLE IF EXISTS `navigation`;

CREATE TABLE `navigation` (
  `nav_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:',
  `nav_name` varchar(20) NOT NULL COMMENT '备注:分类名',
  `nav_remark` varchar(100) DEFAULT NULL COMMENT '备注:备注',
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `navigation` */

insert  into `navigation`(`nav_id`,`nav_name`,`nav_remark`) values (1,'计算机',NULL),(2,'经济管理',NULL),(3,'考研',NULL),(4,'理工复习',NULL),(5,'心理学',NULL),(6,'外语',NULL),(7,'文学历史',NULL),(8,'艺术设计',NULL);

/*Table structure for table `permissions_roles` */

DROP TABLE IF EXISTS `permissions_roles`;

CREATE TABLE `permissions_roles` (
  `roles_permissions_id` int(10) unsigned NOT NULL COMMENT '备注:角色自动增长主键',
  `permissions_roles_id` int(10) unsigned NOT NULL COMMENT '备注:权限自动增长主键',
  PRIMARY KEY (`permissions_roles_id`,`roles_permissions_id`),
  KEY `FKfnpab2qkbp255mxhgtkkdg5sm` (`roles_permissions_id`),
  CONSTRAINT `FKbml1q1i4ismtbl85e18rrf2st` FOREIGN KEY (`permissions_roles_id`) REFERENCES `permissiontb` (`permission_id`),
  CONSTRAINT `FKfnpab2qkbp255mxhgtkkdg5sm` FOREIGN KEY (`roles_permissions_id`) REFERENCES `roletb` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permissions_roles` */

insert  into `permissions_roles`(`roles_permissions_id`,`permissions_roles_id`) values (1,1),(1,2),(2,1),(3,3),(4,4);

/*Table structure for table `permissiontb` */

DROP TABLE IF EXISTS `permissiontb`;

CREATE TABLE `permissiontb` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:权限自动增长主键',
  `permission_last_update_time` datetime DEFAULT NULL COMMENT '备注:权限最后修改時間',
  `permission_module` varchar(50) DEFAULT NULL COMMENT '备注:权限模型',
  `permission_name` varchar(50) DEFAULT NULL COMMENT '备注:权限名称',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '备注:权限值',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `permissiontb` */

insert  into `permissiontb`(`permission_id`,`permission_last_update_time`,`permission_module`,`permission_name`,`permission_value`) values (1,NULL,'订单管理','订单删除','order:deleteOrder'),(2,NULL,'订单管理','订单添加','order:addOrder'),(3,NULL,'教师管理','教师权限','teacher'),(4,NULL,'学生管理','学生权限','student');

/*Table structure for table `positiontb` */

DROP TABLE IF EXISTS `positiontb`;

CREATE TABLE `positiontb` (
  `position_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:',
  `position_name` varchar(20) DEFAULT NULL COMMENT '备注:位置名',
  `position_remark` varchar(20) DEFAULT NULL COMMENT '备注:备注',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `positiontb` */

insert  into `positiontb`(`position_id`,`position_name`,`position_remark`) values (1,'位置一',NULL),(2,'位置二',NULL),(3,'位置三',NULL),(4,'位置四',NULL),(5,'位置五',NULL);

/*Table structure for table `professionaltb` */

DROP TABLE IF EXISTS `professionaltb`;

CREATE TABLE `professionaltb` (
  `professional_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:专业id',
  `professional_name` varchar(20) DEFAULT NULL COMMENT '备注:专业名称',
  `department_id` int(10) unsigned DEFAULT NULL COMMENT '备注:院系id',
  PRIMARY KEY (`professional_id`),
  KEY `FK8jimwtr63b1jjn618mrrkdm9h` (`department_id`),
  CONSTRAINT `FK8jimwtr63b1jjn618mrrkdm9h` FOREIGN KEY (`department_id`) REFERENCES `departmenttb` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `professionaltb` */

insert  into `professionaltb`(`professional_id`,`professional_name`,`department_id`) values (1,'经济学专业',1),(2,'财政学专业',1),(3,'金融学专业',1),(4,'法学专业',2),(5,'英语专业',3),(6,'日语专业',3),(7,'网络与新媒体专业',3),(8,'应用物理学专业',4),(9,'化学专业',4),(10,'应用化学专业',4),(11,'生物技术专业',4),(12,'工程力学专业',5),(13,'机械类专业',5),(14,'机械设计制造及其自动化专业',5),(15,'过程装备与控制工程专业',5),(16,'动物科学专业',6),(17,'工程管理专业',7),(18,'工商管理专业',7),(19,'物流管理专业',7),(20,'化学系专业',7),(21,'播音与主持艺术专业',8),(22,'动画专业',8),(23,'材料工程技术专业',9),(24,'磨料磨具制造专业',9);

/*Table structure for table `rolemoduletb` */

DROP TABLE IF EXISTS `rolemoduletb`;

CREATE TABLE `rolemoduletb` (
  `role_module_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:角色模块自动增长主键',
  `module_id` int(10) unsigned NOT NULL COMMENT '备注:模块id',
  `role_id` int(10) unsigned NOT NULL COMMENT '备注:角色id',
  `role_module_last_update_time` datetime DEFAULT NULL COMMENT '备注:角色权限修改时间',
  PRIMARY KEY (`role_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rolemoduletb` */

/*Table structure for table `roletb` */

DROP TABLE IF EXISTS `roletb`;

CREATE TABLE `roletb` (
  `roles_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:角色自动增长主键',
  `roles_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `roles_explan` varchar(200) DEFAULT NULL COMMENT '备注:备注',
  `roles_last_update_time` datetime DEFAULT NULL COMMENT '备注:角色最后修改时间',
  `roles_name` varchar(20) NOT NULL COMMENT '备注:角色名称',
  PRIMARY KEY (`roles_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `roletb` */

insert  into `roletb`(`roles_id`,`roles_create_time`,`roles_explan`,`roles_last_update_time`,`roles_name`) values (1,'2018-12-18 15:22:18',NULL,NULL,'管理员'),(2,'2018-12-18 23:09:19',NULL,NULL,'经理'),(3,'2018-12-28 10:21:46',NULL,NULL,'老师'),(4,'2018-12-28 10:21:54',NULL,NULL,'学生'),(5,'2018-12-31 12:05:37','1',NULL,'2'),(6,'2018-12-31 13:01:55','1','2018-12-31 13:01:55','admin'),(7,'2018-12-31 14:33:58','ejfiisnfoiafh',NULL,'要记得那时候');

/*Table structure for table `schooltb` */

DROP TABLE IF EXISTS `schooltb`;

CREATE TABLE `schooltb` (
  `school_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:学校id',
  `school_name` varchar(20) DEFAULT NULL COMMENT '备注:学校名称',
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `schooltb` */

insert  into `schooltb`(`school_id`,`school_name`) values (1,'河南工业大学'),(2,'郑州大学'),(3,'北京大学'),(4,'清华大学'),(5,'武汉大学');

/*Table structure for table `users_clazz` */

DROP TABLE IF EXISTS `users_clazz`;

CREATE TABLE `users_clazz` (
  `users_clazz_id` int(10) unsigned NOT NULL COMMENT '备注:用户自动增长主键',
  `clazz_users_id` int(10) unsigned NOT NULL COMMENT '备注:班级id',
  PRIMARY KEY (`clazz_users_id`,`users_clazz_id`),
  KEY `FKd6y93pcf8h1qfhf3447utiid3` (`users_clazz_id`),
  CONSTRAINT `FK66gm32m7h5pabpfsmycef78x6` FOREIGN KEY (`clazz_users_id`) REFERENCES `clazztb` (`class_id`),
  CONSTRAINT `FKd6y93pcf8h1qfhf3447utiid3` FOREIGN KEY (`users_clazz_id`) REFERENCES `userstb` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_clazz` */

insert  into `users_clazz`(`users_clazz_id`,`clazz_users_id`) values (4,4),(5,2),(6,3);

/*Table structure for table `users_department` */

DROP TABLE IF EXISTS `users_department`;

CREATE TABLE `users_department` (
  `department_users_id` int(10) unsigned NOT NULL COMMENT '备注:专业id',
  `users_department_id` int(10) unsigned NOT NULL COMMENT '备注:用户自动增长主键',
  PRIMARY KEY (`users_department_id`,`department_users_id`),
  KEY `FKpln55qq1crcqkl5ywle9q2v8l` (`department_users_id`),
  CONSTRAINT `FKg7pqwrju0mfqfgh2tksfcecsd` FOREIGN KEY (`users_department_id`) REFERENCES `userstb` (`users_id`),
  CONSTRAINT `FKpln55qq1crcqkl5ywle9q2v8l` FOREIGN KEY (`department_users_id`) REFERENCES `professionaltb` (`professional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_department` */

insert  into `users_department`(`department_users_id`,`users_department_id`) values (1,1),(2,2),(3,3);

/*Table structure for table `users_roles` */

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `users_roles_id` int(10) unsigned NOT NULL COMMENT '备注:用户自动增长主键',
  `roles_users_id` int(10) unsigned NOT NULL COMMENT '备注:角色自动增长主键',
  PRIMARY KEY (`roles_users_id`,`users_roles_id`),
  KEY `FKo551tlyswwgsdnjr1c6d6q92r` (`users_roles_id`),
  CONSTRAINT `FKlebp7hgenwnj6ftxac6x35cew` FOREIGN KEY (`roles_users_id`) REFERENCES `roletb` (`roles_id`),
  CONSTRAINT `FKo551tlyswwgsdnjr1c6d6q92r` FOREIGN KEY (`users_roles_id`) REFERENCES `userstb` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_roles` */

insert  into `users_roles`(`users_roles_id`,`roles_users_id`) values (1,1),(1,2),(2,2),(3,3),(4,4);

/*Table structure for table `userstb` */

DROP TABLE IF EXISTS `userstb`;

CREATE TABLE `userstb` (
  `users_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:用户自动增长主键',
  `users_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `users_is_lockout` int(10) unsigned DEFAULT '0' COMMENT '备注:用户是否锁定',
  `users_last_login_ip` varchar(20) DEFAULT NULL COMMENT '备注:用户登录ip',
  `users_last_login_time` datetime DEFAULT NULL COMMENT '备注:用户最后登录时间',
  `users_lock_out_time` datetime DEFAULT NULL COMMENT '备注:用户最后锁定时间',
  `users_name` varchar(20) NOT NULL COMMENT '备注:用户姓名',
  `users_pass_wrong_count` int(10) unsigned DEFAULT '0' COMMENT '备注:用户锁定次数',
  `users_password` varchar(50) NOT NULL COMMENT '备注:用户密碼',
  `users_update_time` datetime DEFAULT NULL COMMENT '备注:用户修改時間',
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `userstb` */

insert  into `userstb`(`users_id`,`users_create_time`,`users_is_lockout`,`users_last_login_ip`,`users_last_login_time`,`users_lock_out_time`,`users_name`,`users_pass_wrong_count`,`users_password`,`users_update_time`) values (1,'2018-12-18 20:29:54',0,NULL,NULL,NULL,'admin',0,'5057b60362214024eb44c58e486919c1',NULL),(2,'2018-12-19 23:47:13',0,NULL,NULL,NULL,'ysd',0,'771447ec8368c43b5787dd46f36dfd23',NULL),(3,'2018-12-19 23:47:39',0,NULL,NULL,NULL,'ywz',0,'5e522e659f102da924c4182321c6a56f',NULL),(4,'2018-12-19 23:48:16',0,NULL,NULL,NULL,'张三',0,'17cf124c5b57f040fc940dd7057e6fb3',NULL),(5,'2018-12-19 23:48:40',0,NULL,NULL,NULL,'李四',0,'191f85a25ed03e02c61a782eaa5d00a2',NULL),(6,'2018-12-31 10:25:37',0,NULL,NULL,NULL,'王五',0,'0d1d8e84b1986277ee1f23c25298589f','2018-12-31 10:25:37'),(7,'2018-12-31 10:11:45',0,NULL,NULL,NULL,'1',0,'098e0d900f4411dcb9e3775874411b80',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
