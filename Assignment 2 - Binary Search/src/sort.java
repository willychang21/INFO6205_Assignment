public class sort {
    /**
     * Given a sorted array containing duplicates, count the number of occurrences of a given element.
     * @param arr       sorted array.
     * @param target    target number.
     * @return          return the count of occurrences of element, otherwise returns 0.
     *
     * Time Complexity  O(logN)
     */
    static public int duplicateCount(int[] arr, int target) {

        // index of first occurrence of target in array.
        int first_occ;

        // index of last occurrence of target in array.
        int last_occ;

        // array length
        int length = arr.length;

        // use first() method to get the index of first occurrence of target.
        first_occ = first(arr, 0, length-1, target, length);

        // if target does not contain in array then return 0;
        if (first_occ == -1) {
            return 0;
        }

        // use last() method to get last occurrence of target.
        last_occ = last(arr, first_occ, length-1, target, length);

        // return the count of occurrences.
        return last_occ - first_occ + 1;
    }

    // return the first occurrence of target.
    private static int first(int arr[], int start, int end, int target, int length)
    {
        if(start <= end)
        {
            // use `start + (end - start)` prevent overflow
            int mid = start + (end - start) / 2;
            if(( mid == 0 || target > arr[mid-1]) && arr[mid] == target) // find the first
                return mid;
            else if(target > arr[mid])
                // start = mid + 1
                return first(arr, (mid + 1), end, target, length);
            else
                // end = mid - 1
                return first(arr, start, (mid -1), target, length);
        }
        return -1;
    }

    // return the last occurrence of target.
    private static int last(int arr[], int start, int end, int target, int length)
    {
        if(start <= end)
        {
            // use `start + (end - start)` prevent overflow
            int mid = start + (end - start) / 2;
            if(( mid == length - 1 || target < arr[mid+1]) && arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                return last(arr, start, (mid - 1), target, length);
            else
                return last(arr, (mid + 1), end, target, length);
        }
        return -1;
    }

    /**
     *  Given the array nums after the possible rotation and an integer target,
     *  return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * @param arr       rotated sorted array
     * @param target    target number
     * @return          index of target number
     *
     * Time Complexity  O(logN)
     */
    static public int search(int[] arr, int target) {
        // check input arr
        if (arr.length == 0 || arr == null) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // use `start + (end - start)` prevent overflow
            int mid = start + (end - start) / 2;
            // find the target
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] >= arr[start]) {
                // if in ascending order
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                // if in descending order
                if (target <= arr[end] && target > arr[mid]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return  -1;
    }
}
