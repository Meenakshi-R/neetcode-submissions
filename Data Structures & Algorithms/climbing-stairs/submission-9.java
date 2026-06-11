class Solution {
    public int climbStairs(int n) {
        if (n==0 || n==1) {
            return n;
        }
        int one = 1, two = 1;
        for (int i=1; i<n; i++) {
            int temp = one + two;
            two = one;
            one = temp;
        }
        return one;
    }
}
