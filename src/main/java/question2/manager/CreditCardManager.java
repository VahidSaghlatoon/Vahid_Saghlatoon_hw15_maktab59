package question2.manager;

import question2.dao.CreditCardDao;
import question2.entity.Account;
import question2.entity.CreditCard;
import question2.entity.CreditCardState;
import question2.entity.Transaction;
import question2.exception.CreditCardInvalidException;
import question2.exception.InvalidAmountException;
import question2.exception.NotFoundCreditCard;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class CreditCardManager extends BaseManager<CreditCard, Long> {
    private static int mistakePasswordCount;
    private final Scanner input = new Scanner(System.in);

    public CreditCardManager() {
        setBaseDao(new CreditCardDao());
    }


    //Check card be exist
    public CreditCard existCard(String number) throws NotFoundCreditCard {
        CreditCard creditCard = null;
        try {
            TypedQuery<CreditCard> query = getBaseDao().getEntityManager().createQuery("FROM CreditCard c WHERE c.cardNumber = :number", CreditCard.class);
            query.setParameter("number", number);
            creditCard = query.getSingleResult();
            throw new NotFoundCreditCard();

        } catch (Exception e) {
            return creditCard;
        }

    }

    private boolean checkFirstPassword(CreditCard creditCard, String password) {
        if (creditCard.getFirstPassword().equals(password))
            return true;
        else {
            mistakePasswordCount++;
            if (mistakePasswordCount == 3) {
                mistakePasswordCount = 0;
                creditCard.setState(CreditCardState.LOCK);
                update(creditCard);
            }
            return false;
        }
    }

    public void changeFirstPassword() throws NotFoundCreditCard {
        System.out.println("Enter credit card number : ");
        CreditCard creditCard = existCard(input.next());
        if (creditCard != null) {
            if (creditCard.getState() == CreditCardState.UNLOCK) {
                System.out.print("Enter current password : ");
                if (checkFirstPassword(creditCard, input.next())) {
                    System.out.print("Enter new password : ");
                    creditCard.setFirstPassword(input.next());
                    update(creditCard);
                    System.out.println("Changed password");
                } else System.out.println("Wrong password");
            } else System.out.println("Card is lock");
        } else System.out.println("Wrong card number");
    }

    public void changeSecondPassword() throws NotFoundCreditCard {
        System.out.println("Enter credit card number : ");

        CreditCard creditCard = existCard(input.next());
        if (creditCard != null) {
            if (creditCard.getState() == CreditCardState.UNLOCK) {
                if (creditCard.getSecondPassword() != null) {
                    System.out.print("Enter current password : ");
                    if (creditCard.getSecondPassword().equals(input.next())) {
                        System.out.print("Enter new password : ");
                        creditCard.setSecondPassword(input.next());
                        update(creditCard);
                        System.out.println("Changed password");
                    } else System.out.println("Wrong password");
                } else {
                    System.out.print("Enter second password : ");
                    creditCard.setSecondPassword(input.next());
                    update(creditCard);
                    System.out.println("Set second password");
                }
            } else System.out.println("Card is lock");
        } else System.out.println("Wrong credit card number");
    }

    //Check card number length
    public boolean checkCardNumberLength(String number) throws CreditCardInvalidException {
        if (number.length() != 16)
            throw new CreditCardInvalidException("Credit card numbers are low");
        return true;
    }

    public void moneyTransfer() throws NotFoundCreditCard, InvalidAmountException {
        System.out.print("Enter origin card number : ");
        CreditCard origin = existCard(input.next());
        if (origin != null) {
            if (origin.getState() == CreditCardState.UNLOCK) {
                System.out.print("Enter first password : ");
                if (checkFirstPassword(origin, input.next())) {
                    System.out.print("Enter destination card number : ");
                    CreditCard destination = existCard(input.next());
                    if (destination != null) {
                        System.out.print("Enter amount : ");
                        Long amount = input.nextLong();
                        if (checkAmount(amount)) {
                            System.out.println("Recipient transfer name : " + destination.getAccount().getCustomer().getName());
                            System.out.println("Transfer amount : " + amount);
                            System.out.println("Accept(1)/Reject(0): ");
                            if (input.nextInt() == 1) {
                                System.out.print("Enter second password : ");
                                boolean checkSecondPassword = origin.getSecondPassword().equals(input.next());
                                System.out.print("Enter Cvv2 code : ");
                                boolean checkCvv2 = origin.getCvv2Code().equals(input.next());
                                if (checkSecondPassword && checkCvv2) {
                                    long originBalance = origin.getAccount().getBalance();
                                    if (originBalance > amount) {
                                        Account originAccount = origin.getAccount();
                                        originAccount.setBalance(origin.getAccount().getBalance() - (amount + 600));

                                        Account destinationAccount = destination.getAccount();
                                        destinationAccount.setBalance(destination.getAccount().getBalance() + amount);
                                        Transaction transaction = new Transaction(origin.getCardNumber(), destination.getCardNumber(), amount);

                                        new AccountManager().update(originAccount);
                                        new AccountManager().update(destinationAccount);
                                        new TransactionManager().save(transaction);
                                        System.out.println("Transfer done");

                                    } else System.out.println("Your balance not enough");
                                } else System.out.println("Second password or Cvv2 wrong");
                            } else System.out.println("Transfer rejected");
                        } else System.out.println("amount is wrong");
                    } else System.out.println("destination card number is wrong");
                } else System.out.println("Wrong password");
            } else System.out.println("Card is lock");
        } else System.out.println("origin card number is wrong");
    }

    private Boolean checkAmount(Long amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("invalid amount");
        return true;
    }

    public void unlockCreditCard() throws NotFoundCreditCard {
        System.out.print("Enter card number : ");
        CreditCard creditCard = existCard(input.next());
        if (creditCard != null) {
            if (creditCard.getState() == CreditCardState.LOCK) {
                creditCard.setState(CreditCardState.UNLOCK);
                update(creditCard);
                System.out.println("Card unlocked");
            } else System.out.println("Card is unlock");

        } else System.out.println("Wrong card number");
    }

    public void showTransactionByCardNumber() throws NotFoundCreditCard {
        System.out.print("Enter credit card number : ");
        String cardNUmber = input.next();
        CreditCard creditCard = existCard(cardNUmber);
        if (creditCard != null) {
            if (creditCard.getState() == CreditCardState.UNLOCK) {
                try {
                    Query query = getBaseDao().getEntityManager().createQuery("FROM Transaction t WHERE t.origin =:number");
                    Query query1 = getBaseDao().getEntityManager().createQuery("FROM Transaction t WHERE t.destination =:number");
                    query.setParameter("number", cardNUmber);
                    query1.setParameter("number", cardNUmber);
                    List<Transaction> resultList = query.getResultList();
                    List<Transaction> resultList1 = query1.getResultList();
                    resultList.forEach(transaction -> System.out.println(transaction.toString()));
                    resultList1.forEach(transaction -> System.out.println(transaction.toString()));

                } catch (Exception e) {
                    System.out.println("Not found any transaction");
                }
            } else System.out.println("Card is lock");
        } else System.out.println("Wrong card number");
    }

}



