class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int minPrice = arr[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++) {
            int p = arr[i] - minPrice;
            maxProfit = Math.max(maxProfit, p);
            minPrice = Math.min(minPrice, arr[i]);
        }
        return maxProfit;
    }
}