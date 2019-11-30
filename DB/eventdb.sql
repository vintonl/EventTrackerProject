-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eventdb` ;

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventdb` DEFAULT CHARACTER SET utf8 ;
USE `eventdb` ;

-- -----------------------------------------------------
-- Table `beverage_tracker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beverage_tracker` ;

CREATE TABLE IF NOT EXISTS `beverage_tracker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `date_consumed` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beverage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beverage` ;

CREATE TABLE IF NOT EXISTS `beverage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(400) NULL DEFAULT NULL,
  `ingredients` TEXT(500) NULL DEFAULT NULL,
  `caffeinated` TINYINT NOT NULL DEFAULT 0,
  `contains_alcohol` TINYINT NOT NULL DEFAULT 0,
  `calories` INT NOT NULL DEFAULT 0,
  `volume` DOUBLE NOT NULL DEFAULT 8,
  `active` TINYINT NOT NULL DEFAULT 1,
  `beverage_tracker_id` INT NOT NULL,
  `caffeine` INT NOT NULL DEFAULT 0,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_beverage_beverage_tracker_idx` (`beverage_tracker_id` ASC),
  CONSTRAINT `fk_beverage_beverage_tracker`
    FOREIGN KEY (`beverage_tracker_id`)
    REFERENCES `beverage_tracker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS eventuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'eventuser'@'localhost' IDENTIFIED BY 'eventuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'eventuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `beverage_tracker`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventdb`;
INSERT INTO `beverage_tracker` (`id`, `first_name`, `last_name`, `date_consumed`) VALUES (1, 'Test', 'Test', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `beverage`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventdb`;
INSERT INTO `beverage` (`id`, `name`, `description`, `ingredients`, `caffeinated`, `contains_alcohol`, `calories`, `volume`, `active`, `beverage_tracker_id`, `caffeine`, `updated_at`) VALUES (1, 'water', 'H2O from the tap', 'water', DEFAULT, DEFAULT, 0, 8, DEFAULT, 1, DEFAULT, DEFAULT);
INSERT INTO `beverage` (`id`, `name`, `description`, `ingredients`, `caffeinated`, `contains_alcohol`, `calories`, `volume`, `active`, `beverage_tracker_id`, `caffeine`, `updated_at`) VALUES (2, 'coffee', 'brewed fresh', 'water and coffee', 1, DEFAULT, 0, 8, DEFAULT, 1, 95, DEFAULT);

COMMIT;

