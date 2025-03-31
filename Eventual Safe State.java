
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length; // Number of vertices
        
        // Step 1: Reverse the Graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Reverse edges and compute indegree
        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        // Step 2: Topological Sorting (Kahn's Algorithm)
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        // Nodes with indegree 0 are safe
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Step 3: Sort safe nodes in ascending order
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
