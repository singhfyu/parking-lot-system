import java.time.LocalDateTime;

public class Ticket {
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime=entryTime;
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
