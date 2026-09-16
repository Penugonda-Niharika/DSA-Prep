class Solution {
    void ps(int[] arr, int i, List<Integer> ans, List<List<Integer>> allSets, int t) {
        if(t == 0) {
            allSets.add(new ArrayList<>(ans));
            return;
        }
        if(i == arr.length || t<0) {
            return;
        }
        ans.add(arr[i]);
        ps(arr, i+1, ans, allSets, t-arr[i]);
        ans.remove(ans.size()-1);
        int idx = i+1;
        while(idx<arr.length && arr[idx] == arr[idx-1])idx++;
        ps(arr, idx, ans, allSets, t);
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> allSets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ps(nums, 0, ans, allSets, target);
        return allSets;
    }
}