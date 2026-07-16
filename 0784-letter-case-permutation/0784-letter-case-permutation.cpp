class Solution {
public:
    void gen(string s, vector<string>& ans, int i, string curr) {
        if(i == s.size()) {
            ans.push_back(curr);
            return;
        }
        char ch = s[i];
        if(isdigit(static_cast<unsigned char>(ch))) {
            curr.push_back(ch);
            gen(s, ans, i+1, curr);
            curr.pop_back();
        } else {
            curr.push_back(
                static_cast<char>(tolower(static_cast<unsigned char>(ch)))
            );

            gen(s, ans, i + 1, curr);

            curr.pop_back();
            curr.push_back(
                static_cast<char>(toupper(static_cast<unsigned char>(ch)))
            );

            gen(s, ans, i + 1, curr);

            curr.pop_back();
        }
    }

    vector<string> letterCasePermutation(string s) {
        vector<string> ans;
        string curr;
        gen(s, ans, 0, curr);
        return ans;
    }
};