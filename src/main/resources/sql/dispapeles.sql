/* Creando base de datos */
CREATE DATABASE `dispapeles`;

/* Creando tablas para los tipo de identificación */
CREATE TABLE tipo_identificacion
(
    id     INT auto_increment NOT NULL,
    nombre varchar(100)       NOT NULL,
    CONSTRAINT tipo_identificacion_PK PRIMARY KEY (id)
);

INSERT INTO tipo_identificacion (nombre)
VALUES ('Cédula de ciudadanía'),
       ('Tarjeta de identidad'),
       ('Cédula de extranjería');

/* Creando tablas de clientes */
CREATE TABLE cliente
(
    id                  INT auto_increment NOT NULL,
    nombre              varchar(250)       NOT NULL,
    apellidos           varchar(250)       NOT NULL,
    edad                INT                NOT NULL,
    teleforno           VARCHAR(100)       NOT NULL,
    direccion           varchar(2500)      NOT NULL,
    tipo_identificacion INT                NOT NULL,
    CONSTRAINT cliente_PK PRIMARY KEY (id),
    CONSTRAINT cliente_FK FOREIGN KEY (tipo_identificacion) REFERENCES tipo_identificacion (id)
);


