class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length; 
        Arrays.sort(time);
        long sum = 0; 
        for (int i = 0; i < n; i++) sum += time[i];
        System.out.println(totalTrips*sum);
        return binsearch(time, totalTrips, 0, totalTrips*sum);
    }
    public long binsearch(int[] time, int totalTrips, long s, long e){
        if (e < s) return -1; 
        long mid = s + ((e - s)/2);
        if (fun(time, totalTrips, mid)){
            long u = binsearch(time, totalTrips, s, mid - 1);
            if (u == -1) return mid;
            return u;
        }
        else {
            return binsearch(time, totalTrips, mid + 1, e);
        }
    }
    public boolean fun(int[] time, int totalTrips, long check){
        long ans = 0; 
        for (int i = 0; i < time.length;i++){
            ans += check/time[i];
        }
        if (ans >= totalTrips) return true;
        return false;
    }
}