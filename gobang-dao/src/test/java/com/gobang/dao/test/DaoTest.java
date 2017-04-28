package com.gobang.dao.test;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gobang.dao.cachedmove.interfaces.CachedMoveDao;



/**
 * Dao层测试类
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月26日 下午9:00:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dao-test.xml")
public class DaoTest {
    
    private static Log log = LogFactory.getLog(DaoTest.class);
    
    @Resource
    private CachedMoveDao cachedMoveDao;
    
    @Test
    public void testInsert() {
        log.info("开始测试");
        log.info("测试结束");
    }
    
    @Test
    public void testLog() {
        log.info("测试日志");
    }

}
