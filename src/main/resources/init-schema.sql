DROP TABLE IF EXISTS 'user';
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `salt` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `head_url` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS 'news';
CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `link` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_date` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
