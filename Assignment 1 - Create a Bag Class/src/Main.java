import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object for user input.
        Scanner in = new Scanner(System.in);

        // Create a Bag.
        Bag bag = new Bag();

        // 1. Test isEmpty method.
        System.out.println("The bag is empty(T/F): " + bag.isEmpty());

        // 2. Test add(T Item) method.
        bag.add(3);
        bag.add(7);
        bag.add("haha");
        bag.add(3.785);
        bag.add("will");

        // 3. Test size() method.
        System.out.println("The size of bag is: " + bag.size());

        // 4. Test contain(T item) method.
        System.out.println("The bag contains 3 (T/F):" + bag.contains(3));
        System.out.println("The bag contains dada (T/F): " + bag.contains("dada"));

        // 5. Test grab() method.
        System.out.println("Grab a random element: " + bag.grab());

        // 6. Test toString() method.
        System.out.println("Transform bag to String: " + bag.toString());

        // 7. Test toArray() method.
        System.out.print("The bag contains the following item(s): ");
        Object[] bagArray = bag.toArray();
        for (int index = 0; index < bagArray.length; index ++) {
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();

        // 8. Test remove(T item) method.
        bag.remove(7);
        System.out.println("The bag contains 7 (T/F):" + bag.contains(7));

        // 9. Test clear() method.
        bag.clear();
        System.out.println("The bag is empty(T/F): " + bag.isEmpty());
    }
}