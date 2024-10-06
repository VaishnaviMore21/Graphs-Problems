

// } Driver Code Ends
class Solution
{
	public:
	//Function to return list containing vertices in Topological order. 
	vector<int> topoSort(int V, vector<int> adj[]) 
	{
	    // code here
	    vector<int>indegree(V);
	    
	     for (int i = 0; i < V; i++)
        {
            for (int j : adj[i])
            {
                indegree[j]++;
            }
        }
	    queue<int>q;
	    for(int i=0;i<V;i++)
	    {
	        if(indegree[i]==0)
	        { 
	          q.push(i);  
	        }
	    }
	    
	    vector<int>ans;
	    while(!q.empty())
	    {
	        int front=q.front();
	        q.pop();
	        ans.push_back(front);
	        
	        
	        //check neighbours
	        for(auto neighbour:adj[front])
	        {
	            indegree[neighbour]--;
	            if(indegree[neighbour]==0)
	            {
	                q.push(neighbour);
	            }
	        }
	        
	    }
	    return ans;
	    
	}
};


// } Driver Code Ends
