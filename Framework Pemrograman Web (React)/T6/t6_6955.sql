-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2023 at 08:04 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t6_6955`
--

create database if not exists t6_6955;
use t6_6955;

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `story_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stories`
--

CREATE TABLE `stories` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `poster` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stories`
--

INSERT INTO `stories` (`id`, `nama`, `poster`, `username`, `active`) VALUES
(1, 'Stopping the Golden Road', 'https://blogger.googleusercontent.com/img/a/AVvXsEhiA0jjeo_Mu4EKa4MHLbkZJlSt5L3WXSxbfJr_Oc3k_GzE6r9mRO5NYcUGQlmJAGsPOXSAZh_MPJzLW0eMbLeyNl_Z9K4agjoguAcy5sx8tUFavDOX5aybzdI7JLhDUC1Ouv9IDRRuHSlPVUqyBay6DDrP2B72pmY9IwhbT1Dr4-yFJb2_FGqkvaKEz0I=w1200-h630-p-k-', 'lolesports', 1),
(2, 'Our Road is Inevitable', 'https://pbs.twimg.com/media/F-tzxz-a8AAcdcS.jpg:large', 'lolesports', 1),
(3, 'You must not forget. All roads lead to me', 'https://pbs.twimg.com/media/F-tz2j4bYAAE8cL.jpg', 'lolesports', 1),
(4, 'PoV Dev Team Game IT-LAND', 'https://static.republika.co.id/uploads/images/headline_slide/video-gwenchana-milik-imran-bard-viral-di-media-sosial_231006151154-261.png', 'himaforstts', 1),
(5, 'PoV Timot setelah nguli asset', 'https://i.pinimg.com/originals/2e/b4/77/2eb477d666c1db8307dd21bf2f5d8a33.jpg', 'himaforstts', 1),
(6, 'PoV diminta ngajar kelas B 2022', 'https://static.republika.co.id/uploads/images/headline_slide/video-gwenchana-milik-imran-bard-viral-di-media-sosial_231006151154-261.png', 'fransiscusxaverius', 1),
(7, '\"Kamu gapapa kuliah di iSTTS?\"', 'https://static.republika.co.id/uploads/images/headline_slide/video-gwenchana-milik-imran-bard-viral-di-media-sosial_231006151154-261.png', 'fransiscusxaverius', 1),
(8, '\"p bang game e kok gak jalan\"', 'https://static.republika.co.id/uploads/images/headline_slide/video-gwenchana-milik-imran-bard-viral-di-media-sosial_231006151154-261.png', 'fransiscusxaverius', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `password`, `nama`, `username`) VALUES
('hayo@gmail.com', '123', 'Fransiscus Xaverius', 'fransiscusxaverius'),
('himafor@istts.ac.id', 'hima', 'HIMAFOR iSTTS', 'himaforstts'),
('lolesports@riotgames.com', 'lol', 'LoL Esports', 'lolesports');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stories`
--
ALTER TABLE `stories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stories`
--
ALTER TABLE `stories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
