class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++){
            grid.add(new ArrayList<Integer>());
            for (int j = 0; j < triangle.get(i).size(); j++){grid.get(i).add(Integer.MAX_VALUE);}
        }
        dp(triangle, grid, 0, 0);
        return grid.get(0).get(0);
    }
    
    public int dp(List<List<Integer>> triangle, List<List<Integer>> grid, int i, int j){
        if (i >= grid.size() || j >= grid.get(i).size()) return 0; 
        if (grid.get(i).get(j) != Integer.MAX_VALUE){
            return grid.get(i).get(j);
        }
        int t = triangle.get(i).get(j); 
        grid.get(i).set(j, t + Math.min(dp(triangle, grid, i + 1, j), dp(triangle, grid, i + 1, j + 1)));
        return grid.get(i).get(j);
    }
}