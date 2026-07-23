class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low=1, high=Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = low+(high-low)/2;

            if (canEat(piles, mid, h)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canEat(int[] piles, int mid, int h) {
        int total = 0;
        for (int i=0; i<piles.length; i++) {
            total += (Math.ceil((double) piles[i]/mid));
        }
        return total <= h;
    }
}
