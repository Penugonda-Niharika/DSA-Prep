class Solution {
    public void rotate(int[][] mt) {
        int n = mt.length;
        int m = mt[0].length;
        int t[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                t[i][j] = mt[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                mt[j][n-1-i] = t[i][j];
            }
        }
    }
}