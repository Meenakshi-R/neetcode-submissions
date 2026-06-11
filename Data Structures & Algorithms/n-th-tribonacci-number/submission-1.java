class Solution {
    public int tribonacci(int n) {
        int one = 0, two=1, three = 1;
        if (n==0) {
            return 0;
        }
        for (int i=3; i<=n; i++) {
            int result = one + two + three;
            one = two;
            two = three;
            three = result;
        }
        return three;
    }
}