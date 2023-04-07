package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){

        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("manage");
                registry.addViewController("ajax.html").setViewName("ajax");
                registry.addViewController("login.html").setViewName("login");
//                管理
                registry.addViewController("manage.html").setViewName("manage");
                registry.addViewController("purchase.html").setViewName("manage/purchase");
                registry.addViewController("purchaseDetail.html").setViewName("manage/purchaseDetail");
                registry.addViewController("storehouse.html").setViewName("manage/storehouse");
                registry.addViewController("shop.html").setViewName("manage/shop");


            }
        };

        return adapter;
    }
}