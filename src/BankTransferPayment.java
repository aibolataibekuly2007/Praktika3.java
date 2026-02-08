public class BankTransferPayment implements Payment {
    private String accountNumber;

    public BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount +
                " to account: " + accountNumber);
    }
}