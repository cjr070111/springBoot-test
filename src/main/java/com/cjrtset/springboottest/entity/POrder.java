package com.cjrtset.springboottest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("p_order")
public class POrder {

  /**
   * 主键
   * @TableId中可以决定主键的类型,不写会采取默认值,默认值可以在yml中配置
   * AUTO: 数据库ID自增
   * INPUT: 用户输入ID
   * ID_WORKER: 全局唯一ID，Long类型的主键
   * ID_WORKER_STR: 字符串全局唯一ID
   * UUID: 全局唯一ID，UUID类型的主键
   * NONE: 该类型为未设置主键类型
   */
  @TableId(type = IdType.AUTO)
  private long id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private long userId;
  private String productName;
  private String totalPrice;
  private long count;
  private String unitPrice;
  private long status;
  private long payType;





}
