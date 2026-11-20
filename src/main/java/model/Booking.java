package model;

/** Represents one passenger's reservation request and its current status. */
public class Booking {
    public enum Status { CONFIRMED, WAITING, CANCELLED }
    private final String pnr;
    private final Passenger passenger;
    private final Train train;
    private Status status;

    public Booking(String pnr, Passenger passenger, Train train, Status status) {
        this.pnr = pnr; this.passenger = passenger; this.train = train; this.status = status;
    }
    public String getPnr() { return pnr; }
    public Passenger getPassenger() { return passenger; }
    public Train getTrain() { return train; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    @Override public String toString() {
        return "PNR: " + pnr + " | " + passenger.getName() + " | " + train.getTrainName()
                + " | " + train.getSource() + " -> " + train.getDestination() + " | " + status;
    }
}
