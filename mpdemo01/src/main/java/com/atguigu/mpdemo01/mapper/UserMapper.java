package com.atguigu.mpdemo01.mapper;

import com.atguigu.mpdemo01.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月04日
 */
@Repository//不加这个注解也能运行，因为底层这个玩意已经在spring ioc容器里面啦，关键点是@MapperScan这个注解！！！
//加这个只是为了spring boot测试类里面@Autowired注入UserMapper不报错
public interface UserMapper extends BaseMapper<User> {
}
