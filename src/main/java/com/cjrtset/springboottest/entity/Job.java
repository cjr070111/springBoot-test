package com.cjrtset.springboottest.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.cjrtset.springboottest.validate.Save;
import com.cjrtset.springboottest.validate.Update;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("job")
public class Job {
        @NotNull(groups = {Update.class})
        @Min(value = 1, groups = Update.class)
        private Long Id;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String jobName;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String position;
}
