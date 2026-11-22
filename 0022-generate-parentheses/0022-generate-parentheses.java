class Solution {
    void generate(List<String> ans, int open, int close, int n, String c) {
        if(c.length() == 2*n) {
            ans.add(c);
            return;
        }
        if(open < n) {
            generate(ans, open+1, close, n, c+"(");
        }
        if(open > close) {
            generate(ans, open, close+1, n, c+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans,0,0,n,"");
        return ans;
    }
}