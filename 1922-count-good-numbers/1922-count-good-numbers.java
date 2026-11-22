class Solution {
    long power(long n, long x, long mod) {
        long ans = 1;
        while(n>0) {
            if(n%2 == 0) {
                x = (x*x)%mod;
                n /= 2;
            } else {
                ans = (ans * x) % mod;
                n -= 1;
            }
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long mod = 1000000007L;
        long e1 = (n+1)/2;
        long b1 = 5;
        long e2 = n/2;
        long b2 = 4;
        long a1 = power(e1,b1,mod);
        long a2 = power(e2, b2, mod);
        return (int)((a1*a2)%mod);
    }
}