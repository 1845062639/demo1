package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@TableName("storehouse")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Storehouse {
    @TableId
    private int Id;

    @TableField("name")
    private String name;

    @TableField("categoryId")
    private int categoryId;

    @TableField("num")
    private int num;

    @TableField("stockout")
    private boolean stockout;

    public Storehouse(String name, int categoryId, int num) {
        this.name = name;
        this.categoryId = categoryId;
        this.num = num;
    }
}
