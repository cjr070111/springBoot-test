package com.cjrtset.springboottest.validate;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.List;


@Data
public class ValidationList<E> implements List<E> {

    /*
     * @Delegate注解受lombok版本限制，1.18.6以上版本可支持。
     * 如果校验不通过，会抛出 NotReadablePropertyException， 同样可以使用统一异常进行处理。
     */

    @Delegate    // @Delegate是lombok注解
    @Valid       // 一定要加@Valid注解
    public List<E> list = new ArrayList<>();

    // 一定要记得重写toString方法
    @Override
    public String toString() {
        return list.toString();
    }



}
