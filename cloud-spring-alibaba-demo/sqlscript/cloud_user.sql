CREATE TABLE `tb_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT '',
  `address` varchar(400) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cloud-user`.tb_user
(username, address)
VALUES('张三', '深圳宝安区石岩街道应人石社区福景新村菜鸟驿站');
INSERT INTO `cloud-user`.tb_user
(username, address)
VALUES('王五', '深圳宝安区石岩街道应人石社区应人石新村菜鸟驿站');
INSERT INTO `cloud-user`.tb_user
(username, address)
VALUES('李四', '深圳宝安区石岩街道应人石社区应人石老村菜鸟驿站');

