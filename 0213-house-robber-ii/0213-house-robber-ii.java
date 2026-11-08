class Solution {
    int r(int[] nums) {
        int n = nums.length;
        int p1 = nums[0];
        int p2 = Math.max(nums[0], nums[1]);
        int a = p2;
        for (int i = 2; i < n; i++) {
            a = Math.max(p2, p1 + nums[i]);
            p1 = p2;
            p2 = a;
        }
        return a;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        int t1[] = new int[n-1];
        int t2[] = new int[n-1];
        int j = 0;
        for(int i=0; i<n; i++) {
            if(i!=0) t1[i-1] = nums[i];
            if(i!=n-1) t2[i] = nums[i];
        }
        return Math.max(r(t1), r(t2));
    }
}