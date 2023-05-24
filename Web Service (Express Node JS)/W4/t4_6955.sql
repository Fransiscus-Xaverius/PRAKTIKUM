-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2023 at 06:03 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


create database if not exists t4_6955;
use t4_6955;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t4_6955`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nama_lengkap` varchar(255) NOT NULL,
  `nomor_telepon` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `email`, `nama_lengkap`, `nomor_telepon`, `password`) VALUES
('AC001', 'x@gmail.com', 'Fransiscus X', '12345678', 'aaaaaaaa'),
('AC002', 'xb@gmail.com', 'Fransiscus X 2', '12345678', 'aaaaaaaa'),
('AC003', 'xc@gmail.com', 'Fransiscus X 3', '12345678', 'aaaaaaaa'),
('AC004', 'xd@gmail.com', 'Fransiscus X 4', '12345678', 'aaaaaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `acc_id` varchar(255) NOT NULL,
  `modul_id` varchar(255) NOT NULL,
  `total_jawaban_benar` int(11) NOT NULL,
  `skor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`acc_id`, `modul_id`, `total_jawaban_benar`, `skor`) VALUES
('AC001', 'MO002', 1, 100),
('AC001', 'MO001', 1, 100);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `id` varchar(255) NOT NULL,
  `pembuat_modul` varchar(255) NOT NULL,
  `nama_modul` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`id`, `pembuat_modul`, `nama_modul`, `password`) VALUES
('MO001', 'AC001', 'Capek banget', 'abcde'),
('MO002', 'AC002', 'Mau DO', 'abcde'),
('MO003', 'AC003', 'Ingin teriak', 'abcde'),
('MO004', 'AC004', 'Tidur selamanya', 'abcde');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` varchar(255) NOT NULL,
  `kalimat_pertanyaan` varchar(255) NOT NULL,
  `pilihan_jawaban_a` varchar(255) NOT NULL,
  `pilihan_jawaban_b` varchar(255) NOT NULL,
  `jawaban_benar` int(11) NOT NULL,
  `skor` int(11) NOT NULL,
  `id_modul` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `kalimat_pertanyaan`, `pilihan_jawaban_a`, `pilihan_jawaban_b`, `jawaban_benar`, `skor`, `id_modul`) VALUES
('QU001', 'Ya ndak tau', 'kok saya', 'kok tanya saya', 1, 100, 'MO001'),
('QU002', 'Mega', 'puan', 'wati', 1, 100, 'MO002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
