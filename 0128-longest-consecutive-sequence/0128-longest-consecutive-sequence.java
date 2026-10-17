class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans=0, len=0;
        for(int i=0; i<nums.length; i++) {
            if(i==0) len++;
            if(i>0 && nums[i] == nums[i-1]) continue;
            if(i>0 && nums[i-1]+1 == nums[i]) len++;
            else {
                ans = Math.max(ans,len);
                len = 1;
            }
        }
        ans = Math.max(ans, len);
        return ans;
    }
}