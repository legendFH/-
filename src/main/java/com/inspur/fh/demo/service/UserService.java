package com.inspur.fh.demo.service;

import com.inspur.fh.demo.entities.User;
import com.inspur.fh.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
/*@CacheConfig(cacheNames = {"user"})*/
@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /*登陆查找*/
    public User findByip(String name, String password) {
        return userMapper.findByip(name, password);
    }

    /*查找所有用户*/
    /*@Cacheable(key = "#id")*/
    public User findbyid(int id) {
        return userMapper.findbyid(id);
    }
//   @Cacheable(key = "234")
    public List<User> findAlluser() {
        return userMapper.findAlluser();
    }
    //返回的集合故不能用result.id 取  key值可随意设定

    /*增加新用户*/
    /*@CachePut(key = "234")*/
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /*删除用户*/
   /* @CacheEvict(*//*cacheNames = {"user"},*//*key = "234")*/
    public int deleteByID(int id) {
        return userMapper.deleteByID(id);
    }
    public int deleteByaccount(String account){
        return  userMapper.deleteByaccount(account);
    };

    /*更新用户*/
    public int updateByid(String account, String password, String name, String department, String sex, String mobile, Date birthday, String email) {
        return userMapper.updateByid(account, password, name, department, sex, mobile, birthday, email);
    }




    /*查找用户*/
    /*@Caching(
            cacheable = {
                    @Cacheable(key = "234")
            },
            put = {
                    @CachePut(key = "234")
            }
    )*/
    public List<User> findbyname(String name) {
        return userMapper.findbyname(name);
    }

    public List<User> findbydep(String department) {
        return userMapper.findbydep(department);
    }

    public List<User> findbydepname(String name, String department) {
        return userMapper.findbydepname(name, department);
    }

    ;

}

