package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 28-10-2018 03:13 PM.
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 Note: Length of the array will not exceed 10,000.
 */
public class L674LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[] {1,3,5,4,7})); //3
        System.out.println(findLengthOfLCIS(new int[] {2,2,2,2,2})); //1
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length==0) return 0;
        int max = 1;
        int count =1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] >nums[i-1]){
                count++;
                if (count>max){
                    max=count;
                }
            }else {
                count=1;
            }
        }

        return max;
    }
}
