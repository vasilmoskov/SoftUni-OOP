import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> stock;

    public Instock() {
        this.stock = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.stock.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.stock.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        if (!stock.contains(product)) {
            stock.add(product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        this.stock.stream()
                .filter(p -> p.getLabel().equals(product))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .setQuantity(quantity);

    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= stock.size()) {
            throw new IndexOutOfBoundsException();
        }

        return this.stock.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return this.stock.stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {

        if (count >= stock.size()) {
            return new ArrayList<>();
        }

        return stock.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> list = this.stock.stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return stock.stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (this.stock.size() < count) {
            throw new IllegalArgumentException();
        }

        return this.stock.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return stock.stream().filter(p -> p.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return stock.iterator();
    }
}
