class Solution {
    private int sumOfSquares(int n) {
        int result = 0;
        while (n != 0) {
            result += (n%10)*(n%10);
            n/=10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = sumOfSquares(n);

        while (slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
        }
        return fast == 1;
    }
}
