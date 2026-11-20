package exceptions;

/** Raised when a PNR cannot be found in the in-memory booking register. */
public class BookingNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public BookingNotFoundException(String message) { super(message); }
}
