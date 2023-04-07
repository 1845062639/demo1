package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@TableName("return")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Return {
    @TableId
    private int Id;

    @TableField("startTime")
    private Date startTime;

    @TableField("endTime")
    private Date endTime;

    @TableField("finished")
    private boolean finished;

    @TableField("pc")
    private String pc;

    @TableField("dl")
    private int dl;
}
