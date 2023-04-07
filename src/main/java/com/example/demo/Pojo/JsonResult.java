package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    private int state;
    private String message;
    private List objectList;
    private Object object;

    public JsonResult(int state, String message, Object object) {
        this.state = state;
        this.message = message;
        this.object = object;
    }

    public JsonResult(int state, String message, List<Object> objectList) {
        this.state = state;
        this.message = message;
        this.objectList = objectList;
    }

    public void True(){
        this.message="success";
        this.state=200;
    }

    public void False(){
        this.message="defeated";
        this.state=233;
    }

    public void CompareList(List objectList){
        if (objectList.size()>0){
            this.True();
            this.setObjectList(objectList);
        }else {
            this.False();
        }
    }

    public void CompareObject(Object object){
        if (object!=null){
            this.True();
            this.setObject(object);
        }else {
            this.False();
        }
    }

    public void result(int i){
        if (i!=0){
            this.True();
        }else {
            this.False();
        }
    }

    public String currentTime(){
        Date dateTime=new Date();//获取日期

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置格式

        String currentTime=df.format(dateTime);//套用

        return currentTime;
    }
}
