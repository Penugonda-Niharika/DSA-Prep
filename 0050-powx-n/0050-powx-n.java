class Solution {
    public double myPow(double x, int n) {
        long e = n;
        if(e<0) {
            x = 1/x;
            e = -e;
        }
        double a = 1;
        while(e>0) {
            if(e%2 == 1) {
                a *= x;

            }
            x *= x;
            e /= 2;
        }
        return a;
    }
}