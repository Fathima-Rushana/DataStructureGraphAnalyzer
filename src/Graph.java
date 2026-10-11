import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Graph component: an undirected graph stored as an adjacency list.
 * Supports add vertex, add edge, display, BFS and DFS.
 */
public class Graph {

    /** Holds the outcome of one traversal. */
    public static class TraversalResult {
        public final String algorithm;
        public final ArrayList<Integer> order = new ArrayList<>();
        public long steps;   // vertices visited + edges examined
        public long nanos;

        TraversalResult(String algorithm) { this.algorithm = algorithm; }
    }

    private final Map<Integer, ArrayList<Integer>> adjacency = new TreeMap<>();
    private int edgeCount = 0;

    public boolean hasVertex(int v) { return adjacency.containsKey(v); }

    public int getVertexCount() { return adjacency.size(); }

    public int getEdgeCount() { return edgeCount; }

    public boolean isEmpty() { return adjacency.isEmpty(); }

    public boolean addVertex(int v) {
        if (hasVertex(v)) {
            System.out.println("Vertex " + v + " already exists.");
            return false;
        }
        adjacency.put(v, new ArrayList<>());
        return true;
    }

    public boolean addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) {
            System.out.println("Both vertices must exist before adding an edge.");
            return false;
        }
        if (a == b) {
            System.out.println("Self-loops are not allowed.");
            return false;
        }
        if (adjacency.get(a).contains(b)) {
            System.out.println("Edge " + a + " - " + b + " already exists.");
            return false;
        }
        adjacency.get(a).add(b);
        adjacency.get(b).add(a);
        Collections.sort(adjacency.get(a));
        Collections.sort(adjacency.get(b));
        edgeCount++;
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Graph (adjacency list) - " + getVertexCount()
                + " vertices, " + edgeCount + " edges:");
        for (Map.Entry<Integer, ArrayList<Integer>> e : adjacency.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Clears the graph and loads a small sample graph (8 vertices). */
    public void loadSample() {
        adjacency.clear();
        edgeCount = 0;
        for (int v = 1; v <= 8; v++) addVertex(v);
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 7}};
        for (int[] e : edges) addEdge(e[0], e[1]);
    }

    /**
     * Breadth First Search using our own MyQueue. Time complexity O(V + E).
     */
    public TraversalResult bfs(int start) {
        TraversalResult result = new TraversalResult("BFS");
        if (!hasVertex(start)) {
            System.out.println("Start vertex " + start + " does not exist.");
            return result;
        }
        long t0 = System.nanoTime();
        java.util.Set<Integer> visited = new java.util.HashSet<>();
        MyQueue queue = new MyQueue(getVertexCount() + 1);
        queue.enqueue(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            result.order.add(current);
            result.steps++;                       // vertex visited
            for (int neighbour : adjacency.get(current)) {
                result.steps++;                   // edge examined
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.enqueue(neighbour);
                }
            }
        }
        result.nanos = System.nanoTime() - t0;
        return result;
    }

    /**
     * Depth First Search (recursive). Time complexity O(V + E).
     */
    public TraversalResult dfs(int start) {
        TraversalResult result = new TraversalResult("DFS");
        if (!hasVertex(start)) {
            System.out.println("Start vertex " + start + " does not exist.");
            return result;
        }
        long t0 = System.nanoTime();
        dfsVisit(start, new java.util.HashSet<>(), result);
        result.nanos = System.nanoTime() - t0;
        return result;
    }

    private void dfsVisit(int current, java.util.Set<Integer> visited, TraversalResult result) {
        visited.add(current);
        result.order.add(current);
        result.steps++;                           // vertex visited
        for (int neighbour : adjacency.get(current)) {
            result.steps++;                       // edge examined
            if (!visited.contains(neighbour)) {
                dfsVisit(neighbour, visited, result);
            }
        }
    }
}
