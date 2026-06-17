class Solution {
    public int tribonacci(int n) {
        int t1=0, t2=1, t3=1;
        if (n == 0) {
            return 0;
        }

        for (int i=3; i<=n; i++) {
            int result = t1+t2+t3;
            t1 = t2;
            t2 = t3;
            t3 = result;
        }
        return t3;
    }
}