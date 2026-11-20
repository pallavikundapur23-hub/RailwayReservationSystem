package service;

import datastructures.WaitingListQueue;
import exceptions.BookingNotFoundException;
import exceptions.SeatNotAvailableException;
import model.Booking;
import model.Passenger;
import model.Train;
import util.PNRGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Handles booking, cancellation, PNR retrieval, and FIFO waiting-list promotion. */
public class ReservationService {
    private final BookingService bookingService = new BookingService();
    private final Map<Integer, WaitingListQueue<Booking>> waitingLists = new HashMap<>();
    private final Map<String, Booking> allBookingsByPnr = new HashMap<>();
    private final Set<String> issuedPnrs = new HashSet<>();
    public Booking book(Passenger passenger, Train train) {
        try { Booking b = bookingService.bookConfirmed(passenger, train); register(b); return b; }
        catch (SeatNotAvailableException ex) {
            Booking b = new Booking(PNRGenerator.nextPnr(), passenger, train, Booking.Status.WAITING);
            register(b); waitingLists.computeIfAbsent(train.getTrainNumber(), k -> new WaitingListQueue<>()).enqueue(b); return b;
        }
    }
    private void register(Booking booking) { issuedPnrs.add(booking.getPnr()); allBookingsByPnr.put(booking.getPnr(), booking); }
    public Booking findBooking(String pnr) throws BookingNotFoundException {
        Booking b = allBookingsByPnr.get(pnr);
        if (b == null) throw new BookingNotFoundException("No booking found for PNR: " + pnr); return b;
    }
    public void cancel(String pnr) throws BookingNotFoundException {
        Booking b = findBooking(pnr);
        if (b.getStatus() == Booking.Status.CANCELLED) throw new BookingNotFoundException("Booking is already cancelled.");
        if (b.getStatus() == Booking.Status.WAITING) { b.setStatus(Booking.Status.CANCELLED); return; }
        b.setStatus(Booking.Status.CANCELLED); b.getTrain().releaseSeat();
        WaitingListQueue<Booking> q = waitingLists.get(b.getTrain().getTrainNumber());
        while (q != null && !q.isEmpty()) {
            Booking next = q.dequeue();
            if (next.getStatus() == Booking.Status.WAITING && b.getTrain().reserveSeat()) { next.setStatus(Booking.Status.CONFIRMED); break; }
        }
    }
    public List<Booking> getAllBookings() { return new ArrayList<>(allBookingsByPnr.values()); }
    public List<Booking> getWaitingBookings(int trainNumber) {
        WaitingListQueue<Booking> q = waitingLists.get(trainNumber); return q == null ? new ArrayList<>() : q.toList();
    }
    public Set<String> getIssuedPnrs() { return new HashSet<>(issuedPnrs); }
}
