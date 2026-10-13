class Solution {
    boolean dfs(int node, int[] vis, int[] path, int[] safe, int[][] graph) {
        vis[node] = 1;
        path[node] = 1;
        for(int x : graph[node]) {
            if(vis[x] == 0) {
                if(!dfs(x, vis,path,safe,graph)) return false;
            } else if(path[x] == 1) return false;
            else if(safe[x] == 0) return false;
        }
        path[node] = 0;
        safe[node] = 1;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int vis[] = new int[v];
        int path[] = new int[v];
        int safe[] = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<v; i++) {
            if(vis[i] == 0) {
                dfs(i, vis, path, safe, graph);
            }
        }
        for(int i=0; i<v; i++) {
            if(safe[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
}