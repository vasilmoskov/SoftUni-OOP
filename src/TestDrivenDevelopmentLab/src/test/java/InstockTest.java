import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private static final String LABEL = "test_label";
    private static final double PRICE = 9.99;
    private static final int QUANTITY = 1;

    private ProductStock stock;
    private Product defaultProduct;

    @Before
    public void createStock() {
        this.stock = new Instock();
        defaultProduct = new Product(LABEL, PRICE, QUANTITY);
    }

    @Test
    public void testAddProductInStockShouldAddTheProduct() {
        this.stock.add(defaultProduct);

        Assert.assertEquals(1, this.stock.getCount());
        Assert.assertTrue(this.stock.contains(defaultProduct));
    }

    @Test
    public void testAddProductShouldNotAddTheSameProductSecondTime() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);
        Assert.assertEquals(1, stock.getCount());
    }

    @Test
    public void testContainsShouldReturnFalseIfLabelIsDifferent() {
        Assert.assertFalse(stock.contains(defaultProduct));
        this.stock.add(defaultProduct);
        Assert.assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testGetCountShouldReturnStockSize() {

        Assert.assertEquals(0, this.stock.getCount());
        stock.add(defaultProduct);
        Assert.assertEquals(1, this.stock.getCount());
    }

    @Test
    public void testFindShouldReturnTheProductAtTheGivenIndex() {
        stock.add(defaultProduct);

        Product actual = stock.find(0);

        Assert.assertSame(defaultProduct, actual);
    }

    @Test
    public void testFindShouldReturnTheProductWhenItIsBetweenOtherProducts() {
        Product product1 = new Product("label1", 1.99, 2);
        Product product3 = new Product("label2", 2.99, 1);

        stock.add(product1);
        stock.add(defaultProduct);
        stock.add(product3);

        Product actual = stock.find(1);

        Assert.assertSame(defaultProduct, actual);
    }

    @Test
    public void testFindShouldReturnTheProductWhenItIsOnTheLastIndex() {
        Product product1 = new Product("label1", 1.99, 2);
        Product product2 = new Product("label2", 2.99, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(defaultProduct);

        Product actual = stock.find(2);

        Assert.assertSame(defaultProduct, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowIfIndexIsNegative() {
        stock.add(defaultProduct);

        stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowWhenIndexIsBiggerThanStockSize() {
        stock.add(defaultProduct);
        stock.find(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowWhenStockIsEmpty() {
        stock.find(0);
    }

    @Test
    public void testChangeQuantityShouldSetTheGivenQuantityToTheProductWithTheGivenLabel() {
        stock.add(defaultProduct);
        String label = "test_label";

        stock.changeQuantity(label, 5);

        Assert.assertEquals(5, defaultProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowWhenProductWithSuchLabelDoesNotExist() {
        stock.add(defaultProduct);
        String label = "unknown_label";

        stock.changeQuantity(label, 5);
    }

    @Test
    public void testFindByLabelShouldReturnProductWithGivenLabel() {
        String label = "test_label";
        stock.add(defaultProduct);
        Product byLabel = stock.findByLabel(label);

        Assert.assertEquals(defaultProduct.getLabel(), byLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowWhenProductWithSuchLabelDoesNotExist() {
        String label = "unknown_label";
        stock.findByLabel(label);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheFirstElementsSorted() {

        stubProducts();

        Iterable<Product> firstByAlphabeticalOrder = this.stock.findFirstByAlphabeticalOrder(3);
        List<Product> list = createListFromIterable(firstByAlphabeticalOrder);

        Set<String> expectedLabels = list.stream().map(Product::getLabel).collect(Collectors.toCollection(TreeSet::new));

        int index = 0;

        Assert.assertEquals(3, list.size());

        for (String expectedLabel : expectedLabels) {
            Assert.assertEquals(expectedLabel, list.get(index++).getLabel());
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {

        Iterable<Product> firstByAlphabeticalOrder = this.stock.findFirstByAlphabeticalOrder(13);

        List<Product> list = createListFromIterable(firstByAlphabeticalOrder);

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnProductsInThatRange() {
        stubProducts();

        Iterable<Product> allInRange = this.stock.findAllInRange(10, 17);

        List<Product> list = createListFromIterable(allInRange);

        List<Product> filtered = list.stream()
                .filter(p -> p.getPrice() > 10 && p.getPrice() <= 17)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals(5, filtered.size());

        int index = 0;

        for (Product product : allInRange) {
            Assert.assertEquals(product.getLabel(), filtered.get(index++).getLabel());
        }
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionIfThereAreNoProductsInPriceRange() {

        this.stubProducts();

        Iterable<Product> allInRange = this.stock.findAllInRange(35, 50);

        List<Product> list = createListFromIterable(allInRange);

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnsAllProductsWithGivenPrice() {
        this.stubProducts();

        Iterable<Product> allByPrice = this.stock.findAllByPrice(10.00);

        List<Product> list = stubProducts().stream().filter(p -> p.getPrice() == 10.00).collect(Collectors.toList());

        int index = 0;

        for (Product product : allByPrice) {
            Assert.assertEquals(product.getLabel(), list.get(index++).getLabel());
        }
    }

    @Test
    public void testFindAllByPriceReturnsEmptyListWhenNoProductsMatchGivenPrice() {
        this.stubProducts();

        Iterable<Product> allByPrice = this.stock.findAllByPrice(52.17);

        List<Product> list = stubProducts().stream().filter(p -> p.getPrice() == 52.17).collect(Collectors.toList());

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnTheseProducts() {
        stubProducts();

        Iterable<Product> firstMostExpensiveProducts = this.stock.findFirstMostExpensiveProducts(3);

        List<Product> list = stubProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());

        int index = 0;

        for (Product product : firstMostExpensiveProducts) {
            Assert.assertEquals(product.getLabel(), list.get(index++).getLabel());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWhenCountIsLessThanGiven() {
        stubProducts();

        stock.findFirstMostExpensiveProducts(stock.getCount() + 1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnProductsWithSuchQuantity() {
        stubProducts();

        Iterable<Product> allByQuantity = stock.findAllByQuantity(2);

        List<Product> list = createListFromIterable(allByQuantity).stream()
                .filter(p -> p.getQuantity() == 2)
                .collect(Collectors.toList());

        int index = 0;

        Assert.assertEquals(5, list.size());

        for (Product product : allByQuantity) {
            Assert.assertEquals( product.getLabel(), list.get(index++).getLabel());
        }
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoProductsHaveSuchQuantity() {
        stubProducts();

        Iterable<Product> allByQuantity = stock.findAllByQuantity(7);

        List<Product> list = createListFromIterable(allByQuantity).stream()
                .filter(p -> p.getQuantity() == 7)
                .collect(Collectors.toList());

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testGetIterableShouldReturnAllProductsInStock() {
        stubProducts();

        Iterator<Product> iterator = this.stock.iterator();

        List<Product> list = createListFromIterable(stock);

        int index = 0;

        while (iterator.hasNext()) {
            Assert.assertEquals(list.get(index++).getLabel(), iterator.next().getLabel());
        }
    }

    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> stock = new ArrayList<>();
        iterable.forEach(stock::add);
        return stock;
    }

    private List<Product> stubProducts() {
        List<Product> products = Arrays.asList(
                new Product("test_label_1", 12.00, 2),
                new Product("test_label_2", 20.00, 10),
                new Product("test_label_3", 33.00, 10),
                new Product("test_label_4", 15.00, 10),
                new Product("test_label_5", 17.00, 2),
                new Product("test_label_6", 14.99, 2),
                new Product("test_label_7", 10.01, 10),
                new Product("test_label_8", 10.00, 2),
                new Product("test_label_9", 10.00, 10),
                new Product("test_label_10", 10.00, 2)
        );

        for (Product product : products) {
            stock.add(product);
        }

        return products;
    }
}