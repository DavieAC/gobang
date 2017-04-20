package com.gobang.ai.interfaces;

/**
 * 评估器，用于计算单个落子和局面的相对分数
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月19日 下午9:21:43
 */
public interface Evaluator {

    /**
     * 计算单个落子的分数
     * 
     * @param chessInfo
     * @param x
     * @param y
     * @return
     */
    public int getScore(int[][] chessInfo, int x, int y);

    /**
     * 获得全部的分数
     * 
     * @param chessInfo
     * @return
     */
    public int getAllScore(int[][] chessInfo);

}
