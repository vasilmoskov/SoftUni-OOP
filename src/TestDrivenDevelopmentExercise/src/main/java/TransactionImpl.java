public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TransactionStatus getTransactionStatus() {
        return status;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }
}
