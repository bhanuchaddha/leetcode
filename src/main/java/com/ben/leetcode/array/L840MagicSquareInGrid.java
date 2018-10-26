package com.ben.leetcode.array;

/**
 * Created by ben on 26-10-2018.
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

 Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



 Example 1:

 Input: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 Output: 1
 Explanation:
 The following subgrid is a 3 x 3 magic square:
 438
 951
 276

 while this one is not:
 384
 519
 762

 In total, there is only one magic square inside the given grid.
 Note:

 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 0 <= grid[i][j] <= 15
 */
public class L840MagicSquareInGrid {
    public static void main(String[] args) {
/*        System.out.println(numMagicSquaresInside(
                new int[][]{
                        {4,3,8,4},
                        {9,5,1,9},
                        {2,7,6,2}}
        ));*/
        System.out.println(numMagicSquaresInside(
                new int[][]{
                        {4,3,8},
                        {9,5,1},
                        {2,7,6}}
        ));

        System.out.println(numMagicSquaresInside(
                new int[][]{
                        {4,3,8},
                        {9,5,1},
                        {2,7,6},
                {4,3,8},
                {9,5,1},
                {2,7,6}}
        ));

        System.out.println(numMagicSquaresInside(
                new int[][]{
                        {4,3,8},
                        {9,5,1},
                        {2,7,6},
                        {4,3,8},
                        {9,5,1},
                        {2,7,6,8}}
        ));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int ms = 0;
        if (grid==null || grid.length < 3 || grid[0].length <3){
            return ms;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] uniqueNums;

        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                uniqueNums = new int[10];
                boolean uniqueNum = true;
                int[] rowSum = new int[3];
                int[] colSum = new int[3];
                int diagonalSum1 = grid[i][j]+ grid[i-1][j-1] +grid[i-2][j-2];
                int diagonalSum2 = grid[i-2][j]+ grid[i-1][j-1] +grid[i][j-2];

                if (diagonalSum1 != diagonalSum2) {
                    continue;
                }

                gridCheck:
                for (int k = i-2, row=0; k <= i && row < 3 && uniqueNum; k++, row++) {

                    for (int l = j-2, col=0; l <= j && col <3 ; l++, col++) {

                        // check for unique
                        if ( grid[k][l] >9 || grid[k][l] <1 || uniqueNums[grid[k][l]] > 0 ){ //non unique number
                            uniqueNum =false;
                            break gridCheck;
                        }else {
                            uniqueNums[grid[k][l]]++;
                        }
                        //row sum
                        rowSum[row]= rowSum[row] + grid[k][l];
                        //col sum
                        colSum[col]= colSum[col] + grid[k][l];
                    }
                }

                if (uniqueNum && rowSum[0]==rowSum[1] && rowSum[1]== rowSum[2] && rowSum[2] == colSum[0] && colSum[0]== colSum[1] && colSum[1]==colSum[2]){
                    ms++;
                }

            }

        }
        return ms;
    }
}
