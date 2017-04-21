package com.gobang.ai.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.gobang.ai.interfaces.Evaluator;
import com.gobang.ai.interfaces.MovePicker;
import com.gobang.ai.interfaces.Selector;
import com.gobang.constant.Constant;
import com.gobang.domain.ai.BestMove;
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
    public int getCurBestMove(int[][] chessInfo) {
        return 0;
    }

    private BestMove getMaxScore(int[][] chessInfo, int count) {

        // 用来记录当前层的最佳落子
        BestMove curBestMove = new BestMove();

        // 如果计算到最后一层（此时没有x坐标和y坐标）
        if (count == 0) {
            return curBestMove.setScore(evaluator.getAllScore(chessInfo));
        }

        int curMaxScore = -1;

        // 开始遍历所有有意义的落子
        ArrayList<Move> moves = movePicker.getValuableMove(chessInfo);
        for (Move move : moves) {
            int[][] newChessInfo = ArrayTool.copyOf(chessInfo);
            newChessInfo[move.getX()][move.getY()] = Constant.BLACK;
            int score = evaluator.getAllScore(newChessInfo);
            if (score > curMaxScore) {
                curBestMove.setX(move.getX());
                curBestMove.setY(move.getY());
                curBestMove.setScore(score);
            }
        }
        return curBestMove;
    }

    private BestMove getMinScore(int[][] chessInfo, int count) {

        // 用来记录当前层的最佳落子
        BestMove curBestMove = new BestMove();

        // 如果计算到最后一层（此时没有x坐标和y坐标）
        if (count == 0) {
            return curBestMove.setScore(evaluator.getAllScore(chessInfo));
        }

        int curScore = Integer.MAX_VALUE;

        // 开始遍历所有有意义的落子
        ArrayList<Move> moves = movePicker.getValuableMove(chessInfo);
        for (Move move : moves) {
            int[][] newChessInfo = ArrayTool.copyOf(chessInfo);
            newChessInfo[move.getX()][move.getY()] = Constant.WHITE;
            int score = evaluator.getAllScore(newChessInfo);
            if (score < curScore) {
                curBestMove.setX(move.getX());
                curBestMove.setY(move.getY());
                curBestMove.setScore(score);
            }
        }
        return curBestMove;
    }

}
