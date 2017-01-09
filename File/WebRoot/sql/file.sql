-- MySQL dump 10.13  Distrib 5.1.48, for Win32 (ia32)
--
-- Host: 192.168.33.220    Database: filemanager
-- ------------------------------------------------------
-- Server version	5.1.48-community

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
-- Table structure for table `fileinfo`
--

DROP TABLE IF EXISTS `fileinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fileinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department` varchar(50) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  `info` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fileinfo`
--

LOCK TABLES `fileinfo` WRITE;
/*!40000 ALTER TABLE `fileinfo` DISABLE KEYS */;
INSERT INTO `fileinfo` VALUES (1,'xueshubu  ','lisi',' Joe and I decided to take the long trip we\'d always wanted across the country. We were like young kids buying our camper and stocking it with all the necessities of life. Bella bakes the best rhubarb pie. We started out in early spring from Minneapolis and headed west across the northern part of the country'),(2,'caiwubu   ','wangwu','We both enjoyed those people we met at the trailer park. Joe received a watch at his retirement dinner. To our surprise, we found that we liked the warm southern regions very much, and so we decided to stay here in New Mexico'),(3,'qiyefazhanbu','zhaoliu','My name is Roseanna, and I like to keep physically fit. I used to weigh two hundred pounds, but I joined the YMCA for an exercise class and diet program. In one year I lost eighty pounds. I feel much better and never want to have that much weight on my five-feet frame again.'),(4,'shichangbu','xueqi','I bought two new suitcases last week. Everyday I practice jogging three miles, swimming fifteen laps, lifting twenty-pound weights and playing tennis for one hour. My mother was a premature baby. ');
/*!40000 ALTER TABLE `fileinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fileuploads`
--

DROP TABLE IF EXISTS `fileuploads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fileuploads` (
  `file_id` int(100) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NOT NULL,
  `department` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `position` varchar(30) NOT NULL,
  `path` varchar(100) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `content_type` varchar(50) NOT NULL,
  `uploadstime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fileuploads`
--

LOCK TABLES `fileuploads` WRITE;
/*!40000 ALTER TABLE `fileuploads` DISABLE KEYS */;
INSERT INTO `fileuploads` VALUES (2,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241537.JPG','image/pjpeg','20110224'),(3,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241539.jpg','image/pjpeg','20110224'),(4,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241600.JPG','image/pjpeg','20110224'),(5,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241601.JPG','image/pjpeg','20110224'),(6,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241602.jpg','image/pjpeg','20110224'),(8,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241607.exe','application/octet-stream','20110224'),(12,6001,'dongshihui','zhangsan','boss','E:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241639.doc','application/msword','20110224'),(13,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102241639.jpg','image/pjpeg','20110224'),(19,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251058.java','text/plain','20110225'),(20,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251103.JPG','image/pjpeg','20110225'),(21,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251104.java','text/plain','20110225'),(26,2001,'shichangbu','xueqi','manager','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251425.jpg','image/pjpeg','20110225'),(30,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251533.jpg','image/pjpeg','20110225'),(31,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251534.JPG','image/pjpeg','20110225'),(32,2100,'shichangbu','AA','employee','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251613.JPG','image/pjpeg','20110225'),(33,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201102251614.java','text/plain','20110225'),(34,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103010916.jpg','image/pjpeg','20110301'),(35,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103010917.jpg','image/pjpeg','20110301'),(36,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103010917.jpg','image/pjpeg','20110301'),(37,6001,'dongshihui','zhangsan','boss','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103010919.jpg','image/pjpeg','20110301'),(40,5001,'xueshubu','lisi','manager','d:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011107.txt','text/plain','20110301'),(41,4003,'xueshubu','sffs','employee','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011124.jpg','image/pjpeg','20110301'),(42,4003,'xueshubu','sffs','employee','d:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011125.txt','text/plain','20110301'),(43,5101,'xueshubu','b','employee','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011136.java','text/plain','20110301'),(44,4003,'xueshubu','sffs','employee','D:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011137.java','text/plain','20110301'),(46,5101,'xueshubu','b','employee','E:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103011418.doc','application/msword','20110301'),(47,5101,'xueshubu','b','employee','C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\File\\file_upload\\','201103010630.exe','application/octet-stream','20110301');
/*!40000 ALTER TABLE `fileuploads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `eid` int(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `employedtime` varchar(20) DEFAULT NULL,
  `telphone` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4002,'df','df','shichangbu','manager','20000101','12413','000000'),(4003,'sffs','female','xueshubu','employee','20101212','123245','000000'),(4004,'asd','female','qiyebu','manager','12311212','13546','000000'),(5001,'lisi','male','xueshubu','manager','20101212','123456','000000'),(5100,'a','female','xueshubu','employee','20100230','5464645','000000'),(5101,'b','male','xueshubu','employee','20100602','4575858','000000'),(6001,'zhangsan','male','dongshihui','boss','20101212','46546','000000');
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

-- Dump completed on 2011-03-01 14:32:47
