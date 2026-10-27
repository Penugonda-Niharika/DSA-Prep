class Solution {
    int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        return find(parent[x], parent);
    }
    void union(int a, int b, int[] parent, int[] rank) {
        int p1 = find(a, parent);
        int p2 = find(b, parent);
        if(p1 == p2) return;
        if(rank[p1] < rank[p2]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        int parent[] = new int[n];
        int rank[] = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        } 
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<m; j++) {
                if(isConnected[i][j] == 1) {
                    union(i,j,parent,rank);
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(find(i,parent) == i) ans++;
        }
        return ans;
    }
}