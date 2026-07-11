class Solution {
public:
    int myAtoi(string s) {
        int sign = 1;
        long long ans  = 0;
        int i=0;
        while(i < s.size() && s[i] == ' ') {
            i++;
        }
        if(i<s.size() && (s[i] == '+' || s[i] == '-')) {
            if(s[i] == '-') {
                sign = -1;
            }
            i++;
        }

        while(i<s.size() && isdigit(s[i])) {
            int dig = s[i] - '0';
            ans = ans * 10 + dig;
            if(sign == 1 && ans > INT_MAX) return INT_MAX;
            if(sign == -1 && -ans < INT_MIN) return INT_MIN;
            i++;
        }
        return ans*sign;
    }
};