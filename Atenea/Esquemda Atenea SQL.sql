/*
SQLyog Community Edition- MySQL GUI v8.05 
MySQL - 5.1.49-1ubuntu8.1 : Database - atenea
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`atenea` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `atenea`;

/*Table structure for table `gpp_cargoequivalente` */

DROP TABLE IF EXISTS `gpp_cargoequivalente`;

CREATE TABLE `gpp_cargoequivalente` (
  `ceq_nidcargoeq` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ceq_vcargoeq` varchar(60) NOT NULL,
  `ceq_vusucrea` varchar(60) NOT NULL,
  `ceq_dfeccrea` datetime NOT NULL,
  `ceq_vusumodifica` varchar(60) DEFAULT NULL,
  `ceq_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`ceq_nidcargoeq`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_cargoequivalente` */

LOCK TABLES `gpp_cargoequivalente` WRITE;

insert  into `gpp_cargoequivalente`(`ceq_nidcargoeq`,`ceq_vcargoeq`,`ceq_vusucrea`,`ceq_dfeccrea`,`ceq_vusumodifica`,`ceq_dfecmodifica`) values (1,'Gerente de Proyectos','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Coordinador de Proyectos','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Operativo','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Técnico','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_departamento` */

DROP TABLE IF EXISTS `gpp_departamento`;

CREATE TABLE `gpp_departamento` (
  `dpt_niddepto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pai_nidpais` int(10) unsigned NOT NULL,
  `dpt_vdepto` varchar(60) NOT NULL,
  `dpt_vusucrea` varchar(60) NOT NULL,
  `dpt_dfeccrea` datetime NOT NULL,
  `dpt_vusumodifica` varchar(60) DEFAULT NULL,
  `dpt_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`dpt_niddepto`),
  KEY `gpp_departamento_FKIndex1` (`pai_nidpais`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_departamento` */

LOCK TABLES `gpp_departamento` WRITE;

insert  into `gpp_departamento`(`dpt_niddepto`,`pai_nidpais`,`dpt_vdepto`,`dpt_vusucrea`,`dpt_dfeccrea`,`dpt_vusumodifica`,`dpt_dfecmodifica`) values (1,1,'Amazonas','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,1,'Antioquia','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,1,'Arauca','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,1,'Atlantico','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,1,'Boyacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,1,'Caldas','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,1,'Caquetá','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,1,'Casanare','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,1,'Cauca','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,1,'Cesar','hrojas','2010-01-01 00:00:00',NULL,NULL),(11,1,'Chocó','hrojas','2010-01-01 00:00:00',NULL,NULL),(13,1,'Córdoba','hrojas','2010-01-01 00:00:00',NULL,NULL),(12,1,'Cundinamarca','hrojas','2010-01-01 00:00:00',NULL,NULL),(14,1,'Guainía','hrojas','2010-01-01 00:00:00',NULL,NULL),(15,1,'Guaviare','hrojas','2010-01-01 00:00:00',NULL,NULL),(16,1,'Huila','hrojas','2010-01-01 00:00:00',NULL,NULL),(17,1,'La Guajira','hrojas','2010-01-01 00:00:00',NULL,NULL),(18,1,'Magdalena','hrojas','2010-01-01 00:00:00',NULL,NULL),(19,1,'Meta','hrojas','2010-01-01 00:00:00',NULL,NULL),(20,1,'Nariño','hrojas','2010-01-01 00:00:00',NULL,NULL),(21,1,'Norte de Santander','hrojas','2010-01-01 00:00:00',NULL,NULL),(22,1,'Putumayo','hrojas','2010-01-01 00:00:00',NULL,NULL),(23,1,'Quindío','hrojas','2010-01-01 00:00:00',NULL,NULL),(24,1,'Risaralda','hrojas','2010-01-01 00:00:00',NULL,NULL),(25,1,'San Andrés','hrojas','2010-01-01 00:00:00',NULL,NULL),(26,1,'Santafé de Bogotá','hrojas','2010-01-01 00:00:00',NULL,NULL),(27,1,'Santander','hrojas','2010-01-01 00:00:00',NULL,NULL),(28,1,'Sucre','hrojas','2010-01-01 00:00:00',NULL,NULL),(29,1,'Tolima','hrojas','2010-01-01 00:00:00',NULL,NULL),(30,1,'Valle','hrojas','2010-01-01 00:00:00',NULL,NULL),(31,1,'Vaupés','hrojas','2010-01-01 00:00:00',NULL,NULL),(32,1,'Vichada','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_documento` */

DROP TABLE IF EXISTS `gpp_documento`;

CREATE TABLE `gpp_documento` (
  `doc_niddocumento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `per_nidpersona` int(10) unsigned NOT NULL,
  `tar_nidtipoarchivo` int(10) unsigned NOT NULL,
  `doc_vnombre` varchar(120) NOT NULL,
  `doc_varchivo` varchar(120) DEFAULT NULL,
  `doc_vurlarchivo` varchar(255) DEFAULT NULL,
  `doc_dfecexpide` date NOT NULL,
  `doc_vusucrea` varchar(120) NOT NULL,
  `doc_dfeccrea` datetime NOT NULL,
  `doc_vusumodifica` varchar(120) DEFAULT NULL,
  `doc_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`doc_niddocumento`),
  KEY `gpp_documento_FKIndex1` (`tar_nidtipoarchivo`),
  KEY `gpp_documento_FKIndex2` (`per_nidpersona`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_documento` */

LOCK TABLES `gpp_documento` WRITE;

UNLOCK TABLES;

/*Table structure for table `gpp_estadocivil` */

DROP TABLE IF EXISTS `gpp_estadocivil`;

CREATE TABLE `gpp_estadocivil` (
  `esc_nidestadocivil` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `esc_vestadocivil` varchar(60) NOT NULL,
  `esc_vusucrea` varchar(60) NOT NULL,
  `esc_dfeccrea` datetime NOT NULL,
  `esc_vusumodifica` varchar(60) DEFAULT NULL,
  `esc_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`esc_nidestadocivil`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_estadocivil` */

LOCK TABLES `gpp_estadocivil` WRITE;

insert  into `gpp_estadocivil`(`esc_nidestadocivil`,`esc_vestadocivil`,`esc_vusucrea`,`esc_dfeccrea`,`esc_vusumodifica`,`esc_dfecmodifica`) values (1,'Casado/a','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Divorciado/a','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Unión Libre','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Separado/a','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Soltero/a','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,'Prueba','hrojas','2010-08-31 00:00:00','hrojas','2010-08-31 00:00:00');

UNLOCK TABLES;

/*Table structure for table `gpp_experiencia` */

DROP TABLE IF EXISTS `gpp_experiencia`;

CREATE TABLE `gpp_experiencia` (
  `exp_nidexplaboral` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `per_nidpersona` int(10) unsigned NOT NULL,
  `gpp_municipio_mun_vidmunicipio` varchar(3) NOT NULL,
  `doc_ncertifica1` int(10) unsigned DEFAULT NULL,
  `doc_ncertifica2` int(10) unsigned DEFAULT NULL,
  `exp_vnomempresa` varchar(120) NOT NULL,
  `exp_vtelempresa` varchar(120) DEFAULT NULL,
  `exp_vnomcontacto` varchar(120) DEFAULT NULL,
  `exp_vemailcontacto` varchar(120) DEFAULT NULL,
  `exp_vcargo` varchar(120) NOT NULL,
  `ceq_nidcargoeq` int(10) unsigned NOT NULL,
  `exp_dfecingreso` date NOT NULL,
  `exp_dfecretiro` date DEFAULT NULL,
  `exp_vherrasw` varchar(255) DEFAULT NULL,
  `exp_vfuncionlogro` varchar(255) DEFAULT NULL,
  `exp_vusucrea` varchar(60) NOT NULL,
  `exp_dfeccrea` datetime NOT NULL,
  `exp_vusumodifica` varchar(60) DEFAULT NULL,
  `exp_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`exp_nidexplaboral`),
  KEY `gpp_experiencia_FKIndex1` (`ceq_nidcargoeq`),
  KEY `gpp_experiencia_FKIndex2` (`doc_ncertifica1`),
  KEY `gpp_experiencia_FKIndex3` (`doc_ncertifica2`),
  KEY `gpp_experiencia_FKIndex4` (`gpp_municipio_mun_vidmunicipio`),
  KEY `gpp_experiencia_FKIndex5` (`per_nidpersona`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_experiencia` */

LOCK TABLES `gpp_experiencia` WRITE;

UNLOCK TABLES;

/*Table structure for table `gpp_formacion` */

DROP TABLE IF EXISTS `gpp_formacion`;

CREATE TABLE `gpp_formacion` (
  `for_nidformacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `per_nidpersona` int(10) unsigned NOT NULL,
  `for_vtitulo` varchar(120) NOT NULL,
  `nac_nidnivelac` int(10) unsigned NOT NULL,
  `Ins_nidinstitucion` int(10) unsigned NOT NULL,
  `teq_nidtituloeq` int(10) unsigned NOT NULL,
  `for_dfecgrado` date NOT NULL,
  `for_vunidaddurac` varchar(1) DEFAULT NULL,
  `for_nduracion` int(10) unsigned DEFAULT NULL,
  `for_vtarjetaprof` varchar(60) DEFAULT NULL,
  `for_dfectarjeta` date DEFAULT NULL,
  `doc_ntarjetaprof` int(10) unsigned DEFAULT NULL,
  `doc_nactagrado` int(10) unsigned DEFAULT NULL,
  `doc_nidiploma` int(10) unsigned DEFAULT NULL,
  `for_vusucrea` varchar(60) NOT NULL,
  `for_dfeccrea` datetime NOT NULL,
  `for_vusumodifica` varchar(60) DEFAULT NULL,
  `for_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`for_nidformacion`),
  KEY `gpp_formacion_FKIndex1` (`Ins_nidinstitucion`),
  KEY `gpp_formacion_FKIndex2` (`nac_nidnivelac`),
  KEY `gpp_formacion_FKIndex3` (`teq_nidtituloeq`),
  KEY `gpp_formacion_FKIndex4` (`doc_nidiploma`),
  KEY `gpp_formacion_FKIndex5` (`doc_nactagrado`),
  KEY `gpp_formacion_FKIndex6` (`doc_ntarjetaprof`),
  KEY `gpp_formacion_FKIndex7` (`per_nidpersona`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_formacion` */

LOCK TABLES `gpp_formacion` WRITE;

UNLOCK TABLES;

/*Table structure for table `gpp_idioma` */

DROP TABLE IF EXISTS `gpp_idioma`;

CREATE TABLE `gpp_idioma` (
  `idi_nididioma` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idi_vidioma` varchar(60) NOT NULL,
  `idi_vusucrea` varchar(60) NOT NULL,
  `idi_dfeccrea` datetime NOT NULL,
  `idi_vusumodifica` varchar(60) DEFAULT NULL,
  `idi_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`idi_nididioma`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_idioma` */

LOCK TABLES `gpp_idioma` WRITE;

insert  into `gpp_idioma`(`idi_nididioma`,`idi_vidioma`,`idi_vusucrea`,`idi_dfeccrea`,`idi_vusumodifica`,`idi_dfecmodifica`) values (1,'Inglés','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Francés','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Alemán','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Mandarín','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Italiano','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'Ruso','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_institucion` */

DROP TABLE IF EXISTS `gpp_institucion`;

CREATE TABLE `gpp_institucion` (
  `ins_nidinstitucion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ins_vinstitucion` varchar(60) NOT NULL,
  `ins_vusucrea` varchar(60) NOT NULL,
  `ins_dfeccrea` datetime NOT NULL,
  `ins_vusumodifica` varchar(60) DEFAULT NULL,
  `ins_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`ins_nidinstitucion`)
) ENGINE=MyISAM AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_institucion` */

LOCK TABLES `gpp_institucion` WRITE;

insert  into `gpp_institucion`(`ins_nidinstitucion`,`ins_vinstitucion`,`ins_vusucrea`,`ins_dfeccrea`,`ins_vusumodifica`,`ins_dfecmodifica`) values (1,'Colegio de Estudios Superiores en Administración CESA ','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Colegio Mayor Nuestra Señora del Rosario ','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Colegio Universitario Colombiano (COLE ODONT COL) ','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Escuela Colombiana de Ingenieria ','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Escuela de Administracion de Negocios -EAN ','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'Escuela de Ingenieria de Antioquia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,'Escuela Superior de Administracion Publica -ESAP ','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,'Fundacion Escuela Colombiana de Rehabilitacion ','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,'Fundación Escuela de Medicina Juan N Corpas ','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,'Fundación Pontificia Bolivariana Medellín ','hrojas','2010-01-01 00:00:00',NULL,NULL),(11,'Fundacion Universidad Central ','hrojas','2010-01-01 00:00:00',NULL,NULL),(12,'Fundacion Universidad de Bogota \"Jorge Tadeo Lozano\" ','hrojas','2010-01-01 00:00:00',NULL,NULL),(13,'Fundacion Universidad de Manizales ','hrojas','2010-01-01 00:00:00',NULL,NULL),(14,'Fundación Universitaria Agraria de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(15,'Fundación Universitaria de Popayan ','hrojas','2010-01-01 00:00:00',NULL,NULL),(16,'Fundación Universitaria Los Libertadores ','hrojas','2010-01-01 00:00:00',NULL,NULL),(17,'Fundación Universitaria Manuela Beltran ','hrojas','2010-01-01 00:00:00',NULL,NULL),(18,'Fundación Universitaria Maria Cano Medellín ','hrojas','2010-01-01 00:00:00',NULL,NULL),(19,'Fundación Universitaria San Martín ','hrojas','2010-01-01 00:00:00',NULL,NULL),(20,'Instituto de Ciencias de la Salud hospital de san jose ','hrojas','2010-01-01 00:00:00',NULL,NULL),(21,'Lasalle College ','hrojas','2010-01-01 00:00:00',NULL,NULL),(22,'Politecnico Grancolombiano ','hrojas','2010-01-01 00:00:00',NULL,NULL),(23,'Pontificia Universidad Javeriana ','hrojas','2010-01-01 00:00:00',NULL,NULL),(24,'Royal & SunAlliance ','hrojas','2010-01-01 00:00:00',NULL,NULL),(25,'Taller 5 ','hrojas','2010-01-01 00:00:00',NULL,NULL),(26,'UNITEC ','hrojas','2010-01-01 00:00:00',NULL,NULL),(27,'Universidad Antonio Nariño ','hrojas','2010-01-01 00:00:00',NULL,NULL),(28,'Universidad Autonoma de Bucaramanga                     ','hrojas','2010-01-01 00:00:00',NULL,NULL),(29,'Universidad Autonoma de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(30,'Universidad Autonoma de Manizales ','hrojas','2010-01-01 00:00:00',NULL,NULL),(31,'Universidad Autonoma de Occidente - UAO ','hrojas','2010-01-01 00:00:00',NULL,NULL),(32,'Universidad Autonoma del Caribe                        ','hrojas','2010-01-01 00:00:00',NULL,NULL),(33,'Universidad Catolica de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(34,'Universidad Catolica de Manizales ','hrojas','2010-01-01 00:00:00',NULL,NULL),(35,'Universidad Católica Polular de Risaralda ','hrojas','2010-01-01 00:00:00',NULL,NULL),(36,'Universidad Colegio Mayor de Cundinamarca ','hrojas','2010-01-01 00:00:00',NULL,NULL),(37,'Universidad Cooperativa de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(38,'Universidad de América ','hrojas','2010-01-01 00:00:00',NULL,NULL),(39,'Universidad de Antioquia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(40,'Universidad de Caldas                                     ','hrojas','2010-01-01 00:00:00',NULL,NULL),(41,'Universidad de Cartagena                                ','hrojas','2010-01-01 00:00:00',NULL,NULL),(42,'Universidad de Ciencias Aplicadas y Ambientales -UDCA ','hrojas','2010-01-01 00:00:00',NULL,NULL),(43,'Universidad de Cordoba ','hrojas','2010-01-01 00:00:00',NULL,NULL),(44,'Universidad de Cundinamarca                           ','hrojas','2010-01-01 00:00:00',NULL,NULL),(45,'Universidad de Ibague -CORUNIVERSITARIA ','hrojas','2010-01-01 00:00:00',NULL,NULL),(46,'Universidad de la Amazonia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(47,'Universidad de la Sabana ','hrojas','2010-01-01 00:00:00',NULL,NULL),(48,'Universidad de la Salle ','hrojas','2010-01-01 00:00:00',NULL,NULL),(49,'Universidad de los Andes ','hrojas','2010-01-01 00:00:00',NULL,NULL),(50,'Universidad de Medellin ','hrojas','2010-01-01 00:00:00',NULL,NULL),(51,'Universidad de Nariño ','hrojas','2010-01-01 00:00:00',NULL,NULL),(52,'Universidad de Pamplona                                  ','hrojas','2010-01-01 00:00:00',NULL,NULL),(53,'Universidad de San Buenaventura ','hrojas','2010-01-01 00:00:00',NULL,NULL),(54,'Universidad del Atlantico                            ','hrojas','2010-01-01 00:00:00',NULL,NULL),(55,'Universidad del Cauca ','hrojas','2010-01-01 00:00:00',NULL,NULL),(56,'Universidad del Magdalena                               ','hrojas','2010-01-01 00:00:00',NULL,NULL),(57,'Universidad del Norte                               ','hrojas','2010-01-01 00:00:00',NULL,NULL),(58,'Universidad del Quindio ','hrojas','2010-01-01 00:00:00',NULL,NULL),(59,'Universidad del Tolima ','hrojas','2010-01-01 00:00:00',NULL,NULL),(60,'Universidad del Valle ','hrojas','2010-01-01 00:00:00',NULL,NULL),(61,'Universidad Distrital \"Francisco Jose de Caldas\" ','hrojas','2010-01-01 00:00:00',NULL,NULL),(62,'Universidad EAFIT ','hrojas','2010-01-01 00:00:00',NULL,NULL),(63,'Universidad El Bosque ','hrojas','2010-01-01 00:00:00',NULL,NULL),(64,'Universidad Externado de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(65,'Universidad Francisco de Paula Santander ','hrojas','2010-01-01 00:00:00',NULL,NULL),(66,'Universidad ICESI ','hrojas','2010-01-01 00:00:00',NULL,NULL),(67,'Universidad INCCA de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(68,'Universidad Industrial de Santander                   ','hrojas','2010-01-01 00:00:00',NULL,NULL),(69,'Universidad la Gran Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(70,'Universidad la Gran Colombia Sede Quindio ','hrojas','2010-01-01 00:00:00',NULL,NULL),(71,'Universidad Libre Bogotá ','hrojas','2010-01-01 00:00:00',NULL,NULL),(72,'Universidad Libre de Pereira ','hrojas','2010-01-01 00:00:00',NULL,NULL),(73,'Universidad Libre Sede (Barranquilla)                 ','hrojas','2010-01-01 00:00:00',NULL,NULL),(74,'Universidad Militar \"Nueva Granada\" ','hrojas','2010-01-01 00:00:00',NULL,NULL),(75,'Universidad Minuto de Dios ','hrojas','2010-01-01 00:00:00',NULL,NULL),(76,'Universidad Nacional de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(77,'Universidad Pedagógica Nacional ','hrojas','2010-01-01 00:00:00',NULL,NULL),(78,'Universidad Pedagogica y Tecnologica de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(79,'Universidad Piloto de Colombia ','hrojas','2010-01-01 00:00:00',NULL,NULL),(80,'Universidad Pontificia Bolivariana Cali ','hrojas','2010-01-01 00:00:00',NULL,NULL),(81,'Universidad Pontificia Bolivariana Sede (Bucaramanga) ','hrojas','2010-01-01 00:00:00',NULL,NULL),(82,'Universidad Popular del Cesar ','hrojas','2010-01-01 00:00:00',NULL,NULL),(83,'Universidad San Buenaventura Cali ','hrojas','2010-01-01 00:00:00',NULL,NULL),(84,'Universidad Santiago de Cali ','hrojas','2010-01-01 00:00:00',NULL,NULL),(85,'Universidad Santo Tomas ','hrojas','2010-01-01 00:00:00',NULL,NULL),(86,'Universidad Santo Tomas Sede (Bucaramanga) ','hrojas','2010-01-01 00:00:00',NULL,NULL),(87,'Universidad Sergio Arboleda ','hrojas','2010-01-01 00:00:00',NULL,NULL),(88,'Universidad Surcolombiana ','hrojas','2010-01-01 00:00:00',NULL,NULL),(89,'Universidad Tecnologica de Bolivar ','hrojas','2010-01-01 00:00:00',NULL,NULL),(90,'Universidad Tecnologica de los Llanos Orientales ','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_municipio` */

DROP TABLE IF EXISTS `gpp_municipio`;

CREATE TABLE `gpp_municipio` (
  `mun_nidmunicipio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dpt_niddepto` int(10) unsigned NOT NULL,
  `mun_vmunicipio` varchar(60) NOT NULL,
  `mun_vusucrea` varchar(60) NOT NULL,
  `mun_dfeccrea` datetime NOT NULL,
  `mun_vusumodifica` varchar(60) DEFAULT NULL,
  `mun_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`mun_nidmunicipio`),
  KEY `gpp_municipio_FKIndex1` (`dpt_niddepto`)
) ENGINE=MyISAM AUTO_INCREMENT=1083 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_municipio` */

LOCK TABLES `gpp_municipio` WRITE;

insert  into `gpp_municipio`(`mun_nidmunicipio`,`dpt_niddepto`,`mun_vmunicipio`,`mun_vusucrea`,`mun_dfeccrea`,`mun_vusumodifica`,`mun_dfecmodifica`) values (1,1,'Leticia','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,1,'Puerto Nariño','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,2,'Abejorral','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,2,'Abriaqui','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,2,'Alejandría','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,2,'Amagá','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,2,'Amalfi','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,2,'Andes','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,2,'Angelópolis','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,2,'Angostura','hrojas','2010-01-01 00:00:00',NULL,NULL),(11,2,'Anorí','hrojas','2010-01-01 00:00:00',NULL,NULL),(12,2,'Antioquia','hrojas','2010-01-01 00:00:00',NULL,NULL),(13,2,'Anzá','hrojas','2010-01-01 00:00:00',NULL,NULL),(14,2,'Apartadó','hrojas','2010-01-01 00:00:00',NULL,NULL),(15,2,'Arboletes','hrojas','2010-01-01 00:00:00',NULL,NULL),(16,2,'Argelia','hrojas','2010-01-01 00:00:00',NULL,NULL),(17,2,'Armenia','hrojas','2010-01-01 00:00:00',NULL,NULL),(18,2,'Barbosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(19,2,'Bello','hrojas','2010-01-01 00:00:00',NULL,NULL),(20,2,'Belmira','hrojas','2010-01-01 00:00:00',NULL,NULL),(21,2,'Betania','hrojas','2010-01-01 00:00:00',NULL,NULL),(22,2,'Betulia','hrojas','2010-01-01 00:00:00',NULL,NULL),(23,2,'Bolívar','hrojas','2010-01-01 00:00:00',NULL,NULL),(24,2,'Briseño','hrojas','2010-01-01 00:00:00',NULL,NULL),(25,2,'Buriticá','hrojas','2010-01-01 00:00:00',NULL,NULL),(26,2,'Cáceres','hrojas','2010-01-01 00:00:00',NULL,NULL),(27,2,'Caicedo','hrojas','2010-01-01 00:00:00',NULL,NULL),(28,2,'Caldas','hrojas','2010-01-01 00:00:00',NULL,NULL),(29,2,'Campamento','hrojas','2010-01-01 00:00:00',NULL,NULL),(30,2,'Cañasgordas','hrojas','2010-01-01 00:00:00',NULL,NULL),(31,2,'Caracolí','hrojas','2010-01-01 00:00:00',NULL,NULL),(32,2,'Caramanta','hrojas','2010-01-01 00:00:00',NULL,NULL),(33,2,'Carepa','hrojas','2010-01-01 00:00:00',NULL,NULL),(34,2,'Carmen de Viboral','hrojas','2010-01-01 00:00:00',NULL,NULL),(35,2,'Carolina','hrojas','2010-01-01 00:00:00',NULL,NULL),(36,2,'Caucasia','hrojas','2010-01-01 00:00:00',NULL,NULL),(37,2,'Chigorodó','hrojas','2010-01-01 00:00:00',NULL,NULL),(38,2,'Cisneros','hrojas','2010-01-01 00:00:00',NULL,NULL),(39,2,'Cocorná','hrojas','2010-01-01 00:00:00',NULL,NULL),(40,2,'Concepción','hrojas','2010-01-01 00:00:00',NULL,NULL),(41,2,'Concordia','hrojas','2010-01-01 00:00:00',NULL,NULL),(42,2,'Copacabana','hrojas','2010-01-01 00:00:00',NULL,NULL),(43,2,'Dabeiba','hrojas','2010-01-01 00:00:00',NULL,NULL),(44,2,'Don Matías','hrojas','2010-01-01 00:00:00',NULL,NULL),(45,2,'Ebéjico','hrojas','2010-01-01 00:00:00',NULL,NULL),(46,2,'El Bagre','hrojas','2010-01-01 00:00:00',NULL,NULL),(47,2,'Entrerríos','hrojas','2010-01-01 00:00:00',NULL,NULL),(48,2,'Envigado','hrojas','2010-01-01 00:00:00',NULL,NULL),(49,2,'Fredonia','hrojas','2010-01-01 00:00:00',NULL,NULL),(50,2,'Frontino','hrojas','2010-01-01 00:00:00',NULL,NULL),(51,2,'Giraldo','hrojas','2010-01-01 00:00:00',NULL,NULL),(52,2,'Girardota','hrojas','2010-01-01 00:00:00',NULL,NULL),(53,2,'Gómez Plata','hrojas','2010-01-01 00:00:00',NULL,NULL),(54,2,'Granada','hrojas','2010-01-01 00:00:00',NULL,NULL),(55,2,'Guadalupe','hrojas','2010-01-01 00:00:00',NULL,NULL),(56,2,'Guarne','hrojas','2010-01-01 00:00:00',NULL,NULL),(57,2,'Guatapé','hrojas','2010-01-01 00:00:00',NULL,NULL),(58,2,'Heliconia','hrojas','2010-01-01 00:00:00',NULL,NULL),(59,2,'Hispania','hrojas','2010-01-01 00:00:00',NULL,NULL),(60,2,'Itagüí','hrojas','2010-01-01 00:00:00',NULL,NULL),(61,2,'Ituango','hrojas','2010-01-01 00:00:00',NULL,NULL),(62,2,'Jardín','hrojas','2010-01-01 00:00:00',NULL,NULL),(63,2,'Jericó','hrojas','2010-01-01 00:00:00',NULL,NULL),(64,2,'La Ceja','hrojas','2010-01-01 00:00:00',NULL,NULL),(65,2,'La Estrella','hrojas','2010-01-01 00:00:00',NULL,NULL),(66,2,'La Pintada','hrojas','2010-01-01 00:00:00',NULL,NULL),(67,2,'La Unión','hrojas','2010-01-01 00:00:00',NULL,NULL),(68,2,'Liborina','hrojas','2010-01-01 00:00:00',NULL,NULL),(69,2,'Maceo','hrojas','2010-01-01 00:00:00',NULL,NULL),(70,2,'Marinilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(71,2,'Medellín','hrojas','2010-01-01 00:00:00',NULL,NULL),(72,2,'Montebello','hrojas','2010-01-01 00:00:00',NULL,NULL),(73,2,'Murindó','hrojas','2010-01-01 00:00:00',NULL,NULL),(74,2,'Mutatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(75,2,'Nariño','hrojas','2010-01-01 00:00:00',NULL,NULL),(76,2,'Nechí','hrojas','2010-01-01 00:00:00',NULL,NULL),(77,2,'Necoclí','hrojas','2010-01-01 00:00:00',NULL,NULL),(78,2,'Olaya','hrojas','2010-01-01 00:00:00',NULL,NULL),(79,2,'Peñol','hrojas','2010-01-01 00:00:00',NULL,NULL),(80,2,'Peque','hrojas','2010-01-01 00:00:00',NULL,NULL),(81,2,'Pueblorrico','hrojas','2010-01-01 00:00:00',NULL,NULL),(82,2,'Puerto Berrío','hrojas','2010-01-01 00:00:00',NULL,NULL),(83,2,'Puerto Nare','hrojas','2010-01-01 00:00:00',NULL,NULL),(84,2,'Puerto Triunfo','hrojas','2010-01-01 00:00:00',NULL,NULL),(85,2,'Remedios','hrojas','2010-01-01 00:00:00',NULL,NULL),(86,2,'Retiro','hrojas','2010-01-01 00:00:00',NULL,NULL),(87,2,'Rionegro','hrojas','2010-01-01 00:00:00',NULL,NULL),(88,2,'Sabanalarga','hrojas','2010-01-01 00:00:00',NULL,NULL),(89,2,'Sabaneta','hrojas','2010-01-01 00:00:00',NULL,NULL),(90,2,'Salgar','hrojas','2010-01-01 00:00:00',NULL,NULL),(91,2,'San Andrés','hrojas','2010-01-01 00:00:00',NULL,NULL),(92,2,'San Carlos','hrojas','2010-01-01 00:00:00',NULL,NULL),(93,2,'San francisco','hrojas','2010-01-01 00:00:00',NULL,NULL),(94,2,'San Jerónimo','hrojas','2010-01-01 00:00:00',NULL,NULL),(95,2,'San José de Montaña','hrojas','2010-01-01 00:00:00',NULL,NULL),(96,2,'San Juan de Urabá','hrojas','2010-01-01 00:00:00',NULL,NULL),(97,2,'San Luis','hrojas','2010-01-01 00:00:00',NULL,NULL),(98,2,'San Pedro','hrojas','2010-01-01 00:00:00',NULL,NULL),(99,2,'San Pedro de Urabá','hrojas','2010-01-01 00:00:00',NULL,NULL),(100,2,'San Rafael','hrojas','2010-01-01 00:00:00',NULL,NULL),(101,2,'San Roque','hrojas','2010-01-01 00:00:00',NULL,NULL),(102,2,'San Vicente','hrojas','2010-01-01 00:00:00',NULL,NULL),(103,2,'Santa Bárbara','hrojas','2010-01-01 00:00:00',NULL,NULL),(104,2,'Santa Rosa de Osos','hrojas','2010-01-01 00:00:00',NULL,NULL),(105,2,'Santo Domingo','hrojas','2010-01-01 00:00:00',NULL,NULL),(106,2,'Santuario','hrojas','2010-01-01 00:00:00',NULL,NULL),(107,2,'Segovia','hrojas','2010-01-01 00:00:00',NULL,NULL),(108,2,'Sonsón','hrojas','2010-01-01 00:00:00',NULL,NULL),(109,2,'Sopetrán','hrojas','2010-01-01 00:00:00',NULL,NULL),(110,2,'Támesis','hrojas','2010-01-01 00:00:00',NULL,NULL),(111,2,'Tarazá','hrojas','2010-01-01 00:00:00',NULL,NULL),(112,2,'Tarso','hrojas','2010-01-01 00:00:00',NULL,NULL),(113,2,'Titiribí','hrojas','2010-01-01 00:00:00',NULL,NULL),(114,2,'Toledo','hrojas','2010-01-01 00:00:00',NULL,NULL),(115,2,'Turbo','hrojas','2010-01-01 00:00:00',NULL,NULL),(116,2,'Uramita','hrojas','2010-01-01 00:00:00',NULL,NULL),(117,2,'Urrao','hrojas','2010-01-01 00:00:00',NULL,NULL),(118,2,'Valdivia','hrojas','2010-01-01 00:00:00',NULL,NULL),(119,2,'Valparaíso','hrojas','2010-01-01 00:00:00',NULL,NULL),(120,2,'Vegachí','hrojas','2010-01-01 00:00:00',NULL,NULL),(121,2,'Venecia','hrojas','2010-01-01 00:00:00',NULL,NULL),(122,2,'Vigía del Fuerte','hrojas','2010-01-01 00:00:00',NULL,NULL),(123,2,'Yalí','hrojas','2010-01-01 00:00:00',NULL,NULL),(124,2,'Yarumal','hrojas','2010-01-01 00:00:00',NULL,NULL),(125,2,'Yolombó','hrojas','2010-01-01 00:00:00',NULL,NULL),(126,2,'Yondó (Casabe)','hrojas','2010-01-01 00:00:00',NULL,NULL),(127,2,'Zaragoza','hrojas','2010-01-01 00:00:00',NULL,NULL),(128,3,'Arauca','hrojas','2010-01-01 00:00:00',NULL,NULL),(129,3,'Arauquita','hrojas','2010-01-01 00:00:00',NULL,NULL),(130,3,'Cravo Norte','hrojas','2010-01-01 00:00:00',NULL,NULL),(131,3,'Fortul','hrojas','2010-01-01 00:00:00',NULL,NULL),(132,3,'Fortul','hrojas','2010-01-01 00:00:00',NULL,NULL),(133,3,'Puerto Rondón','hrojas','2010-01-01 00:00:00',NULL,NULL),(134,3,'Puerto Rondón','hrojas','2010-01-01 00:00:00',NULL,NULL),(135,3,'Saravena','hrojas','2010-01-01 00:00:00',NULL,NULL),(136,3,'Tame','hrojas','2010-01-01 00:00:00',NULL,NULL),(137,4,'Achí','hrojas','2010-01-01 00:00:00',NULL,NULL),(138,4,'Altos del Rosario','hrojas','2010-01-01 00:00:00',NULL,NULL),(139,4,'Arenal','hrojas','2010-01-01 00:00:00',NULL,NULL),(140,4,'Arjona','hrojas','2010-01-01 00:00:00',NULL,NULL),(141,4,'Arroyohondo','hrojas','2010-01-01 00:00:00',NULL,NULL),(142,4,'Baranoa','hrojas','2010-01-01 00:00:00',NULL,NULL),(143,4,'Barranco de Loba','hrojas','2010-01-01 00:00:00',NULL,NULL),(144,4,'Barranquilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(145,4,'Calamar','hrojas','2010-01-01 00:00:00',NULL,NULL),(146,4,'Campo de la Cruz','hrojas','2010-01-01 00:00:00',NULL,NULL),(147,4,'Candelaria','hrojas','2010-01-01 00:00:00',NULL,NULL),(148,4,'Cantagallo','hrojas','2010-01-01 00:00:00',NULL,NULL),(149,4,'Cartagena','hrojas','2010-01-01 00:00:00',NULL,NULL),(150,4,'Cicuto','hrojas','2010-01-01 00:00:00',NULL,NULL),(151,4,'Clemencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(152,4,'Córdoba','hrojas','2010-01-01 00:00:00',NULL,NULL),(153,4,'El Carmen de Bolívar','hrojas','2010-01-01 00:00:00',NULL,NULL),(154,4,'El Guamo','hrojas','2010-01-01 00:00:00',NULL,NULL),(155,4,'El Peñón','hrojas','2010-01-01 00:00:00',NULL,NULL),(156,4,'Galapa','hrojas','2010-01-01 00:00:00',NULL,NULL),(157,4,'Hatillo de Loba','hrojas','2010-01-01 00:00:00',NULL,NULL),(158,4,'Juan de Acosta','hrojas','2010-01-01 00:00:00',NULL,NULL),(159,4,'Luruaco','hrojas','2010-01-01 00:00:00',NULL,NULL),(160,4,'Magangue','hrojas','2010-01-01 00:00:00',NULL,NULL),(161,4,'Mahates','hrojas','2010-01-01 00:00:00',NULL,NULL),(162,4,'Malambo','hrojas','2010-01-01 00:00:00',NULL,NULL),(163,4,'Manatí','hrojas','2010-01-01 00:00:00',NULL,NULL),(164,4,'Margarita','hrojas','2010-01-01 00:00:00',NULL,NULL),(165,4,'María la Baja','hrojas','2010-01-01 00:00:00',NULL,NULL),(166,4,'Mompós','hrojas','2010-01-01 00:00:00',NULL,NULL),(167,4,'Montecristo','hrojas','2010-01-01 00:00:00',NULL,NULL),(168,4,'Morales','hrojas','2010-01-01 00:00:00',NULL,NULL),(169,4,'Palmar de Varela','hrojas','2010-01-01 00:00:00',NULL,NULL),(170,4,'Pinillos','hrojas','2010-01-01 00:00:00',NULL,NULL),(171,4,'Piojó','hrojas','2010-01-01 00:00:00',NULL,NULL),(172,4,'Polonuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(173,4,'Ponedera','hrojas','2010-01-01 00:00:00',NULL,NULL),(174,4,'Puerto Colombia','hrojas','2010-01-01 00:00:00',NULL,NULL),(175,4,'Regidor','hrojas','2010-01-01 00:00:00',NULL,NULL),(176,4,'Repelón','hrojas','2010-01-01 00:00:00',NULL,NULL),(177,4,'Río Viejo','hrojas','2010-01-01 00:00:00',NULL,NULL),(178,4,'Sabanagrande','hrojas','2010-01-01 00:00:00',NULL,NULL),(179,4,'Sabanalarga','hrojas','2010-01-01 00:00:00',NULL,NULL),(180,4,'San Cristóbal','hrojas','2010-01-01 00:00:00',NULL,NULL),(181,4,'San Estanislao','hrojas','2010-01-01 00:00:00',NULL,NULL),(182,4,'San Fernando','hrojas','2010-01-01 00:00:00',NULL,NULL),(183,4,'San Jacinto','hrojas','2010-01-01 00:00:00',NULL,NULL),(184,4,'San Jacinto del Cauca','hrojas','2010-01-01 00:00:00',NULL,NULL),(185,4,'San Juan Nepomuceno','hrojas','2010-01-01 00:00:00',NULL,NULL),(186,4,'San Martín de Loba','hrojas','2010-01-01 00:00:00',NULL,NULL),(187,4,'San Pablo','hrojas','2010-01-01 00:00:00',NULL,NULL),(188,4,'Santa Catalina','hrojas','2010-01-01 00:00:00',NULL,NULL),(189,4,'Santa Lucía','hrojas','2010-01-01 00:00:00',NULL,NULL),(190,4,'Santa Rosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(191,4,'Santa Rosa del Sur','hrojas','2010-01-01 00:00:00',NULL,NULL),(192,4,'Santo Tomás','hrojas','2010-01-01 00:00:00',NULL,NULL),(193,4,'Simití','hrojas','2010-01-01 00:00:00',NULL,NULL),(194,4,'Soledad','hrojas','2010-01-01 00:00:00',NULL,NULL),(195,4,'Soplaviento','hrojas','2010-01-01 00:00:00',NULL,NULL),(196,4,'Suán','hrojas','2010-01-01 00:00:00',NULL,NULL),(197,4,'Talaigua Nuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(198,4,'Tiquisio (Puerto Rico)','hrojas','2010-01-01 00:00:00',NULL,NULL),(199,4,'Tubará','hrojas','2010-01-01 00:00:00',NULL,NULL),(200,4,'Turbaco','hrojas','2010-01-01 00:00:00',NULL,NULL),(201,4,'Turbaná','hrojas','2010-01-01 00:00:00',NULL,NULL),(202,4,'Usiacurí','hrojas','2010-01-01 00:00:00',NULL,NULL),(203,4,'Villanueva','hrojas','2010-01-01 00:00:00',NULL,NULL),(204,4,'Zambrano','hrojas','2010-01-01 00:00:00',NULL,NULL),(205,5,'Almeida','hrojas','2010-01-01 00:00:00',NULL,NULL),(206,5,'Aquitania','hrojas','2010-01-01 00:00:00',NULL,NULL),(207,5,'Arcabuco','hrojas','2010-01-01 00:00:00',NULL,NULL),(208,5,'Belén','hrojas','2010-01-01 00:00:00',NULL,NULL),(209,5,'Berbeo','hrojas','2010-01-01 00:00:00',NULL,NULL),(210,5,'Beteitiva','hrojas','2010-01-01 00:00:00',NULL,NULL),(211,5,'Boavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(212,5,'Boyacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(213,5,'Briseño','hrojas','2010-01-01 00:00:00',NULL,NULL),(214,5,'Buenavista','hrojas','2010-01-01 00:00:00',NULL,NULL),(215,5,'Busbanzá','hrojas','2010-01-01 00:00:00',NULL,NULL),(216,5,'Caldas','hrojas','2010-01-01 00:00:00',NULL,NULL),(217,5,'Campohermoso','hrojas','2010-01-01 00:00:00',NULL,NULL),(218,5,'Cerinza','hrojas','2010-01-01 00:00:00',NULL,NULL),(219,5,'Chinavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(220,5,'Chiquinquirá','hrojas','2010-01-01 00:00:00',NULL,NULL),(221,5,'Chíquiza','hrojas','2010-01-01 00:00:00',NULL,NULL),(222,5,'Chiscas','hrojas','2010-01-01 00:00:00',NULL,NULL),(223,5,'Chita','hrojas','2010-01-01 00:00:00',NULL,NULL),(224,5,'Chitaranque','hrojas','2010-01-01 00:00:00',NULL,NULL),(225,5,'Chivatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(226,5,'Chivor','hrojas','2010-01-01 00:00:00',NULL,NULL),(227,5,'Ciénaga','hrojas','2010-01-01 00:00:00',NULL,NULL),(228,5,'Cómbita','hrojas','2010-01-01 00:00:00',NULL,NULL),(229,5,'Coper','hrojas','2010-01-01 00:00:00',NULL,NULL),(230,5,'Corrales','hrojas','2010-01-01 00:00:00',NULL,NULL),(231,5,'Covarachia','hrojas','2010-01-01 00:00:00',NULL,NULL),(232,5,'Cubar','hrojas','2010-01-01 00:00:00',NULL,NULL),(233,5,'Cucaita','hrojas','2010-01-01 00:00:00',NULL,NULL),(234,5,'Cuitiva','hrojas','2010-01-01 00:00:00',NULL,NULL),(235,5,'Duitama','hrojas','2010-01-01 00:00:00',NULL,NULL),(236,5,'El Cocuy','hrojas','2010-01-01 00:00:00',NULL,NULL),(237,5,'El Espino','hrojas','2010-01-01 00:00:00',NULL,NULL),(238,5,'Firavitoba','hrojas','2010-01-01 00:00:00',NULL,NULL),(239,5,'Floresta','hrojas','2010-01-01 00:00:00',NULL,NULL),(240,5,'Gachantivá','hrojas','2010-01-01 00:00:00',NULL,NULL),(241,5,'Gámeza','hrojas','2010-01-01 00:00:00',NULL,NULL),(242,5,'Garagoa','hrojas','2010-01-01 00:00:00',NULL,NULL),(243,5,'Guacamayas','hrojas','2010-01-01 00:00:00',NULL,NULL),(244,5,'Guateque','hrojas','2010-01-01 00:00:00',NULL,NULL),(245,5,'Guayatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(246,5,'Guicán','hrojas','2010-01-01 00:00:00',NULL,NULL),(247,5,'Iza','hrojas','2010-01-01 00:00:00',NULL,NULL),(248,5,'Jenesano','hrojas','2010-01-01 00:00:00',NULL,NULL),(249,5,'Jericó','hrojas','2010-01-01 00:00:00',NULL,NULL),(250,5,'La Capilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(251,5,'La Ubita','hrojas','2010-01-01 00:00:00',NULL,NULL),(252,5,'La Victoria','hrojas','2010-01-01 00:00:00',NULL,NULL),(253,5,'Labranzagrande','hrojas','2010-01-01 00:00:00',NULL,NULL),(254,5,'Macanal','hrojas','2010-01-01 00:00:00',NULL,NULL),(255,5,'Maripí','hrojas','2010-01-01 00:00:00',NULL,NULL),(256,5,'Miraflores','hrojas','2010-01-01 00:00:00',NULL,NULL),(257,5,'Mongua','hrojas','2010-01-01 00:00:00',NULL,NULL),(258,5,'Monguí','hrojas','2010-01-01 00:00:00',NULL,NULL),(259,5,'Moniquirá','hrojas','2010-01-01 00:00:00',NULL,NULL),(260,5,'Motavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(261,5,'Muzo','hrojas','2010-01-01 00:00:00',NULL,NULL),(262,5,'Nobsa','hrojas','2010-01-01 00:00:00',NULL,NULL),(263,5,'Nuevo Colón','hrojas','2010-01-01 00:00:00',NULL,NULL),(264,5,'Oicatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(265,5,'Otanche','hrojas','2010-01-01 00:00:00',NULL,NULL),(266,5,'Pachavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(267,5,'Páez','hrojas','2010-01-01 00:00:00',NULL,NULL),(268,5,'Paipa','hrojas','2010-01-01 00:00:00',NULL,NULL),(269,5,'Pajarito','hrojas','2010-01-01 00:00:00',NULL,NULL),(270,5,'Panqueba','hrojas','2010-01-01 00:00:00',NULL,NULL),(271,5,'Pauna','hrojas','2010-01-01 00:00:00',NULL,NULL),(272,5,'Paya','hrojas','2010-01-01 00:00:00',NULL,NULL),(273,5,'Paz de Río','hrojas','2010-01-01 00:00:00',NULL,NULL),(274,5,'Pesca','hrojas','2010-01-01 00:00:00',NULL,NULL),(275,5,'Pisva','hrojas','2010-01-01 00:00:00',NULL,NULL),(276,5,'Puerto Boyacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(277,5,'Quípama','hrojas','2010-01-01 00:00:00',NULL,NULL),(278,5,'Ramiquirí','hrojas','2010-01-01 00:00:00',NULL,NULL),(279,5,'Ráquira','hrojas','2010-01-01 00:00:00',NULL,NULL),(280,5,'Rondón','hrojas','2010-01-01 00:00:00',NULL,NULL),(281,5,'Saboyá','hrojas','2010-01-01 00:00:00',NULL,NULL),(282,5,'Sáchica','hrojas','2010-01-01 00:00:00',NULL,NULL),(283,5,'Samacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(284,5,'San Eduardo','hrojas','2010-01-01 00:00:00',NULL,NULL),(285,5,'San José de Pare','hrojas','2010-01-01 00:00:00',NULL,NULL),(286,5,'San Luis de Gaceno','hrojas','2010-01-01 00:00:00',NULL,NULL),(287,5,'San Mateo','hrojas','2010-01-01 00:00:00',NULL,NULL),(288,5,'San Miguel de Sema','hrojas','2010-01-01 00:00:00',NULL,NULL),(289,5,'San Pablo de Borbur','hrojas','2010-01-01 00:00:00',NULL,NULL),(290,5,'Santa María','hrojas','2010-01-01 00:00:00',NULL,NULL),(291,5,'Santa Rosa de Viterbo','hrojas','2010-01-01 00:00:00',NULL,NULL),(292,5,'Santa Sofía','hrojas','2010-01-01 00:00:00',NULL,NULL),(293,5,'Santana','hrojas','2010-01-01 00:00:00',NULL,NULL),(294,5,'Sativanorte','hrojas','2010-01-01 00:00:00',NULL,NULL),(295,5,'Sativasur','hrojas','2010-01-01 00:00:00',NULL,NULL),(296,5,'Siachoque','hrojas','2010-01-01 00:00:00',NULL,NULL),(297,5,'Soatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(298,5,'Socha','hrojas','2010-01-01 00:00:00',NULL,NULL),(299,5,'Socotá','hrojas','2010-01-01 00:00:00',NULL,NULL),(300,5,'Sogamoso','hrojas','2010-01-01 00:00:00',NULL,NULL),(301,5,'Somondoco','hrojas','2010-01-01 00:00:00',NULL,NULL),(302,5,'Sora','hrojas','2010-01-01 00:00:00',NULL,NULL),(303,5,'Soracá','hrojas','2010-01-01 00:00:00',NULL,NULL),(304,5,'Sotaquirá','hrojas','2010-01-01 00:00:00',NULL,NULL),(305,5,'Susacón','hrojas','2010-01-01 00:00:00',NULL,NULL),(306,5,'Sutamarchán','hrojas','2010-01-01 00:00:00',NULL,NULL),(307,5,'Sutatenza','hrojas','2010-01-01 00:00:00',NULL,NULL),(308,5,'Tasco','hrojas','2010-01-01 00:00:00',NULL,NULL),(309,5,'Tenza','hrojas','2010-01-01 00:00:00',NULL,NULL),(310,5,'Tibaná','hrojas','2010-01-01 00:00:00',NULL,NULL),(311,5,'Tibasosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(312,5,'Tinjacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(313,5,'Tipacoque','hrojas','2010-01-01 00:00:00',NULL,NULL),(314,5,'Toca','hrojas','2010-01-01 00:00:00',NULL,NULL),(315,5,'Toguí','hrojas','2010-01-01 00:00:00',NULL,NULL),(316,5,'Tópaga','hrojas','2010-01-01 00:00:00',NULL,NULL),(317,5,'Tota','hrojas','2010-01-01 00:00:00',NULL,NULL),(318,5,'Tunja','hrojas','2010-01-01 00:00:00',NULL,NULL),(319,5,'Tunungua','hrojas','2010-01-01 00:00:00',NULL,NULL),(320,5,'Turmequé','hrojas','2010-01-01 00:00:00',NULL,NULL),(321,5,'Tuta','hrojas','2010-01-01 00:00:00',NULL,NULL),(322,5,'Tutazá','hrojas','2010-01-01 00:00:00',NULL,NULL),(323,5,'Úmbita','hrojas','2010-01-01 00:00:00',NULL,NULL),(324,5,'Ventaquemada','hrojas','2010-01-01 00:00:00',NULL,NULL),(325,5,'Villa de Leyva','hrojas','2010-01-01 00:00:00',NULL,NULL),(326,5,'Viracachá','hrojas','2010-01-01 00:00:00',NULL,NULL),(327,5,'Zetaquirá','hrojas','2010-01-01 00:00:00',NULL,NULL),(328,6,'Aguadas','hrojas','2010-01-01 00:00:00',NULL,NULL),(329,6,'Anserma','hrojas','2010-01-01 00:00:00',NULL,NULL),(330,6,'Aranzazu','hrojas','2010-01-01 00:00:00',NULL,NULL),(331,6,'Belalcázar','hrojas','2010-01-01 00:00:00',NULL,NULL),(332,6,'Chinchina','hrojas','2010-01-01 00:00:00',NULL,NULL),(333,6,'Filadelfia','hrojas','2010-01-01 00:00:00',NULL,NULL),(334,6,'La Dorada','hrojas','2010-01-01 00:00:00',NULL,NULL),(335,6,'La Merced','hrojas','2010-01-01 00:00:00',NULL,NULL),(336,6,'Manizales','hrojas','2010-01-01 00:00:00',NULL,NULL),(337,6,'Manzanares','hrojas','2010-01-01 00:00:00',NULL,NULL),(338,6,'Marmato','hrojas','2010-01-01 00:00:00',NULL,NULL),(339,6,'Marquetalia','hrojas','2010-01-01 00:00:00',NULL,NULL),(340,6,'Marulanda','hrojas','2010-01-01 00:00:00',NULL,NULL),(341,6,'Neira','hrojas','2010-01-01 00:00:00',NULL,NULL),(342,6,'Pácora','hrojas','2010-01-01 00:00:00',NULL,NULL),(343,6,'Palestina','hrojas','2010-01-01 00:00:00',NULL,NULL),(344,6,'Pensilvania','hrojas','2010-01-01 00:00:00',NULL,NULL),(345,6,'Riosucio','hrojas','2010-01-01 00:00:00',NULL,NULL),(346,6,'Risaralda','hrojas','2010-01-01 00:00:00',NULL,NULL),(347,6,'Salamina','hrojas','2010-01-01 00:00:00',NULL,NULL),(348,6,'Samaná','hrojas','2010-01-01 00:00:00',NULL,NULL),(349,6,'San José','hrojas','2010-01-01 00:00:00',NULL,NULL),(350,6,'Supía','hrojas','2010-01-01 00:00:00',NULL,NULL),(351,6,'Victoria','hrojas','2010-01-01 00:00:00',NULL,NULL),(352,6,'Villamaría','hrojas','2010-01-01 00:00:00',NULL,NULL),(353,6,'Viterbo','hrojas','2010-01-01 00:00:00',NULL,NULL),(354,7,'Albania','hrojas','2010-01-01 00:00:00',NULL,NULL),(355,7,'Belén de los Andaquíes','hrojas','2010-01-01 00:00:00',NULL,NULL),(356,7,'Cartagena del Chairá','hrojas','2010-01-01 00:00:00',NULL,NULL),(357,7,'Curillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(358,7,'El Doncello','hrojas','2010-01-01 00:00:00',NULL,NULL),(359,7,'El Paujil','hrojas','2010-01-01 00:00:00',NULL,NULL),(360,7,'Florencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(361,7,'La Montañita','hrojas','2010-01-01 00:00:00',NULL,NULL),(362,7,'Milán','hrojas','2010-01-01 00:00:00',NULL,NULL),(363,7,'Morelia','hrojas','2010-01-01 00:00:00',NULL,NULL),(364,7,'Puerto Rico','hrojas','2010-01-01 00:00:00',NULL,NULL),(365,7,'San José del Fragua','hrojas','2010-01-01 00:00:00',NULL,NULL),(366,7,'San Vicente del Caguán','hrojas','2010-01-01 00:00:00',NULL,NULL),(367,7,'Solano','hrojas','2010-01-01 00:00:00',NULL,NULL),(368,7,'Solita','hrojas','2010-01-01 00:00:00',NULL,NULL),(369,7,'Valparaíso','hrojas','2010-01-01 00:00:00',NULL,NULL),(370,8,'Aguazul','hrojas','2010-01-01 00:00:00',NULL,NULL),(371,8,'Chameza','hrojas','2010-01-01 00:00:00',NULL,NULL),(372,8,'Hato Corozal','hrojas','2010-01-01 00:00:00',NULL,NULL),(373,8,'La Salina','hrojas','2010-01-01 00:00:00',NULL,NULL),(374,8,'Maní','hrojas','2010-01-01 00:00:00',NULL,NULL),(375,8,'Monterrey','hrojas','2010-01-01 00:00:00',NULL,NULL),(376,8,'Nunchía','hrojas','2010-01-01 00:00:00',NULL,NULL),(377,8,'Orocué','hrojas','2010-01-01 00:00:00',NULL,NULL),(378,8,'Paz de Ariporo','hrojas','2010-01-01 00:00:00',NULL,NULL),(379,8,'Pore','hrojas','2010-01-01 00:00:00',NULL,NULL),(380,8,'Recetor','hrojas','2010-01-01 00:00:00',NULL,NULL),(381,8,'Sabalarga','hrojas','2010-01-01 00:00:00',NULL,NULL),(382,8,'Sácama','hrojas','2010-01-01 00:00:00',NULL,NULL),(383,8,'San Luis de Palenque','hrojas','2010-01-01 00:00:00',NULL,NULL),(384,8,'Támara','hrojas','2010-01-01 00:00:00',NULL,NULL),(385,8,'Tauramena','hrojas','2010-01-01 00:00:00',NULL,NULL),(386,8,'Trinidad','hrojas','2010-01-01 00:00:00',NULL,NULL),(387,8,'Villanueva','hrojas','2010-01-01 00:00:00',NULL,NULL),(388,8,'Yopal','hrojas','2010-01-01 00:00:00',NULL,NULL),(389,9,'Almaguer','hrojas','2010-01-01 00:00:00',NULL,NULL),(390,9,'Argelia','hrojas','2010-01-01 00:00:00',NULL,NULL),(391,9,'Balboa','hrojas','2010-01-01 00:00:00',NULL,NULL),(392,9,'Bolívar','hrojas','2010-01-01 00:00:00',NULL,NULL),(393,9,'Buenos Aires','hrojas','2010-01-01 00:00:00',NULL,NULL),(394,9,'Cajibío','hrojas','2010-01-01 00:00:00',NULL,NULL),(395,9,'Caldono','hrojas','2010-01-01 00:00:00',NULL,NULL),(396,9,'Caloto','hrojas','2010-01-01 00:00:00',NULL,NULL),(397,9,'Corinto','hrojas','2010-01-01 00:00:00',NULL,NULL),(398,9,'El Tambo','hrojas','2010-01-01 00:00:00',NULL,NULL),(399,9,'Florencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(400,9,'Guapi','hrojas','2010-01-01 00:00:00',NULL,NULL),(401,9,'Inzá','hrojas','2010-01-01 00:00:00',NULL,NULL),(402,9,'Jambaló','hrojas','2010-01-01 00:00:00',NULL,NULL),(403,9,'La Sierra','hrojas','2010-01-01 00:00:00',NULL,NULL),(404,9,'La Vega','hrojas','2010-01-01 00:00:00',NULL,NULL),(405,9,'López (Micay)','hrojas','2010-01-01 00:00:00',NULL,NULL),(406,9,'Mercaderes','hrojas','2010-01-01 00:00:00',NULL,NULL),(407,9,'Miranda','hrojas','2010-01-01 00:00:00',NULL,NULL),(408,9,'Morales','hrojas','2010-01-01 00:00:00',NULL,NULL),(409,9,'Padilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(410,9,'Páez (Belalcazar)','hrojas','2010-01-01 00:00:00',NULL,NULL),(411,9,'Patía (El Bordo)','hrojas','2010-01-01 00:00:00',NULL,NULL),(412,9,'Piamonte','hrojas','2010-01-01 00:00:00',NULL,NULL),(413,9,'Piendamó','hrojas','2010-01-01 00:00:00',NULL,NULL),(414,9,'Popayán','hrojas','2010-01-01 00:00:00',NULL,NULL),(415,9,'Puerto Tejada','hrojas','2010-01-01 00:00:00',NULL,NULL),(416,9,'Puracé (Coconuco)','hrojas','2010-01-01 00:00:00',NULL,NULL),(417,9,'Rosas','hrojas','2010-01-01 00:00:00',NULL,NULL),(418,9,'San Sebastián','hrojas','2010-01-01 00:00:00',NULL,NULL),(419,9,'Santa Rosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(420,9,'Santander de Quilichao','hrojas','2010-01-01 00:00:00',NULL,NULL),(421,9,'Silvia','hrojas','2010-01-01 00:00:00',NULL,NULL),(422,9,'Sotará (Paispamba)','hrojas','2010-01-01 00:00:00',NULL,NULL),(423,9,'Suárez','hrojas','2010-01-01 00:00:00',NULL,NULL),(424,9,'Timbío','hrojas','2010-01-01 00:00:00',NULL,NULL),(425,9,'Timbiquí','hrojas','2010-01-01 00:00:00',NULL,NULL),(426,9,'Toribío','hrojas','2010-01-01 00:00:00',NULL,NULL),(427,9,'Totoro','hrojas','2010-01-01 00:00:00',NULL,NULL),(428,10,'Aguachica','hrojas','2010-01-01 00:00:00',NULL,NULL),(429,10,'Agustín Codazzi','hrojas','2010-01-01 00:00:00',NULL,NULL),(430,10,'Astrea','hrojas','2010-01-01 00:00:00',NULL,NULL),(431,10,'Becerril','hrojas','2010-01-01 00:00:00',NULL,NULL),(432,10,'Bosconia','hrojas','2010-01-01 00:00:00',NULL,NULL),(433,10,'Chimichagua','hrojas','2010-01-01 00:00:00',NULL,NULL),(434,10,'Chiriguaná','hrojas','2010-01-01 00:00:00',NULL,NULL),(435,10,'Curumaní','hrojas','2010-01-01 00:00:00',NULL,NULL),(436,10,'El Copey','hrojas','2010-01-01 00:00:00',NULL,NULL),(437,10,'El Paso','hrojas','2010-01-01 00:00:00',NULL,NULL),(438,10,'Gamarra','hrojas','2010-01-01 00:00:00',NULL,NULL),(439,10,'González','hrojas','2010-01-01 00:00:00',NULL,NULL),(440,10,'La Gloria','hrojas','2010-01-01 00:00:00',NULL,NULL),(441,10,'La Jagua de Ibirico','hrojas','2010-01-01 00:00:00',NULL,NULL),(442,10,'La Paz (Robles)','hrojas','2010-01-01 00:00:00',NULL,NULL),(443,10,'Manaure Balcón Cesar','hrojas','2010-01-01 00:00:00',NULL,NULL),(444,10,'Pailitas','hrojas','2010-01-01 00:00:00',NULL,NULL),(445,10,'Pelaya','hrojas','2010-01-01 00:00:00',NULL,NULL),(446,10,'Pueblo Bello','hrojas','2010-01-01 00:00:00',NULL,NULL),(447,10,'Río de Oro','hrojas','2010-01-01 00:00:00',NULL,NULL),(448,10,'San Alberto','hrojas','2010-01-01 00:00:00',NULL,NULL),(449,10,'San Diego','hrojas','2010-01-01 00:00:00',NULL,NULL),(450,10,'San Martín','hrojas','2010-01-01 00:00:00',NULL,NULL),(451,10,'Tamalameque','hrojas','2010-01-01 00:00:00',NULL,NULL),(452,10,'Valledupar','hrojas','2010-01-01 00:00:00',NULL,NULL),(453,11,'Acandí','hrojas','2010-01-01 00:00:00',NULL,NULL),(454,11,'Alto Baudó (Pie de Pato)','hrojas','2010-01-01 00:00:00',NULL,NULL),(455,11,'Atrato (Yuto)','hrojas','2010-01-01 00:00:00',NULL,NULL),(456,11,'Bagadó','hrojas','2010-01-01 00:00:00',NULL,NULL),(457,11,'Bahía Solano (Mútis)','hrojas','2010-01-01 00:00:00',NULL,NULL),(458,11,'Bajo Baudó (Pizarro)','hrojas','2010-01-01 00:00:00',NULL,NULL),(459,11,'Bojayá (Bellavista)','hrojas','2010-01-01 00:00:00',NULL,NULL),(460,11,'Cantón de San Pablo','hrojas','2010-01-01 00:00:00',NULL,NULL),(461,11,'Condoto','hrojas','2010-01-01 00:00:00',NULL,NULL),(462,11,'El Carmen','hrojas','2010-01-01 00:00:00',NULL,NULL),(463,11,'El Litoral de San Juan','hrojas','2010-01-01 00:00:00',NULL,NULL),(464,11,'Itsmina','hrojas','2010-01-01 00:00:00',NULL,NULL),(465,11,'Juradó','hrojas','2010-01-01 00:00:00',NULL,NULL),(466,11,'Lloró','hrojas','2010-01-01 00:00:00',NULL,NULL),(467,11,'Nóvita','hrojas','2010-01-01 00:00:00',NULL,NULL),(468,11,'Nuquí','hrojas','2010-01-01 00:00:00',NULL,NULL),(469,11,'Quibdó','hrojas','2010-01-01 00:00:00',NULL,NULL),(470,11,'Riosucio','hrojas','2010-01-01 00:00:00',NULL,NULL),(471,11,'San José del Palmar','hrojas','2010-01-01 00:00:00',NULL,NULL),(472,11,'Sipí','hrojas','2010-01-01 00:00:00',NULL,NULL),(473,11,'Tadó','hrojas','2010-01-01 00:00:00',NULL,NULL),(474,11,'Unguía','hrojas','2010-01-01 00:00:00',NULL,NULL),(475,13,'Ayapel','hrojas','2010-01-01 00:00:00',NULL,NULL),(476,13,'Buenavista','hrojas','2010-01-01 00:00:00',NULL,NULL),(477,13,'Canalete','hrojas','2010-01-01 00:00:00',NULL,NULL),(478,13,'Cereté','hrojas','2010-01-01 00:00:00',NULL,NULL),(479,13,'Chima','hrojas','2010-01-01 00:00:00',NULL,NULL),(480,13,'Chinú','hrojas','2010-01-01 00:00:00',NULL,NULL),(481,13,'Ciénaga de Oro','hrojas','2010-01-01 00:00:00',NULL,NULL),(482,13,'Cotorra','hrojas','2010-01-01 00:00:00',NULL,NULL),(483,13,'La Apartada (Frontera)','hrojas','2010-01-01 00:00:00',NULL,NULL),(484,13,'Lorica','hrojas','2010-01-01 00:00:00',NULL,NULL),(485,13,'Los Córdobas','hrojas','2010-01-01 00:00:00',NULL,NULL),(486,13,'Momil','hrojas','2010-01-01 00:00:00',NULL,NULL),(487,13,'Monitos','hrojas','2010-01-01 00:00:00',NULL,NULL),(488,13,'Montelíbano','hrojas','2010-01-01 00:00:00',NULL,NULL),(489,13,'Montería','hrojas','2010-01-01 00:00:00',NULL,NULL),(490,13,'Planeta Rica','hrojas','2010-01-01 00:00:00',NULL,NULL),(491,13,'Pueblo Nuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(492,13,'Puerto Escondido','hrojas','2010-01-01 00:00:00',NULL,NULL),(493,13,'Puerto Libertador','hrojas','2010-01-01 00:00:00',NULL,NULL),(494,13,'Purísima','hrojas','2010-01-01 00:00:00',NULL,NULL),(495,13,'Sahagún','hrojas','2010-01-01 00:00:00',NULL,NULL),(496,13,'San Andrés Sotavento','hrojas','2010-01-01 00:00:00',NULL,NULL),(497,13,'San Antero','hrojas','2010-01-01 00:00:00',NULL,NULL),(498,13,'San Bernardo del Viento','hrojas','2010-01-01 00:00:00',NULL,NULL),(499,13,'San Carlos','hrojas','2010-01-01 00:00:00',NULL,NULL),(500,13,'San Pelayo','hrojas','2010-01-01 00:00:00',NULL,NULL),(501,13,'Tierralta','hrojas','2010-01-01 00:00:00',NULL,NULL),(502,13,'Valencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(503,12,'Agua de Dios','hrojas','2010-01-01 00:00:00',NULL,NULL),(504,12,'Albán','hrojas','2010-01-01 00:00:00',NULL,NULL),(505,12,'Anapoima','hrojas','2010-01-01 00:00:00',NULL,NULL),(506,12,'Anolaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(507,12,'Arbeláez','hrojas','2010-01-01 00:00:00',NULL,NULL),(508,12,'Beltrán','hrojas','2010-01-01 00:00:00',NULL,NULL),(509,12,'Bituima','hrojas','2010-01-01 00:00:00',NULL,NULL),(510,12,'Bojacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(511,12,'Cabrera','hrojas','2010-01-01 00:00:00',NULL,NULL),(512,12,'Cachipay','hrojas','2010-01-01 00:00:00',NULL,NULL),(513,12,'Cajicá','hrojas','2010-01-01 00:00:00',NULL,NULL),(514,12,'Caparrapí','hrojas','2010-01-01 00:00:00',NULL,NULL),(515,12,'Cáqueza','hrojas','2010-01-01 00:00:00',NULL,NULL),(516,12,'Carmen de Carupa','hrojas','2010-01-01 00:00:00',NULL,NULL),(517,12,'Chaguaní','hrojas','2010-01-01 00:00:00',NULL,NULL),(518,12,'Chía','hrojas','2010-01-01 00:00:00',NULL,NULL),(519,12,'Chipaque','hrojas','2010-01-01 00:00:00',NULL,NULL),(520,12,'Choachí','hrojas','2010-01-01 00:00:00',NULL,NULL),(521,12,'Chocontá','hrojas','2010-01-01 00:00:00',NULL,NULL),(522,12,'Cogua','hrojas','2010-01-01 00:00:00',NULL,NULL),(523,12,'Cota','hrojas','2010-01-01 00:00:00',NULL,NULL),(524,12,'Cucunubá','hrojas','2010-01-01 00:00:00',NULL,NULL),(525,12,'El Colegio','hrojas','2010-01-01 00:00:00',NULL,NULL),(526,12,'El Peñón','hrojas','2010-01-01 00:00:00',NULL,NULL),(527,12,'El Rosal','hrojas','2010-01-01 00:00:00',NULL,NULL),(528,12,'Facatativá','hrojas','2010-01-01 00:00:00',NULL,NULL),(529,12,'Fómeque','hrojas','2010-01-01 00:00:00',NULL,NULL),(530,12,'Fosca','hrojas','2010-01-01 00:00:00',NULL,NULL),(531,12,'Funza','hrojas','2010-01-01 00:00:00',NULL,NULL),(532,12,'Fúquene','hrojas','2010-01-01 00:00:00',NULL,NULL),(533,12,'Fusagasugá','hrojas','2010-01-01 00:00:00',NULL,NULL),(534,12,'Gachalá','hrojas','2010-01-01 00:00:00',NULL,NULL),(535,12,'Gachancipá','hrojas','2010-01-01 00:00:00',NULL,NULL),(536,12,'Gachetá','hrojas','2010-01-01 00:00:00',NULL,NULL),(537,12,'Gama','hrojas','2010-01-01 00:00:00',NULL,NULL),(538,12,'Girardot','hrojas','2010-01-01 00:00:00',NULL,NULL),(539,12,'Granada','hrojas','2010-01-01 00:00:00',NULL,NULL),(540,12,'Guachetá','hrojas','2010-01-01 00:00:00',NULL,NULL),(541,12,'Guaduas','hrojas','2010-01-01 00:00:00',NULL,NULL),(542,12,'Guasca','hrojas','2010-01-01 00:00:00',NULL,NULL),(543,12,'Guataquí','hrojas','2010-01-01 00:00:00',NULL,NULL),(544,12,'Guatavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(545,12,'Guayabal de Síquima','hrojas','2010-01-01 00:00:00',NULL,NULL),(546,12,'Guayabetal','hrojas','2010-01-01 00:00:00',NULL,NULL),(547,12,'Gutiérrez','hrojas','2010-01-01 00:00:00',NULL,NULL),(548,12,'Jerusalén','hrojas','2010-01-01 00:00:00',NULL,NULL),(549,12,'Junín','hrojas','2010-01-01 00:00:00',NULL,NULL),(550,12,'La Calera','hrojas','2010-01-01 00:00:00',NULL,NULL),(551,12,'La Mesa','hrojas','2010-01-01 00:00:00',NULL,NULL),(552,12,'La Palma','hrojas','2010-01-01 00:00:00',NULL,NULL),(553,12,'La Peña','hrojas','2010-01-01 00:00:00',NULL,NULL),(554,12,'La Vega','hrojas','2010-01-01 00:00:00',NULL,NULL),(555,12,'Lenguazaque','hrojas','2010-01-01 00:00:00',NULL,NULL),(556,12,'Machetá','hrojas','2010-01-01 00:00:00',NULL,NULL),(557,12,'Madrid','hrojas','2010-01-01 00:00:00',NULL,NULL),(558,12,'Manta','hrojas','2010-01-01 00:00:00',NULL,NULL),(559,12,'Medina','hrojas','2010-01-01 00:00:00',NULL,NULL),(560,12,'Mosquera','hrojas','2010-01-01 00:00:00',NULL,NULL),(561,12,'Nariño','hrojas','2010-01-01 00:00:00',NULL,NULL),(562,12,'Nemocón','hrojas','2010-01-01 00:00:00',NULL,NULL),(563,12,'Nilo','hrojas','2010-01-01 00:00:00',NULL,NULL),(564,12,'Nimaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(565,12,'Nocaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(566,12,'Pacho','hrojas','2010-01-01 00:00:00',NULL,NULL),(567,12,'Paime','hrojas','2010-01-01 00:00:00',NULL,NULL),(568,12,'Pandi','hrojas','2010-01-01 00:00:00',NULL,NULL),(569,12,'Paratebueno','hrojas','2010-01-01 00:00:00',NULL,NULL),(570,12,'Pasca','hrojas','2010-01-01 00:00:00',NULL,NULL),(571,12,'Puerto Salgar','hrojas','2010-01-01 00:00:00',NULL,NULL),(572,12,'Pulí','hrojas','2010-01-01 00:00:00',NULL,NULL),(573,12,'Quebradanegra','hrojas','2010-01-01 00:00:00',NULL,NULL),(574,12,'Quetame','hrojas','2010-01-01 00:00:00',NULL,NULL),(575,12,'Quipile','hrojas','2010-01-01 00:00:00',NULL,NULL),(576,12,'Rafael','hrojas','2010-01-01 00:00:00',NULL,NULL),(577,12,'Ricaurte','hrojas','2010-01-01 00:00:00',NULL,NULL),(578,12,'San Antonio de Tequendama','hrojas','2010-01-01 00:00:00',NULL,NULL),(579,12,'San Bernardo','hrojas','2010-01-01 00:00:00',NULL,NULL),(580,12,'San Cayetano','hrojas','2010-01-01 00:00:00',NULL,NULL),(581,12,'San Francisco','hrojas','2010-01-01 00:00:00',NULL,NULL),(582,12,'San Juan de Rioseco','hrojas','2010-01-01 00:00:00',NULL,NULL),(583,12,'Sasaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(584,12,'Sesquilé','hrojas','2010-01-01 00:00:00',NULL,NULL),(585,12,'Sibate','hrojas','2010-01-01 00:00:00',NULL,NULL),(586,12,'Silvania','hrojas','2010-01-01 00:00:00',NULL,NULL),(587,12,'Simijaca','hrojas','2010-01-01 00:00:00',NULL,NULL),(588,12,'Soacha','hrojas','2010-01-01 00:00:00',NULL,NULL),(589,12,'Sopó','hrojas','2010-01-01 00:00:00',NULL,NULL),(590,12,'Subachoque','hrojas','2010-01-01 00:00:00',NULL,NULL),(591,12,'Suesca','hrojas','2010-01-01 00:00:00',NULL,NULL),(592,12,'Supatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(593,12,'Susa','hrojas','2010-01-01 00:00:00',NULL,NULL),(594,12,'Sutatausa','hrojas','2010-01-01 00:00:00',NULL,NULL),(595,12,'Tabio','hrojas','2010-01-01 00:00:00',NULL,NULL),(596,12,'Tausa','hrojas','2010-01-01 00:00:00',NULL,NULL),(597,12,'Tena','hrojas','2010-01-01 00:00:00',NULL,NULL),(598,12,'Tenjo','hrojas','2010-01-01 00:00:00',NULL,NULL),(599,12,'Tibacuy','hrojas','2010-01-01 00:00:00',NULL,NULL),(600,12,'Tibiritá','hrojas','2010-01-01 00:00:00',NULL,NULL),(601,12,'Tocaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(602,12,'Tocancipá','hrojas','2010-01-01 00:00:00',NULL,NULL),(603,12,'Topaipí','hrojas','2010-01-01 00:00:00',NULL,NULL),(604,12,'Ubalá','hrojas','2010-01-01 00:00:00',NULL,NULL),(605,12,'Ubaque','hrojas','2010-01-01 00:00:00',NULL,NULL),(606,12,'Ubaté','hrojas','2010-01-01 00:00:00',NULL,NULL),(607,12,'Une','hrojas','2010-01-01 00:00:00',NULL,NULL),(608,12,'Útica','hrojas','2010-01-01 00:00:00',NULL,NULL),(609,12,'Venecia (Ospina Pérez)','hrojas','2010-01-01 00:00:00',NULL,NULL),(610,12,'Vergara','hrojas','2010-01-01 00:00:00',NULL,NULL),(611,12,'Vianí','hrojas','2010-01-01 00:00:00',NULL,NULL),(612,12,'Villagómez','hrojas','2010-01-01 00:00:00',NULL,NULL),(613,12,'Villapinzón','hrojas','2010-01-01 00:00:00',NULL,NULL),(614,12,'Villeta','hrojas','2010-01-01 00:00:00',NULL,NULL),(615,12,'Viotá','hrojas','2010-01-01 00:00:00',NULL,NULL),(616,12,'Yacopí','hrojas','2010-01-01 00:00:00',NULL,NULL),(617,12,'Zipacón','hrojas','2010-01-01 00:00:00',NULL,NULL),(618,12,'Zipaquirá','hrojas','2010-01-01 00:00:00',NULL,NULL),(619,14,'Puerto Inírida','hrojas','2010-01-01 00:00:00',NULL,NULL),(620,15,'Calamar','hrojas','2010-01-01 00:00:00',NULL,NULL),(621,15,'El Retorno','hrojas','2010-01-01 00:00:00',NULL,NULL),(622,15,'Miraflores','hrojas','2010-01-01 00:00:00',NULL,NULL),(623,15,'San José del Guaviare','hrojas','2010-01-01 00:00:00',NULL,NULL),(624,16,'Acevedo','hrojas','2010-01-01 00:00:00',NULL,NULL),(625,16,'Agrado','hrojas','2010-01-01 00:00:00',NULL,NULL),(626,16,'Aipe','hrojas','2010-01-01 00:00:00',NULL,NULL),(627,16,'Algeciras','hrojas','2010-01-01 00:00:00',NULL,NULL),(628,16,'Altamira','hrojas','2010-01-01 00:00:00',NULL,NULL),(629,16,'Baraya','hrojas','2010-01-01 00:00:00',NULL,NULL),(630,16,'Campoalegre','hrojas','2010-01-01 00:00:00',NULL,NULL),(631,16,'Colombia','hrojas','2010-01-01 00:00:00',NULL,NULL),(632,16,'Elías','hrojas','2010-01-01 00:00:00',NULL,NULL),(633,16,'Garzón','hrojas','2010-01-01 00:00:00',NULL,NULL),(634,16,'Gigante','hrojas','2010-01-01 00:00:00',NULL,NULL),(635,16,'Guadalupe','hrojas','2010-01-01 00:00:00',NULL,NULL),(636,16,'Hobo','hrojas','2010-01-01 00:00:00',NULL,NULL),(637,16,'Iquira','hrojas','2010-01-01 00:00:00',NULL,NULL),(638,16,'Isnos','hrojas','2010-01-01 00:00:00',NULL,NULL),(639,16,'La Argentina','hrojas','2010-01-01 00:00:00',NULL,NULL),(640,16,'La Plata','hrojas','2010-01-01 00:00:00',NULL,NULL),(641,16,'Nátaga','hrojas','2010-01-01 00:00:00',NULL,NULL),(642,16,'Neiva','hrojas','2010-01-01 00:00:00',NULL,NULL),(643,16,'Oporapa','hrojas','2010-01-01 00:00:00',NULL,NULL),(644,16,'Paicol','hrojas','2010-01-01 00:00:00',NULL,NULL),(645,16,'Palermo','hrojas','2010-01-01 00:00:00',NULL,NULL),(646,16,'Palestina','hrojas','2010-01-01 00:00:00',NULL,NULL),(647,16,'Pital','hrojas','2010-01-01 00:00:00',NULL,NULL),(648,16,'Pitalito','hrojas','2010-01-01 00:00:00',NULL,NULL),(649,16,'Rivera','hrojas','2010-01-01 00:00:00',NULL,NULL),(650,16,'Saladoblanco','hrojas','2010-01-01 00:00:00',NULL,NULL),(651,16,'San Agustín','hrojas','2010-01-01 00:00:00',NULL,NULL),(652,16,'Santa María','hrojas','2010-01-01 00:00:00',NULL,NULL),(653,16,'Suazá','hrojas','2010-01-01 00:00:00',NULL,NULL),(654,16,'Tarqui','hrojas','2010-01-01 00:00:00',NULL,NULL),(655,16,'Tello','hrojas','2010-01-01 00:00:00',NULL,NULL),(656,16,'Teruel','hrojas','2010-01-01 00:00:00',NULL,NULL),(657,16,'Tesalia','hrojas','2010-01-01 00:00:00',NULL,NULL),(658,16,'Timaná','hrojas','2010-01-01 00:00:00',NULL,NULL),(659,16,'Villavieja','hrojas','2010-01-01 00:00:00',NULL,NULL),(660,16,'Yaguará','hrojas','2010-01-01 00:00:00',NULL,NULL),(661,17,'Barrancas','hrojas','2010-01-01 00:00:00',NULL,NULL),(662,17,'Dibulla','hrojas','2010-01-01 00:00:00',NULL,NULL),(663,17,'Distracción','hrojas','2010-01-01 00:00:00',NULL,NULL),(664,17,'El Molino','hrojas','2010-01-01 00:00:00',NULL,NULL),(665,17,'Fonseca','hrojas','2010-01-01 00:00:00',NULL,NULL),(666,17,'Hatonuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(667,17,'Maicao','hrojas','2010-01-01 00:00:00',NULL,NULL),(668,17,'Manaure','hrojas','2010-01-01 00:00:00',NULL,NULL),(669,17,'Riohacha','hrojas','2010-01-01 00:00:00',NULL,NULL),(670,17,'San Juan del Cesar','hrojas','2010-01-01 00:00:00',NULL,NULL),(671,17,'Uribía','hrojas','2010-01-01 00:00:00',NULL,NULL),(672,17,'Urumita','hrojas','2010-01-01 00:00:00',NULL,NULL),(673,17,'Villanueva','hrojas','2010-01-01 00:00:00',NULL,NULL),(674,18,'Aracataca','hrojas','2010-01-01 00:00:00',NULL,NULL),(675,18,'Ariguaní (El Difícil)','hrojas','2010-01-01 00:00:00',NULL,NULL),(676,18,'Cerro San Antonio','hrojas','2010-01-01 00:00:00',NULL,NULL),(677,18,'Chivolo','hrojas','2010-01-01 00:00:00',NULL,NULL),(678,18,'Ciénaga','hrojas','2010-01-01 00:00:00',NULL,NULL),(679,18,'El Banco','hrojas','2010-01-01 00:00:00',NULL,NULL),(680,18,'El Piñón','hrojas','2010-01-01 00:00:00',NULL,NULL),(681,18,'El Retén','hrojas','2010-01-01 00:00:00',NULL,NULL),(682,18,'Fundación','hrojas','2010-01-01 00:00:00',NULL,NULL),(683,18,'Guamal','hrojas','2010-01-01 00:00:00',NULL,NULL),(684,18,'Pedraza','hrojas','2010-01-01 00:00:00',NULL,NULL),(685,18,'Pijiño del Carmen','hrojas','2010-01-01 00:00:00',NULL,NULL),(686,18,'Pivijay','hrojas','2010-01-01 00:00:00',NULL,NULL),(687,18,'Plato','hrojas','2010-01-01 00:00:00',NULL,NULL),(688,18,'Publoviejo','hrojas','2010-01-01 00:00:00',NULL,NULL),(689,18,'Remolino','hrojas','2010-01-01 00:00:00',NULL,NULL),(690,18,'Salamina','hrojas','2010-01-01 00:00:00',NULL,NULL),(691,18,'San Sebastián de Buuenavista','hrojas','2010-01-01 00:00:00',NULL,NULL),(692,18,'San Zenón','hrojas','2010-01-01 00:00:00',NULL,NULL),(693,18,'Santa Ana','hrojas','2010-01-01 00:00:00',NULL,NULL),(694,18,'Santa Marta','hrojas','2010-01-01 00:00:00',NULL,NULL),(695,18,'Sitionuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(696,18,'Tenerife','hrojas','2010-01-01 00:00:00',NULL,NULL),(697,19,'Acacias','hrojas','2010-01-01 00:00:00',NULL,NULL),(698,19,'Barranca de Upía','hrojas','2010-01-01 00:00:00',NULL,NULL),(699,19,'Cabuyaro','hrojas','2010-01-01 00:00:00',NULL,NULL),(700,19,'Castilla la Nueva','hrojas','2010-01-01 00:00:00',NULL,NULL),(701,19,'Cubarral','hrojas','2010-01-01 00:00:00',NULL,NULL),(702,19,'Cumaral','hrojas','2010-01-01 00:00:00',NULL,NULL),(703,19,'El Calvario','hrojas','2010-01-01 00:00:00',NULL,NULL),(704,19,'El Castillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(705,19,'El Dorado','hrojas','2010-01-01 00:00:00',NULL,NULL),(706,19,'Fuente de Oro','hrojas','2010-01-01 00:00:00',NULL,NULL),(707,19,'Granada','hrojas','2010-01-01 00:00:00',NULL,NULL),(708,19,'Guamal','hrojas','2010-01-01 00:00:00',NULL,NULL),(709,19,'La Macarena','hrojas','2010-01-01 00:00:00',NULL,NULL),(710,19,'La Uribe','hrojas','2010-01-01 00:00:00',NULL,NULL),(711,19,'Lejanías','hrojas','2010-01-01 00:00:00',NULL,NULL),(712,19,'Mapiripán','hrojas','2010-01-01 00:00:00',NULL,NULL),(713,19,'Mesetas','hrojas','2010-01-01 00:00:00',NULL,NULL),(714,19,'Puerto Concordia','hrojas','2010-01-01 00:00:00',NULL,NULL),(715,19,'Puerto Gaitán','hrojas','2010-01-01 00:00:00',NULL,NULL),(716,19,'Puerto Lleras','hrojas','2010-01-01 00:00:00',NULL,NULL),(717,19,'Puerto López','hrojas','2010-01-01 00:00:00',NULL,NULL),(718,19,'Puerto Rico','hrojas','2010-01-01 00:00:00',NULL,NULL),(719,19,'Restrepo','hrojas','2010-01-01 00:00:00',NULL,NULL),(720,19,'San Carlos de Guaroa','hrojas','2010-01-01 00:00:00',NULL,NULL),(721,19,'San Juan de Arama','hrojas','2010-01-01 00:00:00',NULL,NULL),(722,19,'San Juanito','hrojas','2010-01-01 00:00:00',NULL,NULL),(723,19,'San Martín','hrojas','2010-01-01 00:00:00',NULL,NULL),(724,19,'Villavicencio','hrojas','2010-01-01 00:00:00',NULL,NULL),(725,19,'Vistahermosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(726,20,'Albán (San José)','hrojas','2010-01-01 00:00:00',NULL,NULL),(727,20,'Aldana','hrojas','2010-01-01 00:00:00',NULL,NULL),(728,20,'Ancuyá','hrojas','2010-01-01 00:00:00',NULL,NULL),(729,20,'Arboleda (Berruecos)','hrojas','2010-01-01 00:00:00',NULL,NULL),(730,20,'Barbacoas','hrojas','2010-01-01 00:00:00',NULL,NULL),(731,20,'Belén','hrojas','2010-01-01 00:00:00',NULL,NULL),(732,20,'Buesaco','hrojas','2010-01-01 00:00:00',NULL,NULL),(733,20,'Chachagüi','hrojas','2010-01-01 00:00:00',NULL,NULL),(734,20,'Colón (Génova)','hrojas','2010-01-01 00:00:00',NULL,NULL),(735,20,'Consacá','hrojas','2010-01-01 00:00:00',NULL,NULL),(736,20,'Contadero','hrojas','2010-01-01 00:00:00',NULL,NULL),(737,20,'Córdoba','hrojas','2010-01-01 00:00:00',NULL,NULL),(738,20,'Cuaspud (Carlosama)','hrojas','2010-01-01 00:00:00',NULL,NULL),(739,20,'Cumbal','hrojas','2010-01-01 00:00:00',NULL,NULL),(740,20,'Cumbitará','hrojas','2010-01-01 00:00:00',NULL,NULL),(741,20,'El Charco','hrojas','2010-01-01 00:00:00',NULL,NULL),(742,20,'El Rosario','hrojas','2010-01-01 00:00:00',NULL,NULL),(743,20,'El Tablón','hrojas','2010-01-01 00:00:00',NULL,NULL),(744,20,'El Tambo','hrojas','2010-01-01 00:00:00',NULL,NULL),(745,20,'Francisco Pizarro','hrojas','2010-01-01 00:00:00',NULL,NULL),(746,20,'Funes','hrojas','2010-01-01 00:00:00',NULL,NULL),(747,20,'Guachucal','hrojas','2010-01-01 00:00:00',NULL,NULL),(748,20,'Guaitarilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(749,20,'Gualmatán','hrojas','2010-01-01 00:00:00',NULL,NULL),(750,20,'Iles','hrojas','2010-01-01 00:00:00',NULL,NULL),(751,20,'Imúes','hrojas','2010-01-01 00:00:00',NULL,NULL),(752,20,'Ipiales','hrojas','2010-01-01 00:00:00',NULL,NULL),(753,20,'La Cruz','hrojas','2010-01-01 00:00:00',NULL,NULL),(754,20,'La Florida','hrojas','2010-01-01 00:00:00',NULL,NULL),(755,20,'La Llanada','hrojas','2010-01-01 00:00:00',NULL,NULL),(756,20,'La Tola','hrojas','2010-01-01 00:00:00',NULL,NULL),(757,20,'La Unión','hrojas','2010-01-01 00:00:00',NULL,NULL),(758,20,'Leiva','hrojas','2010-01-01 00:00:00',NULL,NULL),(759,20,'Linares','hrojas','2010-01-01 00:00:00',NULL,NULL),(760,20,'Los Andes (Sotomayor)','hrojas','2010-01-01 00:00:00',NULL,NULL),(761,20,'Magüí (Payán)','hrojas','2010-01-01 00:00:00',NULL,NULL),(762,20,'Mallama (Piedrancha)','hrojas','2010-01-01 00:00:00',NULL,NULL),(763,20,'Mosquera','hrojas','2010-01-01 00:00:00',NULL,NULL),(764,20,'Olaya','hrojas','2010-01-01 00:00:00',NULL,NULL),(765,20,'Ospina','hrojas','2010-01-01 00:00:00',NULL,NULL),(766,20,'Pasto','hrojas','2010-01-01 00:00:00',NULL,NULL),(767,20,'Policarpa','hrojas','2010-01-01 00:00:00',NULL,NULL),(768,20,'Potosí','hrojas','2010-01-01 00:00:00',NULL,NULL),(769,20,'Providencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(770,20,'Puerres','hrojas','2010-01-01 00:00:00',NULL,NULL),(771,20,'Pupiales','hrojas','2010-01-01 00:00:00',NULL,NULL),(772,20,'Ricaurte','hrojas','2010-01-01 00:00:00',NULL,NULL),(773,20,'Roberto Payán (San José)','hrojas','2010-01-01 00:00:00',NULL,NULL),(774,20,'Samaniego','hrojas','2010-01-01 00:00:00',NULL,NULL),(775,20,'San Bernardo','hrojas','2010-01-01 00:00:00',NULL,NULL),(776,20,'San Lorenzo','hrojas','2010-01-01 00:00:00',NULL,NULL),(777,20,'San Pablo','hrojas','2010-01-01 00:00:00',NULL,NULL),(778,20,'San Pedro de Cartago','hrojas','2010-01-01 00:00:00',NULL,NULL),(779,20,'Sandoná','hrojas','2010-01-01 00:00:00',NULL,NULL),(780,20,'Santa Bárbara (Iscuandé)','hrojas','2010-01-01 00:00:00',NULL,NULL),(781,20,'Santa Cruz (Guachávez)','hrojas','2010-01-01 00:00:00',NULL,NULL),(782,20,'Sapuyés','hrojas','2010-01-01 00:00:00',NULL,NULL),(783,20,'Taminango','hrojas','2010-01-01 00:00:00',NULL,NULL),(784,20,'Tangua','hrojas','2010-01-01 00:00:00',NULL,NULL),(785,20,'Tumaco','hrojas','2010-01-01 00:00:00',NULL,NULL),(786,20,'Túquerres','hrojas','2010-01-01 00:00:00',NULL,NULL),(787,20,'Yacuanquer','hrojas','2010-01-01 00:00:00',NULL,NULL),(788,21,'Abrego','hrojas','2010-01-01 00:00:00',NULL,NULL),(789,21,'Arboledas','hrojas','2010-01-01 00:00:00',NULL,NULL),(790,21,'Bochalema','hrojas','2010-01-01 00:00:00',NULL,NULL),(791,21,'Bucarasica','hrojas','2010-01-01 00:00:00',NULL,NULL),(792,21,'Cáchira','hrojas','2010-01-01 00:00:00',NULL,NULL),(793,21,'Cácota','hrojas','2010-01-01 00:00:00',NULL,NULL),(794,21,'Chinácota','hrojas','2010-01-01 00:00:00',NULL,NULL),(795,21,'Chitagá','hrojas','2010-01-01 00:00:00',NULL,NULL),(796,21,'Convención','hrojas','2010-01-01 00:00:00',NULL,NULL),(797,21,'Cúcuta','hrojas','2010-01-01 00:00:00',NULL,NULL),(798,21,'Cucutilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(799,21,'Durania','hrojas','2010-01-01 00:00:00',NULL,NULL),(800,21,'El Carmen','hrojas','2010-01-01 00:00:00',NULL,NULL),(801,21,'El Tarra','hrojas','2010-01-01 00:00:00',NULL,NULL),(802,21,'El Zulia','hrojas','2010-01-01 00:00:00',NULL,NULL),(803,21,'Gramalote','hrojas','2010-01-01 00:00:00',NULL,NULL),(804,21,'Hacarí','hrojas','2010-01-01 00:00:00',NULL,NULL),(805,21,'Herrán','hrojas','2010-01-01 00:00:00',NULL,NULL),(806,21,'La Esperanza','hrojas','2010-01-01 00:00:00',NULL,NULL),(807,21,'La Playa','hrojas','2010-01-01 00:00:00',NULL,NULL),(808,21,'Labateca','hrojas','2010-01-01 00:00:00',NULL,NULL),(809,21,'Los Patios','hrojas','2010-01-01 00:00:00',NULL,NULL),(810,21,'Lourdes','hrojas','2010-01-01 00:00:00',NULL,NULL),(811,21,'Mutiscua','hrojas','2010-01-01 00:00:00',NULL,NULL),(812,21,'Ocaña','hrojas','2010-01-01 00:00:00',NULL,NULL),(813,21,'Pamplona','hrojas','2010-01-01 00:00:00',NULL,NULL),(814,21,'Pamplonita','hrojas','2010-01-01 00:00:00',NULL,NULL),(815,21,'Puerto Santander','hrojas','2010-01-01 00:00:00',NULL,NULL),(816,21,'Ragonvalia','hrojas','2010-01-01 00:00:00',NULL,NULL),(817,21,'Salazar','hrojas','2010-01-01 00:00:00',NULL,NULL),(818,21,'San Calixto','hrojas','2010-01-01 00:00:00',NULL,NULL),(819,21,'San Cayetano','hrojas','2010-01-01 00:00:00',NULL,NULL),(820,21,'Santiago','hrojas','2010-01-01 00:00:00',NULL,NULL),(821,21,'Sardinata','hrojas','2010-01-01 00:00:00',NULL,NULL),(822,21,'Silos','hrojas','2010-01-01 00:00:00',NULL,NULL),(823,21,'Teorama','hrojas','2010-01-01 00:00:00',NULL,NULL),(824,21,'Tibú','hrojas','2010-01-01 00:00:00',NULL,NULL),(825,21,'Toledo','hrojas','2010-01-01 00:00:00',NULL,NULL),(826,21,'Villa del Rosario','hrojas','2010-01-01 00:00:00',NULL,NULL),(827,21,'Villacaro','hrojas','2010-01-01 00:00:00',NULL,NULL),(828,22,'Colón','hrojas','2010-01-01 00:00:00',NULL,NULL),(829,22,'Mocoa','hrojas','2010-01-01 00:00:00',NULL,NULL),(830,22,'Orito','hrojas','2010-01-01 00:00:00',NULL,NULL),(831,22,'Puerto Asís','hrojas','2010-01-01 00:00:00',NULL,NULL),(832,22,'Puerto Caicedo','hrojas','2010-01-01 00:00:00',NULL,NULL),(833,22,'Puerto Guzmán','hrojas','2010-01-01 00:00:00',NULL,NULL),(834,22,'Puerto Leguízamo','hrojas','2010-01-01 00:00:00',NULL,NULL),(835,22,'San Francisco','hrojas','2010-01-01 00:00:00',NULL,NULL),(836,22,'San Miguel','hrojas','2010-01-01 00:00:00',NULL,NULL),(837,22,'Santiago','hrojas','2010-01-01 00:00:00',NULL,NULL),(838,22,'Sibundoy','hrojas','2010-01-01 00:00:00',NULL,NULL),(839,22,'Villa Gamuez (La Hormiga)','hrojas','2010-01-01 00:00:00',NULL,NULL),(840,22,'Villa Garzón','hrojas','2010-01-01 00:00:00',NULL,NULL),(841,23,'Armenia','hrojas','2010-01-01 00:00:00',NULL,NULL),(842,23,'Buenavista','hrojas','2010-01-01 00:00:00',NULL,NULL),(843,23,'Calarcá','hrojas','2010-01-01 00:00:00',NULL,NULL),(844,23,'Circasia','hrojas','2010-01-01 00:00:00',NULL,NULL),(845,23,'Córdoba','hrojas','2010-01-01 00:00:00',NULL,NULL),(846,23,'Filandia','hrojas','2010-01-01 00:00:00',NULL,NULL),(847,23,'Génova','hrojas','2010-01-01 00:00:00',NULL,NULL),(848,23,'La Tebaida','hrojas','2010-01-01 00:00:00',NULL,NULL),(849,23,'Montenegro','hrojas','2010-01-01 00:00:00',NULL,NULL),(850,23,'Pijao','hrojas','2010-01-01 00:00:00',NULL,NULL),(851,23,'Quimbaya','hrojas','2010-01-01 00:00:00',NULL,NULL),(852,23,'Salento','hrojas','2010-01-01 00:00:00',NULL,NULL),(853,24,'Apía','hrojas','2010-01-01 00:00:00',NULL,NULL),(854,24,'Balboa','hrojas','2010-01-01 00:00:00',NULL,NULL),(855,24,'Belén de Umbría','hrojas','2010-01-01 00:00:00',NULL,NULL),(856,24,'Dos Quebradas','hrojas','2010-01-01 00:00:00',NULL,NULL),(857,24,'Guática','hrojas','2010-01-01 00:00:00',NULL,NULL),(858,24,'La Celia','hrojas','2010-01-01 00:00:00',NULL,NULL),(859,24,'La Virginia','hrojas','2010-01-01 00:00:00',NULL,NULL),(860,24,'Marsella','hrojas','2010-01-01 00:00:00',NULL,NULL),(861,24,'Mistrató','hrojas','2010-01-01 00:00:00',NULL,NULL),(862,24,'Pereira','hrojas','2010-01-01 00:00:00',NULL,NULL),(863,24,'Pueblo Rico','hrojas','2010-01-01 00:00:00',NULL,NULL),(864,24,'Quinchia','hrojas','2010-01-01 00:00:00',NULL,NULL),(865,24,'Santa Rosa de Cabal','hrojas','2010-01-01 00:00:00',NULL,NULL),(866,24,'Santuario','hrojas','2010-01-01 00:00:00',NULL,NULL),(867,25,'Providencia','hrojas','2010-01-01 00:00:00',NULL,NULL),(868,25,'San Andrés','hrojas','2010-01-01 00:00:00',NULL,NULL),(869,12,'Bogotá','hrojas','2010-01-01 00:00:00',NULL,NULL),(870,27,'Aguada','hrojas','2010-01-01 00:00:00',NULL,NULL),(871,27,'Albania','hrojas','2010-01-01 00:00:00',NULL,NULL),(872,27,'Aratoca','hrojas','2010-01-01 00:00:00',NULL,NULL),(873,27,'Barbosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(874,27,'Barichara','hrojas','2010-01-01 00:00:00',NULL,NULL),(875,27,'Barrancabermeja','hrojas','2010-01-01 00:00:00',NULL,NULL),(876,27,'Betulia','hrojas','2010-01-01 00:00:00',NULL,NULL),(877,27,'Bolívar','hrojas','2010-01-01 00:00:00',NULL,NULL),(878,27,'Bucaramanga','hrojas','2010-01-01 00:00:00',NULL,NULL),(879,27,'Cabrera','hrojas','2010-01-01 00:00:00',NULL,NULL),(880,27,'California','hrojas','2010-01-01 00:00:00',NULL,NULL),(881,27,'Capitanejo','hrojas','2010-01-01 00:00:00',NULL,NULL),(882,27,'Carcasí','hrojas','2010-01-01 00:00:00',NULL,NULL),(883,27,'Cepitá','hrojas','2010-01-01 00:00:00',NULL,NULL),(884,27,'Cerrito','hrojas','2010-01-01 00:00:00',NULL,NULL),(885,27,'Charalá','hrojas','2010-01-01 00:00:00',NULL,NULL),(886,27,'Charta','hrojas','2010-01-01 00:00:00',NULL,NULL),(887,27,'Chima','hrojas','2010-01-01 00:00:00',NULL,NULL),(888,27,'Chipatá','hrojas','2010-01-01 00:00:00',NULL,NULL),(889,27,'Cimitarra','hrojas','2010-01-01 00:00:00',NULL,NULL),(890,27,'Concepción','hrojas','2010-01-01 00:00:00',NULL,NULL),(891,27,'Confines','hrojas','2010-01-01 00:00:00',NULL,NULL),(892,27,'Contratación','hrojas','2010-01-01 00:00:00',NULL,NULL),(893,27,'Coromoro','hrojas','2010-01-01 00:00:00',NULL,NULL),(894,27,'Curití','hrojas','2010-01-01 00:00:00',NULL,NULL),(895,27,'El Carmen','hrojas','2010-01-01 00:00:00',NULL,NULL),(896,27,'El Guacamayo','hrojas','2010-01-01 00:00:00',NULL,NULL),(897,27,'El Peñón','hrojas','2010-01-01 00:00:00',NULL,NULL),(898,27,'El Playón','hrojas','2010-01-01 00:00:00',NULL,NULL),(899,27,'Encino','hrojas','2010-01-01 00:00:00',NULL,NULL),(900,27,'Enciso','hrojas','2010-01-01 00:00:00',NULL,NULL),(901,27,'Florián','hrojas','2010-01-01 00:00:00',NULL,NULL),(902,27,'Floridablanca','hrojas','2010-01-01 00:00:00',NULL,NULL),(903,27,'Galán','hrojas','2010-01-01 00:00:00',NULL,NULL),(904,27,'Gámbita','hrojas','2010-01-01 00:00:00',NULL,NULL),(905,27,'Girón','hrojas','2010-01-01 00:00:00',NULL,NULL),(906,27,'Guaca','hrojas','2010-01-01 00:00:00',NULL,NULL),(907,27,'Guadalupe','hrojas','2010-01-01 00:00:00',NULL,NULL),(908,27,'Guapotá','hrojas','2010-01-01 00:00:00',NULL,NULL),(909,27,'Guavata','hrojas','2010-01-01 00:00:00',NULL,NULL),(910,27,'Guepsa','hrojas','2010-01-01 00:00:00',NULL,NULL),(911,27,'Hato','hrojas','2010-01-01 00:00:00',NULL,NULL),(912,27,'Jesús María','hrojas','2010-01-01 00:00:00',NULL,NULL),(913,27,'Jordán','hrojas','2010-01-01 00:00:00',NULL,NULL),(914,27,'La Belleza','hrojas','2010-01-01 00:00:00',NULL,NULL),(915,27,'La Paz','hrojas','2010-01-01 00:00:00',NULL,NULL),(916,27,'Landázuri','hrojas','2010-01-01 00:00:00',NULL,NULL),(917,27,'Lebrija','hrojas','2010-01-01 00:00:00',NULL,NULL),(918,27,'Los Santos','hrojas','2010-01-01 00:00:00',NULL,NULL),(919,27,'Macaravita','hrojas','2010-01-01 00:00:00',NULL,NULL),(920,27,'Málaga','hrojas','2010-01-01 00:00:00',NULL,NULL),(921,27,'Matanza','hrojas','2010-01-01 00:00:00',NULL,NULL),(922,27,'Mogotes','hrojas','2010-01-01 00:00:00',NULL,NULL),(923,27,'Molagavita','hrojas','2010-01-01 00:00:00',NULL,NULL),(924,27,'Ocamonte','hrojas','2010-01-01 00:00:00',NULL,NULL),(925,27,'Oiba','hrojas','2010-01-01 00:00:00',NULL,NULL),(926,27,'Onzága','hrojas','2010-01-01 00:00:00',NULL,NULL),(927,27,'Palmar','hrojas','2010-01-01 00:00:00',NULL,NULL),(928,27,'Palmas del Socorro','hrojas','2010-01-01 00:00:00',NULL,NULL),(929,27,'Páramo','hrojas','2010-01-01 00:00:00',NULL,NULL),(930,27,'Pie de Cuesta','hrojas','2010-01-01 00:00:00',NULL,NULL),(931,27,'Pinchote','hrojas','2010-01-01 00:00:00',NULL,NULL),(932,27,'Puente Nacional','hrojas','2010-01-01 00:00:00',NULL,NULL),(933,27,'Puerto Parra','hrojas','2010-01-01 00:00:00',NULL,NULL),(934,27,'Puerto Wilches','hrojas','2010-01-01 00:00:00',NULL,NULL),(935,27,'Rionegro','hrojas','2010-01-01 00:00:00',NULL,NULL),(936,27,'Sabana de Torres','hrojas','2010-01-01 00:00:00',NULL,NULL),(937,27,'San Andrés','hrojas','2010-01-01 00:00:00',NULL,NULL),(938,27,'San Benito','hrojas','2010-01-01 00:00:00',NULL,NULL),(939,27,'San Gil','hrojas','2010-01-01 00:00:00',NULL,NULL),(940,27,'San Joaquín','hrojas','2010-01-01 00:00:00',NULL,NULL),(941,27,'San José de Miranda','hrojas','2010-01-01 00:00:00',NULL,NULL),(942,27,'San Miguel','hrojas','2010-01-01 00:00:00',NULL,NULL),(943,27,'San Vicente de Chucurí','hrojas','2010-01-01 00:00:00',NULL,NULL),(944,27,'Santa Bárbara','hrojas','2010-01-01 00:00:00',NULL,NULL),(945,27,'Santa Helena del Opón','hrojas','2010-01-01 00:00:00',NULL,NULL),(946,27,'Simacota','hrojas','2010-01-01 00:00:00',NULL,NULL),(947,27,'Socorro','hrojas','2010-01-01 00:00:00',NULL,NULL),(948,27,'Suaita','hrojas','2010-01-01 00:00:00',NULL,NULL),(949,27,'Sucre','hrojas','2010-01-01 00:00:00',NULL,NULL),(950,27,'Suratá','hrojas','2010-01-01 00:00:00',NULL,NULL),(951,27,'Tona','hrojas','2010-01-01 00:00:00',NULL,NULL),(952,27,'Valle de San José','hrojas','2010-01-01 00:00:00',NULL,NULL),(953,27,'Vélez','hrojas','2010-01-01 00:00:00',NULL,NULL),(954,27,'Vetas','hrojas','2010-01-01 00:00:00',NULL,NULL),(955,27,'Villanueva','hrojas','2010-01-01 00:00:00',NULL,NULL),(956,27,'Zapatoca','hrojas','2010-01-01 00:00:00',NULL,NULL),(957,28,'Buenavista','hrojas','2010-01-01 00:00:00',NULL,NULL),(958,28,'Caimito','hrojas','2010-01-01 00:00:00',NULL,NULL),(959,28,'Chalán','hrojas','2010-01-01 00:00:00',NULL,NULL),(960,28,'Coloso (Ricaurte)','hrojas','2010-01-01 00:00:00',NULL,NULL),(961,28,'Corozal','hrojas','2010-01-01 00:00:00',NULL,NULL),(962,28,'Galeras (Nueva Granada)','hrojas','2010-01-01 00:00:00',NULL,NULL),(963,28,'Guarandá','hrojas','2010-01-01 00:00:00',NULL,NULL),(964,28,'La Unión','hrojas','2010-01-01 00:00:00',NULL,NULL),(965,28,'Los Palmitos','hrojas','2010-01-01 00:00:00',NULL,NULL),(966,28,'Majagual','hrojas','2010-01-01 00:00:00',NULL,NULL),(967,28,'Morroa','hrojas','2010-01-01 00:00:00',NULL,NULL),(968,28,'Ovejas','hrojas','2010-01-01 00:00:00',NULL,NULL),(969,28,'Palmito','hrojas','2010-01-01 00:00:00',NULL,NULL),(970,28,'Sampués','hrojas','2010-01-01 00:00:00',NULL,NULL),(971,28,'San Benito Abad','hrojas','2010-01-01 00:00:00',NULL,NULL),(972,28,'San Juan de Betulia','hrojas','2010-01-01 00:00:00',NULL,NULL),(973,28,'San Marcos','hrojas','2010-01-01 00:00:00',NULL,NULL),(974,28,'San Onofre','hrojas','2010-01-01 00:00:00',NULL,NULL),(975,28,'San Pedro','hrojas','2010-01-01 00:00:00',NULL,NULL),(976,28,'Sincé','hrojas','2010-01-01 00:00:00',NULL,NULL),(977,28,'Sincelejo','hrojas','2010-01-01 00:00:00',NULL,NULL),(978,28,'Sucre','hrojas','2010-01-01 00:00:00',NULL,NULL),(979,28,'Tolú','hrojas','2010-01-01 00:00:00',NULL,NULL),(980,28,'Toluviejo','hrojas','2010-01-01 00:00:00',NULL,NULL),(981,29,'Alpujarra','hrojas','2010-01-01 00:00:00',NULL,NULL),(982,29,'Alvarado','hrojas','2010-01-01 00:00:00',NULL,NULL),(983,29,'Ambalema','hrojas','2010-01-01 00:00:00',NULL,NULL),(984,29,'Anzóategui','hrojas','2010-01-01 00:00:00',NULL,NULL),(985,29,'Armero (Guayabal)','hrojas','2010-01-01 00:00:00',NULL,NULL),(986,29,'Ataco','hrojas','2010-01-01 00:00:00',NULL,NULL),(987,29,'Cajamarca','hrojas','2010-01-01 00:00:00',NULL,NULL),(988,29,'Carmen de Apicalá','hrojas','2010-01-01 00:00:00',NULL,NULL),(989,29,'Casabianca','hrojas','2010-01-01 00:00:00',NULL,NULL),(990,29,'Chaparral','hrojas','2010-01-01 00:00:00',NULL,NULL),(991,29,'Coello','hrojas','2010-01-01 00:00:00',NULL,NULL),(992,29,'Coyaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(993,29,'Cunday','hrojas','2010-01-01 00:00:00',NULL,NULL),(994,29,'Dolores','hrojas','2010-01-01 00:00:00',NULL,NULL),(995,29,'Espinal','hrojas','2010-01-01 00:00:00',NULL,NULL),(996,29,'Falán','hrojas','2010-01-01 00:00:00',NULL,NULL),(997,29,'Flandes','hrojas','2010-01-01 00:00:00',NULL,NULL),(998,29,'Fresno','hrojas','2010-01-01 00:00:00',NULL,NULL),(999,29,'Guamo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1000,29,'Herveo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1001,29,'Honda','hrojas','2010-01-01 00:00:00',NULL,NULL),(1002,29,'Ibagué','hrojas','2010-01-01 00:00:00',NULL,NULL),(1003,29,'Icononzo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1004,29,'Lérida','hrojas','2010-01-01 00:00:00',NULL,NULL),(1005,29,'Líbano','hrojas','2010-01-01 00:00:00',NULL,NULL),(1006,29,'Mariquita','hrojas','2010-01-01 00:00:00',NULL,NULL),(1007,29,'Melgar','hrojas','2010-01-01 00:00:00',NULL,NULL),(1008,29,'Murillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1009,29,'Natagaima','hrojas','2010-01-01 00:00:00',NULL,NULL),(1010,29,'Ortega','hrojas','2010-01-01 00:00:00',NULL,NULL),(1011,29,'Palocabildo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1012,29,'Piedras','hrojas','2010-01-01 00:00:00',NULL,NULL),(1013,29,'Planadas','hrojas','2010-01-01 00:00:00',NULL,NULL),(1014,29,'Prado','hrojas','2010-01-01 00:00:00',NULL,NULL),(1015,29,'Purificación','hrojas','2010-01-01 00:00:00',NULL,NULL),(1016,29,'Rioblanco','hrojas','2010-01-01 00:00:00',NULL,NULL),(1017,29,'Roncesvalles','hrojas','2010-01-01 00:00:00',NULL,NULL),(1018,29,'Rovira','hrojas','2010-01-01 00:00:00',NULL,NULL),(1019,29,'Saldaña','hrojas','2010-01-01 00:00:00',NULL,NULL),(1020,29,'San Antonio','hrojas','2010-01-01 00:00:00',NULL,NULL),(1021,29,'San Luis','hrojas','2010-01-01 00:00:00',NULL,NULL),(1022,29,'Santa Isabel','hrojas','2010-01-01 00:00:00',NULL,NULL),(1023,29,'Suárez','hrojas','2010-01-01 00:00:00',NULL,NULL),(1024,29,'Valle de San Juan','hrojas','2010-01-01 00:00:00',NULL,NULL),(1025,29,'Venadillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1026,29,'Villahermosa','hrojas','2010-01-01 00:00:00',NULL,NULL),(1027,29,'Villarrica','hrojas','2010-01-01 00:00:00',NULL,NULL),(1028,30,'Alcalá','hrojas','2010-01-01 00:00:00',NULL,NULL),(1029,30,'Andalucía','hrojas','2010-01-01 00:00:00',NULL,NULL),(1030,30,'Ansermanuevo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1031,30,'Argelia','hrojas','2010-01-01 00:00:00',NULL,NULL),(1032,30,'Bolívar','hrojas','2010-01-01 00:00:00',NULL,NULL),(1033,30,'Buenaventura','hrojas','2010-01-01 00:00:00',NULL,NULL),(1034,30,'Buga','hrojas','2010-01-01 00:00:00',NULL,NULL),(1035,30,'Bugalagrande','hrojas','2010-01-01 00:00:00',NULL,NULL),(1036,30,'Caicedonia','hrojas','2010-01-01 00:00:00',NULL,NULL),(1037,30,'Cali','hrojas','2010-01-01 00:00:00',NULL,NULL),(1038,30,'Calima (Darién)','hrojas','2010-01-01 00:00:00',NULL,NULL),(1039,30,'Candelaria','hrojas','2010-01-01 00:00:00',NULL,NULL),(1040,30,'Cartago','hrojas','2010-01-01 00:00:00',NULL,NULL),(1041,30,'Dagua','hrojas','2010-01-01 00:00:00',NULL,NULL),(1042,30,'El Águila','hrojas','2010-01-01 00:00:00',NULL,NULL),(1043,30,'El Cairo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1044,30,'El Cerrito','hrojas','2010-01-01 00:00:00',NULL,NULL),(1045,30,'El Dovio','hrojas','2010-01-01 00:00:00',NULL,NULL),(1046,30,'Florida','hrojas','2010-01-01 00:00:00',NULL,NULL),(1047,30,'Ginebra','hrojas','2010-01-01 00:00:00',NULL,NULL),(1048,30,'Guacarí','hrojas','2010-01-01 00:00:00',NULL,NULL),(1049,30,'Jamundí','hrojas','2010-01-01 00:00:00',NULL,NULL),(1050,30,'La Cumbre','hrojas','2010-01-01 00:00:00',NULL,NULL),(1051,30,'La Unión','hrojas','2010-01-01 00:00:00',NULL,NULL),(1052,30,'La Victoria','hrojas','2010-01-01 00:00:00',NULL,NULL),(1053,30,'Obando','hrojas','2010-01-01 00:00:00',NULL,NULL),(1054,30,'Palmira','hrojas','2010-01-01 00:00:00',NULL,NULL),(1055,30,'Pradera','hrojas','2010-01-01 00:00:00',NULL,NULL),(1056,30,'Restrepo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1057,30,'Riofrío','hrojas','2010-01-01 00:00:00',NULL,NULL),(1058,30,'Roldanillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1059,30,'San Pedro','hrojas','2010-01-01 00:00:00',NULL,NULL),(1060,30,'Sevilla','hrojas','2010-01-01 00:00:00',NULL,NULL),(1061,30,'Toro','hrojas','2010-01-01 00:00:00',NULL,NULL),(1062,30,'Trujillo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1063,30,'Tuluá','hrojas','2010-01-01 00:00:00',NULL,NULL),(1064,30,'Ulloa','hrojas','2010-01-01 00:00:00',NULL,NULL),(1065,30,'Versalles','hrojas','2010-01-01 00:00:00',NULL,NULL),(1066,30,'Vijes','hrojas','2010-01-01 00:00:00',NULL,NULL),(1067,30,'Yotoco','hrojas','2010-01-01 00:00:00',NULL,NULL),(1068,30,'Yumbo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1069,30,'Zarzal','hrojas','2010-01-01 00:00:00',NULL,NULL),(1070,31,'Carurú','hrojas','2010-01-01 00:00:00',NULL,NULL),(1071,31,'Mitú','hrojas','2010-01-01 00:00:00',NULL,NULL),(1072,31,'Tatamá','hrojas','2010-01-01 00:00:00',NULL,NULL),(1073,32,'Cumaribo','hrojas','2010-01-01 00:00:00',NULL,NULL),(1074,32,'La Primavera','hrojas','2010-01-01 00:00:00',NULL,NULL),(1075,32,'Puerto Carreño','hrojas','2010-01-01 00:00:00',NULL,NULL),(1076,32,'Santa Rosalia','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_nivelacademico` */

DROP TABLE IF EXISTS `gpp_nivelacademico`;

CREATE TABLE `gpp_nivelacademico` (
  `nac_nidnivelac` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nac_vnivelac` varchar(60) NOT NULL,
  `nac_vusucrea` varchar(60) NOT NULL,
  `nac_dfeccrea` datetime NOT NULL,
  `nac_vusumodifica` varchar(60) DEFAULT NULL,
  `nac_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`nac_nidnivelac`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_nivelacademico` */

LOCK TABLES `gpp_nivelacademico` WRITE;

insert  into `gpp_nivelacademico`(`nac_nidnivelac`,`nac_vnivelac`,`nac_vusucrea`,`nac_dfeccrea`,`nac_vusumodifica`,`nac_dfecmodifica`) values (1,'Bachillerato','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Técnico','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Pregrado','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Especialización','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Magister','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'MBA','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,'Doctorado','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,'Tecnología','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,'Diplomado','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,'Curso','hrojas','2010-01-01 00:00:00',NULL,NULL),(11,'Certificación PMP','hrojas','2010-01-01 00:00:00',NULL,NULL),(12,'Certificación Java','hrojas','2010-01-01 00:00:00',NULL,NULL),(13,'Certificación .Net','hrojas','2010-01-01 00:00:00',NULL,NULL),(14,'Otra Certificación','hrojas','2010-01-01 00:00:00',NULL,NULL),(15,'Certificacion OCA','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_pais` */

DROP TABLE IF EXISTS `gpp_pais`;

CREATE TABLE `gpp_pais` (
  `pai_nidpais` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pai_vpais` varchar(60) NOT NULL,
  `pai_vusucrea` varchar(60) NOT NULL,
  `pai_dfeccrea` datetime NOT NULL,
  `pai_vusumodifica` varchar(60) DEFAULT NULL,
  `pai_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`pai_nidpais`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_pais` */

LOCK TABLES `gpp_pais` WRITE;

insert  into `gpp_pais`(`pai_nidpais`,`pai_vpais`,`pai_vusucrea`,`pai_dfeccrea`,`pai_vusumodifica`,`pai_dfecmodifica`) values (1,'Colombia','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_parametrizacion` */

DROP TABLE IF EXISTS `gpp_parametrizacion`;

CREATE TABLE `gpp_parametrizacion` (
  `par_nidparam` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `par_vnombre` varchar(60) NOT NULL,
  `par_vvalor` varchar(120) NOT NULL,
  `par_vdescripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`par_nidparam`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_parametrizacion` */

LOCK TABLES `gpp_parametrizacion` WRITE;

insert  into `gpp_parametrizacion`(`par_nidparam`,`par_vnombre`,`par_vvalor`,`par_vdescripcion`) values (1,'Ruta Documentos','/home/memo/Temp/','La ruta en el disco duro del servidor para los documentos'),(2,'Ruta Documentos Generados','/home/memo/Export/','Ruta en el servidor donde se colocaran las hojas de vida exportadas a formatos'),(3,'Puerto de Servidor Http','80','Puerto de escucha del servidor http configurado'),(4,'Alias de Documentos','/atenea-docs/','Alias para servidor apache de ruta de documentos cargados para descarga'),(5,'Alias de Reportes','/atenea-export/','Alias para servidor apache de ruta de reportes generados para descarga');

UNLOCK TABLES;

/*Table structure for table `gpp_perfilequivalente` */

DROP TABLE IF EXISTS `gpp_perfilequivalente`;

CREATE TABLE `gpp_perfilequivalente` (
  `peq_nidperfileq` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `peq_vperfileq` varchar(60) NOT NULL,
  `peq_vusucrea` varchar(60) NOT NULL,
  `peq_dfeccrea` datetime NOT NULL,
  `peq_vusumodifica` varchar(60) DEFAULT NULL,
  `peq_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`peq_nidperfileq`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_perfilequivalente` */

LOCK TABLES `gpp_perfilequivalente` WRITE;

insert  into `gpp_perfilequivalente`(`peq_nidperfileq`,`peq_vperfileq`,`peq_vusucrea`,`peq_dfeccrea`,`peq_vusumodifica`,`peq_dfecmodifica`) values (1,'Programador Junior','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Programador Senior','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Especialista SIG','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Especialista Base de Datos','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'DBA Oracle','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'Arquitecto de Software','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,'Analísta','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,'Analísta de Pruebas','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,'Gerente de Proyectos','hrojas','2010-01-01 00:00:00',NULL,NULL),(10,'Coordinador de Proyectos','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_perfilprof` */

DROP TABLE IF EXISTS `gpp_perfilprof`;

CREATE TABLE `gpp_perfilprof` (
  `ppr_nidperfilprof` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `peq_nidperfileq` int(10) unsigned NOT NULL,
  `per_nidpersona` int(10) unsigned NOT NULL,
  `ppr_vperfil` varchar(255) NOT NULL,
  `idi_nididioma1` int(10) unsigned DEFAULT NULL,
  `ppr_nnivelidi1` int(10) unsigned DEFAULT NULL,
  `idi_nididioma2` int(10) unsigned DEFAULT NULL,
  `ppr_nnivelidi2` int(10) unsigned DEFAULT NULL,
  `ppr_vherrasw` varchar(255) DEFAULT NULL,
  `ppr_vmotorbd` varchar(255) DEFAULT NULL,
  `ppr_vusucrea` varchar(60) NOT NULL,
  `ppr_dfeccrea` datetime NOT NULL,
  `ppr_vusumodifica` varchar(60) DEFAULT NULL,
  `ppr_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`ppr_nidperfilprof`),
  KEY `gpp_perfilprof_FKIndex1` (`idi_nididioma1`),
  KEY `gpp_perfilprof_FKIndex2` (`idi_nididioma2`),
  KEY `gpp_perfilprof_FKIndex3` (`per_nidpersona`),
  KEY `gpp_perfilprof_FKIndex4` (`peq_nidperfileq`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_perfilprof` */

LOCK TABLES `gpp_perfilprof` WRITE;

UNLOCK TABLES;

/*Table structure for table `gpp_persona` */

DROP TABLE IF EXISTS `gpp_persona`;

CREATE TABLE `gpp_persona` (
  `per_nidpersona` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gpp_municipio_mun_vidmunicipio` int(4) NOT NULL,
  `per_vnombres` varchar(60) NOT NULL,
  `per_vapellidos` varchar(60) NOT NULL,
  `tdc_nidtipodoc` int(10) unsigned NOT NULL,
  `per_nidentificacion` int(10) unsigned NOT NULL,
  `per_vsexo` varchar(1) NOT NULL,
  `esc_nidestadocivil` int(10) unsigned NOT NULL,
  `per_dfecnacimiento` date DEFAULT NULL,
  `per_vlibretamilitar` varchar(60) DEFAULT NULL,
  `per_vmovil` varchar(60) DEFAULT NULL,
  `per_vemail` varchar(60) DEFAULT NULL,
  `per_vdireccion` varchar(120) DEFAULT NULL,
  `per_vtelefono` varchar(60) DEFAULT NULL,
  `pai_npaisresidencia` int(10) unsigned NOT NULL,
  `mun_nmpioresidencia` int(10) unsigned NOT NULL,
  `per_vactivo` varchar(5) NOT NULL,
  `per_vusucrea` varchar(60) NOT NULL,
  `per_dfeccrea` datetime NOT NULL,
  `per_vusumodifica` varchar(60) DEFAULT NULL,
  `per_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`per_nidpersona`),
  UNIQUE KEY `per_nidentificacion` (`per_nidentificacion`),
  KEY `gpp_persona_FKIndex1` (`tdc_nidtipodoc`),
  KEY `gpp_persona_FKIndex2` (`esc_nidestadocivil`),
  KEY `gpp_persona_FKIndex3` (`gpp_municipio_mun_vidmunicipio`),
  KEY `gpp_persona_FKIndex4` (`pai_npaisresidencia`),
  KEY `gpp_persona_FKIndex5` (`mun_nmpioresidencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_persona` */

LOCK TABLES `gpp_persona` WRITE;

UNLOCK TABLES;

/*Table structure for table `gpp_rol` */

DROP TABLE IF EXISTS `gpp_rol`;

CREATE TABLE `gpp_rol` (
  `rol_nidrol` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rol_vnombre` varchar(20) NOT NULL,
  `rol_vdescripcion` varchar(255) DEFAULT NULL,
  `rol_vactivo` varchar(5) NOT NULL,
  `rol_vusucrea` varchar(20) NOT NULL,
  `rol_dfeccrea` datetime NOT NULL,
  `rol_vusumodifica` varchar(20) DEFAULT NULL,
  `rol_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`rol_nidrol`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_rol` */

LOCK TABLES `gpp_rol` WRITE;

insert  into `gpp_rol`(`rol_nidrol`,`rol_vnombre`,`rol_vdescripcion`,`rol_vactivo`,`rol_vusucrea`,`rol_dfeccrea`,`rol_vusumodifica`,`rol_dfecmodifica`) values (1,'Rol Admin','Rol Administrador con todos los servicios','true','hrojas','2010-01-01 00:00:00','hrojas','2010-10-07 00:00:00'),(2,'Rol Agregar','Rol solo de creacion de registros','true','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Rol Modificar','Solo permisos de Modificacion','true','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Rol Eliminar','Rol solo de eliminar','true','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_servicio` */

DROP TABLE IF EXISTS `gpp_servicio`;

CREATE TABLE `gpp_servicio` (
  `ser_nidservicio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ser_vnombre` varchar(60) DEFAULT NULL,
  `ser_vruta` varchar(255) DEFAULT NULL,
  `ser_vusucrea` varchar(60) NOT NULL,
  `ser_dfeccrea` datetime NOT NULL,
  PRIMARY KEY (`ser_nidservicio`)
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_servicio` */

LOCK TABLES `gpp_servicio` WRITE;

insert  into `gpp_servicio`(`ser_nidservicio`,`ser_vnombre`,`ser_vruta`,`ser_vusucrea`,`ser_dfeccrea`) values (1,'srvAgregarCargoEquivalente','Permite agregar registros a la tabla de CargoEquivalente','hrojas','2010-01-01 00:00:00'),(2,'srvAgregarDepartamento','Permite agregar registros a la tabla de Departamento','hrojas','2010-01-01 00:00:00'),(3,'srvAgregarEstadoCivil','Permite agregar registros a la tabla de EstadoCivil','hrojas','2010-01-01 00:00:00'),(4,'srvAgregarIdioma','Permite agregar registros a la tabla de Idioma','hrojas','2010-01-01 00:00:00'),(5,'srvAgregarInstitucion','Permite agregar registros a la tabla de Institucion','hrojas','2010-01-01 00:00:00'),(6,'srvAgregarMunicipio','Permite agregar registros a la tabla de Municipio','hrojas','2010-01-01 00:00:00'),(7,'srvAgregarNivelesAcademicos','Permite agregar registros a la tabla de NivelesAcademicos','hrojas','2010-01-01 00:00:00'),(8,'srvAgregarPais','Permite agregar registros a la tabla de Pais','hrojas','2010-01-01 00:00:00'),(9,'srvAgregarParametrizacion','Permite agregar registros a la tabla de Parametrizacion','hrojas','2010-01-01 00:00:00'),(10,'srvAgregarPerfilEquivalente','Permite agregar registros a la tabla de PerfilEquivalente','hrojas','2010-01-01 00:00:00'),(11,'srvAgregarHojadeVida','Permite agregar hojas de vida en la aplicacion','hrojas','2010-01-01 00:00:00'),(12,'srvAgregarRol','Permite agregar registros a la tabla de Rol','hrojas','2010-01-01 00:00:00'),(13,'srvAgregarTipoArchivo','Permite agregar registros a la tabla de TipoArchivo','hrojas','2010-01-01 00:00:00'),(14,'srvAgregarTipoDocumento','Permite agregar registros a la tabla de TipoDocumento','hrojas','2010-01-01 00:00:00'),(15,'srvAgregarTituloEquivalente','Permite agregar registros a la tabla de TituloEquivalente','hrojas','2010-01-01 00:00:00'),(16,'srvAgregarUsuario','Permite agregar registros a la tabla de Usuario','hrojas','2010-01-01 00:00:00'),(17,'srvCrearReporte','Permite crear reportes de Hojas de Vida','hrojas','2010-01-01 00:00:00'),(18,'srvModificarCargoEquivalente','Permite modificar registros a la tabla de CargoEquivalente','hrojas','2010-01-01 00:00:00'),(19,'srvModificarDepartamento','Permite modificar registros a la tabla de Departamento','hrojas','2010-01-01 00:00:00'),(20,'srvModificarEstadoCivil','Permite modificar registros a la tabla de EstadoCivil','hrojas','2010-01-01 00:00:00'),(21,'srvModificarIdioma','Permite modificar registros a la tabla de Idioma','hrojas','2010-01-01 00:00:00'),(22,'srvModificarInstitucion','Permite modificar registros a la tabla de Institucion','hrojas','2010-01-01 00:00:00'),(23,'srvModificarMunicipio','Permite modificar registros a la tabla de Municipio','hrojas','2010-01-01 00:00:00'),(24,'srvModificarNivelesAcademicos','Permite modificar registros a la tabla de NivelesAcademicos','hrojas','2010-01-01 00:00:00'),(25,'srvModificarPais','Permite modificar registros a la tabla de Pais','hrojas','2010-01-01 00:00:00'),(26,'srvModificarParametrizacion','Permite modificar registros a la tabla de Parametrizacion','hrojas','2010-01-01 00:00:00'),(27,'srvModificarPerfilEquivalente','Permite modificar registros a la tabla de PerfilEquivalente','hrojas','2010-01-01 00:00:00'),(28,'srvModificarHojadeVida','Permite modificar datos de las hojas de vida de la aplicacion','hrojas','2010-01-01 00:00:00'),(29,'srvModificarRol','Permite modificar registros a la tabla de Rol','hrojas','2010-01-01 00:00:00'),(30,'srvModificarTipoArchivo','Permite modificar registros a la tabla de TipoArchivo','hrojas','2010-01-01 00:00:00'),(31,'srvModificarTipoDocumento','Permite modificar registros a la tabla de TipoDocumento','hrojas','2010-01-01 00:00:00'),(32,'srvModificarTituloEquivalente','Permite modificar registros a la tabla de TituloEquivalente','hrojas','2010-01-01 00:00:00'),(33,'srvModificarUsuario','Permite modificar registros a la tabla de Usuario','hrojas','2010-01-01 00:00:00'),(34,'srvModificarPermisos','Permite modificar permisos a un rol','hrojas','2010-01-01 00:00:00'),(35,'srvEliminarCargoEquivalente','Permite modificar registros a la tabla de CargoEquivalente','hrojas','2010-01-01 00:00:00'),(36,'srvEliminarDepartamento','Permite modificar registros a la tabla de Departamento','hrojas','2010-01-01 00:00:00'),(37,'srvEliminarEstadoCivil','Permite modificar registros a la tabla de EstadoCivil','hrojas','2010-01-01 00:00:00'),(38,'srvEliminarIdioma','Permite modificar registros a la tabla de Idioma','hrojas','2010-01-01 00:00:00'),(39,'srvEliminarInstitucion','Permite modificar registros a la tabla de Institucion','hrojas','2010-01-01 00:00:00'),(40,'srvEliminarMunicipio','Permite modificar registros a la tabla de Municipio','hrojas','2010-01-01 00:00:00'),(41,'srvEliminarPais','Permite modificar registros a la tabla de Pais','hrojas','2010-01-01 00:00:00'),(42,'srvEliminarPerfilEquivalente','Permite modificar registros a la tabla de PerfilEquivalente','hrojas','2010-01-01 00:00:00'),(43,'srvEliminarTipoArchivo','Permite modificar registros a la tabla de TipoArchivo','hrojas','2010-01-01 00:00:00'),(44,'srvEliminarTipoDocumento','Permite modificar registros a la tabla de TipoDocumento','hrojas','2010-01-01 00:00:00'),(45,'srvEliminarTituloEquivalente','Permite modificar registros a la tabla de TituloEquivalente','hrojas','2010-01-01 00:00:00'),(46,'srvEliminarUsuario','Permite modificar registros a la tabla de Usuario','hrojas','2010-01-01 00:00:00'),(47,'srvEliminarNivelesAcademicos','Permite eliminar registros de la tabla de usuarios','admin','2010-09-01 12:30:00'),(48,'srvConsultarHV','Permite buscar hojas de vida','admin','2010-09-01 12:30:00'),(49,'srvConsultarHVAvanzada','Permite la busqueda avanzada de hojas de vida','admin','2010-09-01 12:30:00'),(50,'srvDetalleHV','Permite ver el detalle de una hoja de vida','admin','2010-09-01 12:30:00'),(51,'srvActivarHV','Permite Activar o inactivar una hoja de vida','admin','2010-09-01 12:30:00'),(52,'srvDetalleRol','Permite ver el detalle de los roles','admin','2010-09-01 12:30:00'),(53,'srvDetalleUsuario','Permite ver el detalle de los usuarios','admin','2010-09-01 12:30:00'),(54,'srvDetallePermiso','Permite ver el detalle de los permisos','admin','2010-09-01 12:30:00'),(55,'srvDetalleParametrizacion','Permite ver el detalle de los parametros','admin','2010-09-01 12:30:00'),(56,'srvActivarRol','Permite activar o inactivar roles','admin','2010-09-01 12:30:00'),(57,'srvActivarUsuario','Permite activar o inactivar usuarios','admin','2010-09-01 12:30:00');

UNLOCK TABLES;

/*Table structure for table `gpp_serviciorol` */

DROP TABLE IF EXISTS `gpp_serviciorol`;

CREATE TABLE `gpp_serviciorol` (
  `ser_nidservicio` int(10) unsigned NOT NULL,
  `rol_nidrol` int(10) unsigned NOT NULL,
  `srl_vusucrea` varchar(60) NOT NULL,
  `srl_dfeccrea` date NOT NULL,
  PRIMARY KEY (`ser_nidservicio`,`rol_nidrol`),
  KEY `gpp_serviciorol_FKIndex1` (`ser_nidservicio`),
  KEY `gpp_serviciorol_FKIndex2` (`rol_nidrol`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_serviciorol` */

LOCK TABLES `gpp_serviciorol` WRITE;

insert  into `gpp_serviciorol`(`ser_nidservicio`,`rol_nidrol`,`srl_vusucrea`,`srl_dfeccrea`) values (1,1,'hrojas','2010-01-01'),(2,1,'hrojas','2010-01-01'),(3,1,'hrojas','2010-01-01'),(11,1,'hrojas','2010-01-01'),(4,1,'hrojas','2010-01-01'),(5,1,'hrojas','2010-01-01'),(6,1,'hrojas','2010-01-01'),(7,1,'hrojas','2010-01-01'),(8,1,'hrojas','2010-01-01'),(9,1,'hrojas','2010-01-01'),(10,1,'hrojas','2010-01-01'),(12,1,'hrojas','2010-01-01'),(13,1,'hrojas','2010-01-01'),(14,1,'hrojas','2010-01-01'),(15,1,'hrojas','2010-01-01'),(16,1,'hrojas','2010-01-01'),(17,1,'hrojas','2010-01-01'),(35,1,'hrojas','2010-01-01'),(36,1,'hrojas','2010-01-01'),(37,1,'hrojas','2010-01-01'),(38,1,'hrojas','2010-01-01'),(39,1,'hrojas','2010-01-01'),(40,1,'hrojas','2010-01-01'),(41,1,'hrojas','2010-01-01'),(42,1,'hrojas','2010-01-01'),(43,1,'hrojas','2010-01-01'),(44,1,'hrojas','2010-01-01'),(45,1,'hrojas','2010-01-01'),(46,1,'hrojas','2010-01-01'),(18,1,'hrojas','2010-01-01'),(20,1,'hrojas','2010-01-01'),(19,1,'hrojas','2010-01-01'),(28,1,'hrojas','2010-01-01'),(21,1,'hrojas','2010-01-01'),(22,1,'hrojas','2010-01-01'),(23,1,'hrojas','2010-01-01'),(24,1,'hrojas','2010-01-01'),(25,1,'hrojas','2010-01-01'),(26,1,'hrojas','2010-01-01'),(27,1,'hrojas','2010-01-01'),(34,1,'hrojas','2010-01-01'),(29,1,'hrojas','2010-01-01'),(30,1,'hrojas','2010-01-01'),(31,1,'hrojas','2010-01-01'),(32,1,'hrojas','2010-01-01'),(33,1,'hrojas','2010-01-01'),(1,2,'hrojas','2010-01-01'),(2,2,'hrojas','2010-01-01'),(3,2,'hrojas','2010-01-01'),(11,2,'hrojas','2010-01-01'),(4,2,'hrojas','2010-01-01'),(5,2,'hrojas','2010-01-01'),(6,2,'hrojas','2010-01-01'),(7,2,'hrojas','2010-01-01'),(8,2,'hrojas','2010-01-01'),(9,2,'hrojas','2010-01-01'),(10,2,'hrojas','2010-01-01'),(12,2,'hrojas','2010-01-01'),(13,2,'hrojas','2010-01-01'),(14,2,'hrojas','2010-01-01'),(15,2,'hrojas','2010-01-01'),(16,2,'hrojas','2010-01-01'),(17,2,'hrojas','2010-01-01'),(35,4,'hrojas','2010-01-01'),(36,4,'hrojas','2010-01-01'),(37,4,'hrojas','2010-01-01'),(38,4,'hrojas','2010-01-01'),(39,4,'hrojas','2010-01-01'),(40,4,'hrojas','2010-01-01'),(41,4,'hrojas','2010-01-01'),(42,4,'hrojas','2010-01-01'),(43,4,'hrojas','2010-01-01'),(44,4,'hrojas','2010-01-01'),(45,4,'hrojas','2010-01-01'),(46,4,'hrojas','2010-01-01'),(33,3,'hrojas','2010-01-01'),(32,3,'hrojas','2010-01-01'),(31,3,'hrojas','2010-01-01'),(30,3,'hrojas','2010-01-01'),(29,3,'hrojas','2010-01-01'),(34,3,'hrojas','2010-01-01'),(27,3,'hrojas','2010-01-01'),(26,3,'hrojas','2010-01-01'),(25,3,'hrojas','2010-01-01'),(24,3,'hrojas','2010-01-01'),(23,3,'hrojas','2010-01-01'),(22,3,'hrojas','2010-01-01'),(21,3,'hrojas','2010-01-01'),(28,3,'hrojas','2010-01-01'),(20,3,'hrojas','2010-01-01'),(19,3,'hrojas','2010-01-01'),(18,3,'hrojas','2010-01-01'),(47,1,'hrojas','2010-10-04'),(51,1,'hrojas','2010-10-07'),(56,1,'hrojas','2010-10-07'),(57,1,'hrojas','2010-10-07'),(48,1,'hrojas','2010-10-07'),(49,1,'hrojas','2010-10-07'),(50,1,'hrojas','2010-10-07'),(55,1,'hrojas','2010-10-07'),(54,1,'hrojas','2010-10-07'),(52,1,'hrojas','2010-10-07'),(53,1,'hrojas','2010-10-07');

UNLOCK TABLES;

/*Table structure for table `gpp_tipoarchivo` */

DROP TABLE IF EXISTS `gpp_tipoarchivo`;

CREATE TABLE `gpp_tipoarchivo` (
  `tar_nidtipoarchivo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tar_vtipoarchivo` varchar(120) DEFAULT NULL,
  `tar_vusucrea` varchar(60) NOT NULL,
  `tar_dfeccrea` datetime NOT NULL,
  `tar_vusumodifica` varchar(60) DEFAULT NULL,
  `tar_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`tar_nidtipoarchivo`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_tipoarchivo` */

LOCK TABLES `gpp_tipoarchivo` WRITE;

insert  into `gpp_tipoarchivo`(`tar_nidtipoarchivo`,`tar_vtipoarchivo`,`tar_vusucrea`,`tar_dfeccrea`,`tar_vusumodifica`,`tar_dfecmodifica`) values (1,'Hoja de Vida','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Compilado Soportes Laborales','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Compilado Soportes Academicos','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Acta','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Diploma','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'Certificado Laboral','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_tipodoc` */

DROP TABLE IF EXISTS `gpp_tipodoc`;

CREATE TABLE `gpp_tipodoc` (
  `tdc_nidtipodoc` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tdc_vnombre` varchar(60) NOT NULL,
  `tdc_vusucrea` varchar(60) NOT NULL,
  `tdc_dfeccrea` datetime NOT NULL,
  `tdc_vusumodifica` varchar(60) DEFAULT NULL,
  `tdc_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`tdc_nidtipodoc`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_tipodoc` */

LOCK TABLES `gpp_tipodoc` WRITE;

insert  into `gpp_tipodoc`(`tdc_nidtipodoc`,`tdc_vnombre`,`tdc_vusucrea`,`tdc_dfeccrea`,`tdc_vusumodifica`,`tdc_dfecmodifica`) values (1,'Cédula de Ciudadanía','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Tarjeta de Identidad','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Cédula de Extranjería','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'NIT Persona Natural','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'NIT Persona Jurídica','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'NIT Persona Extranjera','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,'Pasaporte','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,'Regístro Civil','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_tituloequivalente` */

DROP TABLE IF EXISTS `gpp_tituloequivalente`;

CREATE TABLE `gpp_tituloequivalente` (
  `teq_nidtituloeq` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teq_vtituloeq` varchar(60) NOT NULL,
  `teq_vusucrea` varchar(60) NOT NULL,
  `teq_dfeccrea` datetime NOT NULL,
  `teq_vusumodifica` varchar(60) DEFAULT NULL,
  `teq_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`teq_nidtituloeq`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_tituloequivalente` */

LOCK TABLES `gpp_tituloequivalente` WRITE;

insert  into `gpp_tituloequivalente`(`teq_nidtituloeq`,`teq_vtituloeq`,`teq_vusucrea`,`teq_dfeccrea`,`teq_vusumodifica`,`teq_dfecmodifica`) values (1,'Ingeniero de Sistemas','hrojas','2010-01-01 00:00:00',NULL,NULL),(2,'Ingeniero Catastral y Geodesta','hrojas','2010-01-01 00:00:00',NULL,NULL),(3,'Ingeniero Industrial','hrojas','2010-01-01 00:00:00',NULL,NULL),(4,'Ingeniero Electrónico','hrojas','2010-01-01 00:00:00',NULL,NULL),(5,'Ingeniero Mecatrónico','hrojas','2010-01-01 00:00:00',NULL,NULL),(6,'Ingeniero de Petróleos','hrojas','2010-01-01 00:00:00',NULL,NULL),(7,'Gestion Operativa','hrojas','2010-01-01 00:00:00',NULL,NULL),(9,'Especialista','hrojas','2010-01-01 00:00:00',NULL,NULL),(8,'Gestion Humana','hrojas','2010-01-01 00:00:00',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `gpp_usuario` */

DROP TABLE IF EXISTS `gpp_usuario`;

CREATE TABLE `gpp_usuario` (
  `usu_nidusuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usu_vnombre` varchar(120) NOT NULL,
  `usu_vlogin` varchar(60) NOT NULL,
  `usu_vactivo` varchar(5) NOT NULL,
  `usu_vemail` varchar(60) DEFAULT NULL,
  `usu_vtelefono` varchar(60) DEFAULT NULL,
  `usu_vusucrea` varchar(60) NOT NULL,
  `usu_dfeccrea` datetime NOT NULL,
  `usu_vusumodifica` varchar(60) DEFAULT NULL,
  `usu_dfecmodifica` datetime DEFAULT NULL,
  PRIMARY KEY (`usu_nidusuario`),
  UNIQUE KEY `usu_vlogin` (`usu_vlogin`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `gpp_usuario` */

LOCK TABLES `gpp_usuario` WRITE;

insert  into `gpp_usuario`(`usu_nidusuario`,`usu_vnombre`,`usu_vlogin`,`usu_vactivo`,`usu_vemail`,`usu_vtelefono`,`usu_vusucrea`,`usu_dfeccrea`,`usu_vusumodifica`,`usu_dfecmodifica`) values (4,'memo','memo','false','memo@','8909090','hrojas','2010-08-31 00:00:00','hrojas','2010-10-04 00:00:00');

UNLOCK TABLES;

/*Table structure for table `gpp_usuariorol` */

DROP TABLE IF EXISTS `gpp_usuariorol`;

CREATE TABLE `gpp_usuariorol` (
  `rol_nidrol` int(10) unsigned NOT NULL,
  `usu_nidusuario` int(10) unsigned NOT NULL,
  `url_vusucrea` varchar(60) NOT NULL,
  `url_dfeccrea` datetime NOT NULL,
  PRIMARY KEY (`rol_nidrol`,`usu_nidusuario`),
  KEY `gpp_usuariorol_FKIndex1` (`rol_nidrol`),
  KEY `gpp_usuariorol_FKIndex2` (`usu_nidusuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `gpp_usuariorol` */

LOCK TABLES `gpp_usuariorol` WRITE;

insert  into `gpp_usuariorol`(`rol_nidrol`,`usu_nidusuario`,`url_vusucrea`,`url_dfeccrea`) values (1,1,'hrojas','2010-01-01 00:00:00');

UNLOCK TABLES;

/*Table structure for table `gpp_consulta_avanzada` */

DROP TABLE IF EXISTS `gpp_consulta_avanzada`;

/*!50001 DROP VIEW IF EXISTS `gpp_consulta_avanzada` */;
/*!50001 DROP TABLE IF EXISTS `gpp_consulta_avanzada` */;

/*!50001 CREATE TABLE `gpp_consulta_avanzada` (
  `per_nidpersona` int(10) unsigned NOT NULL DEFAULT '0',
  `per_vnombres` varchar(60) NOT NULL,
  `per_vapellidos` varchar(60) NOT NULL,
  `for_vtarjetaprof` varchar(60) DEFAULT NULL,
  `for_vtitulo` varchar(120),
  `exp_vcargo` varchar(120),
  `exp_vherrasw` varchar(255) DEFAULT NULL,
  `ppr_vherrasw` varchar(255) DEFAULT NULL,
  `teq_vtituloeq` varchar(60),
  `ceq_vcargoeq` varchar(60),
  `nac_vnivelac` varchar(60)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 */;

/*View structure for view gpp_consulta_avanzada */

/*!50001 DROP TABLE IF EXISTS `gpp_consulta_avanzada` */;
/*!50001 DROP VIEW IF EXISTS `gpp_consulta_avanzada` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gpp_consulta_avanzada` AS select `p`.`per_nidpersona` AS `per_nidpersona`,`p`.`per_vnombres` AS `per_vnombres`,`p`.`per_vapellidos` AS `per_vapellidos`,`f`.`for_vtarjetaprof` AS `for_vtarjetaprof`,`f`.`for_vtitulo` AS `for_vtitulo`,`e`.`exp_vcargo` AS `exp_vcargo`,`e`.`exp_vherrasw` AS `exp_vherrasw`,`pp`.`ppr_vherrasw` AS `ppr_vherrasw`,`te`.`teq_vtituloeq` AS `teq_vtituloeq`,`ce`.`ceq_vcargoeq` AS `ceq_vcargoeq`,`na`.`nac_vnivelac` AS `nac_vnivelac` from ((((((`gpp_persona` `p` left join `gpp_perfilprof` `pp` on((`p`.`per_nidpersona` = `pp`.`per_nidpersona`))) left join `gpp_experiencia` `e` on((`p`.`per_nidpersona` = `e`.`per_nidpersona`))) left join `gpp_formacion` `f` on((`p`.`per_nidpersona` = `f`.`per_nidpersona`))) left join `gpp_nivelacademico` `na` on((`f`.`nac_nidnivelac` = `na`.`nac_nidnivelac`))) left join `gpp_cargoequivalente` `ce` on((`ce`.`ceq_nidcargoeq` = `e`.`ceq_nidcargoeq`))) left join `gpp_tituloequivalente` `te` on((`f`.`teq_nidtituloeq` = `te`.`teq_nidtituloeq`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
