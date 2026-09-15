class Solution {
    int fi(int n) {
        if(n == 0 || n == 1) return n;
        return fi(n-1)+fi(n-2);
    }
    public int fib(int n) {
        return fi(n);
    }
}