class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int s = nums[i];
            int l = nums[i];
            for(int j=i; j<n; j++) {
                s = Math.min(s, nums[j]);
                l = Math.max(l, nums[j]);
                sum += (l-s);
            }
        }
        return sum;
    }
}