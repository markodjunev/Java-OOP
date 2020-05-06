public class Studio {
    private double EuroPrice = 1.95;
    private double DollarPrice = 1.7;

    private double maxHoursPerDay; //it can be 8:30 => 8.5
    private double availableHours;
    private double price;
    private double totalIncomePerDay;

    public Studio(double maxHoursPerDay){
        this.maxHoursPerDay = maxHoursPerDay;
        this.availableHours = maxHoursPerDay;
    }

    public void set_Price(double price){
        this.price = price;
    }

    public double get_Price(){
        return this.price;
    }

    public boolean isFree(double hours){
        if (this.availableHours >= hours){
            return true;
        }
        return false;
    }

    public double check_Total_Incomes(){
        return this.totalIncomePerDay;
    }

    public double check_Total_Incomes_Euros(){
        return this.totalIncomePerDay * EuroPrice;
    }

    public double check_Total_Incomes_Dollars(){
        return this.totalIncomePerDay * DollarPrice;
    }

    public double get_Available_Hours(){
        return this.availableHours;
    }

    public void reserve(double hours){
        this.availableHours -= hours;
        this.totalIncomePerDay += (hours * price);
    }
}
