class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int ft = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] >= ft) {
                ft = intervals[i][1];
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}