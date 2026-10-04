public class Vehicle {
    private VehicleType vehicleType;
    private String vehicleNumber;

    public Vehicle(VehicleType vehicleType, String vehicleNumber) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
