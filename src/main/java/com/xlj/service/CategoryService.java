package com.xlj.service;

import com.xlj.bean.Category;

import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:43
 */

public interface CategoryService {

    void add(Category category);

    void delete(Category category);

    void update(Category category);

    Category get(int id);

    List<Category> list();

    // 测试事务的两个方法
    void deleteAll();
    void addTwo();
}
