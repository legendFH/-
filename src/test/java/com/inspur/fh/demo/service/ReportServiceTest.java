package com.inspur.fh.demo.service;

import com.inspur.fh.demo.entities.Report;
import com.inspur.fh.demo.mapper.ReportMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author fh
 * @date 2019/4/22  15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTest {
    @Autowired
    ReportMapper reportMapper;
    @Test
    public void findrep() {
        Report report = reportMapper.findrepbyid(1);
        Assert.assertEquals(1,report.getReport_id());

    }

    @Test
    public void findrepbyid() {
    }

    @Test
    public void findbyrep1() {
    }

    @Test
    public void delrep() {
    }

    @Test
    public void updatebyrep() {
    }

    @Test
    public void addrep() {
    }
}