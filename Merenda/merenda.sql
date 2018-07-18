-- MySQL dump 10.16  Distrib 10.1.34-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: merenda
-- ------------------------------------------------------
-- Server version	10.1.34-MariaDB

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
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `perecivel` tinyint(4) DEFAULT NULL,
  `qtd_atende` int(11) DEFAULT NULL,
  `medida` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fornecedor` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'Banana',1,100,'Quilograma (kg)','PalmTree S.A.','Braziliense'),(2,'Maça',1,30,'Quilograma (kg)','Isaac Newton S.A.','Argetzina'),(3,'Ovos',1,77,'Dúzia','Galinha Garnizé S.A.','Caipirinha'),(4,'Melancia',1,10,'Unidade','Magali S.A.','Vermelho por Dentro'),(5,'Cana de Açucar',0,2,'Metro (m)','Pão de Açucar S.A.','Canavial'),(7,'Feijão',0,120,'Quilograma (kg)','Zé do Caroço S.A.','Java Beans'),(46,'M',1,23,'Metro (m)','I','STCKAPAXPKTJHKEDQHXGUVCDU'),(180,'Macarrão',0,10,'Quilograma (kg)','Seu Zé','Massa do China'),(181,'Carne Moida',0,10,'Quilograma (kg)','Fazenda do João','Vaquinha'),(182,'Molho de tomate',0,10,'Quilograma (kg)','Extreme','Sadio');
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardapio`
--

DROP TABLE IF EXISTS `cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardapio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_instituicao` int(11) NOT NULL,
  `data_cardapio` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `lanche_manha` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `almoco` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lanche_tarde` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `janta` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cardapio_instituicao_idx` (`id_instituicao`),
  CONSTRAINT `fk_cardapio_instituicao` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapio`
--

LOCK TABLES `cardapio` WRITE;
/*!40000 ALTER TABLE `cardapio` DISABLE KEYS */;
INSERT INTO `cardapio` VALUES (1,2,'12/07/2018','maça com banana','strognoff de frango','banana com maça','caldo de cana'),(2,2,'13/07/2018','banana','arroz com feijão','melancia','macarrão'),(3,2,'14/07/2018','feijão com banana','macarrão com caldo de cana',NULL,NULL);
/*!40000 ALTER TABLE `cardapio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id_pessoa` int(11) NOT NULL,
  `id_instituicao` int(11) NOT NULL,
  `id_tipo_conta` int(11) DEFAULT NULL,
  `matricula` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usuario` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`,`id_instituicao`),
  KEY `fk_conta_instituicao_idx` (`id_instituicao`),
  KEY `fk_conta_tipo_idx` (`id_tipo_conta`),
  CONSTRAINT `fk_conta_instituicao` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_conta_pessoa` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_conta_tipo` FOREIGN KEY (`id_tipo_conta`) REFERENCES `tipo_conta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,1,1,'1001001001','root','48A538310CCA5506BBFF12908F6B5F1B'),(2,3,3,'5647389201','lei','640FA97CD253EBCC6BA6F195E2E372A9'),(3,2,2,'1029387456','dir','114D4B88B648593D797FC7F8313D2755'),(214,163,1,'9464235795','MFJQPHI','347336E107D27CC23137A9FDB8130A91'),(515,367,2,'1234512345','Fei','B17C4B7AAFB46D78F487BC4B1F4657BC');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_alimento` int(11) NOT NULL,
  `id_instituicao` int(11) NOT NULL,
  `data` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qtd_alimento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_entrada_alimento_idx` (`id_alimento`),
  KEY `fk_entrada_instituicao_idx` (`id_instituicao`),
  CONSTRAINT `fk_entrada_alimento` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrada_instituicao` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,1,1,'10/07/2018',50),(2,2,1,'12/07/2018',5),(3,180,367,'23/07/2018',15),(4,181,367,'23/07/2018',15),(5,182,367,'23/07/2018',15);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrega`
--

DROP TABLE IF EXISTS `entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrega` (
  `id_pedido` int(11) NOT NULL,
  `data_entrega` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fornecedor` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  CONSTRAINT `fk_entrega_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrega`
--

LOCK TABLES `entrega` WRITE;
/*!40000 ALTER TABLE `entrega` DISABLE KEYS */;
INSERT INTO `entrega` VALUES (1,'12/07/2018','Milionário e José Rico'),(2,'23/07/2018','Caminhões do seu Bino');
/*!40000 ALTER TABLE `entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo` int(11) NOT NULL,
  `nome` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `inep` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endereco` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qtd_alunos` int(11) DEFAULT NULL,
  `telefone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`id_tipo`),
  KEY `fk_instituicao_tipo_idx` (`id_tipo`),
  CONSTRAINT `fk_instituicao_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=368 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituicao`
--

LOCK TABLES `instituicao` WRITE;
/*!40000 ALTER TABLE `instituicao` DISABLE KEYS */;
INSERT INTO `instituicao` VALUES (1,1,'efaefaaef','12345678','Rua da Ouvidor',50,'2140028922'),(2,2,'Escolinha do professor Raimundo','98172487','Rua dos Guajajaras',1500,'9867432323'),(3,4,'Escolinha do Prof Girafales','12345812','Vila do Chavez',300,'3255543212'),(49,2,'QORHSSDFTKJIUEU','66777111','JILFRFCHXE',22,'1558481611'),(112,3,'VUMBCEOFCILRLVSUXPMCV','69172576','IJFIBMTBZVXBIJT',15,'77505228521'),(163,4,'EODVGOVPDQFVXMR','82526717','JBXDXZHLIEEUFQ',4,'6577962405'),(264,2,'PCMIVMLCBISOAJRVOIS','92541563','EBXSFKCILXZPZKXZEDFTZGGKJLCKVZIIPERUZVZIOFDTBRVAIP',16,'7053587493'),(365,2,'KFVTZHTLAXU','44732100','JPHZJTRVKZFSAUHJUBDLHBFCBXKDVRKRBCPCQAFVBZGKZDEEQP',3,'25750648657'),(367,1,'Colegio Santa Tereza','43567254','Rua Santo Agostinho',123,'2198134589');
/*!40000 ALTER TABLE `instituicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote_estoque`
--

DROP TABLE IF EXISTS `lote_estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lote_estoque` (
  `id` int(11) NOT NULL,
  `id_alimento` int(11) NOT NULL,
  `qtd_alimento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_alimento`),
  KEY `fk_lote_estoque_alimento_idx` (`id_alimento`),
  CONSTRAINT `fk_lote_estoque_alimento` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lote_estoque_instituicao` FOREIGN KEY (`id`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote_estoque`
--

LOCK TABLES `lote_estoque` WRITE;
/*!40000 ALTER TABLE `lote_estoque` DISABLE KEYS */;
INSERT INTO `lote_estoque` VALUES (1,1,'40'),(1,2,'5'),(367,180,'15'),(367,181,'15'),(367,182,'15');
/*!40000 ALTER TABLE `lote_estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote_pedido`
--

DROP TABLE IF EXISTS `lote_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lote_pedido` (
  `id` int(11) NOT NULL,
  `id_alimento` int(11) NOT NULL,
  `qtd_alimento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_alimento`),
  KEY `fk_lote_pedido_idx` (`id`),
  KEY `fk_lote_alimento_idx` (`id_alimento`),
  CONSTRAINT `fk_lote_alimento` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lote_pedido` FOREIGN KEY (`id`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote_pedido`
--

LOCK TABLES `lote_pedido` WRITE;
/*!40000 ALTER TABLE `lote_pedido` DISABLE KEYS */;
INSERT INTO `lote_pedido` VALUES (1,2,5),(2,180,15),(2,181,15),(2,182,15);
/*!40000 ALTER TABLE `lote_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_instituicao` int(11) NOT NULL,
  `data` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_instituicao_idx` (`id_instituicao`),
  CONSTRAINT `fk_pedido_instituicao` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1,'11/07/2018'),(2,367,'20/07/2018');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=516 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'admin','10010010023'),(2,'Matheus Feitosa','41239941231'),(3,'Victor Lento','65512341253'),(105,'mat','12345678912'),(163,'M','86109312756'),(214,'VBIDRMUUZRUPFBIPSDGJXXFJPHOFQKDZBHAIXBIFUGXQ','11209956036'),(515,'Matheus Feitosao','12345678912');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_alimento` int(11) DEFAULT NULL,
  `id_instituicao` int(11) DEFAULT NULL,
  `data` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qtd_alimento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_saida_alimento_idx` (`id_alimento`),
  KEY `fk_saida_instituicao_idx` (`id_instituicao`),
  CONSTRAINT `fk_saida_alimento` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_saida_instituicao` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
INSERT INTO `saida` VALUES (1,1,1,'10/07/2018',10);
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salt`
--

DROP TABLE IF EXISTS `salt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salt` (
  `id` int(11) NOT NULL,
  `salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salt`
--

LOCK TABLES `salt` WRITE;
/*!40000 ALTER TABLE `salt` DISABLE KEYS */;
INSERT INTO `salt` VALUES (0,'ecoieno1in1od39doa3hd1o');
/*!40000 ALTER TABLE `salt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_conta`
--

DROP TABLE IF EXISTS `tipo_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_conta`
--

LOCK TABLES `tipo_conta` WRITE;
/*!40000 ALTER TABLE `tipo_conta` DISABLE KEYS */;
INSERT INTO `tipo_conta` VALUES (1,'Administrador'),(2,'Diretor'),(3,'Leitor');
/*!40000 ALTER TABLE `tipo_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_instituicao`
--

DROP TABLE IF EXISTS `tipo_instituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_instituicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_instituicao`
--

LOCK TABLES `tipo_instituicao` WRITE;
/*!40000 ALTER TABLE `tipo_instituicao` DISABLE KEYS */;
INSERT INTO `tipo_instituicao` VALUES (1,'Secretaria de Educação'),(2,'Escola Tipo A'),(3,'Escola Tipo B'),(4,'Escola Tipo C');
/*!40000 ALTER TABLE `tipo_instituicao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-18  9:09:35
