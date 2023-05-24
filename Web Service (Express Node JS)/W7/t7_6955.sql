-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2023 at 12:23 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database if not exists t7_6955;
use t7_6955;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t7_6955`
--

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id_makanan` varchar(255) NOT NULL,
  `nama_makanan` varchar(255) NOT NULL,
  `deskripsi_makanan` varchar(255) NOT NULL,
  `bahan_utama` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `asal_makanan` varchar(255) NOT NULL,
  `pembuat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id_makanan`, `nama_makanan`, `deskripsi_makanan`, `bahan_utama`, `harga`, `asal_makanan`, `pembuat`) VALUES
('F001', 'anjing goreng', 'anjing digoreng', 'anjing', 10000, 'Rwanda', 'frans'),
('F002', 'tahu goreng', 'tahu digoreng minyak emas', 'emas, tahu', 20000, 'Italia', 'frans'),
('F003', 'kecoak panggang', 'kecoak yang gak sengaja masuk ke panggangan daging', 'kecoak', 30000, 'India', 'frans'),
('F004', 'Dorayaki', 'jajanan doraemon', 'ndak tau', 40000, 'Jepang', 'frans'),
('F005', 'Steak Gajah', 'Steak dari daging gajah afrika', 'Ribeye Gajah', 50000, 'Afrika', 'frans');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `saldo` int(11) NOT NULL,
  `api_hit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `name`, `password`, `token`, `saldo`, `api_hit`) VALUES
('U001', 'frans', 'fransiscus x', '123', '2tx29m9', 0, 16),
('U002', 'frans2', 'fransiscus x', '123', 'cjqWfZN', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
