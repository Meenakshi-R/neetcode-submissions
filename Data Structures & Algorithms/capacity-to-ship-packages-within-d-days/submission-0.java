class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max=0, sum=0;
 
        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }
        int low=max, high=sum;

        while (low <= high) {
            int mid = low+(high-low)/2;
            if (canShip(weights, days, mid)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, int mid) {
        int total = 0, totalDays=1;

        for (int i=0; i<weights.length; i++) {
            total += (weights[i]);
            if (total > mid) {
                total = weights[i];
                totalDays++;
            }
        }
        return totalDays <= days;
    }
}