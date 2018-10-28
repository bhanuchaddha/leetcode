package com.ben.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bhanu Chaddha on 28-10-2018 02:32 PM.
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.

 *
 */
public class L697DegreeOfAnArray {

    public static void main(String[] args) {

        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));//2
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));//6
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer,List<Integer>> counts= new HashMap<>();
        int max =nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if(counts.containsKey(nums[i])){
                List<Integer> val=counts.get(nums[i]);
                val.set(0,val.get(0)+1);
                val.set(2,i);
                int currentCount = val.get(0);
                int currentLength = val.get(2)-val.get(1);
                List<Integer> maxVal = counts.get(max);
                int maxCount = maxVal.get(0);
                int maxLength = maxVal.get(2)-maxVal.get(1);
                if((currentCount> maxCount || currentCount== maxCount && currentLength < maxLength )){
                    max = nums[i];
                }
            }else {
                counts.put(nums[i],Arrays.asList(1,i,i)); // list 0=count, 1= min index, 2= max index
            }
        }

        return counts.get(max).get(2) - counts.get(max).get(1) +1;
    }
}
