Create DATABASE if not exists db_sosialmedia;
use db_sosialmedia;


--1
Create table USERS(
	KD_User VARCHAR(5) PRIMARY KEY,
	Username VARCHAR(255) NOT NULL,
	Email VARCHAR(50) UNIQUE,
	Deskripsi_Profil TEXT,
	Followers INT(11) DEFAULT 0,
	Following INT(11) DEFAULT 0,
	Status VARCHAR(1) NOT NULL
	);
	
CREATE TABLE THREADS(
	KD_Thread VARCHAR(10) PRIMARY KEY,
	Judul_Thread VARCHAR(50) NOT NULL,
	Isi_Thread Text,
	ID_User VARCHAR(5) REFERENCES USERS(KD_User),
	Tanggal_Post DATE NOT NULL
	);
	
CREATE TABLE COMMENTS(
	KD_Comment VARCHAR(5) PRIMARY KEY,
	Isi_Comment TEXT,
	FK_User VARCHAR(5) REFERENCES USERS(KD_User),
	FK_Thread VARCHAR(10) REFERENCES THREADS(KD_Thread)
	);
	
--2
ALTER TABLE THREADS 
CHANGE COLUMN ID_USER FK_USer VARCHAR(5) REFERENCES;

--3
ALTER TABLE USERS
MODIFY Status Int(1);

--4
INSERT INTO USERS VALUES('US001','Abigail_Salinas','Abi.sal@gmail.com','Seorang musisi yang ingin menggemparkan dunia',10317,5248,1);
INSERT INTO USERS VALUES('US002','SkyCarter#1','sky@gmail.com','Have a nice day',216,138,0);
INSERT INTO USERS VALUES('US003','Kane.Webster','Webster20@gmail.com','Ayam dulu apa telur dulu?',18471,1378,1);
INSERT INTO USERS VALUES('US004','Mehdihail99','Hail_mehdy99@gmail.com','',318,319,1);
INSERT INTO USERS VALUES('US005','RudyRamsey','Ramsey01@gmail.com','Hayo ngapain buka-buka profil saya?',1314,2011,0);

INSERT INTO THREADS VALUES('T010522001','Thread pertama','Halo guys, hari ini saya mau ngepost thread untuk pertama kalinya','US001','2022-05-01');
INSERT INTO THREADS VALUES('T020522001','Cara memasak','Memasak dengan minyak membuat makanan berminyak','US002','2022-05-02');
INSERT INTO THREADS VALUES('T020522002','Fun Fact','Putih adalah warna paling cerah','US001','2022-05-02');
INSERT INTO THREADS VALUES('T050522001','Quotes of the day','Kebahagiaan tidak akan datang kepada orang yang tidak pernah bersyukur','US004','2022-05-05');
INSERT INTO THREADS VALUES('T060522001','Bantu jawab PR','2 tambah 2 hasilnya berapa?','US005','2022-05-06');

INSERT INTO COMMENTS VALUES('C001','First','US002','T010522001');
INSERT INTO COMMENTS VALUES('C002','wow','US001','T020522002');
INSERT INTO COMMENTS VALUES('C003','Harus dibuktikan sendiri baru percaya','US004','T020522002');
INSERT INTO COMMENTS VALUES('C004','PP lu wibu, argumen lu ga valid','US003','T050522001');
INSERT INTO COMMENTS VALUES('C005','Jawabannya B maaf kalau salah.','US005','T060522001');

--5
DELETE FROM COMMENTS WHERE KD_COMMENT='C004';

--6
UPDATE THREADS SET Judul_Thread='PR Gua susah, bantu jawab dong' WHERE KD_Thread='T060522001';

DROP TABLE USERS;
DROP TABLE THREADS;
DROP TABLE COMMENTS;
