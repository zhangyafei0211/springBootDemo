/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : dbspringboot

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-01-19 16:59:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_entity
-- ----------------------------
DROP TABLE IF EXISTS `user_entity`;
CREATE TABLE `user_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(3) DEFAULT NULL,
  `user_name` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_entity
-- ----------------------------
INSERT INTO `user_entity` VALUES ('2', '1', '梅长苏');
INSERT INTO `user_entity` VALUES ('3', '18', '霓裳');
INSERT INTO `user_entity` VALUES ('4', '18', '靖王');
INSERT INTO `user_entity` VALUES ('5', '18', '大坏人');
INSERT INTO `user_entity` VALUES ('19', '10', '李四');
INSERT INTO `user_entity` VALUES ('20', '18', '李四');
