import java.util.*;

class Solution {

    // Main method to count the number of complete components
    public int countCompleteComponents(int n, int[][] edges) {

        // Step 1: Build the graph as an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Initialize each node's neighbor list
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v); // Add edge u->v
            graph.get(v).add(u); // Add edge v->u (undirected graph)
        }

        // Step 2: Initialize visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        int completeCount = 0; // This will store the number of complete components

        // Step 3: Traverse all nodes in the graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // If the node is unvisited, it's the start of a new component
                Set<Integer> component = new HashSet<>();
                dfs(i, graph, visited, component); // Explore all nodes in this component

                // Step 4: Check if the component is complete
                int size = component.size(); // Number of nodes in the component
                int expectedEdges = size * (size - 1) / 2; // Edges needed for a complete graph
                int actualEdges = 0;

                // Count actual edges in the component
                for (int node : component) {
                    actualEdges += graph.get(node).size(); // Sum of degrees
                }
                actualEdges /= 2; // Divide by 2 because each edge is counted twice

                // If actual edges match expected, the component is complete
                if (actualEdges == expectedEdges) {
                    completeCount++; // Increment the count of complete components
                }
            }
        }

        // Step 5: Return the total number of complete components
        return completeCount;
    }

    // DFS helper method to explore a connected component
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, Set<Integer> component) {
        visited[node] = true; // Mark the current node as visited
        component.add(node);   // Add the node to the current component
        for (int neighbor : graph.get(node)) { // Explore all neighbors
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component); // Recursive DFS call
            }
        }
    }
}
