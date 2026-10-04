class Solution {
    public String largestOddNumber(String num) {
        String ans = "";
        int idx = -1;
        int n = num.length();
        for(int i=n-1; i>=0; i--) {
            if((num.charAt(i) - '0') % 2 == 1) {
                idx = i;
                break;
            }
        }
        for(int i=0; i<=idx; i++) {
            ans += num.charAt(i);
        }
        return ans;
    }
}