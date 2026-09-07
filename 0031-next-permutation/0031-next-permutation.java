class Solution {
    void reverse(int[] arr, int st, int end) {
        while(st<=end) {
            int t = arr[st];
            arr[st] = arr[end];
            arr[end] = t;
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] n) {
        int min = 0;
        int m = n.length;
        boolean found = false;
        for(int i=m-2; i>=0; i--) {
            if(n[i]<n[i+1]) {
                for(int j=m-1; j>i; j--) {
                    if(n[j] > n[i]) {
                        int t = n[i];
                        n[i] = n[j];
                        n[j] = t;
                        
                        break;
                    }
                }
                found = true;
                reverse(n, i+1, m-1);
               break;
            }
        }

        if(!found && m>0) {
            reverse(n, 0, m-1);
        }
    }
}