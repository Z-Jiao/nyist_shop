package com.nyist_shop.user.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;

@ApiModel
@Mapper
public interface MajorMapper {
    //根据专业名称查询专业id
    String findMajorIdByName(String majorName);
}
