class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;
        while(row < matrix.length && row >= 0 && column >= 0 && column < matrix[0].length){
            if(matrix[row][column] == target) return true;
            if(matrix[row][column] > target) column --;
            else if(matrix[row][column] < target) row ++;
        }
        return false;
    }
}
