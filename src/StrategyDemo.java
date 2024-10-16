// PaymentStrategy Interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete Strategies

class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Credit card payment processing logic
    }
}

class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // PayPal payment processing logic
    }
}

class CryptoPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount);
        // Cryptocurrency payment processing logic
    }
}

// PaymentContext Class

class PaymentContext {
    private PaymentStrategy strategy;

    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void executePayment(double amount) {
        if (strategy != null) {
            strategy.processPayment(amount);
        } else {
            System.out.println("Payment strategy has not been set.");
        }
    }
}

// Strategy Demo Class

public class StrategyDemo {
    public static void main(String[] args) {
        double purchaseAmount = 100.0;

        PaymentContext paymentContext = new PaymentContext();

        // Payment using credit card
        paymentContext.setStrategy(new CreditCardPaymentStrategy());
        paymentContext.executePayment(purchaseAmount);

        // Payment using PayPal
        paymentContext.setStrategy(new PayPalPaymentStrategy());
        paymentContext.executePayment(purchaseAmount);

        // Payment using cryptocurrency
        paymentContext.setStrategy(new CryptoPaymentStrategy());
        paymentContext.executePayment(purchaseAmount);
    }
}
