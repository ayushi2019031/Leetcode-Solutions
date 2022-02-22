class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>(); 
        int len = intervals.length;
        int pos = 0; 
        boolean flag = false;
        for (int i = 0; i < len; i++){
            if (intervals[i][0] > newInterval[0]){
                flag = true; pos = i; break;
               
            }
        }
        
        int count = pos; int curr = 0; 
        if (!flag)  count = len;
        while (curr < len){
            if (count == curr){
                list.add(newInterval);
                count = -1; 
            }
            else {
                list.add(intervals[curr]); curr+= 1; 
            }
        }
        if (!flag) list.add(newInterval);
        for (int i = 0; i < list.size(); i++){
            System.out.print(Arrays.toString(list.get(i)) + " ");
            
        }
        System.out.println("");
        Stack<int[]> stack = new Stack<>(); 
        for (int i = 0; i < list.size(); i++){
            if (stack.isEmpty()){
                stack.push(list.get(i));
            }
            else {
                int[] cud = stack.peek(); 
                if (cud[1] >= list.get(i)[0]){
                    int[] aj = new int[2];
                    aj[0] = Math.min(list.get(i)[0], cud[0]);
                    aj[1] = Math.max(list.get(i)[1], cud[1]);
                    stack.pop(); 
                    stack.push(aj);
                }
                else {
                    stack.push(list.get(i));
                }
                
            }
        }
        int[][] grid = new int[stack.size()][2];
        for (int i = grid.length - 1; i >= 0; i--){
            grid[i] = stack.pop();
        }
        return grid;
    }
}