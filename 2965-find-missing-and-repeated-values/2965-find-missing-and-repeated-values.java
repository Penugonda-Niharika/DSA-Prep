class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        int cnt = 0;
        int arr[] = new int[2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int el = grid[i][j];
                cnt = 0;
                for(int k=0; k<n; k++) {
                    for(int l=0; l<n; l++) {
                        if(grid[k][l] == el) {
                            cnt++;
                        }
                    }
                }
                if(cnt==2) {
                    arr[0] = el;
                    break;
                } 
            }
            if (arr[0] != 0) {
                 break;
            }
        }
        for(int k=1; k<=n*n; k++) {
            found = false;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == k) found = true;
                }
            }
            if(!found) {
                arr[1] = k;
                break;
            }
        }
        return arr;
    }
}