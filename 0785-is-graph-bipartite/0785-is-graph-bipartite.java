class Solution {
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        Queue<Integer> q = new LinkedList<>();
        int col[] = new int[n];
        Arrays.fill(col, -1);
        for(int i=0; i<n; i++) {
            if(col[i] == -1) {
                col[i] = 0;
                q.add(i);
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int x : g[node]) {
                        if(col[x] == -1) {
                            col[x] = 1-col[node];
                            q.add(x);
                        } else if(col[x] == col[node]) return false;
                    }
                }
            }
        }
        return true;
    }
}