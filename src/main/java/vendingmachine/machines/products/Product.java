package vendingmachine.machines.products;

import vendingmachine.machines.commons.ProductType;

/**
 * Class representing products
 */
public class Product {
    private String name;
    private int price;
    private ProductType type;

    public Product(String name, int price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }
}
