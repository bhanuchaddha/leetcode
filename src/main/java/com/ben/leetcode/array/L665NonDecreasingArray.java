package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 28-10-2018 03:24 PM.
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

 We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

 Example 1:
 Input: [4,2,3]
 Output: True
 Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 Example 2:
 Input: [4,2,1]
 Output: False
 Explanation: You can't get a non-decreasing array by modify at most one element.
 Note: The n belongs to [1, 10,000].
 *
 */
public class L665NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));//true
        System.out.println(checkPossibility(new int[]{4,2,1}));//false
        System.out.println(checkPossibility(new int[]{2,2}));//true
        System.out.println(checkPossibility(new int[]{3,4,2,3}));//false
        System.out.println(checkPossibility(new int[]{3,4,2,3}));//false
        System.out.println(checkPossibility(new int[]{4,2,3}));//true
    }

    /**
     * Locate problem index.
     *
     * Intuition

     Consider all indices pp for which \text{A[p]} &gt; \text{A[p+1]}A[p]>A[p+1]. If there are zero, the answer is True. If there are 2 or more, the answer is False, as more than one element of the array must be changed for \text{A}A to be monotone increasing.

     At the problem index pp, we only care about the surrounding elements. Thus, immediately the problem is reduced to a very small size that can be analyzed by casework.

     Algorithm

     As before, let pp be the unique problem index for which \text{A[p]} &gt; \text{A[p+1]}A[p]>A[p+1]. If this is not unique or doesn't exist, the answer is False or True respectively. We analyze the following cases:

     If \text{p = 0}p = 0, then we could make the array good by setting \text{A[p] = A[p+1]}A[p] = A[p+1].
     If \text{p = len(A) - 2}p = len(A) - 2, then we could make the array good by setting \text{A[p+1] = A[p]}A[p+1] = A[p].
     Otherwise, \text{A[p-1], A[p], A[p+1], A[p+2]}A[p-1], A[p], A[p+1], A[p+2] all exist, and:
     We could change A[p] to be between A[p-1] and A[p+1] if possible, or;
     We could change A[p+1] to be between A[p] and A[p+2] if possible.
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int problemI = -1;
        for (int i = 0; i<nums.length-1 ;i++) {
            if (nums[i]> nums[i+1]){
                if(problemI!= -1){
                    return false; //two anomaly can not be fixed
                }else {
                    problemI = i;
                }
            }
        }

        return problemI == -1 || problemI ==0 || problemI == nums.length-2
                || nums[problemI-1] <= nums[problemI+1]
                || nums[problemI] <= nums[problemI+2];
    }





    /**
     * Attempt 1- Incorrect
     * Checking only one anomaly is  not sufficient. Because it does not guarantee that chaning that number would result in increasing series.
     * It also depend upon the number surrounding the anomaly.
     * @param nums
     * @return
     */
    public static boolean checkPossibility2(int[] nums) {
        if (nums.length==1) return true;
        int exception = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1]){
                if (i<nums.length-1 && nums[i+1] <nums[i-1]  ){
                    return false;
                }else {
                    exception++;
                }
            }
        }
        return exception<=1;
    }
}
