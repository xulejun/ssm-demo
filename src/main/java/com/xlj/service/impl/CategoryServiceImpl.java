package com.xlj.service.impl;

import com.xlj.dao.CategoryMapper;
import com.xlj.bean.Category;
import com.xlj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:47
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void delete(Category category) {
        categoryMapper.delete(category.getId());
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }


    // 实现事务测试的方法
    @Override
    public void deleteAll() {
        List<Category> list = list();
        for (Category category : list) {
            categoryMapper.delete(category.getId());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public void addTwo() {
        Category category1 = new Category();
        category1.setName("短的名字");
        categoryMapper.add(category1);

        Category category2 = new Category();
        category2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(category2);
    }
}
