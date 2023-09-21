import Lab1.*;

public class Main {
    public static void main(String[] args) {

        Card debitCard = new DebitCard();

        debitCard.deposit(2000);
        System.out.println(debitCard.getBalance());

        debitCard.withdraw(1500);
        System.out.println(debitCard.getBalance());

        debitCard.withdraw(1000);


        Card creditCard = new CreditCard(5000, 1.5);

        creditCard.deposit(500);
        System.out.println(creditCard.getBalance());

        Transaction transaction = new CardTransaction();
        transaction.transaction(creditCard, debitCard, 1000);

        System.out.println(creditCard.getBalance());
    }
}