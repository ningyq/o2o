/*
 Navicat Premium Data Transfer

 Source Server         : o2o
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 47.94.213.70:3306
 Source Schema         : o2o

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 12/03/2020 07:46:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (1, '面食', '饱腹解馋......哈哈');
INSERT INTO `classify` VALUES (2, '蔬菜', '补充维生素');
INSERT INTO `classify` VALUES (3, '肉类', '丰富的蛋白质和脂肪');
INSERT INTO `classify` VALUES (4, '海鲜', '新鲜美味高大上');
INSERT INTO `classify` VALUES (10, 'a', '3');

-- ----------------------------
-- Table structure for good_set
-- ----------------------------
DROP TABLE IF EXISTS `good_set`;
CREATE TABLE `good_set`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品集ID',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '用户ID',
  `order_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单编号',
  `goods_id` int(20) NULL DEFAULT NULL COMMENT '商品编号',
  `num` int(20) NULL DEFAULT 1 COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`user_id`) USING BTREE,
  INDEX `order`(`order_id`) USING BTREE,
  INDEX `goods`(`goods_id`) USING BTREE,
  CONSTRAINT `goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_set
-- ----------------------------
INSERT INTO `good_set` VALUES (1, NULL, 'zt083', 1, 2);
INSERT INTO `good_set` VALUES (3, NULL, 'sf001', 3, 7);
INSERT INTO `good_set` VALUES (6, NULL, 'sf001', 2, 1);
INSERT INTO `good_set` VALUES (8, NULL, 'sf001', 1, 1);
INSERT INTO `good_set` VALUES (15, NULL, 'dd002', 1, 1);
INSERT INTO `good_set` VALUES (16, NULL, 'dd002', 2, 1);
INSERT INTO `good_set` VALUES (17, NULL, 'dd002', 3, 7);
INSERT INTO `good_set` VALUES (21, 3, NULL, 4, 2);
INSERT INTO `good_set` VALUES (24, NULL, '2,2020-03-10 07:29:59', 6, 2);
INSERT INTO `good_set` VALUES (25, NULL, '2,2020-03-10 07:30:35', 6, 2);
INSERT INTO `good_set` VALUES (26, 2, NULL, 3, 8);
INSERT INTO `good_set` VALUES (27, NULL, '2,2020-03-10 10:40:43', 6, 2);
INSERT INTO `good_set` VALUES (28, NULL, '2,2020-03-10 10:40:43', 3, 1);
INSERT INTO `good_set` VALUES (29, NULL, '2,2020-03-11 11:34:24', 6, 2);
INSERT INTO `good_set` VALUES (30, NULL, '2,2020-03-11 11:34:24', 3, 6);
INSERT INTO `good_set` VALUES (31, 2, NULL, 4, 2);
INSERT INTO `good_set` VALUES (34, NULL, '9,2020-03-11 05:06:06', 3, 4);
INSERT INTO `good_set` VALUES (35, NULL, '9,2020-03-11 05:06:06', 2, 1);
INSERT INTO `good_set` VALUES (63, 9, NULL, 3, 2);
INSERT INTO `good_set` VALUES (64, 9, NULL, 4, 2);
INSERT INTO `good_set` VALUES (65, 9, NULL, 6, 1);
INSERT INTO `good_set` VALUES (72, NULL, '8-20200311115011', 3, 2);
INSERT INTO `good_set` VALUES (73, NULL, '8-20200311115011', 4, 2);
INSERT INTO `good_set` VALUES (74, NULL, '8-20200312122820', 3, 2);
INSERT INTO `good_set` VALUES (75, NULL, '8-20200312122820', 4, 2);
INSERT INTO `good_set` VALUES (77, NULL, '8-20200312122843', 4, 1);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `shops_id` int(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '照片',
  `stock` int(20) NOT NULL COMMENT '库存',
  `description` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '描述',
  `sales_volume` int(20) NULL DEFAULT 0 COMMENT '月销量',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '单位',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `classify_id` int(10) NULL DEFAULT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classify_goods`(`classify_id`) USING BTREE,
  INDEX `shops_goods`(`shops_id`) USING BTREE,
  CONSTRAINT `classify_goods` FOREIGN KEY (`classify_id`) REFERENCES `classify` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shops_goods` FOREIGN KEY (`shops_id`) REFERENCES `shops` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, '娃娃菜', NULL, 25, '今天凌晨刚到的', 69, 'h', 3.50, 1);
INSERT INTO `goods` VALUES (2, 1, '红富士苹果', NULL, 30, '新鲜红润', 200, '斤', 20.00, 2);
INSERT INTO `goods` VALUES (3, 4, '法国蓝龙虾', 'https://hbimg.huabanimg.com/bfc4b7d26d12e24a3c88f49db3045ff492bab03b4e7ff-NCw0Bm_fw658', 300, '现货，满足你的奢侈', 80, '只', 600.00, 1);
INSERT INTO `goods` VALUES (4, 3, '土猪肉', 'https://hbimg.huabanimg.com/df6926639a2166f0d478e5e155532ad6cf52b66ef837-U4ywKW_fw658', 50, '今天刚宰杀的', 800, '斤', 18.50, 3);
INSERT INTO `goods` VALUES (6, 3, '鱼', 'https://hbimg.huabanimg.com/ff298a1b9d11e824d6e5b11dfe8eee6541ec4d7f12301-LvGV2B_fw658', 25, '今天222凌晨刚到的', 600, '斤', 3.50, 3);

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单编号',
  `user_id` int(20) NULL DEFAULT NULL COMMENT '用户ID',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
  `freight` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费',
  `status` int(10) NULL DEFAULT 0 COMMENT '订单状态（-1：已取消；0：已下单；1：配送中；2：配送完成）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_user`(`user_id`) USING BTREE,
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_table
-- ----------------------------
INSERT INTO `order_table` VALUES ('2,2020-03-10 07:29:59', 2, 7.00, '2020-03-10 07:29:59', 8.00, 2);
INSERT INTO `order_table` VALUES ('2,2020-03-10 07:30:35', 2, 7.00, '2020-03-10 07:30:35', 8.00, 1);
INSERT INTO `order_table` VALUES ('2,2020-03-10 10:40:43', 2, 607.00, '2020-03-10 10:40:43', 8.00, 1);
INSERT INTO `order_table` VALUES ('2,2020-03-11 11:34:24', 2, 3607.00, '2020-03-11 11:34:24', 8.00, 1);
INSERT INTO `order_table` VALUES ('8-20200311115011', 8, 1237.00, '2020-03-11 11:50:11', 8.00, 1);
INSERT INTO `order_table` VALUES ('8-20200312122820', 8, 1237.00, '2020-03-12 12:28:20', 8.00, 1);
INSERT INTO `order_table` VALUES ('8-20200312122843', 8, 18.50, '2020-03-12 12:28:43', 8.00, 1);
INSERT INTO `order_table` VALUES ('9,2020-03-11 05:06:06', 9, 2420.00, '2020-03-11 05:06:06', 8.00, 1);
INSERT INTO `order_table` VALUES ('dd002', 3, 23.50, '2020-03-05 22:01:12', 8.00, 0);
INSERT INTO `order_table` VALUES ('sf001', 2, 23.50, '2020-02-21 13:51:44', 8.00, -1);
INSERT INTO `order_table` VALUES ('zt066', 5, 2400.00, '2019-11-27 13:54:16', 18.00, 2);
INSERT INTO `order_table` VALUES ('zt083', 4, 155.60, '2020-01-23 13:53:16', 6.00, -1);

-- ----------------------------
-- Table structure for shops
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商铺ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商铺名',
  `freight` decimal(20, 2) NULL DEFAULT NULL COMMENT '店铺运费',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商铺描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shops
-- ----------------------------
INSERT INTO `shops` VALUES (1, '立明果蔬', 0.00, '新鲜100分');
INSERT INTO `shops` VALUES (3, '老王肉铺', 1.00, '良心，放心');
INSERT INTO `shops` VALUES (4, '老九海鲜', 2.00, NULL);
INSERT INTO `shops` VALUES (5, '陕西农贸', 3.00, '不新鲜不要钱');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `roles` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT 'ROLE_user' COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$uXr.KqjjRXUtUkSdzv4GDetJhkc.BOgz9YiHHGd7SD3.7xqaWrr6K', 'ROLE_admin;ROLE_user');
INSERT INTO `user` VALUES (2, '张小花', '$2a$10$gQ/eGC3LZoyYEYe2uYAqk.8ZeeSK97wk/XzmpjtRaZIZKt68wRw82', 'ROLE_user');
INSERT INTO `user` VALUES (3, '王小华', '$2a$10$HlpZJb3GAgwqAvKZfnstxOZkeoernMz971ji3UQnV6hO7iEL5Zf.y', 'ROLE_user');
INSERT INTO `user` VALUES (4, 'abcdefg', '$2a$10$CMnb1XvduI0cD7UEBqtqieCe/BgVt8U.w2dtYPJAd/n6hpqeS.bCm', 'ROLE_user');
INSERT INTO `user` VALUES (5, '67dasu_abc', '$2a$10$HKB3W0S3l4KZxq0ajbRrAeT3sLaMnsrei1DI7xRqrH1aDNRTSxmkm', 'ROLE_user');
INSERT INTO `user` VALUES (7, 'dfghryj', '$2a$10$/MI6O5yDLgRUd0yfEmwDCOvDVsj7nrIUBeCQH0uK5wI9oO5OsbtvS', 'ROLE_user');
INSERT INTO `user` VALUES (8, 'ningyinqiang', '$2a$10$q.t7htzfL.2CWgeAfbQUEOjpiyqbvsgDQ5v03239MJSdwYhjpHfTG', 'ROLE_user');
INSERT INTO `user` VALUES (9, 'fengrong', '$2a$10$yMnc8UXmwengC9g8MiXVRONk.g/q94w6owRuh4yA8sX5TdfFeEnuS', 'ROLE_user');
INSERT INTO `user` VALUES (12, 'nyq', '$2a$10$cGr7M1xRXt50wkx9Trc9jO0O8hWjlCy3vRUK0Z4eA9oijXX5SQCH2', 'ROLE_user');
INSERT INTO `user` VALUES (13, 'xiaofeng', '$2a$10$yMnc8UXmwengC9g8MiXVRONk.g/q94w6owRuh4yA8sX5TdfFeEnuS', 'ROLE_admin;ROLE_user');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户信息ID',
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户真实姓名（收货姓名）',
  `sex` tinyint(2) NULL DEFAULT NULL COMMENT '用户性别',
  `birthday` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户生日',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '王小华', '张少华', 1, '1985年6月5日', '13456998745', '北京');
INSERT INTO `user_info` VALUES (2, '张小花', '张', 0, '1993-03-08', '18879465343', '河南');
INSERT INTO `user_info` VALUES (3, 'abcdefg', '何源', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, '67dasu_abc', '李自成', 1, '2005年1月13日', NULL, '江苏');
INSERT INTO `user_info` VALUES (7, 'ningyinqiang', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (8, 'fengrong', '小冯', 0, '1997-10-05', '11111111111', '陕西');
INSERT INTO `user_info` VALUES (11, 'nyq', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (12, 'xiaofeng', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
