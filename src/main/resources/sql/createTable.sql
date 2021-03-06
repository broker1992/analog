CREATE TABLE `analog_info` (
  `id` BIGINT(10) NOT NULL,
  `name_china` VARBINARY(250) DEFAULT NULL,
  `name_english` VARBINARY(250) DEFAULT NULL,
  `path` VARBINARY(1024) DEFAULT NULL,
  `return` TEXT,
  `create_date` DATE DEFAULT NULL,
  `create_user` VARBINARY(250) DEFAULT NULL,
  `update_date` DATE DEFAULT NULL,
  `update_user` VARBINARY(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8