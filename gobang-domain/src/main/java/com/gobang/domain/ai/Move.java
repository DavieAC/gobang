package com.gobang.domain.ai;

public class Move {

    /**
     * 一个落子的X坐标
     */
    private int x;

    /**
     * 一个落子的Y坐标
     */
    private int y;

    /**
     * 一个落子的分数，在递归函数中需要用到
     */
    private int score;

    public Move() {

    }

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
    
    public String toInfoString() {
        return String.valueOf(x * 100 + y);
    }

    public int getX() {
        return x;
    }

    public Move setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Move setY(int y) {
        this.y = y;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Move setScore(int score) {
        this.score = score;
        return this;
    }

}
