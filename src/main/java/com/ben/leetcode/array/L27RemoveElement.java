package com.ben.leetcode.array;

/**
 * Created by ben on 21-10-2018.
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example 1:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.

 It doesn't matter what you leave beyond the returned length.
 Example 2:

 Given nums = [0,1,2,2,3,0,4,2], val = 2,

 Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

 Note that the order of those five elements can be arbitrary.

 It doesn't matter what values are set beyond the returned length.
 */
public class L27RemoveElement {

    public static void main(String[] args) {
        //System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));//5
        System.out.println(removeElementSaveSwaps(new int[]{0,1,2,2,3,0,4,2},2));//5
    }

    /**
     * Two pointer approach
     * @param nums
     * @param val
     * @return
     */
    static public int removeElement(int[] nums, int val) {
        int index = 0;
        int newIndex = 0;
        while (index < nums.length ) {
            if ( nums[index] == val ){
                index++;
            }else {
                nums[newIndex++]= nums[index++];
            }
        }
        return newIndex;
    }

    /**
     * Save Swaps.
     *

     Now consider cases where the array contains few elements to remove. For example, nums = [1,2,3,5,4], val = 4nums=[1,2,3,5,4],val=4. The previous algorithm will do unnecessary copy operation of the first four elements. It seems unnecessary to move elements [1,2,3,5][1,2,3,5] one step left as the problem description mentions that the order of elements could be changed.

     Algorithm

     When we encounternums[i]=val, we can swap the current element out with the last element and dispose the last one. This essentially reduces the array's size by 1.

     Note that the last element that was swapped in could be the value you want to remove itself. But don't worry, in the next iteration we will still check this element.
     *
     *
     * Inspite of swaping elements we would replaces the element with last one.
     * @param nums
     * @param val
     * @return
     */
    static public int removeElementSaveSwaps(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while (left <=right){
            if (nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else {
                left++;
            }
        }
        return right+1;
    }
}
