package repository;

public class Customer {
    private double budget;

    public Customer(double budget){
        this.budget = budget;
    }

    public double GetBudget(){
        return this.budget;
    }

    public void NewBudget(double appliancePrice){
        this.budget-=appliancePrice;
    }

    @Override
    public String toString() {
        return "repository.Customer{" +
                "budget='" + budget + '\'' +
                '}';
    }

}
