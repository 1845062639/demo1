package com.example.demo.Controller.Manage;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DAO.*;
import com.example.demo.Pojo.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("/manage")
@Controller
public class ManageController {
    @Autowired
    private PurchaseDAO purchaseDAO;
    @Autowired
    private PurchaseDetailDAO purchaseDetailDAO;
    @Autowired
    private ReturnDAO returnDAO;
    @Autowired
    private ReturnDetailDAO returnDetailDAO;
    @Autowired
    private BackDAO backDAO;
    @Autowired
    private BackDetailDAO backDetailDAO;
    @Autowired
    private StorehouseDAO storehouseDAO;
    @Autowired
    private ShopDAO shopDAO;
    @Autowired
    private OutboundDAO outboundDAO;
    @Autowired
    private OutboundDetailDAO outboundDetailDAO;
    private Integer id = 2;
    private String name = "shop";

    @RequestMapping("/purchaseDetail")
    public String hello(){
        return "manage/purchaseDetail";
    }

    //    查询所有
    @ResponseBody
    @GetMapping("/selectAll/{name}")
    public JsonResult selectAll(@PathVariable("name") String s) {
        JsonResult result = new JsonResult();
        name=s;
//        采购
        if (name.equals("purchase")) {
            QueryWrapper<Purchase> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            List<Purchase> pc = purchaseDAO.selectList(qw);
            result.CompareList(pc);
        }
//        缺货
        else if (name.equals("back")) {
            QueryWrapper<Back> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            List<Back> pc = backDAO.selectList(qw);
            result.CompareList(pc);
        }
//        退货
        else if (name.equals("return")) {
            QueryWrapper<Return> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            List<Return> pc = returnDAO.selectList(qw);
            result.CompareList(pc);
        }
//        仓库
        else if (name.equals("storehouse")) {
            QueryWrapper<Storehouse> qw = new QueryWrapper<>();
            List<Storehouse> pc = storehouseDAO.selectList(qw);
            result.CompareList(pc);
        }
//        购物车
        else if (name.equals("shop")) {
            QueryWrapper<Shop> qw = new QueryWrapper<>();
            List<Shop> pc = shopDAO.selectList(qw);
            result.CompareList(pc);
        }
//        出库
        else if (name.equals("outbound")) {
            QueryWrapper<Outbound> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            List<Outbound> outbounds = outboundDAO.selectList(qw);
            result.CompareList(outbounds);
        }
        return result;
    }

//    查询历史
    @ResponseBody
    @GetMapping("/selectAllOrder/{name}")
    public JsonResult selectAllOrder(@PathVariable("name") String s) {
        JsonResult result = new JsonResult();
        name=s;
        if (name.equals("purchase")) {
            QueryWrapper<Purchase> qw = new QueryWrapper<>();
            qw.eq("finished", true);
            List<Purchase> pc = purchaseDAO.selectList(qw);
            result.CompareList(pc);
        } else if (name.equals("back")) {
            QueryWrapper<Back> qw = new QueryWrapper<>();
            qw.eq("finished", true);
            List<Back> pc = backDAO.selectList(qw);
            result.CompareList(pc);
        } else if (name.equals("return")) {
            QueryWrapper<Return> qw = new QueryWrapper<>();
            qw.eq("finished", true);
            List<Return> pc = returnDAO.selectList(qw);
            result.CompareList(pc);
        }
        else if (name.equals("outbound")) {
            QueryWrapper<Shop> qw = new QueryWrapper<>();
            qw.eq("finished", true);
            List<Shop> pc = shopDAO.selectList(qw);
            result.CompareList(pc);
        }else {
            result.False();
        }
        return result;
    }

//    order查询
    @ResponseBody
    @PostMapping("/select")
    public JsonResult selectById(@RequestBody Purchase p) {
        Integer id = p.getId();
        Date startTime = p.getStartTime();
        JsonResult result = new JsonResult();
        if (name.equals("purchase")) {
            QueryWrapper<Purchase> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            if (id != 0 && startTime != null) {
                qw.eq("id", id).le("startTime", startTime);
            } else if (id != 0 && startTime == null) {
                qw.eq("id", id);
            } else if (id == 0 && startTime != null) {
                qw.le("startTime", startTime);
            }
            List<Purchase> purchaseList = purchaseDAO.selectList(qw);
            result.CompareList(purchaseList);
        } else if (name.equals("back")) {
            QueryWrapper<Back> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            if (id != 0 && startTime != null) {
                qw.eq("id", id).le("startTime", startTime);
            } else if (id != 0 && startTime == null) {
                qw.eq("id", id);
            } else if (id == 0 && startTime != null) {
                qw.le("startTime", startTime);
            }
            List<Back> backList = backDAO.selectList(qw);
            result.CompareList(backList);
        } else if (name.equals("return")) {
            QueryWrapper<Return> qw = new QueryWrapper<>();
            qw.eq("finished", false);
            if (id != 0 && startTime != null) {
                qw.eq("id", id).le("startTime", startTime);
            } else if (id != 0 && startTime == null) {
                qw.eq("id", id);
            } else if (id == 0 && startTime != null) {
                qw.le("startTime", startTime);
            }
            List<Return> returnList = returnDAO.selectList(qw);
            result.CompareList(returnList);
        } else {
            result.False();
        }
        return result;
    }

//    detail查询
//      设置id
    @ResponseBody
    @GetMapping("/setId/{id}")
    public JsonResult setId(@PathVariable("id") int id){
        this.id = id;
        JsonResult result = new JsonResult();
        result.True();
        return result;
    }

//    查询detail
    @ResponseBody
    @GetMapping("/selectDetailId")
    public JsonResult selectById(){
        JsonResult result = new JsonResult();
        if (name.equals("purchase")) {
            QueryWrapper<PurchaseDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            List<PurchaseDetail> pcd = purchaseDetailDAO.selectList(qw);
            result.CompareList(pcd);
            return result;
        } else if (name.equals("back")) {
            QueryWrapper<BackDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            List<BackDetail> pcd = backDetailDAO.selectList(qw);
            result.CompareList(pcd);
        } else if (name.equals("return")) {
            QueryWrapper<ReturnDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            List<ReturnDetail> pcd = returnDetailDAO.selectList(qw);
            result.CompareList(pcd);
        }else if (name.equals("outbound")) {
            QueryWrapper<OutboundDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            List<OutboundDetail> od = outboundDetailDAO.selectList(qw);
            result.CompareList(od);
        }
        else {
            result.False();
        }
        return result;
    }

//    查询细节框
    @ResponseBody
    @PostMapping("/selectDetail")
    public JsonResult selectById(@RequestBody PurchaseDetail p)
    {
        int categoryId = p.getCategoryId();
        String names = p.getName();
        JsonResult result = new JsonResult();
        if (name.equals("purchase")) {
            QueryWrapper<PurchaseDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            if (categoryId!=0&&!names.equals("")){
                qw.eq("categoryId",categoryId).like("name",names);
            } else if (categoryId!=0&& names.equals("")) {
                qw.eq("categoryId",categoryId);
            } else if (categoryId==0&&!names.equals("")) {
                qw.like("name",names);
            }
            List<PurchaseDetail> purchaseList = purchaseDetailDAO.selectList(qw);
            result.CompareList(purchaseList);
        } else if (name.equals("back")) {
            QueryWrapper<BackDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            if (categoryId!=0&&!names.equals("")){
                qw.eq("categoryId",categoryId).like("name",names);
            } else if (categoryId!=0&& names.equals("")) {
                qw.eq("categoryId",categoryId);
            } else if (categoryId==0&&!names.equals("")) {
                qw.like("name",names);
            }
            List<BackDetail> purchaseList = backDetailDAO.selectList(qw);
            result.CompareList(purchaseList);
        } else if (name.equals("return")) {
            QueryWrapper<ReturnDetail> qw = new QueryWrapper<>();
            qw.eq("id",id);
            if (categoryId!=0&&!names.equals("")){
                qw.eq("categoryId",categoryId).like("name",names);
            } else if (categoryId!=0&& names.equals("")) {
                qw.eq("categoryId",categoryId);
            } else if (categoryId==0&&!names.equals("")) {
                qw.like("name",names);
            }
            List<ReturnDetail> returnList = returnDetailDAO.selectList(qw);
            result.CompareList(returnList);
        }else if (name.equals("storehouse")) {
            QueryWrapper<Storehouse> qw = new QueryWrapper<>();
            if (categoryId!=0&&!names.equals("")){
                qw.eq("categoryId",categoryId).like("name",names);
            } else if (categoryId!=0&& names.equals("")) {
                qw.eq("categoryId",categoryId);
            } else if (categoryId==0&&!names.equals("")) {
                qw.like("name",names);
            }
            List<Storehouse> storehouseList = storehouseDAO.selectList(qw);
            result.CompareList(storehouseList);
        }else if (name.equals("shop")) {
            QueryWrapper<Shop> qw = new QueryWrapper<>();
            if (categoryId!=0&&!names.equals("")){
                qw.eq("categoryId",categoryId).like("name",names);
            } else if (categoryId!=0&& names.equals("")) {
                qw.eq("categoryId",categoryId);
            } else if (categoryId==0&&!names.equals("")) {
                qw.like("name",names);
            }
            List<Shop> shops = shopDAO.selectList(qw);
            result.CompareList(shops);
        }
        else {
            result.False();
        }

        return result;
    }

//    确认审核
    @ResponseBody
    @PatchMapping("/update/true")
    public JsonResult updateOrderT(){

        JsonResult result = new JsonResult();
        if (name.equals("purchase")) {
            Purchase p = new Purchase();
            p.setPc("审核已通过");
            p.setId(id);
            int i = purchaseDAO.updateById(p);
            result.result(i);
        } else if (name.equals("back")) {
            Back back = new Back();
            back.setPc("审核通过");
            back.setId(id);
            int i = backDAO.updateById(back);
            result.result(i);
        } else if (name.equals("return")) {
            Return re = new Return();
            re.setPc("审核通过");
            re.setId(id);
            int i = returnDAO.updateById(re);
            result.result(i);
        }else {
            result.False();
        }
        return result;
    }

    @ResponseBody
    @PatchMapping("/update/false")
    public JsonResult updateOrderF(){
        JsonResult result = new JsonResult();
        if (name.equals("purchase")) {
            Purchase p = new Purchase();
            p.setPc("审核未通过");
            p.setId(id);
            int i = purchaseDAO.updateById(p);
            result.result(i);
        } else if (name.equals("back")) {
            Back back = new Back();
            back.setPc("审核未通过");
            back.setId(id);
            int i = backDAO.updateById(back);
            result.result(i);
        } else if (name.equals("return")) {
            Return re = new Return();
            re.setPc("审核未通过");
            re.setId(id);
            int i = returnDAO.updateById(re);
            result.result(i);
        }else {
            result.False();
        }
        return result;
    }

}
