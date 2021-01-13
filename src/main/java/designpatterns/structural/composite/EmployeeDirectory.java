package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the composite which manages the collection / composition of the component
 */
public class EmployeeDirectory implements Employee {
    private List<Employee> employeeList;

    EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public void printEmployeeDetails() {
        for (Employee employee : employeeList) employee.printEmployeeDetails();
    }

    /**
     * @param employee can also be an employee directory
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
