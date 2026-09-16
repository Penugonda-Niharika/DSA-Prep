class Solution {
    void ps(int[] arr, int i, List<Integer> ans, List<List<Integer>> allSets, int t) {
        if(i == arr.length || t<0) {
            return;
        }
        if(t == 0) {
            allSets.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        ps(arr, i, ans, allSets, t-arr[i]);
        ans.remove(ans.size()-1);
        
        ps(arr, i+1, ans, allSets, t);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> allSets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ps(nums, 0, ans, allSets, target);
        return allSets;
    }
}