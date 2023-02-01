DROP TABLE Customer;
use jv250;
CREATE TABLE Customer (
	cid		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	name	VARCHAR(20)	NOT NULL,
	ssn		VARCHAR(14)	NOT	NULL,
	phone	VARCHAR(11)	NOT	NULL	DEFAULT	'00000000000',
	regDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

SELECT cid, name FROM Customer;
SELECT cid, name FROM Customer WHERE name='유비' AND ssn='901212-9012121';
SELECT ssn FROM Customer;


INSERT INTO Customer (name, ssn, phone) VALUES ('유비', '900001-1601111', '01012344321');
INSERT INTO Customer (name, ssn, phone) VALUES ('관우', '910001-1701111', '01023414321');
INSERT INTO Customer (name, ssn, phone) VALUES ('장비', '920001-1801111', '01023414322');

UPDATE Customer SET name='조조' WHERE name='홍길동';
DELETE FROM Customer WHERE ssn = '930001-1901111';


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

INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
	VALUES ('3690-8879', 3000.0, 0.02, 0.0, "S", 1001);
INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
	VALUES ('3691-8870', 1000.0, 0.0, 5000.0, "C", 1002);
	
SELECT a.aid, a.accountNum, a.balance, a.interestRate,
				a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate
				FROM Account AS a INNER JOIN Customer AS c ON a.customerId = c.cid
				WHERE c.ssn = "920001-1801111";
				
SELECT * FROM Account a, Customer c;

