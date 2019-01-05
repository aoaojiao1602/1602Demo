/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.9-log : Database - liuwenjin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liuwenjin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `liuwenjin`;

/*Table structure for table `exam_questiontb` */

DROP TABLE IF EXISTS `exam_questiontb`;

CREATE TABLE `exam_questiontb` (
  `examquestiontb_examinfo_id` int(10) unsigned NOT NULL COMMENT '备注:自动增长主键',
  `examquestiontb_question_id` int(10) unsigned NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`examquestiontb_question_id`,`examquestiontb_examinfo_id`),
  KEY `FKnbpod8cuxmtls8v94pifu5ore` (`examquestiontb_examinfo_id`),
  CONSTRAINT `FKbxjuvdyty6ipcpn8s7jgcr4hm` FOREIGN KEY (`examquestiontb_question_id`) REFERENCES `questiontb` (`q_id`),
  CONSTRAINT `FKnbpod8cuxmtls8v94pifu5ore` FOREIGN KEY (`examquestiontb_examinfo_id`) REFERENCES `examinfotb` (`ex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_questiontb` */

insert  into `exam_questiontb`(`examquestiontb_examinfo_id`,`examquestiontb_question_id`) values (2,4),(2,15),(2,22),(2,28),(2,31),(2,44),(2,57),(2,65),(2,67),(2,68),(2,101),(2,107),(3,1),(3,10),(3,13),(3,36),(3,45),(3,48),(3,49),(3,61),(3,72),(3,77),(3,101),(3,107);

/*Table structure for table `examinfotb` */

DROP TABLE IF EXISTS `examinfotb`;

CREATE TABLE `examinfotb` (
  `ex_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cx_time` int(11) NOT NULL COMMENT '备注:持续时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '备注:考试结束时间',
  `exam_score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `exam_type` varchar(20) DEFAULT NULL COMMENT '备注:考试类型',
  `fillblank_num` int(11) DEFAULT NULL COMMENT '备注:填空题数量',
  `judge_num` int(11) DEFAULT NULL COMMENT '备注:判断题数量',
  `k_id` int(11) DEFAULT NULL COMMENT '备注:课程id',
  `option_num` int(11) DEFAULT NULL COMMENT '备注:选择题数量',
  `paper_name` varchar(100) NOT NULL COMMENT '备注:试卷名',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '备注:考试开始时间',
  `teacher_id` int(11) DEFAULT NULL COMMENT '备注:教师Id',
  PRIMARY KEY (`ex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `examinfotb` */

insert  into `examinfotb`(`ex_id`,`create_time`,`cx_time`,`end_time`,`exam_score`,`exam_type`,`fillblank_num`,`judge_num`,`k_id`,`option_num`,`paper_name`,`start_time`,`teacher_id`) values (1,'2019-01-02 18:07:37',2,'2019-01-04 00:00:00',100,'自主',1,2,NULL,10,'eeeeeeeeeee','2019-01-01 00:00:00',1),(2,'2019-01-02 22:15:48',2,'2019-01-04 00:00:00',100,'统一',1,2,NULL,10,'eeeeeeeeeee','2019-01-01 00:00:00',1),(3,'2019-01-02 23:14:42',2,'2019-01-03 10:00:00',100,'统一',1,2,NULL,10,'888888888','2019-01-03 08:00:00',1);

/*Table structure for table `fillblanktb` */

DROP TABLE IF EXISTS `fillblanktb`;

CREATE TABLE `fillblanktb` (
  `fillblank_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `answer` varchar(100) DEFAULT NULL COMMENT '备注:答案',
  `num` varchar(100) DEFAULT NULL COMMENT '备注:填空数量',
  `score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `topic` varchar(100) DEFAULT NULL COMMENT '备注:题目',
  PRIMARY KEY (`fillblank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fillblanktb` */

/*Table structure for table `judgetb` */

DROP TABLE IF EXISTS `judgetb`;

CREATE TABLE `judgetb` (
  `judge_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `answer` varchar(100) DEFAULT NULL COMMENT '备注:答案',
  `score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `topic` varchar(100) DEFAULT NULL COMMENT '备注:题目',
  PRIMARY KEY (`judge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `judgetb` */

insert  into `judgetb`(`judge_id`,`answer`,`score`,`topic`) values (1,'66',20,'1+1=2'),(2,'888',20,'666'),(3,'否',5,'666'),(4,'否',5,'6666');

/*Table structure for table `optiontb` */

DROP TABLE IF EXISTS `optiontb`;

CREATE TABLE `optiontb` (
  `option_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `answer` varchar(10) DEFAULT NULL COMMENT '备注:答案',
  `optiona` varchar(20) DEFAULT NULL COMMENT '备注:A选项',
  `optionb` varchar(20) DEFAULT NULL COMMENT '备注:B选项',
  `optionc` varchar(20) DEFAULT NULL COMMENT '备注:C选项',
  `optiond` varchar(20) DEFAULT NULL COMMENT '备注:D选项',
  `score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `topic` varchar(100) DEFAULT NULL COMMENT '备注:题目',
  PRIMARY KEY (`option_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

/*Data for the table `optiontb` */

insert  into `optiontb`(`option_id`,`answer`,`optiona`,`optionb`,`optionc`,`optiond`,`score`,`topic`) values (1,'D','四川菜系','山东菜系','广东菜系','淮扬菜系',5,'“大煮干丝”是哪个菜系的代表菜系之一（）。'),(2,'A','半发酵','发酵','不发酵','微发酵',5,'红茶属于（）茶。'),(3,'A','清代','唐代','宋代','两汉',5,'满汉全席起兴于（）。'),(4,'D','含蛋白质','含脂肪','含糖','含胆固醇',5,'吃冰淇淋不解渴主要是因为它：（）'),(5,'A','足球','篮球','冰球','橄榄球',5,'下列哪种球类没有“越位”的规则（）？'),(6,'B','1.20米','1.30米','1.40米','1.50米',5,'我国铁路规定身高多少的儿童要买全票（）？'),(7,'A','考试','拜师','做官','下山',5,'“敲门砖”一词源于：（）'),(8,'D','水彩画','油画','水粉画','国画',5,'工笔是哪种绘画形式的技法？（）'),(9,'A','英国','法国','美国','俄国',5,'“冰激凌”是从哪国传进的外来语？（）'),(10,'A','人名','地名','海名','山名',5,'“席梦思”三个字源于什么（）？'),(11,'D','韩非子、蓝采和、何翠谷、汉钟离','蓝采和、何仙姑、韩非子、汉钟离','韩湘子、蓝采和、何仙姑、红孩儿','韩湘子、蓝采和、何仙姑、汉钟离',5,'“八仙过海”中的八仙除铁拐李、张果老、吕洞宾、曹国舅外还有（）？'),(12,'A','英国《泰晤士报》','法国《费加罗报》','美国《太阳报》','德国《明镜》周刊E',5,'“无冕之王”的由来与下列哪一个有关（）？'),(13,'B','1964-1966','1966-1968','1969-1971','1971-1973',5,'老三届是指的哪几年毕业的初、高中毕业生'),(14,'A','秦','汉','唐','宋',5,'博士作为官名最早出现在：（）'),(15,'B','官场黑暗','科举制度','社会风气','诗词风格',5,'“谬种流传”最早是宋朝人批评当时的（）？'),(16,'D','四川民歌','蒙古民歌','云南民歌','青海民歌',5,'《在那遥远的地方》是哪里的民歌？（）'),(17,'C','肝','肾','眼球','心',5,'人体水含量百分比最高的器官是（）？'),(18,'C','胃','肾脏','肝脏','脾',5,'人体最大的解毒器官是（）？'),(19,'D','旗杆的一半处','下降1米','下降1.5米','距离杆顶的1/3处',5,'下半旗是把旗子下降到（）？'),(20,'D','夏纳-金棕榈','洛杉矶-奥斯卡','中国-金鸡','柏林-圣马克金狮',5,'下列地点与电影奖搭配不正确的是（）？'),(21,'A','平信','挂号信','保价邮件','特快专递邮件',5,'下列哪种邮件如果丢失了，邮局不负赔偿责任（）？'),(22,'D','琥珀酸','苹果酸','柠檬酸','单宁酸',5,'下面哪种酸，人在品尝的时候不是酸的（）？'),(23,'C','干燥处','通风处','日光照射处','卧室内',5,'土豆不宜存放在什么地方（）？'),(24,'A','灯比原来亮了','灯比原来暗了','跟原来一样','没有反应',5,'小华家的电灯丝断了，他把灯泡晃了晃使灯丝又搭上了，再用的时候会发现（）：'),(25,'C','200%','180%','150%','130%',5,'飞机票头等舱的票价一般为普通舱票价的（）：'),(26,'B','人名','地名','海名','山名',5,'马拉松赛跑中的“马拉松”一词是指：（）'),(27,'A','阮玲玉','王美人','上官云珠','胡蝶',5,'中国无声影片的最高峰《神女》是谁的代表作（）？'),(28,'D','容易打发小孩子','是灶神喜欢的食品','甜为吉利','用糖粘住灶神的牙',5,'中国民间“送灶神”时要吃粘牙的甜食，这是为了（）：'),(29,'C','张治中','张自忠','赵登禹','左权',5,'中国抗日战争中，最早为抗击日寇的中国将领是：（）？'),(30,'A','3种','4种','5种','6种',5,'中国铁路车票一般分为几种（）？'),(31,'A','饭前食用','饭后食用','晚上食用','早上食用',5,'什么时间吃水果比较好（）？'),(32,'B','夏','商','春秋','周',5,'从何时起，对最高统治者成“王”（）'),(33,'B','防腐剂','合成氧化剂','香精','食用色素',5,'方便面里必然有哪中食品添加剂（）？'),(34,'D','复合家庭','单身家庭','核心家庭','直系家庭',5,'父母和一个已婚子女及其配偶、后代所组成的家庭属于什么类型的家庭？'),(35,'B','中国紫禁城','英国王室','美国华尔街','旧金山',5,'世界上最贵的钻石藏在（）？'),(36,'C','印度尼西亚','伊拉克','阿富汗','伊朗',5,'世界上最高的立式佛像--巴米扬佛在哪个国家（）？'),(37,'C','根','茎','叶','汁',5,'仙人掌进行光合作用是依靠（）？'),(38,'C','红茶','绿茶','乌龙茶','花茶',5,'以下哪一类茶是半发酵茶（）？'),(39,'C','荣誉','富贵','禁戒','婚否',5,'古时戒指用来表示（）？'),(40,'C','汉武帝','汉成帝','汉文帝','汉景帝',5,'汉朝最先下诏废除肉刑的皇帝是（）？'),(41,'A','有','没有','穿鞋子','不穿鞋子',5,'光脚散步对小儿发育有好处吗（）？'),(42,'A','四川乐山','河南洛阳','四川屏山','四川江津',5,'全世界最大的石佛像在（）？'),(43,'B','锡中毒','铅中毒','铬中毒','纳中毒',5,'吃太多手摇爆米花机爆出的米花会导致（）？'),(44,'A','（e,t）','(t,h)','(h,m)','(m,e)',5,'在英语当中，哪两个字母出现的频率最高（）？'),(45,'B','千万以上','亿以上','千亿以上','兆亿以上',5,'多大的数字被称为天文数字（）？'),(46,'A','把整水壶烧到50°C','先烧开半壶水再掺半壶凉水','把水烧开等它变凉','烧开半壶水',5,'如果一壶50°C的温水，哪一种方法更节省燃料（）？'),(47,'B','银杏','银杉','白桦','白杨',5,'有“植物熊猫”之称的是（）？'),(48,'B','树','草','花','根',5,'竹子是（）？'),(49,'D','100公斤水','1000公斤水','一吨水','一立方米水',5,'自来水表上的一度水表表示耗水量为（）？'),(50,'B','印度西部','大西洋西部','印度洋西部','太平洋西部',5,'西印度群岛位于（）？'),(51,'ACD','居里夫人','格林加德','桑格','巴丁',5,'两次获得诺贝尔奖的有（）？'),(52,'D','元代的“宝钞”','元代的“交子”','宋代的“宝钞”','宋代的“交子”',5,'我国最先出现的纸币是：（）'),(53,'B','全球化的直营连锁','全球化的特许经营','全球化的流量营销','全球化的热量传递',5,'麦当劳的经营方式是（）？'),(54,'A','谷氨酸钠','醋酸','氯化钠','氢氧化钠',5,'味精的主要成分是什么（）？'),(55,'B','皮肤','舌头','眼睛','耳朵',5,'狗热时用什么散热（）？'),(56,'C','25颗','30颗','50颗','60颗',5,'现在美国国旗星条旗上有多少颗星（）？'),(57,'B','铁','锌','钙','维生素',5,'苹果中含有增强记忆力的微量元素是（）？'),(58,'B','899个字','无一字','1000个字','1200个字',5,'陕西乾陵武则天墓碑上有几个字（）？'),(59,'B','固定不变的','随外界的温度变化而变化','随体形的大小变化而变化','随风吹的干燥变化而变化',5,'鱼、蛙、蛇等冷血动物的体温是（）？'),(60,'B','泰国','印度','尼西亚','墨尔本',5,'举世闻名的泰姬陵在（）？'),(61,'A','麋鹿','白唇鹿','斑马','长颈鹿',5,'俗称“四不像”的动物是（）？'),(62,'B','正在寻找对象','正在恋爱中','表示独身','表示离婚',5,'按照风俗习惯戒指戴在中指上表示（）？'),(63,'B','防火','灭菌','防牲畜啃食','区分树木',5,'树干为什么常常刷成白色（）？'),(64,'A','牙膏','奶粉','洗洁精','香皂',5,'洗鱼后手上有腥味用下列哪种东西可以去除（）？'),(65,'B','杨玉环','赵飞燕','西施','貂蝉',5,'相传古代能做“掌上舞”的人是（）？'),(66,'B','主板股票市场','创业股票市场','投资股票市场','销售股票市场',5,'美国的纳斯达克股票市场属于（）？'),(67,'B','骨折','休克','心肌梗塞','头晕',5,'骨折时伴随休克发生，应先治（）？'),(68,'B','直着飞行','旋转飞行','垂直飞行','扭曲飞行',5,'射出去的子弹头是直着飞行还是旋转着（）？'),(69,'C','大卫','维纳斯','掷铁饼者','送花者',5,'被公认为体育运动和健美体魄象征的雕像是：（）？'),(70,'B','都会开花','不会开花','开花的比不开花的多','不开花的比开花的多',5,'菊花在秋天开，如果一直把菊花放在温暖的环境里，这些句话会怎么样（）？'),(71,'C','机械记忆能力','注意力','抽象思维能力','观察力',5,'智力的核心是（）？'),(72,'B','甜菜','蜂蜜','甘蔗','桃子',5,'最初的“糖果”的糖取自于）（）？'),(73,'C','祖父母、外祖父母、兄弟姐妹','兄弟姐妹、外祖父母、祖父母','兄弟姐妹、祖父母、外祖父母','外祖父母、祖父母、兄弟姐妹',5,'遗产继承的第二顺序是（）？'),(74,'A','古印度','古希腊','古埃及','古罗马',5,'数学符号中的“0”起源于（）？'),(75,'A','南方','北方','西方','东方',5,'馒头起源于（）？'),(76,'C','姜末','白糖','精盐','味精',5,'醋放久了会生白，为了防止其生白，最好在醋内加一些黄酒后再掺入少许（）？'),(77,'C','官燕','毛燕','血燕','飞燕',5,'燕窝中最珍贵的是（）？');

/*Table structure for table `questiontb` */

DROP TABLE IF EXISTS `questiontb`;

CREATE TABLE `questiontb` (
  `q_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `course_id` int(11) NOT NULL COMMENT '备注:课程id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `section_id` int(11) DEFAULT NULL COMMENT '备注:章节id',
  `teacher_id` int(11) NOT NULL COMMENT '备注:教师id',
  `fillblanks_id` int(10) unsigned DEFAULT NULL COMMENT '备注:自动增长主键',
  `judges_id` int(10) unsigned DEFAULT NULL COMMENT '备注:自动增长主键',
  `option_id` int(10) unsigned DEFAULT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`q_id`),
  UNIQUE KEY `UK_155qacp2loa06mgilo4sl1fbt` (`fillblanks_id`),
  UNIQUE KEY `UK_exbuw2cg5qakjuxxn8w1rlmq6` (`judges_id`),
  UNIQUE KEY `UK_qdnksr8pvhjnyddceok8hwnqi` (`option_id`),
  CONSTRAINT `FKefhyretk8oqj94tqfisvpy9fi` FOREIGN KEY (`fillblanks_id`) REFERENCES `fillblanktb` (`fillblank_id`),
  CONSTRAINT `FKrxrli1ax05cf88sddrmgo1mxq` FOREIGN KEY (`judges_id`) REFERENCES `judgetb` (`judge_id`),
  CONSTRAINT `FKtnm6yr7r77d1p5jf5ue2ifokt` FOREIGN KEY (`option_id`) REFERENCES `optiontb` (`option_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

/*Data for the table `questiontb` */

insert  into `questiontb`(`q_id`,`course_id`,`create_time`,`section_id`,`teacher_id`,`fillblanks_id`,`judges_id`,`option_id`) values (1,1,'2018-12-20 15:17:36',1,1,NULL,NULL,1),(2,1,'2018-12-18 16:02:03',1,1,NULL,NULL,2),(3,1,'2018-12-18 16:02:23',1,1,NULL,NULL,3),(4,1,'2018-12-18 16:05:15',1,1,NULL,NULL,4),(5,1,'2018-12-18 16:05:17',1,1,NULL,NULL,5),(6,1,'2018-12-18 16:05:19',1,1,NULL,NULL,6),(7,1,'2018-12-18 16:05:25',1,1,NULL,NULL,7),(8,1,'2018-12-18 17:44:04',1,1,NULL,NULL,8),(9,1,'2018-12-18 17:44:44',1,1,NULL,NULL,9),(10,1,'2018-12-18 17:44:39',1,1,NULL,NULL,10),(11,1,'2018-12-18 17:44:57',1,1,NULL,NULL,11),(12,1,'2018-12-18 17:45:05',1,1,NULL,NULL,12),(13,1,'2018-12-18 17:45:19',1,1,NULL,NULL,13),(14,1,'2018-12-18 17:45:27',1,1,NULL,NULL,14),(15,1,'2018-12-18 17:45:35',1,1,NULL,NULL,15),(16,1,'2018-12-18 17:45:43',1,1,NULL,NULL,16),(17,1,'2018-12-18 17:45:51',1,1,NULL,NULL,17),(18,1,'2018-12-18 17:46:00',1,1,NULL,NULL,18),(19,1,'2018-12-18 17:46:08',1,1,NULL,NULL,19),(20,1,'2018-12-18 17:46:16',1,1,NULL,NULL,20),(21,1,'2018-12-18 17:46:33',1,1,NULL,NULL,21),(22,1,'2018-12-18 17:46:41',1,1,NULL,NULL,22),(23,1,'2018-12-18 17:46:49',1,1,NULL,NULL,23),(24,1,'2019-01-03 12:01:13',7,1,NULL,NULL,24),(25,1,'2019-01-03 12:01:08',7,1,NULL,NULL,25),(26,1,'2019-01-03 12:01:07',7,1,NULL,NULL,26),(27,1,'2019-01-03 12:01:03',7,1,NULL,NULL,27),(28,1,'2019-01-03 12:01:02',7,1,NULL,NULL,28),(29,1,'2019-01-03 12:01:01',7,1,NULL,NULL,29),(30,1,'2019-01-03 12:01:00',7,1,NULL,NULL,30),(31,1,'2018-12-20 14:43:08',0,1,NULL,NULL,31),(32,1,'2018-12-20 14:43:29',NULL,1,NULL,NULL,32),(33,1,'2018-12-20 17:32:42',NULL,1,NULL,NULL,33),(34,1,'2018-12-20 17:32:50',NULL,1,NULL,NULL,34),(35,1,'2018-12-20 17:32:57',NULL,1,NULL,NULL,35),(36,1,'2018-12-20 17:33:03',NULL,1,NULL,NULL,36),(37,1,'2018-12-20 17:33:09',NULL,1,NULL,NULL,37),(38,1,'2018-12-20 17:33:14',NULL,1,NULL,NULL,38),(39,1,'2018-12-20 17:33:22',NULL,1,NULL,NULL,39),(40,1,'2018-12-20 17:33:29',NULL,1,NULL,NULL,40),(41,1,'2018-12-20 17:33:37',NULL,1,NULL,NULL,41),(42,1,'2018-12-20 17:33:42',NULL,1,NULL,NULL,42),(43,1,'2018-12-20 17:33:47',NULL,1,NULL,NULL,43),(44,1,'2018-12-20 17:33:54',NULL,1,NULL,NULL,44),(45,1,'2018-12-20 17:33:59',NULL,1,NULL,NULL,45),(46,1,'2018-12-20 17:34:03',NULL,1,NULL,NULL,46),(47,1,'2018-12-20 17:34:08',NULL,1,NULL,NULL,47),(48,1,'2018-12-20 17:34:13',NULL,1,NULL,NULL,48),(49,1,'2018-12-20 17:34:18',NULL,1,NULL,NULL,49),(50,1,'2018-12-20 17:34:23',NULL,1,NULL,NULL,50),(51,1,'2018-12-20 17:34:27',NULL,1,NULL,NULL,51),(52,1,'2018-12-20 17:34:32',NULL,1,NULL,NULL,52),(53,1,'2018-12-20 17:34:38',NULL,1,NULL,NULL,53),(54,1,'2018-12-20 17:34:42',NULL,1,NULL,NULL,54),(55,1,'2018-12-20 17:34:45',NULL,1,NULL,NULL,55),(56,1,'2018-12-20 17:34:50',NULL,1,NULL,NULL,56),(57,1,'2018-12-20 17:34:56',NULL,1,NULL,NULL,57),(58,1,'2018-12-20 17:35:00',NULL,1,NULL,NULL,58),(59,1,'2018-12-20 17:35:07',NULL,1,NULL,NULL,59),(60,1,'2018-12-20 17:35:13',NULL,1,NULL,NULL,60),(61,1,'2018-12-20 17:35:18',NULL,1,NULL,NULL,61),(64,1,'2018-12-20 17:35:35',NULL,1,NULL,NULL,62),(65,1,'2018-12-20 17:35:40',NULL,1,NULL,NULL,63),(66,1,'2018-12-20 17:35:46',NULL,1,NULL,NULL,64),(67,1,'2018-12-20 17:35:50',NULL,1,NULL,NULL,65),(68,1,'2018-12-20 17:35:55',NULL,1,NULL,NULL,66),(69,1,'2018-12-20 17:36:00',NULL,1,NULL,NULL,67),(70,1,'2018-12-20 17:36:05',NULL,1,NULL,NULL,68),(71,1,'2018-12-20 17:36:10',NULL,1,NULL,NULL,69),(72,1,'2018-12-20 17:36:15',NULL,1,NULL,NULL,70),(73,1,'2018-12-20 17:36:22',NULL,1,NULL,NULL,71),(74,1,'2018-12-20 17:36:27',NULL,1,NULL,NULL,72),(75,1,'2018-12-20 17:36:32',NULL,1,NULL,NULL,73),(76,1,'2018-12-20 17:36:37',NULL,1,NULL,NULL,74),(77,1,'2018-12-20 17:36:43',NULL,1,NULL,NULL,75),(78,1,'2018-12-20 17:36:49',NULL,1,NULL,NULL,76),(79,1,'2018-12-20 17:36:55',NULL,1,NULL,NULL,77),(101,1,'2019-01-02 17:47:08',NULL,1,NULL,1,NULL),(107,1,'2019-01-02 18:06:05',1,1,NULL,3,NULL),(108,1,'2019-01-02 18:07:11',1,1,NULL,4,NULL);

/*Table structure for table `student_exam_questiontb` */

DROP TABLE IF EXISTS `student_exam_questiontb`;

CREATE TABLE `student_exam_questiontb` (
  `seq_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `answer` varchar(100) DEFAULT NULL COMMENT '备注:考试答案',
  `exam_id` int(11) DEFAULT NULL COMMENT '备注:考试信息id',
  `questiontb_id` int(11) DEFAULT NULL COMMENT '备注:题库id',
  `student_id` int(11) DEFAULT NULL COMMENT '备注:学生id',
  PRIMARY KEY (`seq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `student_exam_questiontb` */

insert  into `student_exam_questiontb`(`seq_id`,`answer`,`exam_id`,`questiontb_id`,`student_id`) values (1,'B',1,1,6),(2,'D',1,76,6),(3,'B',1,32,6),(4,'D',1,77,6),(5,'A',1,42,6),(6,'C',1,15,6),(7,NULL,1,45,6),(8,'B',1,39,6),(9,'D',1,52,6),(10,'C',1,18,6),(11,'是',1,107,6),(12,'是',1,108,6),(13,NULL,2,4,6),(14,NULL,2,15,6),(15,NULL,2,22,6),(16,NULL,2,28,6),(17,NULL,2,31,6),(18,NULL,2,44,6),(19,NULL,2,57,6),(20,NULL,2,65,6),(21,NULL,2,67,6),(22,NULL,2,68,6),(23,NULL,2,101,6),(24,NULL,2,107,6);

/*Table structure for table `student_examinfotb` */

DROP TABLE IF EXISTS `student_examinfotb`;

CREATE TABLE `student_examinfotb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `exam_score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `student_id` int(11) DEFAULT NULL COMMENT '备注:学生id',
  `time` int(11) DEFAULT NULL COMMENT '备注:倒计时',
  `examinfo_id` int(10) unsigned NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`id`),
  KEY `FK8ic3u6sawfcobtmgvoseg82hq` (`examinfo_id`),
  CONSTRAINT `FK8ic3u6sawfcobtmgvoseg82hq` FOREIGN KEY (`examinfo_id`) REFERENCES `examinfotb` (`ex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `student_examinfotb` */

insert  into `student_examinfotb`(`id`,`exam_score`,`student_id`,`time`,`examinfo_id`) values (1,NULL,6,900000,1),(2,NULL,6,7200,2);

/*Table structure for table `student_test_questiontb` */

DROP TABLE IF EXISTS `student_test_questiontb`;

CREATE TABLE `student_test_questiontb` (
  `stq_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `answer` varchar(100) DEFAULT NULL COMMENT '备注:考试答案',
  `questiontb_id` int(11) DEFAULT NULL COMMENT '备注:题库id',
  `student_id` int(11) DEFAULT NULL COMMENT '备注:学生id',
  `test_id` int(11) DEFAULT NULL COMMENT '备注:测试信息id',
  PRIMARY KEY (`stq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student_test_questiontb` */

/*Table structure for table `student_testinfotb` */

DROP TABLE IF EXISTS `student_testinfotb`;

CREATE TABLE `student_testinfotb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `spare_time` int(11) DEFAULT NULL COMMENT '备注:测试剩余时间',
  `student_id` int(11) DEFAULT NULL,
  `test_num` int(11) DEFAULT NULL COMMENT '备注:测试次数',
  `test_score` int(11) DEFAULT NULL COMMENT '备注:分数',
  `testinfo_id` int(10) unsigned NOT NULL COMMENT '备注:自动增长主键',
  PRIMARY KEY (`id`),
  KEY `FKswauw68kpgpfq227auaip8051` (`testinfo_id`),
  CONSTRAINT `FKswauw68kpgpfq227auaip8051` FOREIGN KEY (`testinfo_id`) REFERENCES `testinfotb` (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `student_testinfotb` */

insert  into `student_testinfotb`(`id`,`spare_time`,`student_id`,`test_num`,`test_score`,`testinfo_id`) values (5,60,1,3,0,1);

/*Table structure for table `testinfotb` */

DROP TABLE IF EXISTS `testinfotb`;

CREATE TABLE `testinfotb` (
  `test_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:自动增长主键',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:测试建立时间',
  `option_num` int(11) DEFAULT NULL COMMENT '备注:选择题数量',
  `section_id` int(11) DEFAULT NULL COMMENT '备注:章节id',
  `spare_time` int(11) DEFAULT NULL COMMENT '备注:剩余时间',
  `teacher_id` int(11) DEFAULT NULL COMMENT '备注:教师Id',
  `test_name` varchar(100) DEFAULT NULL COMMENT '备注:测试试卷名',
  `test_num` int(11) DEFAULT NULL COMMENT '备注:测试次数',
  `test_score` int(11) DEFAULT NULL COMMENT '备注:分数',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `testinfotb` */

insert  into `testinfotb`(`test_id`,`create_time`,`option_num`,`section_id`,`spare_time`,`teacher_id`,`test_name`,`test_num`,`test_score`) values (1,'2019-01-03 11:09:34',1,7,60,1,'666666',5,100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
