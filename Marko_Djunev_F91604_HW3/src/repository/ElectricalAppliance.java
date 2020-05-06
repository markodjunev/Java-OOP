package repository;

public class ElectricalAppliance {
    protected double price;
    protected Manufacturer manufacturer;
    protected int minimumWarrantyPeriodMonths;

    public ElectricalAppliance(double price, Manufacturer manufacturer, int minimumWarrantyPeriodMonths){
        this.price = price;
        this.manufacturer = manufacturer;
        this.minimumWarrantyPeriodMonths = minimumWarrantyPeriodMonths;
    }

    protected ElectricalAppliance(double price, Manufacturer manufacturer){
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public void ExtendMinimumWarrantyPeriodMonths(int months){
        boolean isPossible = this.manufacturer.ExtendGuarantee();

        if (isPossible)
            this.minimumWarrantyPeriodMonths += 12;
        else
            System.out.println("Sorry, but the manufacturer doesn't offer to extend your guarantee period.");
    }

    public int guaranteePeriod(){
        return this.minimumWarrantyPeriodMonths;
    }

    @Override
    public String toString() {
        return "repository.ElectricalAppliance{" +
                "price='" + price +
                "manufacturer" + manufacturer +
                "minimumWarrantyPeriodMonths" + minimumWarrantyPeriodMonths + '\'' +
                '}';
    }

}
