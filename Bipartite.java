#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool check(int start, vector<vector<int>>& adj, vector<int>& color) {
        queue<int> q;
        q.push(start);
        color[start] = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            for (auto it : adj[node]) {
                // If the adjacent node is not colored, assign opposite color
                if (color[it] == -1) {
                    color[it] = !color[node];
                    q.push(it);
                }
                // If the adjacent node has the same color, it's not bipartite
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    bool isBipartite(vector<vector<int>>& adj) {
        int V = adj.size();  // Get the number of vertices
        vector<int> color(V, -1); // -1 indicates uncolored nodes

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // If not colored, start BFS
                if (!check(i, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
};
