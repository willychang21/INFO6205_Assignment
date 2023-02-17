import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    // beginning of bag
    private Node<Item> first;
    // number of elements in bag
    private int size;

    // Node: linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // Initializes an empty bag.
    public Bag() {
        first = null;
        size = 0;
    }

    // Returns true if this bag is empty.
    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this bag.
    public int size() {
        return size;
    }

    // Adds the item to this bag.
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    // Return a random element from the bag.
    public Item grab() {
        int random_index = (int)Math.floor(Math.random() * (size));
        // System.out.println("random index is: " + random_index);
        Node<Item> n = first;
        while (random_index > 0) {
            n = n.next;
            random_index--;
        }
        return n.item;
    }

    // Remove the item from this bag.
    public boolean remove(Item item) {
        if (isEmpty()) {
            return false;
        }

        Node<Item> n = first;
        Node<Item> prev = null;
        while ((n != null) && (!n.item.equals(item))) {
            prev = n;
            n = n.next;
        }
        if (n != null) {
            if (n == first) {
                first = first.next;
            } else {
                prev.next = n.next;
            }
            size --;
            return true;
        }
        return false;
    }

    // Clear all elements from the bag.
    public void clear() {
        first = null;
    }

    // Searches for specified element in this bag.
    public boolean contains(Item item) {
        boolean found = false;
        Node<Item> p = this.first;
        while ((!found) && (p != null)) {
            if (p.item.equals(item)) {
                found = true;
            }
            p = p.next;
        }
        return found;
    }

    // transform all elements in bag to string
    @Override public String toString() {
        String result = "";
        Node<Item> n = first;
        while (n != null) {
            result += n.item + " ";
            n = n.next;
        }
        return result;
    }

    // return an array with all of the elements in the bag
    public Item[] toArray() {
        Item[] arr = (Item[]) new Object[size];
        Node<Item> n = first;
        for (int index = 0; index < size; index++) {
            arr[index] = n.item;
            n = n.next;
        }
        return arr;
    }


    // Returns an iterator that iterates over the items in this bag in arbitrary order.
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    // an iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}