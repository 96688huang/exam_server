CREATE DATABASE IF NOT EXISTS `exam_db`;

USE `exam_db`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `account` varchar(50) NOT NULL COMMENT '帐号',
  `password` varchar(255) NOT NULL COMMENT '登陆密码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='系统管理员信息';

-- ----------------------------
-- Table structure for examinee
-- ----------------------------
DROP TABLE IF EXISTS `examinee`;
CREATE TABLE `examinee` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `account` varchar(50) NOT NULL COMMENT '帐号',
  `password` varchar(255) NOT NULL COMMENT '登陆密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='应试者信息';

-- ----------------------------
-- Table structure for exam_owner
-- ----------------------------
DROP TABLE IF EXISTS `exam_owner`;
CREATE TABLE `exam_owner` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `account` varchar(50) NOT NULL COMMENT '帐号',
  `password` varchar(255) NOT NULL COMMENT '登陆密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名/企业名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='出题者信息';

-- ----------------------------
-- Table structure for exam_category
-- ----------------------------
DROP TABLE IF EXISTS `exam_category`;
CREATE TABLE `exam_category` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `owner_id` varchar(36) NOT NULL COMMENT '出题者id',
  `parent_id` varchar(36) NOT NULL DEFAULT '0' COMMENT '父类别id',
  `name` varchar(255) NOT NULL COMMENT '类别名称',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='类别信息';

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `category_id` varchar(36) NOT NULL COMMENT '试题类别',
  `name` varchar(255) NOT NULL COMMENT '试题名称',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='试题信息';

-- ----------------------------
-- Table structure for exam_fill
-- ----------------------------
DROP TABLE IF EXISTS `exam_fill`;
CREATE TABLE `exam_fill` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `exam_id` varchar(36) NOT NULL COMMENT '试题id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `answer` varchar(255) NOT NULL COMMENT '答案',
  `analysis` text DEFAULT NULL COMMENT '试题解析',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='填空题';

-- ----------------------------
-- Table structure for exam_judge
-- ----------------------------
DROP TABLE IF EXISTS `exam_judge`;
CREATE TABLE `exam_judge` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `exam_id` varchar(36) NOT NULL COMMENT '试题id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `answer` enum('Y','N') NOT NULL COMMENT '答案: Y-正确; N-错误;',
  `analysis` text DEFAULT NULL COMMENT '试题解析',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='判断题';

-- ----------------------------
-- Table structure for exam_choice
-- ----------------------------
DROP TABLE IF EXISTS `exam_choice`;
CREATE TABLE `exam_choice` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `exam_id` varchar(36) NOT NULL COMMENT '试题id',
  `content` varchar(255) NOT NULL COMMENT '题目内容',
  `options` text NOT NULL COMMENT '答案选项',
  `answer` char(1) NOT NULL COMMENT '答案',
  `analysis` text DEFAULT NULL COMMENT '试题解析',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='单选题';

-- ----------------------------
-- Table structure for exam_multi_choice
-- ----------------------------
DROP TABLE IF EXISTS `exam_multi_choice`;
CREATE TABLE `exam_multi_choice` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `exam_id` varchar(36) NOT NULL COMMENT '试题id',
  `content` varchar(255) NOT NULL COMMENT '题目内容',
  `options` text NOT NULL COMMENT '答案选项',
  `answer` varchar(10) NOT NULL COMMENT '答案',
  `analysis` text COMMENT '试题解析',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='多选题';

-- ----------------------------
-- Table structure for exam_essay
-- ----------------------------
DROP TABLE IF EXISTS `exam_essay`;
CREATE TABLE `exam_essay` (
  `id` varchar(36) NOT NULL COMMENT 'id主键',
  `exam_id` varchar(36) NOT NULL COMMENT '试题id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `answer` text NOT NULL COMMENT '答案',
  `analysis` text DEFAULT NULL COMMENT '试题解析',
  `description` text NOT NULL COMMENT '说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='论述题';





