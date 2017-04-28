package com.gobang.dao.cachedmove.interfaces;

import java.util.List;

import com.gobang.domain.ai.CachedMove;

/**
 * 落子缓存的mapper
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月26日 下午8:19:44
 */
public interface CachedMoveDao {

    /**
     * 通过一个id获取一个落子缓存
     * 
     * @param id
     * @return
     */
    public CachedMove getCachedMoveByID(int id);

    /**
     * 通过一个棋局的HashCode获得落子缓存
     * 
     * @param hashcode
     * @return
     */
    public List<CachedMove> getCachedMoveByHashcode(String hashcode);

    /**
     * 插入一个落子缓存到数据库中
     * 
     * @param cachedMove
     */
    public void insertCachedMove(CachedMove cachedMove);

    /**
     * 更新一个落子缓存到数据库
     * 
     * @param cachedMove
     */
    public void updateCachedMove(CachedMove cachedMove);

    /**
     * 删除一个落子缓存到数据库
     * 
     * @param cachedMove
     */
    public void deleteCachedMove(CachedMove cachedMove);

    /**
     * 计算数据库中目前有多少缓存
     * 
     * @param cachedMove
     * @return
     */
    public int countCachedMove();

}
