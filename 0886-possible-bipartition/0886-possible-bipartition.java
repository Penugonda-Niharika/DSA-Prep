class Solution {
    boolean dfs(int u, int[] color, ArrayList<ArrayList<Integer>> adj) {
        for(int v : adj.get(u)) {
            if(color[v] == -1) {
                color[v] = 1-color[u]; 
                if(!dfs(v,color,adj)) return false;
            } else if(color[u] == color[v]) return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : dislikes) {
            int u = pair[0];
            int v = pair[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int color[] = new int[n+1];
        Arrays.fill(color, -1);
        for(int i=1; i<=n; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                if(!dfs(i,color,adj)) return false;
            }
        }
        return true;
    }
}