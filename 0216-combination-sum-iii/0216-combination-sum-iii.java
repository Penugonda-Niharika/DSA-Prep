class Solution {
    void calculate(int i, int sum, int k, int n,List<Integer> ds, List<List<Integer>> ans) {
        if(ds.size() > k) return;
        
        if(ds.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(sum>n) return;
        if(i>9) return;

        ds.add(i);
        calculate(i+1, sum+i, k, n, ds, ans);
        ds.remove(ds.size()-1);
        calculate(i+1, sum, k, n, ds, ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        calculate(1, 0, k, n, ds, ans);

        return ans;
    }
}