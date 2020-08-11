package com.xlj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlj.bean.Category;
import com.xlj.service.CategoryService;
import com.xlj.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:48
 */


@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // 分页展示category数据
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public ModelAndView listCategory(PageUtil pageUtil) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.offsetPage(pageUtil.getStart(), 5);
        List<Category> list = categoryService.list();
        int total = (int) new PageInfo<>(list).getTotal();
        //计算末页数
        pageUtil.caculateLast(total);

        // 传参到页面上
        modelAndView.addObject("list", list);
        // 放入jsp路径
        modelAndView.setViewName("listCategory");
        return modelAndView;
    }

    // 添加category
    @RequestMapping(value = "/categories",method = RequestMethod.POST)
    public ModelAndView addCategory(Category category){
        categoryService.add(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        return modelAndView;
    }

    // 删除category
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteCategory(Category category){
        categoryService.delete(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        return modelAndView;
    }

    //
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.PUT)
    public ModelAndView updateCategory(Category category){
        categoryService.update(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        return modelAndView;
    }

    @RequestMapping(value = "/categories/{id}",method = RequestMethod.GET)
    public ModelAndView editCategory(Category category){
        Category c = categoryService.get(category.getId());
        ModelAndView modelAndView = new ModelAndView("editCategory");
        modelAndView.addObject("c",c);
        return modelAndView;
    }
}
