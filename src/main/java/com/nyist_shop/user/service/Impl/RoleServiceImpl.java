package com.nyist_shop.user.service.Impl;

import com.nyist_shop.user.domian.Role;
import com.nyist_shop.user.mapper.RoleMapper;
import com.nyist_shop.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRoles() {
        return roleMapper.findAllRoles();
    }

    @Override
    public Role findOneRoleByRoleId(String roleid) {
        return roleMapper.findOneRoleByRoleId(roleid);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }
}
