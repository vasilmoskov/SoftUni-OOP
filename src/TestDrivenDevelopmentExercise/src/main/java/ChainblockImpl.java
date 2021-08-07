import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private List<Transaction> chainblock;

    public ChainblockImpl() {
        this.chainblock = new ArrayList<>();
    }

    public int getCount() {
        return this.chainblock.size();
    }

    public void add(Transaction transaction) {
        this.chainblock.add(transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.chainblock.contains(transaction);
    }

    public boolean contains(int id) {
        for (Transaction transaction : chainblock) {
            if (transaction.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {

        boolean transactionStatusChanged = false;

        for (Transaction transaction : chainblock) {
            if (transaction.getId() == id) {
                transaction.setStatus(newStatus);
                transactionStatusChanged = true;
                break;
            }
        }

        if (!transactionStatusChanged) {
            throw new IllegalArgumentException();
        }
    }

    public void removeTransactionById(int id) {
        Transaction transactionToRemove = null;
        int idToRemove = -1;

        for (int i = 0; i < chainblock.size(); i++) {
            Transaction transaction = chainblock.get(i);

            if (transaction.getId() == id) {
                transactionToRemove = transaction;
                idToRemove = id;
                break;
            }
        }

        if (transactionToRemove == null) {
            throw new IllegalArgumentException();
        }

        this.chainblock.remove(idToRemove);
    }

    public Transaction getById(int id) {
        for (Transaction transaction : chainblock) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }

        throw new IllegalArgumentException();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> list = this.chainblock.stream()
                .filter(tr -> tr.getTransactionStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> list = this.chainblock.stream()
                .filter(tr -> tr.getTransactionStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> list = this.chainblock.stream()
                .filter(tr -> tr.getTransactionStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.chainblock.stream()
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                        .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> list = this.chainblock.stream().filter(tr -> tr.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> list = this.chainblock.stream()
                .filter(tr -> tr.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.chainblock.stream()
                .filter(tr -> tr.getTransactionStatus().equals(status))
                .filter(tr -> tr.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> list = this.chainblock.stream()
                .filter(tr -> tr.getFrom().equals(sender))
                .filter(tr -> tr.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> list = this.chainblock.stream().filter(tr -> tr.getTo().equals(receiver)
                && tr.getAmount() >= lo && tr.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.chainblock.stream()
                .filter(tr -> tr.getAmount() >= lo && tr.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return new Iterator<Transaction>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < chainblock.size();
            }

            @Override
            public Transaction next() {
                return chainblock.get(index++);
            }
        };

    }
}
