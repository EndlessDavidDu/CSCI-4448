/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : housing

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 29/11/2018 00:18:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_affiche
-- ----------------------------
DROP TABLE IF EXISTS `tb_affiche`;
CREATE TABLE `tb_affiche`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `issueTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_affiche
-- ----------------------------
INSERT INTO `tb_affiche` VALUES (1, 'fsda', 'fdsafasdfa', '2018-11-27 17:55:51');
INSERT INTO `tb_affiche` VALUES (2, ' A ninety percent discount', '\r\nA ninety percent discount', '2018-11-27 20:17:28');
INSERT INTO `tb_affiche` VALUES (3, 'Luxury sea view room discount', 'Luxury sea view room discount', '2018-11-27 20:18:07');

-- ----------------------------
-- Table structure for tb_bigtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_bigtype`;
CREATE TABLE `tb_bigtype`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bigName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_bigtype
-- ----------------------------
INSERT INTO `tb_bigtype` VALUES (11, 'dwellings', '2018-11-10 16:52:51');
INSERT INTO `tb_bigtype` VALUES (12, 'Inn', '2018-11-10 16:52:53');
INSERT INTO `tb_bigtype` VALUES (13, 'apartment ', '2018-11-10 16:52:56');
INSERT INTO `tb_bigtype` VALUES (14, 'villa', '2018-11-10 16:52:58');
INSERT INTO `tb_bigtype` VALUES (15, 'sea-view room ', '2018-11-10 20:50:28');

-- ----------------------------
-- Table structure for tb_favorite
-- ----------------------------
DROP TABLE IF EXISTS `tb_favorite`;
CREATE TABLE `tb_favorite`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `houseID` int(11) NULL DEFAULT NULL,
  `memberID` int(11) NOT NULL,
  `number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_favorite
-- ----------------------------
INSERT INTO `tb_favorite` VALUES (3, 10, 20, 1);

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bigId` int(11) NULL DEFAULT NULL,
  `smallId` int(11) NULL DEFAULT NULL,
  `houseName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `houseFrom` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `nowPrice` float(10, 0) NULL DEFAULT NULL,
  `freePrice` float(10, 0) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `picture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mark` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES (7, 14, 4, 'villa_1', 'merchant_1', 'villa_1 ', '2018-11-27 20:09:09', 169, 0, 0, 'goodsPicture/1543320549645.jpg', b'0');
INSERT INTO `tb_house` VALUES (8, 12, 2, 'inn_2', 'merchant_32', 'inn', '2018-11-27 20:11:45', 149, 0, 0, 'goodsPicture/1543320705114.jpg', b'0');
INSERT INTO `tb_house` VALUES (9, 15, 5, 'sea-view room_1', 'merchant_4', 'sea view', '2018-11-27 20:14:21', 129, 0, 0, 'goodsPicture/1543320861519.jpg', b'0');
INSERT INTO `tb_house` VALUES (10, 13, 3, 'apartiment', 'merchant_1', 'apartmment', '2018-11-27 20:15:30', 123, 0, 3, 'goodsPicture/1543320930758.jpg', b'0');

-- ----------------------------
-- Table structure for tb_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_link`;
CREATE TABLE `tb_link`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `linkName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `linkAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_link
-- ----------------------------
INSERT INTO `tb_link` VALUES (5, 'fsa', 'fsa');
INSERT INTO `tb_link` VALUES (6, 'Delicious specialty carp', 'www.liyu.cn');
INSERT INTO `tb_link` VALUES (7, 'Sweet and delicious flower cake', 'google.com');

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES (1, 'admin', 'admin', 'admin', 1);

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reallyName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `profession` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES (1, 'xx', 'xx', 'xx', 45, 'ttt', '1143432@qq.com', 'rr', 'rre');
INSERT INTO `tb_member` VALUES (20, 'admin', 'admin', 'tom', 23, 'teacher', '1143432@qq.com', 'birthday', '1965.09.12');
INSERT INTO `tb_member` VALUES (21, 'mm', 'mm', 'mm', 34, 'teacher', '11234@qq.com', 'rr', 'rr');
INSERT INTO `tb_member` VALUES (22, 'gg', 'gg', 'gg', 34, 'teacher', '11234@qq.com', 'rr', 'rr');
INSERT INTO `tb_member` VALUES (25, 'qq', 'qq', 'qq', 34, 'teacher', '11234@qq.com', 'rr', 'rr');
INSERT INTO `tb_member` VALUES (26, 'yy', 'yy', 'yy', 34, 'teacher', '11234@qq.com', 'rr', 'rr');
INSERT INTO `tb_member` VALUES (27, 'uu', 'uu', 'uu', 34, 'teacher', '11234@qq.com', 'rr', 'rr');

-- ----------------------------
-- Table structure for tb_merchant
-- ----------------------------
DROP TABLE IF EXISTS `tb_merchant`;
CREATE TABLE `tb_merchant`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `merchantName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tb_merchant_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reallyName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bz` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `sign` tinyint(4) NULL DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (2, '1543301718420', 'admin', 'tom', 'a', '122', 'wechat', 'one hour', '12', 1, '2018-11-27 14:56:33');
INSERT INTO `tb_order` VALUES (3, '1543310310028', 'admin', 'tom', 'a', '122', 'wechat', 'two hour', 'fas', 0, '2018-11-27 17:18:36');
INSERT INTO `tb_order` VALUES (4, '1543310639623', 'admin', 'tom', 'fas', 'fasd', 'alipay', 'one hour', 'fas', 1, '2018-11-27 17:24:04');
INSERT INTO `tb_order` VALUES (7, '1543419861361', 'admin', 'tom', '', '', 'wechat', 'one hour', '', 0, '2018-11-28 23:44:31');
INSERT INTO `tb_order` VALUES (8, '1543420191831', 'admin', 'tom', '', '', 'wechat', 'one hour', '', 0, '2018-11-28 23:49:55');

-- ----------------------------
-- Table structure for tb_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderdetail`;
CREATE TABLE `tb_orderdetail`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `houseId` int(11) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_orderdetail
-- ----------------------------
INSERT INTO `tb_orderdetail` VALUES (2, '1543301718420', 6, 123, 1);
INSERT INTO `tb_orderdetail` VALUES (4, '1543310310028', 6, 123, 10);
INSERT INTO `tb_orderdetail` VALUES (5, '1543310639623', 6, 123, 10);
INSERT INTO `tb_orderdetail` VALUES (7, '1543419861361', 10, 123, 1);
INSERT INTO `tb_orderdetail` VALUES (8, '1543420191831', 10, 123, 1);

-- ----------------------------
-- Table structure for tb_smalltype
-- ----------------------------
DROP TABLE IF EXISTS `tb_smalltype`;
CREATE TABLE `tb_smalltype`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bigId` int(11) NULL DEFAULT NULL,
  `smallName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_smalltype
-- ----------------------------
INSERT INTO `tb_smalltype` VALUES (1, 11, 'Transportation', '2018-11-10 16:55:19');
INSERT INTO `tb_smalltype` VALUES (2, 12, 'scenic zone', '2018-11-10 16:56:01');
INSERT INTO `tb_smalltype` VALUES (3, 13, 'Two Bedrooms', '2018-11-10 16:56:44');
INSERT INTO `tb_smalltype` VALUES (4, 14, 'Retro', '2018-11-10 16:57:55');
INSERT INTO `tb_smalltype` VALUES (5, 15, 'Cool House', '2018-11-10 17:08:43');

SET FOREIGN_KEY_CHECKS = 1;
