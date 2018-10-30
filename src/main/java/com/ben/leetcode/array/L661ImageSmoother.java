package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by Bhanu Chaddha on 28-10-2018 09:58 PM.
 *
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * The sample is terrible. The question wants you to get the average of all surrounding cells for each cell. But the average should be computed from the state of the ORIGINAL matrix. So, for example, after getting the average for the middle cell, if that cell's value changes, you still want to use the original value when calculating the averages for that cell's neighbors.

 And the numbers can be from [1,255] not just 0 and 1.
 ex:
 [[1, 3, 2],
 [6, 2, 25]
 should produce
 [3, 6, 8],
 [3, 6, 8]

 Remember to include the cell in its own average.
 */
public class L661ImageSmoother {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{
                {1, 3, 2},
                {6, 2, 25}
        })));

        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{
                {10, 300},
                {60, 500}
        })));//[[435,435],[435,435]]
    }

    public static int[][] imageSmoother(int[][] M) {
        if (M.length == 0)return M;
        int[][] result = new int[M.length][M[0].length];
        for (int i =0; i<M.length ;i++){
            for (int j=0; j<M[0].length; j++){
                result[i][j]=avg(M,i,j);
            }
        }
        return result;

    }

    public static int getValue(int[][] M, int r, int c){
        if (r>=0 && r <M.length && c >=0 && c < M[0].length){
            return M[r][c];
        }else return -1;
    }

    public static int avg(int[][] M, int r, int c) {
        int count =0;
        int sum = 0;
        for (int i = r-1; i <=r+1 ; i++) {
            for (int j = c-1; j <= c+1 ; j++) {
                if (getValue(M,i,j)!= -1){
                    sum+= getValue(M,i,j);
                    count++;
                }
            }
        }
        return sum/count;
    }
}
