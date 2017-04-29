package com.gobang.dao.api.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gobang.constant.Constant;
import com.gobang.dao.api.interfaces.MoveCache;
import com.gobang.dao.cachedmove.interfaces.CachedMoveDao;
import com.gobang.domain.ai.CachedMove;
import com.gobang.domain.ai.Move;

public class MoveCacheImpl implements MoveCache {

    private static final Logger logger = LoggerFactory.getLogger(MoveCacheImpl.class);

    @Resource
    private CachedMoveDao cachedMoveDao;

    @Override
    public boolean insertCachedMove(int x, int y, int[][] chessInfo) {
        return cachedMoveDao.insertCachedMove(new CachedMove(x, y, getHashcode(chessInfo)));
    }

    @Override
    public boolean deleteCachedMove(int[][] chessInfo) {
        return cachedMoveDao.deleteCachedMove(new CachedMove(getHashcode(chessInfo)));
    }

    @Override
    public Move getCachedMove(int[][] chessInfo) {

        List<CachedMove> cachedMoves = cachedMoveDao.getCachedMoveByHashcode(getHashcode(chessInfo));
        // Dao层报错，也就是查询失败
        if (cachedMoves == null) {
            logger.error("DAO层查询落子缓存失败");
            return null;
        }

        // 查询到0个或者多个的情况，都返回null
        if (cachedMoves.size() != 1) {
            return null;
        } else {
            return new Move(cachedMoves.get(0).getX(), cachedMoves.get(0).getY());
        }
    }

    /**
     * 对于一个棋局计算其hash码作为棋局的唯一标识
     * 
     * @param chessInfo
     * @return
     */
    private String getHashcode(int[][] chessInfo) {
        String chess = new String();
        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                chess += chessInfo[i][j];
            }
        }
        return Integer.toString(chess.hashCode());
    }

}
