class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] xor = new int[m][n];
        
        xor[0][0] = matrix[0][0];
        
        for (int i = 1; i < m; i++){
            xor[i][0]  = matrix[i][0];
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                xor[i][j] = xor[i][j - 1] ^ matrix[i][j];
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                xor[i][j] = xor[i - 1][j] ^ xor[i][j];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                list.add(xor[i][j]);
            }
        }
        System.out.println(list);
        Collections.sort(list);
        Collections.reverse(list);
        return list.get(k - 1);
    }
}