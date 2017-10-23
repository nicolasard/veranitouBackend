/*
	Script para crear las tablas de la version nueva de veranitou.
*/
use veranitou;
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
<<<<<<< HEAD

##########################################################
##########################################################

#Old tables interface
DELIMITER |
CREATE TRIGGER ins_consultas BEFORE INSERT ON bkendConsultas_consulta
FOR EACH ROW BEGIN
  INSERT INTO consulta(nombre,email,consulta,fecha,propiedadId)
  VALUES (NEW.email,NEW.email,NEW.consulta,NOW(),NEW.propiedad_id);
END
|
DELIMITER ;
=======
INSERT INTO consulta (propiedadId,fecha,nombre,email,consulta,emailTo) VALUES (1,NOW(),"Juan Perez","juan.perez@mail.com","Este es un mensaje mucho mas largo tiene mas lineas","");
INSERT INTO consulta (propiedadId,fecha,nombre,email,consulta,emailTo) VALUES (1,NOW(),"Isaac Newton","isaac Newton@mail.com","Soy Pablo el cliente ideal","");
#select * from consulta;
>>>>>>> 962b824e8f5f50e2c4f33f8f2c1a0f6e380b81a7
