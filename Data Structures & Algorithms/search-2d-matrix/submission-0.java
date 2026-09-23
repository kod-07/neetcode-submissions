class Solution {
    public boolean binarySearch(int[][] matrix, int row , int target){
        int left = 0 , right = matrix[0].length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[row][mid] ==  target){
                return true;
            }
           else if(matrix[row][mid] < target) {
                left = mid + 1;
           }else{
                right = mid - 1;
            } 
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row = 0 ; row < matrix.length; row ++){
            if(matrix[row][0] <= target && matrix[row][matrix[0].length - 1] >= target) return binarySearch(matrix,row,target);
        }
        return false;
    }
}
