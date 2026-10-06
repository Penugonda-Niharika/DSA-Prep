class Solution {
    void sol(char[][] arr, Queue<int []> q, int[][] vis) {
        int n = arr.length;
        int m = arr[0].length;
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            if(r+1 < n && arr[r+1][c] == 'O' && vis[r+1][c] == 0) {
                vis[r+1][c] = 1;
                q.add(new int[]{r+1, c});
            }
            if(r-1 >= 0 && arr[r-1][c] == 'O' && vis[r-1][c] == 0) {
                vis[r-1][c] = 1;
                q.add(new int[]{r-1, c});
            }
            if(c+1 < m && arr[r][c+1] == 'O' && vis[r][c+1] == 0) {
                vis[r][c+1] = 1;
                q.add(new int[]{r, c+1});
            }
            if(c-1 >= 0 && arr[r][c-1] == 'O' && vis[r][c-1] == 0) {
                vis[r][c-1] = 1;
                q.add(new int[]{r, c-1});
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int []> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0; i<m; i++) {
            if(board[0][i] == 'O' && vis[0][i] == 0) {
                q.add(new int[]{0,i});
                vis[0][i] = 1;
            }
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0) {
                q.add(new int[]{n-1,i});
                vis[n-1][i] = 1;
            }
        }
        for(int i=0; i<n; i++) {
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                q.add(new int[]{i,0});
                vis[i][0] = 1;
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) {
                q.add(new int[]{i,m-1});
                vis[i][m-1] = 1;
            }
        }
        sol(board, q, vis);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) board[i][j] = 'X';
            }
        }
    }
}