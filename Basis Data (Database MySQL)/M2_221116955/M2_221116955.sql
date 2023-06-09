create database if not exists M2_221116955;
use M2_221116955;
	
create table USERS(
	ID int(5) PRIMARY KEY,
	KODE VARCHAR(5) NOT NULL,
	USERNAME VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	NAMA VARCHAR(100) NOT NULL,
	NO_TELP VARCHAR(12) NOT NULL,
	ULANG_TAHUN DATE NOT NULL,
	GENDER VARCHAR(1) NOT NULL CHECK (GENDER='P' OR GENDER='L'),
	EMAIL VARCHAR(100)
	);
	
CREATE TABLE SAHAM(
	ID int(5) PRIMARY KEY,
	KODE VARCHAR(6) NOT NULL,
	NAMA VARCHAR(100) NOT NULL,
	HARGA INT(15) NOT NULL CHECK(HARGA>=0),
	TIPE INT(1) NOT NULL CHECK(TIPE=0 OR TIPE=1 OR TIPE=2),
	DESKRIPSI VARCHAR(200)
	);
	
CREATE TABLE OBLIGASI(
	ID INT(5) PRIMARY KEY,
	KODE VARCHAR(6) NOT NULL,
	NAMA VARCHAR(100) NOT NULL,
	HARGA INT(15) NOT NULL CHECK (HARGA>=0),
	JATUH_TEMPO DATE NOT NULL,
	DESKRIPSI VARCHAR(200)
	);
	
CREATE TABLE H_TRANSAKSI(
	KODE_TRANS VARCHAR(5) PRIMARY KEY,
	TOTAL INT(15) NOT NULL,
	TANGGAL_TRANSAKSI DATE NOT NULL,
	METODE_BAYAR INT NOT NULL,
	ID_CUSTOMER INT(5) NOT NULL REFERENCES USERS(ID),
	KETERANGAN VARCHAR(100)
	);
	
CREATE TABLE D_TRANS(
	KODE_TRANS VARCHAR(5) NOT NULL REFERENCES H_TRANSAKSI(KODE_TRANS),
	FK_SAHAM INT(5) REFERENCES SAHAM(ID),
	FK_OBLIGASI INT(5) REFERENCES OBLIGASI(ID),
	JUMLAH INT (10) NOT NULL,
	SUBTOTAL INT(15) NOT NULL
	);
	
CREATE TABLE ADMIN(
	USERNAME VARCHAR(4) PRIMARY KEY,
	PASSWORD VARCHAR(5) NOT NULL
	);

--2
ALTER TABLE USERS 
CHANGE COLUMN ULANG_TAHUN TANGGAL_LAHIR DATE NOT NULL;
ALTER TABLE H_TRANSAKSI
CHANGE COLUMN ID_CUSTOMER ID_USER INT(5) NOT NULL;

--3
ALTER TABLE H_TRANSAKSI DROP COLUMN KETERANGAN;

--4
ALTER TABLE D_TRANS RENAME TO D_TRANSAKSI;

--5
ALTER TABLE H_TRANSAKSI ADD CONSTRAINT CHECK_METODE CHECK(METODE_BAYAR = '1' OR METODE_BAYAR = '2' OR METODE_BAYAR = '3' OR METODE_BAYAR = '4');
ALTER TABLE USERS ADD CONSTRAINT UNIQUE (EMAIL);

alter table H_TRANSAKSI add CONSTRAINT CHECK_METODE CHECK(METODE_BAYAR='1' OR METODE_BAYAR='2' OR METODE_BAYAR='3' OR METODE_BAYAR='4');


--6
DROP TABLE ADMIN;

--7
DROP TABLE D_TRANSAKSI;
DROP TABLE H_TRANSAKSI;
DROP TABLE OBLIGASI;
DROP TABLE SAHAM;
DROP TABLE USERS;
