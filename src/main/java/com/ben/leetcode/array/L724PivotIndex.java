package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 27-10-2018 09:40 PM.
 *
 *
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

 We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

 If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

 Example 1:
 Input:
 nums = [1, 7, 3, 6, 5, 6]
 Output: 3
 Explanation:
 The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 Also, 3 is the first index where this occurs.
 Example 2:
 Input:
 nums = [1, 2, 3]
 Output: -1
 Explanation:
 There is no index that satisfies the conditions in the problem statement.
 Note:

 The length of nums will be in the range [0, 10000].
 Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class L724PivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1, 2, 3}));//-1
        System.out.println(pivotIndex(new int[] {1, 1,1}));//1
        System.out.println(pivotIndex(new int[] {1, -1,11, -12,4,-1}));//4
        System.out.println(pivotIndex(new int[] {}));//-1
        System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6})); //3
    }

    /**
     * Approach 3:
     *
     * keeping count of left sum only.
     * if we have sum of all numbers  then we dont need the rightSum.
     * Neither we need extra memory to keep cumulative sum.
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        long sum =0;
        for (int i : nums) sum+=i;
        int leftSum =0;
        for (int i = 0; i < nums.length ; i++) {
            if(leftSum == sum-leftSum-nums[i]){
                return i;
            }
            leftSum +=nums[i];
        }
        return -1;

    }


    /**
     * Approach 2.
     * Cumulative sum
     *
     * Accepted solution but poorly performant
     *
     * @param nums
     * @return
     */
    public static int pivotIndex2(int[] nums) {
        if(nums.length==0) return -1;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0]=nums[0];
        rightSum[nums.length-1]=nums[nums.length-1];
        for (int i = 1, j= nums.length-2; i <nums.length && j>=0 ; i++,j--) {
            leftSum[i]=leftSum[i-1]+nums[i];
            rightSum[j]=rightSum[j+1]+nums[j];
        }

        for (int i= 0; i<nums.length ;i++ ){
            if (leftSum[i]==rightSum[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 1.
     *
     * Two pointers.
     *
     * unfortunately failing at test case  {1, -1,11, -12,4,-1}));//4
     * Because numbers are not sorted, logic of moving pointer can not be on the basis of smaller sum.
     * In this test case when left is at 11 and right is at 4, left and right sum are respectivly 11 and 3.
     * As per our logic right should move but for answer to be correct left need to be moved.
     *
     * @param nums
     * @return
     */
    public static int pivotIndex1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        long leftSum= 0;
        long rightSum = 0;
        while (left <= right){

            if (left==right && leftSum==rightSum) {
                return left;
            }
            if (leftSum < rightSum){
                leftSum +=nums[left];
                left++;
            }else {
                rightSum += nums[right];
                right--;
            }
        }
        return -1;
    }
}
