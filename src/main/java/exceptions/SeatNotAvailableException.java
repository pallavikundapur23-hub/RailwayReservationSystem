package exceptions;

/** Raised when a confirmed seat is requested but none is available. */
public class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String message) { super(message); }
}
