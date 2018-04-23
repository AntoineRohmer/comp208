-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 27, 2018 at 09:58 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gspdatabase`
--
CREATE DATABASE IF NOT EXISTS `gspdatabase` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gspdatabase`;

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleid` varchar(17) NOT NULL,
  `datetime` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`appointmentid`),
  KEY `vehicleid` (`vehicleid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`appointmentid`, `vehicleid`, `datetime`, `userid`) VALUES
(1, 'imanid', '2018-03-27 12:00:00', 1),
(2, 'vehicleidnumber', '2018-03-27 09:00:00', 1),
(3, 'carid', '2018-03-28 15:00:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) CHARACTER SET latin1 NOT NULL,
  `sname` varchar(30) CHARACTER SET latin1 NOT NULL,
  `email` varchar(64) CHARACTER SET latin1 NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `fname`, `sname`, `email`, `phone`) VALUES
(1, 'ryan', 'llewellyn', 'r.llewellyn@students.liverpool.ac.uk', 1234567891),
(2, 'john', 'smith', 'email@emailserver.com', 987654321);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoiceid` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleid` varchar(17) NOT NULL,
  `cost` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`invoiceid`),
  KEY `vehicleid` (`vehicleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoiceid`, `vehicleid`, `cost`, `date`) VALUES
(1, 'carid', 250.5, '2018-03-27'),
(2, 'imanid', 190.9, '2018-03-28'),
(3, 'vehicleidnumber', 89.99, '2018-03-27');

-- --------------------------------------------------------

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
CREATE TABLE IF NOT EXISTS `parts` (
  `partid` int(11) NOT NULL,
  `repairid` int(11) NOT NULL,
  `partname` varchar(50) NOT NULL,
  `supplier` varchar(30) NOT NULL,
  `dateadded` date NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`partid`),
  KEY `repairid` (`repairid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parts`
--

INSERT INTO `parts` (`partid`, `repairid`, `partname`, `supplier`, `dateadded`, `cost`) VALUES
(1, 1, 'head gasket', 'bmw oem', '2018-03-27', 251),
(2, 2, 'air filter', 'ford oem', '2018-03-27', 90),
(3, 3, 'windscreen replacement', 'audi oem', '2018-03-28', 191);

-- --------------------------------------------------------

--
-- Table structure for table `repairs`
--

DROP TABLE IF EXISTS `repairs`;
CREATE TABLE IF NOT EXISTS `repairs` (
  `repairid` int(11) NOT NULL AUTO_INCREMENT,
  `appointmentid` int(11) NOT NULL,
  `vehicleid` varchar(17) NOT NULL,
  `issue` text NOT NULL,
  `partid` int(11) NOT NULL,
  `invoiceid` int(11) NOT NULL,
  PRIMARY KEY (`repairid`),
  KEY `appointmentid` (`appointmentid`),
  KEY `vehicleid` (`vehicleid`),
  KEY `partid` (`partid`),
  KEY `invoiceid` (`invoiceid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `repairs`
--

INSERT INTO `repairs` (`repairid`, `appointmentid`, `vehicleid`, `issue`, `partid`, `invoiceid`) VALUES
(1, 1, 'imanid', 'head gasket replacement', 1, 1),
(2, 2, 'vehicleidnumber', 'air filter replacement', 2, 2),
(3, 3, 'carid', 'windscreen replacement', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(30) CHARACTER SET latin1 NOT NULL,
  `email` varchar(64) CHARACTER SET latin1 NOT NULL,
  `clearance` int(1) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`userid`, `password`, `email`, `clearance`) VALUES
(1, 'imapassword', 'r.llewellyn2@students.liverpool.ac.uk', 1),
(2, 'imanotherpassword', 'email@email.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles` (
  `vehicleid` varchar(17) NOT NULL,
  `platenumber` varchar(7) NOT NULL,
  `customerid` int(11) NOT NULL,
  `vehicletype` varchar(10) NOT NULL,
  `dateregistered` date NOT NULL,
  PRIMARY KEY (`vehicleid`),
  KEY `customerid` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`vehicleid`, `platenumber`, `customerid`, `vehicletype`, `dateregistered`) VALUES
('carid', 'hijklmn', 2, 'saloon', '2018-03-27'),
('imanid', 'abcdefg', 1, 'coupe', '2018-03-28'),
('vehicleidnumber', 'plateno', 1, 'saloon', '2018-03-27');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointment_repairs_fk` FOREIGN KEY (`appointmentid`) REFERENCES `repairs` (`appointmentid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customer_vehicle_fk` FOREIGN KEY (`customerid`) REFERENCES `vehicles` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_repairs_fk` FOREIGN KEY (`invoiceid`) REFERENCES `repairs` (`invoiceid`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `parts`
--
ALTER TABLE `parts`
  ADD CONSTRAINT `parts_repair_fk` FOREIGN KEY (`partid`) REFERENCES `repairs` (`partid`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `repairs`
--
ALTER TABLE `repairs`
  ADD CONSTRAINT `repair_parts` FOREIGN KEY (`repairid`) REFERENCES `parts` (`repairid`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_appointment_fk` FOREIGN KEY (`userid`) REFERENCES `appointments` (`userid`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicle_appointment_fk1` FOREIGN KEY (`vehicleid`) REFERENCES `appointments` (`vehicleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehicle_invoice_fk` FOREIGN KEY (`vehicleid`) REFERENCES `invoice` (`vehicleid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vehicle_repairs_fk` FOREIGN KEY (`vehicleid`) REFERENCES `repairs` (`vehicleid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
