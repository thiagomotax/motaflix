-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Mar-2021 às 19:05
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `motaflix`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `actor`
--

CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `height` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `actor`
--

INSERT INTO `actor` (`id`, `name`, `birthday`, `height`) VALUES
(1, 'teste de xarope', '1998-04-28', 1.95),
(2, 'teste', '1998-04-28', 1.92),
(3, 'teste', '1998-04-28', 1.95);

-- --------------------------------------------------------

--
-- Estrutura da tabela `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'teste'),
(2, 'teste'),
(3, 'teste2'),
(5, 'dado'),
(6, 'das');

-- --------------------------------------------------------

--
-- Estrutura da tabela `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `media_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `language`
--

CREATE TABLE `language` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `acronym` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `media`
--

CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `release_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `media`
--

INSERT INTO `media` (`id`, `name`, `description`, `release_date`) VALUES
(1, 'dsadsa', 'dassda', '1998-04-28'),
(2, 'das', 'ads', '2221-10-22'),
(4, 'dasdasx', 'dasaddsa', '1998-04-28'),
(6, 'dsa', 'das', '1998-04-28'),
(7, 'dasaads', 'das', '1998-04-28'),
(8, 'dsa', 'das', '1998-04-28'),
(9, 'dasdsa', 'das', '1998-04-28'),
(10, 'daads', '51551', '1998-04-28'),
(11, 'asdas', 'dasas', '1998-04-28'),
(12, 'dsdas', 'das', '1998-04-28'),
(13, 'dsad', 'das', '2000-04-28'),
(14, 'cagada', 'das', '1998-04-28');

-- --------------------------------------------------------

--
-- Estrutura da tabela `media_has_actor`
--

CREATE TABLE `media_has_actor` (
  `media_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `media_has_category`
--

CREATE TABLE `media_has_category` (
  `media_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `media_has_genre`
--

CREATE TABLE `media_has_genre` (
  `media_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `media_has_language`
--

CREATE TABLE `media_has_language` (
  `media_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parental`
--

CREATE TABLE `parental` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `min_interval` int(11) NOT NULL,
  `max_interval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `parental`
--

INSERT INTO `parental` (`id`, `name`, `min_interval`, `max_interval`) VALUES
(1, 'Adolescente', 3, 6),
(2, 'Teste', 12, 18);

-- --------------------------------------------------------

--
-- Estrutura da tabela `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `subscription_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `plan`
--

CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rating`
--

CREATE TABLE `rating` (
  `id` int(11) NOT NULL,
  `value` float NOT NULL,
  `media_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `subscription`
--

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `plan_id` int(11) NOT NULL,
  `due` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `subtitle`
--

CREATE TABLE `subtitle` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `media_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `parental_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `name`, `cpf`, `birthday`, `email`, `password`, `parental_id`) VALUES
(28, 'Usuario teste 1', '136.586.026-43', '1998-04-28', 'dasdsa@gmail.com', '84068905', 1),
(29, 'dasda', '151.515.111-51', '1998-04-28', 'daasd@gmail.com', '84068905', 1),
(30, 'dasdsa', '136.586.026-41', '1998-04-28', 'dsadaad', 'dasdsaa', 1),
(31, 'dsad', '136.586.026-43', '1998-04-28', 'das', 'das', 1),
(32, 'dasdsa', '151.551.515-15', '1998-04-28', 'das', 'das', 1),
(33, 'dassa', '136.586.026-43', '1998-04-28', 'das', 'das', 1),
(34, 'dassa', '136.586.026-43', '1998-04-28', 'das', 'dd', 1),
(35, 'd', '136.586.026-43', '1998-04-28', 'das', 'dsadas', 1),
(36, 'das', '136.586.026-43', '1998-04-28', 'das', 'das', 1),
(37, 'dsasad', '136.586.026-46', '1998-04-28', 'das', 'das', 2),
(38, 'Thiago Mota', '136.586.026-43', '1998-04-28', 'dasdsa', '8406', 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_favorite_user1_idx` (`user_id`),
  ADD KEY `fk_favorite_media1_idx` (`media_id`);

--
-- Índices para tabela `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `media_has_actor`
--
ALTER TABLE `media_has_actor`
  ADD PRIMARY KEY (`media_id`,`actor_id`),
  ADD KEY `fk_media_has_actor_actor1_idx` (`actor_id`),
  ADD KEY `fk_media_has_actor_media1_idx` (`media_id`);

--
-- Índices para tabela `media_has_category`
--
ALTER TABLE `media_has_category`
  ADD PRIMARY KEY (`media_id`,`category_id`),
  ADD KEY `fk_media_has_category_category1_idx` (`category_id`),
  ADD KEY `fk_media_has_category_media_idx` (`media_id`);

--
-- Índices para tabela `media_has_genre`
--
ALTER TABLE `media_has_genre`
  ADD PRIMARY KEY (`media_id`,`genre_id`),
  ADD KEY `fk_media_has_genre_genre1_idx` (`genre_id`),
  ADD KEY `fk_media_has_genre_media1_idx` (`media_id`);

--
-- Índices para tabela `media_has_language`
--
ALTER TABLE `media_has_language`
  ADD PRIMARY KEY (`media_id`,`language_id`),
  ADD KEY `fk_media_has_language_language1_idx` (`language_id`),
  ADD KEY `fk_media_has_language_media1_idx` (`media_id`);

--
-- Índices para tabela `parental`
--
ALTER TABLE `parental`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_payment_subscription1_idx` (`subscription_id`);

--
-- Índices para tabela `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_rating_media1_idx` (`media_id`),
  ADD KEY `fk_rating_user1_idx` (`user_id`);

--
-- Índices para tabela `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_subscription_user1_idx` (`user_id`),
  ADD KEY `fk_subscription_plan1_idx` (`plan_id`);

--
-- Índices para tabela `subtitle`
--
ALTER TABLE `subtitle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_subtitle_media1_idx` (`media_id`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_parental1_idx` (`parental_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `actor`
--
ALTER TABLE `actor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `favorite`
--
ALTER TABLE `favorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `language`
--
ALTER TABLE `language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `media`
--
ALTER TABLE `media`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `parental`
--
ALTER TABLE `parental`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `plan`
--
ALTER TABLE `plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `subscription`
--
ALTER TABLE `subscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `subtitle`
--
ALTER TABLE `subtitle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `fk_favorite_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_favorite_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `media_has_actor`
--
ALTER TABLE `media_has_actor`
  ADD CONSTRAINT `fk_media_has_actor_actor1` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_media_has_actor_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `media_has_category`
--
ALTER TABLE `media_has_category`
  ADD CONSTRAINT `fk_media_has_category_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_media_has_category_media` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `media_has_genre`
--
ALTER TABLE `media_has_genre`
  ADD CONSTRAINT `fk_media_has_genre_genre1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_media_has_genre_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `media_has_language`
--
ALTER TABLE `media_has_language`
  ADD CONSTRAINT `fk_media_has_language_language1` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_media_has_language_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_payment_subscription1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `fk_rating_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rating_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `subscription`
--
ALTER TABLE `subscription`
  ADD CONSTRAINT `fk_subscription_plan1` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_subscription_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `subtitle`
--
ALTER TABLE `subtitle`
  ADD CONSTRAINT `fk_subtitle_media1` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_parental1` FOREIGN KEY (`parental_id`) REFERENCES `parental` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
