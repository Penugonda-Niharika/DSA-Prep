class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0,a=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                c++;
            } else {
                c = 0;
            }
                            a = Math.max(a,c);

        }
        return a;
    }
}