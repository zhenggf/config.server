# config.server

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


增加文件 ~/config/config.client.properties

config.app.k1=appKey

config.app.k2=secret

config.service.url=http://host:port/config


