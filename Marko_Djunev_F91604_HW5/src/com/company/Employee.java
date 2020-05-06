package com.company;

import javax.lang.model.element.TypeElement;

public class Employee {
    private static int counter = 0;

    private String name;
    private int serialNumber;
    private TypeOfContract contract;
    private int workingHoursMonthly;
    private double hourPayment;
    private double additionalPayment;
    private double salary;

    public Employee(String name, TypeOfContract contract, int workingHoursMonthly, double hourPayment, double additionalPayment){
        this.serialNumber = ++counter;
        this.name = name;
        this.contract = contract;
        this.workingHoursMonthly = workingHoursMonthly;
        this.hourPayment = hourPayment;
        this.additionalPayment = additionalPayment;
        setSalary();
    }

    private void setSalary(){
        this.salary = (this.hourPayment * this.workingHoursMonthly) + this.additionalPayment;
    }
    public double getSalary(){
        return this.salary;
    }

    public void increaseAdditionalPayment(double percentage){
        double inc = (percentage + 100) / 100;
        this.additionalPayment *= inc;
        setSalary();
    }

    public TypeOfContract getTypeOfContract(){
        return this.contract;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + this.name +
                ", serialNumber=" + this.serialNumber +
                ", contract=" + this.contract +
                ", workingHoursMonthly=" + this.workingHoursMonthly +
                ", hourPayment=" + this.hourPayment +
                ", additionalPayment=" + this.additionalPayment +
                ", salary=" + this.salary +
                '}';
    }
}
