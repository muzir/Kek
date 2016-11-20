-- Dumping database structure for kek
CREATE DATABASE IF NOT EXISTS `kek` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `kek`;


-- Dumping structure for table kek.kek_user
CREATE TABLE IF NOT EXISTS `kek_user` (
  `id` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL **AUTO_INCREMENT**,
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password_sha256` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_login_ts` timestamp NULL DEFAULT NULL,
  `creation_ts` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `activation_ts` timestamp NULL DEFAULT NULL,
  `activation_key` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` char(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '0: Active, 1: Passive',
  `timezone` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `language` char(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- Dumping structure for table kek.kek_user
use kek;
CREATE TABLE IF NOT EXISTS `kek_todo` (
  `id` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `creation_ts` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` varchar(2048) COLLATE utf8mb4_unicode_ci NOT null,
  `userId` char(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`userId`) REFERENCES kek.kek_user(`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;