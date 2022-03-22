class Solution {
    public int countCollisions(String directions) {
        int i = 0;
        int n = directions.length(); 
        int ans = 0; 
        while (i < n && directions.charAt(i) == 'L') i++;
        
        int no_of_right = 0; 
        while (i < n){
            if (directions.charAt(i) == 'R'){
                no_of_right += 1; 
            }
            else {
                if (directions.charAt(i) == 'L'){ans += no_of_right + 1;  no_of_right = 0;  }
                else {ans += no_of_right; no_of_right = 0; } 
            }
            i += 1; 
        }
        return ans; 
    }
}