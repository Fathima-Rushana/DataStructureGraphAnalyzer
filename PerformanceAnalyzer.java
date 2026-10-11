import java.util.ArrayList;

/**
 * Performance / complexity demonstration.
 * Records the number of steps and execution time of searches and traversals
 * and prints them in a comparison table.
 */
public class PerformanceAnalyzer {
    private static final String LINE = "=".repeat(78);
    private static final String DASH = "-".repeat(78);

    private final ArrayList<String[]> results = new ArrayList<>();

    /** Stores one result row so that it can be shown later in "Display All Results". */
    public void record(String operation, String algorithm, long steps, long nanos, String details) {
        results.add(new String[]{operation, algorithm, String.valueOf(steps), String.valueOf(nanos), details});
    }

    public void recordSearch(Searching.SearchResult r, int key) {
        String details = (r.index >= 0 ? "found at index " + r.index : "not found") + " (key " + key + ")";
        record("Search", r.algorithm, r.steps, r.nanos, details);
    }

    public void recordTraversal(Graph.TraversalResult r, int start) {
        record("Graph Traversal", r.algorithm, r.steps, r.nanos, "start " + start + ", order " + r.order);
    }

    /** Compares linear and binary search on the given array and prints the table. */
    public void compareSearches(int[] array, int key) {
        if (array.length == 0) {
            System.out.println("The array is empty. Add data first (Array Operations).");
            return;
        }
        int[] sorted = Searching.sortedCopy(array);
        Searching.SearchResult lin = Searching.linear(sorted, key);
        Searching.SearchResult bin = Searching.binary(sorted, key);
        recordSearch(lin, key);
        recordSearch(bin, key);

        System.out.println(LINE);
        System.out.println("  SEARCH COMPARISON  (n = " + sorted.length + ", sorted copy of the array)");
        System.out.println(LINE);
        printHeader();
        printRow("Search", lin.algorithm, lin.steps, lin.nanos);
        printRow("Search", bin.algorithm, bin.steps, bin.nanos);
        System.out.println(DASH);
        System.out.println("Linear Search: " + (lin.index >= 0 ? "found at index " + lin.index : "not found"));
        System.out.println("Binary Search: " + (bin.index >= 0 ? "found at index " + bin.index : "not found"));
        System.out.println("Explanation: Linear search checks elements one by one -> O(n).");
        System.out.println("Binary search halves the search range each step -> O(log n),");
        System.out.println("so it needs far fewer steps on large sorted data.");
        System.out.println(LINE);
    }

    /** Compares BFS and DFS on the given graph and prints the table. */
    public void compareTraversals(Graph graph, int start) {
        if (graph.isEmpty()) {
            System.out.println("The graph is empty. Add vertices or load the sample graph first.");
            return;
        }
        Graph.TraversalResult bfs = graph.bfs(start);
        Graph.TraversalResult dfs = graph.dfs(start);
        if (bfs.order.isEmpty()) {
            return;
        }
        recordTraversal(bfs, start);
        recordTraversal(dfs, start);

        System.out.println(LINE);
        System.out.println("  GRAPH TRAVERSAL COMPARISON  (V = " + graph.getVertexCount()
                + ", E = " + graph.getEdgeCount() + ", start = " + start + ")");
        System.out.println(LINE);
        printHeader();
        printRow("Graph Traversal", bfs.algorithm, bfs.steps, bfs.nanos);
        printRow("Graph Traversal", dfs.algorithm, dfs.steps, dfs.nanos);
        System.out.println(DASH);
        System.out.println("BFS order: " + bfs.order);
        System.out.println("DFS order: " + dfs.order);
        System.out.println("Explanation: both visit every vertex and examine every edge,");
        System.out.println("so both are O(V + E). The visiting ORDER differs: BFS goes level by");
        System.out.println("level using a queue, DFS goes deep first using recursion (a stack).");
        System.out.println(LINE);
    }

    public void displayAll() {
        System.out.println(LINE);
        System.out.println("  ALL RECORDED RESULTS");
        System.out.println(LINE);
        if (results.isEmpty()) {
            System.out.println("No results recorded yet. Run a search or traversal first.");
            System.out.println(LINE);
            return;
        }
        System.out.printf("%-4s %-16s %-14s %-7s %-10s %s%n", "No.", "Operation", "Algorithm", "Steps", "Time(ns)", "Details");
        System.out.println(DASH);
        int n = 1;
        for (String[] r : results) {
            System.out.printf("%-4d %-16s %-14s %-7s %-10s %s%n", n++, r[0], r[1], r[2], r[3], r[4]);
        }
        System.out.println(LINE);
    }

    private void printHeader() {
        System.out.printf("%-18s %-16s %-10s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println(DASH);
    }

    private void printRow(String op, String alg, long steps, long nanos) {
        System.out.printf("%-18s %-16s %-10d %-12d%n", op, alg, steps, nanos);
    }
}
