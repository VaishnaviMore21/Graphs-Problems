
/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int V = adj.size();
        int[] dist = new int[V]; 
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances to infinity
        dist[src] = 0;

        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()) {
            iPair cur = pq.poll();
            int u = cur.first;
            int curDist = cur.second;

            if (curDist > dist[u]) continue; // Skip outdated distances

            for (iPair neighbor : adj.get(u)) {
                int v = neighbor.first;
                int weight = neighbor.second;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new iPair(v, dist[v]));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) result.add(d);
        return result;
    }
}
