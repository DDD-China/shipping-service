CREATE TABLE `logistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipping_id` int(11) DEFAULT NULL,
  `order_id` varchar(256) DEFAULT NULL,
  `express` varchar(512) DEFAULT NULL,
  `info` varchar(10000) DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;