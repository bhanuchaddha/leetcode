package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 27-10-2018.
 *
 * In a given integer array nums, there is always exactly one largest element.

 Find whether the largest element in the array is at least twice as much as every other number in the array.

 If it is, return the index of the largest element, otherwise return -1.

 Example 1:

 Input: nums = [3, 6, 1, 0]
 Output: 1
 Explanation: 6 is the largest integer, and for every other number in the array x,
 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


 Example 2:

 Input: nums = [1, 2, 3, 4]
 Output: -1
 Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


 Note:

 nums will have a length in the range [1, 50].
 Every nums[i] will be an integer in the range [0, 99].
 *
 *
 */
public class L747LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0})); // 1
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4})); // -1
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4,8})); // 4
    }

    /**
     * Approach 1.
     *
     * Single pointer:
     * Keep track of largest and second largest number and check if second largest is less than equal to largest.
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if (nums.length ==0){
            return -1;
        }
        if (nums.length==1){
            return 0;
        }

        int largest = 0;
        int secLargest = -1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i]> nums[largest]){
                secLargest = largest;
                largest = i;
            }
        }
        if (secLargest==-1 || (secLargest !=-1 && nums[secLargest]<=nums[largest]/2)){
            return largest;
        }
        return -1;
    }
}
