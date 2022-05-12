DROP DATABASE IF EXISTS gestiplatform_db;
CREATE DATABASE IF NOT EXISTS gestiplatform_db;
USE gestiplatform_db;

CREATE TABLE plataformas(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) DEFAULT NULL,
    url_general VARCHAR(255) DEFAULT NULL,
    url_admin VARCHAR(255) DEFAULT NULL,
    logo VARCHAR(50) DEFAULT NULL,
    fecha_alta DATE DEFAULT NULL,
    limite_perfiles INT DEFAULT NULL,
    limite_reproducciones INT DEFAULT NULL,
    color VARCHAR(20) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE periodicidad(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20) DEFAULT NULL,
    descripcion VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE formas_pago(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) DEFAULT NULL,
    favorita BOOLEAN DEFAULT 0
) ENGINE=InnoDB;

CREATE TABLE suscripciones(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_plataforma INT,
    FOREIGN KEY (id_plataforma) REFERENCES plataformas(id),
    id_periodicidad INT,
	FOREIGN KEY (id_periodicidad) REFERENCES periodicidad(id),
    id_forma_de_pago INT,
	FOREIGN KEY (id_forma_de_pago) REFERENCES formas_pago(id),
    descripcion VARCHAR(255) DEFAULT NULL,
    fecha_alta DATE DEFAULT NULL,
    fecha_proximo_cobro DATE DEFAULT NULL,
    precio DOUBLE DEFAULT NULL,
    credenciales_correo VARCHAR(60) DEFAULT NULL,
    credenciales_clave VARCHAR(60) DEFAULT NULL
) ENGINE=InnoDB;

/*Esta sería nuestra tabla de "usuarios"*/
CREATE TABLE personas(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	correo VARCHAR(60) DEFAULT NULL,
	nombre VARCHAR(30) DEFAULT NULL,
    clave VARCHAR(60) DEFAULT NULL,
	telefono VARCHAR(20) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE grupos(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_persona INT,
    FOREIGN KEY (id_persona) REFERENCES personas(id),
    id_suscripcion INT,
	FOREIGN KEY (id_suscripcion) REFERENCES suscripciones(id)
) ENGINE=InnoDB;

CREATE TABLE recibos(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_grupo INT,
    FOREIGN KEY (id_grupo) REFERENCES grupos(id),
    fecha_emision DATE DEFAULT NULL,
    fecha_cobro DATE DEFAULT NULL,
    vigencia_inicio DATE DEFAULT NULL,
    vigencia_fin DATE DEFAULT NULL,
    cobrado BOOLEAN DEFAULT 0,
    importe DOUBLE DEFAULT NULL
) ENGINE=InnoDB;

INSERT INTO personas(correo, nombre, clave, telefono) VALUES
('pepito@gmail.com', 'Pepe', '12345', '096541789'),
('martina@hotmail.com', 'Marta', '54321', '062683578'),
('jorge@gmail.com', 'Jorge', 'ABCDE','+34945245678'),
('rafa@bizkaia.eu','Rafa', 'EDCBA','660986482'),
('manolo@hotmail.com', 'Manolo', 'A1B2C3','+346604850328'),
('salva@gmail.com', 'Salva', '3C2B1A','+34656565656'),
('martina@yahoo.com', 'Martina', '?.#-AaB4','+34656565656');