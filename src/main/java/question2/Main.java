package question2;

import question2.exception.CreditCardInvalidException;
import question2.exception.InvalidAmountException;
import question2.exception.NotFoundCreditCard;
import question2.manager.BankManager;
import question2.service.Menu;

public class Main {
    public static void main(String[] args) throws CreditCardInvalidException, InvalidAmountException, NotFoundCreditCard {

//        new BankManager().addBank();
//        new BankManager().deleteBank();
        new Menu().start();
    }

}
