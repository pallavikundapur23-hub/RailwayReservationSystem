package model;

/** Stores train route information and the current seat count. */
public class Train {
    private final int trainNumber;
    private final String trainName;
    private final String source;
    private final String destination;
    private final int totalSeats;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        if (totalSeats <= 0) throw new IllegalArgumentException("Total seats must be positive.");
        this.trainNumber = trainNumber; this.trainName = trainName;
        this.source = source; this.destination = destination;
        this.totalSeats = totalSeats; this.availableSeats = totalSeats;
    }
    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public boolean reserveSeat() { if (availableSeats == 0) return false; availableSeats--; return true; }
    public void releaseSeat() { if (availableSeats < totalSeats) availableSeats++; }
    @Override public String toString() {
        return trainNumber + " | " + trainName + " | " + source + " -> " + destination
                + " | Seats: " + availableSeats + "/" + totalSeats;
    }
}
