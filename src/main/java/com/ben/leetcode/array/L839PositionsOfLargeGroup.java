package com.ben.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 26-10-2018.
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

 For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

 Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

 The final answer should be in lexicographic order.



 Example 1:

 Input: "abbxxxxzzy"
 Output: [[3,6]]
 Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 Example 2:

 Input: "abc"
 Output: []
 Explanation: We have "a","b" and "c" but no large group.
 Example 3:

 Input: "abcdddeeeeaabbbcd"
 Output: [[3,5],[6,9],[12,14]]
 */
public class L839PositionsOfLargeGroup {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));//[[3,6]]
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));//[[3,5],[6,9],[12,14]]
        System.out.println(largeGroupPositions("vvvvvvv"));//[[0,6]]
        System.out.println(largeGroupPositions("123455"));//[]
        System.out.println(largeGroupPositions("aaa"));//[0,2]
        System.out.println(largeGroupPositions("aaaabbaaccccc"));//[0,3][8,12]

        System.out.println(largeGroupPositions2("abbxxxxzzy"));//[[3,6]]
        System.out.println(largeGroupPositions2("abcdddeeeeaabbbcd"));//[[3,5],[6,9],[12,14]]
        System.out.println(largeGroupPositions2("vvvvvvv"));//[[0,6]]
        System.out.println(largeGroupPositions2("123455"));//[]
        System.out.println(largeGroupPositions2("aaa"));//[0,2]
        System.out.println(largeGroupPositions2("aaaabbaaccccc"));//[0,3][8,12]
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> positions = new ArrayList<>();
        char[] chars = S.toCharArray();
        if (chars.length <3){
            return positions;
        }
        int start =0;
        for (int i = 1; i < chars.length ; i++) {
            if ( i== chars.length-1 && chars[i]==chars[i-1] ){
                if ((i-start) >= 2){
                    List<Integer> position =Arrays.asList(start,i);
                    positions.add(position);
                }
            } else if (chars[i]!=chars[i-1]) {
                if ((i-start) >= 3){
                    List<Integer> position =Arrays.asList(start,i-1);
                    positions.add(position);
                }
                start=i;
            }
        }
        return positions;
    }

    /**
     * Attempt 2
     *
     * No else condition to improve runtime
     * @param S
     * @return
     */
    public static List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> positions = new ArrayList<>();
        char[] chars = S.toCharArray();
        if (chars.length <3){
            return positions;
        }
        int start =0;
        for (int i = 0; i < chars.length ; i++) {
             if (i== chars.length-1 || chars[i]!=chars[i+1]) {
                if ((i-start) >= 2){
                    List<Integer> position =Arrays.asList(start,i);
                    positions.add(position);
                }
                start=i+1;
            }
        }
        return positions;
    }

}
