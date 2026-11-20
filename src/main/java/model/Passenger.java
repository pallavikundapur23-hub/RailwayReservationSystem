package model;

/** Represents a passenger who can reserve railway seats. */
public class Passenger extends User {
    private final String phoneNumber;

    public Passenger(String userId, String name, String phoneNumber) {
        super(userId, name);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public void displayDetails() {
        System.out.println("Passenger: " + getName() + " | ID: " + getUserId() + " | Phone: " + phoneNumber);
    }
}
