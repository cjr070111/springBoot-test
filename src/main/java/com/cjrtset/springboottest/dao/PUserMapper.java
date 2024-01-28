package com.cjrtset.springboottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjrtset.springboottest.entity.PUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PUserMapper extends BaseMapper<PUser> {
     List<PUser> selList();
}
