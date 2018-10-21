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

public class BestTimeToBuySellTheStock {


    public static void main(String[] args) {
        int[] input = new int[]  {7, 1, 5, 3, 6, 4};
        int[] input2 = new int[]  {7, 6, 4, 3, 1};
        System.out.println(maxProfitBrutForce(input));//5
        System.out.println(maxProfitBrutForce(input2));//0
        System.out.println(maxProfit(input));//5
        System.out.println(maxProfit(input2));//0
    }

    /*
    * Case 1 : pair not found -  new minima
    * Case 2 : pair not fount - new maxima
    * Case 3 : pair found - you can only search for max, not min - new mxima
    * Case 4 : pair found - new minima
    *
    * */
    static int maxProfit(int[] input ){//{7, 1, 5, 3, 6, 4}
        int minI = 0;//0
        int maxI = 0;//2
        boolean pairFound = false;
        int newMinI = 0;
        for (int i = 1; i < input.length ; i++) {
            if( !pairFound && input[i] < input[minI] ) { // Case 1
                minI = i;
            } else if (!pairFound && input[i]> input[minI]){ // first maxima nee to be set
                maxI = i;
                pairFound =true;
            } else if ( pairFound && input[i] > input[maxI] ) { // Case 2 && Case 4
                maxI = i;
            } else if ( pairFound && input[i] < input[minI] ){
                newMinI = i;
            } else if ( pairFound && (input[i]-input[newMinI]) > (input[maxI]-input[minI]) ) { //new pair found
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
    * Two for loops .
    * N^2
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
