package com.ben.leetcode.array;

/**
 * Created by ben on 14-10-2018.
 */
// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

public class L121BestTimeToBuySellTheStock {


    public static void main(String[] args) {
        int[] input = new int[]  {7, 1, 5, 3, 6, 4};
        int[] input2 = new int[]  {7, 6, 4, 3, 1};
        int[] input3 = new int[]  {2,4,1,7};
        int[] input4 = new int[]  {4,7,1,2,11,12};
        //System.out.println(maxProfitBrutForce(input));//5
        //System.out.println(maxProfitBrutForce(input2));//0
//        System.out.println(maxProfit(input));//5
//        System.out.println(maxProfit(input2));//0
//        System.out.println(maxProfit(input3));//6
//        System.out.println(maxProfit(input4));//11
        System.out.println(maxProfit2(input));//5
        System.out.println(maxProfit2(input2));//0
        System.out.println(maxProfit2(input3));//6
        System.out.println(maxProfit2(input4));//11
    }

    /*
    * Attempt 2
    * Using One Pass Algorithm
    * Time Complexity O(n)
    * Space Complexity O(1)
    *
    * Taking only minprice and maximumProfit into consideration.
    * Start from beginning and look for minmum value
    * If current value is greater than min value check for max profit
    * */
    static int maxProfit2(int[] input){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i= 0; i < input.length; i++) {
            if (input[i] < minPrice){
                minPrice = input[i];
            } else if (input[i]-minPrice > maxProfit) {
                maxProfit = input[i]-minPrice;
            }
        }
        return maxProfit;
    }



    /*
    * Attempt 1.
    * Using different cases.
    * Time Complexity O(n)
    * Space Complexity O(1)
    * */
    static int maxProfit(int[] input ){
        int minI = 0;//0
        int maxI = 0;//2
        boolean pairFound = false;
        int newMinI = 0;
        for (int i = 1; i < input.length ; i++) {
            if( !pairFound && input[i] < input[minI] ) { // if pair is not set. keep looking for min
                minI = i;
            } else if (!pairFound && input[i]> input[minI]){ // first maxima need to be set. set as soon as first bigger number is found
                maxI = i;
                pairFound =true;
            } else if ( pairFound && input[i] > input[maxI] && (newMinI < minI)) { // keep on looking for max . but not in case new min has been found
                maxI = i;
            } else if ( pairFound && input[i] < input[minI] && newMinI <= minI){ // if you find new min after pair is set. start new pair
                newMinI = i;
            } else if (pairFound && newMinI > minI && input[i] < input[newMinI]){ // when new min found while looking for new pair
                newMinI = i;
            } else if ( pairFound && (input[i]-input[newMinI]) > (input[maxI]-input[minI]) ) { // Conclude the pair, if new max is found
                minI = newMinI;
                maxI = i;
            }
        }
        if(pairFound){
            return input[maxI]-input[minI];
        }else {
            return 0;
        }

    }

    /*
    * BrutForce
    * Two for loops .
    * Time Complexity O(n^2)
    * Space Complexity O(1)
    * */
    static  int maxProfitBrutForce(int[] input) {
        int maxProfit=0;
        for (int i=0; i< input.length; i++){
            for(int j=i+1; j<input.length;j++){
                if((input[j]-input[i]) > maxProfit){
                    maxProfit = input[j]-input[i];
                }
            }
        }
        return maxProfit;
    }
}
