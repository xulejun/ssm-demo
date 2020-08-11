package com.xlj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author XuLeJun
 * @Date 2020/6/28 18:36
 */

@Controller
public class VelocityController {
    @RequestMapping("velocity")
    public ModelAndView index(){
        String name = "XLJ";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        return modelAndView;
    }


}
