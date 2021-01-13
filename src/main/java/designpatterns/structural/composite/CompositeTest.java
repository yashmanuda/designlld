package designpatterns.structural.composite;

public class CompositeTest {
    public static void main(String[] args) {
        Developer developer1 = new Developer("John", "john@sample.com", "Search");
        Developer developer2 = new Developer("Max", "max@sample.com", "Payment");

        EmployeeDirectory devDirectory = new EmployeeDirectory();
        devDirectory.addEmployee(developer1);
        devDirectory.addEmployee(developer2);

        EngineeringManager e1 = new EngineeringManager("Creed", "creed@sample.com", "Search");
        EngineeringManager e2 = new EngineeringManager("Oliver", "oliver@sample.com", "Payment");

        EmployeeDirectory managerDirectory = new EmployeeDirectory();
        managerDirectory.addEmployee(e1);
        managerDirectory.addEmployee(e2);


        EmployeeDirectory overallEmployeeDirectory = new EmployeeDirectory();
        overallEmployeeDirectory.addEmployee(devDirectory);
        overallEmployeeDirectory.addEmployee(managerDirectory);

        overallEmployeeDirectory.printEmployeeDetails();
    }
}
