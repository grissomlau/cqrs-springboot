CREATE DATABASE cqrs;

USE cqrs;


CREATE TABLE `sys_user` (
	`id` BIGINT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`real_name` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`avatar_url` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`mobile` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`sex` SMALLINT(1) UNSIGNED NOT NULL DEFAULT '2' COMMENT '�Ա� 0 Ů�� 1 �У� 2 δ֪',
	`state` SMALLINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '0 δ���1 ���������У� 2 ����',
	`is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ���ɾ���� 0 �� 1 ��',
	`remark` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`create_time` DATETIME NULL DEFAULT current_timestamp(),
	`update_time` DATETIME NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='�û���Ϣ'
COLLATE='utf8_general_ci'
ENGINE=INNODB  
;
