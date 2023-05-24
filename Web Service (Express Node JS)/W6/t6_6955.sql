-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2023 at 06:51 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database if not exists t6_6955;
use t6_6955;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t6_6955`
--

-- --------------------------------------------------------

--
-- Table structure for table `allowed_roles`
--

CREATE TABLE `allowed_roles` (
  `text_channel_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `allowed_roles`
--

INSERT INTO `allowed_roles` (`text_channel_id`, `role_id`, `role_name`) VALUES
('SR001TC001', 'SR001RL001', 'Tes Role'),
('SR001TC001', 'SR001RL002', 'Tes Role2'),
('SR001TC002', 'SR000RL001', 'Member'),
('SR001TC003', 'SR001RL001', 'Tes Role'),
('SR001TC003', 'SR001RL002', 'Tes Role2');

-- --------------------------------------------------------

--
-- Table structure for table `ban`
--

CREATE TABLE `ban` (
  `username` varchar(255) NOT NULL,
  `ID_server` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ban`
--

INSERT INTO `ban` (`username`, `ID_server`) VALUES
('frans1', 'SR001'),
('frans2', 'SR001'),
('frans3', 'SR001');

-- --------------------------------------------------------

--
-- Table structure for table `chats`
--

CREATE TABLE `chats` (
  `username` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `text_channel_id` varchar(255) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chats`
--

INSERT INTO `chats` (`username`, `message`, `text_channel_id`, `datetime`) VALUES
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:33:47'),
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:34:01'),
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:34:17'),
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:35:15'),
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:35:52'),
('frans', 'Perempuan apa yang kuat?', 'SR001TC001', '2023-04-19 16:36:10');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_name` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `ID_server` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_name`, `role_id`, `ID_server`) VALUES
('Tes Role', 'SR001RL001', 'SR001'),
('Tes Role2', 'SR001RL002', 'SR001'),
('Tes Role3', 'SR002RL001', 'SR002');

-- --------------------------------------------------------

--
-- Table structure for table `servers`
--

CREATE TABLE `servers` (
  `ID_server` varchar(255) NOT NULL,
  `server_name` varchar(255) NOT NULL,
  `join_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `servers`
--

INSERT INTO `servers` (`ID_server`, `server_name`, `join_code`) VALUES
('SR001', 'Keluh Kesah Kuliah', 'LemFc'),
('SR002', 'Keluh Kesah Kuliah', 'Kyr3d');

-- --------------------------------------------------------

--
-- Table structure for table `text_channels`
--

CREATE TABLE `text_channels` (
  `text_channel_id` varchar(255) NOT NULL,
  `ID_server` varchar(255) NOT NULL,
  `channel_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `text_channels`
--

INSERT INTO `text_channels` (`text_channel_id`, `ID_server`, `channel_name`) VALUES
('SR001TC001', 'SR001', 'ndaktau'),
('SR001TC002', 'SR001', 'ndaktau1'),
('SR001TC003', 'SR001', 'ndaktau1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('frans', 'frans'),
('frans1', 'frans'),
('frans2', 'frans'),
('frans3', 'frans');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `username` varchar(255) NOT NULL,
  `ID_server` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`username`, `ID_server`, `role_id`, `role_name`) VALUES
('frans', 'SR001', 'SR000RL000', 'Admin'),
('frans', 'SR001', 'SR001RL002', 'Tes Role2'),
('frans', 'SR002', 'SR000RL000', 'Admin'),
('frans1', 'SR002', 'SR000RL001', 'Member'),
('frans2', 'SR002', 'SR000RL001', 'Member'),
('frans3', 'SR002', 'SR000RL001', 'Member'),
('frans2', 'SR002', 'SR002RL001', 'Tes Role3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `servers`
--
ALTER TABLE `servers`
  ADD PRIMARY KEY (`ID_server`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
