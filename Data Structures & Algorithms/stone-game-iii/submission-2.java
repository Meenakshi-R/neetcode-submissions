class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int prev1 = 0, prev2 = 0, prev3 = 0;

        for (int i=n-1; i>=0; i--) {
            int score = 0;
            int curr = Integer.MIN_VALUE;
            
            score += stoneValue[i];
            curr = Math.max(curr, score-prev1);

            if (i+1 < n) {
                score += stoneValue[i+1];
                curr = Math.max(curr, score-prev2);
            }
            if (i+2 < n) {
                score += stoneValue[i+2];
                curr = Math.max(curr, score-prev3);
            }
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        if (prev1 > 0) {
            return "Alice";
        }
        else if (prev1 < 0) {
            return "Bob";
        }
        return "Tie";
    }
}