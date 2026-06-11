class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = cols-1;

        while (low < rows && high >= 0) {
            int current = matrix[low][high];

            if (current == target) {
                return true;
            }
            else if (current < target) {
                low++;
            }
            else {
                high--;
            }
        }
        return false;
    }
}
