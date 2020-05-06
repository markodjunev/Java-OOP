package repository;

public class WashingMachine extends ElectricalAppliance {
    private double rpm;
    private boolean dryingClothes;

    public WashingMachine(double price, Manufacturer manufacturer, int minimumWarrantyPeriodMonths, double rpm, boolean dryingClothes){
        super(price, manufacturer, minimumWarrantyPeriodMonths);
        this.rpm = rpm;
        this.dryingClothes = dryingClothes;
        if (dryingClothes == true){
            this.minimumWarrantyPeriodMonths += minimumWarrantyPeriodMonths / 2;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "WashingMachine{" +
                "rpm='" + rpm + '\'' +
                "dryingClothes='" + dryingClothes + '\'' +
                '}';
    }
}
