package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@TableName("shop")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Shop{

    @TableId
    private int Id;

    @TableField("name")
    private String name;

    @TableField("categoryId")
    private int categoryId;

    @TableField("num")
    private int num;
}
