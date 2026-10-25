class Solution {
    void dfs(int[][] image, int r, int c, int org, int newC) {
        int n = image.length;
        int m = image[0].length;
        if(r >= n || r < 0 || c >= m || c < 0) return;
        if(image[r][c] != org) return;
        image[r][c] = newC;
        dfs(image, r+1, c, org, newC);
        dfs(image, r-1, c, org, newC);
        dfs(image, r, c+1, org, newC);
        dfs(image, r, c-1, org, newC);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if(org == color) return image;
        dfs(image, sr ,sc,org, color);
        return image;
    }
}