CREATE DATABASE cqrs;

USE cqrs;


CREATE TABLE `sys_user` (
	`id` BIGINT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`real_name` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`avatar_url` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`mobile` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`sex` SMALLINT(1) UNSIGNED NOT NULL DEFAULT '2' COMMENT '性别， 0 女， 1 男， 2 未知',
	`state` SMALLINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '0 未激活，1 激活启用中， 2 禁用',
	`is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否已删除， 0 否， 1 是',
	`remark` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`create_time` DATETIME NULL DEFAULT current_timestamp(),
	`update_time` DATETIME NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='用户信息'
COLLATE='utf8_general_ci'
ENGINE=INNODB  
;
