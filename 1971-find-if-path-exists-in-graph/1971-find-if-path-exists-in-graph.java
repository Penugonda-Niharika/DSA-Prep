class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        q.add(source);
        vis[source] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(node == destination) return true;
            for(int e : adj.get(node)) {
                if(vis[e] == 0) {
                    q.add(e);
                    vis[e] = 1;
                }
            }
        }
        return false;
    }
}