package com.xlj.test;

import com.xlj.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author XuLeJun
 * @Date 2020/6/27 13:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testAddTwo(){
//        categoryService.addTwo(); // 测试执行报错，字符太长，无法添加
        categoryService.deleteAll();
    }

}
