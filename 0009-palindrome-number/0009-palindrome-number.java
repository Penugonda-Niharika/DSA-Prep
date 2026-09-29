class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int s = 0;
        int n = x;
        if(n<0) {
            n = -n;
            s = 1;
        }
        while(n>0) {
            int d = n%10;

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && d > 7)) {
                return false;
            }
            rev = rev*10+d;
            n /= 10;
        }
        if(rev == x) return true;
        return false;
    }
}