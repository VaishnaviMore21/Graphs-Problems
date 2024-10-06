//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:

    void dfs(int node, vector<int> adj[], int vis[], vector<int> &ls) {
        vis[node]=1;
        ls.push_back(node);
        for(auto it:adj[node])
        {
            if(!vis[it])
            {
                dfs(it,adj,vis,ls);
            }
        }
    }
  
    // Function to return a list containing the DFS traversal of the graph.
    vector<int> dfsOfGraph(int V, vector<int> adj[]) {
        // Code here
         int vis[V] = {0}; 
        int start = 0;
        // create a list to store dfs
        vector<int> ls; 
        // call dfs for starting node
        dfs(start, adj, vis, ls); 
        return ls; 
}}
