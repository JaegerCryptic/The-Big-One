-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 03, 2018 at 09:18 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `classroom_records`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL,
  `enrollment_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`attendance_id`, `enrollment_id`, `student_id`, `class_id`, `created_ts`) VALUES
(28, 53, 18, 11, '2018-12-01 11:09:39'),
(29, 56, 18, 12, '2018-12-02 03:08:56'),
(30, 57, 19, 12, '2018-12-02 03:08:56');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `topic` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `topic`, `description`, `created_ts`) VALUES
(11, 'Modern History', 'Overview of the recent past. Modern History examines and\n discusses the Modern Era.', '2018-12-01 11:06:37'),
(12, 'Ancient History', 'Discusses history from before the fall of the \nWestern Roman Empire', '2018-12-02 02:55:39'),
(13, 'Math A', 'Advanced Math', '2018-12-02 02:55:54'),
(14, 'Math B', 'Intermediate Math', '2018-12-02 02:56:08'),
(15, 'Math C', 'Average Math', '2018-12-02 02:56:21'),
(16, 'Provocational Math', 'Math for those with no recorded history of mathmatics', '2018-12-02 02:56:54'),
(17, 'English', 'Study of English', '2018-12-02 02:59:01'),
(18, 'English Communication', 'Study of English in a communicational sense', '2018-12-02 02:59:28');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `enrollment_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`enrollment_id`, `student_id`, `class_id`, `created_ts`) VALUES
(53, 18, 11, '2018-12-01 11:09:16'),
(54, 18, 11, '2018-12-02 02:53:33'),
(55, 19, 11, '2018-12-02 02:53:33'),
(56, 18, 12, '2018-12-02 03:01:02'),
(57, 19, 12, '2018-12-02 03:01:02'),
(58, 18, 14, '2018-12-02 03:01:09'),
(59, 19, 14, '2018-12-02 03:01:09'),
(60, 18, 17, '2018-12-02 03:01:20'),
(61, 19, 17, '2018-12-02 03:01:20'),
(62, 18, 18, '2018-12-02 03:05:59');

-- --------------------------------------------------------

--
-- Table structure for table `exercises`
--

CREATE TABLE `exercises` (
  `exercises_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `exercises_type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `exercises`
--

INSERT INTO `exercises` (`exercises_id`, `class_id`, `exercises_type`, `created_ts`) VALUES
(18, 11, 'Assignment', '2018-12-01 11:10:57'),
(20, 11, 'In-class Activity', '2018-12-02 03:49:14');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `grades_id` int(11) NOT NULL,
  `enrollment_id` int(11) NOT NULL,
  `exercises_id` int(11) DEFAULT NULL,
  `grade` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `score` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`grades_id`, `enrollment_id`, `exercises_id`, `grade`, `score`, `created_ts`) VALUES
(12, 53, 18, 'A', '100', '2018-12-01 11:24:59');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `first_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `dob` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `last_name`, `gender`, `dob`, `phone`, `address`, `created_ts`) VALUES
(18, 'Kylea', 'eKent', 'Female', '17-12-2018', '0475216055', '16 Taupo Court,\nCOOMBABAH\nQLD 4216', '2018-12-01 11:08:29'),
(19, 'Susan', 'Doe', 'Female', '08-12-2005', '04229419', '10 Pear Street \nArundel 4215\nQLD', '2018-12-02 02:52:24'),
(20, 'abc', 'Test3', 'Male', '11-12-2018', '1234567890', 'Pineapples', '2018-12-03 09:08:31');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `username`, `password`, `created_ts`) VALUES
(17, 'sammy', '123', '2018-12-01 05:22:31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attendance_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`enrollment_id`);

--
-- Indexes for table `exercises`
--
ALTER TABLE `exercises`
  ADD PRIMARY KEY (`exercises_id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`grades_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attendance_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `enrollment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- AUTO_INCREMENT for table `exercises`
--
ALTER TABLE `exercises`
  MODIFY `exercises_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `grades_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
