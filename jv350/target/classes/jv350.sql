use jv350;
DROP TABLE Customer;
CREATE TABLE Customer (
	cid		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	name	VARCHAR(20)	NOT NULL,
	ssn		VARCHAR(13)	NOT	NULL	DEFAULT	'0000000000000',
	phone	VARCHAR(11)	NOT	NULL	DEFAULT	'00000000000',
	tel		VARCHAR(11)	NOT	NULL	DEFAULT	'00000000000',
	userId	VARCHAR(20)	NOT	NULL,
	passwd	VARCHAR(20)	NOT	NULL,
	email	VARCHAR(20)	NOT	NULL,
	regDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 1001;
SELECT * FROM Customer;

INSERT INTO Customer(name, ssn, phone, tel, userId, passwd, email) 
			VALUES ('유비', '8805241687722', '01023411144', '0535541144', 'Spring', 'Spring12', 'Spring123@gmail.com');

DROP TABLE Account;
CREATE TABLE Account (
	aid				BIGINT		PRIMARY KEY	AUTO_INCREMENT,
	accountNum		VARCHAR(9) 	NOT	NULL,					-- ####-####
	balance			DOUBLE		NOT NULL	DEFAULT 0.0,
	interestRate	DOUBLE		NOT NULL	DEFAULT 0.0,
	overdraft		DOUBLE		NOT NULL	DEFAULT 0.0,
	accountType		CHAR(1)		NOT NULL	DEFAULT 'S',
	customerId		BIGINT		NOT	NULL,
	regDate			TIMESTAMP	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;
SELECT * FROM Account;
