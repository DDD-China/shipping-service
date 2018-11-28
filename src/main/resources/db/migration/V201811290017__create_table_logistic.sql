CREATE TABLE `logistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipping_id` int(11),
  `order_id` int(11),
  `express` varchar(512),
  `info` varchar(10000),
  `update_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;