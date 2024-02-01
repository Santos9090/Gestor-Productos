-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-02-2024 a las 10:08:27
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ud4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `Precio` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `categoria` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=149 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `Nombre`, `Precio`, `Cantidad`, `categoria`) VALUES
(60, 'Mesa de Centro', 120, 8, 'Hogar'),
(61, 'Reloj Deportivo', 35, 12, 'Deportes'),
(62, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(63, 'Gorra Deportiva', 10, 50, 'Deportes'),
(64, 'Vestido Elegante', 45, 15, 'Ropa'),
(65, 'Tablet Android', 300, 7, 'Electrónicos'),
(66, 'Silla de Escritorio', 80, 10, 'Hogar'),
(67, 'Balón de Fútbol', 15, 20, 'Deportes'),
(68, 'Peluche Suave', 12, 30, 'Juguetes'),
(69, 'Camiseta', 20, 30, 'Ropa'),
(70, 'Televisor LED', 400, 5, 'Electrónicos'),
(71, 'Sofá de Cuero', 600, 2, 'Hogar'),
(72, 'Zapatillas Deportivas', 50, 15, 'Deportes'),
(73, 'Juego de Construcción', 30, 10, 'Juguetes'),
(74, 'Blusa Floral', 25, 25, 'Ropa'),
(75, 'Computadora Portátil', 800, 3, 'Electrónicos'),
(76, 'Mesa de Centro', 120, 8, 'Hogar'),
(77, 'Reloj Deportivo', 35, 12, 'Deportes'),
(78, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(79, 'Gorra Deportiva', 10, 50, 'Deportes'),
(80, 'Vestido Elegante', 45, 15, 'Ropa'),
(81, 'Tablet Android', 300, 7, 'Electrónicos'),
(82, 'Silla de Escritorio', 80, 10, 'Hogar'),
(83, 'Balón de Fútbol', 15, 20, 'Deportes'),
(84, 'Peluche Suave', 12, 30, 'Juguetes'),
(85, 'Camiseta', 20, 30, 'Ropa'),
(86, 'Televisor LED', 400, 5, 'Electrónicos'),
(87, 'Sofá de Cuero', 600, 2, 'Hogar'),
(88, 'Zapatillas Deportivas', 50, 15, 'Deportes'),
(89, 'Juego de Construcción', 30, 10, 'Juguetes'),
(90, 'Blusa Floral', 25, 25, 'Ropa'),
(91, 'Computadora Portátil', 800, 3, 'Electrónicos'),
(92, 'Mesa de Centro', 120, 8, 'Hogar'),
(93, 'Reloj Deportivo', 35, 12, 'Deportes'),
(94, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(95, 'Gorra Deportiva', 10, 50, 'Deportes'),
(96, 'Vestido Elegante', 45, 15, 'Ropa'),
(97, 'Tablet Android', 300, 7, 'Electrónicos'),
(98, 'Silla de Escritorio', 80, 10, 'Hogar'),
(99, 'Balón de Fútbol', 15, 20, 'Deportes'),
(100, 'Cochecito', 12, 30, 'Juguetes'),
(101, 'Camiseta', 20, 30, 'Ropa'),
(102, 'Televisor LED', 400, 5, 'Electrónicos'),
(103, 'Sofá de Cuero', 600, 2, 'Hogar'),
(104, 'Zapatillas Deportivas', 50, 15, 'Deportes'),
(105, 'Juego de Construcción', 30, 10, 'Juguetes'),
(106, 'Blusa Floral', 25, 25, 'Ropa'),
(107, 'Computadora Portátil', 800, 3, 'Electrónicos'),
(108, 'Mesa de Centro', 120, 8, 'Hogar'),
(109, 'Reloj Deportivo', 35, 12, 'Deportes'),
(110, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(111, 'Gorra Deportiva', 10, 50, 'Deportes'),
(112, 'Vestido Elegante', 45, 15, 'Ropa'),
(113, 'Tablet Android', 300, 7, 'Electrónicos'),
(114, 'Silla de Escritorio', 80, 10, 'Hogar'),
(115, 'Balón de Fútbol', 15, 20, 'Deportes'),
(116, 'Peluche Suave', 12, 30, 'Juguetes'),
(117, 'Camiseta', 20, 30, 'Ropa'),
(118, 'Televisor LED', 400, 5, 'Electrónicos'),
(119, 'Sofá de Cuero', 600, 2, 'Hogar'),
(120, 'Zapatillas Deportivas', 50, 15, 'Deportes'),
(121, 'Juego de Construcción', 30, 10, 'Juguetes'),
(122, 'Blusa Floral', 25, 25, 'Ropa'),
(123, 'Computadora Portátil', 800, 3, 'Electrónicos'),
(124, 'Mesa de Centro', 120, 8, 'Hogar'),
(125, 'Reloj Deportivo', 35, 12, 'Deportes'),
(126, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(127, 'Gorra Deportiva', 10, 50, 'Deportes'),
(128, 'Vestido Elegante', 45, 15, 'Ropa'),
(129, 'Tablet Android', 300, 7, 'Electrónicos'),
(130, 'Silla de Escritorio', 80, 10, 'Hogar'),
(131, 'Balón de Fútbol', 15, 20, 'Deportes'),
(132, 'Peluche Suave', 12, 30, 'Juguetes'),
(133, 'Camiseta', 20, 30, 'Ropa'),
(134, 'Televisor LED', 400, 5, 'Electrónicos'),
(135, 'Sofá de Cuero', 600, 2, 'Hogar'),
(136, 'Zapatillas Deportivas', 50, 15, 'Deportes'),
(137, 'Juego de Construcción', 30, 10, 'Juguetes'),
(138, 'Blusa Floral', 25, 25, 'Ropa'),
(139, 'Computadora Portátil', 800, 3, 'Electrónicos'),
(140, 'Mesa de Centro', 120, 8, 'Hogar'),
(141, 'Reloj Deportivo', 35, 12, 'Deportes'),
(142, 'Muñeca Articulada', 15, 20, 'Juguetes'),
(143, 'Gorra Deportiva', 10, 50, 'Deportes'),
(144, 'Vestido Elegante', 45, 15, 'Ropa'),
(145, 'Tablet Android', 300, 7, 'Electrónicos'),
(146, 'Silla de Escritorio', 80, 10, 'Hogar'),
(147, 'Balón de Fútbol', 15, 20, 'Deportes'),
(148, 'Peluche Suave', 12, 30, 'Juguetes');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
