package com.gobang.ai.interfaces;

import com.gobang.domain.ai.Move;

public interface ChessAI {

    /**
     * 计算一个最佳落子
     * 
     * @param chessInfo 当前棋盘的信息
     * @return 一个最佳落子 x * 100 + y
     */
    public Move getAIMove(int[][] chessInfo);


}
