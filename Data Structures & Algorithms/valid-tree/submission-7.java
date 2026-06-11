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

    private int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
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
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
           return false;
        }
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!dsu.union(u, v)) {
                return false;
            }
        }
        return true;
    }
}
