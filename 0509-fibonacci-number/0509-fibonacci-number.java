class Solution {
    void fibDP(int n, int[] arr) {
       for(int i=2; i<=n; i++) {
        arr[i] = arr[i-1]+arr[i-2];
       }
    }
    public int fib(int n) {
        if(n <= 1) return n;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        fibDP(n, arr);
        return arr[n];
    }
}