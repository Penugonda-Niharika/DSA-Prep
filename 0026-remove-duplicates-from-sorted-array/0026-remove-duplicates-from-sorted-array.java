class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int p = 1;
        int i = 1;
        while(i<n) {
            if(nums[p-1] != nums[i]) {           
                nums[p++] = nums[i];
                ans++;
            }
            i++;
        }
        return ans;
    }
}