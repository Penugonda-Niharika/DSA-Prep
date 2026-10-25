class Solution {
    int dfs(int r, int c, int[][] vis, int[][] arr,int n, int m) {
        if(r < 0 || r >= n || c < 0 || c >= m) return 0;
        if(arr[r][c] == 0 || vis[r][c] ==1) return 0;
        vis[r][c] = 1;
        int d = dfs(r+1,c,vis,arr,n,m);
        int u = dfs(r-1,c,vis,arr,n,m);
        int rt = dfs(r,c+1,vis,arr,n,m);
        int l = dfs(r,c-1,vis,arr,n,m);
        return d+u+rt+l+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    int l = dfs(i,j,vis,grid,n,m);
                    ans = Math.max(ans, l);
                }
            }
        }
        return ans;
    }
}