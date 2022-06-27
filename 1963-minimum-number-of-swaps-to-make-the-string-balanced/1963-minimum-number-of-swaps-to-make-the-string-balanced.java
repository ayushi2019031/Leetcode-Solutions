class Solution {
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length; 
        int j = n -1; 
        int ans =0; 
        int c1 = 0; int c2 = 0; 
        for (int i = 0; i < n; i++){
            if (arr[i] == '['){c1 += 1; }
            if (arr[i] == ']'){
                c2 += 1; 
                if (c2 > c1){
                    while (j > i && arr[j] == ']'){j -= 1; }
                    ans += 1; 
                    arr[i] = '['; arr[j] = ']';
                    c1 += 1; c2 -= 1; 
                }
                else{
                    continue;
                }
            }
        }
        return ans; 
    }
}