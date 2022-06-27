DROP DATABASE IF EXISTS gestiplatform_db;
CREATE DATABASE IF NOT EXISTS gestiplatform_db;
USE gestiplatform_db;

CREATE TABLE plataformas(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30) DEFAULT NULL,
    url_general VARCHAR(255) DEFAULT NULL,
    url_admin VARCHAR(255) DEFAULT NULL,
    logo VARCHAR(50) DEFAULT NULL,
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

CREATE TABLE personas(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	correo VARCHAR(60) UNIQUE DEFAULT NULL,
	nombre VARCHAR(30) DEFAULT NULL,
    clave VARCHAR(60) DEFAULT NULL,
	telefono VARCHAR(20) DEFAULT NULL,
	admin BOOLEAN DEFAULT 0
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
INSERT INTO personas(correo, nombre, clave, telefono, admin) VALUES
('admin@gmail.com', 'Admin', '12345', '096541789', 1);

INSERT INTO personas(correo, nombre, clave, telefono) VALUES
('martina@hotmail.com', 'Marta', '54321', '062683578'),
('jorge@gmail.com', 'Jorge', 'ABCDE','+34945245678'),
('rafa@bizkaia.eu','Rafa', 'EDCBA','660986482'),
('manolo@hotmail.com', 'Manolo', 'A1B2C3','+346604850328'),
('salva@gmail.com', 'Salva', '3C2B1A','+34656565656'),
('martina@yahoo.com', 'Martina', '?.#-AaB4','+34656565653');

INSERT INTO plataformas(nombre, url_general, url_admin, logo, limite_perfiles, limite_reproducciones, color) VALUES
('Netflix', 'www.netflix.com', 'www.netflix.com/es/login', 'img/netflix.png', '5', '4', '#ff0000'),
('HBO', 'www.hbomax.com', 'play.hbomax.com/login', 'img/hbo.png', '5', '2', '#000000'),
('Disney+', 'www.disneyplus.com', 'www.disneyplus.com/login', 'img/disney.png', '4', '4', '#ffffff'),
('Spotify', 'www.spotify.com', 'www.spotify.com/login', 'img/spotify.png', '2', '2','#0dff00');

INSERT INTO periodicidad(tipo, descripcion) VALUES
('Mensual','Cada mes.'),
('Anual', 'Cada año'),
('Bimensual', 'Cada dos meses.'),
('Trimensual', 'Cada tres meses.'),
('Semestral', 'Cada seis meses.');

INSERT INTO formas_pago(descripcion, favorita) VALUES
('Bizum', 1),
('Transferencia Bancaria', 0),
('Con Tarjeta', 0);

INSERT INTO suscripciones(id_plataforma, id_periodicidad, id_forma_de_pago, descripcion, fecha_alta, fecha_proximo_cobro, precio, credenciales_correo, credenciales_clave) VALUES
(4, 3, 1, 'Spotify con la familia','2021-06-07','2022-08-07', 9.99,'ohio@mail.com','12345'),
(2, 2, 3, 'HBO Sólo Rafa','2020-09-03','2022-09-03', 30.60,'mymail@not.com','54321'),
(3, 1, 1, 'Disneyx2 Mucho-Martina','2022-03-01','2023-04-01', 7.77,'somebodysmail@maybe.es','ABCDE'),
(1, 5, 2, 'Manu s Netflix', '2022-04-01','2022-10-01', 53.70,'trabajo@yahoo.nz','EDCBA'),
(4, 4, 2, 'Spotify con los colegas internacionales','2020-03-26','2022-06-26', 39.4,'goonies@go.grom','A2B4C6');

INSERT INTO grupos(id_persona, id_suscripcion) VALUES
(1, 4),
(1, 4),
(1, 3),
(1, 3),
(1, 2),
(1, 2),
(1, 1),
(1, 1),
(1, 4),
(2, 3),
(6, 4),
(5, 1),
(3, 4),
(4, 2),
(7, 3);

INSERT INTO recibos(id_grupo, fecha_emision, fecha_cobro, vigencia_inicio, vigencia_fin, cobrado, importe) VALUES
(1, '2022-03-02', '2022-04-02', '2022-03-22', '2022-05-17', 1, 4.4),
(1, '2021-07-19', '2023-11-03', '2024-07-20', '2025-03-19', 0, 50.50),
(2,'2022-05-21','2022-05-31', '2022-07-18', '2022-12-21', 0, 180.40),
(2, '2022-06-06', '2022-07-19','2022-07-31','2022-12-05', 1, 20.0),
(3,'2022-07-15','2022-09-13','2022-09-14','2022-10-17', 0, 31.0),
(3, '2022-05-29','2022-07-23','2022-08-07','2022-12-08', 1, 5.5),
(3,'2022-05-31','2022-07-06','2022-10-24','2022-12-05', 1, 8.8),
(4,'2022-05-20','2022-07-02','2022-10-09','2022-11-16', 0, 0.50),
(5,'2022-05-27','2022-08-11','2022-11-04','2022-12-16', 0, 4.9),
(6,'2022-07-19','2022-08-12','2022-08-22','2022-11-04', 1, 7.7),
(7,'2022-05-13','2022-06-26','2022-11-27','2022-12-14', 1, 9.93),
(6,'2022-07-06','2022-08-04','2022-10-20','2022-11-30', 1, 17.5);