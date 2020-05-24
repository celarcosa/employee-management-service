CREATE DATABASE IF NOT EXISTS emp;
USE emp;

CREATE TABLE `emp`.`employee_contact_info` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `contact` VARCHAR(16) NULL,
  `primary` TINYINT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `emp`.`employee_address_info` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `address_line_1` VARCHAR(255) NULL,
  `address_line_2` VARCHAR(255) NULL,
  `primary` TINYINT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `emp`.`user_details` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `civil_status` VARCHAR(24) NULL,
  `gender` CHAR(1) NULL,
  `position` VARCHAR(45) NULL,
  `date_hired` DATE NULL,
  `employee_contact_info_id` BIGINT NULL,
  `employee_address_info_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_contact_info_idx` (`employee_contact_info_id` ASC) VISIBLE,
  INDEX `employee_address_info_idx` (`employee_address_info_id` ASC) VISIBLE,
  CONSTRAINT `employee_contact_info`
    FOREIGN KEY (`employee_contact_info_id`)
    REFERENCES `emp`.`employee_contact_info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `employee_address_info`
    FOREIGN KEY (`employee_address_info_id`)
    REFERENCES `emp`.`employee_address_info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `emp`.`user_accounts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NULL,
  `roles` VARCHAR(255) NULL,
  `user_details_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  INDEX `user_details_idx` (`user_details_id` ASC) VISIBLE,
  CONSTRAINT `user_details`
    FOREIGN KEY (`user_details_id`)
    REFERENCES `emp`.`user_details` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

