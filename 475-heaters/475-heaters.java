class Solution {
    public boolean fun(int[] houses, int[] heaters, int radius){
        int curr = 0; int i = 0; 
        while (i < houses.length){
            int min = heaters[curr] - radius;
            int max = heaters[curr] + radius;
            if (houses[i] >= min && houses[i] <= max){
                i += 1;
            }
            else {
                
                curr +=1;
                if (curr >= heaters.length) return false;
            }
            
        }
        return true;
        
    }
    public int bin(int[] houses, int[] heaters, int s, int e){
        if (s > e) return -1; 
        int mid = s + (e - s)/2;
        boolean flag = fun(houses, heaters, mid);
        if (flag){
            int u = bin(houses, heaters, s, mid - 1);
            if (u == -1) return mid;
            return u; 
        }
        else {
            int u = bin(houses, heaters, mid + 1, e);
            return u;
        }
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        return bin(houses, heaters, 0, Integer.MAX_VALUE);
    }
}