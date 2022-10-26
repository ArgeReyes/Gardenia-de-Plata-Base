-- MariaDB dump 10.19  Distrib 10.6.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: gardenia
-- ------------------------------------------------------
-- Server version	10.6.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `Proveedor_ID` int(11) NOT NULL,
  `Usuario_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Compra_Proveedor1_idx` (`Proveedor_ID`),
  KEY `fk_Compra_Usuario1_idx` (`Usuario_ID`),
  CONSTRAINT `fk_Compra_Proveedor1` FOREIGN KEY (`Proveedor_ID`) REFERENCES `proveedor` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Usuario1` FOREIGN KEY (`Usuario_ID`) REFERENCES `usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle venta`
--

DROP TABLE IF EXISTS `detalle venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle venta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Venta_ID` int(11) NOT NULL,
  `Producto_ID` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Venta_has_Producto_Producto1_idx` (`Producto_ID`),
  KEY `fk_Venta_has_Producto_Venta_idx` (`Venta_ID`),
  CONSTRAINT `fk_Venta_has_Producto_Producto1` FOREIGN KEY (`Producto_ID`) REFERENCES `producto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_has_Producto_Venta` FOREIGN KEY (`Venta_ID`) REFERENCES `venta` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle venta`
--

LOCK TABLES `detalle venta` WRITE;
/*!40000 ALTER TABLE `detalle venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compra` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Producto_ID` int(11) NOT NULL,
  `Compra_ID` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Producto_has_Compra_Compra1_idx` (`Compra_ID`),
  KEY `fk_Producto_has_Compra_Producto1_idx` (`Producto_ID`),
  CONSTRAINT `fk_Producto_has_Compra_Compra1` FOREIGN KEY (`Compra_ID`) REFERENCES `compra` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Compra_Producto1` FOREIGN KEY (`Producto_ID`) REFERENCES `producto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `consignacion` tinyint(4) DEFAULT NULL,
  `existencia` int(11) DEFAULT NULL,
  `material` varchar(50) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `costo` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (11,'Rubí',0,32,'Finos Realces','2022-03-13',2455,25),(35,'Atardecer de oro',0,45,'Oro','2022-03-12',2000,12),(37,'Open',0,0,'Oro',NULL,10000,23),(39,'Amaterasu',0,0,'Oro',NULL,10000,32),(41,'Comprobación',0,21,'Jade','2022-03-12',20000,22),(43,'A2',0,40,'Jade','2022-04-11',23333,21),(44,'B1',0,0,'Jade',NULL,2000,21),(46,'B2',0,7,'Fuego','2022-02-01',10000,21),(47,'Yuma',0,0,'Diamantes',NULL,21000,21),(48,'Yonka',0,0,'Diamantes',NULL,10000,3),(49,'C1',0,0,'Jade',NULL,50000,20),(50,'C2',0,0,'Oro',NULL,3000,12),(51,'C3',0,0,'Diamante',NULL,32000,100);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `consigna` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Cementos Progreso','455256',1),(5,' Center Fundation','23344345',1),(7,'A2','21345654',1),(8,'B1','34543455',0),(9,' B2','45534323',0),(10,'Ornamentas','34543454',0),(11,'Ingrid','23234454',0),(12,'Argentina','45091233',1),(13,'Luisito','45678909',1);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','827ccb0eea8a706c4c34a16891f84e7b'),(2,'Worbencho','827ccb0eea8a706c4c34a16891f84e7b'),(3,'El pistolas','a4757d7419ff3b48e92e90596f0e7548'),(4,'Iván','572d4e421e5e6b9bc11d815e8a027112'),(6,'Jairo','827ccb0eea8a706c4c34a16891f84e7b');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendedor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (12,'Juan Perez','15253665'),(13,'Amarilis','45256552'),(14,'Marti','55555555'),(15,'Omar','23434554'),(16,' Alejandro','34543212'),(17,'Ingrid','23434344');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `Descuento_ID` int(11) NOT NULL,
  `Vendedor_ID` int(11) NOT NULL,
  `Usuario_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Venta_Vendedor1_idx` (`Vendedor_ID`),
  KEY `fk_Venta_Usuario1_idx` (`Usuario_ID`),
  CONSTRAINT `fk_Venta_Usuario1` FOREIGN KEY (`Usuario_ID`) REFERENCES `usuario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Vendedor1` FOREIGN KEY (`Vendedor_ID`) REFERENCES `vendedor` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,5000,NULL,20,13,2),(2,50000,'2022-05-06',50,13,4),(5,5000,'2022-09-14',5,12,1),(13,5000,'2022-09-14',5,12,1),(18,1000,'2022-09-14',5,13,1),(20,30000,'2022-09-14',5,13,3),(21,20000,'2022-09-14',5,13,3),(22,20000,'2022-09-14',5,13,3);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Agregarventa
BEFORE INSERT ON Venta
FOR EACH ROW
BEGIN
	SET NEW.fecha = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 12:49:59
