/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
         return help(grid, 0, 0, grid.length, grid.length);
    }
    public Node help(int[][] grid, int sx, int sy , int ex, int ey){
        Node root = new Node();
        boolean f0 = true;
        for (int i = sx; i < ex; i++){
            for (int j = sy; j  < ey; j++){
                if (grid[i][j] == 1){f0 = false;}
            }
        }
        if (f0){
            root.val = false; root.isLeaf = true;
        }
        
        boolean f1 = true;
        for (int i = sx; i < ex; i++){
            for (int j = sy; j  < ey; j++){
                if (grid[i][j] == 0){f1 = false;}
            }
        }
        if (f1){
            root.val = false; root.isLeaf = true;
        }
        if (f1){
            root.val = true; root.isLeaf = true;
        }
        if (!f0 && !f1){
            root.isLeaf = false;
            root.topLeft = help(grid, sx, sy, (sx + ex)/2, (sy + ey)/2);
            root.topRight = help(grid, sx, (sy + ey)/2, (sx + ex)/2, ey);
            root.bottomLeft = help(grid, (sx + ex)/2, sy, ex, (ey + sy)/2);
            root.bottomRight = help(grid, (sx + ex)/2, (sy + ey)/2, ex, ey);
            return root; 
        }
        return root; 
    }
}