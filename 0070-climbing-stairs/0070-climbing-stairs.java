class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int st[] = new int[n+1];
        st[0] = 0;
        st[1] = 1;
        st[2] = 2;
        for(int i=3; i<=n; i++) {
            st[i] = st[i-1]+st[i-2];
        }
        return st[n];
    }
}