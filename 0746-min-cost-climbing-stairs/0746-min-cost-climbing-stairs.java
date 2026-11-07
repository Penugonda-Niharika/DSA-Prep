class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = 0, p1 = 0, p2 = 0;
        for(int i=2; i<=n; i++) {
            ans = Math.min(cost[i-1]+p2, cost[i-2]+p1);
            p1 = p2;
            p2 = ans;
        }
        return ans;
    }
}