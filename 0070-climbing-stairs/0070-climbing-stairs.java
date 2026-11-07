class Solution {
    int f(int n, int[] st) {
        if(n == 1 || n == 2) return n;
        if(st[n] != -1) {
            return st[n];
        }
        return st[n] = f(n-1,st)+f(n-2,st);
    }
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int st[] = new int[n+1];
        Arrays.fill(st, -1);
        f(n, st);
        return st[n];
    }
}