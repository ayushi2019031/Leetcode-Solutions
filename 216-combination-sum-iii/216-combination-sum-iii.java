class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>(); 
        fun(ans, new ArrayList<Integer>(), 1, k, n);
        return ans; 
    }
    public void fun(List<List<Integer>> ans, ArrayList<Integer> curr, int index, int k, int n){
        if (k == 0) {
            if (n == 0){
                ans.add(new ArrayList<Integer>(curr));
            }
            return;
        }
        
        for (int i = index; i <= 9; i++){
            if (!curr.contains(i)){
                ArrayList<Integer> temp = new ArrayList<>(curr);
                temp.add(i);
                fun(ans, temp, i + 1, k - 1, n - i);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}