class Solution {
    void reverse(int[] arr, int st, int end) {
        while (st <= end) {
            int t = arr[st];
            arr[st] = arr[end];
            arr[end] = t;
            st++;
            end--;
        }
    }

    public void nextPermutation(int[] n) {
        int m = n.length;
        boolean found = false;
        for (int i = m - 1; i >= 0; i--) {
            if (i>0 && n[i] > n[i - 1]) {
                int el = n[i - 1];
                for (int j = m - 1; j >= i; j--) {
                    if (n[j] > el) {
                        int t = n[i - 1];
                        n[i - 1] = n[j];
                        n[j] = t;
                        reverse(n, i, m - 1);
                        found = true;
                        break;
                    }
                }
                break;
            }
        }
        if(!found) {
            reverse(n, 0, m-1);
        }
    }
}