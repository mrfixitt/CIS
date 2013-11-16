-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 01, 2013 at 10:14 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `user_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `username_pw`
--

CREATE TABLE IF NOT EXISTS `username_pw` (
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `SESSION_ID` varchar(40) DEFAULT NULL,
  `isInstructor` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `username_pw`
--

INSERT INTO `username_pw` (`username`, `password`, `SESSION_ID`, `isInstructor`) VALUES
('username3', '1119cfd37ee247357e034a08d844eea25f6fd20f', 'nmidsdvp63r9arcj98j7adhtf1', 0),
('username4', 'a1d7584daaca4738d499ad7082886b01117275d8', 'k1d2fgbnb93deaocj4ltvvvbi2', 0),
('username5', 'edba955d0ea15fdef4f61726ef97e5af507430c0', 'nmidsdvp63r9arcj98j7adhtf1', 0),
('username8', 'a8dbbfa41cec833f8dd42be4d1fa9a13142c85c2', NULL, 0),
('username9', '024b01916e3eaec66a2c4b6fc587b1705f1a6fc8', NULL, 0),
('username10', 'f68ec41cde16f6b806d7b04c705766b7318fbb1d', NULL, 0),
('username13', 'd505832286e2c1d2839f394de89b3af8dc3f8c1f', NULL, 0),
('username40', '68617a33df2ea41a0a835ac878e0d2065e238da8', NULL, 0),
('username80', '265657489b09e33afca0ebf493103ad39e14f471', NULL, 0),
('username1', 'e38ad214943daad1d64c102faec29de4afe9da3d', 'k1d2fgbnb93deaocj4ltvvvbi2', 0),
('teacher2', '2aa60a8ff7fcd473d321e0146afd9e26df395147', NULL, 1),
('teacher1', 'e38ad214943daad1d64c102faec29de4afe9da3d', 'nmidsdvp63r9arcj98j7adhtf1', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
