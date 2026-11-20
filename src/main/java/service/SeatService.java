package service;

import model.Train;

/** Encapsulates seat availability and seat-count updates. */
public class SeatService {
    public int getAvailableSeats(Train train) { return train.getAvailableSeats(); }
    public boolean reserveSeat(Train train) { return train.reserveSeat(); }
    public void releaseSeat(Train train) { train.releaseSeat(); }
}
