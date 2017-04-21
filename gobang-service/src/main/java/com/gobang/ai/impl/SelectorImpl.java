package com.gobang.ai.impl;

import javax.annotation.Resource;

import com.gobang.ai.interfaces.Evaluator;
import com.gobang.ai.interfaces.MovePicker;
import com.gobang.ai.interfaces.Selector;
import com.gobang.domain.ai.BestMove;

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

        return curBestMove;

    }

}
