class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0}); // {weight, vertex}
        boolean[]vis=new boolean[V];
        int mstweight=0;
        while(!pq.isEmpty())
        {
            int []node=pq.poll();
            int wt=node[0];
            int v=node[1];
            if(vis[v])continue;
            vis[v]=true;
            mstweight+=wt;
            for(int []neighbor:adj.get(v))
            {
                 int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (!vis[adjNode]) {
                    pq.add(new int[]{edgeWeight, adjNode});
            }
        }
        
        
        
        
    }
     return mstweight;
}
}
