/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : jun_art
Target Host     : localhost:3306
Target Database : jun_art
Date: 2015-10-18 18:56:22
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of art
-- ----------------------------
INSERT INTO `art` VALUES ('17', 'sadfaf', 'sadfaf', 'sadfaf', 'sadfaf', 'sadfaf', 'sadfaf', 'sadfaf', 'artFiles/images/1445156786045.jpg', 'sadfafsadfaf', '2015-10-18 16:26:39', '', '1');
INSERT INTO `art` VALUES ('18', '11111', '11111', '11111', '11111', '11111', '11111', '11111', 'artFiles/images/1445156786045.jpg', '11111asdadsf阿斯顿发放 阿斯顿发大声道发得分爱的发多少爱的发的阿的说法啊发的发的发发的发的爱的阿道夫阿发打发打aafdas阿斯顿发斯蒂芬阿道夫阿发阿斯顿发阿达的说法爱的发发实打实的发多少爱的阿达啊发啊', '2015-10-18 16:26:54', '', '1');
INSERT INTO `art` VALUES ('19', '22222', '22222', '22222', '22222', '22222', '22222', '22222', 'artFiles/images/1445156786045.jpg', '22222', '2015-10-18 16:27:10', '', '1');

-- ----------------------------
-- Table structure for art_museum
-- ----------------------------
DROP TABLE IF EXISTS `art_museum`;
CREATE TABLE `art_museum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artId` int(11) DEFAULT NULL,
  `museumId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of art_museum
-- ----------------------------
INSERT INTO `art_museum` VALUES ('1', '17', '1', '2015-10-18 18:28:52');
INSERT INTO `art_museum` VALUES ('2', '18', '1', '2015-10-18 18:29:04');
INSERT INTO `art_museum` VALUES ('3', '19', '1', '2015-10-18 18:29:11');
INSERT INTO `art_museum` VALUES ('4', '17', '2', '2015-10-18 18:30:45');
INSERT INTO `art_museum` VALUES ('5', '18', '2', '2015-10-18 18:30:42');
INSERT INTO `art_museum` VALUES ('6', '19', '2', '2015-10-18 18:30:39');
INSERT INTO `art_museum` VALUES ('7', '17', '3', '2015-10-18 18:30:37');
INSERT INTO `art_museum` VALUES ('8', '18', '3', '2015-10-18 18:30:34');
INSERT INTO `art_museum` VALUES ('9', '19', '3', '2015-10-18 18:30:31');
INSERT INTO `art_museum` VALUES ('10', '17', '4', '2015-10-18 18:30:26');
INSERT INTO `art_museum` VALUES ('11', '18', '4', '2015-10-18 18:30:29');
INSERT INTO `art_museum` VALUES ('12', '19', '4', '2015-10-18 18:30:24');
INSERT INTO `art_museum` VALUES ('13', '17', '5', '2015-10-18 18:30:22');
INSERT INTO `art_museum` VALUES ('14', '18', '5', '2015-10-18 18:30:19');

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
-- Table structure for museum
-- ----------------------------
DROP TABLE IF EXISTS `museum`;
CREATE TABLE `museum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `location` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of museum
-- ----------------------------
INSERT INTO `museum` VALUES ('1', '南昌博物馆', '2015-10-18 18:26:40', '中国江西南昌');
INSERT INTO `museum` VALUES ('2', '杭州博物馆', '2015-10-18 18:27:07', '中国浙江杭州');
INSERT INTO `museum` VALUES ('3', '北京博物馆', '2015-10-18 18:27:29', '中国北京');
INSERT INTO `museum` VALUES ('4', '广州博物馆', '2015-10-18 18:27:56', '中国广东广州');
INSERT INTO `museum` VALUES ('5', '上海博物馆', '2015-10-18 18:28:30', '中国上海');

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
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of optlog
-- ----------------------------
INSERT INTO `optlog` VALUES ('1', '2015-10-18 14:58:05', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('2', '2015-10-18 14:58:25', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('3', '2015-10-18 14:58:27', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('4', '2015-10-18 14:58:27', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('5', '2015-10-18 14:58:59', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('6', '2015-10-18 14:59:12', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('7', '2015-10-18 14:59:12', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('8', '2015-10-18 14:59:12', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('9', '2015-10-18 14:59:17', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('10', '2015-10-18 14:59:23', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('11', '2015-10-18 14:59:27', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('12', '2015-10-18 15:05:34', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('13', '2015-10-18 15:05:35', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('14', '2015-10-18 15:05:35', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('15', '2015-10-18 15:05:37', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('16', '2015-10-18 15:05:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('17', '2015-10-18 15:05:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('18', '2015-10-18 15:05:41', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('19', '2015-10-18 15:05:41', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('20', '2015-10-18 15:05:41', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('21', '2015-10-18 15:05:48', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('22', '2015-10-18 15:05:48', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('23', '2015-10-18 15:05:48', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('24', '2015-10-18 15:06:48', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('25', '2015-10-18 15:06:49', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('26', '2015-10-18 15:06:53', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('27', '2015-10-18 15:06:56', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('28', '2015-10-18 15:06:57', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('29', '2015-10-18 15:07:00', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('30', '2015-10-18 15:07:06', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('31', '2015-10-18 15:07:06', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('32', '2015-10-18 15:14:43', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('33', '2015-10-18 15:14:43', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('34', '2015-10-18 15:14:47', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('35', '2015-10-18 15:14:56', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('36', '2015-10-18 15:15:29', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('37', '2015-10-18 15:15:30', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('38', '2015-10-18 15:15:33', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('39', '2015-10-18 15:25:59', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('40', '2015-10-18 15:26:00', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('41', '2015-10-18 15:27:27', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('42', '2015-10-18 15:27:28', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('43', '2015-10-18 15:31:45', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('44', '2015-10-18 15:31:46', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('45', '2015-10-18 15:31:53', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('46', '2015-10-18 15:32:19', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('47', '2015-10-18 15:32:20', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('48', '2015-10-18 15:32:26', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('49', '2015-10-18 15:32:31', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('50', '2015-10-18 15:32:44', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('51', '2015-10-18 15:32:56', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('52', '2015-10-18 15:33:10', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('53', '2015-10-18 15:33:11', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('54', '2015-10-18 15:33:22', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('55', '2015-10-18 15:34:04', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('56', '2015-10-18 15:34:08', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('57', '2015-10-18 15:34:10', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('58', '2015-10-18 15:34:12', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('59', '2015-10-18 15:34:13', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('60', '2015-10-18 15:34:24', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('61', '2015-10-18 15:35:01', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('62', '2015-10-18 15:35:02', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('63', '2015-10-18 15:35:11', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('64', '2015-10-18 15:35:18', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('65', '2015-10-18 15:35:48', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('66', '2015-10-18 15:35:49', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('67', '2015-10-18 15:35:54', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('68', '2015-10-18 15:36:00', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('69', '2015-10-18 15:36:00', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('70', '2015-10-18 15:36:05', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('71', '2015-10-18 15:36:13', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('72', '2015-10-18 15:40:51', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('73', '2015-10-18 15:40:52', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('74', '2015-10-18 15:41:02', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('75', '2015-10-18 15:41:02', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('76', '2015-10-18 15:41:07', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('77', '2015-10-18 15:41:08', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('78', '2015-10-18 15:41:16', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('79', '2015-10-18 15:41:16', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('80', '2015-10-18 15:41:25', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('81', '2015-10-18 15:41:25', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('82', '2015-10-18 15:44:34', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('83', '2015-10-18 15:44:35', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('84', '2015-10-18 15:44:38', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('85', '2015-10-18 15:44:46', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('86', '2015-10-18 15:45:07', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('87', '2015-10-18 15:45:09', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('88', '2015-10-18 15:45:20', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('89', '2015-10-18 15:45:22', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('90', '2015-10-18 15:45:24', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('91', '2015-10-18 15:45:38', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('92', '2015-10-18 15:45:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('93', '2015-10-18 15:47:53', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('94', '2015-10-18 15:47:54', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('95', '2015-10-18 15:48:01', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('96', '2015-10-18 15:48:01', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('97', '2015-10-18 15:49:41', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('98', '2015-10-18 15:49:41', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('99', '2015-10-18 15:49:50', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('100', '2015-10-18 15:50:22', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('101', '2015-10-18 15:50:23', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('102', '2015-10-18 15:51:05', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('103', '2015-10-18 15:51:16', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('104', '2015-10-18 15:51:17', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('105', '2015-10-18 15:54:48', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('106', '2015-10-18 15:54:49', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('107', '2015-10-18 15:54:56', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('108', '2015-10-18 15:54:56', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('109', '2015-10-18 16:00:35', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('110', '2015-10-18 16:00:36', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('111', '2015-10-18 16:00:46', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('112', '2015-10-18 16:00:46', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('113', '2015-10-18 16:00:50', '1', '/art/admin/art/del.form');
INSERT INTO `optlog` VALUES ('114', '2015-10-18 16:00:50', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('115', '2015-10-18 16:00:52', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('116', '2015-10-18 16:00:53', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('117', '2015-10-18 16:00:57', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('118', '2015-10-18 16:00:57', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('119', '2015-10-18 16:09:18', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('120', '2015-10-18 16:09:37', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('121', '2015-10-18 16:09:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('122', '2015-10-18 16:09:47', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('123', '2015-10-18 16:09:48', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('124', '2015-10-18 16:10:40', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('125', '2015-10-18 16:10:40', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('126', '2015-10-18 16:12:10', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('127', '2015-10-18 16:12:11', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('128', '2015-10-18 16:14:37', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('129', '2015-10-18 16:14:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('130', '2015-10-18 16:19:00', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('131', '2015-10-18 16:19:01', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('132', '2015-10-18 16:19:23', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('133', '2015-10-18 16:19:24', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('134', '2015-10-18 16:19:30', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('135', '2015-10-18 16:19:31', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('136', '2015-10-18 16:20:45', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('137', '2015-10-18 16:20:46', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('138', '2015-10-18 16:21:57', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('139', '2015-10-18 16:21:57', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('140', '2015-10-18 16:22:54', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('141', '2015-10-18 16:22:55', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('142', '2015-10-18 16:23:07', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('143', '2015-10-18 16:23:08', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('144', '2015-10-18 16:23:27', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('145', '2015-10-18 16:23:50', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('146', '2015-10-18 16:23:51', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('147', '2015-10-18 16:24:55', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('148', '2015-10-18 16:24:57', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('149', '2015-10-18 16:26:16', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('150', '2015-10-18 16:26:18', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('151', '2015-10-18 16:26:19', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('152', '2015-10-18 16:26:23', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('153', '2015-10-18 16:26:26', '1', '/art/admin/art/file/upload.form');
INSERT INTO `optlog` VALUES ('154', '2015-10-18 16:26:32', '1', '/art/admin/art/number/valid.form');
INSERT INTO `optlog` VALUES ('155', '2015-10-18 16:26:39', '1', '/art/admin/art/save.form');
INSERT INTO `optlog` VALUES ('156', '2015-10-18 16:26:47', '1', '/art/admin/art/number/valid.form');
INSERT INTO `optlog` VALUES ('157', '2015-10-18 16:26:54', '1', '/art/admin/art/save.form');
INSERT INTO `optlog` VALUES ('158', '2015-10-18 16:27:03', '1', '/art/admin/art/number/valid.form');
INSERT INTO `optlog` VALUES ('159', '2015-10-18 16:27:10', '1', '/art/admin/art/save.form');
INSERT INTO `optlog` VALUES ('160', '2015-10-18 16:27:12', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('161', '2015-10-18 16:27:13', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('162', '2015-10-18 16:29:53', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('163', '2015-10-18 16:29:54', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('164', '2015-10-18 16:29:59', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('165', '2015-10-18 16:30:13', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('166', '2015-10-18 16:30:23', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('167', '2015-10-18 16:31:31', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('168', '2015-10-18 16:31:33', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('169', '2015-10-18 16:31:37', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('170', '2015-10-18 16:31:39', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('171', '2015-10-18 16:31:48', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('172', '2015-10-18 16:32:36', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('173', '2015-10-18 16:32:42', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('174', '2015-10-18 16:41:42', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('175', '2015-10-18 16:41:43', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('176', '2015-10-18 16:52:21', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('177', '2015-10-18 16:52:22', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('178', '2015-10-18 16:53:56', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('179', '2015-10-18 16:53:57', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('180', '2015-10-18 16:54:02', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('181', '2015-10-18 16:54:14', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('182', '2015-10-18 16:54:31', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('183', '2015-10-18 16:54:59', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('184', '2015-10-18 16:55:00', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('185', '2015-10-18 16:55:10', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('186', '2015-10-18 16:58:17', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('187', '2015-10-18 16:58:21', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('188', '2015-10-18 16:58:22', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('189', '2015-10-18 16:58:26', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('190', '2015-10-18 17:00:42', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('191', '2015-10-18 17:00:43', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('192', '2015-10-18 17:00:48', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('193', '2015-10-18 17:01:20', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('194', '2015-10-18 17:01:20', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('195', '2015-10-18 17:01:24', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('196', '2015-10-18 17:01:38', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('197', '2015-10-18 17:01:38', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('198', '2015-10-18 17:01:41', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('199', '2015-10-18 17:01:44', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('200', '2015-10-18 17:01:47', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('201', '2015-10-18 17:01:59', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('202', '2015-10-18 17:02:02', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('203', '2015-10-18 17:02:02', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('204', '2015-10-18 17:02:16', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('205', '2015-10-18 17:05:17', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('206', '2015-10-18 17:11:03', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('207', '2015-10-18 17:11:32', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('208', '2015-10-18 17:14:31', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('209', '2015-10-18 17:14:44', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('210', '2015-10-18 17:14:44', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('211', '2015-10-18 17:14:45', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('212', '2015-10-18 17:18:02', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('213', '2015-10-18 17:19:44', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('214', '2015-10-18 17:19:48', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('215', '2015-10-18 17:20:32', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('216', '2015-10-18 17:21:52', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('217', '2015-10-18 17:23:55', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('218', '2015-10-18 17:24:42', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('219', '2015-10-18 17:24:59', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('220', '2015-10-18 17:25:40', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('221', '2015-10-18 17:26:25', '1', '/art/admin/art/file/upload.form');
INSERT INTO `optlog` VALUES ('222', '2015-10-18 17:26:41', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('223', '2015-10-18 17:26:42', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('224', '2015-10-18 17:26:44', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('225', '2015-10-18 17:26:52', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('226', '2015-10-18 17:26:59', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('227', '2015-10-18 17:27:39', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('228', '2015-10-18 17:28:19', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('229', '2015-10-18 17:28:42', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('230', '2015-10-18 17:29:07', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('231', '2015-10-18 17:30:06', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('232', '2015-10-18 17:30:06', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('233', '2015-10-18 17:30:08', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('234', '2015-10-18 17:31:23', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('235', '2015-10-18 17:32:01', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('236', '2015-10-18 17:32:36', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('237', '2015-10-18 17:33:23', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('238', '2015-10-18 17:33:49', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('239', '2015-10-18 17:33:52', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('240', '2015-10-18 17:35:09', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('241', '2015-10-18 17:35:09', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('242', '2015-10-18 17:35:12', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('243', '2015-10-18 17:35:45', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('244', '2015-10-18 17:35:45', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('245', '2015-10-18 17:35:46', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('246', '2015-10-18 17:35:54', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('247', '2015-10-18 17:36:03', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('248', '2015-10-18 17:36:05', '1', '/art/admin/art/detail.form');
INSERT INTO `optlog` VALUES ('249', '2015-10-18 17:36:12', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('250', '2015-10-18 17:36:12', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('251', '2015-10-18 17:36:21', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('252', '2015-10-18 17:36:22', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('253', '2015-10-18 17:36:23', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('254', '2015-10-18 17:36:23', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('255', '2015-10-18 17:36:25', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('256', '2015-10-18 17:36:25', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('257', '2015-10-18 17:36:31', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('258', '2015-10-18 17:57:35', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('259', '2015-10-18 18:31:55', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('260', '2015-10-18 18:33:24', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('261', '2015-10-18 18:33:27', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('262', '2015-10-18 18:34:15', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('263', '2015-10-18 18:34:50', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('264', '2015-10-18 18:35:30', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('265', '2015-10-18 18:35:46', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('266', '2015-10-18 18:35:47', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('267', '2015-10-18 18:35:51', '1', '/art/admin/art/list.form');
INSERT INTO `optlog` VALUES ('268', '2015-10-18 18:35:51', '1', '/art/admin/art/search.form');
INSERT INTO `optlog` VALUES ('269', '2015-10-18 18:36:05', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('270', '2015-10-18 18:36:08', '1', '/art/admin/art/add.form');
INSERT INTO `optlog` VALUES ('271', '2015-10-18 18:36:46', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('272', '2015-10-18 18:37:33', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('273', '2015-10-18 18:38:38', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('274', '2015-10-18 18:38:43', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('275', '2015-10-18 18:46:10', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('276', '2015-10-18 18:46:53', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('277', '2015-10-18 18:47:25', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('278', '2015-10-18 18:50:30', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('279', '2015-10-18 18:52:24', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('280', '2015-10-18 18:53:03', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('281', '2015-10-18 18:54:06', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('282', '2015-10-18 18:54:31', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('283', '2015-10-18 18:55:16', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('284', '2015-10-18 18:55:51', '1', '/art/admin/index.form');
INSERT INTO `optlog` VALUES ('285', '2015-10-18 18:55:55', '1', '/art/admin/index.form');
