SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS  `accesstoken`;
CREATE TABLE `accesstoken` (
  `access_token` varchar(512) DEFAULT NULL,
  `expires_in` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `accesstoken`(`access_token`,`expires_in`,`create_time`) values
('LAJEm9RKtaReNZNZRk5Bj5EqYUCSwQ_yk4uxJjRIMWWGneDmJq-Q6Eo8jdwaedxuG_PWmE2HhtildByt-FGVyOz_74Z5BrcBvsoJyC2HAzQOWRgAIAJRM','7200','1447487991853');
DROP TABLE IF EXISTS  `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `admin`(`id`,`userName`,`password`,`createTime`) values
('1','111','111','2015-09-12 22:17:08');
DROP TABLE IF EXISTS  `art`;
CREATE TABLE `art` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artNumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `artName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品名称',
  `artSize` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品尺寸100*80',
  `artMaterial` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品材质',
  `artAuthor` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品作者',
  `artCert` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作品证书',
  `artYear` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '年份',
  `artImage` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图',
  `artDesc` text COLLATE utf8mb4_unicode_ci COMMENT '作品文字描述',
  `createTime` datetime DEFAULT NULL,
  `artAudio` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '态状',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `art`(`id`,`artNumber`,`artName`,`artSize`,`artMaterial`,`artAuthor`,`artCert`,`artYear`,`artImage`,`artDesc`,`createTime`,`artAudio`,`status`) values
('21','10001','这是一个测试的','布','200*300','日本人','有意思的','2015','333f1ce0-b299-4b12-a7ac-b3acdccb4833.jpg','这是一个测试的，看出来什么效果。','2015-11-10 16:36:42','','1'),
('22','10002','这是一个测试二','铜版纸','200*200','中国人','好','2014','71ba0423-e239-4c98-8dd2-63e2506e10eb.jpg','这是一个测试二这是一个测试二这是一个测试二这是一个测试二','2015-11-10 16:53:58','','1');
DROP TABLE IF EXISTS  `art_museum`;
CREATE TABLE `art_museum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artId` int(11) DEFAULT NULL,
  `museumId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS  `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS  `batch`;
CREATE TABLE `batch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batchNumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `batchName` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS  `museum`;
CREATE TABLE `museum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `location` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `museum`(`id`,`name`,`createTime`,`location`) values
('1','南昌博物馆','2015-10-18 18:26:40','中国江西南昌'),
('2','杭州博物馆','2015-10-18 18:27:07','中国浙江杭州'),
('3','北京博物馆','2015-10-18 18:27:29','中国北京'),
('4','广州博物馆','2015-10-18 18:27:56','中国广东广州'),
('5','上海博物馆','2015-10-18 18:28:30','中国上海');
DROP TABLE IF EXISTS  `optlog`;
CREATE TABLE `optlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=458 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS  `system_config`;
CREATE TABLE `system_config` (
  `welcome_message` varchar(1000) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

insert into `system_config`(`welcome_message`,`id`) values
('欢迎到791艺术工厂','1');
DROP TABLE IF EXISTS  `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `openId` varchar(50) DEFAULT NULL COMMENT '微信id\n',
  `subscribeTime` bigint(11) DEFAULT NULL COMMENT '时间',
  `avatar` varchar(320) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像\n',
  `nickname` varchar(32) DEFAULT NULL COMMENT '名字',
  `sex` varchar(32) DEFAULT NULL,
  `language` varchar(32) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `province` varchar(32) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `headImgUrl` varchar(320) DEFAULT NULL,
  `sexId` int(32) DEFAULT NULL,
  `remark` varchar(320) DEFAULT NULL,
  `groupId` int(32) DEFAULT NULL,
  `unionId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

insert into `users`(`id`,`openId`,`subscribeTime`,`avatar`,`nickname`,`sex`,`language`,`city`,`province`,`country`,`headImgUrl`,`sexId`,`remark`,`groupId`,`unionId`) values
('2','okULfjhxtXK1Y2ggvW3YBgDD8A50','1447489368',null,null,null,null,null,null,null,null,null,null,null,null);
SET FOREIGN_KEY_CHECKS = 1;

