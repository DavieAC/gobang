package com.gobang.ai.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.ai.interfaces.ChessAI;
import com.gobang.ai.interfaces.Selector;
import com.gobang.dao.api.interfaces.MoveCache;
import com.gobang.domain.ai.Move;

public class ChessAIImpl implements ChessAI {

    private static final Logger logger = LoggerFactory.getLogger(ChessAIImpl.class);

    @Resource
    Selector selector;

    @Resource
    MoveCache moveCache;

    @Override
    public Move getAIMove(int[][] chessInfo) {

        Move cachedMove = moveCache.getCachedMove(chessInfo);
        if (cachedMove == null) {
            logger.info("落子缓存未找到");
            Move move = selector.getMinScore(chessInfo, 4, Integer.MIN_VALUE);
            moveCache.insertCachedMove(move.getX(), move.getY(), chessInfo);
            return move;
        } else {
            logger.info("落子缓存找到:{},{}", cachedMove.getX(), cachedMove.getY());
            return cachedMove;
        }
    }
}
