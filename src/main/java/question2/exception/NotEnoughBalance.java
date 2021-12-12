package question2.exception;

public class NotEnoughBalance extends Exception {
    public NotEnoughBalance() {
        super("Money in car dont enough");
    }
}
