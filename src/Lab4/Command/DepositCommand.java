package Lab4.Command;

import Lab1.BalanceProvider;

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

