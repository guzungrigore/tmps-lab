package Lab4.Observer;

// Concrete Observer
public class User implements BalanceObserver {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void updateBalance(double newBalance) {
        System.out.println("User " + username + ": Updated balance - " + newBalance);
    }
}
