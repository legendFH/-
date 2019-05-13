package com.inspur.fh.demo.entities;
/**
 * @author fh
 * @date 2019/3/11  8:57
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
   private String department_id;
   private String department_name;
   private String manager;
   private  int total_user;
   private Date create_time;

}
