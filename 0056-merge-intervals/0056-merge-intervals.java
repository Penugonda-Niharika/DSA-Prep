class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] x : arr) {
            if(res.isEmpty() || x[0] > res.get(res.size()-1)[1]) {
                res.add(x);
            } else {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], x[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}