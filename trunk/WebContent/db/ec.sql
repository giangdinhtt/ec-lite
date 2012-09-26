/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50139
Source Host           : localhost:3306
Source Database       : ec

Target Server Type    : MYSQL
Target Server Version : 50139
File Encoding         : 65001

Date: 2012-09-19 01:52:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ec_course`
-- ----------------------------
DROP TABLE IF EXISTS `ec_course`;
CREATE TABLE `ec_course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_id` int(10) unsigned DEFAULT NULL,
  `session_id` int(10) unsigned DEFAULT NULL,
  `grade_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_course
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_date`
-- ----------------------------
DROP TABLE IF EXISTS `ec_date`;
CREATE TABLE `ec_date` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `day` decimal(2,0) unsigned DEFAULT NULL,
  `month` decimal(2,0) unsigned DEFAULT NULL,
  `year` decimal(4,0) unsigned DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_date
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_grade`
-- ----------------------------
DROP TABLE IF EXISTS `ec_grade`;
CREATE TABLE `ec_grade` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_grades_years`
-- ----------------------------
DROP TABLE IF EXISTS `ec_grades_years`;
CREATE TABLE `ec_grades_years` (
  `grade_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_grades_years
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_permission`
-- ----------------------------
DROP TABLE IF EXISTS `ec_permission`;
CREATE TABLE `ec_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pattern` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_permission
-- ----------------------------
INSERT INTO `ec_permission` VALUES ('1', 'Add user', 'user:add,remove', '');
INSERT INTO `ec_permission` VALUES ('2', 'Manage user', 'user:update', '');
INSERT INTO `ec_permission` VALUES ('3', 'View user', 'user:view', '');
INSERT INTO `ec_permission` VALUES ('4', 'Delete user', 'user:delete', '');
INSERT INTO `ec_permission` VALUES ('5', 'Change user', 'user:change', '');
INSERT INTO `ec_permission` VALUES ('6', 'Manage role', 'role:*', '');
INSERT INTO `ec_permission` VALUES ('7', 'Set role', 'role:change', '');
INSERT INTO `ec_permission` VALUES ('8', 'Delete role', 'role:delete', '');

-- ----------------------------
-- Table structure for `ec_profile`
-- ----------------------------
DROP TABLE IF EXISTS `ec_profile`;
CREATE TABLE `ec_profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_saint` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lower_case_name` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_profile
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_role`
-- ----------------------------
DROP TABLE IF EXISTS `ec_role`;
CREATE TABLE `ec_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_role
-- ----------------------------
INSERT INTO `ec_role` VALUES ('1', 'admin', null, '');
INSERT INTO `ec_role` VALUES ('2', 'guest', null, '');
INSERT INTO `ec_role` VALUES ('3', 'mod', null, '');
INSERT INTO `ec_role` VALUES ('4', 'user', null, '');

-- ----------------------------
-- Table structure for `ec_roles_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `ec_roles_permissions`;
CREATE TABLE `ec_roles_permissions` (
  `role_id` int(10) unsigned NOT NULL,
  `permission_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_roles_permissions
-- ----------------------------
INSERT INTO `ec_roles_permissions` VALUES ('1', '1');
INSERT INTO `ec_roles_permissions` VALUES ('1', '2');
INSERT INTO `ec_roles_permissions` VALUES ('1', '3');
INSERT INTO `ec_roles_permissions` VALUES ('1', '4');
INSERT INTO `ec_roles_permissions` VALUES ('2', '6');
INSERT INTO `ec_roles_permissions` VALUES ('3', '1');
INSERT INTO `ec_roles_permissions` VALUES ('3', '2');
INSERT INTO `ec_roles_permissions` VALUES ('3', '3');
INSERT INTO `ec_roles_permissions` VALUES ('3', '4');
INSERT INTO `ec_roles_permissions` VALUES ('3', '5');
INSERT INTO `ec_roles_permissions` VALUES ('3', '6');
INSERT INTO `ec_roles_permissions` VALUES ('3', '7');
INSERT INTO `ec_roles_permissions` VALUES ('3', '8');
INSERT INTO `ec_roles_permissions` VALUES ('4', '1');
INSERT INTO `ec_roles_permissions` VALUES ('4', '2');
INSERT INTO `ec_roles_permissions` VALUES ('4', '6');
INSERT INTO `ec_roles_permissions` VALUES ('4', '7');
INSERT INTO `ec_roles_permissions` VALUES ('4', '8');
INSERT INTO `ec_roles_permissions` VALUES ('5', '3');
INSERT INTO `ec_roles_permissions` VALUES ('5', '4');

-- ----------------------------
-- Table structure for `ec_room`
-- ----------------------------
DROP TABLE IF EXISTS `ec_room`;
CREATE TABLE `ec_room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_room
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_rooms_years`
-- ----------------------------
DROP TABLE IF EXISTS `ec_rooms_years`;
CREATE TABLE `ec_rooms_years` (
  `room_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_rooms_years
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_semester`
-- ----------------------------
DROP TABLE IF EXISTS `ec_semester`;
CREATE TABLE `ec_semester` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_semester
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_semesters_years`
-- ----------------------------
DROP TABLE IF EXISTS `ec_semesters_years`;
CREATE TABLE `ec_semesters_years` (
  `semester_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_semesters_years
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_session`
-- ----------------------------
DROP TABLE IF EXISTS `ec_session`;
CREATE TABLE `ec_session` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dow` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Day of week',
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_session
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_sessions_years`
-- ----------------------------
DROP TABLE IF EXISTS `ec_sessions_years`;
CREATE TABLE `ec_sessions_years` (
  `session_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_sessions_years
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_user`
-- ----------------------------
DROP TABLE IF EXISTS `ec_user`;
CREATE TABLE `ec_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `signature` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `security_question` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `security_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile_id` int(10) unsigned DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `login_attempt` int(10) unsigned DEFAULT '0',
  `is_active` bit(1) DEFAULT b'1',
  `is_locked` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_user
-- ----------------------------
INSERT INTO `ec_user` VALUES ('1', 'a', '123456', null, null, null, null, null, null, '0', null, null);
INSERT INTO `ec_user` VALUES ('2', 'b', '123456', null, null, null, null, null, null, '0', null, null);
INSERT INTO `ec_user` VALUES ('3', 'c', '123456', null, null, null, null, null, null, '0', null, null);
INSERT INTO `ec_user` VALUES ('4', 'd', '123456', null, null, null, null, null, null, '0', null, null);
INSERT INTO `ec_user` VALUES ('5', 'e', '132456', null, null, null, null, null, null, '0', null, null);
INSERT INTO `ec_user` VALUES ('6', 'f', '123456', null, null, null, null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for `ec_users_roles`
-- ----------------------------
DROP TABLE IF EXISTS `ec_users_roles`;
CREATE TABLE `ec_users_roles` (
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `role_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_users_roles
-- ----------------------------
INSERT INTO `ec_users_roles` VALUES ('1', '1');
INSERT INTO `ec_users_roles` VALUES ('1', '2');
INSERT INTO `ec_users_roles` VALUES ('2', '1');
INSERT INTO `ec_users_roles` VALUES ('2', '2');
INSERT INTO `ec_users_roles` VALUES ('2', '3');
INSERT INTO `ec_users_roles` VALUES ('2', '4');
INSERT INTO `ec_users_roles` VALUES ('3', '3');
INSERT INTO `ec_users_roles` VALUES ('4', '4');
INSERT INTO `ec_users_roles` VALUES ('5', '2');
INSERT INTO `ec_users_roles` VALUES ('5', '3');
INSERT INTO `ec_users_roles` VALUES ('5', '4');
INSERT INTO `ec_users_roles` VALUES ('6', '2');

-- ----------------------------
-- Table structure for `ec_year`
-- ----------------------------
DROP TABLE IF EXISTS `ec_year`;
CREATE TABLE `ec_year` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` decimal(4,0) unsigned DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_year
-- ----------------------------

-- ----------------------------
-- Procedure structure for `sp_GetRolePermissions`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetRolePermissions`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetRolePermissions`(IN role VARCHAR(50))
BEGIN
	SELECT ec_permission.pattern
	FROM ec_role, ec_permission, ec_roles_permissions
	WHERE ec_role.id = ec_roles_permissions.role_id AND ec_permission.id = ec_roles_permissions.permission_id AND ec_role.name = role;
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetUserPassword`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetUserPassword`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetUserPassword`(IN username VARCHAR(50))
BEGIN
	SELECT password
	FROM ec_user u
	WHERE u.username = username;
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetUserPermissions`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetUserPermissions`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetUserPermissions`(IN username VARCHAR(50))
BEGIN
	SELECT ec_permission.pattern
	FROM ec_user u, ec_role, ec_permission, ec_users_roles, ec_roles_permissions
	WHERE u.id = ec_users_roles.user_id AND ec_role.id = ec_users_roles.role_id AND ec_role.id = ec_roles_permissions.role_id AND ec_permission.id = ec_roles_permissions.permission_id AND u.username = username;
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetUserRoles`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetUserRoles`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetUserRoles`(IN username VARCHAR(50))
BEGIN
	SELECT ec_role.name
	FROM ec_user u, ec_role, ec_users_roles
	WHERE u.id = ec_users_roles.user_id AND ec_role.id = ec_users_roles.role_id AND u.username = username;
END;;
DELIMITER ;
