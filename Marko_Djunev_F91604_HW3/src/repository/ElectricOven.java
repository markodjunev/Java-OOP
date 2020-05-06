package repository;

public class ElectricOven extends Oven {

    public ElectricOven(double price, Manufacturer manufacturer, int minimumWarrantyPeriodMonths){
        super(price, manufacturer, minimumWarrantyPeriodMonths);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
