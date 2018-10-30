package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 29-10-2018 08:49 PM.
 * 
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */
public class L628MaximumProductOfThreeNumber {

    public static void main(String[] args) {

       // System.out.println(maximumProduct(new int[]{2,3,4,5,6})); //120 all positive
       // System.out.println(maximumProduct(new int[]{-8,-7,2,3,4,5})); //280 3 positive 2 big negative
       // System.out.println(maximumProduct(new int[]{-8,-7,-2,-1,4,5})); //280 2 positive 2 big negative
       // System.out.println(maximumProduct(new int[]{-8,-7,-3,-2,5})); //280 1 positive 2 big negative
        System.out.println(maximumProduct2(new int[]{-8,-7,-3,-2,-1})); //-6  all negative. if not zero. 3 max
       // System.out.println(maximumProduct(new int[]{-8,-7,-3,-2,-1,0})); //0  all negative. if  zero. 0
       // System.out.println(maximumProduct(new int[]{0,0,0,4})); //0  all negative. if  zero. 0
    }

    /**
     * Correct but too long.
     * Check Attempt 2 below.
     * Basically we dont actually need to bother about positive and negative numbers.
     * either sorting and  figuring out 5 numbers is sufficient.
     * @param nums
     * @return
     */

    // negativeMin1 negativeMin2 ..... negativeMax3 negativeMax2 negativeMax1....... positiveMax3 positiveMax2 positiveMax1
    public static int maximumProduct(int[] nums) {
        int positiveMax1 = Integer.MIN_VALUE;
        int positiveMax2 = Integer.MIN_VALUE;
        int positiveMax3 = Integer.MIN_VALUE;

        boolean zero = false;
        int negativeMin1 = Integer.MAX_VALUE;
        int negativeMin2 = Integer.MAX_VALUE;
        
        int negativeMax1 = Integer.MIN_VALUE;
        int negativeMax2 = Integer.MIN_VALUE;
        int negativeMax3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums.length==3 ) return nums[0]*nums[1]*nums[2];
            
            int val = nums[i];
            if(val<0){
                if (val > negativeMax1){
                    negativeMax3=negativeMax2;
                    negativeMax2 = negativeMax1;
                    negativeMax1 = val;
                }else if (val > negativeMax2){
                    negativeMax3=negativeMax2;
                    negativeMax2 = val;
                }else if (val > negativeMax3){
                    negativeMax3 = val;
                }

                if (val < negativeMin1 ){
                    negativeMin2 = negativeMin1;
                    negativeMin1 = val;
                }else if ( val < negativeMin2 ){
                    negativeMin2 = val;
                }
            }else if(val >0){
                if (val > positiveMax1 ){
                    positiveMax3 = positiveMax2;
                    positiveMax2 = positiveMax1;
                    positiveMax1= val;
                }else if ( val > positiveMax2){
                    positiveMax3 = positiveMax2;
                    positiveMax2 = val;
                } else if (val > positiveMax3){
                    positiveMax3 = val;
                }
            }else {
                zero = true;
            }
        }

        if (positiveMax1 > 0 && positiveMax2 > 0 && positiveMax3 > 0){
            if (negativeMin1 <0 && negativeMin2 <0 ){
                return Math.max(positiveMax1 * positiveMax2 * positiveMax3, positiveMax1 * negativeMin1 * negativeMin2);
            }else
                return positiveMax1 * positiveMax2 * positiveMax3 ;
        }else if (positiveMax1 > 0 && positiveMax3 <0){ // case where there is either 1 or 2 positive numbers
            if(zero) return 0;
            else
                return positiveMax1 * negativeMin1 * negativeMin2;
        }else if ( positiveMax1 < 0 && positiveMax2 < 0 && positiveMax3 < 0 ){
            if(zero) return 0;
            else {
                return negativeMax1 * negativeMax2 * negativeMax3;
            }
        }

        return Integer.MIN_VALUE;
    }


    /**
     * Attempt 2
     * Simplified approach.
     * @param nums
     * @return
     */
    public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
