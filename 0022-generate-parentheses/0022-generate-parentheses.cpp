class Solution {
public:
    void generate(int n, int o, int c, string curr, vector<string>& res) {
        if(curr.size() == 2*n) {
            res.push_back(curr);
            return;
        }
        if(o < n) generate(n, o+1, c, curr+'(', res);
        if(c < o) generate(n, o, c+1, curr+')', res);
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        generate(n, 0, 0, "", res);
        return res;
    }
};