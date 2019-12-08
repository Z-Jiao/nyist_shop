package com.nyist_shop.user.domian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("学院实体类")
public class College implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("学院id")
    private String collegeId;
    @ApiModelProperty("学院名称")
    private String collegeName;
    private List<Major> majors;
}
