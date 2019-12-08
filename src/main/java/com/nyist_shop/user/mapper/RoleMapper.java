package com.nyist_shop.user.mapper;

import com.nyist_shop.user.domian.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    //查询所有角色信息
    List<Role> findAllRoles();
    //查询个人角色信息
    String findOneRoleByRoleId(String  roleid);
    //添加角色信息
    void addRole(Role role);
    //更新角色信息
    void updateRole(Role role);
}
