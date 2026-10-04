public class ParkingSpot {
    private final SpotType spotType;
    private Vehicle vehicle;
    private final int spotId;

    public ParkingSpot(int spotId, SpotType spotType){
        this.spotId=spotId;
        this.spotType=spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getSpotId() {
        return spotId;
    }

    public boolean isAvailable(){
            return this.vehicle==null;
    }

    public void allocate(Vehicle vehicle){
        if(!isAvailable()){
            throw new IllegalStateException("Parking spot is already occupied");
        }
        this.vehicle=vehicle;
    }

    public void release(){
        this.vehicle = null;
    }
}
