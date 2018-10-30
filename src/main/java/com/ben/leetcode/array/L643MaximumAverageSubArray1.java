package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 28-10-2018 11:21 PM.
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 */
public class L643MaximumAverageSubArray1 {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));//12.75
        System.out.println(findMaxAverage(new int[]{1,12,-5,-3,-3,5},4));//1.25
        System.out.println(findMaxAverage(new int[]{5},1));//1.25
    }


    /**
     * Attempt 3
     * Approach #2 Sliding Window
     Algorithm

     Instead of creating a cumulative sum array first, and then traversing over it to determine the required sum, we can simply traverse over numsnums just once, and on the go keep on determining the sums possible for the subarrays of length kk. To understand the idea, assume that we already know the sum of elements from index ii to index i+ki+k, say it is xx.

     Now, to determine the sum of elements from the index i+1i+1 to the index i+k+1i+k+1, all we need to do is to subtract the element nums[i]nums[i] from xx and to add the element nums[i+k+1]nums[i+k+1] to xx. We can carry out our process based on this idea and determine the maximum possible average.
     *
     */
    public static double findMaxAverage(int[] nums, int k) {
        int current =0;
        for (int i = 0; i <k ; i++) {
            current+=nums[i];
        }
        int max = current;
        for (int i = k; i<nums.length; i++){
            current = current+nums[i]-nums[i-k];
            if(current>max){
                max=current;
            }
        }
        return max/(double)k;
    }




    /**
     * Attempt 2
     * Approach #1 Cumulative Sum
     Algorithm

     We know that in order to obtain the averages of subarrays with length kk, we need to obtain the sum of these kk length subarrays. One of the methods of obtaining this sum is to make use of a cumulative sum array, sumsum, which is populated only once. Here, sum[i]sum[i] is used to store the sum of the elements of the given numsnums array from the first element upto the element at the i^{th}i
     th
     index.

     Once the sumsum array has been filled up, in order to find the sum of elements from the index ii to i+ki+k, all we need to do is to use: sum[i] - sum[i-k]sum[i]−sum[i−k]. Thus, now, by doing one more iteration over the sumsum array, we can determine the maximum average possible from the subarrays of length kk.

     The following animation illustrates the process for a simple example.
     */
    public static double findMaxAverage2(int[] nums, int k) {
        int[] cumulativeSum =new int[nums.length];
        cumulativeSum[0]=nums[0];

        for (int i=1; i<nums.length;i++){
            cumulativeSum[i]=cumulativeSum[i-1]+nums[i];
        }
        int max =cumulativeSum[k-1];
        for (int i= k;i<nums.length;i++){
            int current = cumulativeSum[i]-cumulativeSum[i-k];
            if (current >max){
                max=current;
            }
        }

        return max/(double)k;
    }



    /**
     * Attempt 1.
     *
     * real slow
     * TC O(n *k)
     * SC O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage1(int[] nums, int k) {
        int max =Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length-k ; i++) {
            int j=0;
            int sum=0;
            while (j<k){
                sum+=nums[i+j];
                j++;
            }
            if (sum>max) max =sum;
        }
        return max/(double)k;
    }
}
