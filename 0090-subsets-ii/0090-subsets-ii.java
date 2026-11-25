class Solution {
     void calculate(int i, int[] arr, List<Integer> ds, List<List<Integer>> ans) {
        if(i == arr.length) {       
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[i]);
        calculate(i+1,arr, ds, ans);
        ds.remove(ds.size()-1);
        while(i+1<arr.length && arr[i] == arr[i+1]) i++;
        calculate(i+1, arr, ds, ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        calculate(0,nums,ds,ans);
        return ans;
    }
}