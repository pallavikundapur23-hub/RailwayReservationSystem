package exceptions;

/** Raised when a PNR cannot be found in the in-memory booking register. */
public class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String message) { super(message); }
}
