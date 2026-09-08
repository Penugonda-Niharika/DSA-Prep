class Solution {
    public int findDuplicate(int[] n) {
        int s = n[0];
        int f = n[0];
        do {
            s = n[s];
            f = n[n[f]];
        } while(s != f);
        s = n[0];
        while(s != f) {
            s = n[s];
            f = n[f];
        }
        return s;
    }
}