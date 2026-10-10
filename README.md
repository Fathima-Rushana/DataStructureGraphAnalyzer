# Data Structure and Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12)
**Language:** Java (console-based application)

## Project Description
A single integrated Java console application that demonstrates the Array, Stack, Queue,
Linked List, Searching (Linear and Binary) and Graph (BFS and DFS) data structures and
algorithms. The Performance Comparison module records the number of steps and the
execution time of searches and graph traversals and relates the results to algorithmic
complexity.

## Team Members

### Member 1
- **Student Name:** JAF.Rushana
- **Student ID:** 23DA2-0500
- **Assigned Responsibility:** Array and Searching
- **Individual Contribution:**
  - Implemented the ArrayOps class (insert, delete, search, display)
  - Implemented Linear Search and Binary Search with step counting and timing (Searching class)
  - Tested the array and searching components with normal, empty and invalid inputs
  - Integrated the array and searching modules with the main application

### Member 2
- **Student Name:** ARS.Farwin
- **Student ID:** 23DA2-0510
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented the MyStack class (push, pop, peek, display)
  - Implemented the MyQueue class as a circular array (enqueue, dequeue, peek, display)
  - Handled stack underflow/overflow and queue underflow/overflow
  - Tested and integrated the stack and queue modules with the main application

### Member 3
- **Student Name:** HM.AASATH
- **Student ID:** 23DA2-1094
- **Assigned Responsibility:** Linked List
- **Individual Contribution:**
  - Implemented the MyLinkedList class with a Node class
  - Implemented insert at beginning, insert at end, delete, search and display
  - Handled empty list and value-not-found cases
  - Tested and integrated the linked list module with the main application

### Member 4
- **Student Name:** NM.MUFEER
- **Student ID:** 23DA2-1045
- **Assigned Responsibility:** Graph, Performance Comparison and Main menu (integration)
- **Individual Contribution:**
  - Implemented the Graph class (adjacency list, add vertex, add edge, display)
  - Implemented BFS and DFS traversal with step counting
  - Implemented PerformanceAnalyzer (Linear vs Binary, BFS vs DFS comparison tables)
  - Implemented the main menu, InputHelper (input validation) and system integration/testing

## Technologies Used
- Java (JDK 11 or higher)
- Git and GitHub for collaboration

## Project Structure
```
src/
  Main.java                 Main menu and integration of all components
  InputHelper.java          Safe console input and input validation
  ArrayOps.java             Array: insert, delete, search, display
  MyStack.java              Stack: push, pop, peek, display
  MyQueue.java              Queue (circular array): enqueue, dequeue, peek, display
  MyLinkedList.java         Linked list: insert, delete, search, display
  Searching.java            Linear search and binary search (with step counting)
  Graph.java                Graph (adjacency list): add vertex, add edge, display, BFS, DFS
  PerformanceAnalyzer.java  Performance comparison tables and stored results
```

## Main Features
- Menu-driven console system with a submenu for every component
- Input validation (invalid numbers, out-of-range choices, invalid index or vertex)
- Handling of empty structures (stack underflow, queue underflow, empty list, empty graph)
- Linear vs Binary search comparison (steps and time)
- BFS vs DFS comparison on the graph (steps, time and traversal order)
- "Display All Results" keeps a record of every search and traversal done

## Complexity Summary
| Operation | Algorithm | Time Complexity |
|---|---|---|
| Search | Linear Search | O(n) |
| Search | Binary Search (sorted data) | O(log n) |
| Graph traversal | BFS | O(V + E) |
| Graph traversal | DFS | O(V + E) |
| Stack push / pop / peek | Array | O(1) |
| Queue enqueue / dequeue | Circular array | O(1) |
| Linked list insert at beginning | - | O(1) |
| Linked list search / delete | - | O(n) |

## How to Run
1. Install JDK 11 or higher (check with `java -version` and `javac -version`).
2. Open a terminal in the project folder.
3. Compile:
   ```
   mkdir out
   javac -d out src/*.java
   ```
4. Run:
   ```
   java -cp out Main
   ```
(Or open the folder in VS Code / IntelliJ and run `Main.java`.)
