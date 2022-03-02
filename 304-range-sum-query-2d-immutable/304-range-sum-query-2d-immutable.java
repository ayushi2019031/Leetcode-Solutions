class NumMatrix {
    int[][] matrix; 
    int r ; 
    int c ; 
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        r = matrix.length; c = matrix[0].length;
        int[][] cols = new int[r][c];
        for (int j = 0; j < c; j++){
            for (int i = 1; i < r; i++){
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        for (int j = 1; j < c; j++){
            for (int i = 0; i < r; i++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        for (int i = 0; i < r; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int ans = matrix[row2][col2];
        if (col1 > 0) ans -= matrix[row2][col1 - 1];
        if (row1 > 0) ans -= matrix[row1 - 1][col2];
        if (row1 > 0 && col1 > 0) ans += matrix[row1 - 1][col1 - 1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */