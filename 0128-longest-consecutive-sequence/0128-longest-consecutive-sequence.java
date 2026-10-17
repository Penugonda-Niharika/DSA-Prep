class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int ans = 0;
        for(int x : nums) {
            st.add(x);
        }
        for(int x : st) {
            if(!st.contains(x-1)) {
                int l = 1;
                int c = x;
                while(st.contains(c+1)) {
                    c++;
                    l++;
                }
                ans = Math.max(ans, l);
            }
        }
        return ans;
    }
}