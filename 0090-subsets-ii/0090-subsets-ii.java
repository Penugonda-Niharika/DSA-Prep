class Solution {
    void ps(int[] arr, int i, List<Integer> ans, List<List<Integer>> allSets) {
        if(i == arr.length) {
            allSets.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        ps(arr, i+1, ans, allSets);
        ans.remove(ans.size()-1);
        int idx = i+1;
        while(idx<arr.length && arr[idx] == arr[idx-1]) idx++;
        ps(arr, idx, ans, allSets);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> allSets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ps(nums, 0, ans, allSets);
        return allSets;
    }
}