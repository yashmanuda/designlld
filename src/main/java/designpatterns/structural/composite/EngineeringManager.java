package designpatterns.structural.composite;

import lombok.ToString;

/**
 * This is a leaf component
 */
@ToString
public class EngineeringManager implements Employee {
    private String name;
    private String email;
    private String team;

    EngineeringManager(String name, String email, String team) {
        this.name = name;
        this.email = email;
        this.team = team;
    }

    @Override
    public void printEmployeeDetails() {
        System.out.println("Engineering Manager: " + this.toString());
    }
}
