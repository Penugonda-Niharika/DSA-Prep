class Solution {
    void bfs(int[][] arr, int[][] vis,  Queue<int []> q, int ans[][]) {
        int n = arr.length;
        int m = arr[0].length;
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
              if(r+1 < n && arr[r+1][c] == 1 && vis[r+1][c] == 0) {
                vis[r+1][c] = 1;
                q.add(new int[]{r+1, c});
                ans[r+1][c] = 1 + ans[r][c];
            }
            if(r-1 >= 0 && arr[r-1][c] == 1 && vis[r-1][c] == 0) {
                vis[r-1][c] = 1;
                q.add(new int[]{r-1, c});
                ans[r-1][c] = 1 + ans[r][c];
            }
            if(c+1 < m && arr[r][c+1] == 1 && vis[r][c+1] == 0) {
                vis[r][c+1] = 1;
                q.add(new int[]{r, c+1});
                ans[r][c+1] = 1 + ans[r][c];
            }
            if(c-1 >= 0 && arr[r][c-1] == 1 && vis[r][c-1] == 0) {
                vis[r][c-1] = 1;
                q.add(new int[]{r, c-1});
                ans[r][c-1] = 1 + ans[r][c];
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0 && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    q.add(new int[]{i,j});
                }
            }
        }
        bfs(mat, vis, q, ans);
        return ans;
    }
}