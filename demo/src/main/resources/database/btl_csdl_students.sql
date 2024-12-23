-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: btl_csdl
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` bigint NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `gpa` float DEFAULT NULL,
  `major` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UKe2rndfrsx22acpq2ty1caeuyw` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (22123459,'2005-08-07','phamthic@gmail.com','Phạm Thị Thị C','Phường 3, Quận Hải Châu, Đà Nẵng','Nữ','0915123456',3.2,'CN7 - Công Nghệ Hàng Không Vũ Trụ','K62',NULL,NULL),(22123462,'2003-07-15','tranvanf@gmail.com','Trần Văn F','Xã Ninh Hòa, Huyện Ninh Sơn, Ninh Thuận','Nam','0921123456',1.8,'CN10 - Công Nghệ Nông Nghiệp','K65',NULL,NULL),(22123465,'2006-06-13','hoangthii@gmail.com','Hoàng Thị Linh','Phường Phước Hòa, Quận Tân Phú, TP. Hồ Chí Minh','Nữ','0935234567',3.1,'CN8 - Khoa Học Máy Tính','K64',NULL,NULL),(22124567,'2004-06-25','maivanphuoc@gmail.com','Mai Văn Phước','Xã Sơn Kim, Huyện Hương Sơn, Hà Tĩnh','Nam','0934321123',2.7,'CN11 - Kỹ Thuật Điều Khiển và Tự Động Hóa','K63',NULL,NULL),(22198765,'2005-08-17','hoangthanhtrung@gmail.com','Hoàng Thành Trung','Phường Thanh Xuân, Quận Thanh Xuân, Hà Nội','Nam','0913456789',3.2,'CN3 - Vật Lý Kỹ Thuật','K67',NULL,NULL),(22212345,'2004-11-11','dangthithao@gmail.com','Đặng Thị Thảo','Phường Hòa An, Quận Cẩm Lệ, Đà Nẵng','Nữ','0987654312',2.7,'CN10 - Công Nghệ Nông Nghiệp','K66',NULL,NULL),(22213456,'2003-12-30','nguyenthanhdat@gmail.com','Nguyễn Thành Đạt','Xã Vĩnh Trường, Huyện Gio Linh, Quảng Trị','Nam','0902345671',3.4,'CN3 - Vật Lý Kỹ Thuật','K65',NULL,NULL),(22234567,'2003-11-23','tranthib@gmail.com','Trần Thị B','Xã Xuân Hòa, Huyện Xuân Trường, Nam Định','Nữ','0987654321',2.9,'CN2 - Kỹ Thuật Máy Tính','K65',NULL,NULL),(22412345,'2006-03-18','nguyenhongngoc@gmail.com','Nguyễn Hồng Ngọc','Phường Vĩnh Hòa, TP. Nha Trang, Khánh Hòa','Nữ','0961234567',3.1,'CN7 - Công Nghệ Hàng Không Vũ Trụ','K68',NULL,NULL),(22456788,'2005-05-14','nguyenminhhieu@gmail.com','Nguyễn Minh Hiếu','Phường Tân Định, Quận 1, TP. Hồ Chí Minh','Nam','0912987654',3.6,'CN1 - Công Nghệ Thông Tin','K67',NULL,NULL),(22456789,'2006-07-08','hoangthid@gmail.com','Hoàng Thị D','Phường Bến Thủy, TP. Vinh, Nghệ An','Nữ','0965432123',3,'CN7 - Công Nghệ Hàng Không Vũ Trụ','K68',NULL,NULL),(22467891,'2005-03-25','nguyencongminh@gmail.com','Nguyễn Công Minh','Xã Hương Sơn, Huyện Hương Khê, Hà Tĩnh','Nam','0987654391',2.8,'CN10 - Công Nghệ Nông Nghiệp','K67',NULL,NULL),(23021567,'2005-05-21','toannq2005@gmail.com','Nguyễn Quang Toàn','Thôn Trên, Bích Hòa, Thanh Oai, Hà Nội','Nam','0376216946',3.45,'CN12 - Trí Tuệ Nhân Tạo','K68',NULL,NULL),(23021631,'2005-09-21','minh2m5@gmail.com','Nguyễn Nhật Minh','Bích hòa, Thanh Oai, Hà Nội','Nam','0354128488',3.34,'CN8 - Khoa Học Máy Tính','K68',NULL,NULL),(23111223,'2003-02-19','phamvane@gmail.com','Phạm Văn Em','Xã Hoài Sơn, Huyện Hoài Nhơn, Bình Định','Nam','0943210987',3.1,'CN8 - Khoa Học Máy Tính','K66',NULL,NULL),(23123456,'2004-05-12','nguyenvana123@gmail.com','Nguyễn Văn A','Phường Dịch Vọng, Quận Cầu Giấy, Hà Nội','Nam','0912345678',3.5,'CN1 - Công Nghệ Thông Tin','K66',NULL,NULL),(23123457,'2005-08-22','lethib@gmail.com','Lê Thị B','Phường 2, Quận Ba Đình, Hà Nội','Nữ','0945234567',2.8,'CN8 - Khoa Học Máy Tính','K64',NULL,NULL),(23123460,'2005-10-10','dinhvand@gmail.com','Đinh Văn D','Xã Đông Hòa, Huyện Đông Hưng, Thái Bình','Nam','0939123456',2.5,'CN11 - Kỹ Thuật Điều Khiển và Tự Động Hóa','K67',NULL,NULL),(23123463,'2004-09-18','nguyenthig@gmail.com','Nguyễn Thị G','Phường Lê Lợi, Quận Ngô Quyền, Hải Phòng','Nữ','0948234567',3.6,'CN2 - Kỹ Thuật Máy Tính','K66',NULL,NULL),(23123490,'2004-08-12','phamthihoa@gmail.com','Phạm Thị Hoa','Phường Hòa Minh, Quận Liên Chiểu, Đà Nẵng','Nữ','0904321098',3.1,'CN2 - Kỹ Thuật Máy Tính','K66',NULL,NULL),(23154321,'2006-06-22','lethithuy@gmail.com','Lê Thị Thúy','Phường Bình An, TP. Vũng Tàu, Bà Rịa - Vũng Tàu','Nữ','0937654321',3,'CN11 - Kỹ Thuật Điều Khiển và Tự Động Hóa','K68',NULL,NULL),(23234567,'2004-12-25','tranthithanh@gmail.com','Trần Thị Thanh','Xã Hương Thủy, Huyện Hương Khê, Hà Tĩnh','Nữ','0923456781',3.6,'CN2 - Kỹ Thuật Máy Tính','K66',NULL,NULL),(23321234,'2005-09-13','phamducthanh@gmail.com','Phạm Đức Thành','Xã Bình Minh, Huyện Thăng Bình, Quảng Nam','Nam','0932345678',3.4,'CN12 - Trí Tuệ Nhân Tạo','K67',NULL,NULL),(23321236,'2003-09-18','tranthithuylinh@gmail.com','Trần Thị Thùy Linh','Phường Hòa Cường Bắc, Quận Hải Châu, Đà Nẵng','Nữ','0904321980',3.3,'CN2 - Kỹ Thuật Máy Tính','K65',NULL,NULL),(23367890,'2006-01-15','lethithuytien@gmail.com','Lê Thị Thúy Tiên','Xã Bình Chánh, Huyện Bình Chánh, TP. Hồ Chí Minh','Nữ','0976543123',2.9,'CN11 - Kỹ Thuật Điều Khiển và Tự Động Hóa','K68',NULL,NULL),(23412345,'2006-07-07','lethiyen@gmail.com','Lê Thị Yến','Phường Bình Thủy, Quận Bình Thủy, TP. Cần Thơ','Nữ','0923456789',3,'CN7 - Công Nghệ Hàng Không Vũ Trụ','K68',NULL,NULL),(23456780,'2003-04-10','vohuuthanh@gmail.com','Võ Hữu Thành','Phường An Phú, TP. Cần Thơ, Cần Thơ','Nam','0976543219',3.5,'CN2 - Kỹ Thuật Máy Tính','K65',NULL,NULL),(23456789,'2006-04-11','voanhtuan@gmail.com','Võ Anh Tuấn','Xã Đông Hòa, Huyện Đông Sơn, Thanh Hóa','Nam','0986543210',3.4,'CN2 - Kỹ Thuật Máy Tính','K67',NULL,NULL),(24111223,'2004-06-18','dangngocthuy@gmail.com','Đặng Ngọc Thúy','Phường Lê Lợi, TP. Bắc Giang, Bắc Giang','Nữ','0943216598',3.7,'CN12 - Trí Tuệ Nhân Tạo','K66',NULL,NULL),(24123457,'2003-01-27','phamquanghuy@gmail.com','Phạm Quang Huy','Phường Tân Bình, TP. Hải Dương, Hải Dương','Nam','0943217654',3.9,'CN1 - Công Nghệ Thông Tin','K65',NULL,NULL),(24123458,'2003-05-05','tranvanh@gmail.com','Trần Văn H','Xã Hòa Bình, Huyện Châu Thành, Tây Ninh','Nam','0928123456',3.9,'CN12 - Trí Tuệ Nhân Tạo','K65',NULL,NULL),(24123461,'2006-02-28','hoangthie@gmail.com','Hoàng Thị E','Phường Tân Phú, Quận 7, TP. Hồ Chí Minh','Nữ','0919234567',4,'CN3 - Vật Lý Kỹ Thuật','K68',NULL,NULL),(24123464,'2005-11-25','phamvanh@gmail.com','Phạm Văn H','Phường Phước Long, Quận 9, TP. Hồ Chí Minh','Nam','0911324567',2.3,'CN12 - Trí Tuệ Nhân Tạo','K69',NULL,NULL),(24123478,'2005-03-15','leminhc@gmail.com','Lê Minh C','Phường 9, Quận 5, TP. Hồ Chí Minh','Nam','0938765432',3.8,'CN3 - Vật Lý Kỹ Thuật','K67',NULL,NULL),(24189012,'2003-12-14','lehoanganh@gmail.com','Lê Hoàng Anh','Phường Hòa Khánh Nam, Quận Liên Chiểu, Đà Nẵng','Nam','0911123456',3.3,'CN12 - Trí Tuệ Nhân Tạo','K66',NULL,NULL),(24198761,'2004-02-10','phamanhquan@gmail.com','Phạm Anh Quân','Xã Hải Lộc, Huyện Hải Hậu, Nam Định','Nam','0937654123',3.9,'CN8 - Khoa Học Máy Tính','K66',NULL,NULL),(24345678,'2005-10-30','nguyenthithu@gmail.com','Nguyễn Thị Thu','Phường 3, TP. Đà Lạt, Lâm Đồng','Nữ','0976545678',3.7,'CN10 - Công Nghệ Nông Nghiệp','K64',NULL,NULL),(24345679,'2003-07-09','lequocbao@gmail.com','Lê Quốc Bảo','Phường Bến Nghé, Quận 1, TP. Hồ Chí Minh','Nam','0909876543',2.8,'CN8 - Khoa Học Máy Tính','K65',NULL,NULL),(24456789,'2004-02-15','doanphuongnam@gmail.com','Đoàn Phương Nam','Phường Bình Thuận, TP. Tuy Hòa, Phú Yên','Nam','0904321987',2.9,'CN3 - Vật Lý Kỹ Thuật','K67',NULL,NULL),(24489012,'2005-10-20','tranvanmanh@gmail.com','Trần Văn Mạnh','Phường Đông Vệ, TP. Thanh Hóa, Thanh Hóa','Nam','0911345678',3.2,'CN1 - Công Nghệ Thông Tin','K67',NULL,NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-23  8:54:34
