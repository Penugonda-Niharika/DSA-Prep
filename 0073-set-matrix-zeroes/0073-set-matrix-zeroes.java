class Solution {
    public void setZeroes(int[][] mt) {
        int n = mt.length;
        int m = mt[0].length;
        boolean fr = false;
        boolean fc = false;
        for(int i=0; i<n; i++) {
            if(mt[i][0] == 0) fc = true;
        }
        for(int i=0; i<m; i++) {
            if(mt[0][i] == 0) fr = true;
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(mt[i][j] == 0) {
                    mt[i][0] = 0;
                    mt[0][j] = 0;
                }
            }
        }
        for(int i=1; i<n; i++) {
            if(mt[i][0] == 0) {
                for(int j=1; j<m; j++) {
                    mt[i][j] = 0;
                }
            }
        }
        for(int j=1; j<m; j++) {
            if(mt[0][j] == 0) {
                for(int i=1; i<n; i++) {
                    mt[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int i=0; i<m; i++) {
                mt[0][i] = 0;
            }
        }
        if(fc) {
            for(int i=0; i<n; i++) {
                mt[i][0] = 0;
            }
        }
    }
}