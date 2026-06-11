class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return false;
        }
        if (rank[pv] > rank[pu]) {
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        else {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }
        return true;
    }

    public int findParent(int node) {
        if(node != parent[node]) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
