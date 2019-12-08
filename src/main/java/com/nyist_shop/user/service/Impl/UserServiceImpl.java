package com.nyist_shop.user.service.Impl;

import com.nyist_shop.user.domian.BaseUser;
import com.nyist_shop.user.domian.College;
import com.nyist_shop.user.domian.User;
import com.nyist_shop.user.mapper.MajorMapper;
import com.nyist_shop.user.mapper.UserMapper;
import com.nyist_shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User findOnlyUser(String workid) {
        return userMapper.findOnlyUser(workid);
    }

    @Override
    public void delUserByWorkId(String workId) {
        userMapper.delUserByWorkId(workId);
    }

    @Override
    public void delUserByNumber(String number) {
        userMapper.delUserByNumber(number);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<BaseUser> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public BaseUser findUserByWorkId(String workId) {
        return userMapper.findUserByWorkId(workId);
    }

    @Override
    public BaseUser findUserByNumber(String number) {
        return userMapper.findUserByNumber(number);
    }
}
