package com.ben.leetcode.array;

/**
 * Created by ben on 24-10-2018.
 *
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

 There is at least one empty seat, and at least one person sitting.

 Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

 Return that maximum distance to closest person.

 Example 1:

 Input: [1,0,0,0,1,0,1]
 Output: 2
 Explanation:
 If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 If Alex sits in any other open seat, the closest person has distance 1.
 Thus, the maximum distance to the closest person is 2.
 Example 2:

 Input: [1,0,0,0]
 Output: 3
 Explanation:
 If Alex sits in the last seat, the closest person is 3 seats away.
 This is the maximum distance possible, so the answer is 3.
 Note:

 1 <= seats.length <= 20000
 seats contains only 0s or 1s, at least one 0, and at least one 1.

 *
 */
public class L849MaximumDistanceToClosestPerson {

    public static void main(String[] args) {
/*        System.out.println(maxDistToClosest(new int[] {1,0,0,0,1,0,1}));// 2
        System.out.println(maxDistToClosest(new int[] {1,0,0,0}));// 3
        System.out.println(maxDistToClosest(new int[] {0,1}));// 1*/
        System.out.println(maxDistToClosest(new int[] {0,0,1}));// 2
        //System.out.println(maxDistToClosest(new int[] {0,0,1,0,0,0,0,0,1}));// 3
    }

    public static int maxDistToClosest(int[] seats) {

        int length = 0;
        int newLength = 0;
        boolean headSpaceIdentified =false;
        int headSpace = 0;
        int tailSpace = 0;

        for (int i = 0; i < seats.length; i++) {
            if(i==0 && seats[0]==0){
                headSpaceIdentified = true;
                newLength = 1;
            } else if (i!=0 && seats[i]==0 && seats[i-1]==1){
                newLength = 1;
            } else if (seats[i]==0 && seats[i-1]==0 && i!=seats.length-1 ){
                newLength++;
            } else if (i!=0 && seats[i]==1 && seats[i-1]==0 && headSpaceIdentified) {
                headSpaceIdentified = false;
                headSpace = i;
            } else if ( i!=0 && seats[i]==1 && seats[i-1]==0 &&  newLength > length) {
                length = newLength;
            } else if (i==seats.length-1 && seats[i]==0){
                newLength++;
                tailSpace = newLength;
            }
        }

        int maxDistanceToClosest = length%2==0? length/2 :(length+1)/2;

        return headSpace > tailSpace ? (headSpace > maxDistanceToClosest? headSpace: maxDistanceToClosest ):(tailSpace > maxDistanceToClosest ? tailSpace: maxDistanceToClosest);

    }
}
