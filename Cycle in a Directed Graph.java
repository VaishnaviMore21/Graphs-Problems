

class Solution {
    // Function to detect cycle in a directed graph.
   
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean recs[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, recs)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean recs[]) {
        vis[V] = true;
        recs[V] = true;
        for (Integer neighbour : adj.get(V)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, recs)) {
                    return true;
                }
            } else if (recs[neighbour]) {
                return true;
            }
        }
        recs[V] = false; // Backtrack
        return false;
    }
}
