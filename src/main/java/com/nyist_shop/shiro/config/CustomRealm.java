package com.nyist_shop.shiro.config;

import com.nyist_shop.user.domian.User;
import com.nyist_shop.user.mapper.RoleMapper;
import com.nyist_shop.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 构造授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
                                                               principalCollection) {
        System.out.println("doGetAuthorizationInfo..............");
        //1.从principalCollection 获取登录用户的信息
        String principal = (String) principalCollection.getPrimaryPrincipal();
        //2.利用登录的用户的信息来获取用户当前的角色或权限（可能需要查询数据库）
        String role = roleMapper.findOneRoleByRoleId(principal);
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        //给用户添加权限
//        当用户名为superadmin时 为用户添加权限superadmin  两个superadmin可以理解为连个字段
        if ("superadmin".equals(role)) {
            roles.add("superadmin");
            permissions.add("superadmin:admin");
            permissions.add("superadmin:user");
        }
        if ("admin".equals(role)) {
            roles.add("admin");
            permissions.add("admin:user");
            permissions.add("admin:admin");
        }
        if ("user".equals(role)) {
            roles.add("user");
            permissions.add("user:user");
        }
        //2.构造认证数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //添加权限
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 认证方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //1.获取登录的upToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //2.获取输入的用户名密码
        String workid = upToken.getUsername();
//        String password = new String(upToken.getPassword());
        //3.数据库查询用户
        // 颜值加密的颜，可以用用户名
        System.out.println(workid + "============");
        ByteSource salt = ByteSource.Util.bytes(workid);
        System.out.println(salt + "===========");
        User user = userService.findOnlyUser(workid);
        if (user == null) {
            throw new UnknownAccountException();
        }
        if (user.getState() == 0) {
            throw new AuthenticationException();
        }
        //4.用户存在并且密码匹配存储用户数据
        // 创建SimpleAuthenticationInfo对象，并且把username和password等信息封装到里面
        // 用户密码的比对是Shiro帮我们完成的
        if (user != null) {
            SimpleAuthenticationInfo info = null;
            info = new SimpleAuthenticationInfo(workid, user.getPassword(), salt, this.getName());
            return info;
        } else {
            throw new IncorrectCredentialsException();
        }
    }
}
