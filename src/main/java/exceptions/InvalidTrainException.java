package exceptions;

/** Raised when a requested train number does not exist. */
public class InvalidTrainException extends Exception {
    public InvalidTrainException(String message) { super(message); }
}
