class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long power = Math.abs((long) n);
        double result = 1;

        for (int i=0; i<Math.abs(n); i++) {
             result *= x;
        }
        return n>0 ? result : 1/result;
    }
}
