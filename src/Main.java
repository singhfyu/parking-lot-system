import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        PricingStrategy pricingStrategy1 = new HolidayPricingDecorator(new WeekendPricingDecocator(
                                               new DayNightPricingStrategy()),holidayCalendar);

        ParkingLot parkingLot = new ParkingLot(10,10,5,pricingStrategy1);
        Vehicle vehicle = new Vehicle(VehicleType.BIKE, "BR30B4935");
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        LocalDateTime exitTime = ticket.getEntryTime().plusHours(60);
        long fee = parkingLot.unparkVehicle(vehicle, exitTime);
        System.out.println("Parking fee = "+fee);
    }
}