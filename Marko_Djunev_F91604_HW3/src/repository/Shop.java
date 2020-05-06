package repository;

public class Shop {

    public void Purchase(Customer customer, ElectricalAppliance electricalAppliance){
        if(customer.GetBudget() >= electricalAppliance.price){
            customer.NewBudget(electricalAppliance.price);
        }
    }



}
