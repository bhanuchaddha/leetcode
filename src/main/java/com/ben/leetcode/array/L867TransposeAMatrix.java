package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by ben on 24-10-2018.
 *
 * Given a matrix A, return the transpose of A.

 The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.



 Example 1:

 Input: [[1,2,3],[4,5,6],[7,8,9]]
 Output: [[1,4,7],[2,5,8],[3,6,9]]
 Example 2:

 Input: [[1,2,3],[4,5,6]]
 Output: [[1,4],[2,5],[3,6]]


 Note:

 1 <= A.length <= 1000
 1 <= A[0].length <= 1000
 */
public class L867TransposeAMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}}))); //[[1,4,7],[2,5,8],[3,6,9]]
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1,2,3},{4,5,6}}))); //[[1,4],[2,5],[3,6]]
    }

    public static int[][] transpose(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        if (r!=c){
            int[][] T= new int[c][r];
            for (int i = 0; i < r ; i++) {
                for (int j = 0; j <c ; j++) {
                    T[j][i] = A[i][j];
                }
            }
            return T;
        } else {
            for (int i = 0; i < r ; i++) {
                for (int j = i; j <c ; j++) {
                    if (i!=j){
                        int temp = A[i][j];
                        A[i][j]= A[j][i];
                        A[j][i] = temp;
                    }
                }

            }
            return A;
        }

    }
}
