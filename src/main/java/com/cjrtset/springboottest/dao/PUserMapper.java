package com.cjrtset.springboottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjrtset.springboottest.entity.Job;
import com.cjrtset.springboottest.entity.PUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface PUserMapper extends BaseMapper<PUser> {
     List<PUser> selList();

     List<PUser> getUsers(@Param("id") Long id);

     List<List<?>> getUsersJob();

     Integer insertAndCount(Map<String ,Object> map);
}
