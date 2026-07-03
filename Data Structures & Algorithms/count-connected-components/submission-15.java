class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];

        for (int i=0; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if(parent[node] != node) {
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
        if (size[pu] < size[pv]) {
            size[pv] += size[pu];
            parent[pv] = pu;
        }
        else {
            size[pu] += size[pv];
            parent[pu] = pv;
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = n;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                components--;
            }
        }
        return components;
    }
}
