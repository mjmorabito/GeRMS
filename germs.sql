DROP DATABASE germs;
DROP USER 'GermsAdmin'@'localhost';

CREATE DATABASE germs;

CREATE USER 'GermsAdmin'@'localhost' IDENTIFIED BY 'g3rm5p0w3ru53r';
GRANT ALL PRIVILEGES ON germs.* TO 'GermsAdmin'@'localhost';
FLUSH PRIVILEGES;

USE germs;

CREATE TABLE securityquestion(
	secID int PRIMARY KEY AUTO_INCREMENT,
    secQuestion varchar(255) NOT NULL);

INSERT INTO securityquestion VALUES(null, "what is you favorite color?");
INSERT INTO securityquestion VALUES(null, "what is your favorite animal?");
INSERT INTO securityquestion VALUES(null, "what is your dad's name?");
INSERT INTO securityquestion VALUES(null, "what is your mom's name?");

CREATE TABLE accounts(
   accUser varchar(255) PRIMARY KEY,
   accpassword varchar(255) NOT NULL,
   accfirstname varchar(255) NOT NULL,
   acclastname varchar(255) NOT NULL,
   secID int, 
   secAnswer varchar(255) NOT NULL,
   secretKey varchar(255) NOT NULL,

   FOREIGN KEY (secID)
   REFERENCES securityquestion(secID));

INSERT INTO accounts VALUES ("admin","EjpBfslmhWLRaFsODHZ/gg==", "Administrator", "GeRMS", 1,"black","IKT1l/pEVogErpGSIgMWQg==");


CREATE TABLE standards(
	standardID varchar(3) PRIMARY KEY,
	description varchar(255) NOT NULL);

INSERT INTO standards VALUES("KN1","Counting");
INSERT INTO standards VALUES("KN2","Matching");
INSERT INTO standards VALUES("KN3","Position");
INSERT INTO standards VALUES("KN4","Comparing");
INSERT INTO standards VALUES("KN5","Half and Whole");
INSERT INTO standards VALUES("KN6","Coins");
INSERT INTO standards VALUES("KN7","Math with Drawings");
INSERT INTO standards VALUES("KN8","Estimate");

CREATE TABLE practices(
	PaccUser varchar(255),
	PstandardID varchar(3),

	FOREIGN KEY (PaccUser) REFERENCES accounts(accUser),
	FOREIGN KEY (PstandardID) REFERENCES standards(standardID));


CREATE TABLE grades(
	gradeID int PRIMARY KEY AUTO_INCREMENT,
	gdescription varchar(15) NOT NULL);

INSERT INTO grades VALUES(null, "Pre K - K");
INSERT INTO grades VALUES(null, "Grade 1 - 2");
INSERT INTO grades VALUES(null, "Grade 3 - 4");


CREATE TABLE quizzes(
	QaccUser varchar(255),
	QgradeID int,
	Qdifficulty int NOT NULL,
	Qcorrectanswers int NOT NULL,
	S1 varchar(4) NOT NULL,
	Q1 BOOLEAN NOT NULL,
	S2 varchar(4) NOT NULL,
	Q2 BOOLEAN NOT NULL,
	S3 varchar(4) NOT NULL,
	Q3 BOOLEAN NOT NULL,
	S4 varchar(4) NOT NULL,
	Q4 BOOLEAN NOT NULL,
	S5 varchar(4) NOT NULL,
	Q5 BOOLEAN NOT NULL,
	S6 varchar(4) NOT NULL,
	Q6 BOOLEAN NOT NULL,
	Qdate DATETIME NOT NULL,

	FOREIGN KEY (QaccUser) REFERENCES accounts(accUser),
	FOREIGN KEY (QgradeID) REFERENCES grades(gradeID),
	FOREIGN KEY (S1) REFERENCES standards(standardID),
	FOREIGN KEY (S2) REFERENCES standards(standardID),
	FOREIGN KEY (S3) REFERENCES standards(standardID),
	FOREIGN KEY (S4) REFERENCES standards(standardID),
	FOREIGN KEY (S5) REFERENCES standards(standardID),
	FOREIGN KEY (S6) REFERENCES standards(standardID));

CREATE TABLE finals(
	FaccUser varchar(255),
	FgradeID int,
	Qcorrectanswers int NOT NULL,
	Q1 BOOLEAN NOT NULL,
	Q2 BOOLEAN NOT NULL,
	Q3 BOOLEAN NOT NULL,
	Q4 BOOLEAN NOT NULL,
	Q5 BOOLEAN NOT NULL,
	Q6 BOOLEAN NOT NULL,
	Q7 BOOLEAN NOT NULL,
	Q8 BOOLEAN NOT NULL,
	Q9 BOOLEAN NOT NULL,
	Q10 BOOLEAN NOT NULL,
	Fdate DATETIME NOT NULL,

	FOREIGN KEY (FaccUser) REFERENCES accounts(accUser),
	FOREIGN KEY (FgradeID) REFERENCES grades(gradeID));