class Solution {

    // DFS function to visit all nodes in the same connected component (province)
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int[] vis) {
        vis[node] = 1; // mark the current node as visited
        // Visit all neighbors of this node
        for (int neighbour : adjLs.get(node)) {
            if (vis[neighbour] == 0) { // if neighbor is not visited
                dfs(neighbour, adjLs, vis); // recursively visit neighbor
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length; // number of cities/nodes

        // Convert adjacency matrix to adjacency list for easier DFS traversal
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) adjLs.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Add an edge if cities i and j are connected, excluding self-loops
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                }
            }
        }

        int[] vis = new int[V]; // visited array to keep track of visited cities
        int cnt = 0; // count of provinces

        // Traverse all nodes
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) { // if the city is not yet visited
                cnt++; // this is a new province
                dfs(i, adjLs, vis); // visit all cities in this province
            }
        }

        return cnt; // return total number of provinces
    }
}
