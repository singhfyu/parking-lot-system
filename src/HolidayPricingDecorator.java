public class HolidayPricingDecorator implements PricingStrategy{
    private PricingStrategy pricingStrategy;

    public HolidayPricingDecorator(PricingStrategy pricingStrategy){
        this.pricingStrategy=pricingStrategy;
    }

    @Override
    public long calculateFee(Ticket ticket) {
        return pricingStrategy.calculateFee(ticket)*2;
    }
}
