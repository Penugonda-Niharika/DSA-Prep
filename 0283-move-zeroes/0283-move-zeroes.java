class Solution {
    public void moveZeroes(int[] arr) {
        int i;
        int n = arr.length;
        for(i=0; i<n; i++) {
            if(arr[i] == 0) break;
        }
        for(int j=i+1; j<n; j++) {
            if(arr[j] != 0) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
            }
        }
    }
}