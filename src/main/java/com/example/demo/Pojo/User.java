package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

@TableName("user")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private String username;

    @TableField("password")
    private String password;

    @TableField("id")
    private int id;

}
