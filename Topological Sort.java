

class Solution {
    // Function to return list containing vertices in Topological order.
   static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        // Perform DFS for each unvisited node.
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, stack, vis);
            }
        }

        // Convert stack to ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        
        return ans;
    }

    // Helper method for DFS
    static void dfs(ArrayList<ArrayList<Integer>> adj, int V, Stack<Integer> stack, boolean[] vis) {
        vis[V] = true;
        for (int neighbour : adj.get(V)) {
            if (!vis[neighbour]) {
                dfs(adj, neighbour, stack, vis);
            }
        }
        stack.push(V); // Correctly pushing the current vertex V
    }
}
