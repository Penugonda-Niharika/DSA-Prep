class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int arr[] = new int[2];
        int xor = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                xor ^= grid[i][j];
               
            }
        }

        for(int i=1; i<=n*n; i++) {
            xor ^= i;
        }
        int rbit = xor & -xor;
        int g1 = 0;
        int g2 = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if((grid[i][j] & rbit)!=0) {
                    g1 ^= grid[i][j];
                } else {
                    g2 ^= grid[i][j];
                }
            }
        }

        for(int i=1; i<=n*n; i++) {
            if((i & rbit)!=0) {
                g1 ^= i;
            } else {
                g2 ^= i;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == g1) {
                    arr[0] = g1;
                    arr[1] = g2;
                    break;
                } 
                if(grid[i][j] == g2) {
                    arr[0] = g2;
                    arr[1] = g1;
                    break;
                } 
            }
        }
        return arr;
    }
}