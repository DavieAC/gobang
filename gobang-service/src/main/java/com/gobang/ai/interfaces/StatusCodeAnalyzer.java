package com.gobang.ai.interfaces;

/**
 * 这个接口主要用户对棋子每个方向的状态码进行分析
 * 
 * <li>0, 如果没有落子或者有两头都被堵死的又不是5子连珠的</li>
 * <li>1, 断1</li>
 * <li>2, 活1</li>
 * <li>3, 断2</li>
 * <li>4, 活2</li>
 * <li>5, 断3</li>
 * <li>6, 活3</li>
 * <li>7, 断4</li>
 * <li>8, 活4</li>
 * <li>9, 5子连珠</li>
 * 
 * @copyright Copyright 2016-2017 JD.COM All Right Reserved
 * @author 戴时机 部门：营销创新部-智能营销研发部
 * @version 1.0
 * @data 2017年4月19日 下午5:49:28
 */
public interface StatusCodeAnalyzer {

    /**
     * 获得当前位置的横向连珠的状态码
     */
    public int getHorizontalStatusCode(int[][] chessInfo, int x, int y);

    /**
     * 当前位置获得纵向的状态码
     */
    public int getVerticalStatusCode(int[][] chessInfo, int x, int y);

    /**
     * 获得当前位置撇方向的状态码
     */
    public int getLeftFallingStatusCode(int[][] chessInfo, int x, int y);

    /**
     * 获得当前位置捺方向的状态码
     */
    public int getRightFallingStatusCode(int[][] chessInfo, int x, int y);

}
