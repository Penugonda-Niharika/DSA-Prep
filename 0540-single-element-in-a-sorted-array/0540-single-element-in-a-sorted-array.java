class Solution {
    public int singleNonDuplicate(int[] arr) {
        int l=0, h=arr.length-1;
        while(l < h) {
            int m = (l+h)/2;
            if(m%2 == 1) m--;
            if(arr[m] == arr[m+1]) {
                l = m+2;
            } else {
                h = m;
            }
        }
        return arr[l];
    }
}