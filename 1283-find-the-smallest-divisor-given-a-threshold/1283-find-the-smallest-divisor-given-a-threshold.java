import java.util.Arrays;

class Solution {
    int getSum(int[] arr, int divisor) {
        int sum = 0;

        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }

    public int smallestDivisor(int[] arr, int threshold) {
        int l = 1;
        int h = Arrays.stream(arr).max().getAsInt();
        int ans = h;

        while (l <= h) {
            int m = l + (h - l) / 2;
            int sum = getSum(arr, m);

            if (sum <= threshold) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}