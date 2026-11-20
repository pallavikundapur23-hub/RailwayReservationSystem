package model;

/** Represents an administrator of the console application. */
public class Admin extends User {
    private final String role;

    public Admin(String userId, String name, String role) {
        super(userId, name);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin: " + getName() + " | Role: " + role);
    }
}
