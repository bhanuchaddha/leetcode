package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by ben on 24-10-2018.
 *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

 Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

 Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.

 If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.



 Example 1:

 Input: A = [1,1], B = [2,2]
 Output: [1,2]
 Example 2:

 Input: A = [1,2], B = [2,3]
 Output: [1,2]
 Example 3:

 Input: A = [2], B = [1,3]
 Output: [2,3]
 Example 4:

 Input: A = [1,2,5], B = [2,4]
 Output: [5,4]


 Note:

 1 <= A.length <= 10000
 1 <= B.length <= 10000
 1 <= A[i] <= 100000
 1 <= B[i] <= 100000
 It is guaranteed that Alice and Bob have different total amounts of candy.
 It is guaranteed there exists an answer.
 *
 */
public class L888FairCandySwap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,1} , new int[]{2,2} )));
    }

    /**
     * Attempt 1;
     *
     * Calculate the difference between sum of candies of A and B
     * difference/2 would be the value  between 2 candies need to be swapped for example if the sum dif by 4 then we need to find a pair which has diff of 2. like 4 and 6.
     * now it is a pair find problem , which can be solved by keeping track of numbers in one array.
     *
     * Time 14 ms
     * @param A
     * @param B
     * @return
     *
     * Time Complexity: O(A.length+B.length).
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] aVal = new int[100001];
        int aSum = 0;
        int bSum = 0;
        boolean giveMoreToA = false;
        for (int c : A){
            aVal[c]++;
            aSum = aSum + c;
        }
        for (int c : B){
            bSum = bSum + c;
        }
        int fairSize = (aSum+bSum)/2;
        int sizeDiff = fairSize - aSum;
        if( sizeDiff > 0){
            giveMoreToA = true;
        } else {
            giveMoreToA = false;// not required though. for code consistency
            sizeDiff = -1 * sizeDiff;
        }

        for (int candyInB : B){
            int candyInA = giveMoreToA ? candyInB - sizeDiff : candyInB + sizeDiff;
            if (candyInA > 0 && candyInA <=100001 && aVal[candyInA] >0){
                return new int[] {candyInA, candyInB };
            }
        }
        return new int[] {0,0};
    }
}
