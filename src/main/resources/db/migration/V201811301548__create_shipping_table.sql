CREATE TABLE `shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(256) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `address` varchar(10000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;