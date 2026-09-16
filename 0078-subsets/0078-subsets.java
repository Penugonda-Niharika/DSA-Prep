class Solution {
    void ps(int[] arr, int i, List<Integer> ans, List<List<Integer>> allSets) {
        if(i == arr.length) {
            allSets.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        ps(arr, i+1, ans, allSets);
        ans.remove(ans.size()-1);
        ps(arr, i+1, ans, allSets);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ps(nums, 0, ans, allSets);
        return allSets;
    }
}