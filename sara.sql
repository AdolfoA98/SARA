-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: sara-bd
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `matricula` varchar(13) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contrasena` varchar(90) NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `numeroFactura` int(9) NOT NULL,
  `fechaFacturacion` date NOT NULL,
  `concepto` text NOT NULL,
  `totalImpuestosAñadidos` double NOT NULL,
  `direccionAlmacenamiento` text NOT NULL,
  `diasRenta` int(11) NOT NULL,
  `Vehiculo_noMotor` varchar(25) NOT NULL,
  `Usuario_rfc` varchar(13) NOT NULL,
  `lugarEntrega` text NOT NULL,
  PRIMARY KEY (`numeroFactura`,`Vehiculo_noMotor`,`Usuario_rfc`),
  KEY `fk_Factura_Vehiculo1_idx` (`Vehiculo_noMotor`),
  KEY `fk_Factura_Usuario1_idx` (`Usuario_rfc`),
  CONSTRAINT `fk_Factura_Usuario1` FOREIGN KEY (`Usuario_rfc`) REFERENCES `usuario` (`rfc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Vehiculo1` FOREIGN KEY (`Vehiculo_noMotor`) REFERENCES `vehiculo` (`noMotor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flotilla`
--

DROP TABLE IF EXISTS `flotilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flotilla` (
  `matriculaFlotilla` varchar(10) NOT NULL,
  `calleDireccion` varchar(45) NOT NULL,
  `coloniaDireccion` varchar(45) NOT NULL,
  `numeroDireccion` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `codigoPostal` varchar(5) NOT NULL,
  PRIMARY KEY (`matriculaFlotilla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flotilla`
--

LOCK TABLES `flotilla` WRITE;
/*!40000 ALTER TABLE `flotilla` DISABLE KEYS */;
INSERT INTO `flotilla` VALUES ('XLP0001','Av camacho','miraflorez','30','Xalapa','Veracruz','Mexico','91050');
/*!40000 ALTER TABLE `flotilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetacredito`
--

DROP TABLE IF EXISTS `tarjetacredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjetacredito` (
  `idTarjetaCredito` varchar(5) NOT NULL,
  `numeroTarjeta` int(16) NOT NULL,
  `cuatroDigitos` varchar(45) NOT NULL,
  `mesCaducidad` int(2) NOT NULL,
  `anoCaducidad` int(2) NOT NULL,
  `ccv` int(3) NOT NULL,
  `nombreTarjeta` varchar(70) NOT NULL,
  `Usuario_rfc` varchar(13) NOT NULL,
  PRIMARY KEY (`idTarjetaCredito`),
  KEY `fk_TarjetaCredito_Usuario1_idx` (`Usuario_rfc`),
  CONSTRAINT `fk_TarjetaCredito_Usuario1` FOREIGN KEY (`Usuario_rfc`) REFERENCES `usuario` (`rfc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetacredito`
--

LOCK TABLES `tarjetacredito` WRITE;
/*!40000 ALTER TABLE `tarjetacredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjetacredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `rfc` varchar(13) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `municipio` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `calleDireccion` varchar(60) NOT NULL,
  `colDireccion` varchar(60) NOT NULL,
  `numDireccion` int(4) NOT NULL,
  `codigoPostal` varchar(5) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `contrasena` varchar(90) NOT NULL,
  PRIMARY KEY (`rfc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('adolfo89','Adolfo','Cruz_Diaz','Xalapa','veracruz','emiliano zapata','zapata',14,'90130','Adolfo@hotmail.com','2288132456','holaquehace'),('Emp0347890001','Empresa','Empresa','Xalapa','Veracruz','Av Camacho','mira flores',30,'91050','empresa@org.com','8405060','EmpresaSara'),('jet011898','jethran','gomez','xalapa','veracruz','calle 3','juan de luz',15,'91160','jethran@hotmail.com','8909090','holabd'),('lucia234567','lucia','hernandez','xalapa','veracruz','ruiz cortinez','cortinez',47,'98989','lucia@outlook.com','7899089','holabd2');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `noMotor` varchar(25) NOT NULL,
  `climatizado` enum('si','no') NOT NULL,
  `transmision` enum('manual','auto') NOT NULL,
  `numPasajeros` int(11) NOT NULL,
  `numPuertas` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `version` varchar(45) NOT NULL,
  `kilometraje` double NOT NULL,
  `kml` double NOT NULL,
  `gps` enum('si','no') NOT NULL,
  `descripcion` text NOT NULL,
  `estado` enum('1','2','3','4') NOT NULL,
  `disponibilidad` enum('disponible','nodisponible') NOT NULL,
  `Flotilla_matriculaFlotilla` varchar(10) NOT NULL,
  `precioDia` double NOT NULL,
  `Thumbnail` text NOT NULL,
  `Cliente_rfc` varchar(13) NOT NULL,
  PRIMARY KEY (`noMotor`),
  KEY `fk_Vehiculo_Flotilla1_idx` (`Flotilla_matriculaFlotilla`),
  KEY `fk_Vehiculo_Cliente1_idx` (`Cliente_rfc`),
  CONSTRAINT `fk_Vehiculo_Cliente1` FOREIGN KEY (`Cliente_rfc`) REFERENCES `usuario` (`rfc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehiculo_Flotilla1` FOREIGN KEY (`Flotilla_matriculaFlotilla`) REFERENCES `flotilla` (`matriculaFlotilla`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES ('honda10156745','si','auto',4,4,'honda','1998','2',200,20,'si','es muy bonito por dentro','3','disponible','XLP0001',250,'imagen','Emp0347890001'),('nissan123456','si','auto',4,4,'nissan','1998','2',20000,20,'si','Es muy comodo y agradable','3','disponible','XLP0001',250,'imagen','jet011898');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-23 13:02:44
