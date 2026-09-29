class Solution {
    public int reverse(int x) {
        int rev = 0;
        int s = 0;
        if(x<0) {
            x = -x;
            s = 1;
        }
        while(x>0) {
            int d = x%10;

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && d > 7)) {
                return 0;
            }
            rev = rev*10+d;
            x /= 10;
        }
        if(s == 1) return -rev;
        return rev;
    }
}