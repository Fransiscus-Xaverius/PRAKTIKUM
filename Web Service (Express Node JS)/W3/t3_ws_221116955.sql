-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2023 at 05:21 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database if not exists t3_ws_221116955;
use t3_ws_221116955;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t3_ws_221116955`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendees`
--

CREATE TABLE `attendees` (
  `id_user` varchar(128) NOT NULL,
  `id_event` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendees`
--

INSERT INTO `attendees` (`id_user`, `id_event`) VALUES
('EX00001', 'EV00001'),
('EX00001', 'EV00002'),
('EX00001', 'EV00003'),
('EX00001', 'EV00004');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id_event` varchar(128) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `deskripsi` varchar(256) NOT NULL,
  `lokasi` varchar(256) NOT NULL,
  `tanggal` varchar(128) NOT NULL,
  `id_user` varchar(128) NOT NULL,
  `createdAt` varchar(128) NOT NULL,
  `updatedAt` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id_event`, `nama`, `deskripsi`, `lokasi`, `tanggal`, `id_user`, `createdAt`, `updatedAt`) VALUES
('EV00001', 'Seminar KSP Ep. 1', 'Ndak tau sih gabut', 'DIdepan Rumah mu', '10/03/2023', 'EX00002', '2023-03-15 12:13:33', '2023-03-15 12:13:33'),
('EV00002', 'Seminar KSP Ep. 1', 'Ndak tau sih gabut', 'DIdepan Rumah mu', '10/03/2023', 'EX00002', '2023-03-15 12:14:09', '2023-03-15 12:14:09'),
('EV00003', 'Seminar KSP Ep. 1', 'Ndak tau sih gabut', 'DIdepan Rumah mu', '10/03/2023', 'EX00002', '2023-03-15 12:14:10', '2023-03-15 12:14:10'),
('EV00004', 'Event capek pengen gila', 'kalau ndak bisa yasudahlah ya', 'pinggir jalan', '01/01/2024', 'EX00002', '2023-03-15 14:37:36', '2023-03-15 16:12:51'),
('EV00005', 'Event Wibu', 'Ndak tau sih gabut', 'Di taman', '10/03/2023', 'EX00002', '2023-03-15 14:38:14', '2023-03-15 14:38:14'),
('EV00006', 'Event capek pengen gila', 'Mau nangis speedrun sehari', 'Di taman', '10/03/2042', 'EX00002', '2023-03-15 15:58:46', '2023-03-15 16:08:49'),
('EV00007', 'Event capek pengen gila', 'kalau ndak bisa yasudahlah', 'pinggir jalan', '01/01/2024', 'EX00002', '2023-03-15 16:11:44', '2023-03-15 16:12:23');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` varchar(128) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `nomor_HP` varchar(128) NOT NULL,
  `jenis_kelamin` varchar(16) NOT NULL,
  `email` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `password`, `nomor_HP`, `jenis_kelamin`, `email`) VALUES
('EX00001', 'Gloria Eun Musa', 'cobalagi', '0811111111', 'P', 'xaaaav@gmail.com'),
('EX00002', 'Gloria Eun Musa', 'cobalagi', '0811111111', 'P', 'xv@gmail.com'),
('EX00003', 'Gloria Eun Musa', 'cobalagi', '0811111111', 'P', 'xva@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendees`
--
ALTER TABLE `attendees`
  ADD KEY `id_event` (`id_event`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendees`
--
ALTER TABLE `attendees`
  ADD CONSTRAINT `attendees_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `events` (`id_event`),
  ADD CONSTRAINT `attendees_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
