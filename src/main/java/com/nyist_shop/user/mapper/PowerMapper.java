package com.nyist_shop.user.mapper;

import com.nyist_shop.user.domian.power;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PowerMapper {

    //查询权限
    List<power> findAllPowersByRoleId(String workid);

}
