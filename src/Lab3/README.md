# Topic: *Structural Design Patterns*

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

---

## Implementation

#### Introduction

I decided to implement Adapter, Composite, Decorator and Proxy design patterns.
I created a java program where my previous base classed of Card Banks implement all this patterns.


#### Snippets from your files:

* Adapter:

```java
public interface NewPaymentService {
    void makePayment(String senderAccount, String receiverAccount, double amount);
}

public class PaymentServiceAdapter implements Transaction {
    private final NewPaymentService newPaymentService;

    public PaymentServiceAdapter(NewPaymentService newPaymentService) {
        this.newPaymentService = newPaymentService;
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        String senderAccount = fromCard.getCardNumber().toString();
        String receiverAccount = toCard.getCardNumber().toString();

        newPaymentService.makePayment(senderAccount, receiverAccount, amount);
    }
}
```

* Composite:

```java
public interface CardGroup extends BalanceProvider {
    void addCard(Card card);
    void removeCard(Card card);
}

public class CompositeCardGroup implements CardGroup {
    private List<Card> cards = new ArrayList<>();

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public void removeCard(Card card) {
        cards.remove(card);
    }

    @Override
    public double getBalance() {
        double totalBalance = 0;
        for (Card card : cards) {
            totalBalance += card.getBalance();
        }
        return totalBalance;
    }
}
```

* Decorator:

```java
public class LoggingTransactionDecorator implements Transaction {
    private Transaction transaction;

    public LoggingTransactionDecorator(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        System.out.println("Logging: Transaction started");
        transaction.transaction(fromCard, toCard, amount);
        System.out.println("Logging: Transaction completed");
    }
}
```

* Proxy:

```java
public class CardProxy implements BalanceProvider {
    private final Card card;
    private final String password;

    public CardProxy(Card card, String password) {
        this.card = card;
        this.password = password;
    }

    private void authenticate(String enteredPassword) {
        if (!enteredPassword.equals(password)) {
            throw new SecurityException("Authentication failed. Incorrect password.");
        }
    }

    @Override
    public double getBalance() {
        authenticateUser();
        return card.getBalance();
    }

    @Override
    public void deposit(double amount) {
        authenticateUser();
        card.deposit(amount);
    }

    @Override
    public int withdraw(double amount) {
        authenticateUser();
        return card.withdraw(amount);
    }

    private void authenticateUser() {
        System.out.print("Enter your password: ");
        Scanner scanner = new Scanner(System.in);
        String enteredPassword = scanner.nextLine();
        authenticate(enteredPassword);
    }
}
```

Finally, in the Main class from Package "Lab3" is shown how everything works

## Conclusion
To sum up, I have created a simple code that implements some structural design patterns of my choosing.
In my code I managed to fit somehow 4 structural design patterns. Moreover, I managed not only to create and use them,
but also to interconnect them. That's why I think I have understood the structural design patterns main purpose.