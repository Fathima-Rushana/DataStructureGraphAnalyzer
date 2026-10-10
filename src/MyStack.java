/**
 * Stack component (LIFO) implemented with an array.
 */
public class MyStack {
    private final int[] items;
    private int top;

    public MyStack(int capacity) {
        items = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }

    public boolean isFull() { return top == items.length - 1; }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow! The stack is full.");
            return false;
        }
        items[++top] = value;
        return true;
    }

    /** Removes and returns the top element, or null if the stack is empty. */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Cannot pop from an empty stack.");
            return null;
        }
        return items[top--];
    }

    /** Returns the top element without removing it, or null if empty. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
