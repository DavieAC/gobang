package com.gobang.ai.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.interfaces.ChessAI;


public class ChessAIImpl implements ChessAI {

    private static final Logger logger = LoggerFactory.getLogger(ChessAIImpl.class);

    @Override
    public int getAIMove(int[][] chessInfo) {
        return 0;
    }

    /**
     * 获得当前的局面评估函数的结果
     * 
     * @return
     */
    private int getCurScore() {
        return 0;
    }

    /**
     * 获得一个位置上的分数
     * 
     * @param chessInfo 要计算的棋盘信息
     * @param x 当前位置的x坐标
     * @param y 当前位置的y坐标
     * @return 分数
     */
    private int getMaxLength(int[][] chessInfo, int x, int y) {

        if (chessInfo == null) {
            logger.error("计算{},{}位置分数失败,chessInfo为null", x, y);
        }

        return 0;
    }


}
