-- Stored Procedures
DELIMITER $$
-- inserts a person
CREATE PROCEDURE InsertPerson (
    IN FullName VARCHAR(255),
    IN BirthDate DATE
)
BEGIN
    INSERT INTO Person (FullName, BirthDate)
    VALUES (FullName, BirthDate);
END $$

DELIMITER ;

-- Inserts a student type
DELIMITER $$

CREATE PROCEDURE InsertStudentType (
    IN TypeValue VARCHAR(255)
)
BEGIN
    INSERT INTO StudentType (TypeValue)
    VALUES (TypeValue);
END $$

DELIMITER ;

-- inserts a student
DELIMITER $$

CREATE PROCEDURE InsertStudent (
    IN StudentID INT,
    IN StudentTypeID INT,
    IN InState BOOLEAN
)
BEGIN
    INSERT INTO Student (StudentID, StudentTypeID, InState)
    VALUES (StudentID, StudentTypeID, InState);
END $$

DELIMITER ;

-- inserts an Address Type
DELIMITER $$

CREATE PROCEDURE InsertAddressType (
    IN TypeValue VARCHAR(255)
)
BEGIN
    INSERT INTO AddressType (TypeValue)
    VALUES (TypeValue);
END $$

DELIMITER ;

-- inserts an address
DELIMITER $$

CREATE PROCEDURE InsertAddress (
    IN PersonID INT,
    IN AddressTypeID INT,
    IN Street VARCHAR(255),
    IN City VARCHAR(100),
    IN State CHAR(2),
    IN PostalCode VARCHAR(10)
)
BEGIN
    INSERT INTO Address (PersonID, AddressTypeID, Street, City, State, PostalCode)
    VALUES (PersonID, AddressTypeID, Street, City, State, PostalCode);
END $$

DELIMITER ;

-- inserts an Employee
DELIMITER $$

CREATE PROCEDURE InsertEmployee (
    IN EmployeeID INT,
    IN DateHired DATE,
    IN EmployeeType CHAR(1)
)
BEGIN
    INSERT INTO Employee (EmployeeID, DateHired, EmployeeType)
    VALUES (EmployeeID, DateHired, EmployeeType);
END $$

DELIMITER ;

-- inserts a Maintenace Employee
DELIMITER $$

CREATE PROCEDURE InsertMaintenanceEmployee (
    IN MaintenanceID INT,
    IN MaintenanceLocationID INT,
    IN MaintenanceRole VARCHAR(255)
)
BEGIN
    INSERT INTO MaintenanceEmployee (MaintenanceID, MaintenanceLocationID, MaintenanceRole)
    VALUES (MaintenanceID, MaintenanceLocationID, MaintenanceRole);
END $$

DELIMITER ;

-- updates an address
DELIMITER $$

CREATE PROCEDURE UpdateAddress (
    IN PersonID INT,
    IN AddressTypeID INT,
    IN Street VARCHAR(255),
    IN City VARCHAR(100),
    IN State CHAR(2),
    IN PostalCode VARCHAR(10)
)
BEGIN
    UPDATE Address
    SET Street = Street, City = City, State = State, PostalCode = PostalCode
    WHERE PersonID = PersonID AND AddressTypeID = AddressTypeID;
END $$

DELIMITER ;

-- updates an employee
DELIMITER $$

CREATE PROCEDURE UpdateEmployeeDateHired (
    IN EmployeeID INT,
    IN DateHired DATE
)
BEGIN
    UPDATE Employee
    SET DateHired = DateHired
    WHERE EmployeeID = EmployeeID;
END $$

DELIMITER ;

-- deletes a student
DELIMITER $$

CREATE PROCEDURE DeleteStudent (
    IN StudentID INT
)
BEGIN
    DELETE FROM Student
    WHERE StudentID = StudentID;
END $$

DELIMITER ;

-- deletes a person
DELIMITER $$

CREATE PROCEDURE DeletePerson (
    IN PersonID INT
)
BEGIN
    DELETE FROM Person
    WHERE PersonID = PersonID;
END $$

DELIMITER ;

-- selects students for term
DELIMITER $$

CREATE PROCEDURE GetStudentsForTerm (
    IN TermID INT
)
BEGIN
    SELECT p.FullName, c.CourseName, sch.TermID
    FROM Student st
    JOIN Schedule sch ON st.StudentID = sch.StudentID
    JOIN Session s ON sch.SessionID = s.SessionID
    JOIN Course c ON s.CourseID = c.CourseID
    JOIN Person p ON st.StudentID = p.PersonID
    WHERE sch.TermID = TermID;
END $$

DELIMITER ;

-- counts students enrolled in a course
DELIMITER $$

CREATE PROCEDURE CountStudentsInCourse (
    IN CourseID INT
)
BEGIN
    SELECT c.CourseName, COUNT(sch.StudentID) AS StudentCount
    FROM Schedule sch
    JOIN Session ses ON sch.SessionID = ses.SessionID
    JOIN Course c ON ses.CourseID = c.CourseID
    WHERE c.CourseID = CourseID
    GROUP BY c.CourseName;
END $$

DELIMITER ;

-- checks course prereqs
DELIMITER $$

CREATE PROCEDURE GetCoursePrerequisites (
    IN CourseID INT
)
BEGIN
    SELECT c1.CourseName AS Course, c2.CourseName AS Prerequisite
    FROM Prerequisite p
    JOIN Course c1 ON p.CourseID = c1.CourseID
    JOIN Course c2 ON p.PrerequisiteID = c2.CourseID
    WHERE c1.CourseID = CourseID;
END $$

DELIMITER ;
-- code to execute 
CALL InsertPerson('Aileen Wuornos', '1956-02-29');
CALL InsertStudentType('Undergraduate');
CALL InsertStudent(8, 1, 1);
