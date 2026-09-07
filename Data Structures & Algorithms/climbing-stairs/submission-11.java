class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 0;

        for (int i=0; i<n; i++) {
            int result = first + second;
            second = first;
            first = result;
        }
        return first;
    }
}