class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        re.add(1);
        ans.add(re);
        for(int i=1; i<numRows; i++) {
            long a = 1;
            List<Integer> res = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                res.add((int)a);
                a *= (i-j);
                a /= (j+1);
            }
            ans.add(res);
        }
        return ans;
    }
}