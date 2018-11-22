/*
 Navicat Premium Data Transfer

 Source Server         : Medicine
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : txt

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 22/11/2018 14:19:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `Filename` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Filestyle` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Filetime` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Filepath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Filesize` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Filename`, `Filepath`, `Filesize`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('java.doc', '文档', '2018-11-22 12:13:38', 'java.doc', '32256', '201624133210', '萨德');
INSERT INTO `file` VALUES ('前言.docx', '文档', '2018-11-22 10:33:38', 'C:\\Users\\Administrator\\Documents\\前言.docx', '161639', '无', '介绍作用');
INSERT INTO `file` VALUES ('勘误反馈表.doc', 'doc', '2018-11-22 10:38:22', 'C:\\Users\\Administrator\\Documents\\勘误反馈表.doc', '37888', 'none', 'none');

SET FOREIGN_KEY_CHECKS = 1;
