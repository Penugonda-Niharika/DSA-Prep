class Solution {

    void bfs(int r, int c, int[][] grid, int[][] vis) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vis[r][c] = 1;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()) {

            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] d : dir) {

                int nr = row + d[0];
                int nc = col + d[1];

                if(nr >= 0 && nr < n &&
                   nc >= 0 && nc < m &&
                   grid[nr][nc] == 1 &&
                   vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        // Top and bottom boundaries
        for(int j = 0; j < m; j++) {

            if(grid[0][j] == 1 && vis[0][j] == 0)
                bfs(0, j, grid, vis);

            if(grid[n - 1][j] == 1 && vis[n - 1][j] == 0)
                bfs(n - 1, j, grid, vis);
        }

        // Left and right boundaries
        for(int i = 0; i < n; i++) {

            if(grid[i][0] == 1 && vis[i][0] == 0)
                bfs(i, 0, grid, vis);

            if(grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                bfs(i, m - 1, grid, vis);
        }

        int ans = 0;

        // Count land that was NOT reachable from boundary
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}