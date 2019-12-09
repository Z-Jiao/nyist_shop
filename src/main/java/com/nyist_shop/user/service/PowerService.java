package com.nyist_shop.user.service;

import com.nyist_shop.user.domian.power;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PowerService {
    //查询权限
    List<power> findAllPowersByRoleId(String workid);
}
