class Solution {
    public int findMin(int[] n) {
        int l = 0, h = n.length - 1, ans = Integer.MAX_VALUE;
        while (l <= h) {
            int m = (l + h) / 2;
            ans = Math.min(ans, n[m]);
            if (n[l] <= n[m]) {
                ans = Math.min(ans, n[l]);
                l = m + 1;
            } else {
                ans = Math.min(ans, n[h]);
                h = m - 1;
            }
        }
        return ans;
    }
}