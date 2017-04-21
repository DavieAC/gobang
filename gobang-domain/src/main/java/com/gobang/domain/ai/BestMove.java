package com.gobang.domain.ai;

/**
 * 用于在递归函数中描述某一层的最佳落子
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月20日 下午11:36:42
 */
public class BestMove {

    /**
     * 最佳落子的x坐标
     */
    private int x;

    /**
     * 最佳落子的y坐标
     */
    private int y;

    /**
     * 最佳落子的局面分数
     */
    private int score;

    /**
     * 以另外的形式返回最佳落子
     * 
     * @return
     */
    public int getMove() {
        return x * 100 + y;
    }

    public int getX() {
        return x;
    }

    public BestMove setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public BestMove setY(int y) {
        this.y = y;
        return this;
    }

    public int getScore() {
        return score;
    }

    public BestMove setScore(int score) {
        this.score = score;
        return this;
    }

}
