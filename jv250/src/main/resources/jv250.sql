DROP TABLE Customer;
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


INSERT INTO Customer (name, ssn, phone) VALUES ('유비', '900001-1601111', '01012344321');
INSERT INTO Customer (name, ssn, phone) VALUES ('관우', '910001-1701111', '01023414321');

UPDATE Customer SET name='조조' WHERE name='홍길동';
DELETE FROM Customer WHERE name = '조조';