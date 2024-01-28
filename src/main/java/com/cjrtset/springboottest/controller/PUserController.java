package com.cjrtset.springboottest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjrtset.springboottest.entity.PUser;
import com.cjrtset.springboottest.service.PUserService;
import com.cjrtset.springboottest.utiles.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PUserController {

    @Resource
    private PUserService pUserService;


    @PostMapping
    public Result<Long> save(PUser pUser){
        pUserService.save(pUser);
        return Result.success(pUser.getId());
    }

    @GetMapping("/{id}")
    public Result<PUser> getById(Long id){
        PUser pUser = pUserService.getById(id);
        return Result.success(pUser);
    }



    @GetMapping("/getUserListPage")
    public Result<IPage<PUser>> getInfoListPage(){
        Page<PUser> page = pUserService.page(new Page<>(1, 5));
        return Result.success(page);
    }

    @GetMapping("/list")
    public Result<List<PUser>> list(){
        return Result.success(pUserService.getList());
    }



}
