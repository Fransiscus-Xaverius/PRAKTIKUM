--1
SELECT k.nama as "Kategori Barang", 
CONCAT("Rp.",MIN(b.harga)) as "Harga Termurah",
CONCAT("Rp.",CEIL(AVG(b.harga))) as "Rata-rata Harga"
from kategori k
INNER JOIN barang b
on b.id_kategori=k.id
group by k.nama;
--2

--3
SELECT b.nama as "Nama Barang", 
ifnull(m.nama,"Tidak memiliki Merk") as "Merk Barang", 
ifnull(k.nama,"Tidak memiliki kategori") as "Kategori Barang"
from barang b
left join merk m
on m.id=b.id_merk
left join kategori k
on k.id=b.id_kategori
where b.harga<1000000
order by length (b.nama), b.harga asc;
--4

--5