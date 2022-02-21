class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int row = getrow( matrix, target, 0, matrix.length - 1);
       if (row == -1)return false;
        for (int i = 0; i < matrix[row].length; i++){
            if (matrix[row][i] == target) return true;
        }
        return false;
    }
    public int getrow(int[][] matrix, int target, int s, int e){
        if (e < s) return -1; 
        int mid = (s + e)/2;
        if (matrix[mid][0] == target) return mid; 
        if (matrix[mid][0] < target){
            int tbt = getrow(matrix, target, mid + 1, e);
            if (tbt == -1) return mid;
            return tbt;
        }
        if (matrix[mid][0] > target){
            return getrow(matrix, target, s, mid - 1);
        }
        return -1; 
    }
}