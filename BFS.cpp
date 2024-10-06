
class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
       vector<int> vis(V, 0);
        vis[0] = 1; // Mark the starting node as visited
        
        // Initialize the queue and BFS result
        queue<int> q;
        vector<int> bfs;
        
        // Start BFS from node 0
        q.push(0);
        
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            bfs.push_back(node); // Corrected here
            
            // Explore the neighbors
            for (auto it : adj[node]) { // Corrected from 'nodes' to 'node'
                if (!vis[it]) {
                    vis[it] = 1; // Mark as visited
                    q.push(it); // Add to the queue
                }
            }
        }
        
        return bfs; // Corrected missing semicolon
 // Code here
    }
};

