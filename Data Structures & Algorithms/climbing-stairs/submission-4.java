class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 1, result = 0;
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        for (int i=2; i<=n; i++) {
            result = first+second;
            second = first;
            first = result;
        }
        return result;
    }
}
