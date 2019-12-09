package com.nyist_shop.user.service.Impl;

import com.nyist_shop.user.domian.power;
import com.nyist_shop.user.mapper.PowerMapper;
import com.nyist_shop.user.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<power> findAllPowersByRoleId(String workid) {
        return powerMapper.findAllPowersByRoleId(workid);
    }
}
