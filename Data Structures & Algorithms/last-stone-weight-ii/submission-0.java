class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = Arrays.stream(stones).sum();
        int target = total/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int stone : stones) {
            for (int i=target; i>=stone; i--) {
                dp[i] = dp[i] | dp[i-stone];
            }
        }
        for (int i=target; i>=0; i--) {
            if (dp[i]) {
                return total-2*i;
            }
        }
        return -1;
    }
}