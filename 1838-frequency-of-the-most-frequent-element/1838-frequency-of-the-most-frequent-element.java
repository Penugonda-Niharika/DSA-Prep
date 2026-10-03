import java.util.Arrays;

class Solution {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int max = 0;
        int n = nums.length;

        int l = 0;
        int r = 0;

        int els = 0;
        long sum = 0;

        while (l <= r && r < n) {

            int t = nums[r];

            sum += nums[r];
            els++;

            long cost = (long) t * els - sum;

            if (cost <= k) {

                max = Math.max(max, els);
                r++;

            } else {
                while (cost > k) {

                    sum -= nums[l];
                    els--;
                    l++;

                    cost = (long) t * els - sum;
                }

                max = Math.max(max, els);
                r++;
            }
        }

        return max;
    }
}