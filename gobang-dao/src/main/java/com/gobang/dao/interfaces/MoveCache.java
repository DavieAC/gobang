package com.gobang.dao.interfaces;

import com.gobang.domain.ai.Move;

/**
 * 落子缓存，用于保留某个局面的
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月23日 下午10:15:11
 */
public interface MoveCache {

    /**
     * 获得这个局面对应的缓存数据
     * 
     * @param chessInfo
     * @return 已经计算过的move null 如果没有缓存
     */
    public Move getCacheMove(int[][] chessInfo);

    /**
     * 写入缓存
     * 
     * @param chessInfo
     * @param x
     * @param y
     * @return
     */
    public Boolean setCacheMove(int[][] chessInfo, int x, int y);

}

