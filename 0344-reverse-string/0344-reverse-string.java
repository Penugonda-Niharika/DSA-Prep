class Solution {
    void rev(int st, int end, char[] s) {
        if(st>end) return;
        char t = s[st];
        s[st] = s[end];
        s[end] = t;
        rev(st+1, end-1, s);
    }
    public void reverseString(char[] s) {
        int st = 0;
        int end = s.length-1;
        rev(st, end, s);
    }
}