class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean row0 = false; boolean col0 = false;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                   if (i != 0 && j != 0){ 
                        matrix[i][0] = 0; matrix[0][j] = 0;
                   }
                    else{
                        if (i == 0) row0 = true;
                        if (j == 0) col0 = true;
                    }
                }
            }
        }
        for (int i = 1; i < rows; i++){
            if (matrix[i][0] == 0){
                for (int j = 0; j < cols; j++){matrix[i][j] = 0; }
            }
        }
        for (int i = 1; i < cols; i++){
            if (matrix[0][i] == 0){
                for (int j = 0; j < rows; j++){matrix[j][i] = 0; }
            }
        }
        if (row0){for (int i = 0; i < cols; i++) matrix[0][i] = 0;}
        if (col0){for (int i = 0; i < rows; i++){matrix[i][0] = 0; }}
    }
}