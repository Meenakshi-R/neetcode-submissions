class Solution {
    public int climbStairs(int n) {
        int prev = 1, next = 2;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i=2; i<n; i++) {
            int result = prev+next;
            prev = next;
            next = result;
        }
        return next;
    }
}