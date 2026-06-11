class Solution {
    private int calculateHours(int[] piles, int hour) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil((double) pile/hour);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low + (high-low)/2;
            int hours = calculateHours(piles, mid);
            if (hours <= h) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
}
