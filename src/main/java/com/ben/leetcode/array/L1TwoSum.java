package com.ben.leetcode.array;

import java.util.Arrays;

/**
 * Created by ben on 21-10-2018.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class L1TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] nums2 = { 3, 2, 4};
        int target2 = 6;
        int target = 9;
        //System.out.println(Arrays.toString(twoSum(nums, target))); // [0,1]
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1,2]
    }

    /**
     * Using two pointer Approach.
     * Time Complexity O(n)
     * Space Complexity O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right ) {
            if ( nums[left]+nums[right] == target){
                return new int[]{left, right};
            } else if (nums[left]+nums[right] > target ) {
                right --;
            }else {
                left++;
            }
        }
        return new int[]{0,0};
    }
}
