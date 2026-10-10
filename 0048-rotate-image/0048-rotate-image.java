class Solution {
    public void rotate(int[][] mt) {
        int n = mt.length;
        int m = mt[0].length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<m; j++) {
               int t = mt[i][j];
               mt[i][j] = mt[j][i];
               mt[j][i] = t;
            }
        }
        for(int i=0; i<n; i++) {
            int l = 0, r = n-1;
            while(l<=r) {
                int t = mt[i][l];
                mt[i][l] = mt[i][r];
                mt[i][r] = t;
                l++;
                r--;
            }
        }
    }
}