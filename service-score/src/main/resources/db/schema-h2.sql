-- DROP TABLE IF EXISTS user;
CREATE TABLE `user_info`(
	`id` INT NOT NULL AUTO_INCREMENT COMMENT 'primary_ID',
	`name` VARCHAR(30) NULL DEFAULT NULL COMMENT 'name',
	`age` INT NULL DEFAULT NULL COMMENT 'age',
	`email` VARCHAR(50) NULL DEFAULT NULL COMMENT 'email',
	PRIMARY KEY (`id`)
);
