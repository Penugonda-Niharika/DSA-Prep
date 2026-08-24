class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums1.length];
        for(int i=nums2.length-1; i>=0; i--) {
            if(st.empty()) {
                st.push(nums2[i]);
                mp.put(nums2[i], -1);
            } else {
                while(!st.empty() && st.peek()<=nums2[i]) {
                    st.pop();
                }
                if(st.empty()) {
                   mp.put(nums2[i], -1);
                } else {
                    mp.put(nums2[i], st.peek());
                }
                st.push(nums2[i]);
            }
        }
        for(int i=0; i<nums1.length; i++) {
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
    }
}