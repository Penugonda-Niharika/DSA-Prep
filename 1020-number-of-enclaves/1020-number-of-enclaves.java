class Solution {
    void dfs(int r, int c, int[][] arr, int n, int m) {
        if(r < 0 || r >= n || c < 0 || c >= m) return;
        if (arr[r][c] == 0) return;
        arr[r][c] = 0;
        dfs(r+1, c, arr, n, m);
        dfs(r-1, c, arr, n, m);
        dfs(r, c+1, arr, n, m);
        dfs(r, c-1, arr, n, m);
    }
    public int numEnclaves(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0; i<n; i++) {
            if(arr[i][0] == 1) {
                dfs(i,0,arr,n,m);
            }
            if(arr[i][m-1] == 1) {
                dfs(i,m-1,arr,n,m);
            }
        }
        for(int i=0; i<m; i++) {
            if(arr[0][i] == 1) {
                dfs(0,i,arr,n,m);
            }
            if(arr[n-1][i] == 1) {
                dfs(n-1,i,arr,n,m);
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1) ans++;
            }
        }
        return ans;
    }
}