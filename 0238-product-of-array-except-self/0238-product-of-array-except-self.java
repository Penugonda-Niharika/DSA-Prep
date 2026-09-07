class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1, s = 1;
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=0; i<nums.length; i++) {
            arr[i] = p;
            p *= nums[i];
        }
        for(int i=n-1; i>=0; i--) {
            arr[i] *= s;
            s *= nums[i];
        }
        return arr;
    }
}