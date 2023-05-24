

-2 
select hp.kode as "KODE",
CONCAT(DAYNAME(hp.tanggal),", ",DAY(hp.tanggal)," ",MONTHNAME(hp.tanggal)," ",YEAR(hp.tanggal)) as "Tanggal Berangkat",
CONCAT(
		CONCAT('[HP] ',SUBSTR(s.telp,1,3),"-",SUBSTR(s.telp,4,3),"-",substr(s.telp,7,4)," / [",
		UPPER(SUBSTR(s.email,(POSITION("@" in s.email)+1),5)),"] ",s.email)
	) as "Kontak Supir"
from h_pindah hp
INNER JOIN d_pindah dp
ON hp.kode=dp.kode and hp.status=0
INNER JOIN supir s
on hp.id_supir = s.id
group by hp.kode
order by s.email asc;
-3
select CONCAT("Manager ",m.nama," memiliki bawahan sebanyak ", count(k.id_manager)," karyawan") as "Data Manager"
from manager m
left join karyawan k
on m.id=k.id_manager
group by m.id
order by count(k.id_manager) desc;

-4
select CONCAT("[0",k.id,"] ",RPAD(k.merk, 14, " "),RPAD(CONCAT("< ",k.nopol," >"),15," "),RPAD(CONCAT(RPAD(" ",count(hp.id_kendaraan)+1,"="),">"),7," "),ifnull(sum(hp.total_qty),"Belum pernah mengantar")," barang") as "History Pengantaran Kendaraan"
from kendaraan k
left join h_pindah hp
on k.id=hp.id_kendaraan
group by k.id
order by count(hp.total_qty) desc;

-5
select hp.kode as "Kode", s.nama as "Nama Supir", 
CONCAT(SUBSTR(s.telp,1,3),"-",SUBSTR(s.telp,4,3),"-", substr(s.telp,7,4)) as "Kontak Supir",
CONCAT(RPAD(CONCAT("[",k.nopol,"]"),12," "), k.merk) as "Kendaraan",
w.alamat as "Alamat Tujuan",
CONCAT(DAYNAME(hp.tanggal),", ",DAY(hp.tanggal)," ",MONTHNAME(hp.tanggal)," ",YEAR(hp.tanggal)) as "Tanggal Berangkat",
CONCAT(DAYNAME(DATE_ADD(DATE_ADD(hp.tanggal, INTERVAL 15 DAY), INTERVAL 1 MONTH)),", ",DAY(DATE_ADD(DATE_ADD(hp.tanggal, INTERVAL 15 DAY), INTERVAL 1 MONTH))," ",
MONTHNAME(DATE_ADD(DATE_ADD(hp.tanggal, INTERVAL 15 DAY), INTERVAL 1 MONTH))," ",YEAR(DATE_ADD(DATE_ADD(hp.tanggal, INTERVAL 15 DAY), INTERVAL 1 MONTH))) as "Perkiraan Sampai"
from h_pindah hp
inner join supir s
on hp.tanggal>'2021-05-30' and hp.id_supir=s.id
inner join kendaraan k
on hp.id_kendaraan=k.id
inner join warehouse w
on w.id=hp.tujuan
group by hp.kode
order by w.alamat asc, LENGTH(k.merk) desc, DAY(hp.tanggal) asc;