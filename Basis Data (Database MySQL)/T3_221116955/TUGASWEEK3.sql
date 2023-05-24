create database if not exists T2_221116955;
use T2_221116955;

--membuat table.

CREATE TABLE CABANG(
	kode_cabang VARCHAR(8) PRIMARY KEY,
	notelp_cabang VARCHAR(30) NOT NULL,
	alamat_cabang VARCHAR(30) NOT NULL,
	jumlah_kamar int NOT NULL
	);
	
CREATE TABLE TAMU(
	kode_kartu_tamu VARCHAR(20) PRIMARY KEY,
	nomor_telp bigint NOT NULL,
	nomor_ktp bigint NOT NULL,
	alamat_tamu VARCHAR(30) NOT NULL,
	nama_tamu VARCHAR(30) NOT NULL
	);
	
CREATE TABLE CHECK_IN(
	kode_checkin VARCHAR(20) PRIMARY KEY,
	tanggal_checkin DATETIME NOT NULL,
	total_harga int NOT NULL,
	tanggal_checkout TIMESTAMP NOT NULL
	);
	
CREATE TABLE KAMAR(
	kode_kamar VARCHAR(15) PRIMARY KEY,
	kelas_kamar VARCHAR(10) NOT NULL,
	status_kamar BOOLEAN NOT NULL,
	hargapermalam int NOT NULL CHECK(HARGAPERMALAM>0)
	);
	
CREATE TABLE LAYANAN_HOTEL(
	kode_layanan VARCHAR(10) PRIMARY KEY,
	lama_layanan TIME NOT NULL,
	harga_layanan int NOT NULL CHECK(HARGA_LAYANAN>0),
	jenis_layanan VARCHAR(15) NOT NULL
	);
	
CREATE TABLE FASILITAS(
	kode_fasilitas VARCHAR(10) PRIMARY KEY,
	tipe_fasilitas VARCHAR(10) NOT NULL,
	kapasitas_fasilitas INT CHECK(kapasitas_fasilitas>0),
	jam_operasional TIME NOT NULL
	);
	
CREATE TABLE PEGAWAI(
	kode_pegawai VARCHAR(10) PRIMARY KEY,
	nama_pegawai VARCHAR(30) NOT NULL,
	no_telp_pegawai BIGINT NOT NULL,
	posisi_pegawai VARCHAR(15) NOT NULL
	);
	
CREATE TABLE SUPERVISOR(
	kd_supervisor VARCHAR(10) PRIMARY KEY,
	nama_supervisor VARCHAR(20) NOT NULL,
	notelp_supervisor BIGINT NOT NULL,
	alamat_supervisor VARCHAR(30) NOT NULL
	);
	
--create H_TRANS dan D_Trans disertai dengan pembuatan Constraint Foreign key

CREATE TABLE H_TRANS(
	kode_transaksi VARCHAR(20) PRIMARY KEY,
	tanggal DATE REFERENCES CHECK_IN(tanggal_checkin),
	total INTEGER REFERENCES CHECK_IN(total_harga),
	kamar VARCHAR(15) REFERENCES KAMAR(kode_kamar)
	);
	
CREATE TABLE D_TRANS(
	kode_trans VARCHAR(20) REFERENCES H_TRANS(kode_transaksi),
	tanggal_trans DATE REFERENCES H_TRANS(tanggal),
	tanggal_checkout TIMESTAMP REFERENCES CHECK_IN(tanggal_checkout),
	id_kamar VARCHAR(15) REFERENCES H_TRANS(kamar),
	id_kartu VARCHAR(20) REFERENCES TAMU(kode_kartu_tamu),
	subtotal INTEGER NOT NULL
	);
	
--Mengganti nama tabel pada 2 tabel.

alter table SUPERVISOR rename to MANAGER;
alter table PEGAWAI rename to WORKER;

--Menambah field pada 3 tabel

alter table MANAGER add JENIS_KELAMIN VARCHAR(1);
alter table WORKER add JENIS_KELAMIN VARCHAR(1);
alter table TAMU add GENDER VARCHAR(1);

--menambah constraint pada 2 tabel
--sedikit note, pada alter kali ini digunakan nama "MANAGER" karena terjadi
--rename sebelumnya. (cek line 80)

alter table MANAGER add CONSTRAINT UNIQUE (notelp_supervisor);
alter table CABANG add CONSTRAINT UNIQUE (notelp_cabang);

--memasukkan 7 data pada setiap table
insert into cabang values ('CB000001','0317000001','Jl. KurasaTakada no. 1',250);
insert into cabang values ('CB000002','0317000002','Jl. Menghilang no. 2',140);
insert into cabang values ('CB000003','0317000003','Jl. Dimana no. 3',350);
insert into cabang values ('CB000004','0317000004','Jl. Hilang no. 4',420);
insert into cabang values ('CB000005','0317000005','Jl. KEQING no. 420',696);
insert into cabang values ('CB000006','0317000006','Jl. Tatang Sudrajat no. 69',666);
insert into cabang values ('CB000007','0317000007','Jl. Namanya apa no. 10',777);

insert into tamu values ('TAMU0001',6287823943,324123143,'Jl. Ngagel no. 27','Yusuke Urameshi','L');
insert into tamu values ('TAMU0002',6287942314,124123523,'Jl. Teyvat no. 69','Lisa','P');
insert into tamu values ('TAMU0003',6287820456,123334170,'Jl. Liyue no. 727','Xingqiu','L');
insert into tamu values ('TAMU0004',6287823946,123254144,'Jl. Liyue no. 666','Xiangling','P');
insert into tamu values ('TAMU0005',6287821234,134198240,'Jl. Langit Liyue no. 0','Ningguang','P');
insert into tamu values ('TAMU0006',6287823942,123324373,'Jl. Cash or Duel no. 1','Ryuguji Ken','L');
insert into tamu values ('TAMU0007',6287841943,331468970,'Jl. Pripayer no. 27','DioniSUS MikSUS','L');

insert into check_in values ('CHI00001','2022-01-01',11500000,'2028-01-19 03:14:07');
insert into check_in values ('CHI00002','2022-01-02',10000000,'2030-01-19 01:14:07');
insert into check_in values ('CHI00003','2022-01-03',1150000,'2022-01-19 03:00:00');
insert into check_in values ('CHI00004','2022-01-04',500000,'2023-01-19 12:14:00');
insert into check_in values ('CHI00005','2022-01-05',1100000,'2025-01-19 13:30:00');
insert into check_in values ('CHI00006','2022-01-06',115000,'2022-01-19 10:45:00');
insert into check_in values ('CHI00007','2022-01-07',70000000,'2038-01-19 02:14:00');

insert into kamar values ('KAMAR0001','KING',0,750000);
insert into kamar values ('KAMAR0002','QUEEN',0,650000);
insert into kamar values ('KAMAR0003','PRINCE',0,550000);
insert into kamar values ('KAMAR0004','ROYALTY',0,450000);
insert into kamar values ('KAMAR0005','BUSINESS',0,350000);
insert into kamar values ('KAMAR0006','COMMON',0,250000);
insert into kamar values ('KAMAR0007','PEASANT',0,150000);

insert into layanan_hotel values ('LAYANAN001','01:15:00',150000,'ROOM SERVICE');
insert into layanan_hotel values ('LAYANAN002','02:30:00',350000,'ROOM SERVICE');
insert into layanan_hotel values ('LAYANAN003','03:45:00',750000,'ROOM SERVICE');
insert into layanan_hotel values ('LAYANAN004','04:00:00',50000,'CLEANING');
insert into layanan_hotel values ('LAYANAN005','05:15:00',100000,'RELAXATION');
insert into layanan_hotel values ('LAYANAN006','06:30:00',50000,'LAUNDRY');
insert into layanan_hotel values ('LAYANAN007','07:45:00',350000,'EXTRA');

insert into fasilitas values ('FAS0001','RELAXATION',20,'04:00:00');
insert into fasilitas values ('FAS0002','ENTERTAIN',50,'23:30:00');
insert into fasilitas values ('FAS0003','RECREATION',30,'09:15:00');
insert into fasilitas values ('FAS0004','RELAXATION',20,'12:00:00');
insert into fasilitas values ('FAS0005','ENTERTAIN',40,'18:00:00');
insert into fasilitas values ('FAS0006','ENTERTAIN',30,'10:00:00');
insert into fasilitas values ('FAS0007','RELAXATION',25,'09:30:00');

insert into worker values ('WORKER001','Dio Brando',62851943045,'SUPERVISOR','L');
insert into worker values ('WORKER002','Jotaro Kujo',62898843045,'HEAD CHEF','L');
insert into worker values ('WORKER003','Ayanami Rei',62851989845,'SUPERVISOR','P');
insert into worker values ('WORKER004','Scarlet Erza',62851932345,'FRONT ADMIN','P');
insert into worker values ('WORKER005','Yukihira Soma',62823943045,'CHEF','L');
insert into worker values ('WORKER006','Rem',62857393045,'JANITOR','P');
insert into worker values ('WORKER007','Fukuzou Moguro',62871180045,'HEAD OF SALES','L');

insert into manager values ('SUPER0001','Daniel Christanto',628524342352,'Jl. Dead no.28','L');
insert into manager values ('SUPER0002','Felicia Pangestu',628521234352,'Jl. Hadeh no.28','L');
insert into manager values ('SUPER0003','Michael Andrew',6282213234352,'Jl. Mental no.28','L');
insert into manager values ('SUPER0004','Mikhael Chris',6285243422352,'Jl. Lort no.28','L');
insert into manager values ('SUPER0005','Mikhael Lukas',6285243427352,'Jl. Pusing no.28','L');
insert into manager values ('SUPER0006','uvuvwevwevwe',6285247342352,'Jl. Mboh no.28','L');
insert into manager values ('SUPER0007','ugwemuhwem osas',628124342352,'Jl. DO no.28','L');

insert into h_trans values ('TR00001','2022-01-01',10000000,'KAMAR0001');
insert into h_trans values ('TR00002','2022-01-02',1150000,'KAMAR0002');
insert into h_trans values ('TR00003','2022-01-03',70000000,'KAMAR0003');
insert into h_trans values ('TR00004','2022-01-04',500000,'KAMAR0004');
insert into h_trans values ('TR00005','2022-01-05',115000,'KAMAR0005');
insert into h_trans values ('TR00006','2022-01-06',1100000,'KAMAR0006');
insert into h_trans values ('TR00007','2022-01-07',11500000,'KAMAR0007');

insert into d_trans values ('TR00001','2022-01-01','2028-01-19 03:14:07','TR00001','TAMU0001',1500000);
insert into d_trans values ('TR00002','2022-01-02','2030-01-19 01:14:07','TR00002','TAMU0002',175000);
insert into d_trans values ('TR00003','2022-01-03','2022-01-19 03:00:00','TR00003','TAMU0003',1650000);
insert into d_trans values ('TR00004','2022-01-04','2023-01-19 12:14:00','TR00004','TAMU0004',725000);
insert into d_trans values ('TR00005','2022-01-05','2025-01-19 13:30:00','TR00005','TAMU0005',11500000);
insert into d_trans values ('TR00006','2022-01-06','2022-01-19 10:45:00','TR00006','TAMU0006',10000000);
insert into d_trans values ('TR00007','2022-01-07','2038-01-19 02:14:00','TR00007','TAMU0007',13000000);

--update 5 data
update manager set jenis_kelamin = 'P' where nama_supervisor = 'Felicia Pangestu';
update manager set alamat_supervisor = 'Jl. Jurang Semeru' where nama_supervisor = 'Daniel Christanto';
update d_trans set subtotal = 1000000 where kode_trans = 'TR00001';
update cabang set notelp_cabang = 123 where kode_cabang = 'CB000001';
update kamar set kelas_kamar = 'KISMIN' where kode_kamar = 'KAMAR0007';

--delete 5 data
delete from d_trans where kode_trans = 'TR00001';
delete from d_trans where kode_trans = 'TR00002';
delete from h_trans where kode_transaksi = 'TR00001';
delete from h_trans where kode_transaksi = 'TR00002';
delete from manager where nama_supervisor = 'DAniel Christanto';

--drop tabel

drop table MANAGER;
drop table CABANG;
drop table CHECK_IN;
drop table D_TRANS;
drop table FASILITAS;
drop table H_TRANS;
drop table KAMAR;
drop table LAYANAN_HOTEL;
drop table TAMU;
drop table WORKER;
	
