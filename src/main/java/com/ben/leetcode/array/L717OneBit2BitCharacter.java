package com.ben.leetcode.array;

/**
 * Created by Bhanu Chaddha on 28-10-2018 01:48 PM.
 *
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

 Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

 Example 1:
 Input:
 bits = [1, 0, 0]
 Output: True
 Explanation:
 The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 Example 2:
 Input:
 bits = [1, 1, 1, 0]
 Output: False
 Explanation:
 The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 Note:

 1 <= len(bits) <= 1000.
 bits[i] is always 0 or 1.
 */
public class L717OneBit2BitCharacter {

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));//true
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));//false
    }

    public static boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length ; ) {
            if (i == bits.length - 2) {
                if (bits[i] == 0) {
                    return true;
                } else {
                    return false;
                }

            } else if (i == bits.length - 1) {
                return true;
            } else {
                if (bits[i] == 0) {
                    i++;
                } else i += 2;
            }

        }
        return false;
    }
}
