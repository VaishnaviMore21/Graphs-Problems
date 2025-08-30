class Solution {

    // Step 1: Standard DFS to fill the stack based on finishing times
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; // Mark node as visited
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st); // Visit all adjacent nodes
            }
        }
        st.push(node); // Push node to stack after exploring all descendants
    }

    // Step 3: DFS on the transposed graph
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1; // Mark node as visited
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT); // Visit all reachable nodes in the transposed graph
            }
        }
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // Total number of vertices in the graph
        int[] vis = new int[V]; // Visited array
        Stack<Integer> st = new Stack<>(); // Stack to store the order of nodes

        // Step 1: Perform DFS to fill the stack with finishing times
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Create the transpose of the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>()); // Initialize empty adjacency list for transpose
        }

        // Reverse the direction of all edges to build transpose
        for (int i = 0; i < V; i++) {
            vis[i] = 0; // Reset visited array for second DFS
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i); // Reverse edge from i -> it to it -> i
            }
        }

        // Step 3: Perform DFS on the transposed graph in the order defined by the stack
        int scc = 0; // Count of strongly connected components
        while (!st.isEmpty()) {
            int node = st.pop(); // Get the top node
            if (vis[node] == 0) {
                scc++; // Found a new SCC
                dfs3(node, vis, adjT); // Explore entire SCC
            }
        }

        return scc; // Return the total number of strongly connected components
    }
}
