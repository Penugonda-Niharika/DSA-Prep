class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>();
        long res = 1;
        for(int i=0; i<=n; i++) {
            ans.add((int)res);
            res *= (n-i);
            res /= (i+1);
        }
        return ans;
    }
}