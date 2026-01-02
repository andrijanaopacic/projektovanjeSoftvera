-- Schema for Bicycle Rental System
-- Client-server Java application

/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.32-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `seminarski`;

/*Table structure for table `bicikla` */

DROP TABLE IF EXISTS `bicikla`;

CREATE TABLE `bicikla` (
  `idBicikla` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `tip` varchar(30) NOT NULL,
  `cenaPoSatu` double unsigned NOT NULL,
  `cenaPoDanu` double unsigned NOT NULL,
  PRIMARY KEY (`idBicikla`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `iznajmljivanje` */

DROP TABLE IF EXISTS `iznajmljivanje`;

CREATE TABLE `iznajmljivanje` (
  `idIznajmljivanje` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ukupanIznos` double unsigned NOT NULL,
  `idProdavac` bigint(10) unsigned NOT NULL,
  `idKupac` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`idIznajmljivanje`),
  KEY `idProdavac` (`idProdavac`),
  KEY `idKupac` (`idKupac`),
  CONSTRAINT `iznajmljivanje_ibfk_1` FOREIGN KEY (`idProdavac`) REFERENCES `prodavac` (`idProdavac`),
  CONSTRAINT `iznajmljivanje_ibfk_2` FOREIGN KEY (`idKupac`) REFERENCES `kupac` (`idKupac`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `idKupac` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `brojLicneKarte` varchar(9) NOT NULL,
  `idMesto` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`idKupac`),
  KEY `idMesto` (`idMesto`),
  CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`idMesto`) REFERENCES `mesto` (`idMesto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `idMesto` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`idMesto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `prodavac` */

DROP TABLE IF EXISTS `prodavac`;

CREATE TABLE `prodavac` (
  `idProdavac` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `korisnickoIme` varchar(30) NOT NULL,
  `sifra` varchar(10) NOT NULL,
  PRIMARY KEY (`idProdavac`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `prodavactermin` */

DROP TABLE IF EXISTS `prodavactermin`;

CREATE TABLE `prodavactermin` (
  `idProdavac` bigint(10) unsigned NOT NULL,
  `idTermin` bigint(10) unsigned NOT NULL,
  `datumDezurstva` date NOT NULL,
  `smena` varchar(30) NOT NULL,
  PRIMARY KEY (`idProdavac`,`idTermin`,`datumDezurstva`),
  KEY `idTermin` (`idTermin`),
  CONSTRAINT `prodavactermin_ibfk_1` FOREIGN KEY (`idProdavac`) REFERENCES `prodavac` (`idProdavac`),
  CONSTRAINT `prodavactermin_ibfk_2` FOREIGN KEY (`idTermin`) REFERENCES `termin` (`idTerminDezurstva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `stavkaiznajmljivanja` */

DROP TABLE IF EXISTS `stavkaiznajmljivanja`;

CREATE TABLE `stavkaiznajmljivanja` (
  `idIznajmljivanje` bigint(10) unsigned NOT NULL,
  `idStavkaIznajmljivanja` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `iznos` double unsigned NOT NULL,
  `cena` double unsigned NOT NULL,
  `vremeOd` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `vremeDo` timestamp NOT NULL DEFAULT current_timestamp(),
  `brojSati` bigint(20) unsigned NOT NULL,
  `brojDana` bigint(20) unsigned NOT NULL,
  `idBicikla` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`idIznajmljivanje`,`idStavkaIznajmljivanja`),
  KEY `idBicikla` (`idBicikla`),
  KEY `idStavkaIznajmljivanja` (`idStavkaIznajmljivanja`),
  CONSTRAINT `stavkaiznajmljivanja_ibfk_1` FOREIGN KEY (`idIznajmljivanje`) REFERENCES `iznajmljivanje` (`idIznajmljivanje`),
  CONSTRAINT `stavkaiznajmljivanja_ibfk_2` FOREIGN KEY (`idBicikla`) REFERENCES `bicikla` (`idBicikla`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `termin` */

DROP TABLE IF EXISTS `termin`;

CREATE TABLE `termin` (
  `idTerminDezurstva` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`idTerminDezurstva`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
