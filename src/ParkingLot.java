import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private Map<String, Ticket> tickets;
    private PricingStrategy pricingStrategy;

    public ParkingLot(int compactCount, int regularCount, int oversizedCount, PricingStrategy pricingStrategy){
        this.parkingSpots = new ArrayList<>();
        this.tickets = new HashMap<>();
        this.pricingStrategy=pricingStrategy;

        int spotId=1;
        for(int i=1;i<=compactCount; i++){
            parkingSpots.add(new ParkingSpot(spotId++,SpotType.COMPACT));
        }
        for(int i=1;i<=regularCount; i++){
            parkingSpots.add(new ParkingSpot(spotId++,SpotType.REGULAR));
        }
        for(int i=1;i<=oversizedCount; i++){
            parkingSpots.add(new ParkingSpot(spotId++,SpotType.OVERSIZE));
        }
    }
    public long calculateFee(Ticket ticket, LocalDateTime exitTime){
        return pricingStrategy.calculateFee(ticket, exitTime);
    }
    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findAndAllocateSpot(vehicle);
        if(parkingSpot==null){
            System.out.println("Ticket was not generated as parking spot not available");
            return null;
        }
        LocalDateTime entryTime = LocalDateTime.now() ;
        //generate ticket
        Ticket ticket = new Ticket(entryTime, vehicle, parkingSpot);
        tickets.put(vehicle.getVehicleNumber(), ticket);
        return ticket;
    }

    public long unparkVehicle(Vehicle vehicle, LocalDateTime exitTime){
        Ticket ticket = tickets.get(vehicle.getVehicleNumber());

        if(ticket==null)
            throw new IllegalArgumentException("Vehicle is not parked");

        ParkingSpot spot = ticket.getParkingSpot();
        long fee = calculateFee(ticket, exitTime);
        spot.disallocate();
        tickets.remove(vehicle.getVehicleNumber());

        return fee;
    }
    public ParkingSpot findAndAllocateSpot(Vehicle vehicle){
        //searches appropriate spot according to vehicle type and allocates that spot to that vehicle
        SpotType requiredSpotType = vehicle.getVehicleType().getSpotType();
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isAvailable() && parkingSpot.getSpotType()==requiredSpotType) {
                parkingSpot.allocate(vehicle);
                return parkingSpot;
            }
        }
        System.out.println("Parking spot not available for your vehicle type");
        return null;
    }
}
