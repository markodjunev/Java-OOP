package com.company;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private int maxEmployeesCount;
    private List<Employee> employees;

    public Company(String name, int maxEmployeesCount){
        this.name = name;
        this.maxEmployeesCount = maxEmployeesCount;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (this.employees.size() < maxEmployeesCount) {
            this.employees.add(employee);
        }

        else{
            System.out.println("Sorry, the capacity of the company is full! We cannot hire this employee.");
        }
    }

    public void fireEmployee(Employee employee){
        if (!this.employees.contains(employee)){
            System.out.println("This employee isn't in the company!");
        }
        else{
            this.employees.remove(employee);
        }
    }

    public void showEmployees(){
        for (Employee employee:this.employees) {
            System.out.println(employee.toString());
        }
    }

    public double employeesTotalSalary(){
        double sum = 0;
        for (Employee employee:this.employees) {
            sum+=employee.getSalary();
        }

        return sum;
    }

    public double employeesAverageSalary(){
        double sum = 0;
        for (Employee employee:this.employees) {
            sum+=employee.getSalary();
        }

        return sum / this.employees.size();
    }

    public void increaseEmployeeAdditionalPayment(Employee employee, double percentage){
        employee.increaseAdditionalPayment(percentage);
    }

    public void increaseAllEmployeesAdditionalPayment(double percentage){
        for (Employee employee: this.employees) {
            employee.increaseAdditionalPayment(percentage);
        }
    }

    public double allEmployeesAverageSalariesByContractType(TypeOfContract typeOfContract){
        double sum = 0;
        int count = 0;

        for (Employee employee:this.employees) {
            if (employee.getTypeOfContract() == typeOfContract){
                sum+=employee.getSalary();
                count++;
            }
        }

        return sum / count;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name=" + this.name +
                ", maxEmployeesCount=" + this.maxEmployeesCount +
                ", currentEmployeesCount=" + this.employees.size() +'}';
    }
}
