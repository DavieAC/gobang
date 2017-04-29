package com.gobang.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gobang.dao.cachedmove.interfaces.CachedMoveDao;
import com.gobang.domain.ai.CachedMove;

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

    private static final Logger logger = LoggerFactory.getLogger(DaoTest.class);

    @Resource
    private CachedMoveDao cachedMoveDao;

    @Test
    public void testInsert() {
        CachedMove move = new CachedMove();
        move.sethashcode("2222");
        move.setX(3);
        move.setY(7);
        cachedMoveDao.insertCachedMove(move);
    }

    @Test
    public void testDelete() {
        CachedMove cachedMove = new CachedMove();
        cachedMove.sethashcode("12345");
        cachedMove.setX(3);
        cachedMove.setY(7);
        cachedMoveDao.deleteCachedMove(cachedMove);
    }
    
    @Test
    public void testGetCachedMove() {
        CachedMove cachedMove = cachedMoveDao.getCachedMoveByID(3);
        logger.info(cachedMove.gethashcode() + "," + cachedMove.getX() + "," + cachedMove.getY());
    
        List<CachedMove> cachedMoves = cachedMoveDao.getCachedMoveByHashcode("123");
        logger.info(cachedMoves.get(0).gethashcode() + "," + cachedMoves.get(0).getX() + "," + cachedMoves.get(0).getY());
    }
    
    @Test
    public void testUpdateCachedMove() {
        CachedMove cachedMove = new CachedMove();//cachedMoveDao.getCachedMoveByID(3);
        cachedMove.setId(3);
        cachedMove.sethashcode("123");
        cachedMove.setX(123);
        cachedMove.setY(123);
        cachedMoveDao.updateCachedMove(cachedMove);
    }
    
    @Test
    public void testCountCachedMove() {
        logger.info(cachedMoveDao.countCachedMove() + "");
    }

    @Test
    public void testLog() {
        logger.info("testLog");
    }

}
