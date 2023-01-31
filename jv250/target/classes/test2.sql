CREATE TABLE Customer(
  	cid			BIGINT		PRIMARY KEY AUTO_INCREMENT
, 	name		VARCHAR(20)	NOT	NULL
, 	ssn			VARCHAR(14)	NOT	NULL	DEFAULT	'000000-0000000'
, 	regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP
) 	AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

CREATE TABLE Account (
	aid					BIGINT		PRIMARY KEY	AUTO_INCREMENT
,	accType				CHAR(1)		NOT NULL	DEFAULT 'C'
,	balance				DOUBLE		NOT NULL	DEFAULT 0.0
,	interestRate		DOUBLE		NOT NULL	DEFAULT 0.0
,	overdraftAmount		DOUBLE		NOT NULL	DEFAULT 0.0
,	customerId			BIGINT		NOT	NULL
,	regDate				TIMESTAMP	NOT NULL	DEFAULT	CURRENT_TIMESTAMP
	
,	CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid)
) 	AUTO_INCREMENT = 3001;

SELECT * FROM Account;

INSERT INTO Customer (name, ssn) VALUES ('James Bond', '900101-1234567');

INSERT INTO	Account (accType, balance, interestRate, overdraftAmount, customerId) 
	VALUES ('C', 2000.0, 0.03, 0.0, 1001);
	
UPDATE Customer SET name = 'Jason Bourne' WHERE name = 'James Bond' AND cid = 1002;

DELETE FROM Customer WHERE cid = 1002;

SELECT accType, balance FROM Account WHERE accType = 'C' AND balance = 2000.0;


