class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];
        int ans[] = new int[n];
        int k = 0, l = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]>0) pos[k++] = nums[i];
            if(nums[i]<0) neg[l++] = nums[i];
        }
        k = 0;
        l = 0;
        for(int i=0; i<n; i+=2) {
            ans[i] = pos[k++];
            ans[i+1] = neg[l++];
        }
        return ans;
    }
}