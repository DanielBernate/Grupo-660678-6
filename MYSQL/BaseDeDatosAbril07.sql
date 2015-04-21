-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tiendaEnLinea
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tiendaEnLinea` ;

-- -----------------------------------------------------
-- Schema tiendaEnLinea
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendaEnLinea` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
USE `tiendaEnLinea` ;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Usuario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Usuario` (
  `idUsuario` VARCHAR(20) NOT NULL COMMENT 'Llave primaria del usuario',
  `contrasena` VARCHAR(45) NOT NULL COMMENT 'Contraseña del usuario',
  `rol` VARCHAR(45) NOT NULL COMMENT 'Rol del Usuario',
  `estado` VARCHAR(20) NOT NULL COMMENT 'Estado del usuario',
  `email` VARCHAR(45) NOT NULL COMMENT 'Correo Electronico del Usuario',
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Cuenta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Cuenta` (
  `tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave priamria tipo documento cuenta',
  `numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave priamria número documento cuenta',
  `primerNombre` VARCHAR(100) NOT NULL COMMENT 'Primer nombre de la persona',
  `segundoNombre` VARCHAR(45) NULL COMMENT 'Segundo nombre de la persona',
  `primerApellido` VARCHAR(100) NOT NULL COMMENT 'Primer apellido de la persona',
  `segundoApellido` VARCHAR(45) NULL COMMENT 'Segundo apellido de la persona',
  `Usuario_idUsuario` VARCHAR(20) NOT NULL COMMENT 'Llave foránea ID usuario',
  PRIMARY KEY (`tipoDocumento`, `numeroDocumento`),
  CONSTRAINT `fk_Cuenta_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `tiendaEnLinea`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Factura` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de la factura',
  `fecha` DATETIME NOT NULL COMMENT 'Fecha y Hora de la factura',
  `total` FLOAT NOT NULL COMMENT 'Total de la factura',
  `Cuenta_tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave foránea tipo Documento de cuenta',
  `Cuenta_numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave foránea número de docuemnto de cuenta',
  PRIMARY KEY (`idFactura`),
  CONSTRAINT `fk_Factura_Cuenta1`
    FOREIGN KEY (`Cuenta_tipoDocumento` , `Cuenta_numeroDocumento`)
    REFERENCES `tiendaEnLinea`.`Cuenta` (`tipoDocumento` , `numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Pago` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Pago` (
  `Factura_idFactura` INT NOT NULL COMMENT 'Llave foranea primaria de ID Factura',
  `numTarCredito` VARCHAR(45) NOT NULL COMMENT 'Número Tarjeta del pago',
  `banco` VARCHAR(100) NOT NULL COMMENT 'Banco Tarjeta',
  `tipoCuentaTar` VARCHAR(20) NOT NULL COMMENT 'Tipo de Cuenta Tarjeta',
  `tipoTransaccion` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Factura_idFactura`),
  CONSTRAINT `fk_Pago_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `tiendaEnLinea`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Pedido` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Pedido` (
  `Factura_idFactura` INT NOT NULL COMMENT 'Llave foránea primaria ID factura',
  `total` FLOAT NOT NULL COMMENT 'Precio Total del pedido',
  `subtotal` FLOAT NOT NULL COMMENT 'Subtotal del pedido',
  `impuestos` FLOAT NOT NULL COMMENT 'Impuestos del pedido',
  PRIMARY KEY (`Factura_idFactura`),
  CONSTRAINT `fk_Pedido_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `tiendaEnLinea`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Categoria` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de categoria',
  `nombreCategoria` VARCHAR(100) NOT NULL COMMENT 'Nombre de la categoria',
  `activa` TINYINT(1) NOT NULL,
  `pariente` INT NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Producto` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Producto` (
  `idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave primaria producto',
  `nombre` VARCHAR(300) NOT NULL COMMENT 'Nombre del producto',
  `marca` VARCHAR(45) NOT NULL COMMENT 'Marca del producto',
  `referencia` VARCHAR(45) NOT NULL COMMENT 'Referencia del producto ',
  `descripcion` VARCHAR(500) NOT NULL COMMENT 'Descripcion del producto',
  `material` VARCHAR(45) NOT NULL COMMENT 'Material del producto',
  `color` VARCHAR(45) NOT NULL COMMENT 'Color del producto',
  `foto` LONGBLOB NULL COMMENT 'Foto del producto',
  `cantidad` INT NOT NULL COMMENT 'Unidades existentes del producto',
  `activo` TINYINT(1) NOT NULL COMMENT 'Estado del producto',
  `precioUnitario` FLOAT NOT NULL COMMENT 'Precio Unitario del producto',
  `descuento` FLOAT NOT NULL COMMENT 'Descuento del producto',
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `tiendaEnLinea`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Item` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Item` (
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foránea ID producto\n',
  `Pedido_Factura_idFactura` INT NOT NULL COMMENT 'Llave foránea Pedido',
  `cantidad` INT NOT NULL COMMENT 'Cantidad del producto',
  `costoUnitario` FLOAT NOT NULL COMMENT 'Costo Unitario del producto',
  `costoTotal` FLOAT NOT NULL COMMENT 'Costo Total del Item',
  PRIMARY KEY (`Producto_idProducto`, `Pedido_Factura_idFactura`),
  CONSTRAINT `fk_Item_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaEnLinea`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Pedido1`
    FOREIGN KEY (`Pedido_Factura_idFactura`)
    REFERENCES `tiendaEnLinea`.`Pedido` (`Factura_idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Proveedor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Proveedor` (
  `idProveedor` VARCHAR(45) NOT NULL COMMENT 'Llave primaria compuesta de proveedor ',
  `tipoDeIdentificacion` VARCHAR(20) NOT NULL COMMENT 'Llave primaria compuesta de proveedor',
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre del proveedor',
  `email` VARCHAR(45) NOT NULL COMMENT 'Correo electrónico del proveedor',
  PRIMARY KEY (`idProveedor`, `tipoDeIdentificacion`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`CarritoDeCompras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`CarritoDeCompras` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`CarritoDeCompras` (
  `idCarritoDeCompras` VARCHAR(255) NOT NULL COMMENT 'Llave primaria de carrito de compras ',
  `subtotal` FLOAT NOT NULL COMMENT 'Subtotasl del carrito',
  `precioTotal` FLOAT NOT NULL COMMENT 'Precio total del carrito',
  `impuestos` FLOAT NOT NULL COMMENT 'Impuestos carritos',
  PRIMARY KEY (`idCarritoDeCompras`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Inventario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Inventario` (
  `idInventario` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria inventario',
  `fecha` DATE NOT NULL COMMENT 'Fecha de la compra',
  `cantidad` INT NOT NULL COMMENT 'Cantidad comprada',
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foranea ID Producto',
  `Proveedor_idProveedor` VARCHAR(45) NOT NULL COMMENT 'Llave foranea Id Proveedor',
  `Proveedor_tipoDeIdentificacion` VARCHAR(20) NOT NULL COMMENT 'Llave foraena Proveedor tipo de Identificacion',
  PRIMARY KEY (`idInventario`, `Producto_idProducto`, `Proveedor_idProveedor`, `Proveedor_tipoDeIdentificacion`),
  CONSTRAINT `fk_Inventario_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaEnLinea`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor` , `Proveedor_tipoDeIdentificacion`)
    REFERENCES `tiendaEnLinea`.`Proveedor` (`idProveedor` , `tipoDeIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Departamento` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Departamento` (
  `idDepartamento` VARCHAR(2) NOT NULL COMMENT 'Llave primaria del departamento',
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del departamento',
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Municipio` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Municipio` (
  `idMunicipio` VARCHAR(4) NOT NULL COMMENT 'Llave primaria municipio',
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del municipio',
  `Departamento_idDepartamento` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  CONSTRAINT `fk_Municipio_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `tiendaEnLinea`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Domicilio_Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Domicilio_Cuenta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Domicilio_Cuenta` (
  `Cuenta_tipoDocumento` VARCHAR(10) NOT NULL COMMENT 'Llave primaria Cuenta tipo Documento',
  `Cuenta_numeroDocumento` VARCHAR(45) NOT NULL COMMENT 'Llave primaria Cuenta Número docuemnto',
  `telefono` VARCHAR(45) NOT NULL COMMENT 'Teléfono del domicilio',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Dirección del domicilio',
  `barrio` VARCHAR(100) NOT NULL COMMENT 'Barrio del Domicilio',
  `localidad` VARCHAR(100) NULL COMMENT 'Localidad del domicilio',
  `Municipio_idMunicipio` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Cuenta_tipoDocumento`, `Cuenta_numeroDocumento`),
  CONSTRAINT `fk_Domicilio_Municipio1`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `tiendaEnLinea`.`Municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Cuenta1`
    FOREIGN KEY (`Cuenta_tipoDocumento` , `Cuenta_numeroDocumento`)
    REFERENCES `tiendaEnLinea`.`Cuenta` (`tipoDocumento` , `numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Item_Carrito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Item_Carrito` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Item_Carrito` (
  `Producto_idProducto` VARCHAR(100) NOT NULL COMMENT 'Llave foránea ID producto',
  `CarritoDeCompras_idCarritoDeCompras` VARCHAR(255) NOT NULL,
  `cantidad` INT NOT NULL COMMENT 'Cantidad del producto',
  `costoUnitario` FLOAT NOT NULL COMMENT 'Costo Unitario del producto',
  `costoTotal` FLOAT NOT NULL COMMENT 'Costo Total del Item',
  PRIMARY KEY (`Producto_idProducto`, `CarritoDeCompras_idCarritoDeCompras`),
  CONSTRAINT `fk_Producto_has_CarritoDeCompras_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `tiendaEnLinea`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Carrito_CarritoDeCompras1`
    FOREIGN KEY (`CarritoDeCompras_idCarritoDeCompras`)
    REFERENCES `tiendaEnLinea`.`CarritoDeCompras` (`idCarritoDeCompras`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tiendaEnLinea`.`Domicilio_Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tiendaEnLinea`.`Domicilio_Proveedor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tiendaEnLinea`.`Domicilio_Proveedor` (
  `Proveedor_idProveedor` VARCHAR(45) NOT NULL,
  `Proveedor_tipoDeIdentificacion` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL COMMENT 'Teléfono del domicilio',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Dirección del domicilio',
  `barrio` VARCHAR(100) NOT NULL COMMENT 'Barrio del Domicilio',
  `localidad` VARCHAR(100) NULL COMMENT 'Localidad del domicilio',
  `Municipio_idMunicipio` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Proveedor_idProveedor`, `Proveedor_tipoDeIdentificacion`),
  CONSTRAINT `fk_Domicilio_Municipio10`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `tiendaEnLinea`.`Municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Domicilio_Proveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor` , `Proveedor_tipoDeIdentificacion`)
    REFERENCES `tiendaEnLinea`.`Proveedor` (`idProveedor` , `tipoDeIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
