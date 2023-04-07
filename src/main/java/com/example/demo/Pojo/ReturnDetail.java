package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@TableName("return_detail")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDetail {
    @TableField("id")
    private int id;

    @TableField("name")
    private String name;

    @TableField("categoryId")
    private String categoryId;

    @TableField("num")
    private int num;
}
