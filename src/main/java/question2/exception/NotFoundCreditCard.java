package question2.exception;

public class NotFoundCreditCard extends Exception {

    public NotFoundCreditCard() {
    super("Dont have any credit card with this number");
    }
}
