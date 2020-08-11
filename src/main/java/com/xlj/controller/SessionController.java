package com.xlj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Author XuLeJun
 * @Date 2020/6/28 8:39
 */

@Controller
@RequestMapping("")
public class SessionController {

    // 利用session统计网页访问次数
    @RequestMapping("/check")
    public ModelAndView check(HttpSession httpSession) {
        Integer i = (Integer) httpSession.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        httpSession.setAttribute("count", i);
        ModelAndView modelAndView = new ModelAndView("check");
        return modelAndView;
    }

}
