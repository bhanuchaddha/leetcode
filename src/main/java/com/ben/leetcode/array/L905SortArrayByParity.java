package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by ben on 24-10-2018.
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


 Note:

 1 <= A.length <= 5000
 0 <= A[i] <= 5000
 */
public class L905SortArrayByParity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {3,1,2,4})));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A.length <2 ){
            return A;
        }
        int left = 0;
        int right = A.length-1;
        while (left < right){
            if(A[left]%2!=0 && A[right]%2==0){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
            else if ( A[left]%2==0){
                left++;
            }else if ( A[right]%2!=0){
                right--;
            }
        }
        return A;
    }
}
