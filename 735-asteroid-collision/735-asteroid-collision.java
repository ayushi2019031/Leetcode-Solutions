class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); 
        int n = asteroids.length;
        for (int i = 0; i < n; i++){
            if (asteroids[i] > 0){
                stack.push(i);
            }
            else {
                // if (i == 0) {continue;}
                boolean addtostack = true;
                while (!stack.isEmpty()){
                    int aj = Math.abs(asteroids[i]);
                    if (asteroids[stack.peek()] > 0){
                    if (aj < asteroids[stack.peek()]){
                        addtostack = false;
                        break;
                    }
                    else if (aj == asteroids[stack.peek()]){
                        addtostack = false;
                        stack.pop();
                        break;
                    }
                    else{
                        stack.pop();
                    }
                    }
                    else{break;}
                
                }
                if (addtostack) stack.add(i);
            }
            }
        ArrayList<Integer> list = new ArrayList<>(); 
        while (!stack.isEmpty()) list.add(stack.pop());
        Collections.reverse(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = asteroids[list.get(i)];
        }
        return arr; 
    }
}