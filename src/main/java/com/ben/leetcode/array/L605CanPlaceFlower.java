package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 29-10-2018 10:33 PM.
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True
 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False
 Note:
 The input array won't violate no-adjacent-flowers rule.
 The input array size is in the range of [1, 20000].
 n is a non-negative integer which won't exceed the input array size.
 *
 */
public class L605CanPlaceFlower {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},1));//true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));// false
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0,0,1,0,0},3));//true
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0,0,1,0,0},4));//false
        System.out.println(canPlaceFlowers(new int[]{0,0,0,0,0,0,0,0,0},5));//true
        System.out.println(canPlaceFlowers(new int[]{1,1,1,0,0,1,1},1));//false
        System.out.println(canPlaceFlowers(new int[]{0,0,0,0,0,0,0,0,0},6));//false
        System.out.println(canPlaceFlowers(new int[]{0,0,0,0,0,0},3));//true
        System.out.println(canPlaceFlowers(new int[]{0},1));//true
        System.out.println(canPlaceFlowers(new int[]{0,1,0},1));//false
        System.out.println(canPlaceFlowers(new int[]{0,1,1},0));//true
        System.out.println(canPlaceFlowers(new int[]{1},0));//true
        System.out.println(canPlaceFlowers(new int[]{0,1,0,1,0,1,0,0},1));//true

    }

    /**
     * Attempt 2 [Simple]
     *
     * We check all the 0s and dont check the left and right of first and last element.
     * Plus we fill the seat as we move forward to avoid duplicate counting.
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
        for (int i = 0; i <flowerbed.length ; i++) {
            if (
                    flowerbed[i]==0
                    && (i==0 || flowerbed[i-1]==0)
                    && (i==flowerbed.length-1 || flowerbed[i+1]==0)
                    ){
                count++;
                if(count>=n){
                    return true;
                }
                flowerbed[i]=1;
            }
        }
        return count>=n;

    }


    /**
     * Attempt 1 [ WRONG]
     *
     * Single scan. moving 2 point in a time
     * find a empty spot , check if left and right are empty. then its ok
     * no need to check for left and right.
     *  because we are moing two spots at a time. We might not be able to scan odd points like in  {0,1,0,1,0,1,0,0},1));//true
     *  Check attempt 2
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (flowerbed.length==1){
            if(flowerbed[0]==1){
                return n==0;
            }else return n==1;
        }
        int count =0;
        for (int i = 0; i < flowerbed.length; i=i+2) {
            if(i==0 && flowerbed[i]==0 && i <flowerbed.length-1 && flowerbed[i+1]==0){
                count++;
                if (count>=n)return true;
            } else if (i== flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0) {
                count++;
                if (count>=n)return true;
            } else if (i>0 && i<flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                count++;
                if (count>=n)return true;
            }
        }
        return count>=n;
    }
}
