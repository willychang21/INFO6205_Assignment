public class Main {
    public static void main(String[] args) {

        /*
        Problem 1
        Given a set of intervals, return true if a person can make all meetings or false if one person cannot. Intervals[i] = [start, end]. Please see the examples below
        */

        /*
        Example 1
        Input: intervals = [[0,30],[5,10],[15,20]]
        Output: false
        */

        int[][] input1 = {{ 0, 30 }, { 5, 10 }, { 15, 20 }};
        System.out.println(sort.canAttendMeetings(input1));

        /*
        Example 2
        Input: intervals = [[7,10],[2,4]]
        Output: true
        */
        int[][] input2 = {{ 7, 10 }, { 2, 4 }};
        System.out.println(sort.canAttendMeetings(input2));

        /*
        Problem 2
        You are given a binary array (nums) containing only integers 1 and 0s.  Return the number of sub arrays in the whole array where there are more 1's than 0's.
        */

        /*
        Example 1
        Input: intervals = [0,1,1,0,1]
        Output: 9
        */
        int[] input3 = {0,1,1,0,1};
        System.out.println(sort.numSubArraysWithMoreOnes(input3));


        /*
        Example 2
        Input: intervals = [0]
        Output: 0
        */
        int[] input4 = {0};
        System.out.println(sort.numSubArraysWithMoreOnes(input4));

        /*
        Example 3
        Input: intervals = [1]
        Output: 1
        */
        int[] input5 = {1};
        System.out.println(sort.numSubArraysWithMoreOnes(input5));
    }
}