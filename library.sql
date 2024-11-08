-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2024 at 09:52 AM
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
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` varchar(5) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `password`) VALUES
('1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`author_id`, `first_name`, `last_name`) VALUES
(3, 'Michael', 'Johnson'),
(4, 'Emily', 'Davis'),
(5, 'David', 'Wilson'),
(6, 'Sarah', 'Brown'),
(7, 'James', 'Jones'),
(8, 'Emma', 'Garcia'),
(9, 'Daniel', 'Martinez'),
(10, 'Olivia', 'Hernandez'),
(11, 'Matthew', 'Lopez'),
(12, 'Sophia', 'Gonzalez'),
(13, 'Liam', 'Perez'),
(14, 'Isabella', 'Taylor'),
(15, 'Noah', 'Anderson'),
(16, 'Ava', 'Thomas'),
(17, 'Lucas', 'Moore'),
(18, 'Mia', 'Jackson'),
(19, 'Mason', 'Martin'),
(20, 'Charlotte', 'Lee'),
(21, 'Elijah', 'Walker'),
(22, 'Amelia', 'Hall'),
(23, 'Benjamin', 'Allen'),
(24, 'Harper', 'Young'),
(25, 'Alexander', 'King'),
(26, 'Evelyn', 'Wright'),
(27, 'William', 'Scott'),
(28, 'Avery', 'Green'),
(34, NULL, NULL),
(35, NULL, NULL),
(36, NULL, NULL),
(37, NULL, NULL),
(38, NULL, NULL),
(39, NULL, NULL),
(40, NULL, NULL),
(41, NULL, NULL),
(42, NULL, NULL),
(43, NULL, NULL),
(44, NULL, NULL),
(45, NULL, NULL),
(46, NULL, NULL),
(47, NULL, NULL),
(48, NULL, NULL),
(49, NULL, 'Doe'),
(50, NULL, NULL),
(51, NULL, NULL),
(52, NULL, NULL),
(53, NULL, NULL),
(54, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `published_year` int(11) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `author_id`, `title`, `isbn`, `published_year`, `genre`) VALUES
(3, 3, 'Love in the Moonlight', '978-0-14-312774-1', 2015, 'Romance'),
(4, 4, 'The Science of Everything', '978-0-307-74494-1', 2018, 'Science'),
(5, 5, 'The Darkest Hour', '978-0-7432-7350-9', 2020, 'Thriller'),
(6, 6, 'Cooking with Passion', '978-0-06-284548-8', 2019, 'Cookbook'),
(7, 7, 'A Journey Through Time', '978-0-385-53912-0', 2016, 'Historical Fiction'),
(8, 8, 'The Last Kingdom', '978-0-06-088451-3', 2008, 'Fantasy'),
(9, 9, 'Secrets of the Universe', '978-1-5011-2434-9', 2017, 'Science Fiction'),
(10, 10, 'The Art of Happiness', '978-0-385-41336-8', 2003, 'Self-Help'),
(11, 11, 'The Silent Witness', '978-1-4767-2721-7', 2014, 'Crime'),
(12, 12, 'The Lost City', '978-0-345-46838-2', 2021, 'Adventure'),
(13, 13, 'Whispers in the Wind', '978-0-452-29494-4', 2013, 'Romance'),
(14, 14, 'The Mind of a Genius', '978-1-250-07034-8', 2022, 'Biography'),
(15, 15, 'Legends of the Fall', '978-0-385-73436-6', 2007, 'Historical Fiction'),
(16, 16, 'The Enchanted Forest', '978-1-250-08061-4', 2011, 'Fantasy'),
(17, 17, 'Space Explorers', '978-0-593-19184-0', 2023, 'Science Fiction'),
(18, 18, 'Mastering the Grill', '978-0-7624-6161-4', 2020, 'Cookbook'),
(19, 19, 'The Final Countdown', '978-1-101-91282-9', 2018, 'Thriller'),
(20, 20, 'Meditation for Beginners', '978-0-394-58055-2', 2006, 'Self-Help'),
(21, 21, 'The Haunted Manor', '978-1-4447-5871-9', 2009, 'Mystery'),
(22, 22, 'Epic Tales of the Sea', '978-0-307-34671-0', 2015, 'Adventure'),
(23, 23, 'Dancing with Dreams', '978-0-099-56445-2', 2019, 'Romance'),
(24, 24, 'The Innovator\'s Dilemma', '978-1-4722-4081-2', 2010, 'Biography'),
(25, 25, 'Viking Sagas', '978-0-385-72082-7', 2021, 'Historical Fiction'),
(26, 26, 'The Mystic River', '978-0-8021-4665-1', 2004, 'Fantasy'),
(27, 27, 'Journey to Mars', '978-1-61723-135-6', 2022, 'Science Fiction'),
(28, 28, 'Gourmet Delights', '978-0-7475-6207-3', 2016, 'Cookbook'),
(32, NULL, NULL, NULL, NULL, NULL),
(33, NULL, NULL, NULL, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL),
(35, NULL, NULL, NULL, NULL, NULL),
(36, NULL, NULL, NULL, NULL, NULL),
(37, NULL, NULL, NULL, NULL, NULL),
(38, NULL, NULL, NULL, NULL, NULL),
(39, NULL, NULL, NULL, NULL, NULL),
(40, NULL, NULL, NULL, NULL, NULL),
(41, NULL, NULL, NULL, NULL, NULL),
(42, NULL, NULL, NULL, NULL, NULL),
(43, NULL, NULL, NULL, NULL, NULL),
(44, NULL, NULL, NULL, NULL, NULL),
(45, NULL, NULL, NULL, NULL, NULL),
(46, NULL, NULL, NULL, NULL, NULL),
(47, NULL, NULL, NULL, NULL, NULL),
(48, NULL, NULL, NULL, NULL, NULL),
(49, NULL, NULL, NULL, NULL, NULL),
(50, NULL, NULL, NULL, NULL, NULL),
(51, NULL, NULL, NULL, NULL, NULL),
(52, NULL, NULL, NULL, NULL, NULL),
(53, NULL, NULL, NULL, NULL, NULL),
(54, NULL, NULL, NULL, NULL, NULL),
(55, NULL, NULL, NULL, NULL, NULL),
(56, NULL, NULL, NULL, NULL, NULL),
(57, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book_transaction`
--

CREATE TABLE `book_transaction` (
  `transaction_id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_transaction`
--

INSERT INTO `book_transaction` (`transaction_id`, `book_id`, `customer_id`, `staff_id`, `issue_date`, `due_date`, `return_date`) VALUES
(6, 9, 21, 4, '2024-06-14', '2024-06-28', NULL),
(8, 19, 25, 30, '2024-08-18', '2024-09-01', NULL),
(10, 26, 11, 7, '2024-10-15', '2024-10-29', NULL),
(11, 4, 5, 22, '2024-11-01', '2024-11-15', NULL),
(12, 17, 13, 2, '2024-12-03', '2024-12-17', NULL),
(13, 12, 6, 16, '2024-01-19', '2024-02-02', NULL),
(14, 27, 17, 28, '2024-02-25', '2024-03-10', NULL),
(15, 5, 19, 9, '2024-03-18', '2024-04-01', NULL),
(16, 22, 4, 11, '2024-04-22', '2024-05-06', NULL),
(17, 15, 20, 23, '2024-05-10', '2024-05-24', NULL),
(18, 8, 24, 13, '2024-06-05', '2024-06-19', NULL),
(19, 3, 15, 5, '2024-07-02', '2024-07-16', NULL),
(20, 24, 1, 19, '2024-08-11', '2024-08-25', NULL),
(22, 11, 28, 14, '2024-10-03', '2024-10-17', NULL),
(23, 20, 7, 12, '2024-11-07', '2024-11-21', NULL),
(31, NULL, NULL, NULL, NULL, NULL, NULL),
(32, NULL, NULL, NULL, NULL, NULL, NULL),
(33, NULL, NULL, NULL, NULL, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL, NULL),
(35, NULL, NULL, NULL, NULL, NULL, NULL),
(36, NULL, NULL, NULL, NULL, NULL, NULL),
(37, NULL, NULL, NULL, NULL, NULL, NULL),
(38, NULL, NULL, NULL, NULL, NULL, NULL),
(39, NULL, NULL, NULL, NULL, NULL, NULL),
(40, NULL, NULL, NULL, NULL, NULL, NULL),
(41, NULL, NULL, NULL, NULL, NULL, NULL),
(42, NULL, NULL, NULL, NULL, NULL, NULL),
(43, NULL, NULL, NULL, NULL, NULL, NULL),
(44, NULL, NULL, NULL, NULL, NULL, NULL),
(45, NULL, NULL, NULL, NULL, NULL, NULL),
(46, NULL, NULL, NULL, NULL, NULL, NULL),
(47, NULL, NULL, NULL, NULL, NULL, NULL),
(48, NULL, NULL, NULL, NULL, NULL, NULL),
(49, NULL, NULL, NULL, NULL, NULL, NULL),
(50, NULL, NULL, NULL, NULL, NULL, NULL),
(51, NULL, NULL, NULL, NULL, NULL, NULL),
(52, NULL, NULL, NULL, NULL, NULL, NULL),
(53, NULL, NULL, NULL, NULL, NULL, NULL),
(54, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `membership_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`, `email`, `phone`, `membership_date`) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890', '2023-01-15'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '234-567-8901', '2023-02-20'),
(3, 'Michael', 'Johnson', 'michael.johnson@example.com', '345-678-9012', '2023-03-10'),
(4, 'Emily', 'Davis', 'emily.davis@example.com', '456-789-0123', '2023-04-05'),
(5, 'David', 'Wilson', 'david.wilson@example.com', '567-890-1234', '2023-05-25'),
(6, 'Sarah', 'Brown', 'sarah.brown@example.com', '678-901-2345', '2023-06-12'),
(7, 'James', 'Jones', 'james.jones@example.com', '789-012-3456', '2023-07-07'),
(8, 'Emma', 'Garcia', 'emma.garcia@example.com', '890-123-4567', '2023-08-01'),
(9, 'Daniel', 'Martinez', 'daniel.martinez@example.com', '901-234-5678', '2023-09-14'),
(10, 'Olivia', 'Hernandez', 'olivia.hernandez@example.com', '012-345-6789', '2023-10-03'),
(11, 'Matthew', 'Lopez', 'matthew.lopez@example.com', '123-456-7891', '2023-11-19'),
(12, 'Sophia', 'Gonzalez', 'sophia.gonzalez@example.com', '234-567-8902', '2023-12-28'),
(13, 'Liam', 'Perez', 'liam.perez@example.com', '345-678-9013', '2023-01-22'),
(14, 'Isabella', 'Taylor', 'isabella.taylor@example.com', '456-789-0124', '2023-02-18'),
(15, 'Noah', 'Anderson', 'noah.anderson@example.com', '567-890-1235', '2023-03-11'),
(16, 'Ava', 'Thomas', 'ava.thomas@example.com', '678-901-2346', '2023-04-29'),
(17, 'Lucas', 'Moore', 'lucas.moore@example.com', '789-012-3457', '2023-05-13'),
(18, 'Mia', 'Jackson', 'mia.jackson@example.com', '890-123-4568', '2023-06-23'),
(19, 'Mason', 'Martin', 'mason.martin@example.com', '901-234-5679', '2023-07-30'),
(20, 'Charlotte', 'Lee', 'charlotte.lee@example.com', '012-345-6790', '2023-08-18'),
(21, 'Elijah', 'Walker', 'elijah.walker@example.com', '123-456-7892', '2023-09-09'),
(22, 'Amelia', 'Hall', 'amelia.hall@example.com', '234-567-8903', '2023-10-07'),
(23, 'Benjamin', 'Allen', 'benjamin.allen@example.com', '345-678-9014', '2023-11-11'),
(24, 'Harper', 'Young', 'harper.young@example.com', '456-789-0125', '2023-12-01'),
(25, 'Alexander', 'King', 'alexander.king@example.com', '567-890-1236', '2024-01-20'),
(26, 'Evelyn', 'Wright', 'evelyn.wright@example.com', '678-901-2347', '2024-02-16'),
(27, 'William', 'Scott', 'william.scott@example.com', '789-012-3458', '2024-03-14'),
(28, 'Avery', 'Green', 'avery.green@example.com', '890-123-4569', '2024-04-06'),
(31, NULL, NULL, NULL, NULL, NULL),
(32, NULL, NULL, NULL, NULL, NULL),
(33, NULL, NULL, NULL, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL),
(35, NULL, NULL, NULL, NULL, NULL),
(36, NULL, NULL, NULL, NULL, NULL),
(37, NULL, NULL, NULL, NULL, NULL),
(38, NULL, NULL, NULL, NULL, NULL),
(39, NULL, NULL, NULL, NULL, NULL),
(40, NULL, NULL, NULL, NULL, NULL),
(41, NULL, NULL, NULL, NULL, NULL),
(42, NULL, NULL, NULL, NULL, NULL),
(43, NULL, NULL, NULL, NULL, NULL),
(44, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `first_name`, `last_name`, `email`, `phone`, `position`) VALUES
(2, 'Jane', 'Smith', 'jane.smith@example.com', '234-567-8901', 'Assistant Manager'),
(3, 'Michael', 'Johnson', 'michael.johnson@example.com', '345-678-9012', 'Analyst'),
(4, 'Emily', 'Davis', 'emily.davis@example.com', '456-789-0123', 'Clerk'),
(5, 'David', 'Wilson', 'david.wilson@example.com', '567-890-1234', 'Supervisor'),
(6, 'Sarah', 'Brown', 'sarah.brown@example.com', '678-901-2345', 'Executive'),
(7, 'James', 'Jones', 'james.jones@example.com', '789-012-3456', 'Consultant'),
(8, 'Emma', 'Garcia', 'emma.garcia@example.com', '890-123-4567', 'Coordinator'),
(9, 'Daniel', 'Martinez', 'daniel.martinez@example.com', '901-234-5678', 'Specialist'),
(10, 'Olivia', 'Hernandez', 'olivia.hernandez@example.com', '012-345-6789', 'Advisor'),
(11, 'Matthew', 'Lopez', 'matthew.lopez@example.com', '123-456-7891', 'Analyst'),
(12, 'Sophia', 'Gonzalez', 'sophia.gonzalez@example.com', '234-567-8902', 'Assistant'),
(13, 'Liam', 'Perez', 'liam.perez@example.com', '345-678-9013', 'Manager'),
(14, 'Isabella', 'Taylor', 'isabella.taylor@example.com', '456-789-0124', 'Consultant'),
(15, 'Noah', 'Anderson', 'noah.anderson@example.com', '567-890-1235', 'Supervisor'),
(16, 'Ava', 'Thomas', 'ava.thomas@example.com', '678-901-2346', 'Executive'),
(17, 'Lucas', 'Moore', 'lucas.moore@example.com', '789-012-3457', 'Analyst'),
(18, 'Mia', 'Jackson', 'mia.jackson@example.com', '890-123-4568', 'Coordinator'),
(19, 'Mason', 'Martin', 'mason.martin@example.com', '901-234-5679', 'Advisor'),
(20, 'Charlotte', 'Lee', 'charlotte.lee@example.com', '012-345-6790', 'Specialist'),
(21, 'Elijah', 'Walker', 'elijah.walker@example.com', '123-456-7892', 'Assistant'),
(22, 'Amelia', 'Hall', 'amelia.hall@example.com', '234-567-8903', 'Manager'),
(23, 'Benjamin', 'Allen', 'benjamin.allen@example.com', '345-678-9014', 'Consultant'),
(24, 'Harper', 'Young', 'harper.young@example.com', '456-789-0125', 'Supervisor'),
(25, 'Alexander', 'King', 'alexander.king@example.com', '567-890-1236', 'Executive'),
(26, 'Evelyn', 'Wright', 'evelyn.wright@example.com', '678-901-2347', 'Analyst'),
(27, 'William', 'Scott', 'william.scott@example.com', '789-012-3458', 'Coordinator'),
(28, 'Avery', 'Green', 'avery.green@example.com', '890-123-4569', 'Advisor'),
(29, 'Jacob', 'Baker', 'jacob.baker@example.com', '901-234-6780', 'Specialist'),
(30, 'Ella', 'Adams', 'ella.adams@example.com', '012-345-6791', 'Assistant'),
(33, NULL, NULL, NULL, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL),
(35, NULL, NULL, NULL, NULL, NULL),
(36, NULL, NULL, NULL, NULL, NULL),
(37, NULL, NULL, NULL, NULL, NULL),
(38, NULL, NULL, NULL, NULL, NULL),
(39, NULL, NULL, NULL, NULL, NULL),
(40, NULL, NULL, NULL, NULL, NULL),
(41, NULL, NULL, NULL, NULL, NULL),
(42, NULL, NULL, NULL, NULL, NULL),
(43, NULL, NULL, NULL, NULL, NULL),
(44, NULL, NULL, NULL, NULL, NULL),
(45, NULL, NULL, NULL, NULL, NULL),
(46, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `author_id` (`author_id`);

--
-- Indexes for table `book_transaction`
--
ALTER TABLE `book_transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `staff_id` (`staff_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `book_transaction`
--
ALTER TABLE `book_transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE CASCADE;

--
-- Constraints for table `book_transaction`
--
ALTER TABLE `book_transaction`
  ADD CONSTRAINT `book_transaction_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `book_transaction_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `book_transaction_ibfk_3` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
