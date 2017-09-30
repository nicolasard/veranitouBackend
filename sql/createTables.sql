/*
	Script para crear las tablas de la version nueva de veranitou.
*/

# Tabla de consultas
DROP TABLE IF EXISTS `consulta`;
CREATE TABLE `consulta` (
  `consultaId` int(11) NOT NULL AUTO_INCREMENT,
  `propiedadId` int(11) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `consulta` text COLLATE utf8_spanish_ci,
  `emailTo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`consultaId`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

# Dummy data 
TRUNCATE TABLE consulta; 
INSERT INTO consulta (propiedadId,fecha,nombre,email,consulta,emailTo) VALUES (1,NOW(),"Pablo Cliente","pablo.cliente@mail.com","Soy Pablo el cliente ideal","");

#select * from consulta;