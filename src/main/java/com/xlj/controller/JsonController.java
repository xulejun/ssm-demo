package com.xlj.controller;

import com.alibaba.fastjson.JSONObject;
import com.xlj.bean.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/27 14:43
 */

@Controller
@RequestMapping("")
public class JsonController {

    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submit(@RequestBody Category category) {
        System.out.println(11111);
        System.out.println("SSM接收到浏览器提交的Json，并装换成Category对象：" + category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOne() {
        Category category = new Category();
        category.setId(100);
        category.setName("第100个分类");
        JSONObject json = new JSONObject();
        json.put("category", JSONObject.toJSON(category));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getMany() {
        List<Category> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setId(i);
            category.setName("第" + i + "个分类");
            list.add(category);
        }
        return JSONObject.toJSON(list).toString();
    }
}
