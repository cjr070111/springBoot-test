package com.cjrtset.springboottest.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cjrtset.springboottest.validate.Save;
import com.cjrtset.springboottest.validate.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("p_user")
public class PUser {

  @NotNull(message = "修改时id不能为空",groups = Update.class)   //一般通过id来修改
  private Long id;

  private Date createdAt;

  private Date updatedAt;

  private Date deletedAt;

  private String mobile;

  @Size(min = 5, max = 10, message = "请输入5-10个字符的用户名",groups ={Update.class, Save.class})
  @NotNull(message = "姓名不能为空",groups = Save.class)
  private String name;

  @Email(message = "邮箱格式错误",groups ={Update.class, Save.class})
  private String email;

  @Min(value = 18,message = "年龄不能小于18",groups ={Update.class, Save.class})
  private Integer age;

  @NotNull(message = "生日不能为空",groups = Save.class)
  @Past(message = "生日必须是过去世间",groups ={Update.class, Save.class})
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date birthday;

  /**
   * 如果是嵌套校验，需要加上Valid（只能是Valid，@Validated不支持嵌套校验）
   */
  @Valid
  @NotNull(groups = {Save.class, Update.class})
  @TableField(exist = false)
  private Job job;


}
