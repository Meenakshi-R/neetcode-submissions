class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length, cols=matrix[0].length;
        int left=0, right=cols-1;

        while (left<rows && right>=0) {
            if(matrix[left][right] > target) {
                right--;
            }
            else if (matrix[left][right] < target) {
                left++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
