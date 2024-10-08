
class Solution
{
	public:
	//Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int V, vector<vector<int>> adj[])
    {
        // code here 
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        vector<int> vis(V, 0);
        pq.push({0, 0}); // Starting from node 0 with weight 0
        int sum = 0;
        
        while (!pq.empty()) {
            auto it = pq.top();
            pq.pop();
            int node = it.second;
            int wt = it.first;

            if (vis[node]) continue; // If already visited, skip

            // Add to the MST
            vis[node] = 1;
            sum += wt;
            
            // Explore neighbors
            for (auto edge : adj[node]) {
                int adjNode = edge[0];
                int edW = edge[1];
                if (!vis[adjNode]) {
                    pq.push({edW, adjNode});
                }
            }
        }
        return sum;
    }

};

