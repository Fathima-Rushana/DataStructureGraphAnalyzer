/**
 * Data Structure & Graph Performance Analyzer
 * Main class: shows the main menu and connects all components.
 */
public class Main {

    // One shared object of every component, so data stays between menus.
    private static final ArrayOps array = new ArrayOps(1000);
    private static final MyStack stack = new MyStack(10);
    private static final MyQueue queue = new MyQueue(10);
    private static final MyLinkedList list = new MyLinkedList();
    private static final Graph graph = new Graph();
    private static final PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println("   DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 9);
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: analyzer.displayAll(); break;
                case 9:
                    System.out.println("Thank you for using the program. Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    // ------------------------------------------------------------ ARRAY
    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (at an index)");
            System.out.println("2. Delete (at an index)");
            System.out.println("3. Search (by value)");
            System.out.println("4. Display");
            System.out.println("5. Load sample data (random numbers)");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value: ");
                    int index = InputHelper.readInt("Enter index (0 to " + array.getSize() + "): ");
                    if (array.insert(index, value)) System.out.println("Inserted.");
                    break;
                }
                case 2: {
                    int index = InputHelper.readInt("Enter index to delete: ");
                    if (array.deleteAt(index)) System.out.println("Deleted.");
                    break;
                }
                case 3: {
                    int value = InputHelper.readInt("Enter value to search: ");
                    int idx = array.search(value);
                    System.out.println(idx >= 0 ? "Found at index " + idx : "Value not found.");
                    break;
                }
                case 4: array.display(); break;
                case 5: {
                    int count = InputHelper.readInt("How many numbers (1 to " + array.getCapacity() + ")? ",
                            1, array.getCapacity());
                    array.loadSample(count);
                    System.out.println(count + " random numbers loaded.");
                    break;
                }
                case 6: back = true; break;
            }
        }
    }

    // ------------------------------------------------------------ STACK
    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value to push: ");
                    if (stack.push(value)) System.out.println("Pushed " + value);
                    break;
                }
                case 2: {
                    Integer v = stack.pop();
                    if (v != null) System.out.println("Popped: " + v);
                    break;
                }
                case 3: {
                    Integer v = stack.peek();
                    if (v != null) System.out.println("Top element: " + v);
                    break;
                }
                case 4: stack.display(); break;
                case 5: back = true; break;
            }
        }
    }

    // ------------------------------------------------------------ QUEUE
    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value to enqueue: ");
                    if (queue.enqueue(value)) System.out.println("Enqueued " + value);
                    break;
                }
                case 2: {
                    Integer v = queue.dequeue();
                    if (v != null) System.out.println("Dequeued: " + v);
                    break;
                }
                case 3: {
                    Integer v = queue.peek();
                    if (v != null) System.out.println("Front element: " + v);
                    break;
                }
                case 4: queue.display(); break;
                case 5: back = true; break;
            }
        }
    }

    // ------------------------------------------------------- LINKED LIST
    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n----------- LINKED LIST OPERATIONS -----------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete (by value)");
            System.out.println("4. Search (by value)");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value: ");
                    list.insertAtBeginning(value);
                    System.out.println("Inserted at beginning.");
                    break;
                }
                case 2: {
                    int value = InputHelper.readInt("Enter value: ");
                    list.insertAtEnd(value);
                    System.out.println("Inserted at end.");
                    break;
                }
                case 3: {
                    int value = InputHelper.readInt("Enter value to delete: ");
                    if (list.delete(value)) System.out.println("Deleted " + value);
                    break;
                }
                case 4: {
                    int value = InputHelper.readInt("Enter value to search: ");
                    int pos = list.search(value);
                    System.out.println(pos >= 0 ? "Found at position " + pos : "Value not found.");
                    break;
                }
                case 5: list.display(); break;
                case 6: back = true; break;
            }
        }
    }

    // --------------------------------------------------------- SEARCHING
    private static void searchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------- SEARCHING OPERATIONS -------------");
            System.out.println("(Searches the data stored in the Array component)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search (uses a sorted copy)");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (choice == 4) {
                back = true;
                continue;
            }
            if (array.isEmpty()) {
                System.out.println("The array is empty. Add data in Array Operations first.");
                continue;
            }
            int key = InputHelper.readInt("Enter value to search: ");
            switch (choice) {
                case 1: {
                    Searching.SearchResult r = Searching.linear(array.toArray(), key);
                    printSearch(r);
                    analyzer.recordSearch(r, key);
                    break;
                }
                case 2: {
                    System.out.println("Note: binary search needs sorted data, so a sorted copy is used.");
                    Searching.SearchResult r = Searching.binary(Searching.sortedCopy(array.toArray()), key);
                    printSearch(r);
                    analyzer.recordSearch(r, key);
                    break;
                }
                case 3: analyzer.compareSearches(array.toArray(), key); break;
            }
        }
    }

    private static void printSearch(Searching.SearchResult r) {
        System.out.println(r.algorithm + ": " + (r.index >= 0 ? "found at index " + r.index : "not found")
                + " | steps = " + r.steps + " | time = " + r.nanos + " ns");
    }

    // ------------------------------------------------------------- GRAPH
    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 7);
            switch (choice) {
                case 1: {
                    int v = InputHelper.readInt("Enter vertex number: ");
                    if (graph.addVertex(v)) System.out.println("Vertex " + v + " added.");
                    break;
                }
                case 2: {
                    int a = InputHelper.readInt("Enter first vertex: ");
                    int b = InputHelper.readInt("Enter second vertex: ");
                    if (graph.addEdge(a, b)) System.out.println("Edge " + a + " - " + b + " added.");
                    break;
                }
                case 3: graph.display(); break;
                case 4:
                case 5: {
                    if (graph.isEmpty()) {
                        System.out.println("Graph is empty. Add vertices or load the sample graph.");
                        break;
                    }
                    int start = InputHelper.readInt("Enter start vertex: ");
                    Graph.TraversalResult r = (choice == 4) ? graph.bfs(start) : graph.dfs(start);
                    if (!r.order.isEmpty()) {
                        System.out.println(r.algorithm + " order: " + r.order
                                + " | steps = " + r.steps + " | time = " + r.nanos + " ns");
                        analyzer.recordTraversal(r, start);
                    }
                    break;
                }
                case 6:
                    graph.loadSample();
                    System.out.println("Sample graph loaded.");
                    graph.display();
                    break;
                case 7: back = true; break;
            }
        }
    }

    // ------------------------------------------------------- PERFORMANCE
    private static void performanceMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------- PERFORMANCE COMPARISON -------------");
            System.out.println("1. Linear vs Binary Search (on the Array data)");
            System.out.println("2. BFS vs DFS (on the Graph)");
            System.out.println("3. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 3);
            switch (choice) {
                case 1: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty - loading 1000 sample numbers for the demo.");
                        array.loadSample(1000);
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    analyzer.compareSearches(array.toArray(), key);
                    break;
                }
                case 2: {
                    if (graph.isEmpty()) {
                        System.out.println("Graph is empty - loading the sample graph for the demo.");
                        graph.loadSample();
                    }
                    int start = InputHelper.readInt("Enter start vertex: ");
                    analyzer.compareTraversals(graph, start);
                    break;
                }
                case 3: back = true; break;
            }
        }
    }
}
