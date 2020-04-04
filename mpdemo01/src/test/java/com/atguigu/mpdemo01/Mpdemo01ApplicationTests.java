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

}
