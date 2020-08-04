SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `employee_db` ;
USE `employee_db`;

-- -----------------------------------------------------
-- Table `employee_db`.`employee`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employee_db`.`employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT ,
  `emp_firstName` VARCHAR(45) NOT NULL ,
  `emp_middleName` VARCHAR(45) NULL ,
  `emp_lastName` VARCHAR(45) NOT NULL ,
  `emp_gender` VARCHAR(45) NOT NULL ,
  `emp_email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`emp_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_db`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employee_db`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_username` VARCHAR(45) NOT NULL ,
  `us_password` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`us_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_db`.`role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employee_db`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_db`.`user_role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `employee_db`.`user_role` (
  `ur_us_id` INT NOT NULL ,
  `ur_ro_id` INT NOT NULL ,
  `ur_id` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`ur_id`) ,
  INDEX `fk_user_has_role_user` (`ur_us_id` ASC) ,
  INDEX `fk_user_has_role_role` (`ur_ro_id` ASC) ,
  CONSTRAINT `fk_user_has_role_user`
    FOREIGN KEY (`ur_us_id` )
    REFERENCES `employee_db`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role`
    FOREIGN KEY (`ur_ro_id` )
    REFERENCES `employee_db`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Data for table `employee_db`.`employee`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `employee_db`;
INSERT INTO `employee` (`emp_id`, `emp_firstName`, `emp_middleName`, `emp_lastName`, `emp_gender`, `emp_email`) VALUES (1, 'a', 'b', 'c', 'male', '');
INSERT INTO `employee` (`emp_id`, `emp_firstName`, `emp_middleName`, `emp_lastName`, `emp_gender`, `emp_email`) VALUES (2, 'aa', 'bb', 'cc', 'male', 'abab');

COMMIT;

-- -----------------------------------------------------
-- Data for table `employee_db`.`user`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `employee_db`;
INSERT INTO `user` (`us_id`, `us_username`, `us_password`) VALUES (1, 'admin', '$2a$10$Q0uCGEjkvXbtMobb18w2kOjhNggdGhEVzwNhLhT5vkGUWbgGGgIle');
INSERT INTO `user` (`us_id`, `us_username`, `us_password`) VALUES (2, 'user', '$2a$10$Q0uCGEjkvXbtMobb18w2kOjhNggdGhEVzwNhLhT5vkGUWbgGGgIle');

COMMIT;

-- -----------------------------------------------------
-- Data for table `employee_db`.`role`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `employee_db`;
INSERT INTO `role` (`ro_id`, `ro_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` (`ro_id`, `ro_name`) VALUES (2, 'ROLE_USER);

COMMIT;

-- -----------------------------------------------------
-- Data for table `employee_db`.`user_role`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `employee_db`;
INSERT INTO `user_role` (`ur_us_id`, `ur_ro_id`, `ur_id`) VALUES (1, 1, 1);
INSERT INTO `user_role` (`ur_us_id`, `ur_ro_id`, `ur_id`) VALUES (2, 2, 2);

COMMIT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
