package com.md.iyou.webapp.controller.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 马东 on 2019/1/19.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 14:54 2019/1/19
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Configuration
public class ConfigMvc implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/add").setViewName("/add");
    }
}
