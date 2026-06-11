class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = cols-1;

        while (low < rows && high >= 0) {
            int currentNum = matrix[low][high];
            if (currentNum == target) {
                return true;
            }
            else if (currentNum < target) {
                low++;
            }
            else {
                high--;
            }
        }
        return false;
    }
}
