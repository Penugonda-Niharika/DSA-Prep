class Solution {
public:
    double solve(double x, int n) {
        if(n == 0) return 1.0;
        double half = solve(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }

    double myPow(double x, int n) {
        double ans = 1;
        long long N = n;
        if(N<0) {
            N = -N;
            x = 1/x;
        }
        return solve(x,N);
    }
};