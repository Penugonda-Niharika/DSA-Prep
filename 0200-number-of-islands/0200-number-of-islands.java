class Solution {
    void dfs(int r, int c, int[][] vis, char[][] arr,int n, int m) {
        if(r < 0 || r >= n || c < 0 || c >= m) return;
        if(arr[r][c] == '0' || vis[r][c] ==1) return;
        vis[r][c] = 1;
        dfs(r+1,c,vis,arr,n,m);
        dfs(r-1,c,vis,arr,n,m);
        dfs(r,c+1,vis,arr,n,m);
        dfs(r,c-1,vis,arr,n,m);
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    ans++;
                    dfs(i,j,vis,grid,n,m);
                }
            }
        }
        return ans;
    }
}