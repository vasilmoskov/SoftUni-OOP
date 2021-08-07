public interface Transaction {

    int getId();

    TransactionStatus getTransactionStatus();

    void setStatus(TransactionStatus status);

    double getAmount();

    String getFrom();

    String getTo();
}
