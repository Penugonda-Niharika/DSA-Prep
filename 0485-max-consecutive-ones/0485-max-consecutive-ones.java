class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }
          ans = Math.max(ans, cnt);
        return ans;
    }
}