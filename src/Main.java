//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //PricingStrategy pricingStrategy1 = new HolidayPricingDecorator(new WeekendPricingDecocator(
         //                                       new DayNightPricingStrategy()));
        PricingStrategy pricingStrategy2 = new WeekendPricingDecocator(new DayNightPricingStrategy());

        ParkingLot parkingLot = new ParkingLot(10,10,5,pricingStrategy2);
        Vehicle vehicle = new Vehicle(VehicleType.BIKE, "BR30B4935");
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        long fee = parkingLot.unparkVehicle(vehicle);
        System.out.println("Parking fee = "+fee);
    }
}