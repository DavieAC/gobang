package com.gobang.ai.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.ChessAI;

public class ChessAIImpl implements ChessAI {

    private static final Logger logger = LoggerFactory.getLogger(ChessAIImpl.class);

    // 棋盘上的空格标志
    private static final int BLANK = 0;

    // 棋盘上的黑子标志
    private static final int BLACK = 1;

    // 棋盘上的白字标志
    private static final int WHITE = 2;

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
        return 0;
    }

    /**
     * 
     * 获得当前位置的横向连珠的状态码
     * 
     * @param chessInfo 当前棋盘的信息
     * @param x 当前位置X坐标
     * @param y 当前位置Y坐标
     * @return 一个状态吗，表示当前点的横向状态码:
     *         <li>0, 如果没有落子或者有两头都被堵死的又不是5子连珠的</li>
     *         <li>1, 断1</li>
     *         <li>2, 活1</li>
     *         <li>3, 断2</li>
     *         <li>4, 活2</li>
     *         <li>5, 断3</li>
     *         <li>6, 活4</li>
     *         <li>7, 断4</li>
     *         <li>8, 活4</li>
     *         <li>9, 5子连珠</li>
     */
    private int getHorizontalStatusCode(int[][] chessInfo, int x, int y) {

        // 先检查这个地方是否有棋子
        if (chessInfo[x][y] == BLANK) {
            return 0;
        }

        int maxLength = 1;
        boolean leftCut = false; // 左和右是相对的概念，其他方向的计算函数也用这个变量对
        boolean rightCut = false;
        int theOtherPlayer = getTheOtherPlayer(chessInfo[x][y]); // 获得当前位置落子方对手的状态码

        // 向左遍历
        for (int i = 1; i <= 4; i++) {
            if (y - i < 0 || chessInfo[x][y - i] == theOtherPlayer) { // 如果左边一位是对方棋子或者棋盘边缘
                leftCut = true;
                break;
            } else if (chessInfo[x][y - i] == BLANK) { // 如果左边一位的棋子是空
                break;
            }
            maxLength++;
        }
        // 向右遍历
        for (int i = 1; i <= 4; i++) {
            if (y + i > 14 || chessInfo[x][y + i] == theOtherPlayer) { // 如果左边一位是对方棋子或者棋盘边缘
                rightCut = true;
                break;
            } else if (chessInfo[x][y + i] == BLANK) { // 如果左边一位的棋子是空
                break;
            }
            maxLength++;
        }

        // 计算状态码
        return getStatusCode(leftCut, rightCut, maxLength);
    }

    /**
     * 获得纵向的连珠数状态码
     */
    private int getVerticalStatusCode(int[][] chessInfo, int x, int y) {

        // 先检查这个地方是否有棋子
        if (chessInfo[x][y] == BLANK) {
            return 0;
        }

        int maxLength = 1;
        boolean leftCut = false; // 左和右是相对的概念，其他方向的计算函数也用这个变量对
        boolean rightCut = false;
        int theOtherPlayer = getTheOtherPlayer(chessInfo[x][y]); // 获得当前位置落子方对手的状态码

        // 向上遍历
        for (int i = 1; i <= 4; i++) {
            if (x - i < 0 || chessInfo[x - i][y] == theOtherPlayer) {
                leftCut = true;
                break;
            } else if (chessInfo[x - i][y] == BLANK) {
                break;
            }
            maxLength++;
        }
        // 向下遍历
        for (int i = 1; i <= 4; i++) {
            if (x + i > 14 || chessInfo[x + i][y] == theOtherPlayer) {
                rightCut = true;
                break;
            } else if (chessInfo[x + i][y] == BLANK) {
                break;
            }
            maxLength++;
        }

        // 计算状态码
        return getStatusCode(leftCut, rightCut, maxLength);
    }

    /**
     * 撇方向的状态码
     */
    private int getLeftFallingStatusCode(int[][] chessInfo, int x, int y) {

        // 先检查这个地方是否有棋子
        if (chessInfo[x][y] == BLANK) {
            return 0;
        }

        int maxLength = 1;
        boolean leftCut = false; // 左和右是相对的概念，其他方向的计算函数也用这个变量对
        boolean rightCut = false;
        int theOtherPlayer = getTheOtherPlayer(chessInfo[x][y]); // 获得当前位置落子方对手的状态码

        // 向右上遍历
        for (int i = 1; i <= 4; i++) {
            if (x - i < 0 || y + i > 14 || chessInfo[x - i][y + i] == theOtherPlayer) {
                leftCut = true;
                break;
            } else if (chessInfo[x - i][y + i] == BLANK) {
                break;
            }
            maxLength++;
        }
        // 向左下遍历
        for (int i = 1; i <= 4; i++) {
            if (x + i > 14 || y - i < 0 || chessInfo[x + i][y - i] == theOtherPlayer) {
                rightCut = true;
                break;
            } else if (chessInfo[x + i][y - i] == BLANK) {
                break;
            }
            maxLength++;
        }

        // 计算状态码
        return getStatusCode(leftCut, rightCut, maxLength);
    }

    /**
     * 获得捺方向的状态码
     */
    private int getRightFallingStatusCode(int[][] chessInfo, int x, int y) {

        // 先检查这个地方是否有棋子
        if (chessInfo[x][y] == BLANK) {
            return 0;
        }

        int maxLength = 1;
        boolean leftCut = false; // 左和右是相对的概念，其他方向的计算函数也用这个变量对
        boolean rightCut = false;
        int theOtherPlayer = getTheOtherPlayer(chessInfo[x][y]); // 获得当前位置落子方对手的状态码

        // 向左上遍历
        for (int i = 1; i <= 4; i++) {
            if (x - i < 0 || y - i < 0 || chessInfo[x - i][y - i] == theOtherPlayer) {
                leftCut = true;
                break;
            } else if (chessInfo[x - i][y - i] == BLANK) {
                break;
            }
            maxLength++;
        }
        // 向右下遍历
        for (int i = 1; i <= 4; i++) {
            if (x + i > 14 || y + i > 14 || chessInfo[x + i][y + i] == theOtherPlayer) {
                rightCut = true;
                break;
            } else if (chessInfo[x + i][y + i] == BLANK) {
                break;
            }
            maxLength++;
        }

        // 计算状态码
        return getStatusCode(leftCut, rightCut, maxLength);
    }

    /**
     * 获得当前位置当前方向的状态码
     */
    private int getStatusCode(boolean leftCut, boolean rightCut, int maxLength) {

        if ((leftCut & rightCut) && maxLength < 5) {
            return 0;
        }

        switch (maxLength) {
            case 1: {
                return leftCut | rightCut ? 1 : 2;
            }
            case 2: {
                return leftCut | rightCut ? 3 : 4;
            }
            case 3: {
                return leftCut | rightCut ? 5 : 6;
            }
            case 4: {
                return leftCut | rightCut ? 7 : 8;
            }
            default: {
                return 9;
            }
        }
    }

    /**
     * 获得对手的状态吗，外部保证绝不传入除了1，2之外的数字
     * 
     * @param player
     * @return
     */
    private int getTheOtherPlayer(int player) {
        if (player != 1 && player != 2) {
            logger.error("获得对手方状态码失败,palyer:{}", player);
            return 0;
        }
        return player == 1 ? 2 : 1;
    }

}
