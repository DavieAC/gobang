package com.gobang.ai.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.interfaces.ChessManScoreAnalyzer;
import com.gobang.ai.interfaces.ChessManStatusCodeAnalyzer;
import com.gobang.constant.Constant;

public class ChessManScoreAnalyzerImpl implements ChessManScoreAnalyzer {

    private static final Logger logger = LoggerFactory.getLogger(ChessManScoreAnalyzerImpl.class);

    @Resource
    private ChessManStatusCodeAnalyzer chessManStatusCodeAnalyzer;

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

        result += translateStatusCodeToScore(
                chessManStatusCodeAnalyzer.getHorizontalStatusCode(chessInfo, x, y));

        result +=
                translateStatusCodeToScore(chessManStatusCodeAnalyzer.getVerticalStatusCode(chessInfo, x, y));

        result += translateStatusCodeToScore(
                chessManStatusCodeAnalyzer.getLeftFallingStatusCode(chessInfo, x, y));

        result += translateStatusCodeToScore(
                chessManStatusCodeAnalyzer.getRightFallingStatusCode(chessInfo, x, y));

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
