class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        double m = n;
        if(m < 0) {
            m = -m;
        }
        while(m > 0) {
            if(m%2 == 0) {
                x *= x;
                m /= 2;
            } else {
                ans = ans*x;
                m -= 1;
            }
        }
        if(n < 0) ans = (double) 1.0 / (double) ans;
        return ans;
    }
}