package com.shsxt.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseQuery;
import com.shsxt.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xlf on 2019/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void queryUserById() throws Exception {
        User user = userService.queryById(6);
        System.out.println(user);
    }

    @Test
    public void queryUserById02() throws Exception {
        User user1 = new User();
        user1.setId(114);
        user1.setUserName("spring mybatis");
        userService.update(user1);
    }

    @Test
    public void queryUserById03() throws Exception {
        userService.delete(114);
    }

    @Test
    public void queryUserById04() throws Exception {
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNum(1);
        baseQuery.setPageSize(5);

        PageInfo<User> pageInfo = userService.queryForPage(baseQuery);
        pageInfo.getList().stream().forEach(System.out::println);
    }



}