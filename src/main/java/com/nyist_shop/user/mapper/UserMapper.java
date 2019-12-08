package com.nyist_shop.user.mapper;

import com.nyist_shop.user.domian.BaseUser;
import com.nyist_shop.user.domian.College;
import com.nyist_shop.user.domian.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 查询用户没有学院
     * @return
     */
    User findOnlyUser(String workid);
    /**
     * 删除用户根据工号或学号
     *
     * @param workId
     */
    public void delUserByWorkId(String workId);

    /**
     * 删除用户根据手机号码
     *
     * @param number
     */
    public void delUserByNumber(String number);

    /**
     * 更新用户
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<BaseUser> findAllUser();

    /**
     * 查询用户通过workID
     *
     * @param workId
     * @return
     */
    public BaseUser findUserByWorkId(String workId);

    /**
     * 查询用户通过number
     *
     * @param number
     * @return
     */
    public BaseUser findUserByNumber(String number);

}
