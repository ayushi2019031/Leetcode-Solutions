class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0; 
        int n = machines.length;
        for (int i = 0; i < machines.length; i++){
            sum += machines[i];
        }
        if (sum % n != 0) return -1;
        int ref = sum/n;
        int ans = Integer.MIN_VALUE;
        int ex = 0; 
        for (int i = 0; i < n;i++){
            int de = -(ref - machines[i]);
            ex += de;
            ans = Math.max( Math.abs(ex), Math.max(de, ans));
        }
        return ans;
        
    }
}