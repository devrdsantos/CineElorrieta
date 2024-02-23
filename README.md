-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-02-2024 a las 21:11:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE DATABASE reto3;

CREATE TABLE `cine` (
  `idcine` int(11) NOT NULL,
  `nombrecine` varchar(32) NOT NULL,
  `localidad` varchar(32) NOT NULL,
  `direccion` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`idcine`, `nombrecine`, `localidad`, `direccion`) VALUES
(1, 'Cine Zubiarte', 'Deusto', 'Cerca del guggenheim'),
(2, 'Cine Deusto', 'Deusto', 'cerca del pupy'),
(3, 'Cine Elorrieta', 'San Ignacio', 'Al lado de elorrieta-errekamari');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idcompra` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `descuento` varchar(3) NOT NULL,
  `fechacompra` varchar(32) NOT NULL,
  `horacompra` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idcompra`, `dni`, `descuento`, `fechacompra`, `horacompra`) VALUES
(1, '12345678A', '30%', '20-02-2024', '17:40'),
(2, '12345678A', '30%', '20-02-2024', '17:40'),
(3, '12345678A', '30%', '20-02-2024', '17:40');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `identrada` int(11) NOT NULL,
  `fecha` varchar(32) NOT NULL,
  `nombrepelicula` varchar(32) NOT NULL,
  `horario` varchar(32) NOT NULL,
  `idsala` int(11) NOT NULL,
  `precio` double(4,2) NOT NULL,
  `cine` varchar(32) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `idcompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`identrada`, `fecha`, `nombrepelicula`, `horario`, `idsala`, `precio`, `cine`, `cantidad`, `idcompra`) VALUES
(1, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 3, 4),
(2, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 2, 4),
(3, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 2, 4),
(4, '28-02-2024', 'Parasite', '20:15 ', 7, 10.00, 'Cine Elorrieta', 2, 4),
(5, '28-02-2024', 'Parasite', '20:15 ', 7, 10.00, 'Cine Elorrieta', 2, 4),
(6, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 2, 4),
(7, '01-03-2024', 'Gladiator', '15:20 ', 5, 12.00, 'Cine Deusto', 2, 4),
(9, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 2, 4),
(10, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 4, 4),
(11, '28-02-2024', 'Inception', '15:45 ', 1, 10.00, 'Cine Zubiarte', 2, 4),
(12, '01-03-2024', 'Gladiator', '15:20 ', 5, 12.00, 'Cine Deusto', 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idfuncion` int(11) NOT NULL,
  `hora` varchar(32) NOT NULL,
  `fecha` varchar(32) NOT NULL,
  `precio` double(4,2) NOT NULL,
  `idsala` int(11) NOT NULL,
  `idpelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `funcion`
--

INSERT INTO `funcion` (`idfuncion`, `hora`, `fecha`, `precio`, `idsala`, `idpelicula`) VALUES
(1, '15:45', '28-02-2024', 10.00, 1, 1),
(2, '18:30', '28-02-2024', 10.00, 4, 1),
(3, '17:35', '01-03-2024', 12.00, 2, 1),
(4, '12:55', '29-02-2024', 15.00, 3, 2),
(5, '20:15', '28-02-2024', 10.00, 7, 2),
(6, '19:40', '01-03-2024', 12.00, 8, 2),
(7, '15:20', '01-03-2024', 12.00, 5, 3),
(8, '19:30', '28-02-2024', 10.00, 1, 3),
(9, '11:55', '29-02-2024', 15.00, 9, 3),
(10, '12:40', '02-03-2024', 12.00, 2, 3),
(11, '19:40', '01-03-2024', 10.00, 4, 4),
(12, '20:35', '02-03-2024', 15.00, 9, 4),
(13, '12:40', '28-02-2024', 10.00, 1, 5),
(14, '18:10', '29-02-2024', 10.00, 7, 5),
(15, '10:55', '28-02-2024', 12.00, 5, 5),
(16, '12:40', '02-03-2024', 10.00, 1, 6),
(17, '16:25', '29-02-2024', 10.00, 4, 6),
(18, '18:30', '28-02-2024', 12.00, 2, 6),
(19, '12:40', '01-03-2024', 15.00, 3, 7),
(20, '16:25', '29-02-2024', 15.00, 6, 7),
(21, '18:30', '28-02-2024', 15.00, 6, 7),
(22, '19:20', '28-02-2024', 12.00, 8, 7),
(23, '15:55', '02-03-2024', 10.00, 7, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idpelicula` int(11) NOT NULL,
  `nombrepelicula` varchar(32) NOT NULL,
  `duracion` int(11) NOT NULL,
  `genero` varchar(32) NOT NULL,
  `sinopsis` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idpelicula`, `nombrepelicula`, `duracion`, `genero`, `sinopsis`) VALUES
(1, 'Inception', 148, 'Ciencia ficción/Acción', 'Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños, se le da la tarea inversa de plantar una idea en la mente de un CEO.'),
(2, 'Parasite', 132, 'Drama/Thriller', 'Una familia empobrecida se infiltra en la casa de una familia rica, lo que lleva a eventos inesperadamente oscuros.'),
(3, 'Gladiator', 155, 'Acción/Drama histórico', 'Un general romano traicionado se convierte en gladiador y lucha por venganza contra el corrupto emperador que asesinó a su familia y lo envió al exilio.'),
(4, 'Intocable', 112, 'Comedia/Drama', 'Después de quedar paralítico en un accidente de parapente, un aristócrata contrata a un joven de los suburbios como su cuidador.'),
(5, 'El Gran Hotel Budapest', 99, 'Comedia/Drama', 'El conserje de un famoso hotel europeo entre guerras se alía con uno de sus empleados para demostrar su inocencia después de ser acusado de asesinato.'),
(6, 'Coco', 105, 'Animación/Fantasía', 'Un joven músico entra en la Tierra de los Muertos para encontrar a su bisabuelo, un legendario cantante, y revertir la prohibición de su familia sobre la música.'),
(7, 'El Señor de los Anillos', 178, 'Fantasía/Aventura', 'Un joven hobbit, Frodo, se embarca en una peligrosa misión para destruir un anillo antiguo que es buscado por el malvado Sauron.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idsala` int(11) NOT NULL,
  `nombresala` varchar(32) NOT NULL,
  `idcine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`idsala`, `nombresala`, `idcine`) VALUES
(1, 'central', 1),
(2, '3D', 1),
(3, '4KMAX', 1),
(4, 'CENTRAL', 2),
(5, '3D', 2),
(6, '4KMAX', 2),
(7, 'CENTRAL', 3),
(8, '3D', 3),
(9, '4KMAX', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `dni` varchar(9) NOT NULL,
  `password` varchar(24) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `sexo` enum('Masculino','Femenino','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`dni`, `password`, `nombre`, `apellido`, `sexo`) VALUES
('16097536C', 'FKSztYaooauCEix9YS7Ljw==', 'Izan', 'Rodriguez', 'Masculino'),
('12345678A', 'NK7/M8ntlF6/Cr6u3MalyA==', 'Daniel', 'Santos', 'Masculino');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`identrada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `identrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
