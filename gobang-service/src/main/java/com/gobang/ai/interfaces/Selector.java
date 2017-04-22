package com.gobang.ai.interfaces;

import com.gobang.domain.ai.Move;

/**
 * 选择器，负责递归计算当前最优落子提供给AI，用最大值最小值算法。底层用评估器进行评估。
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月20日 上午10:20:34
 */
public interface Selector {

    /**
     * Max方法，在博弈树中寻找Max层的最优落子
     * 
     * @param chessInfo 当前的棋局
     * @param count 递归层数
     * @return Move对象，表示了最优落子
     */
    public Move getMaxScore(int[][] chessInfo, int count);

    /**
     * Min方法，在博弈树中寻找Min层最优落子
     * 
     * @param chessInfo 当前的棋局
     * @param count 递归层数
     * @return Move对象，表示了最优落子
     */
    public Move getMinScore(int[][] chessInfo, int count);

}
