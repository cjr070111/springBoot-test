package com.cjrtset.springboottest.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjrtset.springboottest.dao.PUserMapper;
import com.cjrtset.springboottest.entity.PUser;
import com.cjrtset.springboottest.service.PUserService;
import com.cjrtset.springboottest.utiles.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PUserServiceImpl extends ServiceImpl<PUserMapper, PUser> implements PUserService {

    @Override
    public List<PUser> getList() {
        List<PUser> pUsers = baseMapper.selList();
        return pUsers;
    }
}
