class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Step 1: Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Prevent overflow
            dist[i][i] = 0;
        }

        // Step 2: Fill adjacency matrix from edges
        for (int i = 0; i < edges.length; i++) { // Fix: Iterate over edges, not 'n'
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Step 3: Floyd-Warshall Algorithm to compute shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Step 4: Find the city with the smallest reachable city count
        int minReachable = Integer.MAX_VALUE;
        int cityNo = -1;

        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (adjCity != city && dist[city][adjCity] <= distanceThreshold) { // Fix: Exclude itself
                    cnt++;
                }
            }

            // Choose the city with a smaller reachable count, or larger index in case of a tie
            if (cnt <= minReachable) {
                minReachable = cnt;
                cityNo = city;
            }
        }

        return cityNo;
    }
}
