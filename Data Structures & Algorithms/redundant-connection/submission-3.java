class DSU {
    int[] parent;
    int[] size;

    public DSU (int n) {
        parent = new int[n+1];
        size = new int[n+1];

        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (size[pu] < size[pv]) {
            size[pv] += size[pv];
            parent[pu] = pv;
        }
        else {
            size[pv] += size[pu];
            parent[pv] = pu;
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
