/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : jun_art
Target Host     : localhost:3306
Target Database : jun_art
Date: 2015-10-09 22:47:48
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '111', '111', '2015-09-12 22:17:08');

-- ----------------------------
-- Table structure for art
-- ----------------------------
DROP TABLE IF EXISTS `art`;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of art
-- ----------------------------
INSERT INTO `art` VALUES ('1', '123123', '123123', '123', null, '1231', '23213213', '213213', null, '123123', '2015-09-20 22:06:18', null, '1');
INSERT INTO `art` VALUES ('2', 'qqq', 'qqq', 'qqqq', null, 'qqq', 'qqqqqqqqqq', 'qqqqqq', null, 'qqqqq', '2015-09-26 11:40:57', null, '1');
INSERT INTO `art` VALUES ('3', '123123123', '123123', '12312312', '123123', '312312321', '3213', '123123123', 'artFiles/images/1443248376909.png', '123123123', '2015-09-26 14:19:50', '', '1');
INSERT INTO `art` VALUES ('4', '123123123444', '123123', '12312312', '123123', '312312321', '3213', '123123123', 'artFiles/images/1443248431385.jpg', '123123123', '2015-09-26 14:20:38', '', '1');
INSERT INTO `art` VALUES ('5', '1231232', '123123', '12312312', '123123', '312312321', '3213', '123123123', 'artFiles/images/1443248431385.jpg', '123123123', '2015-09-26 14:20:45', '', '1');
INSERT INTO `art` VALUES ('6', '1', '1', '1', '1', '1', '1', '1', 'artFiles/images/1443261136373.jpg', '1', '2015-09-26 17:52:26', '', '1');
INSERT INTO `art` VALUES ('7', '2', '2', '2', '2', '2', '2', '2', 'artFiles/images/1443261150737.jpg', '2', '2015-09-26 17:52:41', '', '1');
INSERT INTO `art` VALUES ('8', '3', '3', '3', '3', '3', '3', '3', 'artFiles/images/1443261164852.png', '3', '2015-09-26 17:52:53', '', '1');
INSERT INTO `art` VALUES ('9', '4', '4', '4', '4', '4', '4', '4', 'artFiles/images/1443261177854.jpg', '4', '2015-09-26 17:53:09', '', '1');
INSERT INTO `art` VALUES ('10', '5', '5', '5', '5', '5', '5', '5', 'artFiles/images/1443261195673.gif', '5', '2015-09-26 17:53:22', '', '1');
INSERT INTO `art` VALUES ('11', '6', '6', '6', '6', '6', '6', '6', 'artFiles/images/1443261206692.png', '6', '2015-09-26 17:53:38', '', '1');
INSERT INTO `art` VALUES ('12', '7', '7', '7', '7', '7', '7', '7', 'artFiles/images/1443261222035.jpg', '7', '2015-09-26 17:53:50', '', '1');
INSERT INTO `art` VALUES ('13', '8', '8', '8', '8', '8', '8', '8', 'artFiles/images/1443261261764.jpg', '8', '2015-09-26 17:54:35', '', '1');
INSERT INTO `art` VALUES ('14', 'asdfadsf', 'asdf', 'asdf', 'asdf', 'asdf', 'asdf', 'asdf', 'artFiles/images/1444397000704.jpg', 'asdfadsf', '2015-10-09 21:23:35', '', '1');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of author
-- ----------------------------

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batchNumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `batchName` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of batch
-- ----------------------------

-- ----------------------------
-- Table structure for optlog
-- ----------------------------
DROP TABLE IF EXISTS `optlog`;
CREATE TABLE `optlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of optlog
-- ----------------------------
