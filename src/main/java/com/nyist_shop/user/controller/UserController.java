package com.nyist_shop.user.controller;

import com.nyist_shop.config.Time;
import com.nyist_shop.user.domian.BaseUser;
import com.nyist_shop.user.domian.User;
import com.nyist_shop.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "UserController", tags = "用户管理")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    static Time time = new Time();

    /**
     * 更改用户信息根据工号或者学号
     *
     * @param user1
     */
    @PostMapping(value = "/user/updateUserByWorkId")
    @ApiOperation("更改用户信息根据工号或者学号")
    public void updateUserByWorkId(@ApiParam("更新用户信息") @RequestBody User user1) {
        User user = userService.findOnlyUser(user1.getWorkId());
        user.setId("1");
        user.setName(user1.getName());
        user.setPassword(user1.getPassword());
        user.setSex(user1.getSex());
        user.setAge(Integer.valueOf(user1.getAge()));
        user.setNumber(user1.getNumber());
        user.setMajorId(user1.getMajorId());
        user.setEmail(user1.getEmail());
        user.setAvatar(user1.getAvatar());
        user.setOutTime(user1.getOutTime());
        user.setCreateTime(user1.getCreateTime());
        user.setState(1);
        userService.updateUser(user);
    }

    /**
     * 查找用户根据工号或者学号
     *
     * @param workid
     * @return
     */
    @GetMapping(value = "/user/findUserByWorkId")
    @ApiOperation("查找用户根据工号或者学号")
    public BaseUser findUserByWorkId(@ApiParam("工号或者学号") @RequestParam(name = "workid") String workid) {
        BaseUser user = userService.findUserByWorkId(workid);
        return user;
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @GetMapping(value = "/user/findAllUser")
    @ApiOperation("查找所有用户")
    public List<BaseUser> findAllUser() {
        List<BaseUser> users = userService.findAllUser();
        return users;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping(value = "/user/addUser")
    @ApiOperation("添加用户")
    public void addUser(@ApiParam("JSON格式的用户信息")@RequestBody User user) {
        String createTime = time.getTime();
        String workId = user.getWorkId();
        String password = user.getPassword();
        user.setPassword(new Md5Hash(password, workId, 1024).toString());
        user.setOutTime(createTime);
        user.setCreateTime(createTime);
        user.setState(1);
        userService.addUser(user);
    }

    /**
     * 删除用户根据电话号码
     *
     * @return
     */
    @GetMapping(value = "/user/delUserByNumber")
    @ApiOperation("删除用户根据电话号码")
    public void delUserByNumber(@ApiParam("电话号码") @RequestParam(name = "number") String number) {
        userService.delUserByNumber(number);
    }

    /**
     * 删除用户根据学号或工号
     *
     * @return
     */
    @GetMapping(value = "/user/delUserByWorkId")
    @ApiOperation("删除用户根据学号或工号")
    public void delUserByWorkId(@ApiParam("学号或工号") @RequestParam(name = "workid") String workid) {
        userService.delUserByWorkId(workid);
    }

}
