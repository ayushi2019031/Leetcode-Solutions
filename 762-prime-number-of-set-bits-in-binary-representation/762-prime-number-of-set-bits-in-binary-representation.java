class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0; 
        for (int i = left; i <= right; i++){
            String k = Integer.toBinaryString(i);
        int count = 0; 
            for (int j =0; j < k.length(); j++){
                if (k.charAt(j) == '1'){count += 1;}
            }
            if (count == 2 || count == 3 || count == 5 || count == 7 || count == 11 || count == 13 || count == 17 || count == 19 || count == 23 || count == 29 || count == 31){
                ans += 1; 
            }
        }
        return ans; 
    }
}