class Solution {
    void rev(int l, int h, int[] arr) {
        while(l <= h) {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
            l++;
            h--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return;
        k = k%n;
        rev(0,n-1,nums);
        rev(0,k-1,nums);
        rev(k,n-1,nums);
    }
}