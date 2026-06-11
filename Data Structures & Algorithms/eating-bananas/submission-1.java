class Solution {
    private int calculateHours(int[] piles, int hour) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += Math.ceil((double) pile/ (double) hour);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h == 0) {
            return 0;
        }
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = (low + high)/2;
            int totalH = calculateHours(piles, mid);
            if (totalH <= h) {
                 high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
}
