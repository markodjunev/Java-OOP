package com.company;

public class Main {

    public static void main(String[] args) {
        var emp1 = new Employee("Ivan", TypeOfContract.Permanent, 160 , 8, 100);
        var emp2 = new Employee("Pesho", TypeOfContract.PartTime, 80, 7, 50);
        var emp3 = new Employee("Peter", TypeOfContract.Trainee, 60, 5, 20);
        var emp4 = new Employee("Gosho", TypeOfContract.Permanent, 200 , 8, 100);

        var company = new Company("Nbu", 5);

        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp4);

        // company.showEmployees();
        //System.out.println(emp1.toString());
        //System.out.println(emp4.toString());
        //System.out.println(emp3.toString());

        // company.increaseAllEmployeesAdditionalPayment(10);

        // System.out.println(company.allEmployeesAverageSalariesByContractType(TypeOfContract.Permanent));
    }
}
