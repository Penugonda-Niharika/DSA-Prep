class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(ans.contains(nums[i])) continue;
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(nums[i]==nums[j]) cnt++;
            }
            if(cnt>n/3) {
                ans.add(nums[i]);
            }
        } 
        return ans;
    }
}