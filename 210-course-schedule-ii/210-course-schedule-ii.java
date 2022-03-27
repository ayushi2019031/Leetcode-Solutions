class Solution {
    Stack<Integer> stack;
    ArrayList<Integer>[] adj;
    int[] color; 
boolean f = true;
    public int[] findOrder(int numCourses, int[][] prereqs) {
        this.stack= new Stack<>(); 
        this.adj = new ArrayList[numCourses];
        this.color = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>(); 
        for (int[] k: prereqs){
            adj[k[1]].add(k[0]);
        }
        for (int i = 0; i < numCourses; i++){
            if (color[i] == 0){dfs(i);}
        }
        ArrayList<Integer> list =new ArrayList<>(); 
        while (!stack.isEmpty()) list.add(stack.pop());
        int[] ans = new int[numCourses];
        if (!f) return new int[0];
        for (int i = 0; i < numCourses; i++){ans[i] = list.get(i);}
        return ans;
        
    }
    public void dfs(int s){
        
        
        color[s] = 1;
       
        for (int k: adj[s]){
            if (color[k] == 0){
                dfs(k);
            }
            else if (color[k] == 1){
                this.f = false; 
            }
        }
        color[s] = 2; 
        stack.push(s); 
    }
}