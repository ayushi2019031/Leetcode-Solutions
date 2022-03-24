class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0; int j = n -  1; int ans = 0; 
        while (i <= j){
            if (i == j){ans += 1; i += 1; j -= 1; continue;}
            if (people[i] + people[j] <= limit){
                i += 1; 
            }
            j -= 1; ans += 1;
            
        }
        return ans; 
    }
}