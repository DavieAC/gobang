package com.gobang.ai.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.interfaces.Evaluator;
import com.gobang.ai.interfaces.StatusCodeAnalyzer;
import com.gobang.constant.Constant;
import com.gobang.tools.ArrayTool;

public class EvaluatorImpl implements Evaluator {

    private static final Logger logger = LoggerFactory.getLogger(EvaluatorImpl.class);

    @Resource
    private StatusCodeAnalyzer StatusCodeAnalyzer;

    @Override
    public boolean isWin(int[][] chessInfo, int player) {
        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                if (chessInfo[i][j] == player) {
                    if (StatusCodeAnalyzer.getHorizontalStatusCode(chessInfo, i, j) == 9
                            || StatusCodeAnalyzer.getVerticalStatusCode(chessInfo, i, j) == 9
                            || StatusCodeAnalyzer.getLeftFallingStatusCode(chessInfo, i, j) == 9
                            || StatusCodeAnalyzer.getRightFallingStatusCode(chessInfo, i, j) == 9) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean isWinWith(int[][] chessInfo, int player, int x, int y) {
        
        int[][] newChessInfo = ArrayTool.copyOf(chessInfo);
        
        newChessInfo[x][y] = player;
        
        return isWin(newChessInfo, player);
    }

    @Override
    public int getAllScore(int[][] chessInfo) {

        if (chessInfo == null) {
            logger.error("计算棋局分数失败，入参为null");
            return -1;
        }

        int result = 0;

        // 遍历整个棋盘，黑子为正，白字为负
        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                if (chessInfo[i][j] == Constant.BLACK) {
                    result += getScore(chessInfo, i, j);
                } else if (chessInfo[i][j] == Constant.WHITE) {
                    result -= getScore(chessInfo, i, j);
                }
            }
        }

        return result;
    }

    @Override
    public int getScore(int[][] chessInfo, int x, int y) {

        int result = 0;

        if (chessInfo[x][y] == Constant.BLANK) {
            return result;
        }

        result += translateStatusCodeToScore(StatusCodeAnalyzer.getHorizontalStatusCode(chessInfo, x, y));

        result += translateStatusCodeToScore(StatusCodeAnalyzer.getVerticalStatusCode(chessInfo, x, y));

        result += translateStatusCodeToScore(StatusCodeAnalyzer.getLeftFallingStatusCode(chessInfo, x, y));

        result += translateStatusCodeToScore(StatusCodeAnalyzer.getRightFallingStatusCode(chessInfo, x, y));

        return result;
    }

    private int translateStatusCodeToScore(int code) {
        switch (code) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 10;
            }
            case 3: {
                return 10;
            }
            case 4: {
                return 100;
            }
            case 5: {
                return 100;
            }
            case 6: {
                return 1000;
            }
            case 7: {
                return 1000;
            }
            case 8: {
                return 10000;
            }
            case 9: {
                return 100000;
            }
            default: {
                return -1;
            }
        }
    }

}
