class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if(parent[node] != node) {
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
        if (rank[pu] < rank[pv]) {
            rank[pv] += rank[pu];
            parent[pu] = pv;
        }
        else {
            rank[pu] += rank[pv];
            parent[pv] = pu;
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                components--;
            }
        }
        return components;
    }
}
