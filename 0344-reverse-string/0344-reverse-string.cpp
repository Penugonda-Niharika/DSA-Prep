class Solution {
public:
    void rev(vector<char>& s, int st, int end, int n) {
        if(st>end) return;
        swap(s[st], s[end]);
        rev(s, st+1, end-1, n);
    }

    void reverseString(vector<char>& s) {
        rev(s, 0, s.size()-1, s.size());
    }
};