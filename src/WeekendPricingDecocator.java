public class WeekendPricingDecocator implements PricingStrategy{
    private PricingStrategy pricingStrategy;

    public WeekendPricingDecocator(PricingStrategy pricingStrategy){
        this.pricingStrategy=pricingStrategy;
    }

    @Override
    public long calculateFee(Ticket ticket) {
        return (long)(pricingStrategy.calculateFee(ticket)*1.5);
    }
}
