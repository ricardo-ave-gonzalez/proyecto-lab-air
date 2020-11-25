DROP DATABASE if exists `Air`;
CREATE DATABASE `Air`;

use `Air`;

drop table if exists `Aeropuerto`;
drop table if exists `Vuelo`;
drop table if exists `Cliente`;
drop table if exists `Ticket`;
drop table if exists `Aerolinea`;
drop table if exists `Avion`;


CREATE TABLE `Aeropuerto` (
    `codeAeropuerto` varchar(255) PRIMARY KEY NOT NULL,
    `NameAeropuerto` varchar(50) NOT NULL,
    `Ciudad` varchar(32) DEFAULT NULL,
    `Pais` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Vuelo` (
    `codeVuelo` varchar(255) PRIMARY KEY NOT NULL,
    `datetimeSalida` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `datetimeArrival` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
    `salidaAeropuerto` varchar(80) NOT NULL,
    `destinoAeropuerto` varchar(80) NOT NULL,
    CONSTRAINT `da_fk` FOREIGN KEY (`destinoAeropuerto`) REFERENCES `Aeropuerto` (`CodeAeropuerto`),
    CONSTRAINT `sa_fk` FOREIGN KEY (`salidaAeropuerto`) REFERENCES `Aeropuerto` (`CodeAeropuerto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Cliente` (
    `codeCliente` varchar(255) PRIMARY KEY NOT NULL,
    `nombre` varchar(32) NOT NULL,
    `apellido` varchar(32) NOT NULL,
    `telefono` varchar(25) NOT NULL,
    `sexo` ENUM('FEMENINO','MASCULINO'),
    `categoria` ENUM('CLASE_ECONOMICA','CLASE_EJECUTIVA','PRIMERA_CLASE'),
    `codeVuelo` varchar(255) NOT NULL,
    CONSTRAINT `vl_fk` FOREIGN KEY (`codeVuelo`) REFERENCES `Vuelo`(`codeVuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Ticket` (
    `codeTicket` varchar(255) PRIMARY KEY NOT NULL,
    `tipoDePago` ENUM('EFECTIVO','DEBITO','CREDITO','MERCADOPAGO'),
    `codeVuelo` varchar(255) NOT NULL,
    `codeCliente` varchar(255) NOT NULL,
    CONSTRAINT `c_fk` FOREIGN KEY (`codeCliente`) REFERENCES `Cliente` (`codeCliente`) ON DELETE CASCADE,
    CONSTRAINT `v_fk` FOREIGN KEY (`codeVuelo`) REFERENCES `Vuelo`(`codeVuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Aerolinea`  (
    `codeAerolinea` varchar(255) PRIMARY KEY NOT NULL,
    `nameAerolinea` varchar(50) NOT NULL,
    `codeAeropuerto` varchar(255) NOT NULL,
    CONSTRAINT `ae_fk` FOREIGN KEY(`codeAeropuerto`) REFERENCES `Aeropuerto` (`codeAeropuerto`)	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Avion`  (
    `codeAvion` VARCHAR(255) PRIMARY KEY NOT NULL,
    `modelo` VARCHAR(20) NOT NULL,
    `capacidad` VARCHAR(20)NOT NULL,
    `codeAerolinea` VARCHAR(255) NOT NULL,
    CONSTRAINT `al_fk` FOREIGN KEY (`codeAerolinea`) REFERENCES `Aerolinea` (`codeAerolinea`)	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

alter table `Cliente` ADD `codeAvion` VARCHAR(255) NOT NULL;
alter table `Cliente` ADD CONSTRAINT `av_fk` FOREIGN KEY(`codeAvion`) REFERENCES `Avion`(codeAvion);




