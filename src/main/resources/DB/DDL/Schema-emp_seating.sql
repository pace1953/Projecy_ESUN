-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema emp_seating
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema emp_seating
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emp_seating` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `emp_seating` ;

-- -----------------------------------------------------
-- Table `emp_seating`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emp_seating`.`employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `floor_seat_seq` INT NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE INDEX `UKfopic1oh5oln2khj8eat6ino0` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10002
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `emp_seating`.`seating_chart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emp_seating`.`seating_chart` (
  `floor_seat_seq` INT NOT NULL AUTO_INCREMENT,
  `floor_no` INT NOT NULL,
  `seat_no` INT NOT NULL,
  PRIMARY KEY (`floor_seat_seq`),
  UNIQUE INDEX `unique_floor_seat` (`floor_no` ASC, `seat_no` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
