package com.gobang.dao.cachedmove.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.dao.cachedmove.interfaces.CachedMoveDao;
import com.gobang.domain.ai.CachedMove;

public class CachedMoveDaoImpl implements CachedMoveDao {

    private static final Logger logger = LoggerFactory.getLogger(CachedMoveDaoImpl.class);

    @Resource
    protected SqlSession sqlSession;

    @Override
    public CachedMove getCachedMoveByID(int id) {
        try {
            return sqlSession.selectOne("CachedMove.getCachedMoveByID", id);
        } catch (Exception e) {
            logger.error("通过ID查找落子缓存DAO层查询失败,e:{}", e);
            return null;
        }
    }

    @Override
    public List<CachedMove> getCachedMoveByHashcode(String hashcode) {
        try {
            return sqlSession.selectList("CachedMove.getCachedMoveByHashcode", hashcode);
        } catch (Exception e) {
            logger.error("通过Hashcode查找落子缓存DAO层查询失败,e:{}", e);
            return null;
        }
    }

    @Override
    public void insertCachedMove(CachedMove cachedMove) {
        try {
            sqlSession.insert("CachedMove.insertCachedMove", cachedMove);
        } catch (Exception e) {
            logger.error("插入落子缓存DAO层失败,e:{}", e);
        }
    }

    @Override
    public void updateCachedMove(CachedMove cachedMove) {
        try {
            sqlSession.update("CachedMove.updateCachedMove", cachedMove);
        } catch (Exception e) {
            logger.error("更新落子缓存DAO层失败,e:{}", e);
        }
    }

    @Override
    public void deleteCachedMove(CachedMove cachedMove) {
        try {
            sqlSession.delete("CachedMove.deleteCachedMove", cachedMove);
        } catch (Exception e) {
            logger.error("删除落子缓存DAO层失败,e:{}", e);
        }
    }

    @Override
    public int countCachedMove() {
        try {
            return sqlSession.selectOne("CachedMove.countCachedMove");
        } catch (Exception e) {
            return -1;
        }
    }

}
