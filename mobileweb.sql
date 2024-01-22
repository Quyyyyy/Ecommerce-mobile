-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: moblieweb
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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,NULL,_binary '','2024-01-16 02:43:07.284099','Flagship','điện thoại cao cấp'),(2,NULL,_binary '','2024-01-16 02:42:54.804832','Mid-range','điện thoại tầm trung'),(3,NULL,_binary '','2024-01-16 02:42:37.054109','Budget','điện thoại giá rẻ');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `star` int DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6uv0qku8gsu6x1r2jkrtqwjtn` (`product_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK6uv0qku8gsu6x1r2jkrtqwjtn` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'2024-01-07 04:42:46.000000',_binary '','2024-01-07 04:42:46.000000','dùng tốt',NULL,1,1),(2,'2024-01-07 20:56:43.322289',_binary '','2024-01-07 20:56:43.322289','tốt',NULL,4,1),(3,'2024-01-07 20:59:59.133589',_binary '','2024-01-07 20:59:59.133589','dùng đc',NULL,3,1),(4,'2024-01-07 21:02:56.058499',_binary '','2024-01-07 21:02:56.058499','pin nhanh nóng ',NULL,12,1),(5,'2024-01-07 21:07:37.176013',_binary '','2024-01-07 21:07:37.176013','sản phẩm ok',NULL,7,1),(6,'2024-01-07 21:10:16.570052',_binary '','2024-01-07 21:10:16.570052','ko tôtass lắm',NULL,7,1),(7,'2024-01-07 21:18:36.316235',_binary '','2024-01-07 21:18:36.316235','ko tốt lắm',NULL,7,1),(8,'2024-01-07 21:19:48.196091',_binary '','2024-01-07 21:19:48.196091','sp tốt',NULL,14,1),(9,'2024-01-07 21:21:32.002093',_binary '','2024-01-07 21:21:32.002093','dùng rất tốt',NULL,14,1),(10,'2024-01-07 21:23:33.930059',_binary '','2024-01-07 21:23:33.930059','kjkkn;l',NULL,14,1),(11,'2024-01-07 21:24:13.880404',_binary '','2024-01-07 21:24:13.880404','dùng rrats tốt',NULL,3,1),(12,'2024-01-07 21:25:23.356597',_binary '','2024-01-07 21:25:23.356597','ok',NULL,3,1),(15,'2024-01-07 21:28:08.961514',_binary '','2024-01-07 21:28:08.961514','dùng rất tốt',NULL,6,1),(16,'2024-01-07 21:28:42.123263',_binary '','2024-01-07 21:28:42.123263','nhanh chai pin, hay nóng máy ',NULL,21,1),(17,'2024-01-07 21:28:55.421590',_binary '','2024-01-07 21:28:55.421590','màn hình hay bị đơ',NULL,21,1),(33,'2024-01-08 01:13:59.695163',_binary '','2024-01-08 01:13:59.695163','jkgjfkgavnfdlbldkb',NULL,3,1),(34,'2024-01-17 04:35:17.587000',_binary '','2024-01-17 04:35:17.587000','dùng ổn',NULL,4,1),(35,'2024-01-18 04:05:50.813000',_binary '','2024-01-18 04:05:50.813000','ảnh chụp ảo quá',NULL,13,1),(36,'2024-01-19 13:43:58.225000',_binary '','2024-01-19 13:43:58.225000','cx đc',NULL,11,1),(38,'2024-01-19 15:14:01.755000',_binary '','2024-01-19 15:14:01.755000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(39,'2024-01-19 15:14:03.146000',_binary '','2024-01-19 15:14:03.146000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(40,'2024-01-19 15:14:03.687000',_binary '','2024-01-19 15:14:03.687000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(41,'2024-01-19 15:14:03.988000',_binary '','2024-01-19 15:14:03.988000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(42,'2024-01-19 15:14:04.269000',_binary '','2024-01-19 15:14:04.269000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(43,'2024-01-19 15:14:05.610000',_binary '','2024-01-19 15:14:05.610000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(44,'2024-01-19 15:14:06.057000',_binary '','2024-01-19 15:14:06.057000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(45,'2024-01-19 15:14:06.249000',_binary '','2024-01-19 15:14:06.249000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(46,'2024-01-19 15:14:06.538000',_binary '','2024-01-19 15:14:06.538000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(47,'2024-01-19 15:14:06.762000',_binary '','2024-01-19 15:14:06.762000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(48,'2024-01-19 15:14:16.282000',_binary '','2024-01-19 15:14:16.282000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(49,'2024-01-19 15:14:16.841000',_binary '','2024-01-19 15:14:16.841000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(50,'2024-01-19 15:14:17.122000',_binary '','2024-01-19 15:14:17.122000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(51,'2024-01-19 15:14:17.428000',_binary '','2024-01-19 15:14:17.428000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(52,'2024-01-19 15:14:17.826000',_binary '','2024-01-19 15:14:17.826000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(53,'2024-01-19 15:14:17.998000',_binary '','2024-01-19 15:14:17.998000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(54,'2024-01-19 15:14:18.265000',_binary '','2024-01-19 15:14:18.265000','dùng quá tệ chưa gì pin đã bị phồng lên',NULL,1,3),(55,'2024-01-19 15:17:42.706000',_binary '','2024-01-19 15:17:42.706000','dùng cx đc',NULL,8,3),(56,'2024-01-19 15:23:52.482000',_binary '','2024-01-19 15:23:52.482000','tốt',NULL,12,3),(57,'2024-01-19 15:30:26.948000',_binary '','2024-01-19 15:30:26.948000','sản phẩm tốt',NULL,6,3),(58,'2024-01-19 15:32:20.213000',_binary '','2024-01-19 15:32:20.213000','tạm được',NULL,19,3),(59,'2024-01-19 17:02:07.167000',_binary '','2024-01-19 17:02:07.167000','dùng đc',NULL,20,4),(60,'2024-01-19 17:15:12.165000',_binary '','2024-01-19 17:15:12.165000','sản phẩm dùng tốt',NULL,17,4),(61,'2024-01-21 03:23:58.456000',_binary '','2024-01-21 03:23:58.456000','tệ quá ',NULL,7,9),(62,'2024-01-22 21:47:33.886000',_binary '','2024-01-22 21:47:33.886000','tạm đc',NULL,5,1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedbacks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` bit(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbacks`
--

LOCK TABLES `feedbacks` WRITE;
/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
INSERT INTO `feedbacks` VALUES (2,_binary '','điện thoại của tôi mới nhận bị xước màn hình','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','sản phẩm lỗi',NULL,NULL),(3,_binary '','ko có vấn đề gì nữa','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','hgglkl',NULL,NULL),(4,_binary '','điện thoai của tôi bị lỗi ngồn','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','lỗi',NULL,NULL),(5,_binary '','tốt','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','klln',NULL,NULL),(6,_binary '','dùng cũng tamj đc','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','lnjkjv',NULL,NULL);
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `price_buy` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`),
  CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,'2024-01-09 03:49:31.221366',_binary '','2024-01-09 03:49:31.221366',1,1,2,7000000),(2,'2024-01-09 04:10:26.933228',_binary '','2024-01-09 04:10:26.933228',1,2,6,12000000),(3,'2024-01-09 04:10:26.936221',_binary '','2024-01-09 04:10:26.936221',1,2,4,25000000),(4,'2024-01-09 04:52:28.663126',_binary '','2024-01-09 04:52:28.693241',1,3,4,25000000),(5,'2024-01-09 11:25:25.360605',_binary '','2024-01-09 11:25:25.391524',1,4,2,7000000),(6,'2024-01-09 11:47:25.781385',_binary '','2024-01-09 11:47:25.808312',1,5,4,25000000),(7,'2024-01-13 14:42:42.116974',_binary '','2024-01-13 14:42:42.229672',1,7,1,6100000),(8,'2024-01-18 03:46:42.359000',_binary '','2024-01-18 03:46:42.395000',1,8,1,6100000),(9,'2024-01-18 03:47:11.990000',_binary '','2024-01-18 03:47:12.051000',1,9,19,4300000),(10,'2024-01-19 14:56:49.606000',_binary '','2024-01-19 14:56:49.643000',1,10,6,12000000),(11,'2024-01-19 15:15:23.332000',_binary '','2024-01-19 15:15:23.357000',1,11,20,6290000),(12,'2024-01-19 16:46:39.111000',_binary '','2024-01-19 16:46:39.144000',1,12,2,7000000),(13,'2024-01-19 23:50:21.202000',_binary '','2024-01-19 23:50:21.211000',2,13,1,6100000),(14,'2024-01-19 23:50:21.206000',_binary '','2024-01-19 23:50:21.213000',1,13,20,6290000),(15,'2024-01-23 02:08:30.301000',_binary '','2024-01-23 02:08:30.315000',2,14,11,6500000),(16,'2024-01-23 02:08:30.310000',_binary '','2024-01-23 02:08:30.317000',1,14,21,1890000);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `total` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `order_code` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2024-01-09 03:49:31.121666',_binary '','2024-01-09 03:49:31.122664','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','mq@gmail.com','Trần Vũ Minh Quý','0342939269','đã nhận hàng',7000000,NULL,'1704746970682','SHIP_COD'),(2,'2024-01-09 04:10:26.915280',_binary '','2024-01-09 04:10:26.915280','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',37000000,NULL,'1704748181885','SHIP_COD'),(3,'2024-01-09 04:52:28.648132',_binary '','2024-01-09 04:52:28.648132','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','mq1234@hmail.com','Trần Vũ Minh Quý','0342939269','đã nhận hàng',25000000,NULL,'1704750713323','VNPAY'),(4,'2024-01-09 11:25:25.333679',_binary '','2024-01-22 23:58:24.225000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','frwwkgekrag@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',7000000,NULL,'1704774280501','VNPAY'),(5,'2024-01-09 11:47:25.762436',_binary '','2024-01-22 23:58:23.554000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','31@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',25000000,NULL,'1704775605308','VNPAY'),(7,'2024-01-13 14:42:42.101015',_binary '','2024-01-18 04:25:16.440000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','kjvjj@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',6100000,NULL,'1705131761899','SHIP_COD'),(8,'2024-01-18 03:46:42.334000',_binary '','2024-01-18 04:23:59.173000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','fgdksgkasklg@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',6100000,NULL,'1705524277919','VNPAY'),(9,'2024-01-18 03:47:11.986000',_binary '','2024-01-18 04:23:53.372000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','yjuydtyktrk@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',4300000,NULL,'1705524431882','SHIP_COD'),(10,'2024-01-19 14:56:49.590000',_binary '','2024-01-22 23:55:28.216000','Cầu Giấy, Hà Nội','haoba@gmail.com','Bùi Anh Hào','0935556185','đã hủy',12000000,3,'1705650974367','VNPAY'),(11,'2024-01-19 15:15:23.325000',_binary '','2024-01-22 23:58:22.398000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','dfklawfkawl@gmail.com','Trần Vũ Minh Quý','0342939269','đang vận chuyển',6290000,NULL,'1705652123218','SHIP_COD'),(12,'2024-01-19 16:46:38.981000',_binary '','2024-01-22 23:59:01.472000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','minhquy3107@gmail.com','Trần Vũ Minh Quý','0342939269','đã nhận hàng',7000000,1,'1705657545155','VNPAY'),(13,'2024-01-19 23:50:21.170000',_binary '','2024-01-22 23:54:55.113000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','dhrhktl@gmail.com','Trần Vũ Minh Quý','0342939269','đã hủy',18490000,3,'1705683020931','SHIP_COD'),(14,'2024-01-23 02:08:30.279000',_binary '','2024-01-23 02:08:30.279000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','qtranvuminh@gmail.com','Trần Vũ Minh Quý','0342939269','mới',14890000,9,'1705950392431','VNPAY');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `ktman_hinh` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `camera_sau` varchar(255) DEFAULT NULL,
  `camera_truoc` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `discount` bigint DEFAULT NULL,
  `pin` int DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `ram` int DEFAULT NULL,
  `rom` int DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,NULL,_binary '','2024-01-19 23:50:20.980000','Hisilicon Kirin 980','6.39\'\'','upload\\product\\avatar\\Huawei-mate-20-pro-green.jpg','huawei','24','64','jkjklll;',6100000,4200,6500000,96,8,128,'huawei','Huawei-mate-20-pro-green',2),(2,NULL,_binary '','2024-01-19 16:46:38.919000','Hisilicon Kirin 980','6.3','upload\\product\\avatar\\Huawei-nova-3-2.jpg','huawei','60','24','glkfglsagsa',7000000,4200,7500000,96,4,128,'huawei','Huawei-nova-3-2',3),(3,NULL,_binary '','2024-01-17 02:24:53.745558','kirin 970','6.28','upload\\product\\avatar\\Huawei-y5-2017.jpg','huawei','60','24','jkjklll;',7560000,4000,8000000,100,4,128,'huawei','Huawei-y5-2017',3),(4,NULL,_binary '','2024-01-17 02:23:52.030357','M1','9.7','upload\\product\\avatar\\Ipad-wifi-32gb-2018-thumb.jpg','apple','128','32','jkjklll;',25000000,6000,25000000,97,32,528,'apple','Ipad-wifi-32gb-2018-thumb',1),(5,NULL,_binary '','2024-01-17 02:22:52.963962','A10','5.28','upload\\product\\avatar\\Iphone-7-plus-32gb.jpg','apple','180','24','jkjklll;',5000000,3800,5000000,100,4,256,'apple','Iphone-7-plus-32gb',1),(6,NULL,_binary '','2024-01-19 14:56:49.486000','A10','6.3','upload\\product\\avatar\\Iphone-x-256gb-silver.jpg','apple','180','24','jkjklll;',12000000,3800,12000000,98,4,256,'apple','Iphone-x-256gb-silver',1),(7,NULL,_binary '','2024-01-17 02:20:46.453966','Snapdragon 888+','3','upload\\product\\avatar\\Mobiistar-b310-orange.jpg','mobiiistar','16','0','jkjklll;',1000000,3000,1200000,100,2,64,'mobiistar','Mobiistar-b310-orange',3),(8,NULL,_binary '','2024-01-17 02:19:34.335269','Snapdragon 415','6','upload\\product\\avatar\\Mobiistar-e-selfie-300.jpg','mobiiistar','48','24','jkjklll;',5400000,5000,5400000,100,4,128,'mobiistar','Mobiistar-e-selfie-300',3),(9,NULL,_binary '','2024-01-17 02:18:46.205659','Snapdragon  515','6.2','upload\\product\\avatar\\Mobiistar-x-3.jpg','mobiiistar','24','16','jkjklll;',4800000,3800,4800000,100,4,128,'mobiistar','Mobiistar-x-3',3),(10,NULL,_binary '','2024-01-17 02:14:38.222254','Snapdragon 712','6.8','upload\\product\\avatar\\Mobiistar-zumbo-s2-dual.jpg','mobiiistar','60','24','jkjklll;',8000000,8000,8000000,100,4,128,'mobiistar','Mobiistar-zumbo-s2-dual',3),(11,NULL,_binary '','2024-01-23 02:08:30.191000','Snapdragon 450','6.3','upload\\product\\avatar\\Nokia-51-plus-black.jpg','nokia','64','24','jkjklll;',6500000,8000,6500000,98,4,128,'nokia','Nokia-51-plus-black',2),(12,NULL,_binary '','2024-01-17 02:12:26.454757','A3','5.6','upload\\product\\avatar\\Oppo-a3s-32gb.jpg','oppo','48','24','glkfglsagsa',5700000,4500,5700000,100,4,128,'oppo','Oppo-a3s-32gb',2),(13,NULL,_binary '','2024-01-18 01:34:13.827000','Snapdragon 715','5.8','upload\\product\\avatar\\Oppo-f9-red.jpg','oppo','48','24','jkjklll;',7800000,5800,7800000,100,4,128,'oppo','Oppo-f9-red',2),(14,NULL,_binary '','2024-01-18 01:34:37.677000','Kryo 465','5.8','upload\\product\\avatar\\Samsung-galaxy-a8-plus.jpg','samsung','64','24','jkjklll;',11000000,4000,11000000,100,4,128,'samsung','Samsung-galaxy-a8-plus',1),(15,NULL,_binary '','2024-01-17 01:37:21.010881','kryo 777','6.8','upload\\product\\avatar\\Samsung-galaxy-j4-plus-pink.jpg','samsung','64','24','glkfglsagsa',14000000,4000,14000000,100,8,128,'samsung','Samsung-galaxy-j4-plus-pink',1),(16,NULL,_binary '','2024-01-17 00:35:14.134963','Snapdragon 712','5.9','upload\\product\\avatar\\Xiaomi-mi-8-1.jpg','xiaomi','48','24','glkfglsagsa',4300000,400,4300000,100,4,128,'xiaomi','Xiaomi-mi-8-1',1),(17,NULL,_binary '','2024-01-17 00:33:17.060579','Snapdragon 615','6','upload\\product\\avatar\\Xiaomi-mi-8-lite-black-1.jpg','xiaomi','28','24','jkjklll;',5000000,5000,5000000,100,4,128,'xiaomi','Xiaomi-mi-8-lite-black-1',1),(18,NULL,_binary '','2024-01-17 00:32:16.491656','Snapdragon 888','6.3','upload\\product\\avatar\\Xiaomi-redmi-5-plus.jpg','xiaomi','48','24','glkfglsagsa',6500000,5200,6500000,100,4,128,'xiaomi','Xiaomi-redmi-5-plus',3),(19,NULL,_binary '','2024-01-18 03:52:30.439000','Kryo 412','5\'\'','upload\\product\\avatar\\Xiaomi-redmi-note-5-pro.jpg','xiaomi','48','16','jkjklll;',4300000,4500,4300000,99,4,128,'xiaomi','Xiaomi-redmi-note-5-pro',3),(20,NULL,_binary '','2024-01-19 23:50:21.117000','k7','7.5','upload\\product\\avatar\\Oppo A77s 8GB-128GB.jpg','oppo','180\'\'','46\'\'','glkfglsagsa',6290000,3500,6290000,98,16,256,'oppo','Oppo A77s 8GB-128GB',3),(21,NULL,_binary '','2024-01-23 02:08:30.236000','k7','7.5','upload\\product\\avatar\\realme-C30s 2GB-32GB.jpg','realme','180\'\'','46\'\'','glkfglsagsa',1890000,3000,1890000,99,8,256,'realme','realme-C30s 2GB-32GB',3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_images`
--

DROP TABLE IF EXISTS `products_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgt41wyswrex82sy6iwdup2eak` (`product_id`),
  CONSTRAINT `FKgt41wyswrex82sy6iwdup2eak` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_images`
--

LOCK TABLES `products_images` WRITE;
/*!40000 ALTER TABLE `products_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,NULL,_binary '',NULL,'ADMIN'),(2,NULL,_binary '',NULL,'GUEST');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-01-07 04:41:30.000000',_binary '','2024-01-22 18:59:01.671000','Km10 Nguyễn Trãi, Hà Đông, Hà Nội','minhquy3107@gmail.com','Trần Vũ Minh Quý','$2a$10$uaQDHlxNHr5bYE8bbnyd4.hoQOJRkhBY4F08y2tZkJN.jRFlI0R4y','0342939269','QUYTVM'),(3,'2024-01-07 04:42:17.000000',_binary '','2024-01-22 14:38:44.685000','Cầu Giấy, Hà Nội','haoanh@gmail.com','Bùi Anh Hào','$2a$10$31O0mhD9Tr1.WidwHTEjqOelHXDGqyNQDbo8hHFP71KMNnumaQTzG','0399919789','HAOBA'),(4,'2024-01-15 04:12:23.859427',_binary '','2024-01-22 14:49:16.739000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','hoaithu@gmail.com','Trần Thị Hoài Thu','$2a$10$31O0mhD9Tr1.WidwHTEjqOelHXDGqyNQDbo8hHFP71KMNnumaQTzG','0917363465','ThuTTH'),(7,'2024-01-15 13:12:26.034757',_binary '\0','2024-01-18 04:49:44.827000','Km10 Nguyễn Trãi, Hà Đông, Hà Nội','minhquy@gmail.com','Vũ Minh Quý','$2a$10$31O0mhD9Tr1.WidwHTEjqOelHXDGqyNQDbo8hHFP71KMNnumaQTzG','0915555617','QuyVM'),(9,'2024-01-19 02:40:45.236000',_binary '','2024-01-23 02:05:15.412000','Số 8a, Cổ Bản, Đồng Mai, Hà Đông, Hà Nội','qtranvuminh@gmail.com','Trần Vũ Minh Quý','$2a$10$31O0mhD9Tr1.WidwHTEjqOelHXDGqyNQDbo8hHFP71KMNnumaQTzG','0342939269','MinhTV'),(13,'2024-01-21 03:40:26.767000',_binary '','2024-01-21 03:40:26.767000',NULL,'anpham@gmai.com','Phạm Thành An','$2a$10$kxiEbzy3C6onVxwcyM5sOOC4L3wDh4uMgaI7loXz/3tBqczEk53w2','0999339159','AnPT');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roloes`
--

DROP TABLE IF EXISTS `users_roloes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roloes` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKfx9h1l72uu754metadamcc758` (`role_id`),
  CONSTRAINT `FKfx9h1l72uu754metadamcc758` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhc6iupcxanuh6gb67kq44usri` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roloes`
--

LOCK TABLES `users_roloes` WRITE;
/*!40000 ALTER TABLE `users_roloes` DISABLE KEYS */;
INSERT INTO `users_roloes` VALUES (1,1),(7,1),(9,1),(1,2),(3,2),(4,2),(7,2),(9,2),(13,2);
/*!40000 ALTER TABLE `users_roloes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-23  2:32:54
