package com.gobang.tools;

import java.util.Arrays;

public class ArrayTool {

    public static int[][] copyOf(int[][] oriArray) {

        if (oriArray == null || oriArray.length == 0) {
            return null;
        }

        int[][] newArray = new int[oriArray.length][oriArray[0].length];

        for (int i = 0; i < oriArray.length; i++) {
            for (int j = 0; j < oriArray[0].length; j++) {
                newArray[i][j] = oriArray[i][j];
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        
        int[][] arr = ArrayTool.copyOf(array);
        
        for (int[] ar : arr) {
            System.out.println( Arrays.toString(ar) );
        }
    }

}
