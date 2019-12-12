-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema iiht-mentor-on-demand
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema iiht-mentor-on-demand
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `iiht-mentor-on-demand` DEFAULT CHARACTER SET utf8 ;
USE `iiht-mentor-on-demand` ;

-- -----------------------------------------------------
-- Table `iiht-mentor-on-demand`.`mentor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iiht-mentor-on-demand`.`mentor` (
  `mentor_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `mentor_linkedin_url` VARCHAR(255) NOT NULL,
  `mentor_timeslot` VARCHAR(11) NOT NULL,
  `mentor_years_of_experience` FLOAT NOT NULL,
  `mentor_user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`mentor_id`),
  INDEX `FKtfkx403mra3pna073o3h1k5ti` (`mentor_user_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iiht-mentor-on-demand`.`mentor_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iiht-mentor-on-demand`.`mentor_skill` (
  `ms_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ms_self_rating` FLOAT(2,1) NOT NULL,
  `ms_years_of_experience` FLOAT(2,1) NOT NULL,
  `ms_mentor_id` BIGINT(20) NOT NULL,
  `ms_skill_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ms_id`),
  INDEX `FKtnf1q2bkex81ftw7t7omvb83l` (`ms_mentor_id` ASC),
  INDEX `FKqcj1pqkrdlvbu4nkiqvc8q3io` (`ms_skill_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iiht-mentor-on-demand`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iiht-mentor-on-demand`.`skill` (
  `skill_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `skill_name` VARCHAR(255) NOT NULL,
  `skill_toc` VARCHAR(255) NULL DEFAULT NULL,
  `skill_prerequisite` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`skill_id`),
  INDEX `FKlwmdyofh8pruxjahcf88weuuv` (`skill_prerequisite` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iiht-mentor-on-demand`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iiht-mentor-on-demand`.`training` (
  `training_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `training_end_date` DATE NOT NULL,
  `training_progress` INT(11) NOT NULL,
  `training_rating` FLOAT NULL DEFAULT NULL,
  `training_start_date` DATE NOT NULL,
  `training_status` VARCHAR(20) NOT NULL,
  `training_mentor_id` BIGINT(20) NOT NULL,
  `training_skill_id` BIGINT(20) NOT NULL,
  `training_user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`training_id`),
  INDEX `FKb9n4i7r331uhflndhjj64kgr9` (`training_mentor_id` ASC),
  INDEX `FK8dfju72gnd7gmvmjhcjyjv1p` (`training_skill_id` ASC),
  INDEX `FKbesfm9lgjyrcjrn45gkjv5lci` (`training_user_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `iiht-mentor-on-demand`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iiht-mentor-on-demand`.`user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_contact_number` BIGINT(20) NOT NULL,
  `user_first_name` VARCHAR(25) NOT NULL,
  `user_last_name` VARCHAR(25) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL,
  `user_reset_password` TINYINT(2) NULL DEFAULT NULL,
  `user_reset_password_date` DATE NULL DEFAULT NULL,
  `user_role` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
