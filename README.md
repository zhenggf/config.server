# config.server

目的和意义
大部分企业系统，都会有很多需要动态配置的信息，一般情况下，都是通过配置文件来配置，系统启动时加载配置文件
把配置信息注入到应用的对象中，参与各种业务逻辑运算；
当一个企业的应用特别多的时候，每个应用会有很多配置项，应用之间的配置项也有很多重复的地方，如果某个配置项需要修改，
需要影响到很多台服务器里面的配置文件，修改成本非常高，同时还可能会因为漏修改某台服务器而产生系统错误
所以，我们认为有必要把配置信息集中在一个地方有组织的管理起来。这句是统一配置服务平台的作用。


问题
集中存储敏感的配置信息，可能存在有一定的信息安全隐患

使用说明

1、安装并登录mysql

2、创建数据库
create database configdb default charset utf8


3、新增配置文件（linux下，windows的自己琢磨）
mkdir ~/config


增加文件 ~/config/config.properties

database.driver=com.mysql.jdbc.Driver

database.url=jdbc:mysql://127.0.0.1:3306/configdb?useUnicode=true&amp;characterEncoding=UTF-8

database.password=dbpasword

database.user=dbuser

4、启动服务
cd config
mvn clean install
cd ..
cd config.service
mvn clean jetty:run



5、增加文件 ~/config/config.client.properties

config.app.k1=appKey

config.app.k2=secret

config.service.url=http://host:port/config

6、测试
cd config.client
mvn clean test

