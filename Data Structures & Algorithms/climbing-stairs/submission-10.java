class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 0;
        for (int i=0; i<n; i++) {
            int result = one+two;
            two = one;
            one = result;
        }
        return one;
    }
}
