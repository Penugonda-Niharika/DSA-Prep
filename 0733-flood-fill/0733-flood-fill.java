class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgCol = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        if(orgCol != color) {
            image[sr][sc] = color;
            vis[sr][sc] = 1;
        }
        q.add(new int[]{sr, sc});
        while(!q.isEmpty()) {
            int[] ans = q.poll();
            int r = ans[0];
            int c = ans[1];
            if(image[r][c] == orgCol && vis[r][c] == 0) {
                image[r][c] = color;
                vis[r][c] = 1;
            }
            if(r+1 < n && image[r+1][c] == orgCol && vis[r+1][c] == 0) {
                q.add(new int[]{r+1, c});
                image[r+1][c] = color;
                vis[r+1][c] = 1;
            }
            if(r-1 >= 0 && image[r-1][c] == orgCol && vis[r-1][c] == 0) {
                q.add(new int[]{r-1, c});
                image[r-1][c] = color;
                vis[r-1][c] = 1;
            }
            if(c+1 < m && image[r][c+1] == orgCol && vis[r][c+1] == 0) {
                q.add(new int[]{r, c+1});
                image[r][c+1] = color;
                vis[r][c+1] = 1;
            }
            if(c-1 >= 0 && image[r][c-1] == orgCol && vis[r][c-1] == 0) {
                q.add(new int[]{r, c-1});
                image[r][c-1] = color;
                vis[r][c-1] = 1;
            }
        }
        return image;
    }
}