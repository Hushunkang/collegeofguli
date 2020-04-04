package com.atguigu.mpdemo01.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月04日 14时58分39秒
 */
@Data
public class User {

    //设置主键生成策略
    //@TableId(type = IdType.ID_WORKER) //mp自带策略，生成19位值，数字类型使用这种策略，比如Long
    //@TableId(type = IdType.ID_WORKER_STR) //mp自带策略，生成19位值，字符串类型使用这种策略
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //表中字段create_time，使用驼峰映射的规范
    private Date createTime;
    //表中字段update_time，使用驼峰映射的规范
    private Date updateTime;



}
