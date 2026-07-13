class Solution {
public:
    void solve(int i, string digs, string curr, vector<string>& ans, vector<string> map) {
        if(i == digs.size()) {
            ans.push_back(curr);
            return;
        }
        int dig = digs[i]-'0';
        string s = map[dig];
        for(char ch : s) {
            curr.push_back(ch);
            solve(i+1, digs, curr, ans, map);
            curr.pop_back();
        }
    }

    vector<string> letterCombinations(string digits) {
         if (digits.empty()) {
            return {};
        }

        vector<string> mapping = {
            "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };

        vector<string> answer;
        string current;

        solve(0, digits, current, answer, mapping);

        return answer;
    }
};