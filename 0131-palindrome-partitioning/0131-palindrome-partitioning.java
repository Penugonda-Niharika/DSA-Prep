class Solution {
    void recursion(int i, String s, List<String> ds, List<List<String>> ans) {
        if(i == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int j=i; j<s.length(); j++) {
            String sub = s.substring(i,j+1);
            if(isPalindrome(sub)) {
                ds.add(sub);
                recursion(j+1, s, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length()-1;
        while(l <= h) {
            if(s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        recursion(0, s, ds, ans);
        return ans;
    }
}