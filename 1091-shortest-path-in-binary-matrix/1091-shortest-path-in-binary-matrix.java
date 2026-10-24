class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[n][n];
        for (int[] row : vis) {
            Arrays.fill(row, -1);
        }
        q.add(new int[]{0,0,1});
        vis[0][0] = 1;
        int ans = 0;
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            if(c-1 >= 0 && vis[r][c-1] == -1 && grid[r][c-1] == 0) {
                vis[r][c-1] = d+1;
                q.add(new int[]{r,c-1,d+1});
            }
            // Up
            if(r-1 >= 0 && vis[r-1][c] == -1 && grid[r-1][c] == 0) {
                vis[r-1][c] = d+1;
                q.add(new int[]{r-1, c, d+1});
            }

            // Down
            if(r+1 < n && vis[r+1][c] == -1 && grid[r+1][c] == 0) {
                vis[r+1][c] = d+1;
                q.add(new int[]{r+1, c, d+1});
            }

            // Right
            if(c+1 < n && vis[r][c+1] == -1 && grid[r][c+1] == 0) {
                vis[r][c+1] = d+1;
                q.add(new int[]{r, c+1, d+1});
            }

            // Top-left
            if(r-1 >= 0 && c-1 >= 0 &&
            vis[r-1][c-1] == -1 && grid[r-1][c-1] == 0) {
                vis[r-1][c-1] = d+1;
                q.add(new int[]{r-1, c-1, d+1});
            }

            // Top-right
            if(r-1 >= 0 && c+1 < n &&
            vis[r-1][c+1] == -1 && grid[r-1][c+1] == 0) {
                vis[r-1][c+1] = d+1;
                q.add(new int[]{r-1, c+1, d+1});
            }

            // Bottom-left
            if(r+1 < n && c-1 >= 0 &&
            vis[r+1][c-1] == -1 && grid[r+1][c-1] == 0) {
                vis[r+1][c-1] = d+1;
                q.add(new int[]{r+1, c-1, d+1});
            }

            // Bottom-right
            if(r+1 < n && c+1 < n &&
            vis[r+1][c+1] == -1 && grid[r+1][c+1] == 0) {
                vis[r+1][c+1] = d+1;
                q.add(new int[]{r+1, c+1, d+1});
            }
        }
        return vis[n-1][n-1];
    }
}