class Solution {
    int[][] memo;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n];
        suffix[n-1] = piles[n-1];

        for (int i=n-2; i>=0; i--) {
            suffix[i] = suffix[i+1]+piles[i];
        }
        memo = new int[n][n+1];
        return dfs(piles, 0, 1, suffix);
    }

    private int dfs(int[] piles, int i, int M, int[] suffix) {
        if (i>=piles.length) {
            return 0;
        }
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        int maxStone = Integer.MIN_VALUE;

        for (int X=1; X<=2*M && i+X<=piles.length; X++) {
            int opponent = dfs(piles, i+X, Math.max(M, X), suffix);
            int current = suffix[i] - opponent;
            maxStone = Math.max(maxStone, current);
        }
        return memo[i][M] = maxStone;
    }
}