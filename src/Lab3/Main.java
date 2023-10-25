package Lab3;

import Lab1.*;
import Lab3.Adapter.NewPaymentService;
import Lab3.Adapter.NewPaymentServiceImpl;
import Lab3.Adapter.PaymentServiceAdapter;
import Lab3.Composite.CardGroup;
import Lab3.Composite.CompositeCardGroup;
import Lab3.Decorator.LoggingTransactionDecorator;
import Lab3.Proxy.CardProxy;

public class Main {
    public static void main(String[] args) {
        // Adapter Pattern
        NewPaymentService newPaymentService = new NewPaymentServiceImpl();
        Transaction adaptedTransaction = new PaymentServiceAdapter(newPaymentService);

        // Decorator Pattern
        Transaction decoratedTransaction = new LoggingTransactionDecorator(new CardTransaction());

        // Composite Pattern
        Card debitCard = new DebitCard();
        Card creditCard = new CreditCard(1000, 0.1);

        CardGroup cardGroup = new CompositeCardGroup();
        cardGroup.addCard(debitCard);
        cardGroup.addCard(creditCard);

        // Proxy Pattern
        Card realCard = new DebitCard();
        CardProxy cardProxy = new CardProxy(realCard, "securePassword");

        System.out.println(" ");

        // Example usage
        adaptedTransaction.transaction(debitCard, creditCard, 50.0);

        decoratedTransaction.transaction(debitCard, creditCard, 100.0);

        System.out.println(" ");

        System.out.println("Total Balance in the Card Group: " + cardGroup.getBalance());

        cardProxy.deposit(200.0);
        System.out.println("Balance after deposit: " + cardProxy.getBalance());

        try {
            cardProxy.withdraw(50.0);
            System.out.println("Balance after withdrawal: " + cardProxy.getBalance());
        } catch (SecurityException e) {
            System.out.println("Authentication failed. " + e.getMessage());
        }
    }
}
