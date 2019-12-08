package com.nyist_shop.user.domian;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class BaseUser {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("学号或工号")
    private String workId;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("邮箱地址")
    private String email;
    @ApiModelProperty("电话号码")
    private String number;
    @ApiModelProperty("头像地址")
    private String avatar;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("登出时间")
    private String outTime;
    @ApiModelProperty("用户状态")
    private Integer state;
    @ApiModelProperty("学院名称")
    private String collegeName;
    @ApiModelProperty("专业名称")
    private String majorName;
}
