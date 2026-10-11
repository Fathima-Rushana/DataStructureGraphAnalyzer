/**
 * Linked List component: a singly linked list of integers.
 */
public class MyLinkedList {

    /** A single node of the list. */
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public boolean isEmpty() { return head == null; }

    public int getSize() { return size; }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    /** Deletes the first node that contains value. Returns true if deleted. */
    public boolean delete(int value) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Value " + value + " was not found in the list.");
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    /** Returns the position (starting at 0) of value, or -1 if not found. */
    public int search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null   (size = " + size + ")");
    }
}
