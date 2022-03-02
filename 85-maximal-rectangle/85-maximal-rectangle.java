class Solution {
    public int maximalRectangle(char[][] matrix) {
         int rows = matrix.length; int cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = matrix[i][j] - '0';
            }
        }
        for (int j = 0; j < cols; j++){
            for (int i = 1; i < rows; i++){
             if (grid[i][j] == 1)   grid[i][j] = grid[i - 1][j] + grid[i][j] ;
                
            }
        }
        int maxarea = 0;
        
        // for (int i = 0; i < rows; i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        for (int i = 0; i < rows; i++){
            maxarea = Math.max(maxarea, getMaxHist(grid[i]));
        }
        return maxarea;
    }
    
    public int getMaxHist(int[] arr){
    
        int n = arr.length; 
        int[] beforesmaller = new int[n];
        int[] aftersmaller = new int[n]; 
        
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < n;i++){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                    aftersmaller[stack.peek()] = i; 
                    stack.pop();
                    
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            aftersmaller[stack.pop()] = n;
        }
        
        stack = new Stack<>(); 
        for (int i = n -1;  i >= 0;i--){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else {
 
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    beforesmaller[stack.peek()] = i; 
                    stack.pop();
                   
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            beforesmaller[stack.pop()] = -1;
        }
        int ans = 0; 
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(beforesmaller));
            System.out.println(Arrays.toString(aftersmaller));
        System.out.println("------");
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, (aftersmaller[i] - beforesmaller[i] - 1)*arr[i]);
        }
        return ans;
        
    }
}