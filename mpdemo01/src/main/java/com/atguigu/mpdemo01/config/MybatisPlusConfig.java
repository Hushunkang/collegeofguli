package com.atguigu.mpdemo01.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月04日
 */
@Configuration
@MapperScan("com.atguigu.mpdemo01.mapper")
public class MybatisPlusConfig {

    //mybatis plus乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //mybatis plus分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //mybatis plus逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * mybatis plus sql执行性能分析插件
     * 开发环境使用，线上不推荐使用
     *
     * mp内置sql执行性能分析插件：可输出sql语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
     *
     * 三种环境
     * dev：开发环境
     * test：测试环境
     * prod：生产环境
     */
    @Bean
    @Profile({"dev","test"})//设置dev、test环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //maxTime指的是sql最大执行时长
        performanceInterceptor.setMaxTime(200);//单位ms，sql执行时间超过此处设置的ms数将不执行
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

}
