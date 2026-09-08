class Solution {
    public int trap(int[] ht) {
        int n=ht.length;
        int cnt = 0;
        int lmax = 0, rmax=0;
        int area = 0;
        for(int i=0; i<n; i++) {
            lmax = Math.max(lmax, ht[i]);
            rmax = 0;
            for(int j=i+1; j<n; j++) {
                rmax = Math.max(rmax, ht[j]);
            }
            int w = Math.min(lmax, rmax)-ht[i];
            if(w>0) {
                cnt += w;
            }
        }
        return cnt;
    }
}