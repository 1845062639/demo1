package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DAO.UserDAO;
import com.example.demo.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @PostMapping(value = "/login/in")
    public String logins(@RequestBody User user,
                         HttpServletResponse response) throws IOException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        int i = userDAO.selectCount(wrapper);
        if (i>0) {
            int j = userDAO.selectOne(wrapper).getId();
            String s = "";
            if (j==0){
                s="manage";
            } else if (j==1){
                return "buy";
            } else if (j==2) {
                return "storehouse";
            }
            response.getWriter().print(s);
            return null;
        }
        return "login";
    }
}

