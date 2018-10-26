package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by ben on 26-10-2018.
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

 To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

 To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

 Example 1:

 Input: [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 Example 2:

 Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 Notes:

 1 <= A.length = A[0].length <= 20
 0 <= A[i][j] <= 1
 *
 */
public class L832FlipAnImage {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}})));
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}})));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int left =0;
            int right = n-1;
            while (left<=right) {
                int temp = flip(A[i][left]);
                A[i][left] = flip(A[i][right]);
                A[i][right]= temp;
                left++;
                right--;
            }
        }

        return A;
    }

    private static int flip(int i){
        return i==0?1:0;
    }
}
