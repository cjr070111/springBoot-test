package com.cjrtset.springboottest.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjrtset.springboottest.entity.PUser;

import java.util.List;


public interface PUserService extends IService<PUser> {

    List<PUser> getList();
}
