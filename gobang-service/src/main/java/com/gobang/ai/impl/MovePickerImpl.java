package com.gobang.ai.impl;

import java.util.ArrayList;

import com.gobang.ai.interfaces.MovePicker;
import com.gobang.constant.Constant;
import com.gobang.domain.ai.Move;

public class MovePickerImpl implements MovePicker {

    @Override
    public ArrayList<Move> getValuableMove(int[][] chessInfo) {

        ArrayList<Move> result = new ArrayList<Move>();

        for (int i = 0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                if (isValuableMove(chessInfo, i, j)) {
                    result.add(new Move(i, j));
                }
            }
        }

        return result;
    }

    /**
     * 计算一个位置的落子是否有递归求权重的必要,外部保证x，y在棋盘内
     * 
     * @param chessInfo
     * @param x
     * @param y
     * @return
     */
    private boolean isValuableMove(int[][] chessInfo, int x, int y) {
        
        // 如果当前位置有落子则直接返回false
        if (chessInfo[x][y] != 0) {
            return false;
        }

        // 左上还在棋盘内
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (chessInfo[x - 1][y - 1] != 0) {
                return true;
            }
        }

        // 上还在棋盘内
        if (x - 1 >= 0) {
            if (chessInfo[x - 1][y] != 0) {
                return true;
            }
        }

        // 右上还在棋盘内
        if (x - 1 >= 0 && y + 1 <= 14) {
            if (chessInfo[x - 1][y + 1] != 0) {
                return true;
            }
        }

        // 左还在棋盘内
        if (y - 1 >= 0) {
            if (chessInfo[x][y - 1] != 0) {
                return true;
            }
        }

        // 右还在棋盘内
        if (y + 1 <= 14) {
            if (chessInfo[x][y + 1] != 0) {
                return true;
            }
        }

        // 左下还在棋盘内
        if (x + 1 <= 14 && y - 1 >= 0) {
            if (chessInfo[x + 1][y - 1] != 0) {
                return true;
            }
        }

        // 下在棋盘内
        if (x + 1 <= 14) {
            if (chessInfo[x + 1][y] != 0) {
                return true;
            }
        }

        // 右下在棋盘内
        if (x + 1 <= 14 && y + 1 <= 14) {
            if (chessInfo[x + 1][y + 1] != 0) {
                return true;
            }
        }
        
        return false;
    }

}
