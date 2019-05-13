package com.inspur.fh.demo.mapper;

import com.inspur.fh.demo.entities.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author fh
 * @date 2019/3/11  15:31
 */
@Mapper
public interface ReportMapper {
    /*查询所有日报*/
    @Select("select * from t_report_record")
    public List<Report> findrep ();

    @Select("select *  from  t_report_record where report_id = #{report_id}")
    public Report findrepbyid(int id);

    @Select("select * from t_report_record where report_name like CONCAT('%',#{report_name},'%')  ")
    public List<Report> findbyrep1(String report_name);

    /*删除日报*/
    @Delete("delete from t_report_record where report_id=#{report_id}")
    public int delrep(int id);

    /*更改日报*/
    @Update("update t_report_record set report_date = #{report_date},work_process= #{work_process},work_content = #{work_content},tomorrow_plan=#{tomorrow_plan},problem=#{problem},other = #{other} where report_name=#{report_name}")
    public int updatebyrep(Report report);

    /*增加部门*/
    @Insert("insert into t_report_record(report_name,report_date,work_process,work_content,tomorrow_plan,problem,other) values (#{report_name},#{report_date},#{work_process},#{work_content},#{tomorrow_plan},#{problem},#{other}) ")
    public int addrep(Report report);

}
