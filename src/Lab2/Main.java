package Lab2;

import Lab1.Card;
import Lab1.Transaction;
import Lab2.Builder.CardBuilder;
import Lab2.Builder.CardType;
import Lab2.Factory.Bank;
import Lab2.Factory.CreditBank;
import Lab2.Factory.DebitBank;
import Lab2.Singleton.SingletonTransaction;

public class Main {
    public static void main(String[] args) {
        // Using Singleton for Transaction
        Transaction cardTransaction = SingletonTransaction.getInstance();

        // Using Factory Method for DebitBank
        Bank debitBank = new DebitBank();
        Card debitCardFromDebitBank = debitBank.createCard();
        System.out.println("Debit Card from DebitBank: " + debitCardFromDebitBank.getCardNumber());

        // Using Factory Method for CreditBank
        Bank creditBank = new CreditBank();
        Card creditCardFromCreditBank = creditBank.createCard();
        System.out.println("Credit Card from CreditBank: " + creditCardFromCreditBank.getCardNumber());

        // Using Builder for DebitCard
        CardBuilder debitCardBuilder = new CardBuilder(CardType.DEBIT);
        Card customizedDebitCard = debitCardBuilder
                .setBalance(200.0)
                .build();
        System.out.println("Customized Debit Card Number: " + customizedDebitCard.getCardNumber());
        System.out.println(customizedDebitCard.getBalance());

        // Using Builder for CreditCard
        CardBuilder creditCardBuilder = new CardBuilder(CardType.CREDIT);
        Card customizedCreditCard = creditCardBuilder
                .setBalance(1000.0)
                .build();
        System.out.println("Customized Credit Card Number: " + customizedCreditCard.getCardNumber());
        System.out.println(customizedCreditCard.getBalance());

        // Using Prototype for cloning a card
        try {
            Card clonedCreditCard = (Card) creditCardFromCreditBank.clone();
            System.out.println("Cloned Credit Card Number: " + clonedCreditCard.getCardNumber());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


        // Using Singleton Transaction for a transaction
        double amountToTransfer = 50.0;
        cardTransaction.transaction(debitCardFromDebitBank, creditCardFromCreditBank, amountToTransfer);
    }
}

