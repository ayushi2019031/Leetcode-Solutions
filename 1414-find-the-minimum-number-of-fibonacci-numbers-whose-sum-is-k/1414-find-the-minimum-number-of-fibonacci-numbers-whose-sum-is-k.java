class Solution {
    public int findMinFibonacciNumbers(int k) {
        int f= 1; 
        ArrayList<Integer> fib = new ArrayList<>(); 
        fib.add(1); fib.add(1); 
        int l = 2; 
        while (l <= k){
            int r = fib.get(fib.size() - 1); 
            fib.add(l); 
            l = r + l;         
        }
        Collections.reverse(fib); 
        int i =0; 
        int kk = 0; 
        int ans = 0; 
        while (i < fib.size() && k >= 0){
            if (fib.get(i) <= k){
                int tt = k/fib.get(i); 
                k -= (tt)*fib.get(i); 
                ans += tt; 
                i += 1; 
            }
            else i += 1;
        }
        return ans; 
     }
}