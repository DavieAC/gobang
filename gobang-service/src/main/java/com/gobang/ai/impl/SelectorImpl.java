package com.gobang.ai.impl;

import javax.annotation.Resource;

import com.gobang.ai.interfaces.Evaluator;
import com.gobang.ai.interfaces.MovePicker;
import com.gobang.ai.interfaces.Selector;
import com.gobang.constant.Constant;
import com.gobang.domain.ai.Move;
import com.gobang.tools.ArrayTool;

/**
 * max层计算黑子，min层计算白子
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月21日 上午11:11:32
 */
public class SelectorImpl implements Selector {

    @Resource
    private Evaluator evaluator;

    @Resource
    private MovePicker movePicker;

    @Override
    public Move getMaxScore(int[][] chessInfo, int count) {

        // 用来记录当前层的最佳落子
        Move curBestMove = new Move();

        // 如果计算到最后一层（此时没有x坐标和y坐标）
        if (count == 0) {
            return curBestMove.setScore(evaluator.getAllScore(chessInfo));
        }

        int curMaxScore = Integer.MIN_VALUE;

        // 新的棋局
        int[][] newChessInfo = ArrayTool.copyOf(chessInfo);
        // 开始遍历所有有意义的落子,往下层递归
        for (Move move : movePicker.getValuableMove(newChessInfo)) {

            // 在新的棋局上落子
            newChessInfo[move.getX()][move.getY()] = Constant.BLACK;

            Move nextBesMove = getMinScore(newChessInfo, count - 1);
            if (nextBesMove.getScore() > curMaxScore) {
                curMaxScore = nextBesMove.getScore();

                curBestMove.setX(move.getX());
                curBestMove.setY(move.getY());
                curBestMove.setScore(nextBesMove.getScore());
            }

            // 还原
            newChessInfo[move.getX()][move.getY()] = Constant.BLANK;
        }
        return curBestMove;
    }

    @Override
    public Move getMinScore(int[][] chessInfo, int count) {

        // 用来记录当前层的最佳落子
        Move curBestMove = new Move();

        // 如果计算到最后一层（此时没有x坐标和y坐标）
        if (count == 0) {
            return curBestMove.setScore(evaluator.getAllScore(chessInfo));
        }

        int curMinScore = Integer.MAX_VALUE;

        // 新的棋局
        int[][] newChessInfo = ArrayTool.copyOf(chessInfo);
        // 开始遍历所有有意义的落子,往下层递归
        for (Move move : movePicker.getValuableMove(newChessInfo)) {

            // 在新的棋局上落子
            newChessInfo[move.getX()][move.getY()] = Constant.WHITE;

            Move nextBesMove = getMaxScore(newChessInfo, count - 1);
            if (nextBesMove.getScore() < curMinScore) {
                curMinScore = nextBesMove.getScore();

                curBestMove.setX(move.getX());
                curBestMove.setY(move.getY());
                curBestMove.setScore(nextBesMove.getScore());
            }

            // 还原
            newChessInfo[move.getX()][move.getY()] = Constant.BLANK;
        }
        return curBestMove;
    }


}
