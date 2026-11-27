class Solution {
    public int removeDuplicates(int[] arr) {
        int c = 1;
        int i=0;
        for(int j=1; j<arr.length; j++) {
            if(arr[i] != arr[j]) {
                c++;
                arr[++i] = arr[j];
            }
        }
        return c;
    }
}