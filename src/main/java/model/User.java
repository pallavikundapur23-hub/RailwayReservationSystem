package model;

/** Common abstraction for people who use the reservation system. */
public abstract class User {
    private final String userId;
    private String name;

    protected User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /** Displays details appropriate to the concrete user type. */
    public abstract void displayDetails();
}
