package com.nyist_shop.user.service;

import com.nyist_shop.user.domian.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface RoleService {
    //查询所有角色信息
    List<Role> findAllRoles();
    //查询个人角色信息
    String findOneRoleByRoleId(String  roleid);
    //添加角色信息
    void addRole(Role role);
    //更新角色信息
    void updateRole(Role role);

}
