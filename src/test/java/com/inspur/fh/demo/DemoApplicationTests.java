package com.inspur.fh.demo;

import com.inspur.fh.demo.entities.User;
import com.inspur.fh.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<Object, User> userRedisTemplate;
/*
    @Test*/
/*    public void contextLoads() {
        User userid = userMapper.findbyid(1);
      //将数据以json的方式保存
        //1 自己将对象转为json
        //2 redistemplate 默认的序列化规则 改变默认的序列化规则

       userRedisTemplate.opsForValue().set("user01",userid);
    }*/

}
