DROP TABLE User;
CREATE TABLE User (
	uid 	 	BIGINT 		       PRIMARY KEY AUTO_INCREMENT,
	userId		VARCHAR(15)		   NOT NULL,
	passwd		VARCHAR(15)	       NOT NULL,
	name 		VARCHAR(20) 	   NOT NULL,
	ssn 	 	VARCHAR(14) 	   NOT NULL,
	email		VARCHAR(25)		   NOT NULL,
	phone 	 	VARCHAR(11) 	   NOT NULL	DEFAULT '0000000000',
	regDate  	TIMESTAMP 		   NOT NULL	DEFAULT CURRENT_TIMESTAMP

)AUTO_INCREMENT = 1001;

SELECT * FROM User;

DROP TABLE Account;
CREATE TABLE Account (
	aid				BIGINT		PRIMARY KEY AUTO_INCREMENT,
	accountNum 		VARCHAR(20) NOT NULL,
	balance 		DOUBLE 		NOT NULL	DEFAULT 0.0,
	interestRate 	DOUBLE 		NOT NULL 	DEFAULT 0.0,
	overdraft		DOUBLE 		NOT NULL 	DEFAULT 0.0,
	accountType		CHAR(1)		NOT NULL	DEFAULT 'S',
	userId			VARCHAR(15) NOT NULL,
	regDate  		TIMESTAMP   NOT NULL	DEFAULT CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;