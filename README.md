zhihuijiaoxue（智慧教学）为1602班总项目<br/>
-------------------------------项目结构介绍----------------------------------------<br/>
├── db                                数据库<br/>
├── eureka                            注册中心项目8888<br/>
├── zuul                              网关8080<br/>
│   ├── gezhenzhenDb                        葛珍珍数据库<br/>
│   ├── huangjiongDb                        黄炯数据库<br/>
│   ├── liuhaofeiDb                         刘豪飞数据库<br/>
│   ├── liuwenjinDb                         刘文金数据库<br/>
│   ├── yongwenzhengDb                      雍文正数据库<br/>
│   ├── zhulonghaoDb                        朱龙豪数据库<br/>
├── gezhenzhen                        葛珍珍项目<br/>
├── huangjiong                        黄炯数项目<br/>
├── liuhaofei                         刘豪飞项目<br/>
├── liuwenjin                         刘文金项目<br/>
├── yongwenzheng                      雍文正项目<br/>
├── zhulonghao                        朱龙豪项目<br/>
├── static                            静态资源（前台项目）<br/>
├── pom.xml <br/>
-------------------------------项目规范说明---------------------------------------<br/>
版本<br/>
Spring Boot version 1.5.2.RELEASE<br/>
Spring Boot lombok version 1.16.12.RELEASE<br/>
jdk 1.8+<br/>
端口号<br/>
8888 注册中心<br/>
eureka注册中心地址<br/>
defaultZone: http://localhost:8888/eureka/<br/>
注册服务名称（ application: name） 组长名全拼<br/>
网关<br/>
端口号8080<br/>
8010 黄炯组<br/>
8020 葛珍珍<br/>
8030 朱龙豪<br/>
8040 刘文金<br/>
8050 刘豪飞<br/>
8060 雍文正<br/>
命名规范<br/>
实体类大写<br/>
方法小驼峰命名<br/>
	restful风格（put,delete,post,get）增，删，改，查<br/>
带条件方法用 XXXand XXX by 等标识<br/>
项目名、数据库名以组长的全拼小写 如雍文正(yongwenzheng)<br/>
GitHub远程仓库地址<br/>
https://github.com/aoaojiao1602/1602Demo.git<br/>
账号密码找自己的组长要<br/>

