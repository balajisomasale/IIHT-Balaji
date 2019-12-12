-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: iiht-mentor-on-demand
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mentor`
--

DROP TABLE IF EXISTS `mentor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentor` (
  `mentor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mentor_linkedin_url` varchar(255) NOT NULL,
  `mentor_timeslot` varchar(11) NOT NULL,
  `mentor_years_of_experience` float NOT NULL,
  `mentor_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`mentor_id`),
  KEY `FKtfkx403mra3pna073o3h1k5ti` (`mentor_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor`
--

LOCK TABLES `mentor` WRITE;
/*!40000 ALTER TABLE `mentor` DISABLE KEYS */;
INSERT INTO `mentor` VALUES (1,'balu9198@gmail.com','12345678912',1234,1),(2,'balua9198@gmail.com','12345678912',1234,5),(3,'asdfbalu9198@gmail.com','12345678912',1234,1),(4,'asdfweqwreerewr','10:00-12:00',123,22),(5,'asdahkjfhkllh','10:00-12:00',12,23),(6,'sadfacccccc','17:00-19:00',123,24),(7,'uuuuuu','14:00-16:00',1,25),(8,'youtube','14:00-16:00',12,26),(9,'ttttttt','10:00-12:00',12,27),(10,'qwqeqwqwq','14:00-16:00',123,28),(11,'cccccc','10:00-12:00',1,29),(12,'oooooo','14:00-16:00',12,30),(13,'asdfajdshashd','14:00-16:00',123,31),(14,'asdffas','14:00-16:00',123,32),(15,'ggggggg','14:00-16:00',12,33),(16,'seed@linkedin','10:00-12:00',12,34),(17,'cvcv@likndfsjk','14:00-16:00',12,35),(18,'asdsafd','14:00-16:00',123,36),(19,'dededede','14:00-16:00',123,37),(20,'kkkkk@linkedin','14:00-16:00',1,38),(21,'xcxzc','10:00-12:00',12,39),(22,'asdftrt','14:00-16:00',12,40),(23,'harshaasda@linkedin','20:00-22:00',1,41),(24,'aravind@linkedin','17:00-19:00',1,42),(25,'oneplus@linkedin.com','10:00-12:00',1,43),(26,'zaheer@linkedin','14:00-16:00',1,44),(27,'rama2791@linkedin','14:00-16:00',12,45);
/*!40000 ALTER TABLE `mentor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_skill`
--

DROP TABLE IF EXISTS `mentor_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentor_skill` (
  `ms_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ms_self_rating` float(2,1) NOT NULL,
  `ms_years_of_experience` float(2,1) NOT NULL,
  `ms_mentor_id` bigint(20) NOT NULL,
  `ms_skill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ms_id`),
  KEY `FKtnf1q2bkex81ftw7t7omvb83l` (`ms_mentor_id`),
  KEY `FKqcj1pqkrdlvbu4nkiqvc8q3io` (`ms_skill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_skill`
--

LOCK TABLES `mentor_skill` WRITE;
/*!40000 ALTER TABLE `mentor_skill` DISABLE KEYS */;
INSERT INTO `mentor_skill` VALUES (1,1.0,1.0,1,2),(2,1.0,1.0,1,4),(3,1.0,1.0,22,2),(4,1.0,1.0,23,4),(17,5.0,5.0,2,4),(13,5.0,4.0,27,5),(11,1.0,1.0,25,4),(15,2.0,2.0,2,5),(16,3.0,3.0,27,2);
/*!40000 ALTER TABLE `mentor_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(255) NOT NULL,
  `skill_toc` varchar(255) DEFAULT NULL,
  `skill_prerequisite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`skill_id`),
  KEY `FKlwmdyofh8pruxjahcf88weuuv` (`skill_prerequisite`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (2,'Angular',NULL,NULL),(4,'JWT',NULL,NULL),(5,'HIbernate',NULL,NULL);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training` (
  `training_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `training_end_date` date NOT NULL,
  `training_progress` int(11) NOT NULL,
  `training_rating` float DEFAULT NULL,
  `training_start_date` date NOT NULL,
  `training_status` varchar(20) NOT NULL,
  `training_mentor_id` bigint(20) NOT NULL,
  `training_skill_id` bigint(20) NOT NULL,
  `training_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`training_id`),
  KEY `FKb9n4i7r331uhflndhjj64kgr9` (`training_mentor_id`),
  KEY `FK8dfju72gnd7gmvmjhcjyjv1p` (`training_skill_id`),
  KEY `FKbesfm9lgjyrcjrn45gkjv5lci` (`training_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'2019-12-13',0,0,'2019-12-11','Request Pending',24,3,1),(2,'2019-12-12',0,0,'2019-12-11','Request Pending',1,4,1),(3,'2019-12-12',0,0,'2019-12-11','Accepted',26,3,5),(4,'2019-12-13',0,0,'2019-12-12','Accepted',2,3,1),(5,'2019-12-13',0,0,'2019-12-12','Accepted',2,2,1),(6,'2019-12-13',0,0,'2019-12-12','Request Pending',1,2,1),(7,'2019-12-13',0,0,'2019-12-12','Accepted',23,4,1),(8,'2019-12-13',0,0,'2019-12-12','Request Pending',1,2,1),(9,'2019-12-13',0,0,'2019-12-12','Accepted',27,5,1),(10,'2019-12-13',0,0,'2019-12-12','Denied',27,5,1);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_contact_number` bigint(20) NOT NULL,
  `user_first_name` varchar(25) NOT NULL,
  `user_last_name` varchar(25) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_reset_password` tinyint(2) DEFAULT NULL,
  `user_reset_password_date` date DEFAULT NULL,
  `user_role` varchar(255) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,9100560867,'balaji','balu','$2a$10$u39yIfWNnQaMG5OfRqKMS.37A4Q5hariPz4BNQTRtNEx1da/RFvoO',0,'2012-12-12','user','user'),(7,1231231231,'asdasdasd','asd','$2a$10$7KP2SyNRUAORQJaOFokvHOSrUH3nl1FpYfIK.zollWWP1YGdPqroS',0,NULL,'mentor','gdfg'),(6,1234233232,'asd','asd','$2a$10$aBGIZd243jG0PeneUraPF.MHykwfz6/2kClJybr61FrBpnBy2uH2a',0,NULL,'Mentor','asdf'),(5,9100560867,'mentor','ironman','$2a$10$0d8pXtKbJvt3OjYfTT0Z3uHeywRCkURTcNpiAx9/qOF6Lv..HPamy',0,NULL,'Mentor','mentor'),(8,1231231223,'dsfsdf','sdf','$2a$10$qKgjYiVhWxxPoXv6FZEZl.RUiE9Zol6Bl6qUPJ9yMBf.SZHkhjRPG',0,NULL,'Mentor','sdffds'),(9,1212121212,'asdasd','asd','$2a$10$ysVqhxix1901kEfW2LTQmOoHfp9RG96TZq53.HohFoTtQ5nBWsfCy',0,NULL,'Mentor','adfadfadfa'),(10,1212121212,'asdas','dddd','$2a$10$56ad2tx7.iP6ZtBlkHswL.UC0qvpZioIeIROUgJfbFY50IvSuhTzu',0,NULL,'Mentor','sadasdasd'),(11,1232123123,'asdasds','dad','$2a$10$M6P9zvIj6DoyWuhhJYTvJO2tkXp6NcTh3IFUrnhPV62IgBLi/ZF8i',0,NULL,'Mentor','sadasdasdasdsad'),(12,1212121212,'aaaaa','aaaaa','$2a$10$ZmbaCSdej8RMy.jLZd3VTeKWx/BJfwlvy5Ig2n.UU5TDTZsLsfS9O',0,NULL,'Mentor','aaa'),(13,1211111111,'asdfas','asdsda','$2a$10$ETaKasLB5KMgUxNUAlEqnuafDJsXFOBRI8fRQxmQl0mw5mol14SMu',0,NULL,'Mentor','asfdfdf'),(14,9100560867,'asdf','asdf','$2a$10$hyWEaa5qKSXr0m8eHyyZke7u69KaD0SXTFp36GT6rZml2t6rZDjja',0,NULL,'user','user456'),(15,1231221212,'saddf','asdasd','$2a$10$ltpCuL40tISlL48aii0b.ejjf0gravPMvkqCRPAKuBjHOP1Ieyf3S',0,NULL,'user','userasd456'),(31,1232121212,'thor','hammer','$2a$10$W1HxE14t0lczkmm0VvgcteZ0DFhex/nRJEffWfv2HLSP.7/y/2YoG',0,NULL,'Mentor','unknown'),(39,1234123123,'ccxz','zxczxc','$2a$10$kTyK3w0rci34CX1WaW0a3OGAri4CiZiYx4g.71MffkaP7PpIKVDv2',0,NULL,'Mentor','zxczxczx'),(40,1231121221,'Cricket','Fan','$2a$10$mvjUJFdD2hRfM24/amyVdeMqUuXywu0ZzBpaPXTO6Z8a488ICgNN.',0,NULL,'Mentor','cricket'),(41,9100560867,'mike','hussey','$2a$10$91dCJ8IIjvY1PpcOqd8LJuivb2uGuEbzTebN7fiWaO5jO4BjJEUHK',0,NULL,'Mentor','harsha1234'),(42,9100560867,'asdasd','asdasasd','$2a$10$i2me.TkXa4Dc7OhJvVkMButVUkEQbB7ZCnyozVNotQbUbIoQHSTBa',0,NULL,'Mentor','aravind123'),(43,9100560867,'asdasd','asdasd','$2a$10$/e3earVsVu7Y2y/lNaEp4eMXiowIGd2p1a8Uqk3.NrhqMZg7s.4tK',0,NULL,'Mentor','oneplus'),(44,9100560867,'asdfasd','asdasd','$2a$10$4TWxhjATCQ7W83SOsP7z1uVlUAETCYFWWdzyP0eYbZgB6W7XARwfi',0,NULL,'Mentor','zaheer'),(45,9100560867,'rama','ramaa','$2a$10$8Vo1h69HcyZtOX9e9/I0UeLCdQK7MJFU2G2a8H2gZEXV7MzxcwmCG',0,NULL,'Mentor','rama'),(46,9100560867,'asdasd','asd','$2a$10$O4qdNuURASDCUuKsHDXx1uld5txyPTiM9BYy3FIDncELoD5VET22.',0,NULL,'user','testUser');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 12:49:21
