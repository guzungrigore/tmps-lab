package Lab3.Adapter;

import Lab1.Card;
import Lab1.Transaction;

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
