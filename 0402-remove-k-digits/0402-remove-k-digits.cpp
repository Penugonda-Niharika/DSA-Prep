class Solution {
public:
    string removeKdigits(string s, int k) {
        int n = s.size();
        string res = "";
        stack<char> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && k > 0 && st.top() > s[i]) {
                st.pop();
                k--;
            }
            st.push(s[i]);
        }

        while (!st.empty() && k > 0) {
            st.pop();
            k--;
        }

        while (!st.empty()) {
            res += st.top();
            st.pop();
        }

        reverse(res.begin(), res.end());

        int i = 0;
        while (i < res.size() && res[i] == '0') {
            i++;
        }

        res = res.substr(i);

        if (res.empty()) return "0";
        return res;
    }
};