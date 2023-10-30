-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 03:06:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vacunar23`
--
CREATE DATABASE IF NOT EXISTS `vacunar23` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacunar23`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citavacunacion`
--

CREATE TABLE `citavacunacion` (
  `codCita` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `codRefuerzo` int(11) NOT NULL,
  `fechaHoraCita` datetime NOT NULL,
  `centroVacunacion` varchar(50) NOT NULL,
  `fechaHoraColoca` datetime DEFAULT NULL,
  `dosis` int(11) DEFAULT NULL,
  `cancelar` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `citavacunacion`:
--   `dni`
--       `ciudadano` -> `dni`
--   `dosis`
--       `vacuna` -> `nroSerieDosis`
--

--
-- Volcado de datos para la tabla `citavacunacion`
--

INSERT INTO `citavacunacion` (`codCita`, `dni`, `codRefuerzo`, `fechaHoraCita`, `centroVacunacion`, `fechaHoraColoca`, `dosis`, `cancelar`) VALUES
(3, 12345678, 1, '2023-11-13 10:00:00', 'Hospital Del Oeste Dr. Atilio Luchini', NULL, 0, 0),
(4, 99887766, 1, '2023-10-28 08:00:00', 'Hospital Del Oeste Dr. Atilio Luchini', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `dni` int(11) NOT NULL,
  `nombreCompleto` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `celular` varchar(50) NOT NULL,
  `patologia` varchar(100) DEFAULT NULL,
  `ambitoTrabajo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `ciudadano`:
--

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`dni`, `nombreCompleto`, `email`, `celular`, `patologia`, `ambitoTrabajo`) VALUES
(12345678, 'Carlos Ordoñez', 'charlyO@gmail.com', '2664998877', 'NINGUNO', 'EDUCACIÓN'),
(99887766, 'José Correa', 'pepeNoGuardiola@mail.com', '11994466', 'OBESIDAD', 'SEGURIDAD'),
(2147483647, 'María Jesús López', 'mariaJL@gmail.com', '74347856', 'EPOC', 'OTRO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `CUIT` int(11) NOT NULL,
  `nomLaboratorio` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `domComercial` varchar(50) NOT NULL,
  `marca` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `laboratorio`:
--

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`CUIT`, `nomLaboratorio`, `pais`, `domComercial`, `marca`) VALUES
(1023336655, 'lab', 'USA', 'Oxford', 'Astra Zeneca'),
(1111111111, 'Centro Gamaleya', 'Rusia', 'Clausse 5891', 'SputnikV'),
(1234567890, 'Rotembergh', 'Suiza', 'Pensilvani 1566', 'Vikzin'),
(2147483647, 'Instituto de Productos Biológi', 'China', 'Mitre 734', 'Sinopharm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `nroSerieDosis` int(11) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `medida` double NOT NULL,
  `fechaCaduca` date NOT NULL,
  `colocada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `vacuna`:
--   `marca`
--       `laboratorio` -> `marca`
--

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`nroSerieDosis`, `marca`, `medida`, `fechaCaduca`, `colocada`) VALUES
(0, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(21, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(22, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(23, 'Astra Zeneca', 0.3, '2023-11-04', 0),
(28, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(30, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(31, 'Astra Zeneca', 0.3, '2024-11-14', 0),
(35, 'Astra Zeneca', 0.3, '2025-03-04', 0),
(40, 'Astra Zeneca', 0.3, '2023-10-04', 0),
(1928, 'Astra Zeneca', 0.3, '2025-10-10', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD PRIMARY KEY (`codCita`),
  ADD UNIQUE KEY `dni` (`dni`,`codRefuerzo`) USING BTREE,
  ADD KEY `dosis` (`dosis`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD UNIQUE KEY `CUIT` (`CUIT`),
  ADD UNIQUE KEY `nomLaboratorio` (`nomLaboratorio`),
  ADD UNIQUE KEY `marca` (`marca`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`nroSerieDosis`),
  ADD KEY `marca` (`marca`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  MODIFY `codCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citavacunacion`
--
ALTER TABLE `citavacunacion`
  ADD CONSTRAINT `citaVacunacion_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `ciudadano` (`dni`),
  ADD CONSTRAINT `citaVacunacion_ibfk_2` FOREIGN KEY (`dosis`) REFERENCES `vacuna` (`nroSerieDosis`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `Vacuna_ibfk_1` FOREIGN KEY (`marca`) REFERENCES `laboratorio` (`marca`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
