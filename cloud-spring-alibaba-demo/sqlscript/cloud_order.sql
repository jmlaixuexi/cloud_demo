CREATE TABLE `tb_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `name` varchar(200) default '',
  `price` bigint DEFAULT NULL,
  `num` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cloud-order`.tb_order
(user_id, name, price, num)
VALUES(1, '华为智选 Hi nova 9 SE 一亿像素超清摄影 66W极速快充 5G双模全网通hinova 8GB+128GB亮黑色5G手机', 1899, 1);
INSERT INTO `cloud-order`.tb_order
(user_id, name, price, num)
VALUES(2, '良品铺子 草莓脆 冻干草莓干水果干零食办公室小吃休闲食品20g', 10, 1);
INSERT INTO `cloud-order`.tb_order
(user_id, name, price, num)
VALUES(3, '老板（Robam）领航家D1S欧式顶吸式抽油烟机双腔变频静音吸油烟机 大吸力22m³/min排油烟机家用挥手智控60D1S', 2769, 1);
INSERT INTO `cloud-order`.tb_order
(user_id, name, price, num)
VALUES(4, 'LEGO乐高积木 机械组 42096保时捷RSR赛车10岁+男女孩玩拼儿童插具成人生日礼物汽车模型', 969, 1);
INSERT INTO `cloud-order`.tb_order
(user_id, name, price, num)
VALUES(5, '中伟 ZHONGWEI 北欧餐椅实木会议椅办公椅电脑椅咖啡厅休闲椅牛角椅', 566, 10);
