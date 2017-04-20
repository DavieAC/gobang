package com.gobang.ai.impl;

import javax.annotation.Resource;

import com.gobang.ai.interfaces.Evaluator;
import com.gobang.ai.interfaces.Selector;

public class SelectorImpl implements Selector{
    
    @Resource
    private Evaluator evaluator;

    @Override
    public int getCurBestMove(int[][] chessInfo) {
        return 0;
    }
    
    private int getMaxScore(int[][] chessInfo, int count) {
        
        // 如果计算到最后一层
        if (count == 0) {
            return evaluator.getAllScore(chessInfo);
        }
        
        return 0;
        
    }

}
