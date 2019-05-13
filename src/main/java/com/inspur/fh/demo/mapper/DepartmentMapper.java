package com.inspur.fh.demo.mapper;

import com.inspur.fh.demo.entities.Department;
import com.inspur.fh.demo.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author fh
 * @date 2019/3/11  8:57
 */
@Mapper
public interface DepartmentMapper extends MyMapper {

    /*查询所有部门*/
    @Select("select * from t_department")
    public List<Department> finddep ();

    @Select("select *  from  t_department where department_id = #{department_id}")
    public Department finddepbyid(int id);

    @Select("select * from t_department where department_name like CONCAT('%',#{department_name},'%')  ")
    public List<Department> findbydep1(String department_name);

    /*删除部门*/
    @Delete("delete from t_department where department_id=#{department_id}")
    public int deldep(int id);
    @Delete("delete from t_department where department_id=#{department_id}")
    public int delalldep(String department_id);

    /*更改部门*/
    @Update("update t_department set  department_name = #{department_name}, manager = #{manager} where department_id = #{department_id} ")
    public int updatebydep(Department department);

    /*增加部门*/
    @Insert("insert into t_department(department_id,department_name,manager) values (#{department_id},#{department_name},#{manager}) ")
    public int adddep(Department department);
}
