class Solution {
    void dfs(int c, boolean[] vis, int[][] arr, int n) {
        vis[c] = true;
        for(int i=0; i<n; i++) {
            if(arr[c][i] == 1 && !vis[i]) {
                dfs(i,vis,arr,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int p = 0;
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                p++;
                dfs(i,vis, isConnected,n);
            }
        }
        return p;
    }
}