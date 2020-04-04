package com.atguigu.mpdemo01;

import com.atguigu.mpdemo01.entity.User;
import com.atguigu.mpdemo01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mpdemo01ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询user表中所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //添加操作
    @Test
    public void addUser(){
        User user = new User();
        user.setName("Tom");
        user.setAge(18);
        user.setEmail("tom@atguigu.com");

        //手动设置时间值的方式
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int rows = userMapper.insert(user);
        System.out.println(rows);//输出影响的行数
    }

    //修改操作
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(2L);
        user.setAge(30);

        //手动设置时间值的方式
//        user.setUpdateTime(new Date());

        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

}
