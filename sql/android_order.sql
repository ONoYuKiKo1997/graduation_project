/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : android_order

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2020-05-17 14:21:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_id` int(11) NOT NULL,
  `d_name` varchar(50) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_nickname` varchar(50) NOT NULL,
  `c_content` varchar(200) NOT NULL,
  `c_date` date NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '0', '红烧排骨', '1', '张三', '好好', '2020-05-10');
INSERT INTO `comment` VALUES ('2', '0', '红烧鱼', '1', '张三', '不错', '2020-05-10');
INSERT INTO `comment` VALUES ('3', '2', '红烧排骨', '1', '张三', '咖喱', '2020-05-10');
INSERT INTO `comment` VALUES ('4', '6', '红烧鱼', '1', '张三', '米饭', '2020-05-10');
INSERT INTO `comment` VALUES ('5', '2', '红烧排骨', '1', '张三', '好', '2020-05-10');

-- ----------------------------
-- Table structure for `detail_order`
-- ----------------------------
DROP TABLE IF EXISTS `detail_order`;
CREATE TABLE `detail_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` varchar(50) NOT NULL,
  `d_id` int(11) NOT NULL,
  `d_name` varchar(50) NOT NULL,
  `d_price` int(11) NOT NULL,
  `d_count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail_order
-- ----------------------------
INSERT INTO `detail_order` VALUES ('5', '20200510073125', '4', '糖醋排骨', '53', '2');
INSERT INTO `detail_order` VALUES ('6', '20200510073125', '5', '水煮鱼', '41', '2');
INSERT INTO `detail_order` VALUES ('7', '20200510080315', '3', '可乐鸡翅', '44', '3');
INSERT INTO `detail_order` VALUES ('8', '20200510080315', '4', '糖醋排骨', '53', '2');
INSERT INTO `detail_order` VALUES ('9', '20200510080315', '5', '水煮鱼', '41', '2');
INSERT INTO `detail_order` VALUES ('10', '20200510080315', '6', '红烧鱼', '26', '2');
INSERT INTO `detail_order` VALUES ('11', '20200510080441', '2', '红烧排骨', '42', '2');
INSERT INTO `detail_order` VALUES ('12', '20200510141608', '1', '红烧肉', '29', '2');
INSERT INTO `detail_order` VALUES ('13', '20200510141608', '2', '红烧排骨', '42', '2');
INSERT INTO `detail_order` VALUES ('14', '20200510165950', '5', '水煮鱼', '41', '2');

-- ----------------------------
-- Table structure for `dishes`
-- ----------------------------
DROP TABLE IF EXISTS `dishes`;
CREATE TABLE `dishes` (
  `d_id` int(10) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(50) NOT NULL,
  `d_hunsu` varchar(10) NOT NULL,
  `d_taste` varchar(10) NOT NULL,
  `d_price` int(10) NOT NULL,
  `d_img` varchar(100) NOT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishes
-- ----------------------------
INSERT INTO `dishes` VALUES ('1', '红烧肉', '荤菜', '家常味', '29', 'images/1.jpg');
INSERT INTO `dishes` VALUES ('2', '红烧排骨', '荤菜', '家常味', '42', 'images/2.jpg');
INSERT INTO `dishes` VALUES ('3', '可乐鸡翅', '荤菜', '酸甜味', '44', 'images/3.jpg');
INSERT INTO `dishes` VALUES ('4', '糖醋排骨', '荤菜', '酸甜味', '53', 'images/4.jpg');
INSERT INTO `dishes` VALUES ('5', '水煮鱼', '荤菜', '麻辣味', '41', 'images/5.jpg');
INSERT INTO `dishes` VALUES ('6', '红烧鱼', '荤菜', '咸鲜味', '26', 'images/6.jpg');
INSERT INTO `dishes` VALUES ('7', '鱼香肉丝', '荤菜', '咸鲜味', '45', 'images/7.jpg');
INSERT INTO `dishes` VALUES ('8', '水煮肉片', '荤菜', '麻辣味', '41', 'images/8.jpg');
INSERT INTO `dishes` VALUES ('9', '意大利面', '荤菜', '麻辣味', '51', 'images/9.jpg');
INSERT INTO `dishes` VALUES ('10', '麻辣小龙虾', '荤菜', '麻辣味', '29', 'images/10.jpg');
INSERT INTO `dishes` VALUES ('11', '龙井虾仁', '荤菜', '咸鲜味', '37', 'images/11.jpg');
INSERT INTO `dishes` VALUES ('12', '口水鸡', '荤菜', '麻辣味', '19', 'images/12.jpg');
INSERT INTO `dishes` VALUES ('13', '回锅肉', '荤菜', '麻辣味', '16', 'images/13.jpg');
INSERT INTO `dishes` VALUES ('14', '红烧猪蹄', '荤菜', '咸鲜味', '38', 'images/14.jpg');
INSERT INTO `dishes` VALUES ('15', '皮蛋瘦肉粥', '荤菜', '咸鲜味', '43', 'images/15.jpg');
INSERT INTO `dishes` VALUES ('16', '酸菜鱼', '荤菜', '酸甜味', '40', 'images/16.jpg');
INSERT INTO `dishes` VALUES ('17', '咖喱牛肉', '荤菜', '麻辣味', '35', 'images/17.jpg');
INSERT INTO `dishes` VALUES ('18', '牛肉酱', '荤菜', '家常味', '21', 'images/18.jpg');
INSERT INTO `dishes` VALUES ('19', '腊肉', '荤菜', '咸鲜味', '51', 'images/19.jpg');
INSERT INTO `dishes` VALUES ('20', '啤酒鸭', '荤菜', '咸鲜味', '44', 'images/20.jpg');
INSERT INTO `dishes` VALUES ('21', '宫保鸡丁', '荤菜', '咸鲜味', '59', 'images/21.jpg');
INSERT INTO `dishes` VALUES ('22', '手撕包菜', '荤菜', '麻辣味', '34', 'images/22.jpg');
INSERT INTO `dishes` VALUES ('23', '剁椒鱼头', '荤菜', '麻辣味', '39', 'images/23.jpg');
INSERT INTO `dishes` VALUES ('24', '粉蒸肉', '荤菜', '咸鲜味', '24', 'images/24.jpg');
INSERT INTO `dishes` VALUES ('25', '锅包肉', '荤菜', '酸甜味', '50', 'images/25.jpg');
INSERT INTO `dishes` VALUES ('26', '红烧牛肉', '荤菜', '家常味', '39', 'images/26.jpg');
INSERT INTO `dishes` VALUES ('27', '辣子鸡', '荤菜', '麻辣味', '45', 'images/27.jpg');
INSERT INTO `dishes` VALUES ('28', '牛肉炖土豆', '荤菜', '咸鲜味', '46', 'images/28.jpg');
INSERT INTO `dishes` VALUES ('29', '糖醋鲤鱼', '荤菜', '酸甜味', '25', 'images/29.jpg');
INSERT INTO `dishes` VALUES ('30', '炖排骨', '荤菜', '咸鲜味', '59', 'images/30.jpg');
INSERT INTO `dishes` VALUES ('31', '木须肉', '荤菜', '咸鲜味', '49', 'images/31.jpg');
INSERT INTO `dishes` VALUES ('32', '香辣虾', '荤菜', '麻辣味', '16', 'images/32.jpg');
INSERT INTO `dishes` VALUES ('33', '红烧狮子头', '荤菜', '咸鲜味', '55', 'images/33.jpg');
INSERT INTO `dishes` VALUES ('34', '小鸡炖蘑菇', '荤菜', '咸鲜味', '31', 'images/34.jpg');
INSERT INTO `dishes` VALUES ('35', '糖醋里脊', '荤菜', '酸甜味', '52', 'images/35.jpg');
INSERT INTO `dishes` VALUES ('36', '板栗烧鸡', '荤菜', '咸鲜味', '43', 'images/36.jpg');
INSERT INTO `dishes` VALUES ('37', '糖醋鱼', '荤菜', '酸甜味', '59', 'images/37.jpg');
INSERT INTO `dishes` VALUES ('38', '肉丸', '荤菜', '咸鲜味', '43', 'images/38.jpg');
INSERT INTO `dishes` VALUES ('39', '梅菜扣肉', '荤菜', '家常味', '60', 'images/39.jpg');
INSERT INTO `dishes` VALUES ('40', '京酱肉丝', '荤菜', '家常味', '33', 'images/40.jpg');
INSERT INTO `dishes` VALUES ('41', '红烧带鱼', '荤菜', '家常味', '45', 'images/41.jpg');
INSERT INTO `dishes` VALUES ('42', '大盘鸡', '荤菜', '麻辣味', '52', 'images/42.jpg');
INSERT INTO `dishes` VALUES ('43', '红烧鸡翅', '荤菜', '酸甜味', '25', 'images/43.jpg');
INSERT INTO `dishes` VALUES ('44', '香辣蟹', '荤菜', '麻辣味', '16', 'images/44.jpg');
INSERT INTO `dishes` VALUES ('45', '东坡肉', '荤菜', '咸鲜味', '24', 'images/45.jpg');
INSERT INTO `dishes` VALUES ('46', '鲫鱼豆腐汤', '荤菜', '咸鲜味', '22', 'images/46.jpg');
INSERT INTO `dishes` VALUES ('47', '鲫鱼汤', '荤菜', '咸鲜味', '50', 'images/47.jpg');
INSERT INTO `dishes` VALUES ('48', '鸡汤', '荤菜', '咸鲜味', '19', 'images/48.jpg');
INSERT INTO `dishes` VALUES ('49', '乌鸡汤', '荤菜', '咸鲜味', '23', 'images/49.jpg');
INSERT INTO `dishes` VALUES ('50', '鸽子汤', '荤菜', '咸鲜味', '31', 'images/50.jpg');
INSERT INTO `dishes` VALUES ('51', '清蒸大闸蟹', '荤菜', '咸鲜味', '48', 'images/51.jpg');
INSERT INTO `dishes` VALUES ('52', '清蒸鲈鱼', '荤菜', '咸鲜味', '43', 'images/52.jpg');
INSERT INTO `dishes` VALUES ('53', '孜然羊肉', '荤菜', '咸鲜味', '37', 'images/53.jpg');
INSERT INTO `dishes` VALUES ('54', '西红柿炖牛腩', '荤菜', '酸甜味', '31', 'images/54.jpg');
INSERT INTO `dishes` VALUES ('55', '山药炖鸡', '荤菜', '家常味', '43', 'images/55.jpg');
INSERT INTO `dishes` VALUES ('56', '排骨汤', '荤菜', '咸鲜味', '38', 'images/56.jpg');
INSERT INTO `dishes` VALUES ('57', '烤鱼', '荤菜', '麻辣味', '48', 'images/57.jpg');
INSERT INTO `dishes` VALUES ('58', '毛血旺', '荤菜', '麻辣味', '42', 'images/58.jpg');
INSERT INTO `dishes` VALUES ('59', '泡椒凤爪', '荤菜', '麻辣味', '27', 'images/59.jpg');
INSERT INTO `dishes` VALUES ('60', '酱牛肉', '荤菜', '家常味', '55', 'images/60.jpg');
INSERT INTO `dishes` VALUES ('61', '辣子鸡丁', '荤菜', '麻辣味', '42', 'images/61.jpg');
INSERT INTO `dishes` VALUES ('62', '咖喱鸡', '荤菜', '麻辣味', '41', 'images/62.jpg');
INSERT INTO `dishes` VALUES ('63', '椒盐虾', '荤菜', '咸鲜味', '28', 'images/63.jpg');
INSERT INTO `dishes` VALUES ('64', '家常豆腐', '素菜', '家常味', '44', 'images/64.jpg');
INSERT INTO `dishes` VALUES ('65', '熘肝尖', '荤菜', '咸鲜味', '38', 'images/65.jpg');
INSERT INTO `dishes` VALUES ('66', '红焖羊肉', '荤菜', '咸鲜味', '21', 'images/66.jpg');
INSERT INTO `dishes` VALUES ('67', '葱爆羊肉', '荤菜', '咸鲜味', '41', 'images/67.jpg');
INSERT INTO `dishes` VALUES ('68', '油焖大虾', '荤菜', '咸鲜味', '30', 'images/68.jpg');
INSERT INTO `dishes` VALUES ('69', '三杯鸡', '荤菜', '咸鲜味', '40', 'images/69.jpg');
INSERT INTO `dishes` VALUES ('70', '苦瓜炒肉片', '荤菜', '咸鲜味', '40', 'images/70.jpg');
INSERT INTO `dishes` VALUES ('71', '宫保虾球', '荤菜', '家常味', '38', 'images/71.jpg');
INSERT INTO `dishes` VALUES ('72', '苦瓜酿肉', '荤菜', '咸鲜味', '25', 'images/72.jpg');
INSERT INTO `dishes` VALUES ('73', '蚂蚁上树', '荤菜', '咸鲜味', '38', 'images/73.jpg');
INSERT INTO `dishes` VALUES ('74', '盐水鸭', '荤菜', '咸鲜味', '28', 'images/74.jpg');
INSERT INTO `dishes` VALUES ('75', '麻辣鸭脖', '荤菜', '麻辣味', '58', 'images/75.jpg');
INSERT INTO `dishes` VALUES ('76', '油泼鱼', '荤菜', '咸鲜味', '15', 'images/76.jpg');
INSERT INTO `dishes` VALUES ('77', '西湖牛肉羹', '荤菜', '咸鲜味', '41', 'images/77.jpg');
INSERT INTO `dishes` VALUES ('78', '剁椒鸡丁毛豆子', '荤菜', '麻辣味', '29', 'images/78.jpg');
INSERT INTO `dishes` VALUES ('79', '上校鸡块', '荤菜', '酸甜味', '51', 'images/79.jpg');
INSERT INTO `dishes` VALUES ('80', '红烧鸡爪', '荤菜', '咸鲜味', '57', 'images/80.jpg');
INSERT INTO `dishes` VALUES ('81', '牛肉干', '荤菜', '麻辣味', '52', 'images/81.jpg');
INSERT INTO `dishes` VALUES ('82', '肉末酸豆角', '荤菜', '麻辣味', '49', 'images/82.jpg');
INSERT INTO `dishes` VALUES ('83', '蛤蜊蒸蛋', '荤菜', '家常味', '50', 'images/83.jpg');
INSERT INTO `dishes` VALUES ('84', '叫花鸡', '荤菜', '咸鲜味', '55', 'images/84.jpg');
INSERT INTO `dishes` VALUES ('85', '盐焗鸡', '荤菜', '咸鲜味', '44', 'images/85.jpg');
INSERT INTO `dishes` VALUES ('86', '鸭血粉丝汤', '荤菜', '咸鲜味', '51', 'images/86.jpg');
INSERT INTO `dishes` VALUES ('87', '棒棒鸡', '荤菜', '家常味', '28', 'images/87.jpg');
INSERT INTO `dishes` VALUES ('88', '水晶虾饺', '荤菜', '咸鲜味', '50', 'images/88.jpg');
INSERT INTO `dishes` VALUES ('89', '茄汁带鱼', '荤菜', '酸甜味', '49', 'images/89.jpg');
INSERT INTO `dishes` VALUES ('90', '荷叶粉蒸肉', '荤菜', '咸鲜味', '49', 'images/90.jpg');
INSERT INTO `dishes` VALUES ('91', '爆炒腰花', '荤菜', '家常味', '17', 'images/91.jpg');
INSERT INTO `dishes` VALUES ('92', '蒜薹炒肉', '荤菜', '咸鲜味', '16', 'images/92.jpg');
INSERT INTO `dishes` VALUES ('93', '腐乳烧鸡翅', '荤菜', '咸鲜味', '52', 'images/93.jpg');
INSERT INTO `dishes` VALUES ('94', '木耳炒肉', '荤菜', '家常味', '47', 'images/94.jpg');
INSERT INTO `dishes` VALUES ('95', '照烧鸡', '荤菜', '家常味', '19', 'images/95.jpg');
INSERT INTO `dishes` VALUES ('96', '奥尔良烤翅', '荤菜', '家常味', '39', 'images/96.jpg');
INSERT INTO `dishes` VALUES ('97', '赛肘花', '荤菜', '咸鲜味', '36', 'images/97.jpg');
INSERT INTO `dishes` VALUES ('98', '虎皮凤爪', '荤菜', '家常味', '15', 'images/98.jpg');
INSERT INTO `dishes` VALUES ('99', '香辣烤鱼', '荤菜', '麻辣味', '36', 'images/99.jpg');
INSERT INTO `dishes` VALUES ('100', '把子肉', '荤菜', '家常味', '36', 'images/100.jpg');
INSERT INTO `dishes` VALUES ('101', '铁板鱿鱼', '荤菜', '麻辣味', '17', 'images/101.jpg');
INSERT INTO `dishes` VALUES ('102', '芝心虾球', '荤菜', '咸鲜味', '54', 'images/102.jpg');
INSERT INTO `dishes` VALUES ('103', '白灼虾', '荤菜', '咸鲜味', '30', 'images/103.jpg');
INSERT INTO `dishes` VALUES ('104', '农家小炒肉', '荤菜', '麻辣味', '44', 'images/104.jpg');
INSERT INTO `dishes` VALUES ('105', '松鼠鱼', '荤菜', '酸甜味', '21', 'images/105.jpg');
INSERT INTO `dishes` VALUES ('106', '叉烧肉', '荤菜', '家常味', '38', 'images/106.jpg');
INSERT INTO `dishes` VALUES ('107', '肉皮冻', '荤菜', '咸鲜味', '56', 'images/107.jpg');
INSERT INTO `dishes` VALUES ('108', '咖喱牛腩', '荤菜', '麻辣味', '39', 'images/108.jpg');
INSERT INTO `dishes` VALUES ('109', '白灼菜心', '素菜', '酸甜味', '26', 'images/109.jpg');
INSERT INTO `dishes` VALUES ('110', '麻辣肉片', '荤菜', '麻辣味', '21', 'images/110.jpg');
INSERT INTO `dishes` VALUES ('111', '糟溜鱼片', '荤菜', '咸鲜味', '34', 'images/111.jpg');
INSERT INTO `dishes` VALUES ('112', '韭菜炒鱿鱼', '荤菜', '咸鲜味', '45', 'images/112.jpg');
INSERT INTO `dishes` VALUES ('113', '九转大肠', '荤菜', '咸鲜味', '17', 'images/113.jpg');
INSERT INTO `dishes` VALUES ('114', '东北乱炖', '荤菜', '咸鲜味', '47', 'images/114.jpg');
INSERT INTO `dishes` VALUES ('115', '葱烧海参', '荤菜', '咸鲜味', '34', 'images/115.jpg');
INSERT INTO `dishes` VALUES ('116', '清蒸武昌鱼', '荤菜', '咸鲜味', '17', 'images/116.jpg');
INSERT INTO `dishes` VALUES ('117', '蒜泥白肉', '荤菜', '咸鲜味', '17', 'images/117.jpg');
INSERT INTO `dishes` VALUES ('118', '腊味合蒸', '荤菜', '咸鲜味', '25', 'images/118.jpg');
INSERT INTO `dishes` VALUES ('119', '四喜丸子', '荤菜', '咸鲜味', '49', 'images/119.jpg');
INSERT INTO `dishes` VALUES ('120', '赛螃蟹', '素菜', '咸鲜味', '45', 'images/120.jpg');
INSERT INTO `dishes` VALUES ('121', '盐水虾', '荤菜', '咸鲜味', '27', 'images/121.jpg');
INSERT INTO `dishes` VALUES ('122', '肉片炒青椒', '荤菜', '家常味', '51', 'images/122.jpg');
INSERT INTO `dishes` VALUES ('123', '卤牛肉', '荤菜', '咸鲜味', '21', 'images/123.jpg');
INSERT INTO `dishes` VALUES ('124', '酱爆鸡丁', '荤菜', '家常味', '22', 'images/124.jpg');
INSERT INTO `dishes` VALUES ('125', '青椒炒肉丝', '荤菜', '咸鲜味', '54', 'images/125.jpg');
INSERT INTO `dishes` VALUES ('126', '粉蒸排骨', '荤菜', '咸鲜味', '15', 'images/126.jpg');
INSERT INTO `dishes` VALUES ('127', '香芹炒肉片', '荤菜', '家常味', '25', 'images/127.jpg');
INSERT INTO `dishes` VALUES ('128', '腊肉炒芹菜', '荤菜', '麻辣味', '26', 'images/128.jpg');
INSERT INTO `dishes` VALUES ('129', '凉拌鸡丝莴笋', '荤菜', '咸鲜味', '41', 'images/129.jpg');
INSERT INTO `dishes` VALUES ('130', '凉拌莴笋丝', '素菜', '咸鲜味', '16', 'images/130.jpg');
INSERT INTO `dishes` VALUES ('131', '莴笋炒肉片', '荤菜', '咸鲜味', '33', 'images/131.jpg');
INSERT INTO `dishes` VALUES ('132', '炝炒莴笋', '素菜', '麻辣味', '50', 'images/132.jpg');
INSERT INTO `dishes` VALUES ('133', '凉拌三丝', '荤菜', '咸鲜味', '39', 'images/133.jpg');
INSERT INTO `dishes` VALUES ('134', '水晶虾仁', '荤菜', '咸鲜味', '22', 'images/134.jpg');
INSERT INTO `dishes` VALUES ('135', '椒盐虾仁', '荤菜', '麻辣味', '36', 'images/135.jpg');
INSERT INTO `dishes` VALUES ('136', '番茄虾仁', '荤菜', '酸甜味', '51', 'images/136.jpg');
INSERT INTO `dishes` VALUES ('137', '鲜虾莴笋片', '荤菜', '咸鲜味', '24', 'images/137.jpg');
INSERT INTO `dishes` VALUES ('138', '虾皮韭菜烧豆腐', '素菜', '咸鲜味', '31', 'images/138.jpg');
INSERT INTO `dishes` VALUES ('139', '鸡蛋炒虾仁', '荤菜', '咸鲜味', '22', 'images/139.jpg');
INSERT INTO `dishes` VALUES ('140', '玉子虾仁', '荤菜', '咸鲜味', '56', 'images/140.jpg');
INSERT INTO `dishes` VALUES ('141', '春笋虾丝', '荤菜', '咸鲜味', '49', 'images/141.jpg');
INSERT INTO `dishes` VALUES ('142', '酥皮薯泥起司虾', '荤菜', '咸鲜味', '30', 'images/142.jpg');
INSERT INTO `dishes` VALUES ('143', '芦笋炒虾仁', '荤菜', '家常味', '32', 'images/143.jpg');
INSERT INTO `dishes` VALUES ('144', '软炸虾仁', '荤菜', '家常味', '54', 'images/144.jpg');
INSERT INTO `dishes` VALUES ('145', '炸虾片', '素菜', '家常味', '35', 'images/145.jpg');
INSERT INTO `dishes` VALUES ('146', '抓炒虾片', '荤菜', '咸鲜味', '29', 'images/146.jpg');
INSERT INTO `dishes` VALUES ('147', '油焖大虾', '荤菜', '家常味', '32', 'images/147.jpg');
INSERT INTO `dishes` VALUES ('148', '炸虾', '荤菜', '咸鲜味', '29', 'images/148.jpg');
INSERT INTO `dishes` VALUES ('149', '葱油鲫鱼', '荤菜', '咸鲜味', '46', 'images/149.jpg');
INSERT INTO `dishes` VALUES ('150', '香辣鱼片', '荤菜', '麻辣味', '27', 'images/150.jpg');
INSERT INTO `dishes` VALUES ('151', '红烧白鲢鱼', '荤菜', '家常味', '29', 'images/151.jpg');
INSERT INTO `dishes` VALUES ('152', '龙凤炒饭', '荤菜', '咸鲜味', '45', 'images/152.jpg');
INSERT INTO `dishes` VALUES ('153', '酥焖鲫鱼', '荤菜', '酸甜味', '40', 'images/153.jpg');
INSERT INTO `dishes` VALUES ('154', '酥小鲫鱼', '荤菜', '咸鲜味', '27', 'images/154.jpg');
INSERT INTO `dishes` VALUES ('155', '水晶鱼肉丝', '荤菜', '家常味', '41', 'images/155.jpg');
INSERT INTO `dishes` VALUES ('156', '炸酥鱼', '荤菜', '咸鲜味', '38', 'images/156.jpg');
INSERT INTO `dishes` VALUES ('157', '鲢鱼饼', '荤菜', '咸鲜味', '49', 'images/157.jpg');
INSERT INTO `dishes` VALUES ('158', '凉拌海蜇皮', '荤菜', '咸鲜味', '34', 'images/158.jpg');
INSERT INTO `dishes` VALUES ('159', '玛瑙海参', '荤菜', '咸鲜味', '20', 'images/159.jpg');
INSERT INTO `dishes` VALUES ('160', '鸡蛋卷', '素菜', '咸鲜味', '16', 'images/160.jpg');
INSERT INTO `dishes` VALUES ('161', '榨菜炒肉丝', '荤菜', '家常味', '26', 'images/161.jpg');
INSERT INTO `dishes` VALUES ('162', '素炒三丝', '素菜', '家常味', '36', 'images/162.jpg');
INSERT INTO `dishes` VALUES ('163', '肉炒土豆丝', '荤菜', '家常味', '21', 'images/163.jpg');
INSERT INTO `dishes` VALUES ('164', '辣炒菜丝', '素菜', '麻辣味', '16', 'images/164.jpg');
INSERT INTO `dishes` VALUES ('165', '蒜香肉片', '荤菜', '咸鲜味', '43', 'images/165.jpg');
INSERT INTO `dishes` VALUES ('166', '炒肉片青椒', '荤菜', '家常味', '31', 'images/166.jpg');
INSERT INTO `dishes` VALUES ('167', '虾仁薯饼', '荤菜', '咸鲜味', '52', 'images/167.jpg');
INSERT INTO `dishes` VALUES ('168', '炒虾仁黄瓜', '荤菜', '咸鲜味', '40', 'images/168.jpg');
INSERT INTO `dishes` VALUES ('169', '土豆泥虾球', '荤菜', '家常味', '57', 'images/169.jpg');
INSERT INTO `dishes` VALUES ('170', '炒肉片菜花', '荤菜', '家常味', '44', 'images/170.jpg');
INSERT INTO `dishes` VALUES ('171', '炒肉片莴苣', '荤菜', '咸鲜味', '53', 'images/171.jpg');
INSERT INTO `dishes` VALUES ('172', '炒肉丝豆角', '荤菜', '麻辣味', '41', 'images/172.jpg');
INSERT INTO `dishes` VALUES ('173', '炒合菜', '荤菜', '家常味', '33', 'images/173.jpg');
INSERT INTO `dishes` VALUES ('174', '儿菜炒肉片', '荤菜', '家常味', '32', 'images/174.jpg');
INSERT INTO `dishes` VALUES ('175', '菠菜羊肉', '荤菜', '咸鲜味', '35', 'images/175.jpg');
INSERT INTO `dishes` VALUES ('176', '炒肉片黄瓜', '荤菜', '咸鲜味', '30', 'images/176.jpg');
INSERT INTO `dishes` VALUES ('177', '炒肉片山药', '荤菜', '家常味', '45', 'images/177.jpg');
INSERT INTO `dishes` VALUES ('178', '酱炒三丝', '素菜', '家常味', '30', 'images/178.jpg');
INSERT INTO `dishes` VALUES ('179', '番茄肉片', '荤菜', '酸甜味', '32', 'images/179.jpg');
INSERT INTO `dishes` VALUES ('180', '炒菠萝鸡片', '荤菜', '咸鲜味', '21', 'images/180.jpg');
INSERT INTO `dishes` VALUES ('181', '炒腰片菜心', '荤菜', '家常味', '26', 'images/181.jpg');
INSERT INTO `dishes` VALUES ('182', '韭菜炒猪肝', '荤菜', '咸鲜味', '55', 'images/182.jpg');
INSERT INTO `dishes` VALUES ('183', '肉片独豆腐', '荤菜', '家常味', '49', 'images/183.jpg');
INSERT INTO `dishes` VALUES ('184', '肉丁烩豆腐', '荤菜', '家常味', '52', 'images/184.jpg');
INSERT INTO `dishes` VALUES ('185', '虾仁炒豆腐', '荤菜', '咸鲜味', '53', 'images/185.jpg');
INSERT INTO `dishes` VALUES ('186', '虾籽烩豆腐', '荤菜', '咸鲜味', '35', 'images/186.jpg');
INSERT INTO `dishes` VALUES ('187', '海米炖豆腐', '荤菜', '家常味', '36', 'images/187.jpg');
INSERT INTO `dishes` VALUES ('188', '黄焖牛肉', '荤菜', '家常味', '53', 'images/188.jpg');
INSERT INTO `dishes` VALUES ('189', '肉焖薯块', '荤菜', '家常味', '35', 'images/189.jpg');
INSERT INTO `dishes` VALUES ('190', '酸辣鸡杂', '荤菜', '麻辣味', '47', 'images/190.jpg');
INSERT INTO `dishes` VALUES ('191', '鸡刨豆腐', '荤菜', '家常味', '31', 'images/191.jpg');
INSERT INTO `dishes` VALUES ('192', '虾仁烧豆腐', '荤菜', '咸鲜味', '20', 'images/192.jpg');
INSERT INTO `dishes` VALUES ('193', '虾籽烧豆腐', '荤菜', '麻辣味', '31', 'images/193.jpg');
INSERT INTO `dishes` VALUES ('194', '肉片烧豆腐', '荤菜', '咸鲜味', '36', 'images/194.jpg');
INSERT INTO `dishes` VALUES ('195', '鸡丁烧豆腐', '荤菜', '家常味', '35', 'images/195.jpg');
INSERT INTO `dishes` VALUES ('196', '肉片独面筋', '荤菜', '咸鲜味', '56', 'images/196.jpg');
INSERT INTO `dishes` VALUES ('197', '虾仁独面筋', '荤菜', '咸鲜味', '37', 'images/197.jpg');
INSERT INTO `dishes` VALUES ('198', '虾籽独面筋', '荤菜', '咸鲜味', '47', 'images/198.jpg');
INSERT INTO `dishes` VALUES ('199', '面筋烧鸡块', '荤菜', '家常味', '26', 'images/199.jpg');
INSERT INTO `dishes` VALUES ('200', '炒荤素丝', '荤菜', '咸鲜味', '20', 'images/200.jpg');
INSERT INTO `dishes` VALUES ('201', '咖喱双条', '荤菜', '麻辣味', '33', 'images/201.jpg');
INSERT INTO `dishes` VALUES ('202', '炝荤素全丁', '荤菜', '家常味', '19', 'images/202.jpg');
INSERT INTO `dishes` VALUES ('203', '烧汁素鸡', '素菜', '咸鲜味', '25', 'images/203.jpg');
INSERT INTO `dishes` VALUES ('204', '辣烧鲤鱼', '荤菜', '麻辣味', '38', 'images/204.jpg');
INSERT INTO `dishes` VALUES ('205', '黄焖牛肉西红柿', '荤菜', '酸甜味', '44', 'images/205.jpg');
INSERT INTO `dishes` VALUES ('206', '肉片焖豆角', '荤菜', '家常味', '21', 'images/206.jpg');
INSERT INTO `dishes` VALUES ('207', '海米菜花', '荤菜', '咸鲜味', '46', 'images/207.jpg');
INSERT INTO `dishes` VALUES ('208', '肉片炒卷心菜', '荤菜', '咸鲜味', '46', 'images/208.jpg');
INSERT INTO `dishes` VALUES ('209', '韭菜丸子', '素菜', '家常味', '58', 'images/209.jpg');
INSERT INTO `dishes` VALUES ('210', '氽冬瓜丸子', '荤菜', '咸鲜味', '39', 'images/210.jpg');
INSERT INTO `dishes` VALUES ('211', '南煎丸子', '荤菜', '咸鲜味', '49', 'images/211.jpg');
INSERT INTO `dishes` VALUES ('212', '四喜丸子', '荤菜', '咸鲜味', '59', 'images/212.jpg');
INSERT INTO `dishes` VALUES ('213', '凉拌百财四丝', '荤菜', '家常味', '24', 'images/213.jpg');
INSERT INTO `dishes` VALUES ('214', '扒肚腐', '荤菜', '咸鲜味', '44', 'images/214.jpg');
INSERT INTO `dishes` VALUES ('215', '煎土豆丸子', '荤菜', '家常味', '55', 'images/215.jpg');
INSERT INTO `dishes` VALUES ('216', '土豆煨丸子', '荤菜', '家常味', '29', 'images/216.jpg');
INSERT INTO `dishes` VALUES ('217', '西红柿酿肉', '荤菜', '家常味', '29', 'images/217.jpg');
INSERT INTO `dishes` VALUES ('218', '黄焖牛肉加菜头', '荤菜', '酸甜味', '41', 'images/218.jpg');
INSERT INTO `dishes` VALUES ('219', '番茄土豆肥牛锅', '荤菜', '家常味', '20', 'images/219.jpg');
INSERT INTO `dishes` VALUES ('220', '肉片烧胡萝卜', '荤菜', '家常味', '21', 'images/220.jpg');
INSERT INTO `dishes` VALUES ('221', '锅塌豆腐', '荤菜', '家常味', '45', 'images/221.jpg');
INSERT INTO `dishes` VALUES ('222', '白锅牛肉豆腐', '荤菜', '麻辣味', '18', 'images/222.jpg');
INSERT INTO `dishes` VALUES ('223', '笋烧肉', '荤菜', '家常味', '40', 'images/223.jpg');
INSERT INTO `dishes` VALUES ('224', '炖冰腐牛肉', '荤菜', '家常味', '49', 'images/224.jpg');
INSERT INTO `dishes` VALUES ('225', '萝卜炖牛筋', '荤菜', '咸鲜味', '30', 'images/225.jpg');
INSERT INTO `dishes` VALUES ('226', '鱼头豆腐汤', '荤菜', '咸鲜味', '58', 'images/226.jpg');
INSERT INTO `dishes` VALUES ('227', '菠菜氽丸子', '荤菜', '咸鲜味', '22', 'images/227.jpg');
INSERT INTO `dishes` VALUES ('228', '肉片氽黄瓜', '荤菜', '家常味', '27', 'images/228.jpg');
INSERT INTO `dishes` VALUES ('229', '重庆荤豆花', '荤菜', '家常味', '17', 'images/229.jpg');
INSERT INTO `dishes` VALUES ('230', '溜鸡笋', '荤菜', '咸鲜味', '23', 'images/230.jpg');
INSERT INTO `dishes` VALUES ('231', '青菜白鸡面', '荤菜', '家常味', '24', 'images/231.jpg');
INSERT INTO `dishes` VALUES ('232', '豆瓣鱼', '荤菜', '麻辣味', '30', 'images/232.jpg');
INSERT INTO `dishes` VALUES ('233', '熘什锦黄菜', '荤菜', '家常味', '41', 'images/233.jpg');
INSERT INTO `dishes` VALUES ('234', '氽鲫鱼菜叶', '荤菜', '咸鲜味', '24', 'images/234.jpg');
INSERT INTO `dishes` VALUES ('235', '水萝卜片氽丸子', '荤菜', '咸鲜味', '28', 'images/235.jpg');
INSERT INTO `dishes` VALUES ('236', '青萝丝氽丸子', '荤菜', '咸鲜味', '20', 'images/236.jpg');
INSERT INTO `dishes` VALUES ('237', '青萝金钩奶汤', '荤菜', '家常味', '59', 'images/237.jpg');
INSERT INTO `dishes` VALUES ('238', '肉焖山药', '荤菜', '咸鲜味', '60', 'images/238.jpg');
INSERT INTO `dishes` VALUES ('239', '鸡汤煨藜麦豆腐丸子', '荤菜', '咸鲜味', '30', 'images/239.jpg');
INSERT INTO `dishes` VALUES ('240', '虾仁丸子汤', '荤菜', '咸鲜味', '60', 'images/240.jpg');
INSERT INTO `dishes` VALUES ('241', '鱼丸汤', '荤菜', '咸鲜味', '33', 'images/241.jpg');
INSERT INTO `dishes` VALUES ('242', '肉丸子', '荤菜', '家常味', '35', 'images/242.jpg');
INSERT INTO `dishes` VALUES ('243', '鸡肉丸子汤', '荤菜', '咸鲜味', '60', 'images/243.jpg');
INSERT INTO `dishes` VALUES ('244', '小白菜丸子汤', '荤菜', '家常味', '55', 'images/244.jpg');
INSERT INTO `dishes` VALUES ('245', '嘎鱼炖豆腐', '荤菜', '家常味', '47', 'images/245.jpg');
INSERT INTO `dishes` VALUES ('246', '鸡茸虾米丸子', '荤菜', '家常味', '16', 'images/246.jpg');
INSERT INTO `dishes` VALUES ('247', '鸡汤炖豆腐', '荤菜', '咸鲜味', '38', 'images/247.jpg');
INSERT INTO `dishes` VALUES ('248', '鳞虾丸子香菇火锅', '荤菜', '家常味', '33', 'images/248.jpg');
INSERT INTO `dishes` VALUES ('249', '豆腐肉丸子', '荤菜', '咸鲜味', '47', 'images/249.jpg');
INSERT INTO `dishes` VALUES ('250', '鲫鱼豆腐', '荤菜', '家常味', '22', 'images/250.jpg');
INSERT INTO `dishes` VALUES ('251', '鲫鱼炖萝卜粉条', '荤菜', '家常味', '60', 'images/251.jpg');
INSERT INTO `dishes` VALUES ('252', '榨菜鲫鱼', '荤菜', '咸鲜味', '33', 'images/252.jpg');
INSERT INTO `dishes` VALUES ('253', '凉拌黑木耳', '素菜', '麻辣味', '49', 'images/253.jpg');
INSERT INTO `dishes` VALUES ('254', '茶叶蛋', '素菜', '家常味', '39', 'images/254.jpg');
INSERT INTO `dishes` VALUES ('255', '西红柿炒鸡蛋', '素菜', '酸甜味', '25', 'images/255.jpg');
INSERT INTO `dishes` VALUES ('256', '辣白菜', '素菜', '麻辣味', '25', 'images/256.jpg');
INSERT INTO `dishes` VALUES ('257', '佛跳墙', '素菜', '咸鲜味', '20', 'images/257.jpg');
INSERT INTO `dishes` VALUES ('258', '银耳莲子羹', '素菜', '酸甜味', '53', 'images/258.jpg');
INSERT INTO `dishes` VALUES ('259', '酸辣土豆丝', '素菜', '麻辣味', '47', 'images/259.jpg');
INSERT INTO `dishes` VALUES ('260', '煎蛋', '素菜', '酸甜味', '36', 'images/260.jpg');
INSERT INTO `dishes` VALUES ('261', '鱼香茄子', '素菜', '咸鲜味', '47', 'images/261.jpg');
INSERT INTO `dishes` VALUES ('262', '麻婆豆腐', '素菜', '麻辣味', '36', 'images/262.jpg');
INSERT INTO `dishes` VALUES ('263', '干煸豆角', '素菜', '麻辣味', '28', 'images/263.jpg');
INSERT INTO `dishes` VALUES ('264', '烧茄子', '素菜', '酸甜味', '21', 'images/264.jpg');
INSERT INTO `dishes` VALUES ('265', '醋溜白菜', '素菜', '麻辣味', '37', 'images/265.jpg');
INSERT INTO `dishes` VALUES ('266', '地三鲜', '素菜', '家常味', '33', 'images/266.jpg');
INSERT INTO `dishes` VALUES ('267', '冰糖炖雪梨', '素菜', '酸甜味', '47', 'images/267.jpg');
INSERT INTO `dishes` VALUES ('268', '醋溜土豆丝', '素菜', '麻辣味', '48', 'images/268.jpg');
INSERT INTO `dishes` VALUES ('269', '四川泡菜', '素菜', '酸甜味', '21', 'images/269.jpg');
INSERT INTO `dishes` VALUES ('270', '拔丝地瓜', '素菜', '酸甜味', '58', 'images/270.jpg');
INSERT INTO `dishes` VALUES ('271', '麻辣豆腐', '素菜', '麻辣味', '49', 'images/271.jpg');
INSERT INTO `dishes` VALUES ('272', '香菇油菜', '素菜', '家常味', '37', 'images/272.jpg');
INSERT INTO `dishes` VALUES ('273', '拔丝山药', '素菜', '酸甜味', '48', 'images/273.jpg');
INSERT INTO `dishes` VALUES ('274', '蒜蓉西兰花', '素菜', '咸鲜味', '20', 'images/274.jpg');
INSERT INTO `dishes` VALUES ('275', '鸡蛋灌饼', '素菜', '家常味', '20', 'images/275.jpg');
INSERT INTO `dishes` VALUES ('276', '土豆泥', '素菜', '酸甜味', '17', 'images/276.jpg');
INSERT INTO `dishes` VALUES ('277', '酸辣粉', '素菜', '麻辣味', '33', 'images/277.jpg');
INSERT INTO `dishes` VALUES ('278', '炒年糕', '素菜', '家常味', '33', 'images/278.jpg');
INSERT INTO `dishes` VALUES ('279', '菠菜鸡蛋汤', '素菜', '咸鲜味', '50', 'images/279.jpg');
INSERT INTO `dishes` VALUES ('280', '疙瘩汤', '素菜', '家常味', '47', 'images/280.jpg');
INSERT INTO `dishes` VALUES ('281', '拍黄瓜', '素菜', '家常味', '26', 'images/281.jpg');
INSERT INTO `dishes` VALUES ('282', '尖椒土豆片', '素菜', '咸鲜味', '41', 'images/282.jpg');
INSERT INTO `dishes` VALUES ('283', '炸茄盒', '素菜', '酸甜味', '19', 'images/283.jpg');
INSERT INTO `dishes` VALUES ('284', '芹菜炒香干', '素菜', '家常味', '35', 'images/284.jpg');
INSERT INTO `dishes` VALUES ('285', '炸耦合', '素菜', '咸鲜味', '43', 'images/285.jpg');
INSERT INTO `dishes` VALUES ('286', '白菜炖豆腐', '素菜', '咸鲜味', '42', 'images/286.jpg');
INSERT INTO `dishes` VALUES ('287', '韭菜炒香干', '素菜', '家常味', '42', 'images/287.jpg');
INSERT INTO `dishes` VALUES ('288', '老醋花生', '素菜', '咸鲜味', '20', 'images/288.jpg');
INSERT INTO `dishes` VALUES ('289', '盐水花生', '素菜', '咸鲜味', '34', 'images/289.jpg');
INSERT INTO `dishes` VALUES ('290', '宫保豆腐', '素菜', '家常味', '40', 'images/290.jpg');
INSERT INTO `dishes` VALUES ('291', '凉拌菠菜', '素菜', '麻辣味', '39', 'images/291.jpg');
INSERT INTO `dishes` VALUES ('292', '手撕杏鲍菇', '素菜', '麻辣味', '51', 'images/292.jpg');
INSERT INTO `dishes` VALUES ('293', '蓑衣黄瓜', '素菜', '家常味', '48', 'images/293.jpg');
INSERT INTO `dishes` VALUES ('294', '麻酱豆角', '素菜', '咸鲜味', '42', 'images/294.jpg');
INSERT INTO `dishes` VALUES ('295', '松仁玉米', '素菜', '酸甜味', '23', 'images/295.jpg');
INSERT INTO `dishes` VALUES ('296', '红烧冬瓜', '素菜', '家常味', '54', 'images/296.jpg');
INSERT INTO `dishes` VALUES ('297', '菠菜炒鸡蛋', '素菜', '家常味', '43', 'images/297.jpg');
INSERT INTO `dishes` VALUES ('298', '西芹百合', '素菜', '家常味', '45', 'images/298.jpg');
INSERT INTO `dishes` VALUES ('299', '白灼芥蓝', '素菜', '咸鲜味', '25', 'images/299.jpg');
INSERT INTO `dishes` VALUES ('300', '凉拌西瓜皮', '素菜', '酸甜味', '34', 'images/300.jpg');
INSERT INTO `dishes` VALUES ('301', '冰糖湘莲', '素菜', '酸甜味', '20', 'images/301.jpg');
INSERT INTO `dishes` VALUES ('302', '青椒土豆丝', '素菜', '家常味', '19', 'images/302.jpg');
INSERT INTO `dishes` VALUES ('303', '锅塌豆腐', '素菜', '家常味', '32', 'images/303.jpg');
INSERT INTO `dishes` VALUES ('304', '拔丝苹果', '素菜', '酸甜味', '21', 'images/304.jpg');
INSERT INTO `dishes` VALUES ('305', '韭菜盒子', '素菜', '家常味', '30', 'images/305.jpg');
INSERT INTO `dishes` VALUES ('306', '蒜蓉油麦菜', '素菜', '咸鲜味', '39', 'images/306.jpg');
INSERT INTO `dishes` VALUES ('307', '荷塘小炒', '素菜', '家常味', '23', 'images/307.jpg');
INSERT INTO `dishes` VALUES ('308', '虎皮青椒', '素菜', '麻辣味', '23', 'images/308.jpg');
INSERT INTO `dishes` VALUES ('309', '咸蛋黄焗南瓜', '素菜', '家常味', '26', 'images/309.jpg');
INSERT INTO `dishes` VALUES ('310', '上汤娃娃菜', '素菜', '咸鲜味', '30', 'images/310.jpg');
INSERT INTO `dishes` VALUES ('311', '蒜泥茄子', '素菜', '咸鲜味', '53', 'images/311.jpg');
INSERT INTO `dishes` VALUES ('312', '香椿鱼儿', '素菜', '咸鲜味', '15', 'images/312.jpg');
INSERT INTO `dishes` VALUES ('313', '五香毛豆', '素菜', '咸鲜味', '58', 'images/313.jpg');
INSERT INTO `dishes` VALUES ('314', '杏仁豆腐', '素菜', '家常味', '51', 'images/314.jpg');
INSERT INTO `dishes` VALUES ('315', '凉拌海带丝', '素菜', '家常味', '59', 'images/315.jpg');
INSERT INTO `dishes` VALUES ('316', '青椒炒鸡蛋', '素菜', '咸鲜味', '16', 'images/316.jpg');
INSERT INTO `dishes` VALUES ('317', '黄瓜炒鸡蛋', '素菜', '家常味', '43', 'images/317.jpg');
INSERT INTO `dishes` VALUES ('318', '酸辣白菜', '素菜', '麻辣味', '51', 'images/318.jpg');
INSERT INTO `dishes` VALUES ('319', '红烧豆腐', '素菜', '咸鲜味', '35', 'images/319.jpg');
INSERT INTO `dishes` VALUES ('320', '紫菜蛋花汤', '素菜', '咸鲜味', '32', 'images/320.jpg');
INSERT INTO `dishes` VALUES ('321', '苦瓜炒鸡蛋', '素菜', '咸鲜味', '52', 'images/321.jpg');
INSERT INTO `dishes` VALUES ('322', '皮蛋豆腐', '素菜', '麻辣味', '49', 'images/322.jpg');
INSERT INTO `dishes` VALUES ('323', '炒莴笋', '素菜', '咸鲜味', '19', 'images/323.jpg');
INSERT INTO `dishes` VALUES ('324', '凉拌苦瓜', '素菜', '家常味', '44', 'images/324.jpg');
INSERT INTO `dishes` VALUES ('325', '水果沙拉', '素菜', '酸甜味', '41', 'images/325.jpg');
INSERT INTO `dishes` VALUES ('326', '香芹炝海带', '素菜', '麻辣味', '37', 'images/326.jpg');
INSERT INTO `dishes` VALUES ('327', '五香花生炝香芹', '素菜', '家常味', '22', 'images/327.jpg');
INSERT INTO `dishes` VALUES ('328', '米饭', '主食', '家常味', '2', 'images/328.jpg');
INSERT INTO `dishes` VALUES ('329', '馒头', '主食', '家常味', '1', 'images/329.jpg');
INSERT INTO `dishes` VALUES ('330', '花卷', '主食', '家常味', '2', 'images/330.jpg');

-- ----------------------------
-- Table structure for `total_order`
-- ----------------------------
DROP TABLE IF EXISTS `total_order`;
CREATE TABLE `total_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` varchar(50) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_nickname` varchar(50) NOT NULL,
  `o_total` varchar(50) NOT NULL,
  `o_state` varchar(50) NOT NULL,
  `u_phone` varchar(50) NOT NULL,
  `u_address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of total_order
-- ----------------------------
INSERT INTO `total_order` VALUES ('3', '20200510073125', '1', '张三', '188.0', '已支付', '15500009999', '河北师范大学');
INSERT INTO `total_order` VALUES ('4', '20200510080315', '1', '张三', '372.0', '已支付', '15500009999', '河北师范大学');
INSERT INTO `total_order` VALUES ('5', '20200510080441', '1', '张三', '84.0', '已支付', '15500009999', '河北师范大学');
INSERT INTO `total_order` VALUES ('6', '20200510141608', '1', '张三', '142.0', '已支付', '15500009999', '河北师范大学');
INSERT INTO `total_order` VALUES ('7', '20200510165950', '1', '张三', '82.0', '已支付', '15500009999', '河北师范大学');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `u_nickname` varchar(50) NOT NULL,
  `u_phone` varchar(11) NOT NULL,
  `u_address` varchar(100) NOT NULL,
  `u_img` varchar(100) DEFAULT NULL,
  `u_password` varchar(50) NOT NULL,
  PRIMARY KEY (`u_id`),
  KEY `u_nickname` (`u_nickname`),
  KEY `u_phone` (`u_phone`),
  KEY `u_address` (`u_address`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000001', '张三', '15500009999', '河北师范大学', '', '123');
INSERT INTO `user` VALUES ('0000000002', '咔咔', '15566667777', '', '', '555');
