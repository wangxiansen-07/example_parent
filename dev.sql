# 创建数据库
create database dev;
use dev;

# 创建company表
create table `tb_company`
(
    `id`                 VARCHAR(40) NOT NULL COMMENT 'ID',
    `name`               VARCHAR(255) DEFAULT NULL COMMENT '公司名称',
    `representative`     VARCHAR(255) DEFAULT NULL COMMENT '法人代表',
    `phone`              VARCHAR(255) DEFAULT NULL COMMENT '公司电话',
    `address`            VARCHAR(255) DEFAULT NULL COMMENT '公司地址',
    `license_id`         VARCHAR(255) DEFAULT NULL COMMENT '营业执照(图片地址)',
    `expiration_date`    datetime     DEFAULT NULL COMMENT '有效日期',
    `registered_capital` DOUBLE       DEFAULT NULL COMMENT '注册资金',
    `company_size`       VARCHAR(255) DEFAULT NULL COMMENT '公司规模',
    `industry`           VARCHAR(255) DEFAULT NULL COMMENT '所属行业',
    `remarks`            VARCHAR(255) DEFAULT NULL COMMENT '备注',
    `state`              INT(2)       DEFAULT '0' COMMENT '状态',
    primary key (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4;
