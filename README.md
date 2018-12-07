hihuijiaoxue（智慧教学）为1602班总项目
-------------------------------项目结构介绍----------------------------------------
├── db                                 数据库
│   ├── gezhenzhenDb                        葛珍珍数据库
│   ├── huangjiongDb                        黄炯数据库
│   ├── liuhaofeiDb                         刘豪飞数据库
│   ├── liuwenjinDb                         刘文金数据库
│   ├── yongwenzhengDb                      雍文正数据库
│   ├── zhulonghaoDb                        朱龙豪数据库
├── gezhenzhen                        葛珍珍项目
├── huangjiong                        黄炯数项目
├── liuhaofei                         刘豪飞项目
├── liuwenjin                         刘文金项目
├── yongwenzheng                      雍文正项目
├── zhulonghao                        朱龙豪项目
├── static                            静态资源（前台项目）
├── pom.xml 
-------------------------------项目规范说明---------------------------------------
版本
Spring Boot version 1.5.2.RELEASE
Spring Boot lombok version 1.16.12.RELEASE
jdk 1.8+
端口号
8888 注册中心
eureka注册中心地址
defaultZone: http://localhost:8888/eureka/
注册服务名称（ application: name） 组长名全拼
8001 黄炯组
8002 葛珍珍
8003 朱龙豪
8004 刘文金
8005 刘豪飞
8006 雍文正
命名规范
实体类大写
方法小驼峰命名
	restful风格（put,delete,post,get）增，删，改，查
带条件方法用 XXXand XXX by 等标识
项目名、数据库名以组长的全拼小写 如雍文正(yongwenzheng)
GitHub远程仓库地址
https://github.com/aoaojiao1602/1602Demo.git
账号密码找自己的组长要

