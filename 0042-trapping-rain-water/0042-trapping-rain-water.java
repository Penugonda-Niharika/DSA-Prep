class Solution {
    public int trap(int[] ht) {
        int n=ht.length;
        int cnt = 0;
        int[] lm = new int[n];
        int[] rm = new int[n];

        lm[0] = ht[0];
        for(int i=1; i<n; i++) {
            lm[i] = Math.max(ht[i], lm[i-1]);
        }

        rm[n-1] = ht[n-1];
        for(int i=n-2; i>=0; i--) {
            rm[i] = Math.max(ht[i], rm[i+1]);
        }
        for(int i=0; i<n; i++) {
            
            int w = Math.min(lm[i], rm[i])-ht[i];
            if(w>0) {
                cnt += w;
            }
        }
        return cnt;
    }
}