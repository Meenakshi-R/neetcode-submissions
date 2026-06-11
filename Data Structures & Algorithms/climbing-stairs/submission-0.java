class Solution {
    public int climbStairs(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        int one = 1, two = 2, result = 0;
        for (int i=3; i<=n; i++) {
            result = one+two;
            one = two;
            two = result;
        }
        return result;
    }
}
