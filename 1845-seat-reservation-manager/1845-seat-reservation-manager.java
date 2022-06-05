class SeatManager {
    Set<Integer> reservedSeats = new HashSet<>();
    PriorityQueue<Integer> availableSeats = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; ++i) {
            this.availableSeats.add(i);
        }
    }
    
    public int reserve() {
        int curSeat = this.availableSeats.poll();
        // this.reservedSeats.add(curSeat);
        return curSeat;
    }
    
    public void unreserve(int seatNumber) {
        // this.reservedSeats.remove(seatNumber);
        this.availableSeats.add(seatNumber);
    }}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */