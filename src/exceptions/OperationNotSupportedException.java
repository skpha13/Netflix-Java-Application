package exceptions;

public class OperationNotSupportedException extends Exception {
    public OperationNotSupportedException(String errorMessage) {
        super(errorMessage);
    }
}
