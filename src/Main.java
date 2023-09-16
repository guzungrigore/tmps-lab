import Lab1.Card;
import Lab1.CreditCard;
import Lab1.DebitCard;

public class Main {
    public static void main(String[] args) {

        Card debitCard = new DebitCard();
        Card creditCard = new CreditCard(1000);

        debitCard.deposit(2000);
        System.out.println(debitCard.getBalance());

        debitCard.withdraw(1500);
        System.out.println(debitCard.getBalance());

        debitCard.withdraw(1000);

        creditCard.deposit(500);
        System.out.println(creditCard.getBalance());

        creditCard.withdraw(1000);
        System.out.println(creditCard.getBalance());
    }
}