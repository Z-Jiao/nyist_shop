-- 角色
INSERT INTO `role` VALUES ('1', 'superadmin', '超级管理员', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
INSERT INTO `role` VALUES ('2', 'admin', '管理员', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
INSERT INTO `role` VALUES ('3', 'user', '用户', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
-- 权限
INSERT INTO `power` VALUES ('1', '/user/addUser', 'addUser', '新增用户', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
INSERT INTO `power` VALUES ('2', '/user/delUser', 'delUser', '删除用户', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
INSERT INTO `power` VALUES ('3', '/user/updateUser', 'updateUser', '更新用户', '2019-03-27 16:03:50', '2019-03-27 16:03:50');
