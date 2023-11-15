package Lab4.Command;

public class TransactionInvoker {
    private TransactionCommand command;

    public void setCommand(TransactionCommand command) {
        this.command = command;
    }

    public void executeTransaction() {
        command.execute();
    }
}