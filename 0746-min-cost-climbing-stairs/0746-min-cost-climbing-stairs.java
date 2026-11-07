class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int st[] = new int[n+1];
        st[0] = 0;
        st[1] = 0;
        for(int i=2; i<=n; i++) {
            st[i] = Math.min(cost[i-1]+st[i-1], cost[i-2]+st[i-2]);
        }
        return st[n];
    }
}