class Solution {
    public void setZeroes(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(m[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(row[i] || col[j]) {
                    m[i][j] = 0;
                } 
            }
        }

    }
}