-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: payments
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `sequenceId` int NOT NULL,
  `accountNo` int NOT NULL,
  `name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `currentBal` int NOT NULL,
  PRIMARY KEY (`accountNo`),
  KEY `sequenceId_idx` (`sequenceId`),
  CONSTRAINT `sequenceId` FOREIGN KEY (`sequenceId`) REFERENCES `users` (`sequenceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,1,'Raj','prithvirajpatil2511@gmail.com',9000),(2,2,'Jay','voidpp25@gmail.com',2000);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `billSequenceID` int NOT NULL,
  `billerCode` varchar(45) NOT NULL,
  `amount` int NOT NULL,
  `dueDate` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `consumerNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`billSequenceID`),
  KEY `billerCode_idx` (`billerCode`),
  KEY `billerCode_idx1` (`billerCode`),
  KEY `consumerNo` (`consumerNo`),
  CONSTRAINT `billerCode2` FOREIGN KEY (`billerCode`) REFERENCES `masterbillers` (`billerCode`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`consumerNo`) REFERENCES `regbillers` (`consumerNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (35,'B001',1000,'2022-08-29','PAID','9987'),(1002,'B002',200,'2008-09-11','PAID','9986'),(1003,'B001',300,'2008-10-11','PAID','9934');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (39);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `input`
--

DROP TABLE IF EXISTS `input`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `input` (
  `id` int NOT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input`
--

LOCK TABLES `input` WRITE;
/*!40000 ALTER TABLE `input` DISABLE KEYS */;
/*!40000 ALTER TABLE `input` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logged_in_user`
--

DROP TABLE IF EXISTS `logged_in_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logged_in_user` (
  `id` int NOT NULL,
  `login_id` varchar(45) DEFAULT NULL,
  `role_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logged_in_user`
--

LOCK TABLES `logged_in_user` WRITE;
/*!40000 ALTER TABLE `logged_in_user` DISABLE KEYS */;
INSERT INTO `logged_in_user` VALUES (34,'101','1');
/*!40000 ALTER TABLE `logged_in_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterbillers`
--

DROP TABLE IF EXISTS `masterbillers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masterbillers` (
  `billerCode` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`billerCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterbillers`
--

LOCK TABLES `masterbillers` WRITE;
/*!40000 ALTER TABLE `masterbillers` DISABLE KEYS */;
INSERT INTO `masterbillers` VALUES ('B001','Airtel'),('B002','Jio'),('B003','VI'),('B004','Tata Electric'),('B005','Adani Electricity');
/*!40000 ALTER TABLE `masterbillers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_details`
--

DROP TABLE IF EXISTS `payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_details` (
  `id` int NOT NULL,
  `billSequenceId` int DEFAULT NULL,
  `accountNo` int DEFAULT NULL,
  `description` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_details`
--

LOCK TABLES `payment_details` WRITE;
/*!40000 ALTER TABLE `payment_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regbillers`
--

DROP TABLE IF EXISTS `regbillers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regbillers` (
  `bllerSeqID` int NOT NULL,
  `accountNo` int NOT NULL,
  `billerCode` varchar(45) NOT NULL,
  `consumerNo` varchar(20) DEFAULT NULL,
  `autoPay` tinyint NOT NULL,
  `autopayLimit` int NOT NULL,
  PRIMARY KEY (`bllerSeqID`),
  UNIQUE KEY `consumerNo_UNIQUE` (`consumerNo`),
  KEY `accountNo_idx` (`accountNo`),
  KEY `billerCode_idx` (`billerCode`),
  CONSTRAINT `accountNo` FOREIGN KEY (`accountNo`) REFERENCES `accounts` (`accountNo`),
  CONSTRAINT `billerCode` FOREIGN KEY (`billerCode`) REFERENCES `masterbillers` (`billerCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regbillers`
--

LOCK TABLES `regbillers` WRITE;
/*!40000 ALTER TABLE `regbillers` DISABLE KEYS */;
INSERT INTO `regbillers` VALUES (37,2,'B002','9000',1,5000),(100,1,'B001','9987',1,1000),(101,1,'B002','9986',1,2000),(102,2,'B001','9934',0,0);
/*!40000 ALTER TABLE `regbillers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleId` int NOT NULL,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Bank Manager'),(2,'Account Holder');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `sequenceID` int NOT NULL,
  `transactionsRef` varchar(45) NOT NULL,
  `date_time` datetime NOT NULL,
  `amount` int NOT NULL,
  `transactionType` int NOT NULL,
  `description` varchar(70) DEFAULT NULL,
  `billRefNo` int NOT NULL,
  PRIMARY KEY (`sequenceID`),
  KEY `billRefNo_idx` (`billRefNo`),
  CONSTRAINT `billRefNo` FOREIGN KEY (`billRefNo`) REFERENCES `bills` (`billSequenceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (19,'0','2022-08-24 00:00:00',200,1,'raj paid jio',1002),(20,'0','2022-08-24 21:41:04',200,1,'raj paid jio',1002),(21,'0','2022-08-24 21:45:16',200,1,'raj paid jio',1002),(24,'0','2022-08-25 09:53:06',200,1,'raj paid jio',1002),(25,'0','2022-08-25 09:59:28',200,1,'raj paid jio',1002),(26,'0','2022-08-25 10:51:57',200,1,'raj paid jio',1002),(36,'0','2022-08-25 14:35:39',1000,1,'Auto Payment',35),(38,'0','2022-08-25 14:40:22',1000,1,'raj paid jio',35);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `sequenceId` int NOT NULL,
  `loginId` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roleId` int NOT NULL,
  PRIMARY KEY (`sequenceId`),
  UNIQUE KEY `loginId_UNIQUE` (`loginId`),
  KEY `roleId_idx` (`roleId`),
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'101','abc',1),(2,'102','xyz',2),(3,'103','pqr',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-25 19:12:31
