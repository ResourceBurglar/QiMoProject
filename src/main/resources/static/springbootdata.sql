/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : springbootdata

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 04/06/2023 01:39:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `series` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `token` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for stu_class
-- ----------------------------
DROP TABLE IF EXISTS `stu_class`;
CREATE TABLE `stu_class`  (
  `id` int(0) NOT NULL,
  `classname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_class
-- ----------------------------
INSERT INTO `stu_class` VALUES (1, 'sb班');

-- ----------------------------
-- Table structure for stu_grade
-- ----------------------------
DROP TABLE IF EXISTS `stu_grade`;
CREATE TABLE `stu_grade`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `classid` int(0) NULL DEFAULT NULL,
  `yuwen` int(0) NULL DEFAULT NULL,
  `math` int(0) NULL DEFAULT NULL,
  `english` int(0) NULL DEFAULT NULL,
  `average` int(0) NULL DEFAULT NULL,
  `allgrade` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classid`(`classid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_grade
-- ----------------------------
INSERT INTO `stu_grade` VALUES (1, '欧沸烈', 1, 80, 65, 90, 90, 270);
INSERT INTO `stu_grade` VALUES (2, '张伟', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `stu_grade` VALUES (3, '你好', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `authority` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES (1, 'Admin');
INSERT INTO `t_authority` VALUES (2, 'teacher');
INSERT INTO `t_authority` VALUES (3, 'student');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `valid` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, 'admin', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (2, 'stu', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (3, 'teach', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (41, '123', '$2a$10$Pj9RsUgcgNSNq8rZlxPHt.Z1RgOOFnSFkI2Sec24Gk16h6JLbItke', 1);

-- ----------------------------
-- Table structure for t_customer_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_authority`;
CREATE TABLE `t_customer_authority`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `customer_id` int(0) NULL DEFAULT NULL,
  `authority_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_customer_authority
-- ----------------------------
INSERT INTO `t_customer_authority` VALUES (1, 1, 1);
INSERT INTO `t_customer_authority` VALUES (2, 2, 3);
INSERT INTO `t_customer_authority` VALUES (3, 3, 2);
INSERT INTO `t_customer_authority` VALUES (6, 41, 2);

SET FOREIGN_KEY_CHECKS = 1;
