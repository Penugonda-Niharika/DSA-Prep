class Solution {
    boolean dfs(int u, int[] color, int[][] arr) {
        for(int v : arr[u]) {
            if(color[v] == -1) {
                color[v] = 1 - color[u];
                if(!dfs(v, color, arr)) return false;
            } else if(color[v] == color[u]) return false;
        } 
        return true;
    } 
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                if(!dfs(i, color, graph)) return false;
            }
        }
        return true;
    }
}