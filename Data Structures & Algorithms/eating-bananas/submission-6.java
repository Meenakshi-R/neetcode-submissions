class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low + (high-low)/2;
            int hours = calculateHours(mid, piles);
            if (hours <= h) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    private int calculateHours(int hour, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile/hour);
        }
        return hours;
    }
}
