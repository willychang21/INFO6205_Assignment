import java.util.HashMap;
import java.util.Map;

public class sort {
    /**
     * Problem 1
     * Given a set of intervals, return true if a person can make all meetings or false if one person cannot. Intervals[i] = [start, end]. Please see the examples below
     * @param intervals a 2D integer array
     * @return boolean
     * Time Complexity: O(NlogN)
     * Space Complexity: O(logN)
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        // Sort the intervals array using quicksort
        quicksort(intervals, 0, intervals.length-1);

        // Iterate through the intervals array and check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        // If we reach the end of the loop without finding any overlaps,
        // return true
        return true;
    }

    // Define a quicksort function to sort the intervals array
    private static void quicksort(int[][] intervals, int l, int r) {
        if (l < r) {
            int pi = partition(intervals, l, r);
            quicksort(intervals, l, pi-1);
            quicksort(intervals, pi+1, r);
        }
    }

    // Define a partition function to partition the intervals array
    private static int partition(int[][] intervals, int l, int r) {
        int[] pivot = intervals[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (intervals[j][0] < pivot[0]) {
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
                i++;
            }
        }
        int[] temp = intervals[i];
        intervals[i] = intervals[r];
        intervals[r] = temp;
        return i;
    }

    /**
     * Problem 2
     * You are given a binary array (nums) containing only integers 1 and 0s.  Return the number of sub arrays in the whole array where there are more 1's than 0's.
     * @param nums an integer array
     * @return integer
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    // using DP: assume the end of subarray index i-1 has 1 more than 0, then can derive the answer at i
    public static int numSubArraysWithMoreOnes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int arrCount = 0, result = 0, count = 0;
        for(int i : nums){
            if(i == 1) {
                arrCount += map.getOrDefault(count, 0);
            }
            else {
                arrCount -= map.getOrDefault(count - 1, 0);
            }
            result += arrCount;
            count += i == 0 ? -1 : 1;
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return result;
    }
}
