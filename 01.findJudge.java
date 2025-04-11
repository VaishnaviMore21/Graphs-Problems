class Solution {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;

        // If there are fewer trust relationships than (n - 1),
        // it's impossible for someone to be trusted by everyone else.
        if (len < n - 1) {
            return -1;
        }

        // Initialize indegree and outdegree arrays to count trust relationships
        // indegree[i] = number of people who trust person i
        // outdegree[i] = number of people person i trusts
        int indegree[] = new int[n + 1];
        int outdegree[] = new int[n + 1];

        // Loop through each trust pair: [a, b] means a trusts b
        for (int i = 0; i < len; i++) {
            outdegree[trust[i][0]]++; // a trusts someone
            indegree[trust[i][1]]++;  // b is trusted by someone
        }

        // The town judge is trusted by everyone (indegree = n - 1),
        // and trusts no one (outdegree = 0)
        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1)
                return i; // Found the judge
        }

        // No judge found
        return -1;
    }
}
