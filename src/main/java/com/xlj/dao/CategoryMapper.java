package com.xlj.dao;

import com.xlj.bean.Category;

import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:27
 */

public interface CategoryMapper {

    public int add(Category category);

    public void delete(int id);

    public int update(Category category);

    public Category get(int id);

    public List<Category> list();

    public int count();
}
