class Solution {
    public void solve(char[][] board) {
        int m = board.length; int n = board[0].length;
        int[][] vis = new int[m][n];
        boolean[][] result = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) result[i][j] = true;
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                boolean cond = false;
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) cond = true;
                if (cond == true){
                   if (board[i][j] == 'O') System.out.println(i + " " + j);
                if (board[i][j] == 'O') dfs(board, vis, result, i, j);
                }
            }
        }
        System.out.println("---------");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (result[i][j]) board[i][j] = 'X';
            }
        }
        
    }
    public void dfs(char[][] board, int[][] vis, boolean[][] result, int x, int y){
        if (!isValid(x, y, board.length, board[0].length) || board[x][y] == 'X') return;
        result[x][y] = false;
        int[] h= new int[]{1, -1, 0, 0};
        int[] v = new int[]{0, 0, 1, -1};
        vis[x][y] = 1;
        for (int i = 0; i < 4; i++){
            
            if (isValid(x + h[i], y + v[i], board.length, board[0].length ) && vis[x + h[i]][y + v[i]] == 0){
            dfs(board, vis, result, x + h[i], y + v[i]);
            }
        }
        vis[x][y] =2 ; 
    
    }
    public boolean isValid(int a, int b,int  c,int  d){
        if (a < c && a >= 0 && b < d && b >= 0) return true;
        return false;
    }
}