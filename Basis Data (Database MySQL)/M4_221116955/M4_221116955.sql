--1. Sempurnakan materi
--Materi 1
SELECT CONCAT('Barang ',b.nama,' bermerk ',m.nama," memiliki kategori ", k.nama) as "DAFTAR BARANG"
FROM BARANG b, MERK m, KATEGORI k where b.qty>=10 AND b.id_merk IS NOT NULL AND m.id=b.id_merk AND k.id=b.id_kategori
order by length(b.nama), b.nama asc;

--Materi 2
--Menggunakan -1 pada line 11 karena sekarang belum bulan 6.
SELECT s.nama as "Nama Supir", CONCAT(upper(date_format(s.tanggal_lahir,"%W")),", ",
date_format(s.tanggal_lahir,"%d %M %Y")) as "Tanggal Lahir",
concat("Usia ",s.nama," adalah ",YEAR(CURDATE())-YEAR(s.tanggal_lahir)-1," tahun") as " Usia " 
FROM supir s
where month(s.tanggal_lahir)>=6
order by s.nama desc;

--Materi 3
SELECT s.nama as "Nama Supplier", 
CONCAT(count(hs.kode)," kali supply") as "Jumlah Supply",
CONCAT(sum(hs.total_qty), " barang") as "Total Barang Disupply"
FROM supplier s, h_supply hs
where hs.id_supplier = s.id
group by hs.id_supplier
order by sum(hs.total_qty) desc;

--Materi 4
SELECT lpad(hp.kode,8) as "Kode Pindah", 
asal.nama as "Asal", tujuan.nama as "Tujuan", 
date_format(hp.tanggal, "%d %M %Y") as "Tanggal Pindah",
kendaraan.nopol as "Nomor Polisi"
FROM h_pindah hp, warehouse asal, warehouse tujuan, kendaraan
where hp.asal = asal.id AND hp.tujuan = tujuan.id AND hp.id_kendaraan = kendaraan.id
order by kendaraan.nopol ASC, hp.kode DESC;

--Materi 5
SELECT CONCAT(substr(b.kode,1,2), substr(b.kode,4,6), (length(b.kode)+2)) as " Kode Barang", 
b.nama as "Nama Barang", 
concat(count(b.nama), " kali di-supply") as "Jumlah Supply"
FROM barang b, d_supply ds
where b.id = ds.id_barang
group by b.nama
order by length(b.nama), substr(b.nama,1,1), b.kode;

--2
SELECT CONCAT(s.nama, " mengantarkan ", hp.total_qty, " barang pada tanggal ", 
date_format(hp.tanggal, "%d %M %Y"), " menuju ke ", w.nama, " dengan kendaraaan ", kendaraan.nopol) as "History Perpindahan Barang"
FROM supir s, h_pindah hp, warehouse w, kendaraan
where hp.id_supir = s.id
and hp.tujuan = w.id
and hp.id_kendaraan = kendaraan.id
order by h.tanggal DESC;

--3
SELECT b.kode as "KODE", b.nama as "NAMA", b.harga as "HARGA"
FROM barang b
where locate('O', b.nama)>0
and b.harga>2500000
and b.status=1
order by length(b.nama) DESC, b.harga ASC;

--4
SELECT s.nama as "NAMA", s.telp as "TELP", s.email as "EMAIL",
CONCAT(TIMESTAMPDIFF(YEAR,S.TANGGAL_LAHIR,SYSDATE())," tahun") as "USIA"
FROM supir s
where TIMESTAMPDIFF(YEAR,S.TANGGAL_LAHIR,SYSDATE())=(SELECT min(TIMESTAMPDIFF(YEAR,S.TANGGAL_LAHIR,SYSDATE())))
order by TIMESTAMPDIFF(YEAR,S.TANGGAL_LAHIR,SYSDATE())=(SELECT min(TIMESTAMPDIFF(YEAR,S.TANGGAL_LAHIR,SYSDATE())));

--5
SELECT hp.kode as "KODE", kendaraan.nopol as "NOPOL", 
date_format(hp.tanggal, "%d-%m-%Y") as "TANGGAL PINDAH"
FROM h_pindah hp, kendaraan
where kendaraan.merk="toyota" and kendaraan.id=hp.id_kendaraan
order by substr(date_format(hp.tanggal, "%d-%m-%Y"), 1, 2) DESC;