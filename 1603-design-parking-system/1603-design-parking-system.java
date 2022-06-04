class ParkingSystem {
    int big; int medium; int small;
    public ParkingSystem(int big, int medium, int small) {
      this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int car) {
        if (car == 1){
            if (big == 0) return false;
            big -=1;
        }
        else if (car == 2){
            if (medium == 0) return false;
            medium -= 1;
        }
        else if (car == 3){
            if (small == 0)
                return false;
            small -= 1;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */