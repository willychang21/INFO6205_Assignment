public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};

        // Test of duplicateCount() method
        System.out.println("Target: 4 = " + sort.duplicateCount(arr, 4) + " Occurrences");
        System.out.println("Target: 2 = " + sort.duplicateCount(arr, 2) + " Occurrences");
        System.out.println("Target: 5 = " + sort.duplicateCount(arr, 5) + " Occurrences");

        int[] arr2 = {6, 7, 8, 2, 3, 4, 5};

        // Test of search() method
        System.out.println("Target: 8 = " + sort.search(arr2, 8));
        System.out.println("Target: 6 = " + sort.search(arr2, 6));

    }
}