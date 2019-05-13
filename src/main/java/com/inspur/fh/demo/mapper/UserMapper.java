package com.inspur.fh.demo.mapper;
/**
 * @author fh
 * @date 2019/3/09  9:57
 */
import com.inspur.fh.demo.entities.Department;
import com.inspur.fh.demo.entities.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.sql.Date;
import java.util.List;
@Component
@Mapper
public interface UserMapper {
    /*登陆查找接口*/
    @Select("select * from t_user_info where name = #{param1} and password = #{param2}")
    public User findByip(String account, String password);

    /*查找所有用户接口*/
    @Select("select * from t_user_info")
    public List<User> findAlluser();

    /*登录接口*/
    @Select("select *  from  t_user_info where id = #{id}")
    public User findbyid(int id);

    /*添加用户*/
    @Insert("insert into t_user_info(account,password,name,department,sex,mobile,birthday,email) values (#{account},#{password},#{name},#{department},#{sex},#{mobile},#{birthday},#{email})")
    public int addUser(User user);

    /*删除用户接口*/
    @Delete("delete from  t_user_info where id = #{id}")
    public int deleteByID(int id);
    @Delete("delete from  t_user_info where account = #{account}")
    public int deleteByaccount(String account);

    /*更新用户接口 直接User user*/
    @Update("update t_user_info set password = #{password},name= #{name},department = #{department},sex=#{sex},mobile=#{mobile},birthday = #{birthday},email=#{email} where account=#{account}")
    public int updateByid(String account, String password, String name, String department, String sex, String mobile, Date birthday, String email);

    /*查找用户接口*/
    @Select("select * from t_user_info where name like CONCAT('%',#{name},'%')  ")
    public List<User> findbyname(String name);

    @Select("select * from t_user_info where department like CONCAT('%',#{department},'%')  ")
    public List<User> findbydep(String department);

    @Select("select * from t_user_info where  name like CONCAT('%',#{name},'%') and department like CONCAT('%',#{department},'%') ")
    public List<User> findbydepname(String name, String department);


  /*  @Options(useGeneratedKeys = true,keyProperty = "id") //对自增主键的自动封装
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department department);*/



}
