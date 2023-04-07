package com.example.demo.Controller.Manage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DAO.OutboundDAO;
import com.example.demo.DAO.OutboundDetailDAO;
import com.example.demo.DAO.ShopDAO;
import com.example.demo.DAO.StorehouseDAO;
import com.example.demo.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/manage/outbound")
@Controller
public class OutboundController {
    @Autowired
    private StorehouseDAO storehouseDAO;
    @Autowired
    private ShopDAO shopDAO;
    @Autowired
    private OutboundDAO outboundDAO;
    @Autowired
    private OutboundDetailDAO outboundDetailDAO;

    //     加入购物车
    @ResponseBody
    @PostMapping("/add")
    public JsonResult addShop(@RequestBody Shop shop){
        JsonResult result = new JsonResult();
        int insert = shopDAO.insert(shop);
        result.result(insert);
        return result;
    }

    //     清空购物车
    @ResponseBody
    @GetMapping("/deleteAll")
    public JsonResult deleteShop(){
        JsonResult result = new JsonResult();
        int delete = shopDAO.delete(null);
        result.result(delete);
        return result;
    }

    //     删除购物车一个商品
    @ResponseBody
    @GetMapping("/delete")
    public JsonResult deleteShopById(@RequestBody Shop shop){
        JsonResult result = new JsonResult();
        QueryWrapper<Shop> qw = new QueryWrapper<>();
        qw.eq("id",shop.getId());
        int delete = shopDAO.delete(qw);
        result.result(delete);
        return result;
    }

    //    生成出库单
    @ResponseBody
    @PostMapping("/insert")
    public JsonResult addOutbound(@RequestBody List<Shop> shops){
        JsonResult result = new JsonResult();

        Outbound outbound = new Outbound();
        outbound.setStartTime(result.currentTime());
        outbound.setPc("等待采购");
        outboundDAO.insert(outbound);

        QueryWrapper<Outbound> qw = new QueryWrapper<>();
        qw.select("max(id) as id");
        Outbound outbound1 = outboundDAO.selectOne(qw);
        int id = outbound1.getId();
        boolean flag = true;

        for (Shop shop :
                shops) {
            OutboundDetail outboundDetail = new OutboundDetail(id,shop.getName(),shop.getCategoryId(),shop.getNum());
            int insert = outboundDetailDAO.insert(outboundDetail);
            if (insert<1){
                result.False();
                flag=false;
            }
        }
        if (flag){
            result.True();
        }
        return result;
    }
}
