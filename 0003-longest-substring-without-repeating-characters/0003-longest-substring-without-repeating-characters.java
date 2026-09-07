class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int max = 0, cnt = 0, l = 0;
        for(int r=0; r<s.length(); r++) {
            while(st.contains(s.charAt(r))) {
                st.remove(s.charAt(l));
                cnt--;
                l++;
            }
            st.add(s.charAt(r));
            cnt++;
            max = Math.max(max, cnt);
        }
        return max;
    }
}