class Solution {
    void recursion(int i, String[] map, List<String> ans, String a, String digits) {
        if(i == digits.length()) {
            ans.add(a);
            return;
        }
        int idx = digits.charAt(i)-'0';
        String m = map[idx];
        for(int j=0; j<m.length(); j++) {
            char ch = m.charAt(j);
            recursion(i+1,map,ans,a+ch,digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        recursion(0,map,ans,"", digits);
        return ans;
    }
}