package com.ben.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        //System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1,2]
        System.out.println(Arrays.toString(twoSumUnsortedArray(nums2, target2))); // [1,2]
    }

    /**
     * Using two pointer Approach.
     *
     * This solution is valid only array is sorted in ascending order.
     *
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

    /**
     * This approach do not require sorted array.
     *
     * This is One pass approach. But we could two pass approach as well.
     *
     * We would use a map to store the compliment each number after checking if number itself is there. along with number's index.
     * We will use HashMap because, It gives O(1) time performance for find operation.
     *
     * We need to make sure that a number's compliment is not the number itself. Any condition not required as we visit single index only once and me only single operation from the given 2.
     *
     * Time Complexity O(n)
     * Space Complexity O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumUnsortedArray(int[] nums, int target) {
        Map<Integer, Integer> compliments = new HashMap<Integer, Integer>();
        for ( int i=0; i < nums.length; i++) {
            if (compliments.containsKey(nums[i])) {
                return new int[] {compliments.get(nums[i]), i};
            }else {
                compliments.put(target-nums[i],i);
            }
        }
        return new int[] {-1,-1};
    }
}
