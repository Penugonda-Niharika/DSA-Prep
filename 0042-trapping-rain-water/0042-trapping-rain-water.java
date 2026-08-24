class Solution {

    public int trap(int[] h) {

        int lmax = 0;
        int ans = 0;

        for(int i = 0; i < h.length; i++) {

            int rmax = 0;

            lmax = Math.max(lmax, h[i]);

            for(int j = i + 1; j < h.length; j++) {
                rmax = Math.max(rmax, h[j]);
            }

            ans += Math.max(0, Math.min(lmax, rmax) - h[i]);
        }

        return ans;
    }
}