class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        int sc = m[0].length-1;
        int sr = 0;
        while(sr < m.length && sc >= 0) {
            if(m[sr][sc] == t) {
                return true;
            } else if(m[sr][sc] > t) {
                sc--;
            } else {
                sr++;
            }
        }
        return false;
    }
}