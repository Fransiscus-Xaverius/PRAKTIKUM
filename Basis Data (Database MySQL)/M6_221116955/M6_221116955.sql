--1
select tb.nama as "Nama Barang", tb.laptop as "Laptop", tb.

--2
Select m.nama as "Nama Merk", CONCAT("Rp. ",floor(avg(b.harga))) as "Harga Rata-rata"
from merk m
inner join barang b on m.id = b.id_merk
where b.harga>
(select avg(b.harga)
from barang b)
group by m.nama;
--3
Select nt.nama as "Nama Barang", nt.merk as "Merk", nt.kategori as "Kategori"
from(
select b.nama as "nama", m.nama as "merk", k.nama as "kategori"
from barang b
join merk m on b.id_merk=m.id and b.nama like "%I%"
join kategori k on k.id=b.id_kategori
) nt, barang b
where b.qty<10
group by b.nama;
--4
