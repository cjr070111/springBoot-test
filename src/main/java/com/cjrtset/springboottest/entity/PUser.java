package com.cjrtset.springboottest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@Data
@TableName("p_user")
public class PUser {

  private long id;

  private Date createdAt;

  private Date updatedAt;

  private Date deletedAt;

  private String mobile;

  private String nickname;


}
