-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema utopia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema utopia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `utopia` DEFAULT CHARACTER SET utf8 ;
USE `utopia` ;

-- -----------------------------------------------------
-- Table `utopia`.`tbl_airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_airport` (
  `iataIdent` VARCHAR(4) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `airportId` INT NOT NULL,
  PRIMARY KEY (`iataIdent`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NOT NULL,
  `locked` TINYINT(1) NOT NULL,
  `userRole` INT NULL DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `tbl_users_email_uindex` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 103
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_booking` (
  `bookingId` INT NOT NULL AUTO_INCREMENT,
  `isActive` TINYINT NOT NULL,
  `stripeId` VARCHAR(45) NOT NULL,
  `bookerId` INT NOT NULL,
  PRIMARY KEY (`bookingId`),
  INDEX `fk_tbl_booking_tbl_users1_idx` (`bookerId` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_booking_tbl_users1`
    FOREIGN KEY (`bookerId`)
    REFERENCES `utopia`.`tbl_users` (`userId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 168
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_traveler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_traveler` (
  `travelerId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dob` DATETIME NOT NULL,
  PRIMARY KEY (`travelerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 91
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_bookings_has_travelers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_bookings_has_travelers` (
  `bookingId` INT NOT NULL,
  `travelerId` INT NOT NULL,
  PRIMARY KEY (`bookingId`, `travelerId`),
  UNIQUE INDEX `travelerId` (`travelerId` ASC) VISIBLE,
  INDEX `fk_tbl_bookings_has_tbl_traveler_tbl_traveler1_idx` (`travelerId` ASC) VISIBLE,
  INDEX `fk_tbl_bookings_has_tbl_traveler_tbl_bookings1_idx` (`bookingId` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_bookings_has_tbl_traveler_tbl_bookings1`
    FOREIGN KEY (`bookingId`)
    REFERENCES `utopia`.`tbl_booking` (`bookingId`),
  CONSTRAINT `fk_tbl_bookings_has_tbl_traveler_tbl_traveler1`
    FOREIGN KEY (`travelerId`)
    REFERENCES `utopia`.`tbl_traveler` (`travelerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight_details` (
  `flightNumber` VARCHAR(4) NOT NULL,
  `departCityId` VARCHAR(4) NULL DEFAULT NULL,
  `arriveCityId` VARCHAR(4) NULL DEFAULT NULL,
  PRIMARY KEY (`flightNumber`),
  INDEX `tbl_flight_details_arriveCityId_index` (`arriveCityId` ASC) VISIBLE,
  INDEX `tbl_flight_details_departCityId_index` (`departCityId` ASC) VISIBLE,
  CONSTRAINT `tbl_flight_details_tbl_airport_iataIdent_fk`
    FOREIGN KEY (`departCityId`)
    REFERENCES `utopia`.`tbl_airport` (`iataIdent`)
    ON UPDATE CASCADE,
  CONSTRAINT `tbl_flight_details_tbl_airport_iataIdent_fk_2`
    FOREIGN KEY (`arriveCityId`)
    REFERENCES `utopia`.`tbl_airport` (`iataIdent`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight` (
  `flightId` INT NOT NULL AUTO_INCREMENT,
  `departTime` DATETIME NOT NULL,
  `seatsAvailable` INT NOT NULL,
  `price` DECIMAL(13,2) NOT NULL,
  `arrivalTime` DATETIME NOT NULL,
  `flightNumber` VARCHAR(4) NULL DEFAULT NULL,
  PRIMARY KEY (`flightId`),
  INDEX `idx_tbl_flight_departTime` (`departTime` ASC) VISIBLE,
  INDEX `idx_tbl_flight_arrivalTime` (`arrivalTime` ASC) VISIBLE,
  INDEX `tbl_flight_tbl_flight_details_flightNumber_fk` (`flightNumber` ASC) VISIBLE,
  CONSTRAINT `tbl_flight_tbl_flight_details_flightNumber_fk`
    FOREIGN KEY (`flightNumber`)
    REFERENCES `utopia`.`tbl_flight_details` (`flightNumber`))
ENGINE = InnoDB
AUTO_INCREMENT = 2913637
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_flight_has_bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_flight_has_bookings` (
  `flightId` INT NOT NULL,
  `bookingId` INT NOT NULL,
  PRIMARY KEY (`flightId`, `bookingId`),
  INDEX `fk_tbl_flights_has_tbl_bookings_tbl_bookings1_idx` (`bookingId` ASC) VISIBLE,
  INDEX `fk_tbl_flights_has_tbl_bookings_tbl_flights1_idx` (`flightId` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_flights_has_tbl_bookings_tbl_bookings1`
    FOREIGN KEY (`bookingId`)
    REFERENCES `utopia`.`tbl_booking` (`bookingId`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_tbl_flights_has_tbl_bookings_tbl_flights1`
    FOREIGN KEY (`flightId`)
    REFERENCES `utopia`.`tbl_flight` (`flightId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `utopia`.`tbl_user_signup_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `utopia`.`tbl_user_signup_token` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `confirmationToken` VARCHAR(100) NOT NULL,
  `createdDate` DATETIME NOT NULL,
  `userId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tbl_user_signup_token_confirmationToken_uindex` (`confirmationToken` ASC) VISIBLE,
  INDEX `tbl_user_signup_token_tbl_users_userId_fk` (`userId` ASC) VISIBLE,
  CONSTRAINT `tbl_user_signup_token_tbl_users_userId_fk`
    FOREIGN KEY (`userId`)
    REFERENCES `utopia`.`tbl_users` (`userId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 67
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('ORD', 'Chicago, Illinois');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('MDW', 'Chicago, Illinois');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('CVG', 'Cincinnati, Ohio');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('ELP', 'El Paso, TX');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('FNT', 'Flint, Michigan');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('JAX', 'Jacksonvolle, Florida');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('CGK', 'Jakarta, Java, Indonesia');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('KBL', 'Kabul, Afghanistan');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('MCI', 'Kansas City, Missouri ');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('LAN', 'Lansing, Michigan');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('LAS', 'Las Vegas, Nevada');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('STN', 'London, England');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('LUX', 'Luxembourg, Luxembourg');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('MTY', 'Monterrey, Mexico');
INSERT INTO `utopia`.`airport` (`iata_id`, `city`) VALUES ('LGA', 'New York. New York');

INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('1', 'CVG', 'ELP');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('2', 'MTY', 'MCI');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('3', 'STN', 'LUX');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('4', 'FNT', 'JAX');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('5', 'CVG', 'LGA');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('6', 'LAN', 'ELP');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('7', 'MTY', 'LAS');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('8', 'LGA', 'CVG');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('9', 'LUX', 'STN');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('10', 'KBL', 'LUX');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('11', 'MDW', 'FNT');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('12', 'STN', 'ORD');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('13', 'LAN', 'MDW');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('14', 'LAS', 'LGA');
INSERT INTO `utopia`.`route` (`id`, `origin_id`, `destination_id`) VALUES ('15', 'MTY', 'LGA');

INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('1', '46 ');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('2', '220');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('3', '124');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('4', '150');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('5', '199');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('6', '295');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('7', '313');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('8', '270');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('9', '555');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('10', '419');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('11', '359');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('12', '335');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('13', '360');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('14', '141');
INSERT INTO `utopia`.`airplane_type` (`id`, `max_capacity`) VALUES ('15', '106');

INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('1', '4');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('2', '9');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('3', '15');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('4', '12');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('5', '3');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('6', '9');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('7', '11');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('8', '14');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('9', '6');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('10', '2');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('11', '9');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('12', '8');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('13', '7');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('14', '1');
INSERT INTO `utopia`.`airplane` (`id`, `type_id`) VALUES ('15', '7');

