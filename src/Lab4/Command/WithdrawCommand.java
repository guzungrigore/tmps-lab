package Lab4.Command;

import Lab1.BalanceProvider;

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
