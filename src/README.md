# Author: Guzun Grigore

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I made a small project that implements the workings of Banking cards



* S -> Single Responsibility:

```
public abstract class Card implements BalanceProvider{
    private final StringBuffer cardNumber = new StringBuffer();
    public Card() {
        Random random = new Random();
        for(int i = 1; i <= 16; i++){
            this.cardNumber.append(random.nextInt(10));
            if(i % 4 == 0 && i != 16) {
                this.cardNumber.append(" ");
            }
        }
        System.out.println("Your new card number is: " + getCardNumber());
    }
    public StringBuffer getCardNumber() {
        return cardNumber;
    }
}
```

* O -> Open Close:

I have made the main class Card that can easily be extended without needing to dig into the inner workings of it

* L -> Liskov Substitution:
```
Card debitCard = new DebitCard();
Card creditCard = new CreditCard(5000, 1.5);
```

* I -> Interface Segregation:
```
interface BalanceProvider {
    double getBalance();
    void deposit(double amount);
    int withdraw(double amount);
}

public interface Transaction {
    void transaction (Card fromCard, Card toCard, double amount);
}

```

* D -> Dependency Inversion:
```
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
```

## Conclusion
To sum up, I made the workings of Banking cards as Debit card where you just deposit money and then use it later, while
Credit card you get an initial sum of money you can use, but you have to pay back more. Also implemented the option to
transfer money from a card to another.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.
