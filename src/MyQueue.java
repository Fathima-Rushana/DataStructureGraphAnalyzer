/**
 * Queue component (FIFO) implemented as a circular array.
 */
public class MyQueue {
    private final int[] items;
    private int front;
    private int rear;
    private int count;

    public MyQueue(int capacity) {
        items = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() { return count == 0; }

    public boolean isFull() { return count == items.length; }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow! The queue is full.");
            return false;
        }
        rear = (rear + 1) % items.length;
        items[rear] = value;
        count++;
        return true;
    }

    /** Removes and returns the front element, or null if the queue is empty. */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot dequeue from an empty queue.");
            return null;
        }
        int value = items[front];
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    /** Returns the front element without removing it, or null if empty. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing at the front.");
            return null;
        }
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < count; i++) {
            System.out.print(items[(front + i) % items.length] + (i < count - 1 ? " <- " : ""));
        }
        System.out.println();
    }
}
