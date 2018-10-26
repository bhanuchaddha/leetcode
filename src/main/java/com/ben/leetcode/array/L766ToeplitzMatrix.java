package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 26-10-2018.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

 Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


 Example 1:

 Input:
 matrix = [
 [1,2,3,4],
 [5,1,2,3],
 [9,5,1,2]
 ]
 Output: True
 Explanation:
 In the above grid, the diagonals are:
 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 In each diagonal all elements are the same, so the answer is True.
 Example 2:

 Input:
 matrix = [
 [1,2],
 [2,2]
 ]
 Output: False
 Explanation:
 The diagonal "[1, 2]" has different elements.

 Note:

 matrix will be a 2D array of integers.
 matrix will have a number of rows and columns in range [1, 20].
 matrix[i][j] will be integers in range [0, 99].

 Follow up:

 What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 What if the matrix is so large that you can only load up a partial row into the memory at once?
 *
 */
public class L766ToeplitzMatrix {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));

        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,0,1,2}
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2},{2,2}
        }));
    }

    /**
     * Attempt 2
     *
     * re writing as we are accessing the whole matrix anyway
     * Worsen the  performance
     * @param matrix
     * @return
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i <m-1 ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if (matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return  true;

    }

    /**
     * Attempt 1 compare to  neighbor.
     * @param matrix
     * @return
     *
     * TC O(m*n)
     * SC O(1)
     */
    public static boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int col = 0; col <n ; col++) {
            int dr = 0;
            int dc = col;
            while (dr < m-1 && dc < n-1){
                if (matrix[dr][dc]!=matrix[dr+1][dc+1]){
                    return false;
                }
                dr++;
                dc++;
            }
        }
        for (int row = 1; row <m ; row++) {
            int dr = row;
            int dc = 0;
            while (dr < m-1 && dc < n-1){
                if (matrix[dr][dc]!=matrix[dr+1][dc+1]){
                    return false;
                }
                dr++;
                dc++;
            }
        }
        return  true;

    }



}
