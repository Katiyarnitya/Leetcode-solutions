class Solution {
    public boolean helper(int[][] matrix, int left,int right, int col, int target){
        if(left>right){
            return false;
        }
        int mid = left+(right-left)/2;

        int actual_r = mid/col;
        int actual_c = mid%col;

        if(target == matrix[actual_r][actual_c]){
            return true;
        }else if(target < matrix[actual_r][actual_c]){
            return helper(matrix,left,mid-1,col,target);
        }else{
            return helper(matrix,mid+1,right,col,target);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;//col

        return helper(matrix,0, (row*col)-1, col, target);
    }
}