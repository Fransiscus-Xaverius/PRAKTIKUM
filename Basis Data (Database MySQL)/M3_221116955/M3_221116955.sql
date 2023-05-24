
--no 1

--users
insert into users values(1,'U0001','emotionaldamage','inirahasia','Steven He','081756329457','1998-12-09','L','stevenh@gmail.com');
insert into users values(2,'U0002','MichaelK_0921','akkgrihd','Michael Kevin','081656907354','2001-12-25','L','michaelk@gmail.com');
insert into users values(3,'U0003','123AdiEnrico','tigkf8','Enrico Adi','081406835195','2002-12-03','L','enricoa.gmail.com');
insert into users values(4,'U0004','Chris_009900','kv6ehd9','Mikhael Chris','081650869371','2001-10-09','L','mikhaelc@yahoo.com');
insert into users values(5,'U0005','Citrabunga','ndhv7x','Bunga Citra','081650399265','1978-03-16','P','bungac@yahoo.com');
insert into users values(6,'U0006','SengAacinoM','pfu8gds','Agnes Monica','081648593022','2003-04-28','P','agnesm@gmail.com');
insert into users values(7,'U0007','inevitable99','ifv74nvu','Stefani Thanos','081650385951','1670-07-07','P','madtitan@gmail.com');
insert into users values(8,'U0008','Odin54321','jgu883hd','Thor Petir','081759937248','1209-08-15','L','asgard@gmail.com');

--saham
insert into saham values (1, 'BD0001', 'Batavia Dana Saham', 10300, 0, 'Pasti untung');
insert into saham values (2, 'AI0001', 'Avrist IDX30', 4350, 1, 'Murah banget lho');
insert into saham (id, kode, nama, harga, tipe) values (3, 'BI0001', 'BNI-AM Indeks IDX30', 6995, 1);
insert into saham values (4, 'BP0001', 'BNP Paribas Pesona', 7354, 0, 'Cuan cuan');
insert into saham (id, kode, nama, harga, tipe) values (5, 'DI0001', 'Danareksa Indeks Syariah', 15988, 2);
insert into saham (id, kode, nama, harga, tipe) values (6, 'MS0001', 'Manulife Saham Andalan', 8566, 0);

--obligasi
insert into obligasi (id, kode,nama,harga, jatuh_tempo) values (1, 'SS0001', 'Sucorinvest Stable Fund', 5900, '2023-12-01');
insert into obligasi values  (2, 'DS0001', 'Danamas Stabil', 14600, '2025-09-25', 'Kaya raya');
insert into obligasi (id, kode,nama,harga, jatuh_tempo) values (3, 'MS0001', 'Majoris Sukuk Negara Indonesia', 21375, '2024-02-17');
insert into obligasi values  (4, 'PT0001', 'Principal Total Return Bond Fund', 9840, '2029-04-18', 'Bagus banget');
insert into obligasi (id, kode,nama,harga, jatuh_tempo) values (5, 'VO0001', 'Victoria Obligasi Negara Syariah', 6750, '2030-10-11');

--h_transaksi
insert into h_transaksi values ('H0001', 105600, '2021-01-01', 1, 1);
insert into h_transaksi values ('H0002', 19680, '2021-01-01', 2, 2);
insert into h_transaksi values ('H0003', 132905, '2021-02-02', 4, 1);
insert into h_transaksi values ('H0004', 265680, '2021-04-02', 3, 3);
insert into h_transaksi values ('H0005', 35400, '2021-04-07', 1, 6);
insert into h_transaksi values ('H0006', 89745, '2021-07-08', 4, 4);
insert into h_transaksi values ('H0007', 268594, '2021-11-12', 2, 2);

--d_transaksi
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0001', 2, 3, 43800);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0001', 1, 6, 61800);
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0002', 4, 2, 19680);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0003', 3, 7, 48965);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0003', 3, 12, 83940);
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0004', 4, 4, 39360);
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0004', 4, 23, 226320);
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0005', 1, 6, 35400);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0006', 1, 8, 83400);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0006', 4, 1, 7345);
insert into d_transaksi(kode_trans, fk_obligasi, jumlah, subtotal) values('H0007', 5, 9, 60750);
insert into d_transaksi(kode_trans, fk_saham, jumlah, subtotal) values('H0007', 5, 13, 207844);

--no 2
update saham set harga = 7599 where kode = 'AI0001';

--no 3
update users set nama="Thor bin Odin" where id = 8;

--no 4
update h_transaksi set metode_bayar=1 where kode_trans='H0004';

--no 5
delete from saham where id=6;

--no 6
delete from d_transaksi where kode_trans='H0007';
