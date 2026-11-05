class Solution {
    int fibDP(int n, int[] arr) {
        if(n <= 1) return n;
        if(arr[n] != -1) {
            return arr[n];
        }
        return arr[n] = fibDP(n-1, arr)+fibDP(n-2, arr);
    }
    public int fib(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        return fibDP(n, arr);
    }
}