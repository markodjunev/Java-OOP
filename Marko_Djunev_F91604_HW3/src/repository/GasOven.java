package repository;

public class GasOven extends Oven {

    public GasOven(double price, Manufacturer manufacturer, int minimumWarrantyPeriodMonths) {
        super(price, manufacturer, minimumWarrantyPeriodMonths);
        this.minimumWarrantyPeriodMonths+=12;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}