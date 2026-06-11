class Solution {
    public int climbStairs(int n) {
        if (n==0 ||n==1) {
            return n;
        }
        int one=1, two=1;
        for (int i=2; i<=n; i++) {
            int result = one+two;
            two = one;
            one = result;
        }
        return one;
    }
}