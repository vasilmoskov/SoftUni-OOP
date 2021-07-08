package EncapsulationExercises.E03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() < 1 || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        this.setMoney(this.getMoney() - product.getCost());
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" - ");

        if (products.size() == 0) {
            builder.append("Nothing bought");
        } else {
            for (int i = 0; i < products.size(); i++) {

                builder.append(products.get(i).getName());

                if (i < products.size() - 1) {
                    builder.append(", ");
                }
            }
        }

        builder.append(System.lineSeparator());

        return builder.toString().trim();
    }
}
