class Solution {
public:
    // bool isValid(string c) {
    //     int b = 0;
    //     for(auto s : c) {
    //         if(s == '(') b++;
    //         else b--;
    //         if(b<0) return false;
    //     }
    //     return b == 0;
    // }
    void generate(int n, string& curr, int open, int close, vector<string>& res) {
        if(open == n && close == n) {
                res.push_back(curr);
                return;
        }
        if(open < n) {
            curr.push_back('(');
            generate(n, curr, open+1, close, res);
            curr.pop_back();
        }
        if(close<open) {
            curr.push_back(')');
            generate(n, curr, open, close+1, res);
            curr.pop_back();
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string curr;
        generate(n, curr,0,0, res);
        return res;
    }
};