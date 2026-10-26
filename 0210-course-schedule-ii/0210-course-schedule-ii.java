class Solution {
    boolean e;
    void dfs(int u, int vis[], int path[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = 1;
        path[u] = 1;
        for(int v : adj.get(u)) {
            if(vis[v] == 0) {
                dfs(v,vis,path,st,adj);
            } else if(vis[v] == 1 && path[v] == 1) {
                e = true;
                return;
            }
        }
        path[u] =0;
        st.push(u);
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        int vis[] = new int[n];
        int path[] = new int[n];
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, path, st, adj);
            }
        }
        int[] result = new int[st.size()];
        int i=0;
        while (!st.isEmpty()) {
            result[i] = st.pop();
            i++;
        }
        if(e) return new int[]{};
        return result;
    }
}