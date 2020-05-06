package repository;

public class Oven extends ElectricalAppliance{

    public Oven(double price, Manufacturer manufacturer, int minimumWarrantyPeriodMonths){
        super(price, manufacturer, minimumWarrantyPeriodMonths);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
