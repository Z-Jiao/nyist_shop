package com.nyist_shop.user.domian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("专业实体类")
public class Major implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("学院id")
    private String collegeId;
    @ApiModelProperty("专业id")
    private String majorId;
    @ApiModelProperty("专业名称")
    private String majorName;
    private List<User> users;
}
