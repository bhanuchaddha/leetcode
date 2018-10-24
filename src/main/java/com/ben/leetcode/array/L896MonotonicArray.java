package com.ben.leetcode.array;

/**
 * Created by ben on 24-10-2018.
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.

 An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

 Return true if and only if the given array A is monotonic.



 Example 1:

 Input: [1,2,2,3]
 Output: true
 Example 2:

 Input: [6,5,4,4]
 Output: true
 Example 3:

 Input: [1,3,2]
 Output: false
 Example 4:

 Input: [1,2,4,5]
 Output: true
 Example 5:

 Input: [1,1,1]
 Output: true


 Note:

 1 <= A.length <= 50000
 -100000 <= A[i] <= 100000
 */
public class L896MonotonicArray {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {1,2,2,3})); //true
        System.out.println(isMonotonic(new int[] {6,5,4,4})); //true
        System.out.println(isMonotonic(new int[] {1,3,2})); //false
        System.out.println(isMonotonic(new int[] {1,2,4,5})); //true
        System.out.println(isMonotonic(new int[] {1,1,1})); //true
    }

    /**
     * Time Complexity: O(N)O(N), where NN is the length of A.
     Space Complexity: O(1)O(1).
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        if ( A.length < 2 ){
            return true;
        }
        Boolean increasingTone = null;
        for ( int i = 0; i < A.length-1; i++ ) {

            if ( increasingTone != null ){
                if((A[i] < A[i+1] &&  !increasingTone) || ( A[i] > A[i+1] &&  increasingTone) ) {
                    return false;
                }
            } else {
                if ( A[i] < A[i+1] ) {
                    increasingTone = true;
                }
                if ( A[i] > A[i+1] ) {
                    increasingTone = false;
                }
            }

        }
        return true;
    }
}
