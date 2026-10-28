class Solution {
    private int timer = 0;
    void dfs(int node, int parent, List<List<Integer>> adj,int vis[], int low[], int disc[], List<List<Integer>> ans) {
        vis[node] = 1;
        disc[node] = low[node] = ++timer;
        for(int v : adj.get(node)) {
            if(v == parent) continue;
            if(vis[v] == 0) {
                dfs(v,node,adj,vis,low,disc,ans);
                low[node] = Math.min(low[node], low[v]);
                if(low[v] > disc[node]) {
                    ans.add(Arrays.asList(node,v));
                }
            } else {
                low[node] = Math.min(low[node], disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int disc[] = new int[n];
        int low[] = new int[n];
        int vis[] = new int[n];
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0,-1,adj,vis,low,disc,ans);
        return ans;
    }
}