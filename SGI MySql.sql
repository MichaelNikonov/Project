/*
* Ort Braude College Of Engineering
* Software Engineering Lab Course - Spring 2014
* =============================================
* SGI System Project:
* MySql database file
* =============================================
* Group 7 - Students:
* -------------------
* 	Ron Dadon 			(ID: 038134144)
*	Michael Nikonov		(ID: )
*	Irena Davidov		(ID: )
* 	Yana Nikitchenko	(ID: )
*/

/* Drop SGI database if exists */
DROP DATABASE IF EXISTS SGI;

/* Create new empty database SGI */
CREATE DATABASE SGI DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

/* Set the currently used database to SGI */
USE SGI;

/*
* Create tables 
* =============
* all 'timedate' fields will be in the format of 'DD/MM/YYYY HH:mm:ss'
*/

CREATE TABLE permissions (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE users (
	username VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	permission INT NOT NULL,
	PRIMARY KEY (username),
	FOREIGN KEY (permission) REFERENCES permissions(id)
);

CREATE TABLE clients (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	phone VARCHAR(11),
	email VARCHAR(255),
	username VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (id),
	FOREIGN KEY (username) REFERENCES users(username)	
);

CREATE TABLE employee_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE employees (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	phone VARCHAR(11),
	email VARCHAR(255),
	e_number VARCHAR(20) UNIQUE,
	e_type INT,
	username VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (id),
	FOREIGN KEY (username) REFERENCES users(username),	
	FOREIGN KEY (e_type) REFERENCES employee_type(id)
);

CREATE TABLE online_users (
	username VARCHAR(255) NOT NULL UNIQUE,
	timedate DATETIME NOT NULL,
	ip VARCHAR(17) NOT NULL
);

CREATE TABLE locations (
	id INT NOT NULL AUTO_INCREMENT,
	xcoord INT NOT NULL,
	ycoord INT NOT NULL,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE images (
	id INT NOT NULL AUTO_INCREMENT,
	location INT NOT NULL,
	timedate DATETIME NOT NULL,
	file VARCHAR(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (location) REFERENCES locations(id)
);

CREATE TABLE layer_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE layers (
	id INT NOT NULL AUTO_INCREMENT,
	file VARCHAR(255) NOT NULL,
	image_id INT NOT NULL,
	l_type INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (image_id) REFERENCES images(id),
	FOREIGN KEY (l_type) REFERENCES layer_type(id)
);

CREATE TABLE purchase_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE purchases (
	id INT NOT NULL AUTO_INCREMENT,
	image_id INT NOT NULL,
	client_id INT NOT NULL,
	p_type INT NOT NULL,
	price FLOAT NOT NULL,
	timedate DATETIME NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (image_id) REFERENCES images(id),
	FOREIGN KEY (client_id) REFERENCES clients(id),
	FOREIGN KEY (p_type) REFERENCES purchase_type(id)
);

CREATE TABLE image_search_log (
	image_location VARCHAR(255),
	image_date VARCHAR(10),
	image_time VARCHAR(8),
	client_id INT NOT NULL,
	timedate DATETIME NOT NULL,
	results INT NOT NULL,
	FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE complaint_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE complaints (
	id INT NOT NULL AUTO_INCREMENT,
	employee_id INT NOT NULL,
	client_id INT NOT NULL,
	c_type INT NOT NULL,
	title VARCHAR(255),
	content TEXT NOT NULL,
	reply TEXT NOT NULL,
	compensation FLOAT NOT NULL,
	send_timedate DATETIME NOT NULL,
	reply_timedate DATETIME NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (employee_id) REFERENCES employees(id),
	FOREIGN KEY (client_id) REFERENCES clients(id),
	FOREIGN KEY (c_type) REFERENCES complaint_type(id)
);

CREATE TABLE subscription_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE subscriptions (
	id INT NOT NULL AUTO_INCREMENT,
	s_type INT NOT NULL,
	layer_type INT UNIQUE,
	image_amount INT,
	PRIMARY KEY (id),
	FOREIGN KEY (s_type) REFERENCES subscription_type(id),
	FOREIGN KEY (layer_type) REFERENCES layer_type(id)
);

CREATE TABLE subscription_purchases (
	subscription_id INT NOT NULL,
	client_id INT NOT NULL,
	timedate DATETIME NOT NULL,
	used_images INT NOT NULL,
	price FLOAT NOT NULL,
	FOREIGN KEY (subscription_id) REFERENCES subscriptions(id),
	FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE price_type (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE prices (
	id INT NOT NULL AUTO_INCREMENT,
	p_type INT NOT NULL,
	price INT NOT NULL,
	timedate DATETIME NOT NULL,
	ceo_approve BOOLEAN,
	active BOOLEAN,
	PRIMARY KEY (id),	
	FOREIGN KEY (p_type) REFERENCES price_type(id)
);

/*
* Insert default data 
* ===================
*/

INSERT INTO permissions 
	(id,name) 
VALUES 
	(NULL,'Client'),
	(NULL,'CEO'),
	(NULL,'System Admin'),
	(NULL,'Archive'),
	(NULL,'Sells Manager'),
	(NULL,'Customer Relationship'),
	(NULL,'Customer Service'),
	(NULL,'Customer Case');

INSERT INTO purchase_type 
	(id,name) 
VALUES 
	(NULL,'Sample'),
	(NULL,'Full');

INSERT INTO price_type 
	(id,name) 
VALUES 
	(NULL,'Single image'),
	(NULL,'Image 200 Pack'),
	(NULL,'Layer Subscription'),
	(NULL,'Monitor Subscription');

INSERT INTO subscription_type 
	(id,name) 
VALUES 
	(NULL,'Image 200 Pack'),
	(NULL,'Layer Subscription'),
	(NULL,'Monitor Subscription');

INSERT INTO layer_type 
	(id,name) 
VALUES 
	(NULL,'Roads'),
	(NULL,'Water'),
	(NULL,'Electricity');


INSERT INTO employee_type 
	(id,name) 
VALUES 
	(NULL,'CEO'),
	(NULL,'System Admin'),
	(NULL,'Archive'),
	(NULL,'Sells Manager'),
	(NULL,'Customer Relationship'),
	(NULL,'Customer Service'),
	(NULL,'Customer Case');

INSERT INTO complaint_type 
	(id,name) 
VALUES 
	(NULL,'Missing images'),
	(NULL,'Missing layers'),
	(NULL,'System errors'),
	(NULL,'Employee'),
	(NULL,'Other');

/*
* The system clients are:
* -----------------------
* Dan A, 	050-1234567, 	dan@braude.ac.il
* Sara B, 	051-1234567, 	sara@braude.ac.il
*
* The system employees are:
* -------------------------
* Avi C, 	052-1234567, 	avi@braude.ac.il,	CEO
* Dor D, 	053-1234567, 	dor@braude.ac.il,	System Admin
* Shir E, 	054-1234567, 	shir@braude.ac.il,	Archive
* Dana F, 	055-1234567, 	dana@braude.ac.il,	Sells Manager
* Ilan G, 	056-1234567, 	ilan@braude.ac.il,	Customer Relationship
* Liat H, 	057-1234567, 	liat@braude.ac.il,	Customer Service
* Shula I, 	058-1234567, 	shula@braude.ac.il,	Customer Care
*/
INSERT INTO users 
	(username,password,permission) 
VALUES 
	('dan','dan',1),
	('sara','sara',1),
	('avi','avi',2),
	('dor','dor',3),
	('shir','shir',4),
	('dana','dana',5),
	('ilan','ilan',6),
	('liat','liat',7),
	('shula','shula',8);

INSERT INTO clients
	(id,first_name,last_name,phone,email,username)
VALUES
	(NULL,'Dan','A','050-1234567','dan@braude.ac.il','dan'),
	(NULL,'Sara','B','051-1234567','sara@braude.ac.il','sara');

INSERT INTO employees
	(id,first_name,last_name,phone,email,e_number,e_type,username)
VALUES
	(NULL,'Avi','C','052-1234567','avi@braude.ac.il','SGI001',1,'avi'),
	(NULL,'Dor','D','053-1234567','dor@braude.ac.il','SGI002',2,'dor'),
	(NULL,'Shir','E','054-1234567','shir@braude.ac.il','SGI003',3,'shir'),
	(NULL,'Dana','F','055-1234567','dana@braude.ac.il','SGI004',4,'dana'),
	(NULL,'Ilan','G','056-1234567','ilan@braude.ac.il','SGI005',5,'ilan'),
	(NULL,'Liat','H','057-1234567','liat@braude.ac.il','SGI006',6,'liat'),
	(NULL,'Shula','I','058-1234567','shula@braude.ac.il','SGI007',7,'shula');

/*
* The sytem locations are:
* ------------------------
* Israel
* Italy
* Arctic
* Egypt
*/
INSERT INTO locations
	(id,xcoord,ycoord,name)
VALUES
	(NULL,120,32,'Israel'),
	(NULL,108,27,'Italy'),
	(NULL,96,89,'Arctic'),
	(NULL,116,36,'Egypt');

/*
* System images
*/

INSERT INTO images
	(id,location,timedate,file)
VALUES
	(NULL,1,'2014-01-01 00:00:00','images/1/2014-01-01 00:00:00.jpg'),
	(NULL,1,'2014-01-02 06:00:00','images/1/2014-01-02 06:00:00.jpg'),
	(NULL,1,'2014-02-01 00:00:00','images/1/2014-02-01 00:00:00.jpg'),
	(NULL,2,'2014-01-01 00:00:00','images/2/2014-01-01 00:00:00.jpg'),
	(NULL,2,'2014-01-01 01:00:00','images/2/2014-01-01 01:00:00.jpg'),
	(NULL,2,'2014-01-01 02:00:00','images/2/2014-01-01 02:00:00.jpg'),
	(NULL,3,'2014-01-10 09:30:00','images/3/2014-01-10 09:30:00.jpg'),
	(NULL,3,'2014-02-10 00:15:00','images/3/2014-02-10 00:15:00.jpg'),
	(NULL,4,'2014-01-02 01:00:00','images/4/2014-01-02 01:00:00.jpg');
