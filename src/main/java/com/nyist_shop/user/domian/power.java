package com.nyist_shop.user.domian;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("权限实体类")
@Data
public class power {
    private String powerId;
    private String powerUrl;
    private String powerName;
    private String powerDescription;
    private String updateTime;
    private String createTime;
}
