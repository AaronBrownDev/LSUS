-- Create database
CREATE DATABASE IF NOT EXISTS event_survey_db;

-- Use the database
USE event_survey_db;

-- Create the responses table
CREATE TABLE responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    event_name VARCHAR(255),
    event_type VARCHAR(50),
    rating INT,
    interest VARCHAR(5),
    highlight TEXT,
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the event survey user role
CREATE USER 'survey_user'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON event_survey_db.* TO 'survey_user'@'localhost';

-- Applies changes
FLUSH PRIVILEGES;