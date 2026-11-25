class Solution {
    void combination(int i, int sum, int t, int[] arr, List<List<Integer>> ans, List<Integer> a) {
        if(sum > t) return;
        if(i == arr.length) {
            if(t == sum) {
                ans.add(new ArrayList<>(a));
            }
            return;
        }
        a.add(arr[i]);
        sum += arr[i];
        combination(i+1, sum,t,arr,ans,a);
        a.remove(a.size()-1);
        sum -= arr[i];
        while(i+1<arr.length && arr[i] == arr[i+1]) i++;
        combination(i+1, sum,t,arr,ans,a);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        combination(0,0,target,candidates,ans,a);
        return ans;
    }
}