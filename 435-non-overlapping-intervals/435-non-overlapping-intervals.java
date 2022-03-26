class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int prevEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            if(start<prevEnd){
                prevEnd=Math.min(prevEnd,intervals[i][1]);
                count++;
            }else{
                prevEnd=intervals[i][1];
            }
        }
        return count;
    }
}