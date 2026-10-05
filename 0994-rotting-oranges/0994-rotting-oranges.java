class Solution {
    int bfs(int[][] arr, int[][] vis, Queue<int []> q) {
        int n = arr.length;
        int m = arr[0].length;
        int time = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            time = Math.max(time, t);
            if(r+1 < n && arr[r+1][c] == 1 && vis[r+1][c] == 0) {
                vis[r+1][c] = 2;
                q.add(new int[]{r+1, c, t+1});
            }
            if(r-1 >= 0 && arr[r-1][c] == 1 && vis[r-1][c] == 0) {
                vis[r-1][c] = 2;
                q.add(new int[]{r-1, c, t+1});
            }
            if(c+1 < m && arr[r][c+1] == 1 && vis[r][c+1] == 0) {
                vis[r][c+1] = 2;
                q.add(new int[]{r, c+1, t+1});
            }
            if(c-1 >= 0 && arr[r][c-1] == 1 && vis[r][c-1] == 0) {
                vis[r][c-1] = 2;
                q.add(new int[]{r, c-1, t+1});
            }
        }
        return time;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2 && vis[i][j] == 0) {
                    vis[i][j] = 2;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        int cnt = bfs(grid, vis, q);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    return -1;
                }
            }
        }
        return cnt;
    }
}