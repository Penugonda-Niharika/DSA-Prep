class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int r = target - nums[i];
            if(mp.containsKey(r)) {
                ans[0] = mp.get(r);
                ans[1] = i;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}