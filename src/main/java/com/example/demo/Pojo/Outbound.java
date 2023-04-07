package com.example.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;


@TableName("outbound")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Outbound {
    @TableId
    private int Id;

    @TableField("startTime")
    private String  startTime;

    @TableField("endTime")
    private String  endTime;

    @TableField("finished")
    private boolean finish;

    @TableField("pc")
    private String pc;

    @TableField("dl")
    private int dl;
}
