class Solution {

    public boolean canJump(int[] arr) {

        int mi = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {

            if(i > mi) {
                return false;
            }

            mi = Math.max(mi, i + arr[i]);

            if(mi >= n - 1) {
                return true;
            }
        }

        return true;
    }
}