class Solution {

    int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    void union(int a, int b, int[] parent, int[] size) {
        int p1 = find(a, parent);
        int p2 = find(b, parent);

        if (p1 == p2) {
            return;
        }

        if (size[p1] < size[p2]) {
            parent[p1] = p2;
            size[p2] += size[p1];
        } else {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        // Initialize DSU
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Process each edge once
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Both vertices already belong to the same group
            if (find(u, parent) == find(v, parent)) {
                return edge;
            }

            // Merge their groups
            union(u, v, parent, size);
        }

        return new int[0];
    }
}