class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[]dist=new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        for(int i=0;i<V;i++)
        {
            for(int[]edge:edges)
            {
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if(dist[u]!=1e8 && dist[u]+wt<dist[v])
                {
                      if (i == V - 1)
                        return new int[]{-1};
                    
                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
}
