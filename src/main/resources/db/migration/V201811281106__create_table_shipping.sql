CREATE TABLE `shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` VARCHAR(256),
  `quantity` int(11),
  `address` VARCHAR(10000),
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;