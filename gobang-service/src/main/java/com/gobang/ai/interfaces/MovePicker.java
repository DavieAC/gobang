package com.gobang.ai.interfaces;

import java.util.ArrayList;

import com.gobang.domain.ai.Move;

/**
 * 落子选择器，用于在所有可能的落子中挑选有意义的那些，也就是周伟有黑子或者白子的那些位置，挑选的结果供selector选择
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月21日 上午10:25:40
 */
public interface MovePicker {

    /**
     * 返回有意思需要计算权重的落子
     * @param chessInfo
     * @return
     */
    public ArrayList<Move> getValuableMove(int[][] chessInfo);

}
