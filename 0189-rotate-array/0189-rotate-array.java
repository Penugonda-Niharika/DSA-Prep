class Solution {
    void rev(int st, int end, int[] arr) {
        while(st < end) {
            int t = arr[st];
            arr[st] = arr[end];
            arr[end] = t;

            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rev(0, n-1, nums);
        rev(0, k-1, nums);
        rev(k, n-1, nums);
    }
}