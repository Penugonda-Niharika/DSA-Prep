class Solution {
    int timer = 0;

    void dfs(int u, int parent, List<List<Integer>> adj, int low[], int disc[], int vis[], List<List<Integer>> ans) {
        vis[u] = 1;
        low[u] = disc[u] = ++timer;
        for (int v : adj.get(u)) {
            if (vis[v] == 0) {
                dfs(v, u, adj, low, disc, vis, ans);
                low[u] = Math.min(low[u], low[v]);
                if (disc[u] < low[v]) {
                    ans.add(Arrays.asList(u, v));
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int low[] = new int[n];
        int disc[] = new int[n];
        int vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, adj, low, disc, vis, ans);
            }
        }
        return ans;
    }
}