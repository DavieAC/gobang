package com.gobang.ai.interfaces;

public interface ChessAI {
    
    /**
     * 计算一个最佳落子
     * @param chessInfo 当前棋盘的信息
     * @return 一个最佳落子 x * 100 + y
     */
    public int getAIMove(int[][] chessInfo);
    
}
