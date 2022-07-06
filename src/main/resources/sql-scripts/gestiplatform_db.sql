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
    credenciales_clave VARCHAR(60) DEFAULT NULL,
    suscripcion_activa BOOLEAN DEFAULT 1
) ENGINE=InnoDB;

CREATE TABLE personas(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	correo VARCHAR(60) UNIQUE DEFAULT NULL,
	nombre VARCHAR(30) DEFAULT NULL,
    clave VARCHAR(60) DEFAULT NULL,
	telefono VARCHAR(20) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE grupos(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_persona INT,
    FOREIGN KEY (id_persona) REFERENCES personas(id),
    id_suscripcion INT,
	FOREIGN KEY (id_suscripcion) REFERENCES suscripciones(id),
	grupo_activo BOOLEAN DEFAULT 0,
    admin BOOLEAN DEFAULT 0
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
    importe DOUBLE DEFAULT NULL,
    recibo_activo BOOLEAN DEFAULT 1
) ENGINE=InnoDB;

INSERT INTO personas(correo, nombre, clave, telefono) VALUES
#('admin@gmail.com', 'Admin', '12345', '096541789');
('ramon@gmail.com', 'Ramón', 'gestiplatform', '836287498');


INSERT INTO personas(correo, nombre, clave, telefono) VALUES
('martina@hotmail.com', 'Marta', '54321', '062683578'),
('jorge@gmail.com', 'Jorge', 'ABCDE','945245678'),
('rafa@bizkaia.eu','Rafa', 'EDCBA','660986482'),
('manolo@hotmail.com', 'Manolo', 'A1B2C3','6604850328'),
('salva@gmail.com', 'Salva', '3C2B1A','656565656'),
('martina@yahoo.com', 'Martina', '?.#-AaB4','656565653'),
('david@gestiplatform.es', 'Dyrolvaid', 'whileymedio', '827462096'),
('gerardo@gestiplatform.eu', 'Gerardo', 'animojefa', '927539490'),
('nuria@gestiplatform.com', 'Nuria', 'gobiernodeldato', '203763864'),
('isabella@mail.com', 'Isabella', 'isabella', '027429476');

INSERT INTO plataformas(nombre, url_general, url_admin, logo, limite_perfiles, limite_reproducciones, color) VALUES
('Netflix', 'www.netflix.com', 'www.netflix.com/es/login', 'assets/img/netflix.png', 5, 4, '#ff0000'),
('HBO', 'www.hbomax.com', 'play.hbomax.com/login', 'assets/img/hbo.png', 5, 2, '#000000'),
('Disney+', 'www.disneyplus.com', 'www.disneyplus.com/login', 'assets/img/disney.png', 4, 4, '#ffffff'),
('Spotify', 'www.spotify.com', 'www.spotify.com/login', 'assets/img/spotify.png', 2, 2,'#0dff00'),
('Movistar', 'www.movistar.es', 'www.movistar.es', 'assets/img/movistar.png', 3, 2, '#0dff00'),
('Fubo Tv', 'www.fubo.tv', 'www.fubo.tv', 'assets/img/fubo.png', 6, 3, '#000000'),
('Prime Video', 'www.primevideo.com', 'www.primevideo.com', 'assets/img/prime.png', 5, 4, '#ffffff'),
('Inserta Full-Stack 2022', 'https://insertaonce.arelance.com/', 'https://insertaonce.arelance.com/login/index.php', 'assets/img/inserta.png', 3, 3, '#814187');

INSERT INTO periodicidad(tipo, descripcion) VALUES
('Mensual','Cada mes'),
('Anual', 'Cada año'),
('Semestral', 'Cada seis meses'),
('Vitalicia', 'Sin renovación');

INSERT INTO formas_pago(descripcion, favorita) VALUES
('Bizum', 0),
('Transferencia Bancaria', 0),
('Con Tarjeta', 0),
('Efectivo', 1);

INSERT INTO suscripciones(id_plataforma, id_periodicidad, id_forma_de_pago, descripcion, fecha_alta, fecha_proximo_cobro, precio, credenciales_correo, credenciales_clave, suscripcion_activa) VALUES
(1, 1, 1, 'Netflix Premium', '2022-05-02','2022-08-02', 17.99,'trabajo@yahoo.nz','EDCBA', 1),
(2, 1, 2, 'Reúne contenidos de 5 plataformas TV', '2022-05-02','2022-08-02', 8.99,'mymail@not.com','54321', 1),
(3, 1, 2, 'Especial niños','2022-05-02','2022-08-02', 8.99,'somebodysmail@maybe.es','ABCDE', 1),
(4, 1, 1, 'Spotify con la familia','2022-05-02','2022-08-02', 9.99,'ohio@mail.com','12345', 1),
(5, 1, 1, 'Movistar Deportes', '2022-05-02','2022-08-02', 25.00, 'abc@abc.abc', 'Abc12', 1),
(6, 1, 1, 'Futbol', '2022-05-02','2022-08-02', 3.99, 'fut@fut.fut', 'fut12', 1),
(7, 1, 2, 'Especial series en Prime Video', '2022-05-02','2022-08-02', 3.99, 'pri@pri.pri', 'Pri12', 1),
(8, 1, 2, 'El aula de trabajo del Grupo 2', '2021-12-10', '2022-07-12', 0.00, 'grupo2@gestiplatform.com', '1234ABCD', 1);

INSERT INTO grupos(id_persona, id_suscripcion, grupo_activo, admin) VALUES
(1, 1, 1, 1),
(1, 2, 1, 0),
(1, 3, 1, 0),
(1, 4, 1, 0),
(1, 5, 1, 0),
(1, 6, 1, 0),
(1, 7, 1, 0),
(2, 1, 1, 0),
(2, 2, 1, 1),
(2, 3, 1, 0),
(2, 4, 1, 1),
(3, 1, 1, 0),
(3, 2, 1, 0),
(3, 3, 1, 1),
(3, 5, 1, 1),
(3, 6, 1, 0),
(3, 7, 1, 0),
(4, 1, 1, 0),
(4, 2, 1, 0),
(4, 3, 1, 0),
(4, 6, 1, 1),
(4, 7, 1, 0),
(5, 1, 1, 0),
(5, 2, 1, 0),
(5, 6, 1, 0),
(6, 6, 1, 0),
(6, 7, 1, 1),
(8, 8, 1, 1),
(9, 8, 1, 1),
(10, 8, 1, 1);

INSERT INTO recibos(id_grupo, fecha_emision, fecha_cobro, vigencia_inicio, vigencia_fin, cobrado, importe, recibo_activo) VALUES
(1, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 3.59, 1),
(1, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 3.59, 1),
(1, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 3.59, 1),
(2, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 1.79, 1),
(2, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 1.79, 1),
(2, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 1.79, 1),
(3, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 2.24, 1),
(3, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 2.24, 1),
(3, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 2.24, 1),
(4, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 4.99, 1),
(4, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 4.99, 1),
(4, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 4.99, 1),
(5, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 8.33, 1),
(5, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 8.33, 1),
(5, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 8.33, 1),
(6, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.66, 1),
(6, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.66, 1),
(6, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.66, 1),
(7, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.79, 1),
(7, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.79, 1),
(7, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.79, 1),
(8, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 3.59, 1),
(8, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 3.59, 1),
(8, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 3.59, 1),
(9, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 1.79, 1),
(9, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 1.79, 1),
(9, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 1.79, 1),
(10, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 2.24, 1),
(10, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 2.24, 1),
(10, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 2.24, 1),
(11, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 4.99, 1),
(11, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 4.99, 1),
(11, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 4.99, 1),
(12, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 3.59, 1),
(12, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 3.59, 1),
(12, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 3.59, 1),
(13, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 1.79, 1),
(13, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 1.79, 1),
(13, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 1.79, 1),
(14, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 2.24, 1),
(14, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 2.24, 1),
(14, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 2.24, 1),
(15, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 8.33, 1),
(15, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 8.33, 1),
(15, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 8.33, 1),
(16, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.66, 1),
(16, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.66, 1),
(16, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.66, 1),
(17, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.79, 1),
(17, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.79, 1),
(17, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.79, 1),
(18, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 3.59, 1),
(18, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 3.59, 1),
(18, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 3.59, 1),
(19, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 1.79, 1),
(19, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 1.79, 1),
(19, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 1.79, 1),
(20, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 2.24, 1),
(20, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 2.24, 1),
(20, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 2.24, 1),
(21, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.66, 1),
(21, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.66, 1),
(21, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.66, 1),
(22, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.79, 1),
(22, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.79, 1),
(22, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.79, 1),
(23, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 3.59, 1),
(23, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 3.59, 1),
(23, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 3.59, 1),
(24, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 1.79, 1),
(24, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 1.79, 1),
(24, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 1.79, 1),
(25, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.66, 1),
(25, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.66, 1),
(25, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.66, 1),
(26, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.66, 1),
(26, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.66, 1),
(26, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.66, 1),
(27, '2022-05-02', '2022-06-02', '2022-05-02', '2022-06-02', 1, 0.79, 1),
(27, '2022-06-02', '2022-07-02', '2022-06-02', '2022-07-02', 1, 0.79, 1),
(27, '2022-07-02', '2022-08-02', '2022-07-02', '2022-08-02', 0, 0.79, 1),
(28, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1),
(28, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1),
(29, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1),
(29, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1),
(30, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1),
(30, '2021-12-10', '2022-07-12', '2021-12-10', '2022-07-12', 1, 0.0, 1);