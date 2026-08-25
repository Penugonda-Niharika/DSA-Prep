class Solution {
    int[] findNse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int curr = arr[i];
            while(!st.empty() && arr[st.peek()] >= curr) st.pop();
            if(st.empty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    int[] findPse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            while(!st.empty() && arr[st.peek()] > curr) st.pop();
            if(st.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int nse[] = findNse(arr);
        int pse[] = findPse(arr);
        int sum = 0;
        int mod = (int)1e9 + 7;
        for(int i=0; i<arr.length; i++) {
            int left = i-pse[i];
            int right = nse[i]-i;
            long cont = left*right*1L;
            int val = (int)((cont * arr[i]) % mod);
            sum = (sum+val)%mod;
        }
        return sum;
    }
}