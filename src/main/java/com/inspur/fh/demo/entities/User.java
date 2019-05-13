package com.inspur.fh.demo.entities;
/**
 * @author fh
 * @date 2019/3/8  10:57
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String account;
    private String password;
    private String  name;
    private String department;
    private String sex;
    private Date birthday;
    private  String mobile;
    private String email ;
    private  String User_type;
    private  String mylevel;
    private  Date create_time;
    private  String state;

}
