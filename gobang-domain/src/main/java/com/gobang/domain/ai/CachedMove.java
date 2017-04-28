package com.gobang.domain.ai;

/**
 * 缓存的数据模型实体类。用于缓存一个局面的计算过的最优解
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月26日 下午5:13:17
 */
public class CachedMove {

    /**
     * 一个记录的id
     */
    private int id;

    /**
     * 一个局面的hash值，唯一确定一种棋局
     */
    private String hashcode;

    /**
     * 缓存的最优解的x坐标
     */
    private int x;

    /**
     * 缓存的最优解的y坐标
     */
    private int y;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gethashcode() {
        return hashcode;
    }

    public void sethashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
