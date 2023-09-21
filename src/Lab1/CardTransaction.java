package Lab1;

public class CardTransaction implements Transaction{
    public CardTransaction() {
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        if(fromCard.withdraw(amount) == 1) {
            toCard.deposit(amount);
            System.out.println("Transaction successful");
        } else {
            System.out.println("Transaction failed");
        }
    }


}
