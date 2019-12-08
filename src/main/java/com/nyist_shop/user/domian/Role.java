package com.nyist_shop.user.domian;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("角色实体类")
@Data
public class Role {
    private String roleId;
    private String roleName;
    private String createTime;
    private String updateTime;

}
