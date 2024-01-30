package com.cjrtset.springboottest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjrtset.springboottest.entity.Job;
import com.cjrtset.springboottest.entity.PUser;
import com.cjrtset.springboottest.service.PUserService;
import com.cjrtset.springboottest.utiles.Result;
import com.cjrtset.springboottest.validate.Save;
import com.cjrtset.springboottest.validate.Update;
import com.cjrtset.springboottest.validate.ValidationList;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class PUserController {

    @Resource
    private PUserService pUserService;


    /**
     * 如果请参数不正确会抛出MethodArgumentNotValidException异常（类上加了@Validated，参数也还得加上）
     * @param pUser
     * @return
     */
    @PostMapping
    public Result<Long> save(@Validated(Save.class) @RequestBody PUser pUser){
        pUserService.save(pUser);
        return Result.success(pUser.getId());
    }

    @PostMapping("/saveList")
    public Result<Long> saveList(@Validated(Save.class) @RequestBody ValidationList<PUser> pUsers){
        pUserService.saveBatch(pUsers);
        return Result.success();
    }


    /**
     * 分组校验（Update.class和Save.class定义的俩个空接口用于区分）
     * @param pUser
     * @return
     */
    @PostMapping("/update")
    public Result<Long> update(@Validated(Update.class) @RequestBody PUser pUser){
        boolean flag = pUserService.update(pUser, new QueryWrapper<PUser>().eq("id", pUser.getId()));
        if (flag){
            return Result.success("修改成功");
        }else {
            return Result.error("修改失败");
        }
    }


    @GetMapping("/{id}")
    public Result<PUser> getById(@PathVariable("id") @Min(value = 1, message = "ID需要大于1") Long id){
        PUser pUser = pUserService.getById(id);
        return Result.success(pUser);
    }


    /**
     * 如果要进行@RequestParam参数校验，需要在controller上加上@Validated注解会抛出（@Valid无效）
     * ConstraintViolationException异常
      * @param username
     * @return
     */
    @GetMapping("/getByName")
    public Result<PUser> getByname(@NotBlank(message = "请传入用户名") @RequestParam(value = "username") String username) {
        // 校验通过才会执行业务逻辑
        PUser user = pUserService.getOne(new QueryWrapper<PUser>().eq("name", username));
        return Result.success(user);
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

    /**
     * 调用存储过程
     * @return
     */
    @GetMapping("/getUsers/{id}")
    public Result<List<PUser>> getList(@PathVariable Long id){
        List<PUser> user = pUserService.getUser(id);
        return Result.success(user);
    }

    /**
     * 查询结果返回俩张表的数据
     */
    @GetMapping("/getUsersJob")
    public Result<List<List<?>>> getUsersJob(){
        List<List<?>> user = pUserService.getUsersJob();
        return Result.success(user);
    }

    /**
     * 有入参和有出参的存储过程
     */
    @PostMapping ("/insertAndCount")
    public Result<Integer> getUsersJob(@Validated(Save.class) @RequestBody Job job){
        Integer i =  pUserService.insertAndCount(job);
        return Result.success(i);
    }

}
