# Topic: *Behavioral Design Patterns*

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation

* Introduction

I decided to implement Command, Strategy, Observer and command design patterns.
I created a java program where my previous base classed of Card Banks implement all this patterns.

* Snippets from your files.

* Command:

```java
public class DepositCommand implements TransactionCommand {
    private final BalanceProvider account;
    private final double amount;

    public DepositCommand(BalanceProvider account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposit executed: " + amount);
    }
}

public class WithdrawCommand implements TransactionCommand {
    private final BalanceProvider account;
    private final double amount;

    public WithdrawCommand(BalanceProvider account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        int result = account.withdraw(amount);
        if (result == 1) {
            System.out.println("Withdraw executed: " + amount);
        } else {
            System.out.println("Withdraw failed. Insufficient balance.");
        }
    }
}
```

* Observer:

```java
public class ObservableCard implements BalanceProvider {
    private final List<BalanceObserver> observers = new ArrayList<>();
    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        notifyObservers();
    }

    @Override
    public int withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            notifyObservers();
            return 1;
        } else {
            return -1;
        }
    }

    // Observer management methods
    public void addObserver(BalanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BalanceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (BalanceObserver observer : observers) {
            observer.updateBalance(balance);
        }
    }
}
```

* Strategy:

```java
public class CreditCardWithInterest extends CreditCard {
    private final InterestCalculationStrategy interestStrategy;

    public CreditCardWithInterest(int initialSum, double rate, InterestCalculationStrategy interestStrategy) {
        super(initialSum, rate);
        this.interestStrategy = interestStrategy;
    }

    public void applyInterest() {
        double interest = interestStrategy.calculateInterest(getBalance());
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}
```


Finally, I just show how they work in the Main class:

```java
public class Main {
    public static void main(String[] args) {
        // Observer Pattern
        ObservableCard observableCard = new ObservableCard();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        observableCard.addObserver(user1);
        observableCard.addObserver(user2);

        // Strategy Pattern
        InterestCalculationStrategy simpleInterestStrategy = new SimpleInterestCalculation(0.05);
        CreditCardWithInterest creditCard = new CreditCardWithInterest(1000, 0.1, simpleInterestStrategy);

        // Command Pattern
        TransactionInvoker transactionInvoker = new TransactionInvoker();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to deposit: ");
        double depositAmount = scanner.nextDouble();

        TransactionCommand depositCommand = new DepositCommand(creditCard, depositAmount);
        transactionInvoker.setCommand(depositCommand);
        transactionInvoker.executeTransaction();

        System.out.println("Credit Card Balance after Deposit: " + creditCard.getBalance());

        System.out.println("Enter the amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();

        TransactionCommand withdrawCommand = new WithdrawCommand(creditCard, withdrawAmount);
        transactionInvoker.setCommand(withdrawCommand);
        transactionInvoker.executeTransaction();

        System.out.println("Credit Card Balance after Withdrawal: " + creditCard.getBalance());

        // Trigger a balance change to notify observers
        observableCard.deposit(200.0);
    }
}
```

## Conclusion
To sum up, I have created a simple code that implement the 3 behavioral design patterns that I have chosen.