package Lab3.Adapter;

public class NewPaymentServiceImpl implements NewPaymentService{
    @Override
    public void makePayment(String senderAccount, String receiverAccount, double amount) {
        // Simulate making a payment using the new payment service
        System.out.println("Making payment from " + senderAccount + " to " + receiverAccount + " with amount " + amount);
    }
}
