class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i<nums.length-1 && nums[i+1] > nums[i]) {
                ans[i] = nums[i+1];
            } else {
                int id = i;
                do {
                    i = (i+1) % nums.length;
                } while(i != id && nums[id] >= nums[i]);
                if(i == id) {
                    ans[id] = -1;
                } else {
                    ans[id] = nums[i];
                    i = id;
                }
            }
        }
        return ans;
    }
}