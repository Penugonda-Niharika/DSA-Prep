class Solution {
    void dfs(int r, int c, int vis[][], char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            if(row + 1 < n && grid[row+1][col] == '1' && vis[row+1][col] == 0) {
                q.add(new int[]{row+1, col});
                vis[row+1][col] = 1;
            }
            if(row - 1 >= 0 && grid[row-1][col] == '1' && vis[row-1][col] == 0) {
                q.add(new int[]{row-1, col});
                vis[row-1][col] = 1;
            }
            if(col + 1 < m && grid[row][col+1] == '1' && vis[row][col+1] == 0) {
                q.add(new int[]{row, col+1});
                vis[row][col+1] = 1;
            }
            if(col - 1 >= 0 && grid[row][col-1] == '1' && vis[row][col-1] == 0) {
                q.add(new int[]{row, col-1});
                vis[row][col-1] = 1;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt=0;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(vis[r][c] == 0 && grid[r][c] == '1') {
                    cnt++;
                    dfs(r,c,vis,grid);
                }
            }
        }
        return cnt;
    }
}