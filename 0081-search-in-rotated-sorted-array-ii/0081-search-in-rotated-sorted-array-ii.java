class Solution {
    public boolean search(int[] n, int t) {
        int l = 0, h = n.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (n[m] == t) {
                return true;
            }
            if (n[l] == n[m] && n[m] == n[h]) {
                l++;
                h--;
            } else if (n[l] <= n[m]) {
                if (n[l] <= t && t <= n[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (n[m] <= t && t <= n[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return false;
    }
}