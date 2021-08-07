import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {

    private ChainblockImpl chainblock;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private Transaction transaction5;
    private Transaction transaction6;
    private Transaction transaction7;


    @Before
    public void createChainBlock() {
        this.chainblock = new ChainblockImpl();

        this.transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vasil", "Todor", 9.99);
        this.transaction2 = new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Angel", "Niki", 5.99);
        this.transaction3 = new TransactionImpl(3, TransactionStatus.FAILED, "Sasho", "Emo", 6.99);

        chainblock.add(transaction1);
        chainblock.add(transaction2);
        chainblock.add(transaction3);
    }

    @Test
    public void testAddShouldReturnCountOfAddedTransactions() {
        int count = this.chainblock.getCount();

        Assert.assertEquals(3, count);
    }

    @Test
    public void testContainsTransactionShouldReturnTrueWhenTransactionIsInChainblock() {
        Assert.assertTrue(chainblock.contains(transaction1));
    }

    @Test
    public void testContainsTransactionShouldReturnFalseWhenTransactionIsNotInChainblock() {
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.FAILED, "Miro", "Petar", 0.55);
        Assert.assertFalse(chainblock.contains(transaction4));
    }

    @Test
    public void testContainsIdShouldReturnTrueWhenTransactionIsInChainblock() {
        Assert.assertTrue(chainblock.contains(1));
    }

    @Test
    public void testContainsIdShouldReturnFalseWhenTransactionIsNotInChainblock() {
        Assert.assertFalse(chainblock.contains(4));
    }

    @Test
    public void testChangeTransactionStatusShouldDoSo() {
        Transaction transaction = this.chainblock.getById(1);

        Assert.assertEquals(TransactionStatus.SUCCESSFUL, transaction.getTransactionStatus());

        this.chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);

        Assert.assertEquals(TransactionStatus.ABORTED, transaction.getTransactionStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowWhenIdIsInvalid() {
        this.chainblock.changeTransactionStatus(5, TransactionStatus.FAILED);
    }

    @Test
    public void testGetByIdReturnsTransactionWithGivenId() {
        Transaction transaction = this.chainblock.getById(2);
        Assert.assertEquals(transaction2, transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowsWhenTransactionWithGivenIdDoesNotExist() {
        Transaction transaction = this.chainblock.getById(4);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveTheTransactionFromTheRecord() {
        Assert.assertEquals(3, this.chainblock.getCount());
        Assert.assertTrue(this.chainblock.contains(3));

        this.chainblock.removeTransactionById(2);

        Assert.assertEquals(2, this.chainblock.getCount());
        Assert.assertFalse(this.chainblock.contains(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowWhenIdIsInvalid() {
        this.chainblock.removeTransactionById(5);
    }

    @Test
    public void testGetByTransactionStatusReturnsTheTransactionsWithTheGivenStatusOrderedByAmountDescending() {

        addMoreTransactionsToChainBlock();

        List<Transaction> list = getListWithTransactions();
        List<Transaction> expected = list.stream()
                .filter(tr -> tr.getTransactionStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        Assert.assertEquals(expected.size(), actual.size());
        actual.forEach(tr -> Assert.assertEquals(tr.getTransactionStatus(), TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowWhenThereAreNoTransactionsWithTheGivenStatus() {
        Iterable<Transaction> iterable = this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnsAllSendersWithGivenStatusOrderedByTransactionsAmount() {

        addMoreTransactionsToChainBlock();

        Iterable<String> iterable = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        List<String> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> list = getListWithTransactions();
        List<String> expected = list.stream()
                .filter(tr -> tr.getTransactionStatus().equals(TransactionStatus.FAILED))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowWhenNoTransactionsExist() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithGivenTransactionStatus() {
        addMoreTransactionsToChainBlock();

        Iterable<String> iterable = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<String> expected = getListWithTransactions().stream()
                .filter(tr -> tr.getTransactionStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithGivenTransactionStatusShouldThrowWhenThatTransactionStatusIsNotPresent() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnCorrectTransactions() {

        addMoreTransactionsToChainBlock();

        Iterable<Transaction> iterable = this.chainblock.getAllOrderedByAmountDescendingThenById();
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> expected = getListWithTransactions().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        int index = 0;

        for (Transaction transaction : actual) {
            Assert.assertEquals(transaction.getAmount(), expected.get(index).getAmount(), 0.00);
            Assert.assertEquals(transaction.getId(), expected.get(index).getId());
            index++;
        }
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnCorrectTransactions() {
        addMoreTransactionsToChainBlock();

        Transaction transaction = new TransactionImpl(8, TransactionStatus.UNAUTHORIZED, "Vasil", "Niki", 129.99);
        this.chainblock.add(transaction);

        Iterable<Transaction> iterable = this.chainblock.getBySenderOrderedByAmountDescending("Vasil");
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> list = getListWithTransactions();
        list.add(transaction);

        List<Transaction> expected = list.stream()
                .filter(tr -> tr.getFrom().equals("Vasil"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowWhenNoSuchSender() {
        this.chainblock.getBySenderOrderedByAmountDescending("Zhivko");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        //ShouldReturnAllTransactionsOrderedByAmountDescendingThenByIdAscending() {
        addMoreTransactionsToChainBlock();

        Transaction transaction = new TransactionImpl(8, TransactionStatus.UNAUTHORIZED, "Vasil", "Niki", 129.99);
        this.chainblock.add(transaction);

        Iterable<Transaction> iterable = this.chainblock.getByReceiverOrderedByAmountThenById("Niki");
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> list = getListWithTransactions();
        list.add(transaction);

        List<Transaction> expected = list.stream()
                .filter(tr -> tr.getTo().equals("Niki"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowWhenThereIsNoSuchReceiver() {
        this.chainblock.getByReceiverOrderedByAmountThenById("Zdravko");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount() {
        //ShouldReturnTransactionsWithGivenStatusAndAmountLessOrEqualToMaximumAllowedAmountOrderedByAmountDescending

        addMoreTransactionsToChainBlock();
        Iterable<Transaction> iterable = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 9.00);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> expected = getListWithTransactions().stream()
                .filter(tr -> tr.getTransactionStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(tr -> tr.getAmount() <= 9.00)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionWhenNoSuchTransaction() {
        addMoreTransactionsToChainBlock();
        Iterable<Transaction> iterable = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 10.00);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionWhenNoTransactionsInAmountRange() {
        addMoreTransactionsToChainBlock();
        Iterable<Transaction> iterable = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 0.10);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending() {
        //ShouldReturnTransactionsWithGivenSenderAndAmountBiggerThanGivenAmountOrderedByAmountDescending
        addMoreTransactionsToChainBlock();
        Transaction transaction = new TransactionImpl(8, TransactionStatus.UNAUTHORIZED, "Vasil", "Niki", 129.99);
        this.chainblock.add(transaction);

        Iterable<Transaction> iterable = this.chainblock.getBySenderAndMinimumAmountDescending("Vasil", 9.99);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> list = getListWithTransactions();
        list.add(transaction);

        List<Transaction> expected = list.stream()
                .filter(tr -> tr.getFrom().equals("Vasil"))
                .filter(tr -> tr.getAmount() > 9.99)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowIfNoSuchSender() {
        this.chainblock.getBySenderAndMinimumAmountDescending("Slavko", 5.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowWhenNoTransactionsAboveGivenAmount() {
        this.chainblock.getBySenderAndMinimumAmountDescending("Vasil", 500.00);
    }

    @Test
    public void testGetByReceiverAndAmountRange() {
        //should return all transactions with given receiver and amount between lo (inclusive) and hi (exclusive)
        //ordered by amount descending then by id

        Transaction transaction8 = new TransactionImpl(8, TransactionStatus.SUCCESSFUL, "Kalin", "Niki", 15.99);
        Transaction transaction9 = new TransactionImpl(9, TransactionStatus.SUCCESSFUL, "Kuncho", "Niki", 18.99);
        Transaction transaction10 = new TransactionImpl(10, TransactionStatus.SUCCESSFUL, "Stoyan", "Niki", 17.99);
        Transaction transaction11 = new TransactionImpl(11, TransactionStatus.SUCCESSFUL, "Marin", "Niki", 19.99);

        addMoreTransactionsToChainBlock();
        this.chainblock.add(transaction8);
        this.chainblock.add(transaction9);
        this.chainblock.add(transaction10);
        this.chainblock.add(transaction11);

        Iterable<Transaction> iterable = this.chainblock.getByReceiverAndAmountRange("Niki", 15.99, 19.99);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> list = getListWithTransactions();
        list.add(transaction8);
        list.add(transaction9);
        list.add(transaction10);
        list.add(transaction11);

        List<Transaction> expected = list.stream().filter(tr -> tr.getTo().equals("Niki"))
                .filter(tr -> tr.getAmount() >= 15.99 && tr.getAmount() < 19.99)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowWhenTransactionsAreOutOfRange() {

        Transaction transaction8 = new TransactionImpl(8, TransactionStatus.SUCCESSFUL, "Kalin", "Niki", 15.99);
        Transaction transaction9 = new TransactionImpl(9, TransactionStatus.SUCCESSFUL, "Kuncho", "Niki", 18.99);
        Transaction transaction10 = new TransactionImpl(10, TransactionStatus.SUCCESSFUL, "Stoyan", "Niki", 17.99);
        Transaction transaction11 = new TransactionImpl(11, TransactionStatus.SUCCESSFUL, "Marin", "Niki", 19.99);

        addMoreTransactionsToChainBlock();
        this.chainblock.add(transaction8);
        this.chainblock.add(transaction9);
        this.chainblock.add(transaction10);
        this.chainblock.add(transaction11);

        Iterable<Transaction> iterable = this.chainblock.getByReceiverAndAmountRange("Niki", 10.00, 15.99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowWhenThereIsNoSuchReceiver() {

        Transaction transaction8 = new TransactionImpl(8, TransactionStatus.SUCCESSFUL, "Kalin", "Niki", 15.99);

        addMoreTransactionsToChainBlock();
        this.chainblock.add(transaction8);

        Iterable<Transaction> iterable = this.chainblock.getByReceiverAndAmountRange("Blagoy", 15.99, 21.99);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnTransactionsInRangeInclusive() {
        addMoreTransactionsToChainBlock();

        Iterable<Transaction> iterable = this.chainblock.getAllInAmountRange(6.99, 9.99);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        List<Transaction> expected = getListWithTransactions().stream()
                .filter(tr -> tr.getAmount() >= 6.99 && tr.getAmount() <= 9.99)
                .collect(Collectors.toList());

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyListWhenNoTransactionsAreInRange() {
        addMoreTransactionsToChainBlock();

        Iterable<Transaction> iterable = this.chainblock.getAllInAmountRange(1116.99, 1119.99);
        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testIterator(){
        Iterator<Transaction> iterator = this.chainblock.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(transaction1, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(transaction2, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(transaction3, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    private List<Transaction> getListWithTransactions() {
        List<Transaction> list = new ArrayList<>();

        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);
        list.add(transaction5);
        list.add(transaction6);
        list.add(transaction7);

        return list;
    }

    private void addMoreTransactionsToChainBlock() {
        this.transaction4 = new TransactionImpl(4, TransactionStatus.FAILED, "Qsen", "Krasen", 7.00);
        this.transaction5 = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "Ivan", "Nikola", 1.00);
        this.transaction6 = new TransactionImpl(6, TransactionStatus.FAILED, "Georgi", "Ceco", 3.00);
        this.transaction7 = new TransactionImpl(7, TransactionStatus.SUCCESSFUL, "Tanyo", "Boris", 9.00);

        this.chainblock.add(transaction4);
        this.chainblock.add(transaction5);
        this.chainblock.add(transaction6);
        this.chainblock.add(transaction7);
    }


}