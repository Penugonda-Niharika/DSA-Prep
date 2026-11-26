class Solution {
       boolean safe(int row, int col, char[][] board, int n) {

        // Check upper direction
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    void solve(int i,int n, char[][] board,List<List<String>> ans) {
        if(i == n) {
            List<String> temp = new ArrayList<>();
            for(int r=0; r<n; r++) {
                temp.add(new String(board[r]));
            }
            ans.add(temp);
            return;
        }
        for(int j=0; j<n; j++) {
            if(safe(i,j,board,n)) {
                board[i][j] = 'Q';
                solve(i+1,n,board,ans);
                board[i][j] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0,n,board,ans);
        return ans;
    }
}