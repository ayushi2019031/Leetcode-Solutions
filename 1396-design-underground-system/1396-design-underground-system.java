class Node{
    int in; int out; String station_in; String station_out;
    public Node(String station_in, int in){
        this.station_in = station_in; this.in  = in; 
    }
}
class UndergroundSystem {
    HashMap<String, Integer> frequency = new HashMap<>();
    HashMap<String, Integer> sum_of_time = new HashMap<>(); 
    HashMap<Integer, Node> id_info = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
            id_info.put(id, new Node(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        id_info.get(id).out = t; 
        String aj = id_info.get(id).station_in + "_" + stationName;
        frequency.put(aj, frequency.getOrDefault(aj, 0) + 1);
        sum_of_time.put(aj, sum_of_time.getOrDefault(aj, 0) + t - id_info.get(id).in);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String aj = startStation + "_" + endStation; 
        return (double) ((double)sum_of_time.get(aj))/((double)frequency.get(aj));
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */