/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.24-log : Database - hurtplatform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hurtplatform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hurtplatform`;

/*Table structure for table `accident` */

DROP TABLE IF EXISTS `accident`;

CREATE TABLE `accident` (
  `id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `deliver_hospital` varchar(100) NOT NULL,
  `receive_alarm_time` timestamp NULL DEFAULT NULL,
  `rescue_arrive_time` timestamp NULL DEFAULT NULL,
  `temperature` varchar(30) DEFAULT NULL,
  `humidity` varchar(30) DEFAULT NULL,
  `weather_status` varchar(30) DEFAULT NULL,
  `accident_spot` varchar(100) DEFAULT NULL,
  `transport` char(32) DEFAULT NULL,
  `vulnus_accident_type` char(32) DEFAULT NULL,
  `stretcher_id` char(32) NOT NULL,
  `handle_user` char(32) NOT NULL,
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `cure_situation` varchar(300) DEFAULT NULL,
  `accident_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `accident_fk1` (`patient_id`),
  CONSTRAINT `accident_fk1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `authorization` */

DROP TABLE IF EXISTS `authorization`;

CREATE TABLE `authorization` (
  `id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `item_id` char(32) DEFAULT NULL,
  `item_value` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authorization_fk1` (`acc_id`),
  KEY `authorization_fk2` (`patient_id`),
  CONSTRAINT `authorization_fk1` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`),
  CONSTRAINT `authorization_fk2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `choice_attr` */

DROP TABLE IF EXISTS `choice_attr`;

CREATE TABLE `choice_attr` (
  `id` char(32) NOT NULL,
  `module_id` char(32) DEFAULT NULL,
  `attr_name` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `check_type` varchar(5) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `choices_item` */

DROP TABLE IF EXISTS `choices_item`;

CREATE TABLE `choices_item` (
  `id` char(32) NOT NULL,
  `attr_id` char(32) NOT NULL,
  `parent_id` char(32) DEFAULT NULL,
  `item_name` varchar(100) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `choices_item_fk1` (`attr_id`),
  CONSTRAINT `choices_item_fk1` FOREIGN KEY (`attr_id`) REFERENCES `choice_attr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cure_situation` */

DROP TABLE IF EXISTS `cure_situation`;

CREATE TABLE `cure_situation` (
  `id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `choice_item_id` char(32) DEFAULT NULL,
  `item_remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cure_situation_fk1` (`patient_id`),
  KEY `cure_situation_fk2` (`acc_id`),
  CONSTRAINT `cure_situation_fk1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `cure_situation_fk2` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `gcs` */

DROP TABLE IF EXISTS `gcs`;

CREATE TABLE `gcs` (
  `id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `eye_open_status` char(32) DEFAULT NULL,
  `verbal_status` char(32) DEFAULT NULL,
  `action_status` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `GCS_fk1` (`acc_id`),
  KEY `GCS_fk2` (`patient_id`),
  CONSTRAINT `GCS_fk1` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`),
  CONSTRAINT `GCS_fk2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `green_way` */

DROP TABLE IF EXISTS `green_way`;

CREATE TABLE `green_way` (
  `id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `item_id` char(32) DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `green_way_fk1` (`patient_id`),
  KEY `green_way_fk2` (`acc_id`),
  CONSTRAINT `green_way_fk1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `green_way_fk2` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` char(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `id_card` varchar(18) NOT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telphone` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `native_place` varchar(100) DEFAULT NULL,
  `nationality` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `phi_grade` */

DROP TABLE IF EXISTS `phi_grade`;

CREATE TABLE `phi_grade` (
  `id` char(32) NOT NULL,
  `mental_status` char(32) DEFAULT NULL,
  `attach_valnus_status` char(32) DEFAULT NULL,
  `bsp_scope` char(32) DEFAULT NULL,
  `heart_rate_scope` char(32) DEFAULT NULL,
  `breathe_rate_scope` char(32) DEFAULT NULL,
  `patient_id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `add_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phi_grade_fk1` (`acc_id`),
  KEY `phi_grade_fk2` (`patient_id`),
  CONSTRAINT `phi_grade_fk1` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`),
  CONSTRAINT `phi_grade_fk2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `stretcher` */

DROP TABLE IF EXISTS `stretcher`;

CREATE TABLE `stretcher` (
  `id` varchar(32) NOT NULL,
  `stretcher_no` tinyint(4) NOT NULL,
  `stretcher_code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `wechat` varchar(20) DEFAULT NULL,
  `telphone` varchar(15) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reg_ip` varchar(15) DEFAULT NULL,
  `safe_question` varchar(255) DEFAULT NULL,
  `safe_answer` varchar(255) DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  `is_online` bit(1) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `valnus_detail` */

DROP TABLE IF EXISTS `valnus_detail`;

CREATE TABLE `valnus_detail` (
  `id` char(32) NOT NULL,
  `val_id` char(32) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `bloodloss` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `acc_id` char(32) DEFAULT NULL,
  `patient_id` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `valnus_detail_fk1` (`val_id`),
  KEY `valnus_detail_fk2` (`acc_id`),
  KEY `valnus_detail_fk3` (`patient_id`),
  CONSTRAINT `valnus_detail_fk1` FOREIGN KEY (`val_id`) REFERENCES `valnus_type` (`id`),
  CONSTRAINT `valnus_detail_fk2` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`),
  CONSTRAINT `valnus_detail_fk3` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `valnus_type` */

DROP TABLE IF EXISTS `valnus_type`;

CREATE TABLE `valnus_type` (
  `id` char(32) NOT NULL,
  `parent_id` char(32) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `vital_sign` */

DROP TABLE IF EXISTS `vital_sign`;

CREATE TABLE `vital_sign` (
  `id` char(32) NOT NULL,
  `acc_id` char(32) NOT NULL,
  `patient_id` char(32) NOT NULL,
  `bp_sbp` varchar(10) DEFAULT NULL,
  `bp_dbp` varchar(10) DEFAULT NULL,
  `p_heart_rate` varchar(5) DEFAULT NULL,
  `spo2` varchar(5) DEFAULT NULL,
  `breathing_rate` varchar(5) DEFAULT NULL,
  `body_temperature` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vital_sign_fk1` (`acc_id`),
  KEY `vital_sign_fk2` (`patient_id`),
  CONSTRAINT `vital_sign_fk1` FOREIGN KEY (`acc_id`) REFERENCES `accident` (`id`),
  CONSTRAINT `vital_sign_fk2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
