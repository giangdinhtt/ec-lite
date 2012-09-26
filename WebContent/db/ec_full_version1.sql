/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : ec

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2012-09-26 16:19:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `crc_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `crc_attendance`;
CREATE TABLE `crc_attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_student_schedule_id` int(11) NOT NULL DEFAULT '0',
  `attendance_date_id` int(11) NOT NULL DEFAULT '0',
  `attendance_check` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`attendance_id`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_attendance
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_courses`
-- ----------------------------
DROP TABLE IF EXISTS `crc_courses`;
CREATE TABLE `crc_courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL DEFAULT '',
  `course_desc` varchar(255) DEFAULT '',
  `course_active` tinyint(1) NOT NULL DEFAULT '0',
  `course_fee` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`course_id`,`course_name`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_courses
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_date`
-- ----------------------------
DROP TABLE IF EXISTS `crc_date`;
CREATE TABLE `crc_date` (
  `date_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_day` char(2) NOT NULL DEFAULT '',
  `date_month` char(2) NOT NULL DEFAULT '',
  `date_year` varchar(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`date_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_date
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `crc_feedback`;
CREATE TABLE `crc_feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_profile_id` int(11) NOT NULL DEFAULT '0',
  `feedback_schedule_id` int(11) NOT NULL DEFAULT '0',
  `feedback_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `feedback_active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_profile_id` (`feedback_profile_id`,`feedback_schedule_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='This table is facility to store feddback information from st';

-- ----------------------------
-- Records of crc_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_feedback_answers`
-- ----------------------------
DROP TABLE IF EXISTS `crc_feedback_answers`;
CREATE TABLE `crc_feedback_answers` (
  `feedback_answers_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_answers_feedback_id` int(11) NOT NULL DEFAULT '0',
  `feedback_answers_questions_id` int(11) NOT NULL DEFAULT '0',
  `feedback_answers_answer` text NOT NULL,
  `feedback_answers_active` tinyint(4) NOT NULL DEFAULT '0',
  `feedback_answers_comments` text NOT NULL,
  PRIMARY KEY (`feedback_answers_id`)
) ENGINE=MyISAM AUTO_INCREMENT=449 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_feedback_answers
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_feedback_questions`
-- ----------------------------
DROP TABLE IF EXISTS `crc_feedback_questions`;
CREATE TABLE `crc_feedback_questions` (
  `feedback_questions_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_questions_question` text NOT NULL,
  `feedback_questions_active` tinyint(1) NOT NULL DEFAULT '0',
  `feedback_questions_type` varchar(100) NOT NULL DEFAULT 'COMMENT',
  `feedback_questions_category` varchar(100) NOT NULL DEFAULT 'COMMENTS',
  `feedback_questions_sequence` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`feedback_questions_id`),
  KEY `SEQUENCE` (`feedback_questions_sequence`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_feedback_questions
-- ----------------------------
INSERT INTO `crc_feedback_questions` VALUES ('1', 'I feel that I have gained new skills and knowledge.', '0', 'OPTION', 'GENERAL', '1');
INSERT INTO `crc_feedback_questions` VALUES ('2', 'I will recommend the course to other member(s).', '0', 'OPTION', 'GENERAL', '2');
INSERT INTO `crc_feedback_questions` VALUES ('3', 'I believe the skills that I have learned will help.', '0', 'OPTION', 'GENERAL', '3');
INSERT INTO `crc_feedback_questions` VALUES ('4', 'The course material was easy to read.', '0', 'OPTION', 'GENERAL', '4');
INSERT INTO `crc_feedback_questions` VALUES ('5', 'I will be able to use the course materials as a reference.', '0', 'OPTION', 'GENERAL', '5');
INSERT INTO `crc_feedback_questions` VALUES ('6', 'I felt totally comfortable during the course.', '0', 'OPTION', 'GENERAL', '6');
INSERT INTO `crc_feedback_questions` VALUES ('7', 'The lesson time frame was appropriate for the course.', '0', 'OPTION', 'GENERAL', '7');
INSERT INTO `crc_feedback_questions` VALUES ('8', 'My expectations for the course were met.', '0', 'OPTION', 'GENERAL', '8');
INSERT INTO `crc_feedback_questions` VALUES ('9', 'I understood the course objectives clearly.', '0', 'OPTION', 'OBJECTIVE', '9');
INSERT INTO `crc_feedback_questions` VALUES ('10', 'I did achieve the course objectives.', '0', 'OPTION', 'OBJECTIVE', '10');
INSERT INTO `crc_feedback_questions` VALUES ('11', 'The topics presented in the course were relevant to my work.', '0', 'OPTION', 'OBJECTIVE', '11');
INSERT INTO `crc_feedback_questions` VALUES ('12', 'The course was structured in a logical way.', '0', 'OPTION', 'OBJECTIVE', '12');
INSERT INTO `crc_feedback_questions` VALUES ('13', 'The course was easy to follow.', '0', 'OPTION', 'OBJECTIVE', '13');
INSERT INTO `crc_feedback_questions` VALUES ('14', 'The course was interesting and enjoyable.', '0', 'OPTION', 'OBJECTIVE', '14');
INSERT INTO `crc_feedback_questions` VALUES ('15', 'The concepts and techniques used were explained clearly.', '0', 'OPTION', 'PRESENTATION', '15');
INSERT INTO `crc_feedback_questions` VALUES ('16', 'I was encouraged to actively participate during the course.', '0', 'OPTION', 'PRESENTATION', '16');
INSERT INTO `crc_feedback_questions` VALUES ('17', 'My individual questions/problems discussed were satisfactorily answered.', '0', 'OPTION', 'PRESENTATION', '17');
INSERT INTO `crc_feedback_questions` VALUES ('18', 'The presentation style of the instructor was satisfactory.', '0', 'OPTION', 'PRESENTATION', '18');
INSERT INTO `crc_feedback_questions` VALUES ('19', 'The instructors knowledge of the subject was satisfactory.', '0', 'OPTION', 'PRESENTATION', '19');
INSERT INTO `crc_feedback_questions` VALUES ('20', 'The course was well paced.', '0', 'OPTION', 'PRESENTATION', '20');
INSERT INTO `crc_feedback_questions` VALUES ('21', 'Please comment on what you liked about the course.', '0', 'COMMENT', 'COMMENTS', '21');
INSERT INTO `crc_feedback_questions` VALUES ('22', 'What improvements would you suggest for this course.', '0', 'COMMENT', 'COMMENTS', '22');
INSERT INTO `crc_feedback_questions` VALUES ('23', 'Please provide any additional comments not covered.', '0', 'COMMENT', 'COMMENTS', '23');

-- ----------------------------
-- Table structure for `crc_profiles`
-- ----------------------------
DROP TABLE IF EXISTS `crc_profiles`;
CREATE TABLE `crc_profiles` (
  `profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_uid` varchar(100) NOT NULL DEFAULT '',
  `profile_pwd` varchar(40) NOT NULL DEFAULT '',
  `profile_firstname` varchar(100) NOT NULL DEFAULT '',
  `profile_lastname` varchar(100) NOT NULL DEFAULT '',
  `profile_email` varchar(100) NOT NULL DEFAULT '',
  `profile_dob` date NOT NULL DEFAULT '2010-01-01',
  `profile_gender` varchar(6) NOT NULL DEFAULT 'M',
  `profile_employed` tinyint(1) DEFAULT '0',
  `profile_employed_title` varchar(100) DEFAULT '',
  `profile_employed_company` varchar(100) DEFAULT '',
  `profile_address_one` varchar(100) DEFAULT '',
  `profile_address_two` varchar(100) DEFAULT '',
  `profile_city` varchar(100) DEFAULT '',
  `profile_province_state` varchar(100) DEFAULT '',
  `profile_postal_code` varchar(100) DEFAULT '',
  `profile_country` varchar(100) DEFAULT '',
  `profile_phone_land` varchar(14) DEFAULT '00400000000000',
  `profile_phone_cell` varchar(14) DEFAULT '00400000000000',
  `profile_phone_fax` varchar(14) DEFAULT '00400000000000',
  `profile_role_id` int(11) NOT NULL DEFAULT '0',
  `profile_active` tinyint(1) NOT NULL DEFAULT '0',
  `profile_rdn` varchar(100) DEFAULT 'ou=don mills,ou=toronto,ou=ontario,ou=canada,o=crc world',
  `profile_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`profile_id`,`profile_uid`,`profile_email`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_profiles
-- ----------------------------
INSERT INTO `crc_profiles` VALUES ('1', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'Firstname', 'Lastname', 'admin@domain.com', '1977-11-19', 'M', '0', '', '', 'Campulung', '', 'Campulung', 'AG', '115100', 'Romania', '00400000000000', '00400000000000', '00400000000000', '1', '0', 'ou=don mills,ou=toronto,ou=ontario,ou=canada,o=crc world', '2012-07-17 16:34:45');

-- ----------------------------
-- Table structure for `crc_roles`
-- ----------------------------
DROP TABLE IF EXISTS `crc_roles`;
CREATE TABLE `crc_roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL DEFAULT '',
  `role_desc` varchar(255) NOT NULL DEFAULT '',
  `role_active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`,`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_roles
-- ----------------------------
INSERT INTO `crc_roles` VALUES ('1', 'Administrator', 'CRC Administrator role', '1');
INSERT INTO `crc_roles` VALUES ('2', 'Teacher', 'CRC Teacher role', '1');
INSERT INTO `crc_roles` VALUES ('3', 'Student', 'CRC Student role', '1');

-- ----------------------------
-- Table structure for `crc_rooms`
-- ----------------------------
DROP TABLE IF EXISTS `crc_rooms`;
CREATE TABLE `crc_rooms` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(100) NOT NULL DEFAULT '',
  `room_desc` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`room_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_rooms
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `crc_schedule`;
CREATE TABLE `crc_schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_course_id` int(11) NOT NULL DEFAULT '0',
  `schedule_start_date` date NOT NULL DEFAULT '2010-01-01',
  `schedule_end_date` date NOT NULL DEFAULT '2010-01-01',
  `schedule_day_time` varchar(30) NOT NULL DEFAULT 'M,W [8:00PM - 10:00PM]',
  `schedule_status` varchar(100) NOT NULL DEFAULT 'Tentative',
  `schedule_room_id` int(11) NOT NULL DEFAULT '2',
  `schedule_active` tinyint(1) NOT NULL DEFAULT '0',
  `schedule_venue_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`schedule_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_sessions`
-- ----------------------------
DROP TABLE IF EXISTS `crc_sessions`;
CREATE TABLE `crc_sessions` (
  `session_oid` int(11) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(255) NOT NULL DEFAULT '',
  `session_uid` varchar(15) NOT NULL DEFAULT '',
  `session_pwd` varchar(15) NOT NULL DEFAULT '',
  `session_dn` varchar(255) NOT NULL DEFAULT '',
  `session_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`session_oid`)
) ENGINE=MyISAM AUTO_INCREMENT=460 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_sessions
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_states`
-- ----------------------------
DROP TABLE IF EXISTS `crc_states`;
CREATE TABLE `crc_states` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(50) NOT NULL DEFAULT '',
  `state_desc` text NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_states
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_student_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `crc_student_schedule`;
CREATE TABLE `crc_student_schedule` (
  `student_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_schedule_profile_id` int(11) NOT NULL DEFAULT '0',
  `student_schedule_schedule_id` int(11) NOT NULL DEFAULT '0',
  `student_schedule_paid` char(1) NOT NULL DEFAULT 'U',
  `student_schedule_amount` int(11) NOT NULL DEFAULT '0',
  `student_schedule_questions` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`student_schedule_id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_student_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_teacher_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `crc_teacher_schedule`;
CREATE TABLE `crc_teacher_schedule` (
  `teacher_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_schedule_profile_id` int(11) NOT NULL DEFAULT '0',
  `teacher_schedule_schedule_id` int(11) NOT NULL DEFAULT '0',
  `teacher_schedule_evaluation` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`teacher_schedule_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_teacher_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `crc_venue`
-- ----------------------------
DROP TABLE IF EXISTS `crc_venue`;
CREATE TABLE `crc_venue` (
  `venue_id` int(11) NOT NULL AUTO_INCREMENT,
  `venue_name` varchar(100) NOT NULL DEFAULT '',
  `venue_desc` varchar(100) NOT NULL DEFAULT '',
  `venue_shortname` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`venue_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crc_venue
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_account`
-- ----------------------------
DROP TABLE IF EXISTS `ec_account`;
CREATE TABLE `ec_account` (
  `trainer_id` int(10) unsigned NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `security_question` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `security_answer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_locked` bit(1) DEFAULT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_account
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_area`
-- ----------------------------
DROP TABLE IF EXISTS `ec_area`;
CREATE TABLE `ec_area` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_area
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_attendance_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ec_attendance_detail`;
CREATE TABLE `ec_attendance_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainee_id` int(10) unsigned DEFAULT NULL,
  `attendance_status_id` int(10) unsigned DEFAULT NULL,
  `attendance_list_id` int(10) unsigned DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_attendance_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_attendance_list`
-- ----------------------------
DROP TABLE IF EXISTS `ec_attendance_list`;
CREATE TABLE `ec_attendance_list` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_id` int(10) unsigned DEFAULT NULL,
  `schedule_id` int(10) unsigned DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_person_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_attendance_list
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_attendance_status`
-- ----------------------------
DROP TABLE IF EXISTS `ec_attendance_status`;
CREATE TABLE `ec_attendance_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_attendance_status
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_course`
-- ----------------------------
DROP TABLE IF EXISTS `ec_course`;
CREATE TABLE `ec_course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_code` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade_id` int(10) unsigned DEFAULT NULL,
  `venue_id` int(10) unsigned DEFAULT NULL,
  `shift_id` int(10) unsigned DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_course
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_course_transcript`
-- ----------------------------
DROP TABLE IF EXISTS `ec_course_transcript`;
CREATE TABLE `ec_course_transcript` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_id` int(10) unsigned DEFAULT NULL,
  `test_date_id` int(10) unsigned DEFAULT NULL,
  `test_type_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_course_transcript
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_courses_trainees`
-- ----------------------------
DROP TABLE IF EXISTS `ec_courses_trainees`;
CREATE TABLE `ec_courses_trainees` (
  `course_id` int(10) unsigned DEFAULT NULL,
  `trainee_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_courses_trainees
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_courses_trainers`
-- ----------------------------
DROP TABLE IF EXISTS `ec_courses_trainers`;
CREATE TABLE `ec_courses_trainers` (
  `course_id` int(10) unsigned DEFAULT NULL,
  `trainer_id` int(10) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_courses_trainers
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_date`
-- ----------------------------
DROP TABLE IF EXISTS `ec_date`;
CREATE TABLE `ec_date` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_of_year` date DEFAULT NULL,
  `liturgical_date` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ngay_trong_nam` (`date_of_year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_date
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_function`
-- ----------------------------
DROP TABLE IF EXISTS `ec_function`;
CREATE TABLE `ec_function` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `security_code` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_function
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_grade`
-- ----------------------------
DROP TABLE IF EXISTS `ec_grade`;
CREATE TABLE `ec_grade` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade_leader_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_parent`
-- ----------------------------
DROP TABLE IF EXISTS `ec_parent`;
CREATE TABLE `ec_parent` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patron_saint` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lower_case_name` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `career` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_male` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_parent
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_person`
-- ----------------------------
DROP TABLE IF EXISTS `ec_person`;
CREATE TABLE `ec_person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patron_saint` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lower_case_name` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Thuộc tính này dùng để lưu họ tên của học viên nhưng viết thường và không có dấu để tăng tốc độ tìm kiếm. Vd: Giuse Trần Văn A ---> giuse tran van a',
  `is_male` bit(1) DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area_id` int(10) unsigned DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_person
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_plan`
-- ----------------------------
DROP TABLE IF EXISTS `ec_plan`;
CREATE TABLE `ec_plan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_plan_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ec_plan_detail`;
CREATE TABLE `ec_plan_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_id` int(10) DEFAULT NULL,
  `content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `plan_id` int(10) unsigned DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_plan_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_role`
-- ----------------------------
DROP TABLE IF EXISTS `ec_role`;
CREATE TABLE `ec_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_role
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_roles_functions`
-- ----------------------------
DROP TABLE IF EXISTS `ec_roles_functions`;
CREATE TABLE `ec_roles_functions` (
  `role_id` int(10) unsigned NOT NULL,
  `function_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_roles_functions
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `ec_schedule`;
CREATE TABLE `ec_schedule` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_id` int(10) unsigned DEFAULT NULL,
  `date_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `schedule_status_id` int(10) unsigned DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_schedule_status`
-- ----------------------------
DROP TABLE IF EXISTS `ec_schedule_status`;
CREATE TABLE `ec_schedule_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_schedule_status
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_shift`
-- ----------------------------
DROP TABLE IF EXISTS `ec_shift`;
CREATE TABLE `ec_shift` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `day_of_week` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_shift
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_test`
-- ----------------------------
DROP TABLE IF EXISTS `ec_test`;
CREATE TABLE `ec_test` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `trainee_id` int(10) unsigned DEFAULT NULL,
  `mark` float(4,2) unsigned DEFAULT NULL,
  `course_transcript_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_test
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_test_type`
-- ----------------------------
DROP TABLE IF EXISTS `ec_test_type`;
CREATE TABLE `ec_test_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `factor` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_test_type
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_trainee`
-- ----------------------------
DROP TABLE IF EXISTS `ec_trainee`;
CREATE TABLE `ec_trainee` (
  `person_id` int(10) unsigned NOT NULL,
  `baptism_date` date DEFAULT NULL,
  `baptism_place` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_communion_date` date DEFAULT NULL,
  `first_communion_place` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `confirmation_date` date DEFAULT NULL,
  `confirmation_place` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `father_id` int(10) unsigned DEFAULT NULL,
  `mother_id` int(10) unsigned DEFAULT NULL,
  `sponsor_id` int(10) unsigned DEFAULT NULL,
  `trainee_status_id` int(10) unsigned DEFAULT NULL,
  `current_course_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_trainee
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_trainee_status`
-- ----------------------------
DROP TABLE IF EXISTS `ec_trainee_status`;
CREATE TABLE `ec_trainee_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_trainee_status
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_trainer`
-- ----------------------------
DROP TABLE IF EXISTS `ec_trainer`;
CREATE TABLE `ec_trainer` (
  `person_id` int(10) unsigned NOT NULL,
  `join_date` date DEFAULT NULL,
  `feast_day` date DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trainer_status_id` int(3) unsigned DEFAULT NULL,
  `current_course_id` int(10) unsigned DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_trainer
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_trainer_status`
-- ----------------------------
DROP TABLE IF EXISTS `ec_trainer_status`;
CREATE TABLE `ec_trainer_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_trainer_status
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_trainers_roles`
-- ----------------------------
DROP TABLE IF EXISTS `ec_trainers_roles`;
CREATE TABLE `ec_trainers_roles` (
  `trainer_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_trainers_roles
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_venue`
-- ----------------------------
DROP TABLE IF EXISTS `ec_venue`;
CREATE TABLE `ec_venue` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `location` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_venue
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_year`
-- ----------------------------
DROP TABLE IF EXISTS `ec_year`;
CREATE TABLE `ec_year` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `open_date` date DEFAULT NULL,
  `closed_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_year
-- ----------------------------
