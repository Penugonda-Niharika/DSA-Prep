class Solution {
    public void merge(int[] a1, int m, int[] a2, int n) {

        int i = m - 1;       // last real element in a1
        int j = n - 1;       // last element in a2
        int k = m + n - 1;   // last position in a1

        while (i >= 0 && j >= 0) {

            if (a1[i] > a2[j]) {
                a1[k] = a1[i];
                i--;
            } else {
                a1[k] = a2[j];
                j--;
            }

            k--;
        }

        // If elements are remaining in a2
        while (j >= 0) {
            a1[k] = a2[j];
            j--;
            k--;
        }
    }
}