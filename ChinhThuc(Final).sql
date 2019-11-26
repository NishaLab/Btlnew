-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: realbtl
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `idCourse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sotinchi` int(11) NOT NULL,
  `Khoa` varchar(45) NOT NULL,
  PRIMARY KEY (`idCourse`),
  UNIQUE KEY `idCourse_UNIQUE` (`idCourse`),
  KEY `index3` (`Khoa`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Java OOP',3,'CNTT'),(2,'C++',3,'CNTT'),(3,'C#',3,'CNTT'),(7,'Đại số',2,'ATTT'),(8,'Giải tích',3,'DTVT'),(9,'NLCBCN Mác Lê Nin',3,'DTVT'),(10,'Xác Suất thống kê',2,'CNTT'),(11,'Mạng máy tính',5,'DTVT'),(12,'Nhập môn trí tuệ AI',3,'DTVT'),(13,'Xử lí tín hiệu số',3,'ATTT');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_time`
--

DROP TABLE IF EXISTS `course_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_time` (
  `idCT` int(11) NOT NULL AUTO_INCREMENT,
  `idCourse` int(11) NOT NULL,
  `time` char(16) NOT NULL,
  `tietBatdau` varchar(45) DEFAULT NULL,
  `day` char(3) DEFAULT NULL,
  `phong` varchar(45) NOT NULL,
  `P_ID` int(11) NOT NULL,
  `khoa` varchar(45) NOT NULL,
  PRIMARY KEY (`idCT`),
  KEY `khoa_idx` (`khoa`),
  KEY `idCourse` (`idCourse`),
  KEY `idProfessor_idx` (`P_ID`),
  CONSTRAINT `idCourse` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON UPDATE CASCADE,
  CONSTRAINT `idProfessor` FOREIGN KEY (`P_ID`) REFERENCES `professor` (`idProfessor`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_time`
--

LOCK TABLES `course_time` WRITE;
/*!40000 ALTER TABLE `course_time` DISABLE KEYS */;
INSERT INTO `course_time` VALUES (1,1,'1234567890123456','3','4','502',2,'CNTT'),(3,1,'1234567xxx123456','1','2','502',2,'CNTT'),(5,2,'1234567890123456','1','6','503',2,'CNTT'),(7,3,'12345678xxxxxxxx','1','2','502',2,'CNTT'),(8,11,'1234567xxxxxxxxx','5','6','502',8,'CNTT'),(9,9,'1234567xxxxxxxxx','3','4','602',10,'CNTT'),(11,10,'123456789xxxxxxx','5','4','305',4,'DTVT'),(12,1,'1234567xxx123456','5','2','505',10,'ATTT'),(13,3,'xxxxxxxxx0123456','5','4','602',11,'ATTT'),(14,10,'1234567890123456','3','5','502',11,'DTVT'),(15,10,'xxx4567xxx123456','7','2','401',10,'CNTT'),(16,11,'1234567xxxxxxxxx','1','4','102',11,'CNTT'),(17,8,'123456789xxxxxxx','1','5','205',5,'DTVT'),(18,12,'1234567xxx123456','3','6','302',9,'DTVT'),(19,8,'1234567xxx123456','5','2','605',9,'DTVT'),(20,3,'123456789xxxxxxx','3','3','403',7,'DTVT'),(21,11,'1234567xxx123456','5','6','704',7,'CNTT'),(22,11,'123456789xxxxxxx','3','3','301',5,'CNTT'),(23,7,'1234567xxxxxxxxx','3','5','301',6,'DTVT'),(24,1,'123456789xxxxxxx','5','6','604',8,'DTVT'),(25,2,'123456789xxxxxxx','3','2','501',9,'CNTT'),(26,9,'xxx4567xxx123456','7','3','404',11,'ATTT'),(27,2,'1234567890123456','3','3','504',6,'DTVT'),(29,11,'123456789xxxxxxx','7','2','601',5,'ATTT'),(30,1,'xxx4567xxx123456','7','3','205',4,'ATTT'),(31,2,'1234567xxxxxxxxx','1','6','701',5,'ATTT'),(32,9,'xxx4567xxx123456','1','5','404',4,'CNTT'),(33,1,'1234567890123456','7','2','304',8,'CNTT'),(34,11,'123456789xxxxxxx','5','6','203',4,'DTVT'),(35,2,'1234567xxxxxxxxx','7','5','604',7,'ATTT'),(36,11,'1234567xxxxxxxxx','7','2','403',7,'ATTT'),(37,12,'xxxxxxxxx0123456','7','6','303',10,'ATTT'),(38,12,'xxx4567xxx123456','1','4','103',9,'CNTT'),(39,10,'xxxxxxxxx0123456','1','6','205',4,'ATTT'),(40,3,'123456789xxxxxxx','3','6','704',4,'CNTT'),(41,3,'123456789xxxxxxx','7','5','601',6,'DTVT'),(42,10,'xxx4567xxx123456','7','6','105',8,'CNTT'),(43,10,'1234567xxxxxxxxx','5','2','302',9,'CNTT'),(44,1,'xxxxxxxxx0123456','5','5','303',11,'DTVT');
/*!40000 ALTER TABLE `course_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `idProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `DoB` date NOT NULL,
  `address` varchar(45) NOT NULL,
  `sdt` varchar(45) NOT NULL,
  `sex` char(1) NOT NULL,
  `faculty` varchar(4) NOT NULL,
  PRIMARY KEY (`idProfessor`),
  UNIQUE KEY `idProfessor_UNIQUE` (`idProfessor`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (2,'Nguyen Manh Son','1234-01-01','Ha Noi','0963063105','M','CNTT'),(4,'Nguyễn Thị Dung','1989-09-29','Hà Nội','7569196853','M','DTVT'),(5,'Nguyễn Đình Hóa','1973-10-24','Lạng Sơn','2428264133','F','ATTT'),(6,'Lê Bá Long','1978-10-09','Tuyên Quang','4176401349','F','ATTT'),(7,'Đỗ Phi Nga','1981-12-30','Lào Cai','8958706351','F','DTVT'),(8,'Nguyễn Mạnh Sơn','1978-01-10','Yên Bái','3952698102','F','CNTT'),(9,'Nguyễn Thúy Quỳnh','1986-01-10','Thái Bình','2606710725','M','DTVT'),(10,'Đỗ Xuân Chợ','1986-01-19','Ninh Bình','9132844616','M','ATTT'),(11,'Từ Minh Phương','1986-09-09','Bắc Ninh','7388304682','F','ATTT');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `idStudent` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `sdt` varchar(45) DEFAULT NULL,
  `Sex` char(1) NOT NULL,
  PRIMARY KEY (`idStudent`),
  UNIQUE KEY `idStudent_UNIQUE` (`idStudent`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Hung ABC','1999-01-06','Ha Noi','0963063105','M'),(2,'Nguyen Duc Nam','1999-06-01','Ha Noi','096306105','M'),(3,'hung','1999-06-01','Ha Noi','0963063105','M'),(5,'Tran Dinh Trong','1999-06-01','Ma Cao','0963063105','M'),(7,'Vũ Quỳnh Trang','1999-09-11','Thái Nguyên','4565016007','M'),(8,'Trần Thị Thảo','2000-04-05','Hải Phòng','6623010373','F'),(9,'Nguyễn Thành Nam','2001-06-13','Thanh Hóa','5391835651','F'),(10,'Nguyễn Đức Nam','1999-06-02','Hà Nội','2142701645','F'),(11,'Bùi Thị Xuân','1998-10-08','Lạng Sơn','1367826258','F'),(12,'Nguyễn Thị Thắm','2000-11-24','Tuyên Quang','4389669862','F'),(13,'Quách Hải Nam','2000-06-16','Lào Cai','4421441187','F'),(14,'Nguyễn Đức Hưng','2001-06-22','Yên Bái','3718684940','F'),(15,'Vũ Minh Đức','1999-09-24','Thái Bình','4449083691','F'),(16,'Nguyễn Thị Trang','2000-06-30','Ninh Bình','4388961563','F'),(17,'Nguyễn Thị Thảo','2000-07-21','Bắc Ninh','1154514607','M'),(18,'Trần Đình Trọng','2001-08-18','Thái Nguyên','3741895176','F'),(19,'Nguyễn Đức Hưng','1999-04-11','Hải Phòng','4668405126','M'),(20,'hung123','1999-06-01',NULL,'0963063105','M');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
  `idS` int(11) NOT NULL,
  `idC` int(11) NOT NULL,
  PRIMARY KEY (`idS`,`idC`),
  KEY `idCT_idx` (`idC`),
  CONSTRAINT `idCT` FOREIGN KEY (`idC`) REFERENCES `course_time` (`idCT`),
  CONSTRAINT `idStudent` FOREIGN KEY (`idS`) REFERENCES `student` (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,5),(1,9);
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `usr` varchar(45) NOT NULL,
  `pswd` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `idUser_UNIQUE` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hung','123456'),(2,'Nam','1'),(3,'hung123','123456'),(5,'trong','trong123'),(7,'hungdemo2','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user-student`
--

DROP TABLE IF EXISTS `user-student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user-student` (
  `idU` int(11) NOT NULL,
  `idS` int(11) NOT NULL,
  PRIMARY KEY (`idU`,`idS`),
  KEY `idS_idx` (`idS`),
  CONSTRAINT `idS` FOREIGN KEY (`idS`) REFERENCES `student` (`idStudent`) ON UPDATE CASCADE,
  CONSTRAINT `idU` FOREIGN KEY (`idU`) REFERENCES `user` (`idUser`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user-student`
--

LOCK TABLES `user-student` WRITE;
/*!40000 ALTER TABLE `user-student` DISABLE KEYS */;
/*!40000 ALTER TABLE `user-student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-26 21:25:46
