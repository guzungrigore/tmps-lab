package Lab4;

import Lab4.Command.DepositCommand;
import Lab4.Command.TransactionCommand;
import Lab4.Command.TransactionInvoker;
import Lab4.Command.WithdrawCommand;
import Lab4.Observer.ObservableCard;
import Lab4.Observer.User;
import Lab4.Strategy.CreditCardWithInterest;
import Lab4.Strategy.InterestCalculationStrategy;
import Lab4.Strategy.SimpleInterestCalculation;

import java.util.Scanner;

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
