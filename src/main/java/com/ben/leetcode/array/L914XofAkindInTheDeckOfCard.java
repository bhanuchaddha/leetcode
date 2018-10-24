package com.ben.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 22-10-2018.
 *
 * In a deck of cards, each card has an integer written on it.

 Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

 Each group has exactly X cards.
 All the cards in each group have the same integer.


 Example 1:

 Input: [1,2,3,4,4,3,2,1]
 Output: true
 Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 Example 2:

 Input: [1,1,1,2,2,2,3,3]
 Output: false
 Explanation: No possible partition.
 Example 3:

 Input: [1]
 Output: false
 Explanation: No possible partition.
 Example 4:

 Input: [1,1]
 Output: true
 Explanation: Possible partition [1,1]
 Example 5:

 Input: [1,1,2,2,2,2]
 Output: true
 Explanation: Possible partition [1,1],[2,2],[2,2]


 Note:

 1 <= deck.length <= 10000
 0 <= deck[i] < 10000
 *
 *
 */
public class L914XofAkindInTheDeckOfCard {

    public static void main(String[] args) {
        int[] input = {1,1,2,2,2,2}; // true
        int[] input2 = {1}; // false
        int[] input3 = {1,1,1,1,2,2,2,2,2,2}; // true
        int[] input4 = {1,1,1,2,2,2,3,3}; // false
/*        System.out.println(hasGroupsSizeX(input)); //true
        System.out.println(hasGroupsSizeX(input2)); //false
        System.out.println(hasGroupsSizeX(input3)); //true
        System.out.println(hasGroupsSizeX(input4)); //false  */
        System.out.println(hasGroupsSizeX2(input)); //true
        System.out.println(hasGroupsSizeX2(input2)); //false
        System.out.println(hasGroupsSizeX2(input3)); //true
        System.out.println(hasGroupsSizeX2(input4)); //false
    }

    /**
     * Approach 1
     *
     * Using Map to keep track of occurrence of each element.
     * find gsd.
     * check if the all the values are equal or multiple of minimum.
     *
     * Time Complexity O(nlog^2n)
     * Space Complexity O(n)
     *
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <2) return false;
        Map<Integer, Integer> occurrence = new HashMap<Integer, Integer>();
        for (int aDeck : deck) {
            if (occurrence.containsKey(aDeck)) {
                occurrence.put(aDeck, occurrence.get(aDeck) + 1);
            } else {
                occurrence.put(aDeck, 1);
            }
        }
        if(occurrence.values().size()==1) return true;

        int[] vals = (occurrence.values().stream().mapToInt(i->i).toArray());
        int gcd = gcd(vals[0], vals[1]);
        for (int i = 2; i < vals.length ; i++){
            gcd = gcd(gcd, vals[i]);
        }

        if(gcd!=1){
            return true;
        }
        return false;
    }

    /**
     * Attempt 2.(Better Performing)
     *
     * Using array as storage. As outer bound of numbers is given.
     * Time Complexity O(nlog^2n)
     * Space Complexity O(n)
     *
     *
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX2(int[] deck) {
        int[] count = new int[10000];
        for (int card: deck) {
            count[card]++;
        }

        int gcd = -1;
        for ( int i = 0; i < 10000 ; i++) {
            if(count[i] > 0){
                if (gcd == -1){
                    gcd = count[i];
                }
                gcd = gcd(gcd, count[i]);
            }
        }

        return gcd >= 2;
    }



    /**
     * Greatest common divisor
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        return a==0? b : gcd(b%a,a);
    }
}
