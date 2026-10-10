import java.util.Random;

/**
 * Array component: a fixed-size integer array with insert, delete,
 * search and display operations.
 */
public class ArrayOps {
    private final int[] data;
    private int size;

    public ArrayOps(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int getSize() { return size; }

    public int getCapacity() { return data.length; }

    public boolean isEmpty() { return size == 0; }

    /** Inserts value at the given index, shifting later elements to the right. */
    public boolean insert(int index, int value) {
        if (size == data.length) {
            System.out.println("Array is full. Cannot insert.");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index. Valid range is 0 to " + size + ".");
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Deletes the element at the given index, shifting later elements to the left. */
    public boolean deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Array is empty. Nothing to delete.");
            return false;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Valid range is 0 to " + (size - 1) + ".");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Linear search. Returns the index of value or -1 if not found. */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** Displays the array (only the first 50 elements if it is large). */
    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array (" + size + "/" + data.length + "): [");
        int limit = Math.min(size, 50);
        for (int i = 0; i < limit; i++) {
            System.out.print(data[i] + (i < limit - 1 ? ", " : ""));
        }
        if (size > limit) {
            System.out.print(", ... (" + (size - limit) + " more)");
        }
        System.out.println("]");
    }

    /** Returns a copy of the used part of the array. */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    /** Clears the array and fills it with random numbers (1 to 5000) for testing. */
    public void loadSample(int count) {
        size = 0;
        Random rnd = new Random(42);
        for (int i = 0; i < count && i < data.length; i++) {
            data[size++] = rnd.nextInt(5000) + 1;
        }
    }
}
