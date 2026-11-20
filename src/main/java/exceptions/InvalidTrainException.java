package exceptions;

/** Raised when a requested train number does not exist. */
public class InvalidTrainException extends Exception {
    private static final long serialVersionUID = 1L;
    public InvalidTrainException(String message) { super(message); }
}
