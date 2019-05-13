package com.inspur.fh.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author fh
 * @date 2019/3/12  10:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private  int report_id;
    private String report_name;
    private String account;
    private Date report_date;
    private  String work_process;
    private  String work_content;
    private  String tomorrow_plan;
    private  String problem;
    private  String other;

}
