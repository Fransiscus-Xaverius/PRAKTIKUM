-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2022 at 05:20 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t7_6955`
--

CREATE DATABASE IF NOT EXISTS T7_6955;

USE T7_6955;

-- --------------------------------------------------------

--
-- Table structure for table `dtrans`
--

CREATE TABLE `dtrans` (
  `dtrans_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `htrans_id` varchar(128) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `dtrans_subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `htrans`
--

CREATE TABLE `htrans` (
  `htrans_id` varchar(255) NOT NULL,
  `htrans_date` date NOT NULL,
  `htrans_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `nama_menu` varchar(128) NOT NULL,
  `deskripsi` varchar(256) NOT NULL,
  `harga` int(11) NOT NULL,
  `img` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `nama_menu`, `deskripsi`, `harga`, `img`) VALUES
(1, 'Burger', 'burger ini bro masa ga pernah liat', 25000, 'img_01'),
(2, 'nasi goreng', 'nasi goreng ini bro, masa gak pernah liat.', 30000, 'img_02'),
(3, 'pizza', 'pizza ini bro, masa gak pernah liat.', 50000, 'img_03'),
(4, 'Ayam Goreng', 'Ayam goreng ini bro, masa gak pernah liat.', 20000, 'img_04'),
(5, 'Kebab', 'Kebab ini bro, masa gak pernah liat.', 30000, 'img_05'),
(6, 'Es Krim', 'Es Krim biasa, gak lebih gak kurang.', 20000, 'img_06'),
(7, 'Es Teh', 'Es Teh biasa, gak lebih gak kurang.', 5000, 'img_07'),
(8, 'Es Cao', 'Es Cao biasa, gak lebih gak kurang.', 7000, 'img_08'),
(9, 'Babi Guling', 'Babi diguling biasa, dimasak, disajikan seperti makanan', 70000, 'img_09'),
(10, 'Ayam Bakar', 'Ayam dibakar dengan api yang membara, seperti cintaku yang tidak terbalaskan.', 25000, 'img_10'),
(11, 'Nasi Bakar', 'nasi bakar bro, saya sih ndak pernah coba tapi yaudahlah ya', 20000, 'img_11'),
(12, 'Rendang', 'Rendang bro, saya sih ndak pernah coba tapi yaudahlah ya', 60000, 'img_12'),
(13, 'Rawon Merah', 'Rawon, Kuahnya pake sambel tapi, kebetulan saya jual sendiri :v', 50000, 'img_13'),
(14, 'Sop Buntut', 'Sop daging ekor sapi, kebetulan saya juga jual :v', 75000, 'img_14'),
(15, 'Mie Ayam', 'Mie ayam, didepan kampus ada, kesukaan abang Dunstan', 12000, 'img_15'),
(16, 'Mie Babi', 'Mie Babi enak bergizi dan halal', 30000, 'img_16'),
(17, 'Nasi Kucing', 'Beli nasi sekalian bonus peliharaan/majikan baru', 20000, 'img_17'),
(18, 'Nasi Goreng Cap Pusing Kepala', 'HAIYAAAAAAAAAAAAAAAAAAA YOU MAKE MY ANCESTOR CRY', 35000, 'img_18'),
(19, 'Pisang Goreng ', 'Pisang digoreng dah gitu aja. Saya juga jual.', 12000, 'img_19'),
(20, 'Sate Ayam', 'Daging ayam ditusuk sama tusuk kayu, dibakar dah gitu aja. Saya juga jual.', 30000, 'img_20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD PRIMARY KEY (`dtrans_id`),
  ADD KEY `htrans_id` (`htrans_id`),
  ADD KEY `dtrans_ibfk_1` (`menu_id`);

--
-- Indexes for table `htrans`
--
ALTER TABLE `htrans`
  ADD PRIMARY KEY (`htrans_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dtrans`
--
ALTER TABLE `dtrans`
  MODIFY `dtrans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD CONSTRAINT `dtrans_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
