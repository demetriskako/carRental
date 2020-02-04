-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2020 at 04:34 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crebas`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `CITY_ID` varchar(30) NOT NULL,
  `CITY_NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`CITY_ID`, `CITY_NAME`) VALUES
('1', 'Athens');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `CLIENT_ID` varchar(50) NOT NULL,
  `CLIENT_NAME` varchar(50) NOT NULL,
  `CLIENT_SURNAME` varchar(50) NOT NULL,
  `CLIENT_DRIVING_LICENSE` varchar(20) NOT NULL,
  `CLIENT_ADDRESS` varchar(50) NOT NULL,
  `CLIENT_EMAIL` varchar(50) NOT NULL,
  `CLIENT_TELEPHONE_NO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`CLIENT_ID`, `CLIENT_NAME`, `CLIENT_SURNAME`, `CLIENT_DRIVING_LICENSE`, `CLIENT_ADDRESS`, `CLIENT_EMAIL`, `CLIENT_TELEPHONE_NO`) VALUES
('3453452345', 'Colleen Noble', 'Sampson', 'zkb4567', '+1 (104) 478-3822', 'syqajiw@mailinator.net', 'Dolores corporis vol');

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `RENTAL_ID` int(50) NOT NULL,
  `VEHICLE_LICENCE_NO` varchar(10) NOT NULL,
  `CLIENT_ID` varchar(50) NOT NULL,
  `RENTAL_PICKUP_LOCATION` varchar(50) NOT NULL,
  `RENTAL_PICKUP_DATETIME` datetime NOT NULL,
  `RENTAL_RETURN_LOCATION` varchar(50) NOT NULL,
  `RENTAL_RETURN_DATETIME` datetime NOT NULL,
  `RENTAL_TOTAL_COST` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rental`
--

INSERT INTO `rental` (`RENTAL_ID`, `VEHICLE_LICENCE_NO`, `CLIENT_ID`, `RENTAL_PICKUP_LOCATION`, `RENTAL_PICKUP_DATETIME`, `RENTAL_RETURN_LOCATION`, `RENTAL_RETURN_DATETIME`, `RENTAL_TOTAL_COST`) VALUES
(27, 'zkb4567', '3453452345', '1', '2020-02-04 17:00:00', '1', '2020-02-04 17:00:00', 0),
(28, '881', '3453452345', '1', '2020-02-08 17:32:00', '1', '2020-02-29 17:31:00', 1300);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `STORE_ID` varchar(30) NOT NULL,
  `CITY_ID` varchar(30) NOT NULL,
  `STORE_NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`STORE_ID`, `CITY_ID`, `STORE_NAME`) VALUES
('1', '1', 'Athens Store');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `VEHICLE_LICENCE_NO` varchar(10) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `STORE_ID` varchar(30) NOT NULL,
  `VEHICLE_MODEL` varchar(30) NOT NULL,
  `VEHICLE_CAPACITY` varchar(20) NOT NULL,
  `VEHICLE_FUEL` varchar(20) NOT NULL,
  `VEHICLE_TYPE` varchar(50) NOT NULL,
  `VEHICLE_RENTAL_COST` int(11) NOT NULL,
  `VEHICLE_SEAT_HEIGHT` int(11) DEFAULT NULL,
  `VEHICLE_LUGGAGE_SUPPORT` varchar(50) DEFAULT NULL,
  `VEHICLE_DOOR_NUMBER` int(11) DEFAULT NULL,
  `VEHICLE_SEAT_NO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`VEHICLE_LICENCE_NO`, `TYPE`, `STORE_ID`, `VEHICLE_MODEL`, `VEHICLE_CAPACITY`, `VEHICLE_FUEL`, `VEHICLE_TYPE`, `VEHICLE_RENTAL_COST`, `VEHICLE_SEAT_HEIGHT`, `VEHICLE_LUGGAGE_SUPPORT`, `VEHICLE_DOOR_NUMBER`, `VEHICLE_SEAT_NO`) VALUES
('881', 'Car', '1', 'allalala', '1', 'Petrol', 'Big Car', 51, NULL, NULL, 56, 94),
('zkb4567', 'Car', '1', 'Yaris', '2.7', 'Gas', 'Big Car', 10, NULL, NULL, 4, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`CITY_ID`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`CLIENT_ID`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`RENTAL_ID`),
  ADD KEY `FK_PERFORMS` (`CLIENT_ID`),
  ADD KEY `FKj77c36pieys2yos3qy3uteoxb` (`VEHICLE_LICENCE_NO`),
  ADD KEY `FKo66jagmc5h4qjcfgyuierm93o` (`RENTAL_RETURN_LOCATION`),
  ADD KEY `FKdvepi18t349jhd0x9p9m6fkwt` (`RENTAL_PICKUP_LOCATION`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`STORE_ID`),
  ADD KEY `FK_HAS` (`CITY_ID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`VEHICLE_LICENCE_NO`),
  ADD KEY `FK_OWNS` (`STORE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `RENTAL_ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `FK_APPEARS` FOREIGN KEY (`VEHICLE_LICENCE_NO`) REFERENCES `vehicle` (`VEHICLE_LICENCE_NO`),
  ADD CONSTRAINT `FK_PERFORMS` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`),
  ADD CONSTRAINT `FKdvepi18t349jhd0x9p9m6fkwt` FOREIGN KEY (`RENTAL_PICKUP_LOCATION`) REFERENCES `store` (`STORE_ID`),
  ADD CONSTRAINT `FKj77c36pieys2yos3qy3uteoxb` FOREIGN KEY (`VEHICLE_LICENCE_NO`) REFERENCES `vehicle` (`VEHICLE_LICENCE_NO`),
  ADD CONSTRAINT `FKo66jagmc5h4qjcfgyuierm93o` FOREIGN KEY (`RENTAL_RETURN_LOCATION`) REFERENCES `store` (`STORE_ID`);

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `FK_HAS` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`CITY_ID`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `FK_OWNS` FOREIGN KEY (`STORE_ID`) REFERENCES `store` (`STORE_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
