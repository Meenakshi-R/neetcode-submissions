class Solution {
    int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] clone = new int[n+2];
        System.arraycopy(nums, 0, clone, 1, n);
        clone[0] = 1;
        clone[clone.length-1] = 1;
        memo = new int[n+2][n+2];
        return dfs(clone, 1, n);
    }

    private int dfs(int[] clone, int i, int j) {
        if (i>j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int index = i; index<=j; index++) {
            int result = clone[i-1]*clone[index]*clone[j+1];
            result += dfs(clone, i, index-1) + dfs(clone, index+1, j);
            max = Math.max(max, result);
        }
        return memo[i][j] = max;
    }
}
