-- 更新role表
ALTER TABLE `role`
ADD COLUMN `role_description`  varchar(255) NULL AFTER `role_name`,
ADD COLUMN `create_time`  varchar(40) NULL AFTER `role_description`,
ADD COLUMN `update_time`  varchar(40) NULL AFTER `create_time`;
-- 更新权限表
ALTER TABLE `power`
CHANGE COLUMN `power_mark` `power_url`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `power_id`,
ADD COLUMN `power_name`  varchar(40) NULL AFTER `power_url`,
ADD COLUMN `power_description`  varchar(40) NULL AFTER `power_name`,
ADD COLUMN `update_time`  varchar(40) NULL AFTER `power_description`,
ADD COLUMN `create_time`  varchar(40) NULL AFTER `update_time`;