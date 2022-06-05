class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                double a1_ = (double) (o1[0] + 1)/(double) (o1[1] + 1);
                double a1 = (double) (o1[0])/(double) (o1[1]);
                double c1 = a1_ - a1;
                
                double a2_ = (double) (o2[0] + 1)/(double) (o2[1] + 1);
                double a2 = (double) (o2[0])/(double) (o2[1]);
                double c2 = a2_ - a2;
                return Double.compare(c2, c1);
                
            }
        }); 
        for (int[] class_: classes){
            pq.add(class_);
        }
        while (!pq.isEmpty() && extraStudents > 0){
            int[] k = pq.poll(); 
            k[0] += 1; k[1] += 1;
            extraStudents -= 1; 
            pq.add(k);
        }
        double aj = 0; 
        while (!pq.isEmpty()){
            int[] o1 = pq.poll();
            aj += (double)((double) o1[0]/(double) o1[1]);
        }
        aj = aj/classes.length;
        return aj; 
        
    }
}