class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>(); 
        Stack<Integer> stack = new Stack<>(); 
        int n = nums.length; 
        for (int i = 0; i < n; i++){
            if (stack.isEmpty()){
                stack.push(nums[i]);
            }
            else {
                if (gcd(stack.peek(), nums[i]) > 1){
                    // System.out.println("ENTERED");
                    int lc = nums[i]; 
                    // System.out.println(lc + " " + stack.peek());
                    while (!stack.isEmpty() && gcd(stack.peek(), lc) > 1){
                        lc = lcm(lc, stack.peek());
                        // System.out.println(lc + " " + stack.peek());
                        stack.pop(); 
                    }
                    // System.out.println("PUSHING: " + lc);
                    stack.push(lc);
                }
                
                else {
                    // System.out.println("NOT ENTERE");
                    // System.out.println(nums[i]);
                    stack.push(nums[i]);
                }
            }
        }
        
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list; 
    }
    public int lcm(int a, int b){
        // System.out.println("LCM : " + a + " " + b + " " + (a*b)/(gcd(a, b)) ); 
        return ((a)/(gcd(a, b)))*b;
    }
    public int gcd(int a, int b){
        if (a == 0) return b; 
        return gcd(b % a, a );
    }
}