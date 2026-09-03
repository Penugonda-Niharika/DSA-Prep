class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       int cnt = 0, ans=0;
       for(int i=0; i<n; i++) {
        cnt = 0;
        for(int j=0; j<n; j++) {
            if(nums[j] == nums[i]) cnt++;
        }
        if(cnt>n/2) return nums[i];
       } 
       return -1;
    }
}