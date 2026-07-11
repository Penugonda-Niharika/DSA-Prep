class Solution {
public:
       const long long MOD = 1000000007;
    long long power(int x, long long n) {
        if(n == 0) return 1;
        long long ans = power(x, n/2);
        if(n % 2 == 0) {
            return (ans*ans)%MOD;
        } else {
            return (ans*ans*x)%MOD;
        }
    }
    int countGoodNumbers(long long n) {
       long long ans = 1;
       long long o=0, e=0;
       if(n%2 == 0) {
        o = n/2;
        e = n/2;
       } else {
        o = n/2;
        e = (n/2)+1;
       }
        long long ew = power(5,e);
        long long ow = power(4,o);
       return (ew*ow)%MOD;
    }
};