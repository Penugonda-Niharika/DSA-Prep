class Solution {
    void calculate(int i, int[] arr, int t, int s, List<Integer> ds, List<List<Integer>> ans) {
        if(s>t) return;
        if(i == arr.length) {
            if(t == s) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(arr[i]);
        s += arr[i];
        calculate(i,arr, t, s, ds, ans);
        ds.remove(ds.size()-1);
        s -= arr[i];
        calculate(i+1, arr, t, s, ds, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        calculate(0,candidates,target,0,ds,ans);
        return ans;
    }
}