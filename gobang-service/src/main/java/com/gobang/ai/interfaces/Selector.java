package com.gobang.ai.interfaces;

/**
 * 选择器，负责递归计算当前最优落子提供给AI，用最大值最小值算法。底层用评估器进行评估。
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月20日  上午10:20:34
 */
public interface Selector {
    
    /**
     * 外部接口，通过这个直接获取最优落子
     * @param chessInfo
     * @return
     */
    public int getCurBestMove(int[][] chessInfo);

}
