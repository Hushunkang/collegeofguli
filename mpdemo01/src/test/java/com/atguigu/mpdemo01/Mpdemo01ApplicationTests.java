package com.atguigu.mpdemo01;

import com.atguigu.mpdemo01.entity.User;
import com.atguigu.mpdemo01.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        user.setName("令狐冲");
        user.setAge(18);
        user.setEmail("linghuchong@atguigu.com");

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
        user.setAge(20);

        //手动设置时间值的方式
//        user.setUpdateTime(new Date());

        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    /**
     * 测试mybatis plus乐观锁插件，乐观锁一般用于解决“丢失更新问题”
     */
    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(1246381023311282178L);
        //修改数据
        user.setName("Helen");
        user.setEmail("helen@atguigu.com");
        //执行更新
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    //多个id批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        for (User user : users) {
            System.out.println(user);
        }
    }

    //多条件查询
    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Jone");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //分页查询
    @Test
    public void testSelectPage(){
        //创建Page对象，传入两个参数：当前页和每页显示的记录数
        Page<User> page = new Page<>(1,3);
        //调用mp分页查询过程中，底层封装，把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getPages()); //总页数
        System.out.println(page.getTotal()); //总记录数

        System.out.println(page.hasPrevious()); //有上一页吗
        System.out.println(page.hasNext()); //有下一页吗
    }

    //测试逻辑删除
    @Test
    public void testLogicDelete(){
        int rows = userMapper.deleteById(1246401524645609474L);
        System.out.println(rows);
    }

    //测试逻辑删除后的查询
    //如果使用spring boot配置了mybatis plus逻辑删除插件，mp底层（应该是拦截器）
    //最终拼接查询sql的时候会多带上一个“表示未删除的”查询条件

    //复杂查询操作
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过QueryWrapper设置条件
        //ge、gt、le、lt
        //查询age>=30记录
        //第一个参数设置字段名称，第二个参数设置字段值
        //wrapper.ge("age",30);

        //eq、ne
        //wrapper.eq("name","lilei");
        //wrapper.ne("name","lilei");

        //between
        //查询年龄20-30
        // wrapper.between("age",20,30);

        //like
        //wrapper.like("name","东");

        //orderByDesc
        // wrapper.orderByDesc("id");

        //last
        //wrapper.last("limit 1");

        //指定要查询的列
        wrapper.select("id","name");

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
