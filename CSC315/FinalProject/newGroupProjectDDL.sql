-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`StudentType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`StudentType` (
  `StudentTypeID` INT NOT NULL AUTO_INCREMENT,
  `TypeValue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`StudentTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Person` (
  `PersonID` INT NOT NULL AUTO_INCREMENT,
  `FullName` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NOT NULL,
  PRIMARY KEY (`PersonID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student` (
  `StudentID` INT NOT NULL,
  `StudentTypeID` INT NOT NULL,
  `InState` TINYINT NOT NULL,
  PRIMARY KEY (`StudentID`),
  INDEX `fk_Student_StudentType1_idx` (`StudentTypeID` ASC) VISIBLE,
  INDEX `fk_Student_Person1_idx` (`StudentID` ASC) VISIBLE,
  CONSTRAINT `fk_Student_StudentType1`
    FOREIGN KEY (`StudentTypeID`)
    REFERENCES `mydb`.`StudentType` (`StudentTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Person1`
    FOREIGN KEY (`StudentID`)
    REFERENCES `mydb`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AddressType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AddressType` (
  `AddressTypeID` INT NOT NULL AUTO_INCREMENT,
  `TypeValue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AddressTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Address` (
  `PersonID` INT NOT NULL,
  `AddressTypeID` INT NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `City` VARCHAR(30) NOT NULL,
  `State` VARCHAR(2) NOT NULL,
  `PostalCode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`PersonID`, `AddressTypeID`),
  INDEX `fk_Address_Person1_idx` (`PersonID` ASC) VISIBLE,
  INDEX `fk_Address_AddressType1_idx` (`AddressTypeID` ASC) VISIBLE,
  CONSTRAINT `fk_Address_Person1`
    FOREIGN KEY (`PersonID`)
    REFERENCES `mydb`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Address_AddressType1`
    FOREIGN KEY (`AddressTypeID`)
    REFERENCES `mydb`.`AddressType` (`AddressTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `EmployeeID` INT NOT NULL,
  `DateHired` DATE NOT NULL,
  `EmployeeType` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  INDEX `fk_Employee_Person1_idx` (`EmployeeID` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Person1`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `mydb`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Room` (
  `LocationID` INT NOT NULL AUTO_INCREMENT,
  `BuildingName` VARCHAR(45) NOT NULL,
  `RoomNumber` VARCHAR(45) NULL,
  PRIMARY KEY (`LocationID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MaintenanceEmployee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MaintenanceEmployee` (
  `MaintenanceID` INT NOT NULL,
  `MaintenanceLocationID` INT NOT NULL,
  `MaintenanceRole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaintenanceID`),
  INDEX `fk_MaintenanceEmployee_Building1_idx` (`MaintenanceLocationID` ASC) VISIBLE,
  INDEX `fk_MaintenanceEmployee_Employee1_idx` (`MaintenanceID` ASC) VISIBLE,
  CONSTRAINT `fk_MaintenanceEmployee_Building1`
    FOREIGN KEY (`MaintenanceLocationID`)
    REFERENCES `mydb`.`Room` (`LocationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MaintenanceEmployee_Employee1`
    FOREIGN KEY (`MaintenanceID`)
    REFERENCES `mydb`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department` (
  `DepartmentID` INT NOT NULL AUTO_INCREMENT,
  `DepartmentName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DepartmentID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor` (
  `ProfessorID` INT NOT NULL,
  `Department_DepartmentID` INT NOT NULL,
  `OfficeLocationID` INT NOT NULL,
  `Qualification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ProfessorID`),
  INDEX `fk_Professor_Employee1_idx` (`ProfessorID` ASC) VISIBLE,
  INDEX `fk_Professor_Building1_idx` (`OfficeLocationID` ASC) VISIBLE,
  INDEX `fk_Professor_Department1_idx` (`Department_DepartmentID` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_Employee1`
    FOREIGN KEY (`ProfessorID`)
    REFERENCES `mydb`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_Building1`
    FOREIGN KEY (`OfficeLocationID`)
    REFERENCES `mydb`.`Room` (`LocationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_Department1`
    FOREIGN KEY (`Department_DepartmentID`)
    REFERENCES `mydb`.`Department` (`DepartmentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course` (
  `CourseID` INT NOT NULL AUTO_INCREMENT,
  `CourseName` VARCHAR(45) NOT NULL,
  `Hours` INT NOT NULL,
  PRIMARY KEY (`CourseID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Session` (
  `SessionID` INT NOT NULL AUTO_INCREMENT,
  `ProfessorID` INT NOT NULL,
  `CourseID` INT NOT NULL,
  `RoomID` INT NOT NULL,
  `DateOffered` DATE NOT NULL,
  PRIMARY KEY (`SessionID`),
  INDEX `fk_table1_Professor1_idx` (`ProfessorID` ASC) VISIBLE,
  INDEX `fk_Session_Course1_idx` (`CourseID` ASC) VISIBLE,
  INDEX `fk_Session_Building1_idx` (`RoomID` ASC) VISIBLE,
  CONSTRAINT `fk_table1_Professor1`
    FOREIGN KEY (`ProfessorID`)
    REFERENCES `mydb`.`Professor` (`ProfessorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Session_Course1`
    FOREIGN KEY (`CourseID`)
    REFERENCES `mydb`.`Course` (`CourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Session_Building1`
    FOREIGN KEY (`RoomID`)
    REFERENCES `mydb`.`Room` (`LocationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Term` (
  `TermID` INT NOT NULL AUTO_INCREMENT,
  `Semester` VARCHAR(45) NOT NULL,
  `TermYear` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`TermID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Schedule` (
  `SessionID` INT NOT NULL,
  `StudentID` INT NOT NULL,
  `TermID` INT NOT NULL,
  PRIMARY KEY (`SessionID`, `StudentID`),
  INDEX `fk_Schedule_Session1_idx` (`SessionID` ASC) VISIBLE,
  INDEX `fk_Schedule_Term1_idx` (`TermID` ASC) VISIBLE,
  INDEX `fk_Schedule_Student1_idx` (`StudentID` ASC) VISIBLE,
  CONSTRAINT `fk_Schedule_Session1`
    FOREIGN KEY (`SessionID`)
    REFERENCES `mydb`.`Session` (`SessionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Schedule_Term1`
    FOREIGN KEY (`TermID`)
    REFERENCES `mydb`.`Term` (`TermID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Schedule_Student1`
    FOREIGN KEY (`StudentID`)
    REFERENCES `mydb`.`Student` (`StudentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prerequisite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prerequisite` (
  `CourseID` INT NOT NULL,
  `PrerequisiteID` INT NOT NULL,
  PRIMARY KEY (`CourseID`, `PrerequisiteID`),
  INDEX `fk_Prerequisite_Course2_idx` (`PrerequisiteID` ASC) VISIBLE,
  CONSTRAINT `fk_Prerequisite_Course1`
    FOREIGN KEY (`CourseID`)
    REFERENCES `mydb`.`Course` (`CourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prerequisite_Course2`
    FOREIGN KEY (`PrerequisiteID`)
    REFERENCES `mydb`.`Course` (`CourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ContactType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ContactType` (
  `ContactTypeID` INT NOT NULL AUTO_INCREMENT,
  `TypeValue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ContactTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Contact` (
  `ContactID` INT NOT NULL AUTO_INCREMENT,
  `PersonID` INT NOT NULL,
  `ContactTypeID` INT NOT NULL,
  `ContactValue` VARCHAR(45) NOT NULL,
  `ContactMedium` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ContactID`),
  INDEX `fk_Contact_Person1_idx` (`PersonID` ASC) VISIBLE,
  INDEX `fk_Contact_ContactType1_idx` (`ContactTypeID` ASC) VISIBLE,
  CONSTRAINT `fk_Contact_Person1`
    FOREIGN KEY (`PersonID`)
    REFERENCES `mydb`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contact_ContactType1`
    FOREIGN KEY (`ContactTypeID`)
    REFERENCES `mydb`.`ContactType` (`ContactTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OfficeWorker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OfficeWorker` (
  `Employee_EmployeeID` INT NOT NULL,
  `OfficeLocationID` INT NOT NULL,
  PRIMARY KEY (`Employee_EmployeeID`),
  INDEX `fk_OfficeWorker_Building1_idx` (`OfficeLocationID` ASC) VISIBLE,
  CONSTRAINT `fk_OfficeWorker_Employee1`
    FOREIGN KEY (`Employee_EmployeeID`)
    REFERENCES `mydb`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfficeWorker_Building1`
    FOREIGN KEY (`OfficeLocationID`)
    REFERENCES `mydb`.`Room` (`LocationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
