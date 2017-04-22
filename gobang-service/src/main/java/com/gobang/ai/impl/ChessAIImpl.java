package com.gobang.ai.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.interfaces.ChessAI;
import com.gobang.ai.interfaces.Selector;
import com.gobang.domain.ai.Move;


public class ChessAIImpl implements ChessAI {

    private static final Logger logger = LoggerFactory.getLogger(ChessAIImpl.class);

    @Resource
    Selector selector;

    @Override
    public int getAIMove(int[][] chessInfo) {
        Move AIMove = selector.getMinScore(chessInfo, 2);
        return AIMove.getX() * 100 + AIMove.getY();
    }

}
