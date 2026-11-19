class Solution {
    public boolean checkPerfectNumber(int n) {
        int ans = 0;
        if(n == 1) return false;
        for(int i=1; i<=n/i; i++) {
            if(n%i == 0) {
                ans += i;
                if(i != 1 && n/i != i) ans += n/i;
            }
        }
        if(ans == n) return true;
        else return false;
    }
}