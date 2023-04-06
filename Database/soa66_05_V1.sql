-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2023 at 04:57 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soa66_05`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_menu`
--

CREATE TABLE `course_menu` (
  `course_menu_id` int(11) NOT NULL,
  `course_menu_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course_menu`
--

INSERT INTO `course_menu` (`course_menu_id`, `course_menu_name`) VALUES
(1, 'All_Steak'),
(2, 'All_Fish');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `menu_description` varchar(255) NOT NULL,
  `menu_type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_description`, `menu_type_id`) VALUES
(1, 'Fish_1', 'NULL', 1),
(2, 'Fish_2', 'NULL', 1),
(3, 'Fish_3', 'NULL', 1),
(4, 'Steak_1', 'NULL', 1),
(5, 'Steak_2', 'NULL', 1),
(6, 'Steak_3', 'NULL', 1),
(7, 'SweetFish_1', 'NULL', 2),
(8, 'SweetFish_2', 'NULL', 2),
(9, 'SweetSteak_1', 'NULL', 2),
(10, 'SweetSteak_2', 'NULL', 2),
(11, 'Steak_4', 'NULL', 1);

-- --------------------------------------------------------

--
-- Table structure for table `menu_in_course`
--

CREATE TABLE `menu_in_course` (
  `menu_in_course_id` int(11) NOT NULL,
  `course_menu_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu_in_course`
--

INSERT INTO `menu_in_course` (`menu_in_course_id`, `course_menu_id`, `menu_id`) VALUES
(1, 1, 4),
(2, 1, 5),
(3, 1, 6),
(4, 1, 9),
(5, 1, 10),
(6, 2, 1),
(7, 2, 2),
(8, 2, 3),
(9, 2, 7),
(10, 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `menu_type`
--

CREATE TABLE `menu_type` (
  `menu_type_id` int(11) NOT NULL,
  `menu_type_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu_type`
--

INSERT INTO `menu_type` (`menu_type_id`, `menu_type_name`) VALUES
(1, 'Dish'),
(2, 'Sweet');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `table_restaurant_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `course_menu_id` int(11) NOT NULL,
  `reservation_date` date DEFAULT NULL,
  `reservation_timeStart` time DEFAULT NULL,
  `reservation_timeEnd` time DEFAULT NULL,
  `reservation_status` enum('CANCEL','BOOKING') DEFAULT 'BOOKING'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `table_restaurant_id`, `user_id`, `course_menu_id`, `reservation_date`, `reservation_timeStart`, `reservation_timeEnd`, `reservation_status`) VALUES
(1, 1, 2, 1, '2023-03-27', '21:00:00', '22:00:00', 'BOOKING'),
(2, 2, 1, 2, '2023-03-28', '21:30:00', '22:30:00', 'BOOKING'),
(6, 2, 1, 2, '2023-04-02', '21:45:00', '22:45:00', 'BOOKING'),
(10, 1, 11, 1, '2023-04-05', '01:00:00', '02:00:00', 'CANCEL');

-- --------------------------------------------------------

--
-- Table structure for table `table_restaurant`
--

CREATE TABLE `table_restaurant` (
  `table_restaurant_id` int(11) NOT NULL,
  `table_restaurant_code` varchar(50) NOT NULL,
  `table_restaurant_number_of_chair` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_restaurant`
--

INSERT INTO `table_restaurant` (`table_restaurant_id`, `table_restaurant_code`, `table_restaurant_number_of_chair`) VALUES
(1, 'T001', 5),
(2, 'T002', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_firstname` varchar(50) NOT NULL,
  `user_lastname` varchar(50) NOT NULL,
  `user_phonenumber` varchar(50) NOT NULL,
  `user_type` enum('USER','ADMIN') DEFAULT 'USER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_username`, `user_password`, `user_firstname`, `user_lastname`, `user_phonenumber`, `user_type`) VALUES
(1, 'artzaza7', 'artzaza12', 'Chanakan', 'Srisarutiporn', '0971566385', 'USER'),
(2, 'armzaza7', 'armzaza12', 'Kanrawee', 'Srisarutiporn', '0971566385', 'USER'),
(11, 'arm', '$2a$10$E/58.XJ.3c52ObLbRVy17uYZksYtyedZXW/PmO9Ws/HzoOF8tbSCu', 'arm', 'arm', 'arm', 'USER'),
(12, 'admin', '$2a$10$c5IShw1l3DTX92A8RmQjVuE7PuQZ1GXcDZQRdaL3T.zIId8Ehpo9m', 'admin', 'admin', 'admin', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_menu`
--
ALTER TABLE `course_menu`
  ADD PRIMARY KEY (`course_menu_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu_id`),
  ADD KEY `menu_type_id` (`menu_type_id`);

--
-- Indexes for table `menu_in_course`
--
ALTER TABLE `menu_in_course`
  ADD PRIMARY KEY (`menu_in_course_id`),
  ADD KEY `course_menu_id` (`course_menu_id`,`menu_id`),
  ADD KEY `menu_in_course_ibfk_1` (`menu_id`);

--
-- Indexes for table `menu_type`
--
ALTER TABLE `menu_type`
  ADD PRIMARY KEY (`menu_type_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `table_restaurant_id` (`table_restaurant_id`,`user_id`),
  ADD KEY `course_menu_id` (`course_menu_id`),
  ADD KEY `reservation_ibfk_1` (`user_id`);

--
-- Indexes for table `table_restaurant`
--
ALTER TABLE `table_restaurant`
  ADD PRIMARY KEY (`table_restaurant_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_menu`
--
ALTER TABLE `course_menu`
  MODIFY `course_menu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `menu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `menu_in_course`
--
ALTER TABLE `menu_in_course`
  MODIFY `menu_in_course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `menu_type`
--
ALTER TABLE `menu_type`
  MODIFY `menu_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `table_restaurant`
--
ALTER TABLE `table_restaurant`
  MODIFY `table_restaurant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`menu_type_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `menu_in_course`
--
ALTER TABLE `menu_in_course`
  ADD CONSTRAINT `menu_in_course_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `menu_in_course_ibfk_2` FOREIGN KEY (`course_menu_id`) REFERENCES `course_menu` (`course_menu_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`table_restaurant_id`) REFERENCES `table_restaurant` (`table_restaurant_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`course_menu_id`) REFERENCES `course_menu` (`course_menu_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
