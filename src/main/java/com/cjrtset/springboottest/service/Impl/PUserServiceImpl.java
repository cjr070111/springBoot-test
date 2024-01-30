package com.cjrtset.springboottest.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjrtset.springboottest.dao.PUserMapper;
import com.cjrtset.springboottest.entity.Job;
import com.cjrtset.springboottest.entity.PUser;
import com.cjrtset.springboottest.service.PUserService;
import com.cjrtset.springboottest.utiles.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PUserServiceImpl extends ServiceImpl<PUserMapper, PUser> implements PUserService {

    @Override
    public List<PUser> getList() {
        List<PUser> pUsers = baseMapper.selList();
        return pUsers;
    }

    @Override
    public List<PUser> getUser(Long id) {
        List<PUser> users = baseMapper.getUsers(id);
        return users;
    }

    @Override
    public List<List<?>> getUsersJob() {
        return baseMapper.getUsersJob();
    }

    @Override
    public Integer insertAndCount(Job job) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",job.getId());
        map.put("jobName",job.getJobName());
        map.put("position",job.getPosition());
        map.put("num",-1);
        return baseMapper.insertAndCount(map);
    }
}
