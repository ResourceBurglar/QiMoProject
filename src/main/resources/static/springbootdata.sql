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

 Date: 06/06/2023 12:48:13
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
INSERT INTO `stu_class` VALUES (1, 'SB班');
INSERT INTO `stu_class` VALUES (2, 'NB班');
INSERT INTO `stu_class` VALUES (3, 'BT班');

-- ----------------------------
-- Table structure for stu_grade
-- ----------------------------
DROP TABLE IF EXISTS `stu_grade`;
CREATE TABLE `stu_grade`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `yuwen` int(0) NULL DEFAULT NULL,
  `math` int(0) NULL DEFAULT NULL,
  `english` int(0) NULL DEFAULT NULL,
  `average` int(0) NULL DEFAULT NULL,
  `allgrade` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stu_grade
-- ----------------------------
INSERT INTO `stu_grade` VALUES (1, '欧沸烈', 'SB班', 80, 65, 90, 90, 270);
INSERT INTO `stu_grade` VALUES (4, '张三', 'NB班', 1, 1, 1, 1, 3);
INSERT INTO `stu_grade` VALUES (5, '李四', 'BT班', 2, 2, 2, 2, 6);
INSERT INTO `stu_grade` VALUES (6, '王五', 'SB班', 3, 1, 1, 1, 5);
INSERT INTO `stu_grade` VALUES (7, '迪丽热巴', 'SB班', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `stu_grade` VALUES (18, '张伟', 'NB班', NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, 'admin', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (2, 'stu', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (3, 'teach', '$2a$10$gNUGpVYXIG.lhDMeyqJbpeNZgzTaWNsiNaf98s4UStxMJRImFRekm', 1);
INSERT INTO `t_customer` VALUES (43, '蠢蛋', '$2a$10$pzZK7emDDytrOTa2a8iMJOzzMLJ4XQET1ZB4DJ7Bnckbh/MOq9FCC', 1);
INSERT INTO `t_customer` VALUES (44, '猪仔', '$2a$10$1wyoiNGkbFT/K8COYH4t4uFP4FP/PQWSfFmGfuKT.jLnQWl0R6HvW', 1);
INSERT INTO `t_customer` VALUES (45, '迪丽热巴', '$2a$10$W//H7ZspNl6YUbPpkfvj4.aRqHKLvP5TFhPRShc1ixLiIMdk.EDFC', 1);
INSERT INTO `t_customer` VALUES (46, '傻蛋', '$2a$10$2HIg6DgWKY.aHg21s3N3Hu3bGAl0JguKvKiFaBwSo5n8sLeDLwyTS', 1);
INSERT INTO `t_customer` VALUES (47, '张伟', '$2a$10$qK4CuogrrKuYCt25tIT1MO1zfsXWq1jIl/Gn7KlwQ2a7LCEKiFgum', 1);

-- ----------------------------
-- Table structure for t_customer_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_authority`;
CREATE TABLE `t_customer_authority`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `customer_id` int(0) NULL DEFAULT NULL,
  `authority_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_customer_authority
-- ----------------------------
INSERT INTO `t_customer_authority` VALUES (1, 1, 1);
INSERT INTO `t_customer_authority` VALUES (2, 2, 3);
INSERT INTO `t_customer_authority` VALUES (3, 3, 2);
INSERT INTO `t_customer_authority` VALUES (7, 42, 3);
INSERT INTO `t_customer_authority` VALUES (8, 43, 3);
INSERT INTO `t_customer_authority` VALUES (9, 44, 3);
INSERT INTO `t_customer_authority` VALUES (10, 45, 3);
INSERT INTO `t_customer_authority` VALUES (11, 46, 3);
INSERT INTO `t_customer_authority` VALUES (12, 47, 3);

SET FOREIGN_KEY_CHECKS = 1;
