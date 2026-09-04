class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int cand = 0;
        for(int x : nums) {
            if(cnt == 0) cand = x;
            if(x == cand) cnt++;
            else cnt--;        
        }
        return cand;
    }
}