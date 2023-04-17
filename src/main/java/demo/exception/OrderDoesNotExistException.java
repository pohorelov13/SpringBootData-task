package demo.exception;

public class OrderDoesNotExistException extends Exception{
    public OrderDoesNotExistException(String message) {
        super(message);
    }
}
