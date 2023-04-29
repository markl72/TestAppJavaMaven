CREATE DATABASE insecureapp;
USE insecureapp;
CREATE TABLE users (userid varchar(200), last_name varchar(200), first_name varchar(200), address varchar(200), phone_no varchar(200), password varchar(200));
INSERT INTO users VALUES ('user1', 'L', 'Mark', '111 ABC Street', '0123456789', 'password1');
INSERT INTO users VALUES ('user2', 'Smith', 'J', '22 Dee Street', '0134567892', 'P@ssw0rd');
INSERT INTO users VALUES ('user3', 'Jones', 'H', '34 Eazy Crescent', '0145678923', 'monday07');
INSERT INTO users VALUES ('user4', 'Brown', 'S', '45 XYZ Road', '0156789234', 'australia');
CREATE USER 'insecureapp'@'localhost' IDENTIFIED BY '45EUlZOpL7';
GRANT ALL PRIVILEGES ON *.* TO 'insecureapp'@'localhost';