class Solution {
public:
    int divide(int dividend, int divisor) {
        if(dividend == INT_MIN && divisor == -1) return INT_MAX;
        long long a = dividend;
        long long b = divisor;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        long long res = 0; 
        while(a>=b) {
            long long temp = b;
            long long mul = 1;
            while(a >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            a -= temp;
            res += mul;
        }
        if((dividend<0)^(divisor<0)) {
            return -res;
        }
        return res;
    }
};